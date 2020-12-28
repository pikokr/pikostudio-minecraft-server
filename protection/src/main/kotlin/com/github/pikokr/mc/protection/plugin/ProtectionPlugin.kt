package com.github.pikokr.mc.protection.plugin

import com.github.pikokr.mc.protection.listeners.ExplosionListener
import com.github.pikokr.mc.protection.listeners.FireListener
import org.bukkit.plugin.java.JavaPlugin

class ProtectionPlugin : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(ExplosionListener(), this)
        server.pluginManager.registerEvents(FireListener(), this)
    }
}