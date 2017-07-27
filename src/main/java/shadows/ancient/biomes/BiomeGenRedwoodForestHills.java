package shadows.nature.Biomes;

import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import shadows.ancient.ForgottenNature;

public class BiomeGenRedwoodForestHills extends BiomeGenBase {
	public BiomeGenRedwoodForestHills(int i) {
		super(i);
		spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
		this.setHeight(new BiomeGenBase.Height(0.1F * ForgottenNature.redwoodForestHillMin, 0.1F * ForgottenNature.redwoodForestHillMax));
		this.temperature = 0.5F;
		this.rainfall = 0.7F;
		this.setBiomeName("Redwood Forest Hills");
	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new FNBiomeDecorator.Builder(this).treesPerChunk(0).flowersPerChunk(2).grassPerChunk(4).build();
	}

	public int getBiomeFoliageColor() {
		double d = (int) ((1.0D + 1.0D) / 255D);
		double d1 = (int) ((1.0D + 1.0D) / 255D);
		d1 /= d;
		return ((ColorizerFoliage.getFoliageColor(d, d1) & 0x33aa22));
	}

	public int getBiomeGrassColor() {
		double d = (int) ((1.0D + 1.0D) / 255D);
		double d1 = (int) ((1.0D + 1.0D) / 255D);
		d1 /= d;
		return (ColorizerGrass.getGrassColor(d, d1) & 0x33aa22);
	}
	// public WorldGenerator getRandomWorldGenForTrees(Random random)
	// {
	// return (WorldGenerator)(random.nextInt(8) == 0 ? new
	// genSequoia(mod_ForgottenNature.leafID2, 0, mod_ForgottenNature.logID1, 6)
	// :
	// (random.nextInt(3) > 0 ? new genCedar(mod_ForgottenNature.leafID3, 5,
	// mod_ForgottenNature.logID2, 2) : new
	// genEverBush(mod_ForgottenNature.leafID3, 2, 1)));
	// }
}
