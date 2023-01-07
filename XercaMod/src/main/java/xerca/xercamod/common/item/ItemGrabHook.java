package xerca.xercamod.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import xerca.xercamod.common.Config;
import xerca.xercamod.common.entity.EntityHook;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

import static xerca.xercamod.common.item.Items.ENCHANTMENT_GRAPPLING;

public class ItemGrabHook extends FishingRodItem {

    public ItemGrabHook() {
        super((new Item.Properties()).defaultDurability(210));
    }

    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level worldIn, Player playerIn, @Nonnull InteractionHand hand) {
        final ItemStack heldItem = playerIn.getItemInHand(hand);
        playerIn.startUsingItem(hand);
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, heldItem);
    }

    @Override
    public void releaseUsing(@NotNull ItemStack stack, @NotNull Level worldIn, @NotNull LivingEntity entityLiving, int timeLeft) {
        float useSeconds = (this.getUseDuration(stack) - timeLeft) / 20.0f;
        if(useSeconds > 1.f) useSeconds = 1.f;

        if(useSeconds > 0.1f && entityLiving instanceof Player playerIn){
            InteractionHand hand;
            if(playerIn.getMainHandItem().getItem() instanceof ItemGrabHook){
                hand = InteractionHand.MAIN_HAND;
            }
            else if(playerIn.getOffhandItem().getItem() instanceof ItemGrabHook){
                hand = InteractionHand.OFF_HAND;
            }
            else{
                return;
            }

            final ItemStack heldItem = playerIn.getItemInHand(hand);
            playerIn.getCooldowns().addCooldown(this, 40);
            heldItem.hurtAndBreak(1, playerIn, (p) -> p.broadcastBreakEvent(hand));
            if (!worldIn.isClientSide) {
                worldIn.addFreshEntity(new EntityHook(worldIn, playerIn, heldItem, useSeconds));
            }

            playerIn.swing(hand);
        }
    }

    @Nonnull
    @Override
    public UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack) {
        return 72000;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment)
    {
        return enchantment.category == EnchantmentCategory.BREAKABLE || enchantment == Items.ENCHANTMENT_GRAPPLING.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, @NotNull TooltipFlag flagIn) {
        MutableComponent text = Component.translatable("xercamod.grap_hook_tooltip");
        tooltip.add(text.withStyle(ChatFormatting.BLUE));
        if(EnchantmentHelper.getItemEnchantmentLevel(ENCHANTMENT_GRAPPLING.get(), stack) > 0){
            MutableComponent textGrappling = Component.translatable("xercamod.grappling_tooltip");
            tooltip.add(textGrappling.withStyle(ChatFormatting.YELLOW));
        }
    }
    @Override
    public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType)
    {
        return 300;
    }
}
