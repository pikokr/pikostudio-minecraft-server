package com.github.pikokr.mc.customitems.items

import com.github.pikokr.mc.customitems.plugin.CustomItemsPlugin
import com.github.pikokr.mc.customitems.registry.CustomItemsRegistry
import org.bukkit.Material
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

fun initItems(plugin: CustomItemsPlugin) {
    CustomItemsRegistry.register("test") {
        object : CustomItem(Material.DIAMOND) {
            init {
                val meta = itemMeta
                meta.setDisplayName("우클릭하면 죽음")
                itemMeta = meta
            }

            override fun onUse(event: PlayerInteractEvent, plugin: CustomItemsPlugin) {
                event.player.health = 0.0
            }
        }
    }
}

open class CustomItem(material: Material) : ItemStack(material) {
    open fun onUse(event: PlayerInteractEvent, plugin: CustomItemsPlugin) {}
}
