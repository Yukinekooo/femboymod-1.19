package net.mufaro.femboymod.item;

import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mufaro.femboymod.FemboyMod;
import net.mufaro.femboymod.item.custom.AstolfiumSword;
import net.mufaro.femboymod.item.custom.DildoItem;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FemboyMod.MOD_ID);

    public static final RegistryObject<Item> ASTOLFIUM = ITEMS.register("astolfium", () -> new Item(new Item.Properties().tab(ModCreativeModTab.MOD_TAB)));
    public static final RegistryObject<Item> RAW_ASTOLFIUM = ITEMS.register("raw_astolfium", () -> new Item(new Item.Properties().tab(ModCreativeModTab.MOD_TAB)));

    public static final RegistryObject<Item> DILDO = ITEMS.register("dildo", () -> new DildoItem(new Item.Properties().tab(ModCreativeModTab.MOD_TAB).stacksTo(1)));
    public static final RegistryObject<Item> ASTOLFIUM_SWORD = ITEMS.register("astolfium_sword", () -> new AstolfiumSword(new Item.Properties().tab(ModCreativeModTab.MOD_TAB).stacksTo(1)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static class Tiers {
        public static final Tier ASTOLFIUM_TIER = new ForgeTier(1,1400,1.5f,3,350,null, () -> Ingredient.of(ModItems.ASTOLFIUM.get()));
    }
}

