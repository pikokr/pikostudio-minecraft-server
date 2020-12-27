package com.github.pikokr.mc.protection.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityExplodeEvent

class ExplosionListener : Listener {
    @EventHandler
    fun onExplode(e: EntityExplodeEvent) {
        e.blockList().clear()
    }
}