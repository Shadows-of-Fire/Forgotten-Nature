package shadows.nature.Biomes;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;
import shadows.ancient.ForgottenNature;

public class BiomeGenEucalyptusForest extends BiomeGenBase {
	public BiomeGenEucalyptusForest(int par1) {
		super(par1);
		spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
		spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
		this.setHeight(new BiomeGenBase.Height(0.1F * ForgottenNature.eucalyptusForestMin, 0.1F * ForgottenNature.eucalyptusForestMax));
		this.temperature = 0.7F;
		this.rainfall = 0.7F;
		this.setBiomeName("Eucalyptus Forest");
		addFlower(FNBlocks.fNFlowers, 1, 10);
		addFlower(FNBlocks.fNFlowers, 2, 10);
		addFlower(FNBlocks.fNFlowers, 3, 10);
		addFlower(FNBlocks.fNFlowers, 4, 10);
		addFlower(FNBlocks.fNFlowers, 6, 10);
		addFlower(FNBlocks.fNFlowers, 9, 10);
	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new FNBiomeDecorator.Builder(this).treesPerChunk(0).flowersPerChunk(2).grassPerChunk(8).build();
	}

	@SideOnly(Side.CLIENT)
	public int getBiomeFoliageColor(int a, int b, int c) {
		double d = (int) ((1.0D + 1.0D) / 255D);
		double d1 = (int) ((1.0D + 1.0D) / 255D);
		d1 /= d;
		return ((ColorizerFoliage.getFoliageColor(d, d1) & 0x028500));
	}

	@SideOnly(Side.CLIENT)
	public int getBiomeGrassColor(int a, int b, int c) {
		double d = (int) ((1.0D + 1.0D) / 255D);
		double d1 = (int) ((1.0D + 1.0D) / 255D);
		d1 /= d;
		return (ColorizerGrass.getGrassColor(d, d1) & 0x028500);
	}
}