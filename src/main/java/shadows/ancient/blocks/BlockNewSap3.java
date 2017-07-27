package shadows.nature.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;
import shadows.ancient.gen.genCrystal;
import shadows.ancient.gen.genFruitBush;
import shadows.ancient.gen.genNetherMushroom;
import shadows.ancient.gen.genNetherTree;

public class BlockNewSap3 extends BlockFlower {
	@SideOnly(Side.CLIENT)
	static IIcon[] saplingIcons;
	private static int ID = Block.getIdFromBlock(FNBlocks.fNSapling3);

	public BlockNewSap3() {
		super(ID);
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		setBlockName("FNSapling3");
	}

	public IIcon getIcon(int par1, int par2) {
		return this.saplingIcons[par2];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.saplingIcons = new IIcon[6];

		this.saplingIcons[0] = par1IconRegister.registerIcon("ForgottenNature:SaplingHuckleberry");
		this.saplingIcons[1] = par1IconRegister.registerIcon("ForgottenNature:SaplingBlackberry");
		this.saplingIcons[2] = par1IconRegister.registerIcon("ForgottenNature:SaplingCrystal");
		this.saplingIcons[3] = par1IconRegister.registerIcon("ForgottenNature:SaplingNetherAsh");
		this.saplingIcons[4] = par1IconRegister.registerIcon("ForgottenNature:SaplingNetherBlaze");
		this.saplingIcons[5] = par1IconRegister.registerIcon("ForgottenNature:SaplingNetherMushroom");
	}

	public void updateTick(World world, int i, int j, int k, Random random) {
		if (world.isRemote) {
			return;
		}
		super.updateTick(world, i, j, k, random);
		if (world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(14) == 0 && ((world.getBlock(i, j - 1, k) != Blocks.netherrack || world.getBlockMetadata(i, j, k) < 3) || world.getBlockMetadata(i, j, k) > 2)) {
			growTree(world, i, j, k, random);
		}
	}

	public void growTree(World world, int i, int j, int k, Random random) {
		int l = world.getBlockMetadata(i, j, k) & 15;
		world.setBlockToAir(i, j, k);// set air block
		Object obj = null;
		int size = 2;

		if (l == 1) {
			obj = new genFruitBush(FNBlocks.newLeaves5, 5, 0); // blackberry
		}

		else if (l == 2) {
			if (random.nextInt(25) == 0) {
				size = 4;
				if (random.nextInt(20) == 0)
					size = 8;
			}
			if (random.nextInt(25) > 0)
				obj = new genCrystal(FNBlocks.crystalLeaves, 1, FNBlocks.crystalWood, 0, size); // crystal
			else
				obj = new genCrystal(FNBlocks.crystalLeaves, 0, FNBlocks.crystalWood, 1, size); // darkcrystal
		}

		else if (l == 0) {
			obj = new genFruitBush(FNBlocks.newLeaves6, 0, 0); // huckleberry
		}

		else if (l == 3) {
			obj = new genNetherTree(0, 0, 1); // nether ash
		}

		else if (l == 4) {
			obj = new genNetherTree(1, 1, 1); // nether blaze
		}

		else {
			obj = new genNetherMushroom(FNBlocks.netherLogs); // nether mushroom
		}

		if (!((WorldGenerator) (obj)).generate(world, random, i, j, k)) {
			world.setBlock(i, j, k, this, l, 3);
		}
	}

	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par2, float par3, float par4, float par5) {
		ItemStack equipped = entityplayer.getCurrentEquippedItem();

		if (equipped == null)
			return false;
		if (world.getBlockMetadata(i, j, k) < 3 && world.getBlock(i, j - 1, k) == Blocks.netherrack)
			return false;
		if ((equipped.getItem() == Items.dye) && (equipped.getItemDamage() == 15)) // if
																					// bone
																					// meal
		{
			growTree(world, i, j, k, world.rand);
			if (!entityplayer.capabilities.isCreativeMode)
				equipped.stackSize -= 1;
		}
		return false;
	}

	public int damageDropped(int i) {
		return i & 15;
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return Item.getItemFromBlock(this);
	}
}
