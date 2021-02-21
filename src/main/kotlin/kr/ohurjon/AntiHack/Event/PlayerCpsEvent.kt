package kr.ohurjon.AntiHack.Event

import org.bukkit.entity.Player

class PlayerCpsEvent(private val player : Player, private val cps : Int) : BaseEvent() {
    fun getCps() : Int {
        return cps
    }
    fun getPlayer() : Player {
        return player
    }
}