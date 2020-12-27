package com.github.pikokr.mc.navigation.commands

import com.github.noonmaru.kommand.argument.integer
import com.github.noonmaru.kommand.kommand
import com.github.pikokr.mc.navigation.plugin.NavigationPlugin

fun initCommands(plugin: NavigationPlugin) {
    plugin.kommand {
        register("navigation") {
            then("create") {
                then("x" to integer()) {
                    then("z" to integer()) {
                        executes {
                            createNavigation(it)
                        }
                    }
                }
            }
            then("stop") {
                executes {
                    stopNavigation(it)
                }
            }
        }
    }
}