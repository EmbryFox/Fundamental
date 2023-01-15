package org.hyrical.fundamental

import co.aikar.commands.BaseCommand
import co.aikar.commands.PaperCommandManager
import org.bukkit.GameMode
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import org.hyrical.fundamental.command.*
import org.hyrical.fundamental.command.context.GamemodeContext
import org.hyrical.fundamental.command.context.ItemStackContext
import kotlin.properties.Delegates

class Fundamental : JavaPlugin() {

    companion object {
        lateinit var instance: Fundamental
        var uptime by Delegates.notNull<Long>()
    }

    override fun onEnable() {
        instance = this
        uptime = System.currentTimeMillis()

        val commandManager = PaperCommandManager(this)

        commandManager.commandContexts.registerContext(GameMode::class.java, GamemodeContext())
        commandManager.commandContexts.registerContext(ItemStack::class.java, ItemStackContext())

        for (cmd in getCommands()){
            commandManager.registerCommand(cmd)
        }
    }

    fun getCommands(): List<BaseCommand> {
        return listOf(
            BroadcastCommand,
            CraftCommand,
            FeedCommand,
            GamemodeCommands,
            GiveCommand,
            HatCommand,
            HealCommand,
            MoreCommand,
            SudoCommands,
            UptimeCommand,
            CrashCommand
        )
    }
}