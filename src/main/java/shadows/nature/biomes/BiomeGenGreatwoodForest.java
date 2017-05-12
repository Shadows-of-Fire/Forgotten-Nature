package ForgottenNature.Biomes;

import java.util.Random;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import ForgottenNature.ForgottenNature;
import ForgottenNature.WorldGen.genCedar;
import ForgottenNature.WorldGen.genEverBush;
import ForgottenNature.WorldGen.genSequoia;


public class BiomeGenGreatwoodForest extends BiomeGenBase
{
    public BiomeGenGreatwoodForest(int i)
    {
        super(i);
        spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
        spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
        this.setHeight(new BiomeGenBase.Height(0.1F * ForgottenNature.greatwoodForestMin, 
        		0.1F * ForgottenNature.greatwoodForestMax));
        this.temperature = 0.5F;
        this.rainfall = 0.7F;
        this.setBiomeName("Greatwood Forest");
    }
    
    @Override
	public BiomeDecorator createBiomeDecorator() {
		return new FNBiomeDecorator.Builder(this).treesPerChunk(0)
				.flowersPerChunk(2).grassPerChunk(4).build();
	}
}
