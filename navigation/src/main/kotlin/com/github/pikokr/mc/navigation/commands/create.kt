package com.github.pikokr.mc.navigation.commands

import com.github.noonmaru.kommand.KommandContext
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.CompassMeta

fun createNavigation(ctx: KommandContext) {
    if (ctx.sender !is Player) return
    val player = ctx.sender as Player
    player.inventory.contents.filterNotNull().find {
        it.type === Material.COMPASS && it.itemMeta.lore?.last() == "NAVIGATION"
    }?.let {
        return player.sendMessage("이미 이용중인 네비게이션이 있네요!")
    }
    if (player.inventory.firstEmpty() == -1) return player.sendMessage("인벤토리가 꽉 찼네요!")
    val item = ItemStack(Material.COMPASS)
    val meta = item.itemMeta as CompassMeta
    val x = ctx.parseArgument<Int>("x")
    val z = ctx.parseArgument<Int>("z")
    meta.setDisplayName("네비게이션 X: $x Z: $z")
    meta.isLodestoneTracked = false
    meta.lodestone = Location(player.world, x.toDouble(), 0.0, z.toDouble())
    item.itemMeta = meta
    item.lore = arrayListOf("NAVIGATION")
    player.inventory.addItem(item)
}