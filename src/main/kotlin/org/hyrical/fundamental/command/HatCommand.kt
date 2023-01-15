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

object HatCommand : BaseCommand() {

    @CommandAlias("hat")
    @CommandPermission("fundamental.more")
    fun hat(player: Player){
        if (player.itemInHand.type == Material.AIR) return player.sendMessage(CC.translate("&cYou are not holding an item."))

        player.inventory.helmet = player.itemInHand
    }
}