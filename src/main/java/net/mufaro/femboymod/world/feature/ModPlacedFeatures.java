package net.mufaro.femboymod.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mufaro.femboymod.FemboyMod;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, FemboyMod.MOD_ID);

    public static final RegistryObject<PlacedFeature> ASTOLFIUM_ORE_PLACED = PLACED_FEATURES.register("astolfium_ore_placed", () -> new PlacedFeature(ModConfiguredFeatures.ASTOLFIUM_ORE.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static List<PlacementModifier> orePlacement(PlacementModifier pm1, PlacementModifier pm2) {
        return List.of(pm1, InSquarePlacement.spread(),pm2, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int x, PlacementModifier pm) {
        return orePlacement(CountPlacement.of(x), pm);
    }

    public static List<PlacementModifier> rareOrePlacement(int x, PlacementModifier pm) {
        return orePlacement(RarityFilter.onAverageOnceEvery(x), pm);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
