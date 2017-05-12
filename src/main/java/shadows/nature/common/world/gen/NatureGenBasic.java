package shadows.nature.common.world.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IWorldGenerator;
import shadows.nature.util.INatureFeature;

public abstract class NatureGenBasic implements IWorldGenerator{

	private final INatureFeature feature;
	
	public abstract void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider);

	protected NatureGenBasic(INatureFeature feature){
		MinecraftForge.TERRAIN_GEN_BUS.register(this);
		this.feature = feature;
	}
	
}
