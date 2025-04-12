package net.errorz.loa.effect;

import net.errorz.loa.LesserOccultArts;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class LesserOccultArtsEffects {
    public static final StatusEffect Hexed = registerStatusEffect("hexed",
            new HexedEffect(StatusEffectCategory.HARMFUL, 0x530ebd)
                    .addAttributeModifier(EntityAttributes.GENERIC_LUCK,
                            "7107DE5E-7CE8-4030-940E-514C1F160890", -10.25f,
                            EntityAttributeModifier.Operation.MULTIPLY_TOTAL));




    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(LesserOccultArts.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        LesserOccultArts.LOGGER.info("Registering Mod Effects for " + LesserOccultArts.MOD_ID);
    }
}
