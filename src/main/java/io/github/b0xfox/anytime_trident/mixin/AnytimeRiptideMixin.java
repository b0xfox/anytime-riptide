package io.github.b0xfox.anytime_trident.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.TridentItem;
import net.minecraft.util.Hand;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.b0xfox.anytime_trident.component.DataComponentTypes;

@Mixin(TridentItem.class)
public class AnytimeRiptideMixin {

    @Redirect(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isTouchingWaterOrRain()Z"))
    private boolean useAlwaysTouchingWaterOrRain(PlayerEntity player, Hand hand) {
        return (player.getStackInHand(hand).get(DataComponentTypes.ANYTIME_RIPTIDE) != null) || player.isTouchingWaterOrRain();
    }

    @Redirect(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isTouchingWaterOrRain()Z"))
    private boolean releaseAlwaysTouchingWaterOrRain(PlayerEntity player, Hand hand) {
        return (player.getStackInHand(hand).get(DataComponentTypes.ANYTIME_RIPTIDE) != null) || player.isTouchingWaterOrRain();
    }
}
