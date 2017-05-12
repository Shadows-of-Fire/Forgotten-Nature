package ForgottenNature.WorldGen;

import java.util.Iterator;
import java.util.List;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class RemoveBiomes 
{

	public RemoveBiomes(boolean vanDesert, boolean vanExtremeHills, boolean vanMesa, boolean vanForest, 
			boolean vanBirchForest, boolean vanRoofedForest, boolean vanJungle, 
			boolean vanIcePlains, boolean vanSwampland, boolean vanTaiga, boolean vanMegaTaiga) 
	{
		if(!vanDesert)
		{
//			remove(BiomeGenBase.desert);
			BiomeManager.removeSpawnBiome(BiomeGenBase.desert);
//			remove(BiomeGenBase.desertHills);
			BiomeManager.removeSpawnBiome(BiomeGenBase.desertHills);
		}
		if(!vanExtremeHills)
		{
//			remove(BiomeGenBase.extremeHills);
			BiomeManager.removeSpawnBiome(BiomeGenBase.extremeHills);
//			remove(BiomeGenBase.extremeHillsEdge);
			BiomeManager.removeSpawnBiome(BiomeGenBase.extremeHillsEdge);
//			remove(BiomeGenBase.extremeHillsPlus);
			BiomeManager.removeSpawnBiome(BiomeGenBase.extremeHillsPlus);
		}
		if(!vanMesa)
		{
//			remove(BiomeGenBase.mesa);
			BiomeManager.removeSpawnBiome(BiomeGenBase.mesa);
//			remove(BiomeGenBase.mesaPlateau);
			BiomeManager.removeSpawnBiome(BiomeGenBase.mesaPlateau);
//			remove(BiomeGenBase.mesaPlateau_F);
			BiomeManager.removeSpawnBiome(BiomeGenBase.mesaPlateau_F);
		}
		if(!vanForest)
		{
//			remove(BiomeGenBase.forest);
			BiomeManager.removeSpawnBiome(BiomeGenBase.forest);
//			remove(BiomeGenBase.forestHills);
			BiomeManager.removeSpawnBiome(BiomeGenBase.forestHills);
		}
		if(!vanBirchForest)
		{
//			remove(BiomeGenBase.birchForest);
			BiomeManager.removeSpawnBiome(BiomeGenBase.birchForest);
//			remove(BiomeGenBase.birchForestHills);
			BiomeManager.removeSpawnBiome(BiomeGenBase.birchForestHills);
		}
		if(!vanRoofedForest)
		{
//			remove(BiomeGenBase.roofedForest);
			BiomeManager.removeSpawnBiome(BiomeGenBase.roofedForest);
		}
		if(!vanJungle)
		{
//			remove(BiomeGenBase.jungle);
			BiomeManager.removeSpawnBiome(BiomeGenBase.jungle);
//			remove(BiomeGenBase.jungleEdge);
			BiomeManager.removeSpawnBiome(BiomeGenBase.jungleEdge);
//			remove(BiomeGenBase.jungleHills);
			BiomeManager.removeSpawnBiome(BiomeGenBase.jungleHills);
		}
		if(!vanIcePlains)
		{
//			remove(BiomeGenBase.icePlains);
			BiomeManager.removeSpawnBiome(BiomeGenBase.icePlains);
		}
		if(!vanSwampland)
		{
//			remove(BiomeGenBase.swampland);
			BiomeManager.removeSpawnBiome(BiomeGenBase.swampland);
		}
		if(!vanTaiga)
		{
//			remove(BiomeGenBase.taiga);
			BiomeManager.removeSpawnBiome(BiomeGenBase.taiga);
//			remove(BiomeGenBase.taigaHills);
			BiomeManager.removeSpawnBiome(BiomeGenBase.taigaHills);
//			remove(BiomeGenBase.coldTaiga);
			BiomeManager.removeSpawnBiome(BiomeGenBase.coldTaiga);
//			remove(BiomeGenBase.coldTaigaHills);
			BiomeManager.removeSpawnBiome(BiomeGenBase.coldTaigaHills);
		}
		if(!vanMegaTaiga)
		{
//			remove(BiomeGenBase.megaTaiga);
			BiomeManager.removeSpawnBiome(BiomeGenBase.megaTaiga);
//			remove(BiomeGenBase.megaTaigaHills);
			BiomeManager.removeSpawnBiome(BiomeGenBase.megaTaigaHills);
		}
	}
	private void remove(BiomeGenBase biome)
	{
		List<BiomeEntry> biomes = BiomeManager.warmBiomes;
		Iterator<BiomeEntry> check = biomes.iterator();
		while (check.hasNext())
		{
			BiomeGenBase checkBiome = check.next().biome;
			if (checkBiome == biome)
			{
				biomes.remove(check.next());
			}
		}
		biomes = BiomeManager.desertBiomes;
		check = biomes.iterator();
		while (check.hasNext())
		{
			BiomeGenBase checkBiome = check.next().biome;
			if (checkBiome == biome)
			{
				biomes.remove(check.next());
			}
		}
		biomes = BiomeManager.coolBiomes;
		check = biomes.iterator();
		while (check.hasNext())
		{
			BiomeGenBase checkBiome = check.next().biome;
			if (checkBiome == biome)
			{
				biomes.remove(check.next());
			}
		}
	}
}
