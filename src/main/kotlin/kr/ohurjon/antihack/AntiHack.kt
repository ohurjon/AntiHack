package kr.ohurjon.antihack

import kr.entree.spigradle.annotations.SpigotPlugin
import org.bukkit.event.Event

import org.bukkit.plugin.java.JavaPlugin


@SpigotPlugin
class AntiHack : JavaPlugin() {

    companion object {
        lateinit var instance: AntiHack
            private set
    }

    override fun onEnable() {
        instance = this
        this.saveDefaultConfig()
        server.pluginManager.registerEvents(EventListener(),this)
    }

    fun callEvent(event : Event) {
        server.pluginManager.callEvent(event)
    }

}