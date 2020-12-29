package com.github.pikokr.mc.customitems.events

import com.github.pikokr.mc.customitems.plugin.CustomItemsPlugin
import com.github.pikokr.mc.customitems.registry.CustomItemsRegistry
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerItemBreakEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class CustomItemListener(val plugin: CustomItemsPlugin) : Listener {
    @EventHandler
    fun onInteract(event: PlayerInteractEvent) {
        val i = event.player.inventory.itemInMainHand
        if (i.hasItemMeta() && i.itemMeta.persistentDataContainer.get(NamespacedKey(plugin, "broken"), PersistentDataType.SHORT) == (1).toShort()) {
            event.isCancelled = true
        }
        if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK) {
            val id = event.player.inventory.itemInMainHand.itemMeta?.lore?.last() ?: return
            val item =
                CustomItemsRegistry.items.entries.find { it.key == id.slice("CUSTOM__".length until id.length) }?.value
            item?.onUse(event, plugin)
        }
    }

    @EventHandler
    fun onBreak(event: BlockBreakEvent) {
        val id = event.player.inventory.itemInMainHand.itemMeta?.lore?.last() ?: return
        val item =
            CustomItemsRegistry.items.entries.find { it.key == id.slice("CUSTOM__".length until id.length) }?.value
        item?.onBreakWith(event, plugin)
    }

    @EventHandler
    fun onToolBreak(event: PlayerItemBreakEvent) {
        val tools = arrayListOf<Material>()
        // wood
        tools.add(Material.WOODEN_PICKAXE)
        tools.add(Material.WOODEN_HOE)
        tools.add(Material.WOODEN_AXE)
        tools.add(Material.WOODEN_SHOVEL)
        tools.add(Material.WOODEN_SWORD)
        // stone
        tools.add(Material.STONE_PICKAXE)
        tools.add(Material.STONE_HOE)
        tools.add(Material.STONE_AXE)
        tools.add(Material.STONE_SHOVEL)
        tools.add(Material.STONE_SWORD)
        // iron
        tools.add(Material.IRON_PICKAXE)
        tools.add(Material.IRON_HOE)
        tools.add(Material.IRON_AXE)
        tools.add(Material.IRON_SHOVEL)
        tools.add(Material.IRON_SWORD)
        // gold
        tools.add(Material.GOLDEN_PICKAXE)
        tools.add(Material.GOLDEN_HOE)
        tools.add(Material.GOLDEN_AXE)
        tools.add(Material.GOLDEN_SHOVEL)
        tools.add(Material.GOLDEN_SWORD)
        // diamond
        tools.add(Material.DIAMOND_PICKAXE)
        tools.add(Material.DIAMOND_HOE)
        tools.add(Material.DIAMOND_AXE)
        tools.add(Material.DIAMOND_SHOVEL)
        tools.add(Material.DIAMOND_SWORD)
        // gold
        tools.add(Material.NETHERITE_PICKAXE)
        tools.add(Material.NETHERITE_HOE)
        tools.add(Material.NETHERITE_AXE)
        tools.add(Material.NETHERITE_SHOVEL)
        tools.add(Material.NETHERITE_SWORD)

        if (tools.contains(event.brokenItem.type)) {
            val item = ItemStack(event.brokenItem.type)
            val meta = item.itemMeta
            meta.persistentDataContainer.set(NamespacedKey(plugin, "broken"), PersistentDataType.SHORT, 1)
            val lore = arrayListOf<String>()
            lore.add("BROKEN")
            meta.lore?.filter { it != "BROKEN" }?.forEach {
                lore.add(it)
            }
            meta.lore = lore
            item.itemMeta = meta
            event.player.inventory.setItemInMainHand(item)
        }
    }
}