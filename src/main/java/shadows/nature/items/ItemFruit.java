package shadows.nature.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFruit extends ItemFood {
	@SideOnly(Side.CLIENT)
	private IIcon[] fruitIcons;
	public static final String[] names = new String[] { "banana", "fig", "orange", "peach", "cherries", "blackberries",
			"huckleberries", "blueberries", "raspberries", "lemon" };

	public ItemFruit() {
		super(1, 0.2F, false);
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabFood);
	}

	public String getUnlocalizedName(ItemStack p_71) {
		int i = MathHelper.clamp_int(p_71.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "." + names[i];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return this.fruitIcons[i];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.fruitIcons = new IIcon[10];

		this.fruitIcons[0] = par1IconRegister.registerIcon("forgottennature:FruitBanana");
		this.fruitIcons[1] = par1IconRegister.registerIcon("forgottennature:FruitFig");
		this.fruitIcons[2] = par1IconRegister.registerIcon("forgottennature:FruitOrange");
		this.fruitIcons[3] = par1IconRegister.registerIcon("forgottennature:FruitPeach");
		this.fruitIcons[4] = par1IconRegister.registerIcon("forgottennature:FruitCherry");
		this.fruitIcons[5] = par1IconRegister.registerIcon("forgottennature:FruitBlackBerries");
		this.fruitIcons[6] = par1IconRegister.registerIcon("forgottennature:FruitHuckleberries");
		this.fruitIcons[7] = par1IconRegister.registerIcon("forgottennature:FruitBlueberries");
		this.fruitIcons[8] = par1IconRegister.registerIcon("forgottennature:FruitRaspberries");
		this.fruitIcons[9] = par1IconRegister.registerIcon("forgottennature:FruitLemon");
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item i, CreativeTabs tabs, List list) {
		for (int j = 0; j < 10; j++) {
			list.add(new ItemStack(i, 1, j));
		}
	}
}
