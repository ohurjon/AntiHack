package kr.ohurjon.AntiHack.Event

import org.bukkit.entity.Player

class PlayerCpsEvent(player : Player, val cps : Int) : BaseEvent(player) 