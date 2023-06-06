package xerca.xercapaint.common;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.PacketDistributor;
import xerca.xercapaint.common.item.ItemCanvas;
import xerca.xercapaint.common.item.ItemPalette;
import xerca.xercapaint.common.item.Items;
import xerca.xercapaint.common.packets.ImportPaintingPacket;

import java.util.Objects;

public class CommandImport {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("paintimport")
                        .then(Commands.argument("name", StringArgumentType.word())
                                .executes((p) -> paintImport(p.getSource(), StringArgumentType.getString(p, "name"))))
        );
    }

    private static int paintImport(CommandSourceStack stack, String name){
        XercaPaint.LOGGER.debug("Paint import called. name: " + name);

        ImportPaintingPacket pack = new ImportPaintingPacket(name);
        try {
            ServerPlayer player = stack.getPlayerOrException();
            XercaPaint.NETWORK_HANDLER.send(PacketDistributor.PLAYER.with(() -> player), pack);
        } catch (CommandSyntaxException e) {
            XercaPaint.LOGGER.debug("Command executor is not a player");
            e.printStackTrace();
            return 0;
        }

        return 1;
    }

    public static void doImport(CompoundTag tag, ServerPlayer player){
        byte canvasType = tag.getByte("ct");
        tag.remove("ct");
        if(tag.getInt("generation") > 0){
            tag.putInt("generation", tag.getInt("generation") + 1);
        }

        if(player.isCreative()){
            ItemStack itemStack;
            switch (CanvasType.fromByte(canvasType)){
                case SMALL -> itemStack = new ItemStack(Items.ITEM_CANVAS);
                case TALL -> itemStack = new ItemStack(Items.ITEM_CANVAS_TALL);
                case LONG -> itemStack = new ItemStack(Items.ITEM_CANVAS_LONG);
                case LARGE -> itemStack = new ItemStack(Items.ITEM_CANVAS_LARGE);
                case X3Y2 -> itemStack = new ItemStack(Items.ITEM_CANVAS_X3Y2);
                case X3Y3 -> itemStack = new ItemStack(Items.ITEM_CANVAS_X3Y3);
                case X4Y2 -> itemStack = new ItemStack(Items.ITEM_CANVAS_X4Y2);
                case X4Y3 -> itemStack = new ItemStack(Items.ITEM_CANVAS_X4Y3);
                case X4Y4 -> itemStack = new ItemStack(Items.ITEM_CANVAS_X4Y4);
                default -> {
                    XercaPaint.LOGGER.error("Invalid canvas type");
                    return;
                }
            }
            itemStack.setTag(tag);
            player.addItem(itemStack);
        }
        else{
            ItemStack mainHand = player.getMainHandItem();
            ItemStack offhand = player.getOffhandItem();

            if(!(mainHand.getItem() instanceof ItemCanvas) || (mainHand.hasTag() && mainHand.getTag() != null && !mainHand.getTag().isEmpty())){
                player.sendMessage(new TranslatableComponent("import.fail.1").withStyle(ChatFormatting.RED), Util.NIL_UUID);
                return;
            }
            if(((ItemCanvas)mainHand.getItem()).getCanvasType() != CanvasType.fromByte(canvasType)){
                Component type = Objects.requireNonNull(Items.ITEM_CANVAS).getName(ItemStack.EMPTY);
                switch (CanvasType.fromByte(canvasType)){
                    case TALL -> type = Objects.requireNonNull(Items.ITEM_CANVAS_TALL).getName(ItemStack.EMPTY);
                    case LONG -> type = Objects.requireNonNull(Items.ITEM_CANVAS_LONG).getName(ItemStack.EMPTY);
                    case LARGE -> type = Objects.requireNonNull(Items.ITEM_CANVAS_LARGE).getName(ItemStack.EMPTY);
                    case X3Y2 -> type = Objects.requireNonNull(Items.ITEM_CANVAS_X3Y2).getName(ItemStack.EMPTY);
                    case X3Y3 -> type = Objects.requireNonNull(Items.ITEM_CANVAS_X3Y3).getName(ItemStack.EMPTY);
                    case X4Y2 -> type = Objects.requireNonNull(Items.ITEM_CANVAS_X4Y2).getName(ItemStack.EMPTY);
                    case X4Y3 -> type = Objects.requireNonNull(Items.ITEM_CANVAS_X4Y3).getName(ItemStack.EMPTY);
                    case X4Y4 -> type = Objects.requireNonNull(Items.ITEM_CANVAS_X4Y4).getName(ItemStack.EMPTY);
                }
                player.sendMessage(new TranslatableComponent("import.fail.2", type).withStyle(ChatFormatting.RED), Util.NIL_UUID);
                return;
            }
            if(!ItemPalette.isFull(offhand)){
                player.sendMessage(new TranslatableComponent("import.fail.3").withStyle(ChatFormatting.RED), Util.NIL_UUID);
                return;
            }
            mainHand.setTag(tag);
        }
        player.sendMessage(new TranslatableComponent("import.success").withStyle(ChatFormatting.GREEN), Util.NIL_UUID);
    }
}
