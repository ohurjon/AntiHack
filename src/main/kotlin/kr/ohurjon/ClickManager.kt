package kr.ohurjon

import org.bukkit.entity.Player

class ClickManager {
    companion object {
        private var Map = HashMap<Player,Click>();
    }

    fun addClick(click : Click) {
        Map.put(click.getPlayer(),click)
    }

    fun removeClick(click: Click){
        Map.remove(click.getPlayer())
    }

    fun removeClick(player : Player){
        Map.remove(player)
    }

    fun getClick(player: Player) : Click? {
        return Map.get(player)
    }

    fun countClick(): Int {
        return Map.size
    }

    fun containClick(player: Player) : Boolean {
        return Map.containsKey(player)
    }
}