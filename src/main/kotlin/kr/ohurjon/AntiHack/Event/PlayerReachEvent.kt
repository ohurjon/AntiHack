package kr.ohurjon.AntiHack.Event

import org.bukkit.entity.Player

class PlayerReachEvent(private val player : Player , private val reach: Double) : BaseEvent() {
    fun getReach() : Double {
        return reach
    }
    fun getPlayer() : Player {
        return player
    }
}