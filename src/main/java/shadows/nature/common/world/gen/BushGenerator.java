package shadows.nature.common.world.gen;

import java.util.Random;

import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import shadows.nature.common.world.feature.Bush;
import shadows.nature.registry.ModRegistry;
import shadows.nature.util.NatureData;
import shadows.nature.util.NatureData.BushSet;

public class BushGenerator implements IWorldGenerator {

	public BushGenerator() {
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator gen, IChunkProvider prov) {
		if (rand.nextInt(20) != 0)
			return;
		int posX = chunkX * 16;
		int posZ = chunkZ * 16;
		BlockPos genPos = new BlockPos(posX + MathHelper.getInt(rand, 2, 14), 0, posZ + MathHelper.getInt(rand, 2, 14));
		genPos = world.getTopSolidOrLiquidBlock(genPos);
		IBlockState state = world.getBlockState(genPos.down());
		if (state.getBlock().canSustainPlant(state, world, genPos.down(), EnumFacing.DOWN, Blocks.TALLGRASS)) {
			BUSHGENS[rand.nextInt(6)].generate(world, rand, genPos);
		}
	}

	public static final Bush BLACKBERRY_BUSH = new Bush(Blocks.LOG.getDefaultState(), ModRegistry.BUSH.getDefaultState().withProperty(NatureData.BUSHES, BushSet.BLACKBERRY), false);
	public static final Bush BLUEBERRY_BUSH = new Bush(Blocks.LOG.getDefaultState(), ModRegistry.BUSH.getDefaultState().withProperty(NatureData.BUSHES, BushSet.BLUEBERRY), false);
	public static final Bush DECIDUOUS_BUSH = new Bush(Blocks.LOG.getDefaultState(), ModRegistry.BUSH.getDefaultState().withProperty(NatureData.BUSHES, BushSet.DECIDUOUS), false);
	public static final Bush EVERGREEN_BUSH = new Bush(Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, EnumType.SPRUCE), ModRegistry.BUSH.getDefaultState().withProperty(NatureData.BUSHES, BushSet.EVERGREEN), false);
	public static final Bush HUCKLEBERRY_BUSH = new Bush(Blocks.LOG.getDefaultState(), ModRegistry.BUSH.getDefaultState().withProperty(NatureData.BUSHES, BushSet.HUCKLEBERRY), false);
	public static final Bush RASPBERRY_BUSH = new Bush(Blocks.LOG.getDefaultState(), ModRegistry.BUSH.getDefaultState().withProperty(NatureData.BUSHES, BushSet.RASPBERRY), false);
	public static final Bush[] BUSHGENS = { BLACKBERRY_BUSH, BLUEBERRY_BUSH, DECIDUOUS_BUSH, EVERGREEN_BUSH, HUCKLEBERRY_BUSH, RASPBERRY_BUSH };

}
