package org.hyrical.fundamental.command

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Name
import co.aikar.commands.annotation.Optional
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.hyrical.fundamental.utility.CC

object MoreCommand : BaseCommand() {

    @CommandAlias("more")
    @CommandPermission("fundamental.more")
    fun more(player: Player){

        if (player.itemInHand.type == Material.AIR) return player.sendMessage(CC.translate("&cYou are not holding an item."))

        val item = player.itemInHand
        item.amount = item.maxStackSize

        player.sendMessage(CC.translate("&6There you go."))
    }
}