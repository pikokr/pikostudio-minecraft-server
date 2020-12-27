package com.github.pikokr.mc.navigation.plugin

import com.github.pikokr.mc.navigation.commands.initCommands
import org.bukkit.plugin.java.JavaPlugin

class NavigationPlugin : JavaPlugin() {
    override fun onEnable() {
        initCommands(this)
    }
}