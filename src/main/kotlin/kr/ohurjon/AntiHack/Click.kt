package kr.ohurjon.AntiHack

import kr.ohurjon.AntiHack.Event.PlayerCpsEvent
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

class Click(val player : Player) {
    var plugin = AntiHack.instance
    var manager = ClickManager()

    var click = 0
    var before = 0

    init {
        this.runCheck()
        manager.addClick(this)
    }

    fun getCurrentClick(): Int {
        return click - before
    }

    fun getLimit() : Int {
        return plugin.config.getInt("cps.limit")
    }

    fun getTime() : Int {
        return plugin.config.getInt("cps.time")
    }

    fun addClick(click: Int) {
        this.click += click
    }


    private fun runCheck() {
        var i = 0

        object : BukkitRunnable() {
            override fun run() {

                if(getCurrentClick() >= getLimit()){
                    plugin.server.pluginManager.callEvent(PlayerCpsEvent(player,getCurrentClick()))
                }

                if(i == getTime()){
                    manager.removeClick(player)
                    this.cancel()
                }

                before = click
                i += 1
            }
        }.runTaskTimerAsynchronously(plugin,0L,20L)
    }

}