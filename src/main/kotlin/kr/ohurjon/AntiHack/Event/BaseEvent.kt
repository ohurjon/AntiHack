package kr.ohurjon.AntiHack.Event

import org.bukkit.entity.Player
import org.bukkit.event.HandlerList
import org.bukkit.event.player.PlayerEvent

open class BaseEvent(who: Player) : PlayerEvent(who) {
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