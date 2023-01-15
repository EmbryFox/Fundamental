package org.hyrical.fundamental.utility

import org.apache.commons.io.IOUtils
import org.bukkit.Material
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack
import org.bukkit.inventory.ItemStack
import org.hyrical.fundamental.Fundamental
import java.beans.ConstructorProperties
import java.io.IOException
import java.util.*


object ItemUtils {

    private val NAME_MAP: MutableMap<String, ItemData> = HashMap()

    fun repeat(material: Material?, times: Int): Array<ItemData?>? {
        return repeat(material, 0.toByte(), times)
    }

    fun repeat(material: Material?, data: Byte, times: Int): Array<ItemData?>? {
        val itemData = arrayOfNulls<ItemData>(times)
        for (i in 0 until times) itemData[i] = ItemData(material, data.toShort())
        return itemData
    }

    fun armorOf(part: ArmorPart): Array<ItemData>? {
        val data: MutableList<ItemData> = ArrayList()
        for (at in ArmorType.values()) data.add(
            ItemData(
                Material.valueOf(at.name + "_" + part.name),
                0.toShort()
            )
        )
        return data.toTypedArray()
    }

    fun swords(): Array<ItemData>? {
        val data: MutableList<ItemData> = ArrayList()
        for (at in SwordType.values()) data.add(
            ItemData(
                Material.valueOf(at.name + "_SWORD"),
                0.toShort()
            )
        )
        return data.toTypedArray()
    }

    fun load() {
        NAME_MAP.clear()
        val lines = readLines()
        for (line in lines!!) {
            val parts = line.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            NAME_MAP[parts[0]] = ItemData(Material.getMaterial(parts[1].toInt()), parts[2].toShort())
        }
    }

    operator fun get(input: String, amount: Int): ItemStack? {
        val item = get(input)
        if (item != null) item.amount = amount
        return item
    }

    operator fun get(input: String): ItemStack? {
        if (NumberUtils.isInteger(input)) return ItemStack(Material.getMaterial(input.toInt())!!)
        if (input.contains(":")) {
            if (NumberUtils.isShort(input.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1])) {
                if (NumberUtils.isInteger(input.split(":".toRegex()).dropLastWhile { it.isEmpty() }
                        .toTypedArray()[0])) return ItemStack(
                    Material.getMaterial(input.split(":".toRegex()).dropLastWhile { it.isEmpty() }
                        .toTypedArray()[0].toInt())!!, 1, input.split(":".toRegex()).dropLastWhile { it.isEmpty() }
                        .toTypedArray()[1].toShort())
                if (!NAME_MAP.containsKey(input.split(":".toRegex()).dropLastWhile { it.isEmpty() }
                        .toTypedArray()[0].lowercase(Locale.getDefault()))) return null
                val data =
                    NAME_MAP[input.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0].lowercase(
                        Locale.getDefault()
                    )]
                return ItemStack(
                    data!!.material!!,
                    1,
                    input.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1].toShort()
                )
            }
            return null
        }
        return if (!NAME_MAP.containsKey(input)) null else NAME_MAP[input]!!.toItemStack()
    }

    fun getName(item: ItemStack): String {
        if (item.durability.toInt() != 0) {
            val nmsStack: net.minecraft.server.v1_12_R1.ItemStack? = CraftItemStack.asNMSCopy(item)

            if (nmsStack != null) {
                var name: String = nmsStack.name
                if (name.contains(".")) name = (name.lowercase()).capitalize()

                return name
            }
        }
        val string = item.type.toString().replace("_", " ")
        val chars = string.lowercase(Locale.getDefault()).toCharArray()
        var found = false
        for (i in chars.indices) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = chars[i].uppercaseChar()
                found = true
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') {
                found = false
            }
        }
        return String(chars)
    }

    private fun readLines(): List<String>? {
        return try {
            IOUtils.readLines(Fundamental::class.java.classLoader.getResourceAsStream("items.csv"))
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    class ItemData @ConstructorProperties("material", "data") constructor(val material: Material?, val data: Short) {

        val name: String
            get() = getName(toItemStack())

        fun matches(item: ItemStack?): Boolean {
            return item != null && item.type == material && item.durability == data
        }

        fun toItemStack(): ItemStack {
            return ItemStack(material!!, 1, data)
        }
    }

    enum class ArmorPart {
        HELMET, CHESTPLATE, LEGGINGS, BOOTS
    }

    enum class ArmorType {
        DIAMOND, IRON, GOLD, LEATHER
    }

    enum class SwordType {
        DIAMOND, IRON, GOLD, STONE
    }
}