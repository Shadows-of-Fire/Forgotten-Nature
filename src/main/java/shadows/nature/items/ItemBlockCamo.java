package shadows.nature.Items;

import ForgottenNature.TileEntities.TileEntityCamo;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import shadows.nature.FNBlocks;

public class ItemBlockCamo extends ItemBlock {
	public ItemBlockCamo(Block i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public IIcon getIconFromDamage(int i) {
		return FNBlocks.camo.getIcon(0, i);
	}

	public boolean onItemUse(ItemStack iStack, EntityPlayer entityPlayer, World world, int i, int j, int k, int side,
			float par8, float par9, float par10) {
		Block blk = world.getBlock(i, j, k);
		int met = world.getBlockMetadata(i, j, k);
		int renderCase;
		TileEntityCamo tec = (TileEntityCamo) world.getTileEntity(i, j, k);

		if (blk == Blocks.stone)
			renderCase = 1;
		else if (blk == Blocks.grass)
			renderCase = 2;
		else if (blk == Blocks.dirt)
			renderCase = 3;
		else if (blk == Blocks.cobblestone)
			renderCase = 4;
		else if (blk == Blocks.planks && met == 0)
			renderCase = 5;
		else if (blk == Blocks.planks && met == 1)
			renderCase = 6;
		else if (blk == Blocks.planks && met == 2)
			renderCase = 7;
		else if (blk == Blocks.planks && met == 3)
			renderCase = 8;
		else if (blk == Blocks.planks && met == 4)
			renderCase = 9;
		else if (blk == Blocks.planks && met == 5)
			renderCase = 10;
		else if (blk == Blocks.sand)
			renderCase = 11;
		else if (blk == Blocks.gravel)
			renderCase = 12;
		else if (blk == Blocks.log && met == 0)
			renderCase = 13;
		else if (blk == Blocks.log && met == 1)
			renderCase = 14;
		else if (blk == Blocks.log && met == 2)
			renderCase = 15;
		else if (blk == Blocks.log && met == 3)
			renderCase = 16;
		else if (blk == Blocks.sandstone)
			renderCase = 17;
		else if (blk == Blocks.brick_block)
			renderCase = 18;
		else if (blk == Blocks.nether_brick)
			renderCase = 19;
		else if (blk == Blocks.stonebrick)
			renderCase = 20;
		else if (blk == Blocks.mossy_cobblestone)
			renderCase = 21;
		else if (blk == Blocks.obsidian)
			renderCase = 22;
		else if (blk == Blocks.snow)
			renderCase = 23;
		else if (blk == Blocks.ice)
			renderCase = 24;
		else if (blk == Blocks.netherrack)
			renderCase = 25;
		else if (blk == Blocks.soul_sand)
			renderCase = 26;
		else if (blk == Blocks.glowstone)
			renderCase = 27;
		else if (blk == Blocks.mycelium)
			renderCase = 28;
		else if (blk == Blocks.hay_block)
			renderCase = 29;
		else if (blk == Blocks.packed_ice)
			renderCase = 30;
		else if (blk == Blocks.log2 && met == 0)
			renderCase = 31;
		else if (blk == Blocks.log2 && met == 1)
			renderCase = 32;
		else if (blk == FNBlocks.newLogs1 && met == 0)
			renderCase = 33;
		else if (blk == FNBlocks.newLogs1 && met == 2)
			renderCase = 34;
		else if (blk == FNBlocks.newLogs1 && met == 4)
			renderCase = 35;
		else if (blk == FNBlocks.newLogs1 && met == 6)
			renderCase = 36;
		else if (blk == FNBlocks.newLogs1 && met == 10)
			renderCase = 37;
		else if (blk == FNBlocks.newLogs1 && met == 12)
			renderCase = 38;
		else if (blk == FNBlocks.newLogs2 && met == 0)
			renderCase = 39;
		else if (blk == FNBlocks.newLogs2 && met == 2)
			renderCase = 40;
		else if (blk == FNBlocks.newLogs2 && met == 4)
			renderCase = 41;
		else if (blk == FNBlocks.newLogs2 && met == 6)
			renderCase = 42;
		else if (blk == FNBlocks.newLogs2 && met == 8)
			renderCase = 43;
		else if (blk == FNBlocks.newLogs2 && met == 14)
			renderCase = 44;
		else if (blk == FNBlocks.newLogs3 && met == 0)
			renderCase = 45;
		else if (blk == FNBlocks.newLogs3 && met == 1)
			renderCase = 46;
		else if (blk == FNBlocks.newLogs3 && met == 2)
			renderCase = 47;
		else if (blk == FNBlocks.newLogs3 && met == 3)
			renderCase = 48;
		else if (blk == FNBlocks.newLogs3 && met == 4)
			renderCase = 49;
		else if (blk == FNBlocks.netherLogs && met == 0)
			renderCase = 50;
		else if (blk == FNBlocks.netherLogs && met == 1)
			renderCase = 51;
		else if (blk == FNBlocks.netherLogs && met == 2)
			renderCase = 52;
		else if (blk == FNBlocks.netherLogs && met == 3)
			renderCase = 53;
		else if (blk == FNBlocks.newPlanks1 && met == 0)
			renderCase = 54;
		else if (blk == FNBlocks.newPlanks1 && met == 1)
			renderCase = 55;
		else if (blk == FNBlocks.newPlanks1 && met == 2)
			renderCase = 56;
		else if (blk == FNBlocks.newPlanks1 && met == 3)
			renderCase = 57;
		else if (blk == FNBlocks.newPlanks1 && met == 4)
			renderCase = 58;
		else if (blk == FNBlocks.newPlanks1 && met == 5)
			renderCase = 59;
		else if (blk == FNBlocks.newPlanks1 && met == 6)
			renderCase = 60;
		else if (blk == FNBlocks.newPlanks1 && met == 7)
			renderCase = 61;
		else if (blk == FNBlocks.newPlanks1 && met == 9)
			renderCase = 62;
		else if (blk == FNBlocks.newPlanks1 && met == 10)
			renderCase = 63;
		else if (blk == FNBlocks.newPlanks1 && met == 11)
			renderCase = 64;
		else if (blk == FNBlocks.newPlanks1 && met == 12)
			renderCase = 65;
		else if (blk == FNBlocks.newPlanks1 && met == 13)
			renderCase = 66;
		else if (blk == FNBlocks.newPlanks1 && met == 14)
			renderCase = 67;
		else if (blk == FNBlocks.newPlanks2 && met == 0)
			renderCase = 68;
		else if (blk == FNBlocks.newPlanks2 && met == 1)
			renderCase = 69;
		else if (blk == FNBlocks.newPlanks2 && met == 2)
			renderCase = 70;
		else if (blk == FNBlocks.newPlanks2 && met == 3)
			renderCase = 71;
		else if (blk == FNBlocks.newPlanks2 && met == 4)
			renderCase = 72;
		else if (blk == FNBlocks.newPlanks2 && met == 5)
			renderCase = 73;
		else if (blk == FNBlocks.newPlanks2 && met == 6)
			renderCase = 74;
		else if (blk == Block.getBlockFromItem(this))
			renderCase = tec.getBlockMetadata();
		else
			renderCase = 0;

		if (side == 0)// bottom
		{
			world.setBlock(i, j - 1, k, Block.getBlockFromItem(this), renderCase, 3);
		} else if (side == 1)// top
		{
			world.setBlock(i, j + 1, k, Block.getBlockFromItem(this), renderCase, 3);
		} else if (side == 2)//
		{
			world.setBlock(i, j, k - 1, Block.getBlockFromItem(this), renderCase, 3);
		} else if (side == 3)//
		{
			world.setBlock(i, j, k + 1, Block.getBlockFromItem(this), renderCase, 3);
		} else if (side == 4)//
		{
			world.setBlock(i - 1, j, k, Block.getBlockFromItem(this), renderCase, 3);
		} else if (side == 5)//
		{
			world.setBlock(i + 1, j, k, Block.getBlockFromItem(this), renderCase, 3);
		}

		entityPlayer.getCurrentEquippedItem().stackSize--;

		return true;
	}
}
