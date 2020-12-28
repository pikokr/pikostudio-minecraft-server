package com.github.pikokr.mc.protection.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockIgniteEvent

class FireListener : Listener {
    @EventHandler
    fun onFireTick(event: BlockIgniteEvent) {
        if (event.cause != BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL) {
            event.isCancelled = true
        }
    }
}