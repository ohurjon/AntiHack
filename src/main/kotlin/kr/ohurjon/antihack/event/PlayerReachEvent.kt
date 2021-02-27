package kr.ohurjon.antihack.event

import org.bukkit.entity.Player

class PlayerReachEvent(player : Player, val reach: Double) : BaseEvent(player)