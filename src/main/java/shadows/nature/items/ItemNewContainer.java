package shadows.nature.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNBlocks;

public class ItemNewContainer extends Item {
	@SideOnly(Side.CLIENT)
	private IIcon[] containerIcons;

	public ItemNewContainer() {
		super();
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
		setContainerItem(Items.bucket);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return this.containerIcons[i];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.containerIcons = new IIcon[11];

		this.containerIcons[0] = par1IconRegister.registerIcon("forgottennature:OilBucket");
		this.containerIcons[2] = par1IconRegister.registerIcon("forgottennature:StainBrown");
		this.containerIcons[3] = par1IconRegister.registerIcon("forgottennature:StainPurple");
		this.containerIcons[4] = par1IconRegister.registerIcon("forgottennature:StainDarkRed");
		this.containerIcons[5] = par1IconRegister.registerIcon("forgottennature:StainDarkYellow");
		this.containerIcons[6] = par1IconRegister.registerIcon("forgottennature:StainPeach");
		this.containerIcons[7] = par1IconRegister.registerIcon("forgottennature:StainOrange");
		this.containerIcons[8] = par1IconRegister.registerIcon("forgottennature:StainRedwood");
		this.containerIcons[9] = par1IconRegister.registerIcon("forgottennature:StainBrightYellow");
	}

	public boolean onItemUse(ItemStack iStack, EntityPlayer ePlayer, World world, int x, int y, int z, int dir,
			float p_8_, float p_9_, float p_10_) {
		int xp = 0;
		int yp = 0;
		int zp = 0;

		if (dir == 0)
			yp = -1;
		if (dir == 1)
			yp = 1;
		if (dir == 2)
			zp = -1;
		if (dir == 3)
			zp = 1;
		if (dir == 4)
			xp = -1;
		if (dir == 5)
			xp = 1;

		if (iStack.getItemDamage() == 0) {
			world.setBlock(x + xp, y + yp, z + zp, FNBlocks.oilBlock);
			ePlayer.getCurrentEquippedItem().stackSize -= 1;
			ePlayer.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
			return true;
		} else
			return false;
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item i, CreativeTabs tabs, List list) {
		list.add(new ItemStack(i, 1, 0));

		for (int j = 2; j < 10; j++) {
			list.add(new ItemStack(i, 1, j));
		}
	}

	public String getUnlocalizedName(ItemStack i) {
		switch (i.getItemDamage()) {
		case 0:
			return "oil";
		case 1:
			return "emptystain";
		case 2:
			return "brownStain";
		case 3:
			return "pplStain";
		case 4:
			return "darkRedStain";
		case 5:
			return "darkYellowStain";
		case 6:
			return "peachStain";
		case 7:
			return "orangeStain";
		case 8:
			return "redwoodStain";
		case 9:
			return "brightYellowStain";
		default:
			return "";
		}
	}
}
