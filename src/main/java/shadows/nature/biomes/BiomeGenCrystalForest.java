package ForgottenNature.Biomes;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

import ForgottenNature.ForgottenNature;
import ForgottenNature.WorldGen.genCrystal;
import ForgottenNature.WorldGen.genCrystalMushroom;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BiomeGenCrystalForest extends BiomeGenBase
{
    public BiomeGenCrystalForest(int par1)
    {
        super(par1);
        spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySkeleton.class, 10, 1, 1));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCreeper.class, 10, 1, 1));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySpider.class, 10, 1, 1));
        this.fillerBlock = Block.getBlockById(1);//stone
        this.setHeight(new BiomeGenBase.Height(0.1F, 0.3F));
        this.temperature = 0.8F;
        this.rainfall = 0.2F;
        this.setBiomeName("Crystal Forest");
    }
    
    @Override
	public BiomeDecorator createBiomeDecorator() {
		return new FNBiomeDecorator.Builder(this).treesPerChunk(0)
				.flowersPerChunk(0).grassPerChunk(0).build();
	}
    
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int a, int b, int c)
    {
	    double d = (int)((1.0D + 1.0D) / 255D);
	    double d1 = (int)((1.0D + 1.0D) / 255D);
	    d1 /= d;
	    return (ColorizerGrass.getGrassColor(d, d1) & 0x51eaec);
    }
//    public int getSkyColorByTemp(float par1){return 0x2678a3;}
//    public WorldGenerator getRandomWorldGenForTrees(Random random)
//    {
//    	int size = 2;
//    	if(random.nextInt(25) == 0)
//        {
//        	size = 4;
//        	if(random.nextInt(20) == 0)
//        		size = 8;
//        }
//        return (WorldGenerator)(random.nextInt(25) > 0 ? new genCrystal(mod_ForgottenNature.crystalLeavesID, 1, mod_ForgottenNature.crystalWoodID, 0, size) : //crystal
//        	(random.nextInt(25) > 0 ? new genCrystal(mod_ForgottenNature.crystalLeavesID, 0, mod_ForgottenNature.crystalWoodID, 1, size) : //darkcrystal
//        		(new genCrystalMushroom(0)))); 
//    }
}