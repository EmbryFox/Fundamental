package org.hyrical.fundamental.command

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Name
import co.aikar.commands.annotation.Optional
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.hyrical.fundamental.utility.CC

object CraftCommand : BaseCommand() {

    @CommandAlias("craft")
    @CommandPermission("fundamental.craft")
    fun craft(player: Player){
        player.openWorkbench(player.location, true)
    }
}