package com.github.pikokr.mc.customitems.items

import com.github.pikokr.mc.customitems.plugin.CustomItemsPlugin
import com.github.pikokr.mc.customitems.registry.CustomItemsRegistry
import org.bukkit.Material
import org.bukkit.entity.Arrow
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

fun initItems(plugin: CustomItemsPlugin) {
    CustomItemsRegistry.apply {
        register("follow_bow") {
            object : CustomItem(Material.BOW) {
                init {
                    val meta = itemMeta
                    meta.setDisplayName("쓸데없는(?) 활")
                    itemMeta = meta
                }
            }
        }
        register("test_pickaxe") {
            val material = Material.DIAMOND_PICKAXE
            object : CustomItem(material) {
                init {
                    val meta = itemMeta
                    meta.setDisplayName("테스트중인 곡괭이")
                    itemMeta = meta
                }

                override fun onBreakWith(event: BlockBreakEvent, plugin: CustomItemsPlugin) {
                    event.player.inventory.itemInMainHand.itemMeta?.let { tool ->
                        event.player.setCooldown(material, 20)
                        event.block.breakNaturally(this)
                    }
                }
            }
        }
    }
}

open class CustomItem(material: Material) : ItemStack(material) {
    open fun onUse(event: PlayerInteractEvent, plugin: CustomItemsPlugin) {}
    open fun onBreakWith(event: BlockBreakEvent, plugin: CustomItemsPlugin) {}
}
