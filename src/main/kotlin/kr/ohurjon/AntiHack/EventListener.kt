package kr.ohurjon.AntiHack

import kr.ohurjon.AntiHack.Event.PlayerReachEvent
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerInteractEvent


class EventListener : Listener {

    private val plugin = AntiHack.instance

    @EventHandler
    fun reach(event: EntityDamageByEntityEvent) {
        if (event.cause.name == "ENTITY_ATTACK" && event.damager is Player) {
            val player = (event.damager as Player)
            val range = player.location.distance(event.entity.location)
            val type = player.inventory.itemInMainHand.type.name
            val config = plugin.config

            if (config.getList("reach.items").contains(type)) {
                if (range >= config.getDouble("reach.range") )
                    plugin.server.pluginManager.callEvent(PlayerReachEvent(player,range))
            }
        }
    }

    @EventHandler
    fun cps(event: PlayerInteractEvent)  {
        if(!event.action.name.contains("RIGHT") && event.action.name != "PHYSICAL") {
            val manager = ClickManager()
            val click: Click =
                if (manager.containClick(event.player)) {
                    manager.getClick(event.player)!!
                } else {
                    Click(event.player)
                }
            click.addClick(1)
        }
    }


}

