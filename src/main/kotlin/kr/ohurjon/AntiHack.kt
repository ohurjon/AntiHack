package kr.ohurjon

import kr.entree.spigradle.annotations.SpigotPlugin
import org.bukkit.Server
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

@SpigotPlugin
class AntiHack : JavaPlugin() {

    private val plugin : AntiHack = this

    override fun onEnable() {
        this.saveDefaultConfig()
        server.pluginManager.registerEvents(EventListener(),this)
    }

    override fun onDisable() {

    }

    fun getPlugin() : JavaPlugin {
        return plugin;
    }
};