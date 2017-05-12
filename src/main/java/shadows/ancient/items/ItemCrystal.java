package shadows.nature.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCrystal extends Item {
	@SideOnly(Side.CLIENT)
	private IIcon[] crystalIcons;

	public ItemCrystal() {
		super();
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return this.crystalIcons[i];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.crystalIcons = new IIcon[5];

		this.crystalIcons[0] = par1IconRegister.registerIcon("forgottennature:DarkCrystalChunk");
		this.crystalIcons[1] = par1IconRegister.registerIcon("forgottennature:LightCrystalShard");
		this.crystalIcons[2] = par1IconRegister.registerIcon("forgottennature:LightCrystalChunk");
		this.crystalIcons[3] = par1IconRegister.registerIcon("forgottennature:CrystalStick");
		this.crystalIcons[4] = par1IconRegister.registerIcon("forgottennature:DarkCrystalShard");
	}

	public void addCreativeItems(ArrayList itemList) {
		for (int l1 = 0; l1 < 5; l1++) {
			itemList.add(new ItemStack(this, 1, l1));
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item i, CreativeTabs tabs, List list) {
		for (int j = 0; j < 5; j++) {
			list.add(new ItemStack(i, 1, j));
		}
	}

	public String getUnlocalizedName(ItemStack i) {
		switch (i.getItemDamage()) {
		case 0:
			return "darkCrystalChunk";
		case 1:
			return "crystalShard";
		case 2:
			return "crystalChunk";
		case 3:
			return "crystalStick";
		case 4:
			return "darkCrystalShard";
		default:
			return "";
		}
	}
}
