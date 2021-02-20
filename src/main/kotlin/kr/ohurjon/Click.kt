package kr.ohurjon

import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

class Click(private val player : Player) {
    private var click : Int = 0
    private var plugin : AntiHack = AntiHack.instance

    init {
        this.runCheck()
        ClickManager().addClick(this)
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
                if(beforeClick - click >= limit && i < 10){
                    plugin.server.broadcastMessage(plugin.config.getString("cps.message"))
                }
                if(i == 10){
                    if(click/10 >= limit){
                        plugin.server.broadcastMessage("이상이상")
                    }
                }
                beforeClick = click
                i += 1
            }
        }
        task.runTaskTimerAsynchronously(plugin,20L,200L)
    }

}