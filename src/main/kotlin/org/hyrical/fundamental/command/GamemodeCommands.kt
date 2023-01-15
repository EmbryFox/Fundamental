package org.hyrical.fundamental.command

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Name
import co.aikar.commands.annotation.Optional
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.util.StringUtil
import org.hyrical.fundamental.utility.CC

object GamemodeCommands : BaseCommand() {

    @CommandAlias("gmc")
    @CommandPermission("fundamental.gamemode")
    fun gmc(player: Player, @Optional target: Player?){
        this.gm(player, GameMode.CREATIVE, target ?: player)
    }

    @CommandAlias("gma")
    @CommandPermission("fundamental.gamemode")
    fun gma(player: Player, @Optional target: Player?){
        this.gm(player, GameMode.ADVENTURE, target ?: player)
    }

    @CommandAlias("gmsp")
    @CommandPermission("fundamental.gamemode")
    fun gmsp(player: Player, @Optional target: Player?){
        this.gm(player, GameMode.SPECTATOR, target ?: player)
    }

    @CommandAlias("gms")
    @CommandPermission("fundamental.gamemode")
    fun gms(player: Player, @Optional target: Player?){
        this.gm(player, GameMode.SURVIVAL, target ?: player)
    }

    @CommandAlias("gm|gamemode")
    @CommandPermission("fundamental.gamemode")
    fun gm(player: Player, @Name("gamemode") gameMode: GameMode, @Optional target: Player?){
        if (target != null && target != player){
            if (!player.hasPermission("fundamental.gamemode.other")) return player.sendMessage(CC.translate("&cYou don't have permission to change other player's gamemodes."))

            target.gameMode = gameMode

            player.sendMessage(CC.translate("&6You have set &r${target.displayName}&6's gamemode to &f${gameMode.name}&6."))
            target.sendMessage(CC.translate("&6Your gamemode has been updated to &f${gameMode.name}&6."))
        } else {
            player.gameMode = gameMode

            player.sendMessage(CC.translate("&6Your gamemode has been updated to &f${gameMode.name}&6."))
        }
    }
}