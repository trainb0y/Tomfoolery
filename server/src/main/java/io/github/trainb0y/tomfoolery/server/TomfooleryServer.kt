package io.github.trainb0y.tomfoolery.server;

import io.github.trainb0y.tomfoolery.common.CommonTest
import org.bukkit.plugin.java.JavaPlugin;

@Suppress("Unused")
class TomfooleryServer: JavaPlugin() {

	override fun onEnable() {
		println("Hello from server!")
		CommonTest().doStuff()
	}
}
