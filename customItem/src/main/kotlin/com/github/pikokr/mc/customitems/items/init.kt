package com.github.pikokr.mc.customitems.items

import com.github.pikokr.mc.customitems.plugin.CustomItemsPlugin
import com.github.pikokr.mc.customitems.registry.CustomItemsRegistry
import org.bukkit.Material
import org.bukkit.entity.Arrow
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

fun initItems(plugin: CustomItemsPlugin) {
    CustomItemsRegistry.register("follow_bow") {
        object : CustomItem(Material.BOW) {
            init {
                val meta = itemMeta
                meta.setDisplayName("쓸데없는(?) 활")
                itemMeta = meta
            }
        }
    }
}

open class CustomItem(material: Material) : ItemStack(material) {
    open fun onUse(event: PlayerInteractEvent, plugin: CustomItemsPlugin) {}
}
