package shadows.nature.Items;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;
import shadows.ancient.FNItems;

public class ItemNewAxe extends ItemTool {
	@SideOnly(Side.CLIENT)
	private IIcon axeIcons;

	/** an array of the blocks this axe is effective against */
	public static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] { FNBlocks.newPlanks1, FNBlocks.newPlanks2, FNBlocks.newLogs1, FNBlocks.newLogs2, FNBlocks.newLogs3, FNBlocks.newLogs4, Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.wooden_slab, Blocks.pumpkin, Blocks.lit_pumpkin, FNBlocks.crystalWood });

	public float func_150893_a(ItemStack par1ItemStack, Block par2Block)// getStrengthVsBlock
	{
		return par2Block != null && par2Block.getMaterial() == Material.wood ? this.efficiencyOnProperMaterial : super.func_150893_a(par1ItemStack, par2Block);
	}

	public ItemNewAxe(Item.ToolMaterial enumtoolmaterial) {
		super(3, enumtoolmaterial, blocksEffectiveAgainst);
		maxStackSize = 1;
	}

	public IIcon getIconFromDamage(int i) {
		return this.axeIcons;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		if (this == FNItems.cAxeItem)
			this.axeIcons = par1IconRegister.registerIcon("forgottennature:AxeLightCrystal");
		else if (this == FNItems.dcAxeItem)
			this.axeIcons = par1IconRegister.registerIcon("forgottennature:AxeDarkCrystal");
		else if (this == FNItems.oAxeItem)
			this.axeIcons = par1IconRegister.registerIcon("forgottennature:AxeObsidian");
		else if (this == FNItems.sawItemTool)
			this.axeIcons = par1IconRegister.registerIcon("forgottennature:Saw");
	}

	public String getUnlocalizedName(ItemStack i) {
		if (this == FNItems.cAxeItem)
			return "caxe";
		else if (this == FNItems.dcAxeItem)
			return "daxe";
		else if (this == FNItems.oAxeItem)
			return "oaxe";
		else
			return "saw";
	}
}