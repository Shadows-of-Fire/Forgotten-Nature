package shadows.nature.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNItems;

public class BlockCrystalMushroomBlock extends Block {
	@SideOnly(Side.CLIENT)
	static IIcon[] mushroomIcons;

	public BlockCrystalMushroomBlock() {
		super(Material.rock);
		this.setTickRandomly(true);
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return par2 == 0 && (par1 == 0 || par1 == 1) ? this.mushroomIcons[0]
				: (par2 == 0 && par1 > 1 ? this.mushroomIcons[1] : this.mushroomIcons[2]);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.mushroomIcons = new IIcon[3];

		this.mushroomIcons[0] = par1IconRegister.registerIcon("forgottennature:LightCrystalMushroomStemBlockBase");
		this.mushroomIcons[1] = par1IconRegister.registerIcon("forgottennature:LightCrystalMushroomStemBlock");
		this.mushroomIcons[2] = par1IconRegister.registerIcon("forgottennature:LightCrystalMushroomHeadBlock");
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1) {
		super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
		for (int n = 0; n < 3; n++) {
			if (world.rand.nextInt(2) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNItems.crystalItem, 1, 1)); // crystal
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item i, CreativeTabs tabs, List list) {
		list.add(new ItemStack(i, 1, 0));
		list.add(new ItemStack(i, 1, 1));
	}
}
