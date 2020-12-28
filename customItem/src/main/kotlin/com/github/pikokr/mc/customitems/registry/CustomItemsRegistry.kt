package com.github.pikokr.mc.customitems.registry

import com.github.pikokr.mc.customitems.items.CustomItem

object CustomItemsRegistry {
    val items = HashMap<String, CustomItem>()

    fun register(id: String, fn: () -> CustomItem) {
        val item = fn()
        val meta = item.itemMeta
        val lore = meta.lore ?: arrayListOf()
        lore.add("CUSTOM__${id}")
        meta.lore = lore
        item.itemMeta = meta
        items[id] = item
    }
}