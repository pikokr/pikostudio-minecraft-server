package com.github.pikokr.mc.navigation.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerDropItemEvent

class BlockDropNavigation : Listener {
    @EventHandler
    fun onDrop(event: PlayerDropItemEvent) {
        if (event.itemDrop.itemStack.itemMeta.lore?.last() == "NAVIGATION") event.isCancelled = true
    }
}