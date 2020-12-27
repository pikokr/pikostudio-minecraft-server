package com.github.pikokr.mc.core.plugin

import com.github.pikokr.mc.core.util.registerCommands
import org.bukkit.plugin.java.JavaPlugin

class CorePlugin : JavaPlugin() {
    override fun onEnable() {
        registerCommands(this)
    }
}