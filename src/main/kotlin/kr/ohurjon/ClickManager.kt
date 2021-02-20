package kr.ohurjon

import org.bukkit.entity.Player

class ClickManager {

    private var Map = HashMap<Player,Click>()

    fun addClick(click : Click) {
        Map[click.getPlayer()] = click
    }

    fun removeClick(click: Click){
        Map.remove(click.getPlayer())
    }

    fun removeClick(player : Player){
        Map.remove(player)
    }

    fun getClick(player: Player) : Click? {
        return Map[player]
    }

    fun containClick(player: Player) : Boolean {
        return Map.keys.contains(player)
    }
}