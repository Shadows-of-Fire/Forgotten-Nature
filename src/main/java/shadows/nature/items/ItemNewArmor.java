package shadows.nature.Items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNItems;

public class ItemNewArmor extends ItemArmor {
	@SideOnly(Side.CLIENT)
	private IIcon armorIcons[];
	// "chestPlateTitanStone", "helmetTitanStone", "leggingsTitanStone",
	// "bootsTitanStone"};

	public ItemNewArmor(String unlocalizedName, ItemArmor.ArmorMaterial armormaterial, int j, int k) {
		super(armormaterial, j, k);
		setUnlocalizedName(unlocalizedName);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		if (this == FNItems.helmetObsidian)
			return this.armorIcons[0];
		else if (this == FNItems.plateObsidian)
			return this.armorIcons[1];
		else if (this == FNItems.legsObsidian)
			return this.armorIcons[2];
		else if (this == FNItems.bootsObsidian)
			return this.armorIcons[3];
		else if (this == FNItems.helmetTitanStone)
			return this.armorIcons[4];
		else if (this == FNItems.plateTitanStone)
			return this.armorIcons[5];
		else if (this == FNItems.legsTitanStone)
			return this.armorIcons[6];
		else
			// if(this == ForgottenNature.armorID+7)
			return this.armorIcons[7];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		super.registerIcons(par1IconRegister);
		this.armorIcons = new IIcon[8];

		this.armorIcons[0] = par1IconRegister.registerIcon("ForgottenNature:helmetObsidian");
		this.armorIcons[1] = par1IconRegister.registerIcon("ForgottenNature:chestPlateObsidian");
		this.armorIcons[2] = par1IconRegister.registerIcon("ForgottenNature:leggingsObsidian");
		this.armorIcons[3] = par1IconRegister.registerIcon("ForgottenNature:bootsObsidian");
		this.armorIcons[4] = par1IconRegister.registerIcon("ForgottenNature:helmetTitanStone");
		this.armorIcons[5] = par1IconRegister.registerIcon("ForgottenNature:chestPlateTitanStone");
		this.armorIcons[6] = par1IconRegister.registerIcon("ForgottenNature:leggingsTitanStone");
		this.armorIcons[7] = par1IconRegister.registerIcon("ForgottenNature:bootsTitanStone");
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		if (this == FNItems.helmetObsidian || this == FNItems.plateObsidian || this == FNItems.legsObsidian
				|| this == FNItems.bootsObsidian) {
			if (this == FNItems.helmetObsidian || this == (FNItems.plateObsidian)
					|| itemstack.getItem() == FNItems.bootsObsidian) {
				return "forgottennature:textures/armor/obsidianArmor_1.png";// all
																			// but
																			// legs
			}
			if (this == (FNItems.legsObsidian))// legs
			{
				return "forgottennature:textures/armor/obsidianArmor_2.png";
			} else
				return "ForgottenNature:textures/armor/obsidianArmor_1.png";
		} else {
			if (this == FNItems.helmetTitanStone || this == FNItems.plateTitanStone
					|| itemstack.getItem() == FNItems.bootsTitanStone) {
				return "ForgottenNature:textures/armor/titanStoneArmor_1.png";// all
																				// but
																				// legs
			}
			if (this == FNItems.legsTitanStone)// legs
			{
				return "ForgottenNature:textures/armor/titanStoneArmor_2.png";
			} else
				return "ForgottenNature:textures/armor/titanStoneArmor_1.png";
		}
	}

}