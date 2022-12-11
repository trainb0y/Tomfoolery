package io.github.trainb0y.tomfoolery

import gg.essential.elementa.components.Window
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import org.lwjgl.glfw.GLFW
import kotlin.random.Random

@Suppress("Unused")
object Tomfoolery : ClientModInitializer {
	val channel = Identifier("test:channel")

	override fun onInitializeClient() {
		val key = KeyBindingHelper.registerKeyBinding(KeyBinding("key.test.send",
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_P,
			"category.test.keybinds"
		))
		ClientTickEvents.END_CLIENT_TICK.register { client ->
			if (key.wasPressed()) {
				val value = Random.nextInt(100)
				ClientPlayNetworking.send(channel, PacketByteBufs.create().also {it.writeInt(value)})
				client.player?.sendMessage(Text.literal("Sent $value!"), false)
			}
		}
	}
}