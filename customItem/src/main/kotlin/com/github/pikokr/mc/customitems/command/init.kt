package com.github.pikokr.mc.customitems.command

import com.github.noonmaru.kommand.argument.player
import com.github.noonmaru.kommand.kommand
import com.github.pikokr.mc.customitems.items.CustomItem
import com.github.pikokr.mc.customitems.plugin.CustomItemsPlugin
import org.bukkit.entity.Player

fun initCommands(plugin: CustomItemsPlugin) {
    plugin.kommand {
        register("/give") {
            then("player" to player()) {
                then("item" to ItemArgument) {
                    executes {
                        val item = it.parseArgument<CustomItem>("item")
                        it.parseArgument<Player>("player").inventory.addItem(item.clone())
                    }
                }
            }
        }
    }
}