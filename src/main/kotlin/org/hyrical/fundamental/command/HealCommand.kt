package org.hyrical.fundamental.command

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Optional
import org.bukkit.entity.Player
import org.hyrical.fundamental.utility.CC

object HealCommand : BaseCommand() {

    @CommandAlias("heal")
    @CommandPermission("fundamental.heal")
    fun heal(playerInput: Player, @Optional target: Player?){
        val player = target ?: playerInput

        player.health = player.maxHealth
        player.foodLevel = 10
        player.fireTicks = 0

        if (target == null){
            playerInput.sendMessage(CC.translate("&6You have been healed."))
        } else {
            playerInput.sendMessage(CC.translate("&6You have healed &f${player.displayName}&6."))
        }
    }
}