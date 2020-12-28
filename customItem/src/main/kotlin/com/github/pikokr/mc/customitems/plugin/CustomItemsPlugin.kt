package com.github.pikokr.mc.customitems.plugin

import com.github.pikokr.mc.customitems.command.initCommands
import com.github.pikokr.mc.customitems.events.CustomItemListener
import com.github.pikokr.mc.customitems.events.FollowingBow
import com.github.pikokr.mc.customitems.items.initItems
import org.bukkit.plugin.java.JavaPlugin

class CustomItemsPlugin : JavaPlugin() {
    override fun onEnable() {
        initCommands(this)
        initItems(this)
        server.pluginManager.registerEvents(CustomItemListener(this), this)
        server.pluginManager.registerEvents(FollowingBow(), this)
    }
}