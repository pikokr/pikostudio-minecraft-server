package com.github.pikokr.mc.customitems.plugin

import com.github.pikokr.mc.customitems.command.initCommands
import com.github.pikokr.mc.customitems.events.CustomItemListener
import com.github.pikokr.mc.customitems.events.FollowingBow
import com.github.pikokr.mc.customitems.items.initItems
import com.github.pikokr.mc.customitems.registry.CustomItemsRegistry
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.plugin.java.JavaPlugin

class CustomItemsPlugin : JavaPlugin() {
    override fun onEnable() {
        initCommands(this)
        initItems(this)
        server.pluginManager.registerEvents(CustomItemListener(this), this)
        server.pluginManager.registerEvents(FollowingBow(), this)
        registerRecipes()
    }

    private fun registerRecipes() {
        val bow = CustomItemsRegistry.items["follow_bow"]
        bow?.let {
            val recipe = ShapedRecipe(NamespacedKey(this, "follow_bow"), bow.asOne())
            recipe.shape("***", "*%*", "***")
            recipe.setIngredient('*', Material.ENDER_PEARL)
            recipe.setIngredient('%', Material.BOW)
            server.addRecipe(recipe)
        }
    }
}