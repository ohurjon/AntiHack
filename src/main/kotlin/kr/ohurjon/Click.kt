package kr.ohurjon

import kr.ohurjon.Event.PlayerCpsEvent
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

class Click(private val player : Player) {
    private var click : Int = 0
    private var plugin : AntiHack = AntiHack.instance
    private var manager : ClickManager = ClickManager()

    init {
        this.runCheck()
        manager.addClick(this)
    }


    fun setClick(click: Int){
        this.click = click
    }
    fun addClick(click: Int){
        this.click += click
    }
    fun subClick(click: Int){
        this.click -= click
    }
    fun getClick(): Int {
        return click
    }
    fun getPlayer() : Player {
        return player
    }

    private fun runCheck() {
        var i = 0
        var beforeClick = 0
        val limit = plugin.config.getInt("cps.limit")
        val task : BukkitRunnable = object : BukkitRunnable() {
            override fun run() {
                if(click - beforeClick >= limit && i < 10){
                    plugin.server.pluginManager.callEvent(PlayerCpsEvent(click-beforeClick))
                }
                if(i == plugin.config.getInt("cps.time")){
                    manager.removeClick(player)
                    this.cancel()
                }
                beforeClick = click
                i += 1
            }
        }
        task.runTaskTimerAsynchronously(plugin,0L,20L)
    }

}