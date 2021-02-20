package kr.ohurjon

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerInteractEvent

import org.bukkit.scheduler.BukkitRunnable


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
                    val notice : String  =
                        config.getString("server.prefix") + config.getString("reach.notice")
                        .replace("{name}",damager.name)
                        .replace("{range}",range.toString())
                    if (player.isOp) player.sendMessage(notice)
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

}

