package com.github.pikokr.mc.navigation.plugin

import com.github.pikokr.mc.navigation.commands.initCommands
import com.github.pikokr.mc.navigation.events.BlockDropNavigation
import org.bukkit.plugin.java.JavaPlugin

class NavigationPlugin : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(BlockDropNavigation(), this)
        initCommands(this)
    }
}