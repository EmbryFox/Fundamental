package org.hyrical.fundamental.command

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Optional
import org.bukkit.entity.Player
import org.hyrical.fundamental.utility.CC

object FeedCommand : BaseCommand() {

    @CommandAlias("feed")
    @CommandPermission("fundamental.feed")
    fun feeed(playerInput: Player, @Optional target: Player?){
        val player = target ?: playerInput

        player.foodLevel = 20

        if (target == null){
            playerInput.sendMessage(CC.translate("&6You have been fe.d"))
        } else {
            playerInput.sendMessage(CC.translate("&6You have fed &f${player.displayName}&6."))
        }
    }
}