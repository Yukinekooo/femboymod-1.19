package net.mufaro.femboymod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.mufaro.femboymod.item.ModItems;
import net.mufaro.femboymod.sound.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.client.multiplayer.ClientLevel;

import javax.annotation.Nullable;
import java.util.List;


public class AstolfiumSword extends SwordItem {

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean willApplyEffects = Math.random() * 100 < 50;
        if(!target.level.isClientSide()) {
            if(willApplyEffects) {
                ((ServerPlayer) attacker).getLevel().playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), ModSounds.astolfoUwu.get(), SoundSource.BLOCKS, 1f, 1f);

            }
        }
        if(willApplyEffects) {
            ClientLevel world = Minecraft.getInstance().level;
            double centerX = target.getX();
            double centerY = target.getY();
            double centerZ = target.getZ();
            int numParticles = 40;
            double radius = 0.5;

            for (int i = 0; i < numParticles; i++) {
                double angle = (2*Math.PI*i)/numParticles;
                double xOffset = radius*Math.cos(angle);
                double zOffset = radius*Math.sin(angle);
                world.addParticle(ParticleTypes.CLOUD, centerX + xOffset, centerY, centerZ + zOffset, 0, 0, 0);
            }

            target.moveTo(target.getX(), target.getY() + 2, target.getZ());


        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("50% chance to apply levitation to a target").withStyle(ChatFormatting.DARK_PURPLE));
        } else {
            components.add(Component.literal("Hold LSHIFT for more info").withStyle(ChatFormatting.DARK_PURPLE));
        }
    }



    public AstolfiumSword(Properties properties) {
        super(ModItems.Tiers.ASTOLFIUM_TIER, 3, 1f, properties);
    }

}
