package com.github.pikokr.mc.customitems.events

import com.github.pikokr.mc.customitems.plugin.CustomItemsPlugin
import com.github.pikokr.mc.customitems.registry.CustomItemsRegistry
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class CustomItemListener(val plugin: CustomItemsPlugin) : Listener {
    @EventHandler
    fun onInteract(event: PlayerInteractEvent) {
        if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK) {
            val id = event.player.inventory.itemInMainHand.itemMeta?.lore?.last() ?: return
            val item = CustomItemsRegistry.items.entries.find { it.key == id.slice("CUSTOM__".length until id.length) }?.value
            item?.onUse(event, plugin)
        }
    }
}