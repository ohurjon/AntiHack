package kr.ohurjon.AntiHack.Event

import org.bukkit.entity.Player

class PlayerReachEvent(player : Player, val reach: Double) : BaseEvent(player)