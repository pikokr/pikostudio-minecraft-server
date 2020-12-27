package com.github.pikokr.mc.navigation.commands

import com.github.noonmaru.kommand.KommandContext
import org.bukkit.Material
import org.bukkit.entity.Player

fun stopNavigation(ctx: KommandContext) {
    if (ctx.sender !is Player) return
    val player = ctx.sender as Player
    if (player.inventory.contents.filterNotNull().find {
            it.type === Material.COMPASS && it.itemMeta.lore?.last() == "NAVIGATION"
        } == null) return player.sendMessage("네비게이션이 없네요!")
    for (i in player.inventory.contents.filterNotNull()) {
        if (i.type == Material.COMPASS && i.itemMeta.lore?.last() == "NAVIGATION") {
            player.inventory.remove(i)
        }
    }
    player.sendMessage("네비게이션을 종료했어요!")
}