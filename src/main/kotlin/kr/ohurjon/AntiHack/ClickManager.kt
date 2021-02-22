package kr.ohurjon.AntiHack

import org.bukkit.entity.Player

class ClickManager {
    companion object {
        var Map = HashMap<Player, Click>();
    }

    fun addClick(click : Click) {
        Map[click.player] = click
    }

    fun removeClick(click: Click){
        Map.remove(click.player)
    }

    fun removeClick(player : Player){
        Map.remove(player)
    }

    fun getClick(player: Player) : Click? {
        return Map[player]
    }

    fun countClicks(): Int {
        return Map.size
    }

    fun containClick(player: Player) : Boolean {
        return Map.containsKey(player)
    }
}