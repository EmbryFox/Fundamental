package org.hyrical.fundamental.command

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Name
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.hyrical.fundamental.utility.CC

object SudoCommands : BaseCommand() {

    @CommandAlias("sudo")
    @CommandPermission("fundamental.sudo")
    fun sudo(player: Player, @Name("player") target: Player, @Name("message") message: String){
        target.chat(CC.translate(message))

        player.sendMessage(CC.translate("&6Forced ${target.displayName} &6to say &f${message}&6."))
    }

    @CommandAlias("sudoall")
    @CommandPermission("fundamental.sudo.all")
    fun sudoAll(player: Player, @Name("message") message: String){
        for (target in Bukkit.getOnlinePlayers()){
            target.chat(message)
        }

        player.sendMessage(CC.translate("&6Forced everyone to say &f${message}&6."))
    }
}