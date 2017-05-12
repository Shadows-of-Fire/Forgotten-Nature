package shadows.nature.Biomes;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import shadows.nature.FNBlocks;
import shadows.nature.ForgottenNature;

public class BiomeGenTropicalForestHills extends BiomeGenBase {
	public BiomeGenTropicalForestHills(int par1) {
		super(par1);
		spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
		spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
		this.setHeight(new BiomeGenBase.Height(0.1F * ForgottenNature.tropicalForestHillMin,
				0.1F * ForgottenNature.tropicalForestHillMax));
		this.temperature = 0.9F;
		this.rainfall = 0.9F;
		this.setBiomeName("Tropical Forest Hills");
		addFlower(FNBlocks.fNFlowers, 0, 10);
		addFlower(FNBlocks.fNFlowers, 1, 10);
		addFlower(FNBlocks.fNFlowers, 2, 10);
		addFlower(FNBlocks.fNFlowers, 3, 10);
		addFlower(FNBlocks.fNFlowers, 4, 10);
		addFlower(FNBlocks.fNFlowers, 5, 10);
		addFlower(FNBlocks.fNFlowers, 6, 10);
		addFlower(FNBlocks.fNFlowers, 7, 10);
		addFlower(FNBlocks.fNFlowers, 8, 10);
		addFlower(FNBlocks.fNFlowers, 9, 10);
	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new FNBiomeDecorator.Builder(this).treesPerChunk(0).flowersPerChunk(2).grassPerChunk(8).build();
	}

	public int getBiomeFoliageColor() {
		double d = (int) ((1.0D + 1.0D) / 255D);
		double d1 = (int) ((1.0D + 1.0D) / 255D);
		d1 /= d;
		return ((ColorizerFoliage.getFoliageColor(d, d1) & 0x6ecb01));
	}

	public int getBiomeGrassColor() {
		double d = (int) ((1.0D + 1.0D) / 255D);
		double d1 = (int) ((1.0D + 1.0D) / 255D);
		d1 /= d;
		return (ColorizerGrass.getGrassColor(d, d1) & 0x6ecb01);
	}
	// public WorldGenerator getRandomWorldGenForTrees(Random random)
	// {
	// return (WorldGenerator)(random.nextInt(30) == 0 ? new
	// genBeech(mod_ForgottenNature.leafID4, 0, mod_ForgottenNature.logID2, 6) :
	// (random.nextInt(11) == 0 ? new
	// genWTEucalyptus(mod_ForgottenNature.leafID4, 3,
	// mod_ForgottenNature.logID2, 14) :
	// (random.nextInt(11) == 0 ? new genEucalyptus(mod_ForgottenNature.leafID1,
	// 7, mod_ForgottenNature.logID1, 4) :
	// (random.nextInt(50) == 0 ? new genBukkit(mod_ForgottenNature.leafID4, 4,
	// mod_ForgottenNature.logID3, 0) :
	// (random.nextInt(30) == 0 ? new genFruitBush(mod_ForgottenNature.leafID5,
	// 3, 0) : //rasp
	// (random.nextInt(30) == 0 ? new genFruitBush(mod_ForgottenNature.leafID5,
	// 1, 0) : //blue
	// (random.nextInt(30) == 0 ? new genFruitBush(mod_ForgottenNature.leafID5,
	// 5, 0) : //black
	// (random.nextInt(50) == 0 ? new genCocoa(mod_ForgottenNature.leafID4, 2,
	// mod_ForgottenNature.logID2, 10):
	// (random.nextInt(50) == 0 ? new genFruit(true,
	// mod_ForgottenNature.leafID2, 3, 17, 0, 1) : //apple
	// (random.nextInt(50) == 0 ? new genFruit(false,
	// mod_ForgottenNature.leafID4, 6, mod_ForgottenNature.logID3, 4, 1) :
	// //orange
	// (random.nextInt(50) == 0 ? new genFruit(false,
	// mod_ForgottenNature.leafID4, 7, mod_ForgottenNature.logID3, 6, 1) :
	// //peach
	// (random.nextInt(50) == 0 ? new genFruit(false,
	// mod_ForgottenNature.leafID5, 0, mod_ForgottenNature.logID3, 8, 1) :
	// //lemon
	// (random.nextInt(50) == 0 ? new genCherry(mod_ForgottenNature.leafID2, 1,
	// mod_ForgottenNature.logID1, 0) : //cherry
	// (random.nextInt(61) == 0 ? new genWalnut(mod_ForgottenNature.leafID4, 1,
	// mod_ForgottenNature.logID2, 8) :
	// (random.nextInt(60) == 0 ? new genGinkgo(mod_ForgottenNature.leafID3, 6,
	// mod_ForgottenNature.logID2, 4) :
	// this.worldGeneratorTrees)))))))))))))));
	// }
}