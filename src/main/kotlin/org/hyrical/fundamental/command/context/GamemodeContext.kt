package org.hyrical.fundamental.command.context

import co.aikar.commands.BukkitCommandExecutionContext
import co.aikar.commands.contexts.ContextResolver
import org.bukkit.GameMode

class GamemodeContext : ContextResolver<GameMode, BukkitCommandExecutionContext> {
    override fun getContext(c: BukkitCommandExecutionContext?): GameMode {
        return when (c!!.popFirstArg()) {
            "creative", "c" -> GameMode.CREATIVE
            "survival", "s" -> GameMode.SURVIVAL
            "adventure", "a" -> GameMode.ADVENTURE
            "spectator", "sp" -> GameMode.SPECTATOR
            else -> GameMode.SURVIVAL
        }
    }


}