package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import shadows.ancient.FNBlocks;

public class ItemRope extends Item {

	public ItemRope() {
		setHasSubtypes(true);
		setMaxStackSize(64);
		setTextureName("forgottennature:Rope");
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer entityplayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		int var8 = 0;
		Block blk = world.getBlock(par4, par5, par6);
		if (blk == Blocks.cobblestone || blk == Blocks.mossy_cobblestone || blk == Blocks.stone || blk == Blocks.stonebrick || blk == Blocks.sandstone || blk == FNBlocks.newStones) {
			switch (par7) {
			case 2:
				if (entityplayer.canPlayerEdit(par4, par5, par6 - 1, par7, par1ItemStack))
					var8 = 1;
				for (int y = 0; y < 256; y++) {
					if (world.getBlock(par4, par5 - y, par6 - 1) == Blocks.air)
						world.setBlock(par4, par5 - y, par6 - 1, FNBlocks.rope, var8, 3);
					else
						y = 300;
				}
				break;
			case 3:
				if (entityplayer.canPlayerEdit(par4, par5, par6 + 1, par7, par1ItemStack))
					var8 = 4;
				for (int y = 0; y < 256; y++) {
					if (world.getBlock(par4, par5 - y, par6 + 1) == Blocks.air)
						world.setBlock(par4, par5 - y, par6 + 1, FNBlocks.rope, var8, 3);
					else
						y = 300;
				}
				break;
			case 4:
				if (entityplayer.canPlayerEdit(par4 - 1, par5, par6, par7, par1ItemStack))
					var8 = 8;
				for (int y = 0; y < 256; y++) {
					if (world.getBlock(par4 - 1, par5 - y, par6) == Blocks.air)
						world.setBlock(par4 - 1, par5 - y, par6, FNBlocks.rope, var8, 3);
					else
						y = 300;
				}
				break;
			case 5:
				if (entityplayer.canPlayerEdit(par4 + 1, par5, par6, par7, par1ItemStack))
					var8 = 2;
				for (int y = 0; y < 256; y++) {
					if (world.getBlock(par4 + 1, par5 - y, par6) == Blocks.air)
						world.setBlock(par4 + 1, par5 - y, par6, FNBlocks.rope, var8, 3);
					else
						y = 300;
				}
			}
			--par1ItemStack.stackSize;
			return true;
		} else
			return false;
	}
}
