package kr.ohurjon

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent

import org.bukkit.event.player.PlayerInteractEvent



class EventListener : Listener {

    @EventHandler
    fun reach(event: EntityDamageByEntityEvent) {
        if (event.cause.name == "ENTITY_ATTACK" && event.damager is Player) {
            val range = event.damager.location.distance(event.entity.location)
            val type = (event.damager as Player).inventory.itemInMainHand.type.name

            val config = AntiHack().config

            if (type == "WOOD_SWORD" || type == "NETHER_WARTS" || type == "AIR" ) {
                if (range >= config.get("reach.range") as Double )
                for (player in AntiHack().server.onlinePlayers) {
                    val notice : String  =
                        config.get("server.prefix") as String + (config.get("reach.notice") as String)
                        .replace("{name}",player.name)
                        .replace("{range}",range.toString())
                    if (player.isOp) player.sendMessage(notice)
                }
            }
        }
    }

    @EventHandler
    fun cps(event: PlayerInteractEvent)  {
        val player = event.player

    }
}
