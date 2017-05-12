package shadows.nature.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;
import shadows.ancient.gen.genBeech;
import shadows.ancient.gen.genBukkit;
import shadows.ancient.gen.genCedar;
import shadows.ancient.gen.genDWillow;
import shadows.ancient.gen.genFruit;
import shadows.ancient.gen.genFruitBush;
import shadows.ancient.gen.genGinkgo;
import shadows.ancient.gen.genPalm;
import shadows.ancient.gen.genPoplar;
import shadows.ancient.gen.genWTEucalyptus;
import shadows.ancient.gen.genWalnut;

public class BlockNewSap2 extends BlockFlower {
	@SideOnly(Side.CLIENT)
	static IIcon[] saplingIcons;
	private static int ID = Block.getIdFromBlock(FNBlocks.fNSapling2);

	public BlockNewSap2() {
		super(ID);
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		setBlockName("FNSapling2");
	}

	public String getUnlocalizedName(ItemStack p1) {
		return super.getUnlocalizedName() + "." + p1.getItemDamage();
	}

	public IIcon getIcon(int par1, int par2) {
		return this.saplingIcons[par2];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.saplingIcons = new IIcon[16];

		this.saplingIcons[0] = par1IconRegister.registerIcon("ForgottenNature:SaplingPalm");
		this.saplingIcons[1] = par1IconRegister.registerIcon("ForgottenNature:SaplingDesertWillow");
		this.saplingIcons[2] = par1IconRegister.registerIcon("ForgottenNature:SaplingCedar");
		this.saplingIcons[3] = par1IconRegister.registerIcon("ForgottenNature:SaplingGinkgo");
		this.saplingIcons[4] = par1IconRegister.registerIcon("ForgottenNature:SaplingPoplar");
		this.saplingIcons[5] = par1IconRegister.registerIcon("ForgottenNature:SaplingBeech");
		this.saplingIcons[6] = par1IconRegister.registerIcon("ForgottenNature:SaplingWalnut");
		// this.saplingIcons[7] =
		this.saplingIcons[8] = par1IconRegister.registerIcon("ForgottenNature:SaplingWTEucalyptus");
		this.saplingIcons[9] = par1IconRegister.registerIcon("ForgottenNature:SaplingBukkit");
		this.saplingIcons[10] = par1IconRegister.registerIcon("ForgottenNature:SaplingBanana");
		this.saplingIcons[11] = par1IconRegister.registerIcon("ForgottenNature:SaplingOrange");
		this.saplingIcons[12] = par1IconRegister.registerIcon("ForgottenNature:SaplingPeach");
		this.saplingIcons[13] = par1IconRegister.registerIcon("ForgottenNature:SaplingLemon");
		this.saplingIcons[14] = par1IconRegister.registerIcon("ForgottenNature:SaplingBlueberry");
		this.saplingIcons[15] = par1IconRegister.registerIcon("ForgottenNature:SaplingRaspberry");
	}

	public void updateTick(World world, int i, int j, int k, Random random) {
		if (world.isRemote) {
			return;
		}
		super.updateTick(world, i, j, k, random);
		if (world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(14) == 0) {
			growTree(world, i, j, k, random);
		}
	}

	public void growTree(World world, int i, int j, int k, Random random) {
		Block nLogs2 = FNBlocks.newLogs2;
		Block nLogs3 = FNBlocks.newLogs3;
		Block nLeaves3 = FNBlocks.newLeaves3;
		Block nLeaves4 = FNBlocks.newLeaves4;
		int l = world.getBlockMetadata(i, j, k) & 15;
		world.setBlockToAir(i, j, k);
		Object obj = null;
		if (l == 1) {
			obj = new genDWillow(nLeaves3, 4, nLogs2, 0);
		} else if (l == 2) {
			obj = new genCedar(nLeaves3, 5, nLogs2, 2);
		} else if (l == 3) {
			obj = new genGinkgo(nLeaves3, 6, nLogs2, 4);
		} else if (l == 4) {
			obj = new genPoplar(nLeaves3, 7, Block.getBlockById(17), 1); // poplar
		} else if (l == 5) {
			obj = new genBeech(nLeaves4, 0, nLogs2, 6); // beech
		} else if (l == 6) {
			obj = new genWalnut(nLeaves4, 1, nLogs2, 8); // walnut
		} else if (l == 8) {
			obj = new genWTEucalyptus(nLeaves4, 3, nLogs2, 14); // WTEucal
		} else if (l == 9) {
			obj = new genBukkit(nLeaves4, 4, nLogs3, 0); // bukkit
		} else if (l == 10) {
			obj = new genPalm(nLeaves4, 5, nLogs3, 1); // banana
		} else if (l == 11) {
			obj = new genFruit(false, nLeaves4, 6, nLogs3, 2, 1); // orange
		} else if (l == 12) {
			obj = new genFruit(false, nLeaves4, 7, nLogs3, 3, 1); // peach
		} else if (l == 13) {
			obj = new genFruit(false, FNBlocks.newLeaves5, 0, nLogs3, 4, 1); // lemon
		} else if (l == 14) {
			obj = new genFruitBush(FNBlocks.newLeaves5, 1, 0); // blueberry
		} else if (l == 15) {
			obj = new genFruitBush(FNBlocks.newLeaves5, 3, 0); // raspberry
		} else {
			obj = new genPalm(nLeaves3, 3, FNBlocks.newLogs1, 14); // palm
		}
		if (!((WorldGenerator) (obj)).generate(world, random, i, j, k)) {
			world.setBlock(i, j, k, this, l, 3);
		}
	}

	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par2, float par3,
			float par4, float par5) {
		ItemStack equipped = entityplayer.getCurrentEquippedItem();
		if (equipped == null) {
			return false;
		}
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
