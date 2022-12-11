package io.github.trainb0y.tomfoolery.client

import io.github.trainb0y.tomfoolery.common.CommonTest
import net.fabricmc.api.ClientModInitializer

@Suppress("Unused")
object Tomfoolery : ClientModInitializer {

	override fun onInitializeClient() {
		println("Hello from client!")
		CommonTest().doStuff()
	}
}