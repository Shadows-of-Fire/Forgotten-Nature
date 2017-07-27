package shadows.nature.Items;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNItems;

public class ItemNewShovel extends ItemTool {
	@SideOnly(Side.CLIENT)
	private IIcon field_94594_d;

	public static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] { Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow, Blocks.snow_layer, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium });

	public ItemNewShovel(Item.ToolMaterial enumtoolmaterial) {
		super(2, enumtoolmaterial, blocksEffectiveAgainst);
		maxStackSize = 1;
	}

	public IIcon getIconFromDamage(int i) {
		return this.field_94594_d;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		if (this == FNItems.cShovelItem)
			this.field_94594_d = par1IconRegister.registerIcon("ForgottenNature:ShovelLightCrystal");
		else if (this == FNItems.dcShovelItem)
			this.field_94594_d = par1IconRegister.registerIcon("ForgottenNature:ShovelDarkCrystal");
		else if (this == FNItems.oShovelItem)
			this.field_94594_d = par1IconRegister.registerIcon("ForgottenNature:ShovelObsidian");
	}

	public boolean canHarvestBlock(Block block) {
		return block == Blocks.snow ? true : block == Blocks.snow_layer;
	}

	public String getUnlocalizedName(ItemStack i) {
		if (this == FNItems.cShovelItem)
			return "cshovel";
		else if (this == FNItems.dcShovelItem)
			return "dshovel";
		else
			return "oshovel";
	}
}