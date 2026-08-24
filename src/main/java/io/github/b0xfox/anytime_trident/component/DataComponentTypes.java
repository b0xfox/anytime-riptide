package io.github.b0xfox.anytime_trident.component;

import java.util.function.UnaryOperator;

import io.github.b0xfox.anytime_trident.AnytimeRiptide;
import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;

public class DataComponentTypes {

    public static final ComponentType<Unit> ANYTIME_RIPTIDE = register("anytime_riptide", builder -> builder.codec(Unit.CODEC).packetCodec(PacketCodec.unit(Unit.INSTANCE)));

    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of("minecraft", name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        AnytimeRiptide.LOGGER.info("Registering Data Component Types for " + AnytimeRiptide.MOD_ID);
    }
}
