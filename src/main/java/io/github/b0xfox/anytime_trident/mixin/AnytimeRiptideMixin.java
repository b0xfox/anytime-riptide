package io.github.b0xfox.anytime_trident.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.b0xfox.anytime_trident.component.DataComponentTypes;

@Mixin(TridentItem.class)
public class AnytimeRiptideMixin {

    @Redirect(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isTouchingWaterOrRain()Z"))
    private boolean bypassWaterCheck(PlayerEntity player, World world, PlayerEntity user, Hand hand) {
        return user.getStackInHand(hand).contains(DataComponentTypes.ANYTIME_RIPTIDE) || player.isTouchingWaterOrRain();
    }

    @Redirect(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isTouchingWaterOrRain()Z"))
    private boolean bypassStoppedUsingWaterCheck(PlayerEntity player, ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        return stack.contains(DataComponentTypes.ANYTIME_RIPTIDE) || player.isTouchingWaterOrRain();
    }
}
