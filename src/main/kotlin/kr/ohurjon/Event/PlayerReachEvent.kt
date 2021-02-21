package kr.ohurjon.Event

import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class PlayerReachEvent(private val reach: Double) : Event() {
    companion object {
        private val handler: HandlerList = HandlerList()
        @JvmStatic
        fun getHandlerList(): HandlerList {
            return handler;
        }
    }

    fun getReach() : Double {
        return reach
    }



    override fun getHandlers(): HandlerList {
        return handler
    }

}