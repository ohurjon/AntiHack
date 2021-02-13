package kr.ohurjon

import org.apache.tools.ant.taskdefs.Ant
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerInteractEvent

import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.Plugin


class EventListener : Listener {

    private val plugin = AntiHack.instance

    @EventHandler
    fun reach(event: EntityDamageByEntityEvent) {
        if (event.cause.name == "ENTITY_ATTACK" && event.damager is Player) {
            val range = event.damager.location.distance(event.entity.location)
            val type = (event.damager as Player).inventory.itemInMainHand.type.name

            val config = plugin.config

            if (type == "WOOD_SWORD" || type == "NETHER_STALK" || type == "AIR" ) {
                if (range >= config.getDouble("reach.range") )
                for (player in plugin.server.onlinePlayers) {
                    val notice : String  =
                        config.getString("server.prefix") + config.getString("reach.notice")
                        .replace("{name}",player.name)
                        .replace("{range}",range.toString())
                    if (player.isOp) player.sendMessage(notice)
                }
            }
        }
    }

    @EventHandler
    fun cps(event: PlayerInteractEvent)  {

    }
}
