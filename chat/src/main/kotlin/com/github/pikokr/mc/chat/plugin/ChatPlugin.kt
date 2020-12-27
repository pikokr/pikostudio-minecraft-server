package com.github.pikokr.mc.chat.plugin

import com.github.pikokr.mc.chat.listeners.ChatListener
import org.bukkit.plugin.java.JavaPlugin

class ChatPlugin : JavaPlugin() {
    companion object {
        lateinit var instance: ChatPlugin
    }

    override fun onEnable() {
        instance = this

        server.pluginManager.registerEvents(ChatListener(), this)
    }
}