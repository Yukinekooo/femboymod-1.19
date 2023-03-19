package net.mufaro.femboymod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab MOD_TAB = new CreativeModeTab("femboymod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ASTOLFIUM.get());
        }
    };
}
