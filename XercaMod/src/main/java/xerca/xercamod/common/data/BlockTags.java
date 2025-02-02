package xerca.xercamod.common.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xerca.xercamod.common.XercaMod;
import xerca.xercamod.common.block.Blocks;

public class BlockTags extends BlockTagsProvider implements DataProvider
{
    public BlockTags(DataGenerator gen, ExistingFileHelper existingFileHelper)
    {
        super(gen, XercaMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        this.tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(
                Blocks.BLOCK_BOOKCASE,
                Blocks.CARVING_STATION,
                Blocks.CARVED_OAK_1,
                Blocks.CARVED_OAK_2,
                Blocks.CARVED_OAK_3,
                Blocks.CARVED_OAK_4,
                Blocks.CARVED_OAK_5,
                Blocks.CARVED_OAK_6,
                Blocks.CARVED_OAK_7,
                Blocks.CARVED_OAK_8,
                Blocks.CARVED_BIRCH_1,
                Blocks.CARVED_BIRCH_2,
                Blocks.CARVED_BIRCH_3,
                Blocks.CARVED_BIRCH_4,
                Blocks.CARVED_BIRCH_5,
                Blocks.CARVED_BIRCH_6,
                Blocks.CARVED_BIRCH_7,
                Blocks.CARVED_BIRCH_8,
                Blocks.CARVED_DARK_OAK_1,
                Blocks.CARVED_DARK_OAK_2,
                Blocks.CARVED_DARK_OAK_3,
                Blocks.CARVED_DARK_OAK_4,
                Blocks.CARVED_DARK_OAK_5,
                Blocks.CARVED_DARK_OAK_6,
                Blocks.CARVED_DARK_OAK_7,
                Blocks.CARVED_DARK_OAK_8,
                Blocks.CARVED_ACACIA_1,
                Blocks.CARVED_ACACIA_2,
                Blocks.CARVED_ACACIA_3,
                Blocks.CARVED_ACACIA_4,
                Blocks.CARVED_ACACIA_5,
                Blocks.CARVED_ACACIA_6,
                Blocks.CARVED_ACACIA_7,
                Blocks.CARVED_ACACIA_8,
                Blocks.CARVED_JUNGLE_1,
                Blocks.CARVED_JUNGLE_2,
                Blocks.CARVED_JUNGLE_3,
                Blocks.CARVED_JUNGLE_4,
                Blocks.CARVED_JUNGLE_5,
                Blocks.CARVED_JUNGLE_6,
                Blocks.CARVED_JUNGLE_7,
                Blocks.CARVED_JUNGLE_8,
                Blocks.CARVED_SPRUCE_1,
                Blocks.CARVED_SPRUCE_2,
                Blocks.CARVED_SPRUCE_3,
                Blocks.CARVED_SPRUCE_4,
                Blocks.CARVED_SPRUCE_5,
                Blocks.CARVED_SPRUCE_6,
                Blocks.CARVED_SPRUCE_7,
                Blocks.CARVED_SPRUCE_8,
                Blocks.CARVED_CRIMSON_1,
                Blocks.CARVED_CRIMSON_2,
                Blocks.CARVED_CRIMSON_3,
                Blocks.CARVED_CRIMSON_4,
                Blocks.CARVED_CRIMSON_5,
                Blocks.CARVED_CRIMSON_6,
                Blocks.CARVED_CRIMSON_7,
                Blocks.CARVED_CRIMSON_8,
                Blocks.CARVED_WARPED_1,
                Blocks.CARVED_WARPED_2,
                Blocks.CARVED_WARPED_3,
                Blocks.CARVED_WARPED_4,
                Blocks.CARVED_WARPED_5,
                Blocks.CARVED_WARPED_6,
                Blocks.CARVED_WARPED_7,
                Blocks.CARVED_WARPED_8
        );
        this.tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(
                Blocks.OMNI_CHEST,

                Blocks.VAT,
                Blocks.VAT_MILK,
                Blocks.VAT_CHEESE,

                Blocks.BLACK_TERRATILE,
                Blocks.BLUE_TERRATILE,
                Blocks.BROWN_TERRATILE,
                Blocks.CYAN_TERRATILE,
                Blocks.GRAY_TERRATILE,
                Blocks.GREEN_TERRATILE,
                Blocks.LIGHT_BLUE_TERRATILE,
                Blocks.LIGHT_GRAY_TERRATILE,
                Blocks.LIME_TERRATILE,
                Blocks.MAGENTA_TERRATILE,
                Blocks.ORANGE_TERRATILE,
                Blocks.PINK_TERRATILE,
                Blocks.PURPLE_TERRATILE,
                Blocks.RED_TERRATILE,
                Blocks.WHITE_TERRATILE,
                Blocks.YELLOW_TERRATILE,
                Blocks.TERRATILE,
                Blocks.BLACK_TERRATILE_SLAB,
                Blocks.BLUE_TERRATILE_SLAB,
                Blocks.BROWN_TERRATILE_SLAB,
                Blocks.CYAN_TERRATILE_SLAB,
                Blocks.GRAY_TERRATILE_SLAB,
                Blocks.GREEN_TERRATILE_SLAB,
                Blocks.LIGHT_BLUE_TERRATILE_SLAB,
                Blocks.LIGHT_GRAY_TERRATILE_SLAB,
                Blocks.LIME_TERRATILE_SLAB,
                Blocks.MAGENTA_TERRATILE_SLAB,
                Blocks.ORANGE_TERRATILE_SLAB,
                Blocks.PINK_TERRATILE_SLAB,
                Blocks.PURPLE_TERRATILE_SLAB,
                Blocks.RED_TERRATILE_SLAB,
                Blocks.WHITE_TERRATILE_SLAB,
                Blocks.YELLOW_TERRATILE_SLAB,
                Blocks.TERRATILE_SLAB,
                Blocks.BLACK_TERRATILE_STAIRS,
                Blocks.BLUE_TERRATILE_STAIRS,
                Blocks.BROWN_TERRATILE_STAIRS,
                Blocks.CYAN_TERRATILE_STAIRS,
                Blocks.GRAY_TERRATILE_STAIRS,
                Blocks.GREEN_TERRATILE_STAIRS,
                Blocks.LIGHT_BLUE_TERRATILE_STAIRS,
                Blocks.LIGHT_GRAY_TERRATILE_STAIRS,
                Blocks.LIME_TERRATILE_STAIRS,
                Blocks.MAGENTA_TERRATILE_STAIRS,
                Blocks.ORANGE_TERRATILE_STAIRS,
                Blocks.PINK_TERRATILE_STAIRS,
                Blocks.PURPLE_TERRATILE_STAIRS,
                Blocks.RED_TERRATILE_STAIRS,
                Blocks.WHITE_TERRATILE_STAIRS,
                Blocks.YELLOW_TERRATILE_STAIRS,
                Blocks.TERRATILE_STAIRS
        );
        this.tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_HOE).add(
                Blocks.BLOCK_LEATHER,
                Blocks.BLOCK_STRAW
        );
    }
}