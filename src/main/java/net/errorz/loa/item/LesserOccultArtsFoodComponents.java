package net.errorz.loa.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class LesserOccultArtsFoodComponents {
    public static final FoodComponent ABYSSAL_CRYSTAL = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1), 100f).snack( ).build();

}
