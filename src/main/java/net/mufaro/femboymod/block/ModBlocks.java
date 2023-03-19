package net.mufaro.femboymod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mufaro.femboymod.FemboyMod;
import net.mufaro.femboymod.item.ModItems;
import java.util.function.Supplier;
import net.mufaro.femboymod.item.ModCreativeModTab;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FemboyMod.MOD_ID);

    private static final RegistryObject<Block> ASTOLFIUM_BLOCK = register("astolfium_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1f).requiresCorrectToolForDrops()), ModCreativeModTab.MOD_TAB);

    public static final RegistryObject<Block> ASTOLFIUM_ORE = register("astolfium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModTab.MOD_TAB);
    public static final RegistryObject<Block> DEEPSLATE_ASTOLFIUM_ORE = register("deepslate_astolfium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModTab.MOD_TAB);

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> ret = BLOCKS.register(name, block);
        registerBlockItem(name, ret, tab);
        return ret;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
