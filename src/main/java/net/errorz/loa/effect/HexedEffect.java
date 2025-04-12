package net.errorz.loa.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class HexedEffect extends StatusEffect {

    protected HexedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
