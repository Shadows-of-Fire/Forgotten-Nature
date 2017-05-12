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
import shadows.ancient.FNItems;

public class ItemNewPA extends ItemTool {
	@SideOnly(Side.CLIENT)
	private IIcon field_94594_d;

	private static Set blocksEffectiveAgainst = Sets.newHashSet(
			new Block[] { Blocks.cobblestone, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore,
					Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore,
					Blocks.diamond_block, Blocks.ice, Blocks.lapis_ore, Blocks.lapis_block, Blocks.obsidian });

	public ItemNewPA(Item.ToolMaterial toolmaterial) {
		super(2, toolmaterial, blocksEffectiveAgainst);
		maxStackSize = 1;
	}

	public boolean func_150897_b(Block par1Block) {
		return par1Block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() >= 1
				: (par1Block != Blocks.diamond_block && par1Block != Blocks.diamond_ore
						? (par1Block == Blocks.emerald_ore ? this.toolMaterial.getHarvestLevel() >= 1
								: (par1Block != Blocks.gold_block && par1Block != Blocks.gold_ore
										? (par1Block != Blocks.iron_block && par1Block != Blocks.iron_ore
												? (par1Block != Blocks.lapis_block && par1Block != Blocks.lapis_ore
														? (par1Block != Blocks.redstone_ore
																&& par1Block != Blocks.lit_redstone_ore
																		? (par1Block.getMaterial() == Material.rock
																				? true
																				: par1Block
																						.getMaterial() == Material.iron)
																		: this.toolMaterial.getHarvestLevel() >= 1)
														: this.toolMaterial.getHarvestLevel() >= 1)
												: this.toolMaterial.getHarvestLevel() >= 1)
										: this.toolMaterial.getHarvestLevel() >= 2))
						: this.toolMaterial.getHarvestLevel() >= 1);
	}

	public float func_150893_a(ItemStack par1ItemStack, Block par2Block) {
		return par2Block != null
				&& (par2Block.getMaterial() == Material.iron || par2Block.getMaterial() == Material.rock)
						? this.efficiencyOnProperMaterial : 1.0F;
	}

	public IIcon getIconFromDamage(int i) {
		return this.field_94594_d;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		if (this == FNItems.cPickaxeItem)
			this.field_94594_d = par1IconRegister.registerIcon("ForgottenNature:PickaxeLightCrystal");
		else if (this == FNItems.dcPickaxeItem)
			this.field_94594_d = par1IconRegister.registerIcon("ForgottenNature:PickaxeDarkCrystal");
		else if (this == FNItems.oPickaxeItem)
			this.field_94594_d = par1IconRegister.registerIcon("ForgottenNature:PickaxeObsidian");
	}

	public String getUnlocalizedName(ItemStack i) {
		if (this == FNItems.cPickaxeItem)
			return "cpaxe";
		else if (this == FNItems.dcPickaxeItem)
			return "dpaxe";
		else
			return "opaxe";
	}
}