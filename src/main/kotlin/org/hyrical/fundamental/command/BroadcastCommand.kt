package org.hyrical.fundamental.command

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Name
import co.aikar.commands.annotation.Optional
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.hyrical.fundamental.utility.CC

object BroadcastCommand : BaseCommand() {

    @CommandAlias("broadcast|bc|raw")
    @CommandPermission("fundamental.broadcast")
    fun broadcast(player: Player, @Name("message") msg: String){
        Bukkit.broadcastMessage(CC.translate(msg))
    }
}