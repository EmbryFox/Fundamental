package org.hyrical.fundamental.command

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Default
import co.aikar.commands.annotation.Name
import co.aikar.commands.annotation.Optional
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.hyrical.fundamental.utility.CC
import org.hyrical.fundamental.utility.ItemUtils

object GiveCommand : BaseCommand() {

    @CommandAlias("give")
    @CommandPermission("fundamental.give")
    fun give(playerInput: Player, @Name("item") item: ItemStack, @Optional @Default("1") amountString: String, @Optional target: Player?){
        val player = target ?: playerInput
        val amount = Integer.parseInt(amountString)

        if (amount < 1){
            player.sendMessage(CC.translate("&cThe amount must be greater than 0."))
            return
        }

        if (!player.hasPermission("fundamental.give.others") && player == target){
            player.sendMessage(CC.translate("&cYou cannot give items to other players."))
            return
        }

        item.amount = amount
        player.inventory.addItem(item)

        player.sendMessage(CC.translate("&6Giving ${if (player != target) "yourself" else player.displayName} &f${amount} &6of &f${ItemUtils.getName(ItemStack(item.type))}&6."))
    }
}