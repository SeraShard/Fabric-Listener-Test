package net.serashard.test

import net.fabricmc.api.ModInitializer
import net.minecraft.resources.ResourceLocation
import org.slf4j.LoggerFactory

object Test : ModInitializer {
	const val MOD_ID: String = "test"

	private val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		
		ServerPlayConnectionEvents.JOIN.register { handler, _, _ ->
			
			val player = handler.player
			val playerInventory = player.inventory

			val item = ItemStack(Items.DIAMOND_SWORD, 1)

			playerInventory.insertStack(item)
		}

	}

	fun id(path: String): ResourceLocation
		= ResourceLocation(MOD_ID, path)
}
