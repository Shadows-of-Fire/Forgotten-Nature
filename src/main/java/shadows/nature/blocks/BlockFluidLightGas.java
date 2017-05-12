package shadows.nature.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNBlocks;

public class BlockFluidLightGas extends BlockFluidClassic {
	@SideOnly(Side.CLIENT)
	protected static IIcon stillIconH2;
	@SideOnly(Side.CLIENT)
	protected static IIcon flowingIconH2;
	@SideOnly(Side.CLIENT)
	protected static IIcon stillIconHe;
	@SideOnly(Side.CLIENT)
	protected static IIcon flowingIconHe;
	@SideOnly(Side.CLIENT)
	protected static IIcon stillIconCH4;
	@SideOnly(Side.CLIENT)
	protected static IIcon flowingIconCH4;
	@SideOnly(Side.CLIENT)
	protected static IIcon stillIconH2Ov;
	@SideOnly(Side.CLIENT)
	protected static IIcon flowingIconH2Ov;
	@SideOnly(Side.CLIENT)
	protected static IIcon stillIconO2;
	@SideOnly(Side.CLIENT)
	protected static IIcon flowingIconO2;
	@SideOnly(Side.CLIENT)
	protected static IIcon stillIconOil;
	@SideOnly(Side.CLIENT)
	protected static IIcon flowingIconOil;
	protected int fluidNumber;
	protected Fluid thisFluid;

	public BlockFluidLightGas(Fluid fluid, Material material, int i) {
		super(fluid, material);
		fluidNumber = i;
		setCreativeTab(FNBlocks.tab);
		thisFluid = fluid;
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		if (fluidNumber == 0)
			return (side == 0 || side == 1) ? stillIconH2 : flowingIconH2;
		else if (fluidNumber == 1)
			return (side == 0 || side == 1) ? stillIconHe : flowingIconHe;
		else if (fluidNumber == 2)
			return (side == 0 || side == 1) ? stillIconH2Ov : flowingIconH2Ov;
		else if (fluidNumber == 3)
			return (side == 0 || side == 1) ? stillIconCH4 : flowingIconCH4;
		else if (fluidNumber == 4)
			return (side == 0 || side == 1) ? stillIconO2 : flowingIconO2;
		else
			return (side == 0 || side == 1) ? stillIconOil : flowingIconOil;

	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register) {
		stillIconH2 = register.registerIcon("ForgottenNature:hydrogenStill");
		flowingIconH2 = register.registerIcon("ForgottenNature:hydrogenFlowing");
		stillIconHe = register.registerIcon("ForgottenNature:heliumStill");
		flowingIconHe = register.registerIcon("ForgottenNature:heliumFlowing");
		stillIconCH4 = register.registerIcon("ForgottenNature:methaneStill");
		flowingIconCH4 = register.registerIcon("ForgottenNature:methaneFlowing");
		stillIconH2Ov = register.registerIcon("ForgottenNature:H2OvStill");
		flowingIconH2Ov = register.registerIcon("ForgottenNature:H2OvFlowing");
		stillIconO2 = register.registerIcon("ForgottenNature:O2Still");
		flowingIconO2 = register.registerIcon("ForgottenNature:O2Flowing");
		stillIconOil = register.registerIcon("ForgottenNature:OilStill");
		flowingIconOil = register.registerIcon("ForgottenNature:OilFlowing");
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;
		return super.displaceIfPossible(world, x, y, z);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		int delay = 1;
		if (fluidNumber < 4) {
			if (fluidNumber == 2) {
				delay = 2;
				if (rand.nextInt(3) == 0)
					world.setBlockToAir(x, y, z);
			}

			if (rand.nextInt(delay) == 0) {
				int done = 0;
				Block block = world.getBlock(x, y + 1, z);
				if (world.isAirBlock(x, y + 1, z)) {
					world.setBlockToAir(x, y, z);
					world.setBlock(x, y + 1, z, this);
				} else
					for (int x1 = -1; x1 < 2; x1++) {
						for (int z1 = -1; z1 < 2; z1++) {
							if (world.isAirBlock(x + x1, y + 1, z + z1) && done == 0
									&& (world.isAirBlock(x + x1, y, z + z1) || world.getBlock(x, y + 1, z) == this)) {
								world.setBlockToAir(x, y, z);
								world.setBlock(x + x1, y + 1, z + z1, this);
								done = 1;
								;
							}
						}
					}
			}
		}

		else {
			int quantaRemaining = quantaPerBlock - world.getBlockMetadata(x, y, z);
			int expQuanta = -101;

			if (fluidNumber == 4 && world.isAirBlock(x, y + 1, z) && rand.nextInt(10) == 0)
				world.setBlock(x, y, z, Blocks.air);

			// check adjacent block levels if non-source
			if (quantaRemaining < quantaPerBlock) {
				int y2 = y - densityDir;

				if (world.getBlock(x, y2, z) == this || world.getBlock(x - 1, y2, z) == this
						|| world.getBlock(x + 1, y2, z) == this || world.getBlock(x, y2, z - 1) == this
						|| world.getBlock(x, y2, z + 1) == this) {
					expQuanta = quantaPerBlock - 1;
				} else {
					int maxQuanta = -100;
					maxQuanta = getLargerQuanta(world, x - 1, y, z, maxQuanta);
					maxQuanta = getLargerQuanta(world, x + 1, y, z, maxQuanta);
					maxQuanta = getLargerQuanta(world, x, y, z - 1, maxQuanta);
					maxQuanta = getLargerQuanta(world, x, y, z + 1, maxQuanta);

					expQuanta = maxQuanta - 1;
				}

				// decay calculation
				if (expQuanta != quantaRemaining) {
					quantaRemaining = expQuanta;

					if (expQuanta <= 0) {
						world.setBlock(x, y, z, Blocks.air);
					} else {
						world.setBlockMetadataWithNotify(x, y, z, quantaPerBlock - expQuanta, 3);
						world.scheduleBlockUpdate(x, y, z, this, tickRate);
						world.notifyBlocksOfNeighborChange(x, y, z, this);
					}
				}
			}
			// This is a "source" block, set meta to zero, and send a server
			// only update
			else if (quantaRemaining >= quantaPerBlock) {
				world.setBlockMetadataWithNotify(x, y, z, 0, 2);
			}

			// Flow vertically if possible
			if (canDisplace(world, x, y + densityDir, z)) {
				flowIntoBlock(world, x, y + densityDir, z, 1);
				return;
			}

			// Flow outward if possible
			int flowMeta = quantaPerBlock - quantaRemaining + 1;
			if (flowMeta >= quantaPerBlock) {
				return;
			}

			if (isSourceBlock(world, x, y, z) || !isFlowingVertically(world, x, y, z)) {
				if (world.getBlock(x, y - densityDir, z) == this) {
					flowMeta = 1;
				}
				boolean flowTo[] = getOptimalFlowDirections(world, x, y, z);

				if (flowTo[0])
					flowIntoBlock(world, x - 1, y, z, flowMeta);
				if (flowTo[1])
					flowIntoBlock(world, x + 1, y, z, flowMeta);
				if (flowTo[2])
					flowIntoBlock(world, x, y, z - 1, flowMeta);
				if (flowTo[3])
					flowIntoBlock(world, x, y, z + 1, flowMeta);
			}
		}
	}
}
