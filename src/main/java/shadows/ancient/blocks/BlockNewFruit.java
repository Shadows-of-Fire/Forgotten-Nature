package shadows.nature.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;

public class BlockNewFruit extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon[] fruitIcons;

	Item ItemNut;
	Item ItemFruit;

	public BlockNewFruit(Item nutsItems, Item fruitItems) {
		super(Material.plants);
		setTickRandomly(true);
		ItemNut = nutsItems;
		ItemFruit = fruitItems;
		setHardness(0.2F);
		setLightOpacity(1);
		setStepSound(Block.soundTypeGrass);
		setBlockName("FNFruit");
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return this.fruitIcons[par2];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.fruitIcons = new IIcon[8];

		this.fruitIcons[0] = par1IconRegister.registerIcon("ForgottenNature:FoodWalnuts");
		this.fruitIcons[1] = par1IconRegister.registerIcon("ForgottenNature:Bananas");
		this.fruitIcons[2] = par1IconRegister.registerIcon("ForgottenNature:FruitFig");
		this.fruitIcons[3] = par1IconRegister.registerIcon("ForgottenNature:FoodCoconut");
		this.fruitIcons[4] = par1IconRegister.registerIcon("ForgottenNature:FoodGinkgoNuts");
		this.fruitIcons[5] = par1IconRegister.registerIcon("ForgottenNature:FruitOrange");
		this.fruitIcons[6] = par1IconRegister.registerIcon("ForgottenNature:FruitPeach");
		this.fruitIcons[7] = par1IconRegister.registerIcon("ForgottenNature:FruitLemon");
	}

	public void onNeighborBlockChange(World world, int par2, int par3, int par4, Block blk) {
		if (!blk.isLeaves(world, par2, par3, par4)) {
			dropBlockAsItemWithChance(world, par2, par3, par4, world.getBlockMetadata(par2, par3, par4), 10, 0);
			world.setBlockToAir(par2, par3, par4);
		}
	}

	public void updateTick(World world, int i, int j, int k, Random random) {
		Block ll = world.getBlock(i, j + 1, k);
		int ll2 = world.getBlockMetadata(i, j, k) & 15;
		if (ll == Blocks.air) {
			if (ll2 == 0)
				dropBlockAsItem(world, i, j, k, new ItemStack(ItemNut, 1, 1)); // walnuts
			else if (ll2 == 1)
				dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 0)); // banana
			else if (ll2 == 4)
				dropBlockAsItem(world, i, j, k, new ItemStack(ItemNut, 1, 0)); // ginkgo
																			// nuts
			else if (ll2 == 5)
				dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 2)); // orange
			else if (ll2 == 6)
				dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 3)); // peach
			else if (ll2 == 7)
				dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 9)); // lemon
			else if (ll2 == 2)
				dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 1)); // fig
			else if (ll2 == 3)
				dropBlockAsItem(world, i, j, k, new ItemStack(ItemNut, 1, 2)); // coconut
			world.setBlock(i, j, k, Blocks.air, 0, 3);
		}
		if (world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(8) == 0) {
			if (ll2 == 1 && random.nextInt(4) == 0 && ll == FNBlocks.newLeaves4
					&& world.getBlock(i, j - 1, k) == Blocks.air) {
				world.setBlock(i, j - 1, k, this, 1, 3);
			}
		}
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1) {
		for (int next = 1; next < 4; next++) {
			if (world.rand.nextInt(next + next - 1) == 0) {
				if ((l & 15) == 0)
					dropBlockAsItem(world, i, j, k, new ItemStack(ItemNut, 1, 1)); // walnuts
				if ((l & 15) == 1)
					dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 0)); // banana
				if ((l & 15) == 4)
					dropBlockAsItem(world, i, j, k, new ItemStack(ItemNut, 1, 0)); // ginkgo
																				// nuts
			}
		}
		if ((l & 15) == 5)
			dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 2)); // orange
		if ((l & 15) == 6)
			dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 3)); // peach
		if ((l & 15) == 7)
			dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 9)); // lemon
		if ((l & 15) == 2)
			dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 1)); // fig
		if ((l & 15) == 3)
			dropBlockAsItem(world, i, j, k, new ItemStack(ItemNut, 1, 2)); // coconut
	}

	public int damageDropped(int i) {
		return i & 15;
	}

	public int getRenderType() {
		return 1;
	}
}
