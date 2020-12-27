package com.github.pikokr.mc.protection.plugin

import com.github.pikokr.mc.protection.listeners.ExplosionListener
import org.bukkit.plugin.java.JavaPlugin

class ProtectionPlugin : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(ExplosionListener(), this)
    }
}