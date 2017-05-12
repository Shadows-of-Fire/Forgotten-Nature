package shadows.nature.Biomes;

import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNBlocks;
import shadows.nature.ForgottenNature;

public class BiomeGenMapleForest extends BiomeGenBase {
	public BiomeGenMapleForest(int par1) {
		super(par1);
		spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
		this.setHeight(
				new BiomeGenBase.Height(0.1F * ForgottenNature.mapleForestMin, 0.1F * ForgottenNature.mapleForestMax));
		this.temperature = 0.5F;
		this.rainfall = 0.7F;
		this.setBiomeName("Maple Forest");
		addFlower(FNBlocks.fNFlowers, 0, 10);
		addFlower(FNBlocks.fNFlowers, 2, 10);
		addFlower(FNBlocks.fNFlowers, 3, 10);
		addFlower(FNBlocks.fNFlowers, 4, 10);
		addFlower(FNBlocks.fNFlowers, 5, 10);
		addFlower(FNBlocks.fNFlowers, 6, 10);
		addFlower(FNBlocks.fNFlowers, 7, 10);
		addFlower(FNBlocks.fNFlowers, 8, 10);
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
		return ((ColorizerFoliage.getFoliageColor(d, d1) & 0x676f1f));
	}

	@SideOnly(Side.CLIENT)
	public int getBiomeGrassColor(int a, int b, int c) {
		double d = (int) ((1.0D + 1.0D) / 255D);
		double d1 = (int) ((1.0D + 1.0D) / 255D);
		d1 /= d;
		return (ColorizerGrass.getGrassColor(d, d1) & 0x676f1f);
	}
}