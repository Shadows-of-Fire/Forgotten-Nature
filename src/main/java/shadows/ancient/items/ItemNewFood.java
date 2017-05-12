package shadows.nature.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemNewFood extends ItemFood {
	@SideOnly(Side.CLIENT)
	private IIcon[] breadIcons;

	public ItemNewFood() {
		super(9, 0.6F, false);
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return this.breadIcons[i];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.breadIcons = new IIcon[5];

		this.breadIcons[0] = par1IconRegister.registerIcon("ForgottenNature:FoodBlackberryBread");
		this.breadIcons[1] = par1IconRegister.registerIcon("ForgottenNature:FoodHuckleberryBread");
		this.breadIcons[2] = par1IconRegister.registerIcon("ForgottenNature:FoodBlueberryBread");
		this.breadIcons[3] = par1IconRegister.registerIcon("ForgottenNature:FoodRaspberryBread");
		this.breadIcons[4] = par1IconRegister.registerIcon("ForgottenNature:FoodBerryNutBread");
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
			return "black";
		case 1:
			return "huckle";
		case 2:
			return "blue";
		case 3:
			return "rasp";
		case 4:
			return "berrynut";
		default:
			return "";
		}
	}
}
