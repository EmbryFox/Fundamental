package org.hyrical.fundamental.command

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import org.bukkit.entity.Player
import org.hyrical.fundamental.Fundamental
import org.hyrical.fundamental.utility.CC
import org.hyrical.fundamental.utility.TimeUtils

object UptimeCommand : BaseCommand() {

    @CommandAlias("serveruptime|uptime")
    fun uptime(player: Player){
        val uptime = System.currentTimeMillis() - Fundamental.uptime

        player.sendMessage(CC.translate("&6The server has been running for &f${TimeUtils.formatIntoDetailedString((uptime / 1000L).toInt())}."))
    }
}