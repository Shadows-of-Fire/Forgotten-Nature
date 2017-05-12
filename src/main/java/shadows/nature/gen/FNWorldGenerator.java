package shadows.nature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import shadows.nature.FNBlocks;
import shadows.nature.ForgottenNature;

public class FNWorldGenerator implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		Block flowers = FNBlocks.fNFlowers;
		Block nStone = FNBlocks.newStones;
		Block fNNewLogs1 = FNBlocks.newLogs1;
		Block fNNewLeaves1 = FNBlocks.newLeaves1;
		int bID = ForgottenNature.biomeIDIndex;
		int i = chunkX * 16;
		int j = chunkZ * 16;
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(i, j);
		float biomeRain = world.getWorldChunkManager().getBiomeGenAt(i, j).rainfall;
		int il;
		float biomeTemp = world.getWorldChunkManager().getBiomeGenAt(i, j).temperature;
		int k;
		int l;
		int num;
		int blackOrBlue;
		Block vLog = Block.getBlockById(17);

		// new flower generation in all biomes if grass exists
		if (random.nextInt(5) == 0) {
			num = random.nextInt(10);
			for (int ll = 0; ll < 15; ll++) {
				k = i + random.nextInt(8) + 8;
				l = j + random.nextInt(8) + 8;
				il = world.getHeightValue(k, l);
				if (world.getBlock(k, il - 1, l) == Block.getBlockById(2))// grass
				{
					world.setBlock(k, il, l, flowers, num, 2);
					world.setBlock(k, il, l, flowers, num, 2);
					world.setBlock(k, il, l, flowers, num, 2);
					world.setBlock(k, il, l, flowers, num, 2);
					world.setBlock(k, il, l, flowers, num, 2);
					world.setBlock(k, il, l, flowers, num, 2);
					world.setBlock(k, il, l, flowers, num, 2);
					world.setBlock(k, il, l, flowers, num, 2);
					world.setBlock(k, il, l, flowers, num, 2);
					world.setBlock(k, il, l, flowers, num, 2);
				}
			}
		}
		for (int ll = 0; ll < 15; ll++)// generating new stones
		{
			if (random.nextInt(5) == 0) {
				il = i + random.nextInt(10);
				k = j + random.nextInt(10);
				l = random.nextInt(60) + 4;
				new WorldGenMinable(nStone, 0, 10, Blocks.stone).generate(world, random, il, l, k);
				l = random.nextInt(25) + 4;
				new WorldGenMinable(nStone, 0, 10, Blocks.stone).generate(world, random, il, l, k);
			} else if (random.nextInt(5) == 0) {
				il = i + random.nextInt(10);
				k = j + random.nextInt(10);
				l = random.nextInt(60) + 4;
				new WorldGenMinable(nStone, 1, 30, Blocks.stone).generate(world, random, il, l, k);
				l = random.nextInt(25) + 4;
				new WorldGenMinable(nStone, 1, 30, Blocks.stone).generate(world, random, il, l, k);
			} else if (random.nextInt(5) == 0) {
				il = i + random.nextInt(10);
				k = j + random.nextInt(10);
				l = random.nextInt(60) + 4;
				new WorldGenMinable(nStone, 2, 30, Blocks.stone).generate(world, random, il, l, k);
				l = random.nextInt(25) + 4;
				new WorldGenMinable(nStone, 2, 30, Blocks.stone).generate(world, random, il, l, k);
			} else if (random.nextInt(5) == 0) {
				il = i + random.nextInt(10);
				k = j + random.nextInt(10);
				l = random.nextInt(60) + 4;
				new WorldGenMinable(nStone, 3, 30, Blocks.stone).generate(world, random, il, l, k);
				l = random.nextInt(25) + 4;
				new WorldGenMinable(nStone, 3, 30, Blocks.stone).generate(world, random, il, l, k);
			} else if (random.nextInt(5) == 0) {
				il = i + random.nextInt(10);
				k = j + random.nextInt(10);
				l = random.nextInt(60) + 4;
				new WorldGenMinable(nStone, 4, 30, Blocks.stone).generate(world, random, il, l, k);
				l = random.nextInt(25) + 4;
				new WorldGenMinable(nStone, 4, 30, Blocks.stone).generate(world, random, il, l, k);
			}
		}
		// floating islands
		if (random.nextInt(800) == 0) {
			k = i + random.nextInt(12) + 8;
			l = j + random.nextInt(12) + 8;
			il = world.getHeightValue(k, l);
			if (world.getBlock(k, il - 1, l) != Blocks.water && ForgottenNature.floatingIslands)// grass
				new genFloatingIsland().generate(world, random, k, il, l);
		}
		// bamboo generation
		if (biomeRain > 0.8F && biomeTemp > 0.5F && !(biome.biomeID == 6)) {
			if (random.nextInt(2) == 0) {
				for (int ll = 0; ll < 3; ll++) {
					k = i + random.nextInt(14) + 8;
					l = j + random.nextInt(14) + 8;
					il = world.getHeightValue(k, l);
					if (world.getBlock(k, il - 1, l) == Block.getBlockById(2) && ForgottenNature.bambooGeneration)// grass
						world.setBlock(k, il, l, FNBlocks.hempCotBamCorn, 8, 2);
				}
			}
		}
		// Crystal 'flower' generation
		if (biome.biomeID == (bID + 4)) {
			for (int l2 = 0; l2 < 2; l2++) {
				if (random.nextInt(60) == 0)
					blackOrBlue = 1;
				else
					blackOrBlue = 0;
				for (int ll = 0; ll < 15; ll++) {
					k = i + random.nextInt(16) + 8;
					l = j + random.nextInt(16) + 8;
					il = world.getHeightValue(k, l);
					if (world.getBlock(k, il - 1, l) == Block.getBlockById(2))// grass
						world.setBlock(k, il, l, FNBlocks.crystalStone, blackOrBlue, 2);
				}
			}
		}
		// FN and vanilla biome instances
		if (biome.biomeID == 16) // beach
		{
			if (random.nextInt(16) == 0 && ForgottenNature.palm) {
				genPalm tree = new genPalm(FNBlocks.newLeaves3, 3, fNNewLogs1, 14); // palm
																					// tree
				k = i + random.nextInt(8) + 8;
				l = j + random.nextInt(8) + 8;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(16) == 0 && ForgottenNature.banana) {
				genPalm tree = new genPalm(FNBlocks.newLeaves4, 5, FNBlocks.newLogs3, 1); // banana
																							// tree
				k = i + random.nextInt(8) + 8;
				l = j + random.nextInt(8) + 8;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			}
		}
		if (biome.biomeID == 2 || biome.biomeID == 17)// desert
		{
			if (random.nextInt(75) == 0 && ForgottenNature.DesertIronwood) // ironwood
			{
				genDesertTree tree = new genDesertTree(fNNewLeaves1, 6, fNNewLogs1, 2);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(65) == 0 && ForgottenNature.Joshua) // joshua
			{
				genJoshua tree = new genJoshua(FNBlocks.newLeaves2, 7, fNNewLogs1, 10);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			}

			if (random.nextInt(100) == 0 && ForgottenNature.dWillow) // dWillow
			{
				genDWillow tree = new genDWillow(FNBlocks.newLeaves3, 4, FNBlocks.newLogs2, 0);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			}
		}
		if ((biome.biomeID == 1))// plains
		{
			if (random.nextInt(12) == 0 && ForgottenNature.Cypress) // cypress
			{
				genCypress tree = new genCypress(fNNewLeaves1, 5, vLog, 1);
				k = i + random.nextInt(16) + 6;
				l = j + random.nextInt(16) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(14) == 0 && ForgottenNature.poplar) // poplar
			{
				int size = 2 + random.nextInt(6);
				genPoplar tree = new genPoplar(FNBlocks.newLeaves3, 7, vLog, 1);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(70) == 0 && ForgottenNature.Fig) // fig
			{
				genFig tree = new genFig(fNNewLeaves1, 4, 0, 2);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			}
		}
		if ((biome.biomeID == 3 || biome.biomeID == 20 || biome.biomeID == 34))// hills
		{
			if (random.nextInt(40) == 0 && ForgottenNature.huckleberry)// huckleberrybush
			{
				genFruitBush tree = new genFruitBush(FNBlocks.newLeaves6, 0, 0);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			}
		}
		if ((biome.biomeID == 4 || biome.biomeID == 18 || biome.biomeID == 27 || biome.biomeID == 28))// forests
		{
			if (random.nextInt(80) == 0 && ForgottenNature.bukkit) // bukkit
			{
				genBukkit tree = new genBukkit(FNBlocks.newLeaves4, 4, FNBlocks.newLogs3, 0);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(30) == 0 && ForgottenNature.raspberry) // raspberrybush
			{
				genFruitBush tree = new genFruitBush(FNBlocks.newLeaves5, 3, 0);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(30) == 0 && ForgottenNature.blueberry) // blueberrybush
			{
				genFruitBush tree = new genFruitBush(FNBlocks.newLeaves5, 1, 0);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(30) == 0 && ForgottenNature.blackberry) // blackberrybush
			{
				genFruitBush tree = new genFruitBush(FNBlocks.newLeaves5, 5, 0);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(40) == 0 && ForgottenNature.Apple) // apple
			{
				genFruit tree = new genFruit(true, FNBlocks.newLeaves2, 3, vLog, 0, 1);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(40) == 0 && ForgottenNature.orange) // orange
			{
				genFruit tree = new genFruit(false, FNBlocks.newLeaves4, 6, FNBlocks.newLogs3, 2, 1);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(40) == 0 && ForgottenNature.peach) // peach
			{
				genFruit tree = new genFruit(false, FNBlocks.newLeaves4, 7, FNBlocks.newLogs3, 3, 1);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(40) == 0 && ForgottenNature.lemon) // lemon
			{
				genFruit tree = new genFruit(false, FNBlocks.newLeaves5, 0, FNBlocks.newLogs3, 4, 1);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(41) == 0 && ForgottenNature.Cherry) // cherry
			{
				genCherry tree = new genCherry(FNBlocks.newLeaves2, 1, fNNewLogs1, 0);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(42) == 0 && ForgottenNature.Jacaranda) // jacaranda
			{
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				new genCherry(fNNewLeaves1, 3, vLog, 0).generate(world, random, k, il, l);
				k = i + random.nextInt(18);
				l = j + random.nextInt(18);
				il = world.getHeightValue(k, l);
				new genCherry(fNNewLeaves1, 3, vLog, 0).generate(world, random, k, il, l);
				k = i + random.nextInt(18);
				l = j + random.nextInt(18);
				il = world.getHeightValue(k, l);
				new genCherry(fNNewLeaves1, 3, vLog, 0).generate(world, random, k, il, l);
				k = i + random.nextInt(18);
				l = j + random.nextInt(18);
				il = world.getHeightValue(k, l);
				new genCherry(fNNewLeaves1, 3, vLog, 0).generate(world, random, k, il, l);
			} else if (random.nextInt(50) == 0 && ForgottenNature.Eucalyptus) // eucalyptus
			{
				genEucalyptus tree = new genEucalyptus(fNNewLeaves1, 7, fNNewLogs1, 4);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(50) == 0 && ForgottenNature.wTopEucalyptus) // WTeucalyptus
			{
				genWTEucalyptus tree = new genWTEucalyptus(FNBlocks.newLeaves4, 3, FNBlocks.newLogs2, 14);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(50) == 0 && ForgottenNature.walnut) // walnut
			{
				genWalnut tree = new genWalnut(FNBlocks.newLeaves4, 1, FNBlocks.newLogs2, 8);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(50) == 0 && ForgottenNature.beech) // beech
			{
				genBeech tree = new genBeech(FNBlocks.newLeaves4, 0, FNBlocks.newLogs2, 6);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(51) == 0 && ForgottenNature.ginkgo) // ginkgo
			{
				genGinkgo tree = new genGinkgo(FNBlocks.newLeaves3, 6, FNBlocks.newLogs2, 4);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(8) == 0 && ForgottenNature.decBush) // decbush
			{
				genDecBush tree = new genDecBush(FNBlocks.newLeaves3, 1, 0);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			}

			if (random.nextInt(300) == 0 && ForgottenNature.AngelOak) // angeloak
			{
				genAngel tree = new genAngel(fNNewLeaves1, 1);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			}
		}
		if ((biome.biomeID == 6))// swamp
		{
			if (random.nextInt(40) == 0 && ForgottenNature.Willow) // SWillow
			{
				int size = 2 + random.nextInt(6);
				genWillow tree = new genWillow(FNBlocks.newLeaves3, 0, fNNewLogs1, 12, size);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			}
		}
		if ((biome.biomeID == 5 || biome.biomeID == 19 || biome.biomeID == 30 || biome.biomeID == 31
				|| biome.biomeID == 32 || biome.biomeID == 33))// taigas
		{
			if (random.nextInt(50) == 0 && ForgottenNature.RedMaple) // rMaple
			{
				genCherry tree = new genCherry(fNNewLeaves1, 0, vLog, 0);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(50) == 0 && ForgottenNature.YellowMaple) // yMaple
			{
				genCherry tree = new genCherry(fNNewLeaves1, 2, vLog, 0);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(130) == 0 && ForgottenNature.Sequoia) // sequoia
			{
				genSequoia tree = new genSequoia(FNBlocks.newLeaves2, 0, fNNewLogs1, 6);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(9) == 0 && ForgottenNature.cedar) // cedar
			{
				genCedar tree = new genCedar(FNBlocks.newLeaves3, 5, FNBlocks.newLogs2, 2);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			}

			if (random.nextInt(9) == 0 && ForgottenNature.everBush) // everBush
			{
				genEverBush tree = new genEverBush(FNBlocks.newLeaves3, 2, 1);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = world.getHeightValue(k, l);
				tree.generate(world, random, k, il, l);
			}
		}
		// FN biomes
		if (biome.biomeID == (bID + 4))// crystal
		{
			int size = 2;
			if (random.nextInt(25) == 0) {
				size = 4;
				if (random.nextInt(20) == 0)
					size = 8;
			}
			for (int iter = 0; iter <= ForgottenNature.newTreePerChunkCount; iter++) {
				if (random.nextInt(24) > 0) // crystal
				{
					genCrystal tree = new genCrystal(FNBlocks.crystalLeaves, 1, FNBlocks.crystalWood, 0, size);
					k = i + random.nextInt(14) + 8;
					l = j + random.nextInt(14) + 8;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(24) > 0) // darkcrystal
				{
					genCrystal tree = new genCrystal(FNBlocks.crystalLeaves, 0, FNBlocks.crystalWood, 1, size);
					k = i + random.nextInt(14) + 8;
					l = j + random.nextInt(14) + 8;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				}
				if (ForgottenNature.crystalMushrooms && random.nextInt(80) == 0) {
					genCrystalMushroom tree = new genCrystalMushroom(0);
					k = i + random.nextInt(14) + 8;
					l = j + random.nextInt(14) + 8;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				}
			}
			for (int ll = 0; ll < 15; ll++) {
				il = i + random.nextInt(10);
				k = j + random.nextInt(10);
				l = random.nextInt(64) + 4;
				new WorldGenMinable(FNBlocks.crystalBlock, 4).generate(world, random, il, l, k);
				l = random.nextInt(25) + 4;
				new WorldGenMinable(FNBlocks.crystalBlock, 4).generate(world, random, il, l, k);
			}
		}
		if (biome.biomeID == (bID + 2) || biome.biomeID == (bID + 3))// redwood
																		// forest
		{
			for (int iter = 0; iter <= ForgottenNature.newTreePerChunkCount; iter++) {
				if (random.nextInt(8) == 0 && ForgottenNature.Sequoia) // sequoia
				{
					genSequoia tree = new genSequoia(FNBlocks.newLeaves2, 0, fNNewLogs1, 6);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(3) > 0 && ForgottenNature.cedar) // cedar
				{
					genCedar tree = new genCedar(FNBlocks.newLeaves3, 5, FNBlocks.newLogs2, 2);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (ForgottenNature.everBush) // evergreenBus
				{
					genEverBush tree = new genEverBush(FNBlocks.newLeaves3, 2, 1);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				}
			}
		}
		if (biome.biomeID == (bID + 5))// greatwood forest
		{
			for (int iter = 0; iter <= ForgottenNature.newTreePerChunkCount; iter++) {
				if (random.nextInt(18) == 0 && ForgottenNature.AngelOak) // angel
																			// oak
				{
					genAngel tree = new genAngel(fNNewLeaves1, 1);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(18) == 0 && ForgottenNature.Fig) // fig
																			// tree
				{
					genFig tree = new genFig(fNNewLeaves1, 4, 0, 2);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(8) == 0 && ForgottenNature.decBush) // deciduous
																				// bush
				{
					genDecBush tree = new genDecBush(FNBlocks.newLeaves3, 1, 0);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				}
			}
		}
		if (biome.biomeID == (bID + 6))// maple forest
		{
			for (int iter = 0; iter <= ForgottenNature.newTreePerChunkCount; iter++) {
				if (random.nextInt(2) == 0 && ForgottenNature.YellowMaple) // ymaple
				{
					genCherry tree = new genCherry(fNNewLeaves1, 2, vLog, 0);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);

					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (ForgottenNature.RedMaple) // rmaple
				{
					genCherry tree = new genCherry(fNNewLeaves1, 0, vLog, 0);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);

					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				}
				if (random.nextInt(8) == 0 && ForgottenNature.decBush) // deciduous
																		// bush
				{
					genDecBush tree = new genDecBush(FNBlocks.newLeaves3, 1, 0);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				}
			}
		}
		if (biome.biomeID == (bID + 8))// cherry woodland
		{
			for (int iter = 0; iter <= ForgottenNature.newTreePerChunkCount; iter++) {
				if (ForgottenNature.Cherry) {
					genCherry tree = new genCherry(FNBlocks.newLeaves2, 1, fNNewLogs1, 0);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);

					if (random.nextInt(2) == 0) {
						k = i + random.nextInt(12) + 6;
						l = j + random.nextInt(12) + 6;
						il = world.getHeightValue(k, l);
						tree.generate(world, random, k, il, l);
					}
				}
				if (random.nextInt(8) == 0 && ForgottenNature.decBush) // deciduous
																		// bush
				{
					genDecBush tree = new genDecBush(FNBlocks.newLeaves3, 1, 0);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				}
			}
		}
		if (biome.biomeID == (bID + 9))// eucalyptus forest
		{
			for (int iter = 0; iter <= ForgottenNature.newTreePerChunkCount; iter++) {
				if (random.nextInt(2) == 0 && ForgottenNature.Eucalyptus) {
					genEucalyptus tree = new genEucalyptus(fNNewLeaves1, 7, fNNewLogs1, 4);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(2) == 0 && ForgottenNature.wTopEucalyptus) {
					genWTEucalyptus tree = new genWTEucalyptus(FNBlocks.newLeaves4, 3, FNBlocks.newLogs2, 14);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(2) == 0) {
					genEucalyptus tree = new genEucalyptus(fNNewLeaves1, 7, fNNewLogs1, 4);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				}
				if (random.nextInt(8) == 0 && ForgottenNature.decBush) // deciduous
																		// bush
				{
					genDecBush tree = new genDecBush(FNBlocks.newLeaves3, 1, 0);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				}
			}
		}
		if (biome.biomeID == bID || biome.biomeID == (bID + 1))// tropical
																// forest
		{
			for (int iter = 0; iter <= ForgottenNature.newTreePerChunkCount; iter++) {
				if (random.nextInt(30) == 0 && ForgottenNature.beech) // beech
				{
					genBeech tree = new genBeech(FNBlocks.newLeaves4, 0, FNBlocks.newLogs2, 6);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(11) == 0 && ForgottenNature.wTopEucalyptus) // genWTEucalyptus
				{
					genWTEucalyptus tree = new genWTEucalyptus(FNBlocks.newLeaves4, 3, FNBlocks.newLogs2, 14);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(11) == 0 && ForgottenNature.Eucalyptus) // genEucalyptus
				{
					genEucalyptus tree = new genEucalyptus(fNNewLeaves1, 7, fNNewLogs1, 4);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(50) == 0 && ForgottenNature.bukkit) // bukkit
				{
					genBukkit tree = new genBukkit(FNBlocks.newLeaves4, 4, FNBlocks.newLogs3, 0);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(30) == 0 && ForgottenNature.raspberry) // rasp
				{
					genFruitBush tree = new genFruitBush(FNBlocks.newLeaves5, 3, 0);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(30) == 0 && ForgottenNature.blueberry) // blue
				{
					genFruitBush tree = new genFruitBush(FNBlocks.newLeaves5, 1, 0);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(30) == 0 && ForgottenNature.blackberry) // black
				{
					genFruitBush tree = new genFruitBush(FNBlocks.newLeaves5, 5, 0);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(50) == 0 && ForgottenNature.Apple) // apple
				{
					genFruit tree = new genFruit(true, FNBlocks.newLeaves2, 3, vLog, 0, 1);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(50) == 0 && ForgottenNature.orange) // orange
				{
					genFruit tree = new genFruit(false, FNBlocks.newLeaves4, 6, FNBlocks.newLogs3, 2, 1);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(50) == 0 && ForgottenNature.peach) // peach
				{
					genFruit tree = new genFruit(false, FNBlocks.newLeaves4, 7, FNBlocks.newLogs3, 3, 1);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(50) == 0 && ForgottenNature.lemon) // lemon
				{
					genFruit tree = new genFruit(false, FNBlocks.newLeaves5, 0, FNBlocks.newLogs3, 4, 1);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(50) == 0 && ForgottenNature.Cherry) // cherry
				{
					genCherry tree = new genCherry(FNBlocks.newLeaves2, 1, fNNewLogs1, 0);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(61) == 0 && ForgottenNature.walnut) // walnut
				{
					genWalnut tree = new genWalnut(FNBlocks.newLeaves4, 1, FNBlocks.newLogs2, 8);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				} else if (random.nextInt(60) == 0 && ForgottenNature.ginkgo) // ginkgo
				{
					genGinkgo tree = new genGinkgo(FNBlocks.newLeaves3, 6, FNBlocks.newLogs2, 4);
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				}
				if (random.nextInt(42) == 0 && ForgottenNature.Jacaranda) // jacaranda
				{
					k = i + random.nextInt(12) + 6;
					l = j + random.nextInt(12) + 6;
					il = world.getHeightValue(k, l);
					new genCherry(fNNewLeaves1, 3, vLog, 0).generate(world, random, k, il, l);
					k = i + random.nextInt(18);
					l = j + random.nextInt(18);
					il = world.getHeightValue(k, l);
					new genCherry(fNNewLeaves1, 3, vLog, 0).generate(world, random, k, il, l);
					k = i + random.nextInt(18);
					l = j + random.nextInt(18);
					il = world.getHeightValue(k, l);
					new genCherry(fNNewLeaves1, 3, vLog, 0).generate(world, random, k, il, l);
					k = i + random.nextInt(18);
					l = j + random.nextInt(18);
					il = world.getHeightValue(k, l);
					new genCherry(fNNewLeaves1, 3, vLog, 0).generate(world, random, k, il, l);
				} else if (ForgottenNature.decBush) {
					genDecBush tree = new genDecBush(FNBlocks.newLeaves3, 1, 0);
					k = i + random.nextInt(18) + 6;
					l = j + random.nextInt(18) + 6;
					il = world.getHeightValue(k, l);
					tree.generate(world, random, k, il, l);
				}
			}
		}
		if (biome.biomeID == 8)// nether
		{
			if (random.nextInt(5) == 0) // nether ash
			{
				genNetherTree tree = new genNetherTree(0, 0, 1);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = 75;
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(5) == 0) // nether blaze
			{
				genNetherTree tree = new genNetherTree(1, 1, 1);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = 75;
				tree.generate(world, random, k, il, l);
			} else if (random.nextInt(15) == 0)// nether mushroom
			{
				genNetherMushroom tree = new genNetherMushroom(FNBlocks.netherLogs);
				k = i + random.nextInt(12) + 6;
				l = j + random.nextInt(12) + 6;
				il = 75;
				tree.generate(world, random, k, il, l);
			}
		}
	}
}
