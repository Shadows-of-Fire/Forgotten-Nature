package ForgottenNature.Biomes;

import java.util.Random;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;
import ForgottenNature.WorldGen.genBeech;
import ForgottenNature.WorldGen.genBukkit;
import ForgottenNature.WorldGen.genCherry;
import ForgottenNature.WorldGen.genEucalyptus;
import ForgottenNature.WorldGen.genFruit;
import ForgottenNature.WorldGen.genFruitBush;
import ForgottenNature.WorldGen.genGinkgo;
import ForgottenNature.WorldGen.genWTEucalyptus;
import ForgottenNature.WorldGen.genWalnut;


public class BiomeGenCherryBlossomWoodland extends BiomeGenBase
{
    public BiomeGenCherryBlossomWoodland(int par1)
    {
        super(par1);
        spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
        spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 10, 4, 4));
        this.setHeight(new BiomeGenBase.Height(0.1F * ForgottenNature.cherryBlossomWoodlandMin, 
        		0.1F * ForgottenNature.cherryBlossomWoodlandMax));
        this.temperature = 0.7F;
        this.rainfall = 0.8F;
        this.setBiomeName("Cherry Blossom Woodland");
        addFlower(FNBlocks.fNFlowers,3,10);
        addFlower(FNBlocks.fNFlowers,5,10);
        addFlower(FNBlocks.fNFlowers,7,10);
        addFlower(FNBlocks.fNFlowers,8,10);
        addFlower(FNBlocks.fNFlowers,9,10);
    }
    
    @Override
	public BiomeDecorator createBiomeDecorator() {
		return new FNBiomeDecorator.Builder(this).treesPerChunk(0)
				.flowersPerChunk(2).grassPerChunk(8).build();
	}
    
    public int getBiomeFoliageColor()
    {
    	double d = (int)((1.0D + 1.0D) / 255D);
	    double d1 = (int)((1.0D + 1.0D) / 255D);
	    d1 /= d;
	    return ((ColorizerFoliage.getFoliageColor(d, d1) & 0x6ecb01));
    }
    public int getBiomeGrassColor()
    {
	    double d = (int)((1.0D + 1.0D) / 255D);
	    double d1 = (int)((1.0D + 1.0D) / 255D);
	    d1 /= d;
	    return (ColorizerGrass.getGrassColor(d, d1) & 0x6ecb01);
    }
}