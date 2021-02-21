package kr.ohurjon

import kr.ohurjon.Event.PlayerCpsEvent
import kr.ohurjon.Event.PlayerReachEvent
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
            val range = event.damager.location.distance(event.entity.location)
            val damager = (event.damager as Player)
            val type = damager.inventory.itemInMainHand.type.name


            val config = plugin.config

            if (config.getList("reach.items").contains(type)) {
                if (range >= config.getDouble("reach.range") )
                for (player in plugin.server.onlinePlayers) {
                    plugin.server.pluginManager.callEvent(PlayerReachEvent(range))
                }
            }
        }
    }

    @EventHandler
    fun cps(event: PlayerInteractEvent)  {
        val manager = ClickManager()
        val click : Click =
        if (manager.containClick(event.player)) {
            manager.getClick(event.player)!!
        } else {
            Click(event.player)
        }
        click.addClick(1)
    }

    @EventHandler
    fun dsa(event: PlayerCpsEvent){
        event.getCps()
    }

}

