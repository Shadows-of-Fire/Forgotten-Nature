package shadows.nature.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;

public class ItemNewCropSeeds extends Item {
	@SideOnly(Side.CLIENT)
	private IIcon seedIcon;

	/** BlockID of the block the seeds can be planted on. */
	private Block soilBlock;

	public ItemNewCropSeeds(Block par7) {
		super();
		this.soilBlock = par7;
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return this.seedIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.seedIcon = par1IconRegister.registerIcon("forgottennature:Seed");
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer par2EntityPlayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (par7 != 1)
			return false;
		else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, itemstack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, itemstack)) {
			Block var8 = world.getBlock(par4, par5, par6);
			if (var8 == this.soilBlock && world.isAirBlock(par4, par5 + 1, par6)) {
				if (itemstack.getItemDamage() == 0)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.kCelOniGar, 0, 3);// kcelery
				else if (itemstack.getItemDamage() == 1)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.hempCotBamCorn, 0, 3);// corn
				else if (itemstack.getItemDamage() == 2)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.hempCotBamCorn, 4, 3);// cotton
				else if (itemstack.getItemDamage() == 3)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.parsWChestRiceBrocc, 12, 3);// rice
				else if (itemstack.getItemDamage() == 4)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.grapeTomCabPine, 0, 3);// tomato
				else if (itemstack.getItemDamage() == 5)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.grapeTomCabPine, 4, 3);// cabbage
				else if (itemstack.getItemDamage() == 6)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.grapeTomCabPine, 8, 3);// pineapple
				else if (itemstack.getItemDamage() == 7)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.grapeTomCabPine, 12, 3);// grapes
				else if (itemstack.getItemDamage() == 8)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.hempCotBamCorn, 12, 3);// hemp
				else if (itemstack.getItemDamage() == 9)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.parsWChestRiceBrocc, 4, 3);// broccoli
				else
					world.setBlock(par4, par5 + 1, par6, FNBlocks.parsWChestRiceBrocc, 0, 3);// parsley
				--itemstack.stackSize;
				return true;
			} else
				return false;
		} else
			return false;
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item i, CreativeTabs tabs, List list) {
		for (int j = 0; j < 11; j++) {
			list.add(new ItemStack(i, 1, j));
		}
	}

	public String getUnlocalizedName(ItemStack i) {
		switch (i.getItemDamage()) {
		case 0:
			return "celerySeeds";
		case 1:
			return "cornSeeds";
		case 2:
			return "cottonSeeds";
		case 3:
			return "riceSeeds";
		case 4:
			return "tomatoSeeds";
		case 5:
			return "cabbageSeeds";
		case 6:
			return "pineappleSeeds";
		case 7:
			return "grapesSeeds";
		case 8:
			return "hempSeeds";
		case 9:
			return "broccoliSeeds";
		case 10:
			return "parsleySeeds";
		default:
			return "";
		}
	}
}
