package kr.ohurjon.Event

import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class PlayerCpsEvent(private val cps : Int) : Event() {
    companion object {
        private val handler: HandlerList = HandlerList()
        @JvmStatic
        fun getHandlerList(): HandlerList {
            return handler;
        }
    }

    fun getCps() : Int {
        return cps
    }

    override fun getHandlers(): HandlerList {
        return handler
    }

}