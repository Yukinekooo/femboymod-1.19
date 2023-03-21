package net.mufaro.femboymod.item.custom.astolfium;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.mufaro.femboymod.item.ModItems;
import net.minecraft.world.entity.item.ItemEntity;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class AstolfiumPickaxe extends PickaxeItem {

    private static final Random RANDOM = new Random();
    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity player) {
        if (!level.isClientSide && blockState.getDestroySpeed(level, blockPos) != 0.0F) {
            if(RANDOM.nextInt(100) < 10) {
                ClientLevel world = Minecraft.getInstance().level;
                double centerX = blockPos.getX();
                double centerY = blockPos.getY();
                double centerZ = blockPos.getZ();

                int numParticles = 20;

                for(int i = 0; i < numParticles; i++) {
                    double posX = centerX + (ThreadLocalRandom.current().nextDouble() - 0.5);
                    double posY = centerY + (ThreadLocalRandom.current().nextDouble() - 0.5);
                    double posZ = centerZ + (ThreadLocalRandom.current().nextDouble() - 0.5);

                    // Check if the block at the particle's position is air
                    BlockState blockState1 = world.getBlockState(new BlockPos(posX, posY, posZ));
                    if (blockState1 != null && world.isEmptyBlock(new BlockPos(posX, posY, posZ))) {
                        world.addParticle(ParticleTypes.COMPOSTER, posX, posY, posZ, 0, 0, 0);
                    }
                    else {
                        // If not air, move the particle slightly
                        posX += ThreadLocalRandom.current().nextDouble() - 0.5;
                        posY += ThreadLocalRandom.current().nextDouble() - 0.5;
                        posZ += ThreadLocalRandom.current().nextDouble() - 0.5;
                    }
                }
                Item[] oreItems = {Items.RAW_IRON, Items.RAW_GOLD, Items.DIAMOND, Items.COAL, Items.LAPIS_LAZULI};
                int randomIndex = RANDOM.nextInt(oreItems.length);
                Item randomOre = oreItems[randomIndex];
                level.addFreshEntity(new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(randomOre)));
            }
        }

        return true;
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("10% chance to get a random ore").withStyle(ChatFormatting.DARK_PURPLE));
        } else {
            components.add(Component.literal("Hold LSHIFT for more info").withStyle(ChatFormatting.DARK_PURPLE));
        }
    }

    public AstolfiumPickaxe(Item.Properties properties) {
        super(ModItems.Tiers.ASTOLFIUM_TIER, 0, 1f, properties);
    }
}
