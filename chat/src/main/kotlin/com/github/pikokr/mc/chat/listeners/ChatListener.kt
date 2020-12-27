package com.github.pikokr.mc.chat.listeners

import com.github.kimcore.inko.Inko.Companion.asKorean
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class ChatListener : Listener {
    @EventHandler
    fun onChat(e: AsyncPlayerChatEvent) {
        e.message = ChatColor.translateAlternateColorCodes('&', e.message)
        if (e.message.startsWith("!") && e.message.length > 1) {
            e.message = e.message.slice(1 until e.message.length)
        } else {
            if (e.message.startsWith("k")) {
                e.message = e.message.slice(1 until e.message.length).asKorean
            }
        }
    }
}