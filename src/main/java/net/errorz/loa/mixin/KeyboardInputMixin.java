package net.errorz.loa.mixin;

import net.errorz.loa.effect.LesserOccultArtsEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;

@Mixin({KeyboardInput.class})
public class KeyboardInputMixin {
    public KeyboardInputMixin() {
    }

    @Inject(
            method = {"getMovementMultiplier"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private static void movementMultiplierInjector(boolean positive, boolean negative, CallbackInfoReturnable<Float> info) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null) {
            boolean hasHexed = false;
            Iterator var5 = player.getStatusEffects().iterator();

            while(var5.hasNext()) {
                StatusEffectInstance effects = (StatusEffectInstance)var5.next();
                if (effects.getEffectType() == LesserOccultArtsEffects.Hexed) {
                    hasHexed = true;
                }
            }

            if (hasHexed) {
                if (positive == negative) {
                    info.setReturnValue(0.0F);
                } else {
                    info.setReturnValue(positive ? -1.0F : 1.0F);
                }
            }

        }
    }
}
