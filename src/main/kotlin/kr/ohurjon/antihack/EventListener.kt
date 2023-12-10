package kr.ohurjon.antihack

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent
import kr.ohurjon.antihack.event.PlayerReachEvent
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerInteractEvent


class EventListener : Listener {

    private val plugin = AntiHack.instance

    private val config = plugin.config

    @EventHandler
    fun reach(event: EntityDamageByEntityEvent) {
        if (event.cause.name == "ENTITY_ATTACK" && event.damager is Player) {
            val player = (event.damager as Player)
            val range = player.location.distance(event.entity.location)
            val type = player.inventory.itemInMainHand.type.name

            if (config.getList("reach.items").contains(type)) {
                if (range >= config.getDouble("reach.range") )
                    plugin.callEvent(PlayerReachEvent(player,range))
            }
        }
    }

    @EventHandler
    fun cps(event: EntityDamageByEntityEvent) {
        if (event.cause.name == "ENTITY_ATTACK" && event.damager is Player) {
            val player = (event.damager as Player)
            ClickManager().getClick(player).addClick(1)
        }
    }

    @EventHandler
    fun crack(event : WeaponDamageEntityEvent) {
        val player = event.player
        val range = player.location.distance(event.victim.location)

        if (config.getList("reach.cracks").contains(event.weaponTitle)) {
            if(range >= config.getDouble("reach.range"))
                plugin.callEvent(PlayerReachEvent(player,range))
        }
    }

    @EventHandler
    fun block(event: BlockBreakEvent) {
        ClickManager().getClick(event.player).subClick(1)
    }

    @EventHandler
    fun cps(event: PlayerInteractEvent)  {
        if(!event.action.name.contains("RIGHT") && event.action.name != "PHYSICAL") {
            ClickManager().getClick(event.player).addClick(1)
        }
    }


}
