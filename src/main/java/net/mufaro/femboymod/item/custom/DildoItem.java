package net.mufaro.femboymod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
public class DildoItem extends Item {
    public DildoItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            player.sendSystemMessage(Component.literal(getRandomText()));
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, hand);
    }

    private String getRandomText() {
        String[] texts = {"This looks so juicy!", "I want to put this in my ass...", "That's an interesting one!", "I can imagine selffucking with it"};
        String randomText = texts[(int) (Math.random() * texts.length)];
        return randomText;
    }
}
