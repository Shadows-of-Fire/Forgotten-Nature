package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import shadows.nature.FNBlocks;

public class ItemBamboo extends ItemBlock {
	public static String[] names = { "corn1", "corn2", "corn3", "corn4", "cotton1", "cotton2", "cotton3", "cotton4",
			"bamboo1", "bamboo2", "bamboo3", "bamboo4", "hemp1", "hemp2", "hemp3", "hemp4" };

	public ItemBamboo(Block i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack p1) {
		return super.getUnlocalizedName() + "." + names[p1.getItemDamage()];
	}

	public IIcon getIconFromDamage(int i) {
		return FNBlocks.hempCotBamCorn.getIcon(0, i);
	}

	public int getMetadata(int i) {
		return i & 15;
	}

	public int getPlacedBlockMetadata(int damage) {
		return damage;
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int par4, int par5, int par6,
			int par7) {
		if (par7 != 1)
			return false;
		else if (entityplayer.canPlayerEdit(par4, par5, par6, par7, itemstack)
				&& entityplayer.canPlayerEdit(par4, par5 + 1, par6, par7, itemstack)) {
			int var8 = Block.getIdFromBlock(world.getBlock(par4, par5, par6));
			if ((var8 == 3 || var8 == 2 || var8 == Block.getIdFromBlock(FNBlocks.hempCotBamCorn))
					&& world.isAirBlock(par4, par5 + 1, par6)) {
				if (itemstack.getItemDamage() == 11)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.hempCotBamCorn, 11, 3);// turnip
				--itemstack.stackSize;
				return true;
			} else
				return false;
		} else
			return false;
	}
}
