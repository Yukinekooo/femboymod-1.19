package net.mufaro.femboymod.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mufaro.femboymod.FemboyMod;
import net.mufaro.femboymod.item.custom.astolfium.AstolfiumPickaxe;
import net.mufaro.femboymod.item.custom.astolfium.AstolfiumSword;
import net.mufaro.femboymod.item.custom.DildoItem;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FemboyMod.MOD_ID);

    public static final RegistryObject<Item> ASTOLFIUM = ITEMS.register("astolfium", () -> new Item(new Item.Properties().tab(ModCreativeModTab.MOD_TAB)));
    public static final RegistryObject<Item> RAW_ASTOLFIUM = ITEMS.register("raw_astolfium", () -> new Item(new Item.Properties().tab(ModCreativeModTab.MOD_TAB)));

    public static final RegistryObject<Item> DILDO = ITEMS.register("dildo", () -> new DildoItem(new Item.Properties().tab(ModCreativeModTab.MOD_TAB).stacksTo(1)));
    public static final RegistryObject<Item> ASTOLFIUM_SWORD = ITEMS.register("astolfium_sword", () -> new AstolfiumSword(new Item.Properties().tab(ModCreativeModTab.MOD_TAB).stacksTo(1)));
    public static final RegistryObject<Item> ASTOLFIUM_PICKAXE = ITEMS.register("astolfium_pickaxe", () -> new AstolfiumPickaxe(new Item.Properties().tab(ModCreativeModTab.MOD_TAB).stacksTo(1)));
    public static final RegistryObject<Item> ASTOLFIUM_HELMET = ITEMS.register("astolfium_helmet", () -> new ArmorItem(ModArmorMaterials.ASTOLFIUM, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModTab.MOD_TAB)));
    public static final RegistryObject<Item> ASTOLFIUM_CHESTPLATE = ITEMS.register("astolfium_chestplate", () -> new ArmorItem(ModArmorMaterials.ASTOLFIUM, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModTab.MOD_TAB)));
    public static final RegistryObject<Item> ASTOLFIUM_LEGGING = ITEMS.register("astolfium_leggings", () -> new ArmorItem(ModArmorMaterials.ASTOLFIUM, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModTab.MOD_TAB)));
    public static final RegistryObject<Item> ASTOLFIUM_BOOTS = ITEMS.register("astolfium_boots", () -> new ArmorItem(ModArmorMaterials.ASTOLFIUM, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModTab.MOD_TAB)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static class Tiers {
        public static final Tier ASTOLFIUM_TIER = new ForgeTier(3,1400,10.5f,3,350,null, () -> Ingredient.of(ModItems.ASTOLFIUM.get()));
    }
}

