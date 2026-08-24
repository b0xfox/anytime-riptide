package io.github.b0xfox.anytime_trident;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.b0xfox.anytime_trident.component.DataComponentTypes;

public class AnytimeRiptide implements ModInitializer {

	public static final String MOD_ID = "anytime-riptide";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        DataComponentTypes.registerDataComponentTypes();
	}
}
