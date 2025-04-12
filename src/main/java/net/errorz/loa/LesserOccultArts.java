package net.errorz.loa;

import net.errorz.loa.block.LesserOccultArtsBlocks;
import net.errorz.loa.effect.LesserOccultArtsEffects;
import net.errorz.loa.event.PlayerTempBanEvent;
import net.errorz.loa.item.LesserOccultArtsItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LesserOccultArts implements ModInitializer {
	public static final String MOD_ID = "loa";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LesserOccultArtsItems.registerModItems();
		LesserOccultArtsBlocks.registerModBlocks();
		LesserOccultArtsEffects.registerEffects();

		//AttackEntityCallback.EVENT.register(new PlayerTempBanEvent());
	}
}