package net.mufaro.femboymod.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.mufaro.femboymod.item.ModItems;
import net.mufaro.femboymod.sound.ModSounds;


public class AstolfiumSword extends SwordItem {

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(!target.level.isClientSide()) {
            ((ServerPlayer) attacker).getLevel().playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), ModSounds.astolfoUwu.get(), SoundSource.BLOCKS, 1f, 1f);
        }
        return super.hurtEnemy(stack, target, attacker);
    }



    public AstolfiumSword(Properties properties) {
        super(ModItems.Tiers.ASTOLFIUM_TIER, 5, 1f, properties);
    }

}
