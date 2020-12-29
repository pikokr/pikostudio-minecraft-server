package com.github.pikokr.mc.customitems.events

import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.entity.TNTPrimed
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ProjectileHitEvent
import org.bukkit.event.entity.ProjectileLaunchEvent
import org.bukkit.inventory.ItemStack

class FollowingBow : Listener {
    @EventHandler
    fun onProjectileLaunch(e: ProjectileLaunchEvent) {
        if (e.entityType == EntityType.ARROW) {
            e.entity.shooter ?: return
            if (e.entity.shooter !is Player) return
            val p = e.entity.shooter as Player
            if (p.inventory.itemInMainHand.itemMeta?.lore?.last() == "CUSTOM__follow_bow") {
                if (p.inventory.itemInOffHand.type == Material.TNT) {
                    val tnt = p.world.spawnEntity(e.entity.location, EntityType.PRIMED_TNT)
                    p.inventory.contents.filterNotNull().find { it.type == Material.TNT }!!.amount--
                    if (p.isSneaking) {
                        tnt.velocity = p.eyeLocation.direction.normalize().multiply(3)
                        e.isCancelled = true
                    } else {
                        e.entity.addPassenger(p)
                        e.entity.addPassenger(tnt)
                    }
                } else {
                    e.entity.addPassenger(p)
                    p.setCooldown(Material.BOW, 60)
                }
            }
        }
    }

//    @EventHandler
//    fun onProjectileHit(e: ProjectileHitEvent) {
//        if (e.entityType == EntityType.ARROW) {
//            e.entity.shooter ?: return
//            if (e.entity.shooter !is Player) return
//            val p = e.entity.shooter as Player
//            p.setCooldown(Material.BOW, 0)
//        }
//    }
}