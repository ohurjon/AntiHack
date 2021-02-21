package kr.ohurjon.Event

import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class PlayerReachEvent(private val player : Player , private val reach: Double) : BaseEvent() {
    fun getReach() : Double {
        return reach
    }
    fun getPlayer() : Player {
        return player
    }
}