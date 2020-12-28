package com.github.pikokr.mc.customitems.events

import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ProjectileHitEvent
import org.bukkit.event.entity.ProjectileLaunchEvent

class FollowingBow : Listener {
    @EventHandler
    fun onProjectileLaunch(e: ProjectileLaunchEvent) {
        if (e.entityType == EntityType.ARROW) {
            e.entity.shooter ?: return
            if (e.entity.shooter !is Player) return
            val p = e.entity.shooter as Player
            if (p.inventory.itemInMainHand.itemMeta?.lore?.last() == "CUSTOM__follow_bow") {
                e.entity.addPassenger(p)
                p.setCooldown(Material.BOW, 60)
            }
        }
    }

    @EventHandler
    fun onProjectileHit(e: ProjectileHitEvent) {
        if (e.entityType == EntityType.ARROW) {
            e.entity.shooter ?: return
            if (e.entity.shooter !is Player) return
            val p = e.entity.shooter as Player
            p.setCooldown(Material.BOW, 0)
        }
    }
}