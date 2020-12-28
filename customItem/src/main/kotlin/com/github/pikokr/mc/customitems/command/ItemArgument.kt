package com.github.pikokr.mc.customitems.command

import com.github.noonmaru.kommand.KommandContext
import com.github.noonmaru.kommand.argument.KommandArgument
import com.github.noonmaru.kommand.argument.suggestions
import com.github.pikokr.mc.customitems.items.CustomItem
import com.github.pikokr.mc.customitems.registry.CustomItemsRegistry

object ItemArgument : KommandArgument<CustomItem> {
    override val parseFailMessage: String
        get() = "${KommandArgument.TOKEN} 플레이어를 찾지 못했습니다."

    override fun parse(context: KommandContext, param: String): CustomItem? {
        return CustomItemsRegistry.items[param]
    }

    override fun listSuggestion(context: KommandContext, target: String): Collection<String> {
        return CustomItemsRegistry.items.map { it.key }.suggestions(target)
    }
}