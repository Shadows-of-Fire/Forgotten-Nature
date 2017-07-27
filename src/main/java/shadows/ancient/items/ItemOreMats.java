package shadows.nature.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemOreMats extends Item {
	public static final String[] names1 = new String[] { "aluminumIngot", "antimonyIngot", "bariumIngot", "berylliumIngot", "calciumIngot", "chromeIngot", "cobaltIngot", "copperIngot", "erbiumIngot", "galliumIngot", "leadIngot", "lithiumIngot", "manganeseIngot", "molybdenumIngot", "neodymiumIngot", "nickelIngot" };
	public static final String[] names2 = new String[] { "PGMIngots", "potassiumIngot", "pyritePowder", "salt", "samariumIngot", "siliconIngot", "silverIngot", "sphaleriteIngot", "sulfurChunk", "tantalumIngot", "thoriumIngot", "tinIngot", "titaniumIngot", "tungstenIngot", "uraniumIngot", "vanadiumIngot" };
	public static final String[] names3 = new String[] { "ytterbiumIngot" };

	@SideOnly(Side.CLIENT)
	private IIcon[] matIcons;
	private int maxMet;
	private int matInd;

	public ItemOreMats(int maxMeta, int matIndex) {
		super();
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
		maxMet = maxMeta;
		matInd = matIndex;
	}

	public String getUnlocalizedName(ItemStack p1) {
		if (matInd == 0)
			return super.getUnlocalizedName() + "." + names1[p1.getItemDamage()];
		else if (matInd == 1)
			return super.getUnlocalizedName() + "." + names2[p1.getItemDamage()];
		else
			return super.getUnlocalizedName() + "." + names3[p1.getItemDamage()];
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return this.matIcons[i];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.matIcons = new IIcon[16];

		if (matInd == 0) {
			this.matIcons[0] = par1IconRegister.registerIcon("forgottennature:aluminumIngot");
			this.matIcons[1] = par1IconRegister.registerIcon("forgottennature:antimonyIngot");
			this.matIcons[2] = par1IconRegister.registerIcon("forgottennature:bariumIngot");
			this.matIcons[3] = par1IconRegister.registerIcon("forgottennature:berylliumIngot");
			this.matIcons[4] = par1IconRegister.registerIcon("forgottennature:calciumIngot");
			this.matIcons[5] = par1IconRegister.registerIcon("forgottennature:chromeIngot");
			this.matIcons[6] = par1IconRegister.registerIcon("forgottennature:cobaltIngot");
			this.matIcons[7] = par1IconRegister.registerIcon("forgottennature:copperIngot");
			this.matIcons[8] = par1IconRegister.registerIcon("forgottennature:erbiumIngot");
			this.matIcons[9] = par1IconRegister.registerIcon("forgottennature:galliumIngot");
			this.matIcons[10] = par1IconRegister.registerIcon("forgottennature:leadIngot");
			this.matIcons[11] = par1IconRegister.registerIcon("forgottennature:lithiumIngot");
			this.matIcons[12] = par1IconRegister.registerIcon("forgottennature:manganeseIngot");
			this.matIcons[13] = par1IconRegister.registerIcon("forgottennature:molybdenumIngot");
			this.matIcons[14] = par1IconRegister.registerIcon("forgottennature:neodymiumIngot");
			this.matIcons[15] = par1IconRegister.registerIcon("forgottennature:nickelIngot");
		} else if (matInd == 1) {
			this.matIcons[0] = par1IconRegister.registerIcon("forgottennature:PGMIngots");
			this.matIcons[1] = par1IconRegister.registerIcon("forgottennature:potassiumIngot");
			this.matIcons[2] = par1IconRegister.registerIcon("forgottennature:pyritePowder");
			this.matIcons[3] = par1IconRegister.registerIcon("forgottennature:salt");
			this.matIcons[4] = par1IconRegister.registerIcon("forgottennature:samariumIngot");
			this.matIcons[5] = par1IconRegister.registerIcon("forgottennature:siliconIngot");
			this.matIcons[6] = par1IconRegister.registerIcon("forgottennature:silverIngot");
			this.matIcons[7] = par1IconRegister.registerIcon("forgottennature:sphaleriteIngot");
			this.matIcons[8] = par1IconRegister.registerIcon("forgottennature:sulfurChunk");
			this.matIcons[9] = par1IconRegister.registerIcon("forgottennature:tantalumIngot");
			this.matIcons[10] = par1IconRegister.registerIcon("forgottennature:thoriumIngot");
			this.matIcons[11] = par1IconRegister.registerIcon("forgottennature:tinIngot");
			this.matIcons[12] = par1IconRegister.registerIcon("forgottennature:titaniumIngot");
			this.matIcons[13] = par1IconRegister.registerIcon("forgottennature:tungstenIngot");
			this.matIcons[14] = par1IconRegister.registerIcon("forgottennature:uraniumIngot");
			this.matIcons[15] = par1IconRegister.registerIcon("forgottennature:vanadiumIngot");
		} else
			this.matIcons[0] = par1IconRegister.registerIcon("forgottennature:ytterbiumIngot");
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item i, CreativeTabs tabs, List list) {
		for (int j = 0; j < maxMet + 1; j++) {
			list.add(new ItemStack(i, 1, j));
		}
	}
}
