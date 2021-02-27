package kr.ohurjon.antihack.event

import org.bukkit.entity.Player

class PlayerCpsEvent(player : Player, val cps : Int) : BaseEvent(player) 