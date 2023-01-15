package org.hyrical.fundamental.command.context

import co.aikar.commands.BukkitCommandExecutionContext
import co.aikar.commands.InvalidCommandArgument
import co.aikar.commands.contexts.ContextResolver
import org.bukkit.inventory.ItemStack
import org.hyrical.fundamental.utility.ItemUtils

class ItemStackContext : ContextResolver<ItemStack, BukkitCommandExecutionContext> {
    override fun getContext(c: BukkitCommandExecutionContext?): ItemStack? {
        return ItemUtils[c!!.popFirstArg()]
            ?: throw InvalidCommandArgument("No item with the name ${c!!.popFirstArg()}")
    }


}