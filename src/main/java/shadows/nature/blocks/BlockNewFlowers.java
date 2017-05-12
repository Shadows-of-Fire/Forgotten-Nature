package shadows.nature.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNBlocks;

public class BlockNewFlowers extends BlockFlower {
	@SideOnly(Side.CLIENT)
	static IIcon[] flowerIcons;
	private static int ID = Block.getIdFromBlock(FNBlocks.fNFlowers);

	public BlockNewFlowers() {
		super(ID);
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		setBlockName("FNFlowers");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return this.flowerIcons[par2];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.flowerIcons = new IIcon[10];

		this.flowerIcons[0] = par1IconRegister.registerIcon("ForgottenNature:AlliumDrumstick");
		this.flowerIcons[1] = par1IconRegister.registerIcon("ForgottenNature:BachelorsButton");
		this.flowerIcons[2] = par1IconRegister.registerIcon("ForgottenNature:BillyButtons");
		this.flowerIcons[3] = par1IconRegister.registerIcon("ForgottenNature:DelphiniumBelladonna");
		this.flowerIcons[4] = par1IconRegister.registerIcon("ForgottenNature:FernflowerYarrow");
		this.flowerIcons[5] = par1IconRegister.registerIcon("ForgottenNature:GerberaDaisy");
		this.flowerIcons[6] = par1IconRegister.registerIcon("ForgottenNature:Hydrangea");
		this.flowerIcons[7] = par1IconRegister.registerIcon("ForgottenNature:RedRover");
		this.flowerIcons[8] = par1IconRegister.registerIcon("ForgottenNature:SnapdragonMagenta");
		this.flowerIcons[9] = par1IconRegister.registerIcon("ForgottenNature:StarOfBethlehem");
	}

	public int damageDropped(int i) {
		return i & 15;
	}

	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7,
			float par8, float par9) {
		ItemStack equipped = entityplayer.getCurrentEquippedItem();
		if (equipped == null) {
			return false;
		}
		if ((equipped.getItem() == Items.dye) && (equipped.getItemDamage() == 15)) // if
																					// bone
																					// meal
		{
			int bid;
			int bidu;
			for (int one = -2; one < 3; one++) {
				for (int two = -2; two < 3; two++) {
					for (int three = -2; three < 3; three++) {
						bid = Block.getIdFromBlock(world.getBlock(i + one, j + two, k + three));
						bidu = Block.getIdFromBlock(world.getBlock(i + one, j + two - 1, k + three));
						if ((bid == 31 || bid == 37 || bid == 38 || bid == 0) && (bidu == 2 || bidu == 3)
								&& (Math.abs(one) + Math.abs(three) < 4) && world.rand.nextInt(3) == 0) {
							world.setBlock(i + one, j + two, k + three, world.getBlock(i, j, k),
									world.getBlockMetadata(i, j, k), 3);
						}
					}
				}
			}
			equipped.stackSize -= 1;
		}
		return false;
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return Item.getItemFromBlock(this);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item i, CreativeTabs p_149666_2_, List list) {
		for (int j = 0; j < 10; j++) {
			list.add(new ItemStack(i, 1, j));
		}
	}
}
