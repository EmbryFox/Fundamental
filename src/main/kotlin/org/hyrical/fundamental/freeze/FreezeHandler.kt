package org.hyrical.fundamental.freeze

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.scheduler.BukkitRunnable
import org.hyrical.fundamental.Fundamental
import org.hyrical.fundamental.utility.CC


object FreezeHandler {

    fun freeze(player: Player){
        player.setMetadata("frozen", FixedMetadataValue(Fundamental.instance, true))

        val location = player.location
        var tries = 0

        while (1.0 <= location.y && !location.block.type.isSolid && tries++ < 100) {
            location.subtract(0.0, 1.0, 0.0)
            if (location.y <= 0.0) {
                break
            }
        }
        if (100 <= tries) {
            Bukkit.getLogger().info("Hit the 100 try limit on the freeze command.")
        }

        object : BukkitRunnable(){
            override fun run() {
                if (!player.hasMetadata("frozen")){
                    cancel()
                    return
                }

                val msg = """
                    ${CC.RED}  
                    ${CC.RED}You've been frozen by a staff member!
                    ${CC.YELLOW}You have ${CC.WHITE}3 minutes${CC.YELLOW} to join ${CC.GREEN}discord.pvpmines.net${CC.YELLOW}.
                    ${CC.GRAY}If you fail to comply with our staff team's orders, you will be banned.
                    ${CC.RED}  
                """.trimIndent()

                player.sendMessage(msg)
            }
        }.runTaskTimer(Fundamental.instance, 0L, 20L * 5)
    }

    fun unfreeze(player: Player){
        player.removeMetadata("frozen", Fundamental.instance)

        player.sendMessage(CC.translate("&aYou have been unfrozen."))
    }

}