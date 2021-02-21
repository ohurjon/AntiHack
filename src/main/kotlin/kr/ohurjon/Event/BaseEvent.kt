package kr.ohurjon.Event

import org.bukkit.event.Event
import org.bukkit.event.HandlerList

open class BaseEvent : Event() {
    companion object {
        private val handler: HandlerList = HandlerList()
        @JvmStatic
        fun getHandlerList(): HandlerList {
            return handler;
        }
    }

    override fun getHandlers(): HandlerList {
        return handler
    }
}