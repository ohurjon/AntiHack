package kr.ohurjon.Event

import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class PlayerCpsEvent(private val player : Player, private val cps : Int) : BaseEvent() {
    fun getCps() : Int {
        return cps
    }
    fun getPlayer() : Player {
        return player
    }
}