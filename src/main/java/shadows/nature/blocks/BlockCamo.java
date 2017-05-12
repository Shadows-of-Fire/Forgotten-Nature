package shadows.nature.Blocks;

import java.util.List;
import java.util.Random;

import ForgottenNature.TileEntities.TileEntityCamo;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNBlocks;

public class BlockCamo extends Block implements ITileEntityProvider {
	private boolean solid;
	private IIcon camoIcon;

	public BlockCamo(boolean sld) {
		super(Material.cloth);
		this.setStepSound(soundTypeCloth);
		solid = sld;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_,
			int p_149668_4_) {
		if (solid)
			return AxisAlignedBB.getBoundingBox((double) p_149668_2_ + this.minX, (double) p_149668_3_ + this.minY,
					(double) p_149668_4_ + this.minZ, (double) p_149668_2_ + this.maxX,
					(double) p_149668_3_ + this.maxY, (double) p_149668_4_ + this.maxZ);
		else
			return null;
	}

	public boolean renderAsNormalBlock() {
		if (solid)
			return true;
		else
			return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess iBAccess, int i, int j, int k, int p_149646_5_) {
		Block block = iBAccess.getBlock(i, j, k);
		return block == this ? false : super.shouldSideBeRendered(iBAccess, i, j, k, p_149646_5_);
	}

	public int quantityDropped(Random random) {
		return 1;
	}

	public Item getItemDropped(int p_149650_1_, Random ran, int p_149650_3_) {
		return Item.getItemFromBlock(this);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess ibAccess, int i, int j, int k, int side) {
		int met = ((TileEntityCamo) ibAccess.getTileEntity(i, j, k)).blockMetadata;

		return getIcon(side, met);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.camoIcon = par1IconRegister.registerIcon("ForgottenNature:camo");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int met) {
		if (solid && (met > 74 && met < 149 && side == 0) || (met > 148 && met < 223 && side == 1)
				|| (met > 222 && met < 297 && side == 2) || (met > 296 && met < 371 && side == 3)
				|| (met > 370 && met < 445 && side == 4) || (met > 444 && met < 519 && side == 5)) {
			return Blocks.glass.getIcon(side, 0);
		} else {
			while (met > 74)// reset icon index
			{
				met = met - 74;
			}

			if (met == 0)
				return this.camoIcon;
			else if (met == 1)
				return Blocks.stone.getIcon(side, 0);
			else if (met == 2)
				return Blocks.grass.getIcon(side, 0);
			else if (met == 3)
				return Blocks.dirt.getIcon(side, 0);
			else if (met == 4)
				return Blocks.cobblestone.getIcon(side, 0);
			else if (met == 5)
				return Blocks.planks.getIcon(side, 0);
			else if (met == 6)
				return Blocks.planks.getIcon(side, 1);
			else if (met == 7)
				return Blocks.planks.getIcon(side, 2);
			else if (met == 8)
				return Blocks.planks.getIcon(side, 3);
			else if (met == 9)
				return Blocks.planks.getIcon(side, 4);
			else if (met == 10)
				return Blocks.planks.getIcon(side, 5);
			else if (met == 11)
				return Blocks.sand.getIcon(side, 0);
			else if (met == 12)
				return Blocks.gravel.getIcon(side, 0);
			else if (met == 13)
				return Blocks.log.getIcon(side, 0);
			else if (met == 14)
				return Blocks.log.getIcon(side, 1);
			else if (met == 15)
				return Blocks.log.getIcon(side, 2);
			else if (met == 16)
				return Blocks.log.getIcon(side, 3);
			else if (met == 17)
				return Blocks.sandstone.getIcon(side, 0);
			else if (met == 18)
				return Blocks.brick_block.getIcon(side, 0);
			else if (met == 19)
				return Blocks.nether_brick.getIcon(side, 0);
			else if (met == 20)
				return Blocks.stonebrick.getIcon(side, 0);
			else if (met == 21)
				return Blocks.mossy_cobblestone.getIcon(side, 0);
			else if (met == 22)
				return Blocks.obsidian.getIcon(side, 0);
			else if (met == 23)
				return Blocks.snow.getIcon(side, 0);
			else if (met == 24)
				return Blocks.ice.getIcon(side, 0);
			else if (met == 25)
				return Blocks.netherrack.getIcon(side, 0);
			else if (met == 26)
				return Blocks.soul_sand.getIcon(side, 0);
			else if (met == 27)
				return Blocks.glowstone.getIcon(side, 0);
			else if (met == 28)
				return Blocks.mycelium.getIcon(side, 0);
			else if (met == 29)
				return Blocks.hay_block.getIcon(side, 0);
			else if (met == 30)
				return Blocks.packed_ice.getIcon(side, 0);
			else if (met == 31)
				return Blocks.log2.getIcon(side, 0);
			else if (met == 32)
				return Blocks.log2.getIcon(side, 1);
			else if (met == 33)
				return FNBlocks.newLogs1.getIcon(side, 0);
			else if (met == 34)
				return FNBlocks.newLogs1.getIcon(side, 2);
			else if (met == 35)
				return FNBlocks.newLogs1.getIcon(side, 4);
			else if (met == 36)
				return FNBlocks.newLogs1.getIcon(side, 6);
			else if (met == 37)
				return FNBlocks.newLogs1.getIcon(side, 10);
			else if (met == 38)
				return FNBlocks.newLogs1.getIcon(side, 12);
			else if (met == 39)
				return FNBlocks.newLogs2.getIcon(side, 0);
			else if (met == 40)
				return FNBlocks.newLogs2.getIcon(side, 2);
			else if (met == 41)
				return FNBlocks.newLogs2.getIcon(side, 4);
			else if (met == 42)
				return FNBlocks.newLogs2.getIcon(side, 6);
			else if (met == 43)
				return FNBlocks.newLogs2.getIcon(side, 8);
			else if (met == 44)
				return FNBlocks.newLogs2.getIcon(side, 14);
			else if (met == 45)
				return FNBlocks.newLogs3.getIcon(side, 0);
			else if (met == 46)
				return FNBlocks.newLogs3.getIcon(side, 1);
			else if (met == 47)
				return FNBlocks.newLogs3.getIcon(side, 2);
			else if (met == 48)
				return FNBlocks.newLogs3.getIcon(side, 3);
			else if (met == 49)
				return FNBlocks.newLogs3.getIcon(side, 4);
			else if (met == 50)
				return FNBlocks.netherLogs.getIcon(side, 0);
			else if (met == 51)
				return FNBlocks.netherLogs.getIcon(side, 1);
			else if (met == 52)
				return FNBlocks.netherLogs.getIcon(side, 2);
			else if (met == 53)
				return FNBlocks.netherLogs.getIcon(side, 3);
			else if (met == 54)
				return FNBlocks.newPlanks1.getIcon(side, 0);
			else if (met == 55)
				return FNBlocks.newPlanks1.getIcon(side, 1);
			else if (met == 56)
				return FNBlocks.newPlanks1.getIcon(side, 2);
			else if (met == 57)
				return FNBlocks.newPlanks1.getIcon(side, 3);
			else if (met == 58)
				return FNBlocks.newPlanks1.getIcon(side, 4);
			else if (met == 59)
				return FNBlocks.newPlanks1.getIcon(side, 5);
			else if (met == 60)
				return FNBlocks.newPlanks1.getIcon(side, 6);
			else if (met == 61)
				return FNBlocks.newPlanks1.getIcon(side, 7);
			else if (met == 62)
				return FNBlocks.newPlanks1.getIcon(side, 9);
			else if (met == 63)
				return FNBlocks.newPlanks1.getIcon(side, 10);
			else if (met == 64)
				return FNBlocks.newPlanks1.getIcon(side, 11);
			else if (met == 65)
				return FNBlocks.newPlanks1.getIcon(side, 12);
			else if (met == 66)
				return FNBlocks.newPlanks1.getIcon(side, 13);
			else if (met == 67)
				return FNBlocks.newPlanks1.getIcon(side, 14);
			else if (met == 68)
				return FNBlocks.newPlanks2.getIcon(side, 0);
			else if (met == 69)
				return FNBlocks.newPlanks2.getIcon(side, 1);
			else if (met == 70)
				return FNBlocks.newPlanks2.getIcon(side, 2);
			else if (met == 71)
				return FNBlocks.newPlanks2.getIcon(side, 3);
			else if (met == 72)
				return FNBlocks.newPlanks2.getIcon(side, 4);
			else if (met == 73)
				return FNBlocks.newPlanks2.getIcon(side, 5);
			else
				return FNBlocks.newPlanks2.getIcon(side, 6);
		}
	}

	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer eplayer, int side, float hx,
			float hy, float hz) {
		if (this.solid && eplayer.getCurrentEquippedItem() == null) {
			int met = world.getTileEntity(i, j, k).blockMetadata;
			// eplayer.addChatMessage(new
			// ChatComponentText(Integer.toString(met)));//for testing

			if (met == 0) {
				met++;
			}

			while (met > 74)// reset icon index
			{
				met = met - 74;
			}

			if (side == 0) {
				world.setBlockMetadataWithNotify(i, j, k, met + 74, 3);
			} else if (side == 1) {
				world.setBlockMetadataWithNotify(i, j, k, met + 148, 3);
			} else if (side == 2) {
				world.setBlockMetadataWithNotify(i, j, k, met + 222, 3);
			} else if (side == 3) {
				world.setBlockMetadataWithNotify(i, j, k, met + 296, 3);
			} else if (side == 4) {
				world.setBlockMetadataWithNotify(i, j, k, met + 370, 3);
			} else {
				world.setBlockMetadataWithNotify(i, j, k, met + 444, 3);
			}
			return true;
		} else
			return false;
	}

	public TileEntity createNewTileEntity(World world, int damage) {
		return new TileEntityCamo();
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item i, CreativeTabs tabs, List list) {
		// for(int j = 0; j < 75; j++)
		list.add(new ItemStack(i, 1, 0));
	}
}
