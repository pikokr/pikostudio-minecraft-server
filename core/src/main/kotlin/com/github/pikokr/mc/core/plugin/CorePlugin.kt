package com.github.pikokr.mc.core.plugin

import org.bukkit.plugin.java.JavaPlugin

class CorePlugin : JavaPlugin() {
    override fun onEnable() {
        println("Core enabled")
    }
}