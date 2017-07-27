package shadows.nature.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPowder extends Item {
	@SideOnly(Side.CLIENT)
	private IIcon[] powderIcons;

	public ItemPowder() {
		super();
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return this.powderIcons[i];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.powderIcons = new IIcon[4];

		this.powderIcons[0] = par1IconRegister.registerIcon("forgottennature:PowderSulfur");
		this.powderIcons[1] = par1IconRegister.registerIcon("forgottennature:PowderNitre");
		this.powderIcons[2] = par1IconRegister.registerIcon("forgottennature:PowderNetherrot");
		this.powderIcons[3] = par1IconRegister.registerIcon("forgottennature:PowderSoulDust");
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer entityplayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		byte var8 = 0;
		ItemStack equipped = entityplayer.getCurrentEquippedItem();
		Block blk = world.getBlock(par4, par5, par6);
		if (blk == Blocks.dirt || blk == Blocks.grass) {
			if ((equipped.getItemDamage() == 2)) {
				world.setBlock(par4, par5, par6, Blocks.netherrack, 0, 3);
				equipped.stackSize -= 1;
			}
			if ((equipped.getItemDamage() == 3)) {
				world.setBlock(par4, par5, par6, Blocks.soul_sand, 0, 3);
				equipped.stackSize -= 1;
			}
			return true;
		} else
			return false;
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item i, CreativeTabs tabs, List list) {
		for (int j = 0; j < 4; j++) {
			list.add(new ItemStack(i, 1, j));
		}
	}

	public String getUnlocalizedName(ItemStack i) {
		switch (i.getItemDamage()) {
		case 0:
			return "sulfur";
		case 1:
			return "nitre";
		case 2:
			return "netherrot";
		case 3:
			return "soulDust";
		default:
			return "";
		}
	}
}
