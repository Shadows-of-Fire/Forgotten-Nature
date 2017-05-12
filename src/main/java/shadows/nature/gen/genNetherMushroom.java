package shadows.nature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import shadows.nature.FNBlocks;

public class genNetherMushroom extends WorldGenerator

{
	Block block;

	public genNetherMushroom(Block i) {
		block = i;
	}

	public boolean generate(World world, Random random, int i, int j, int k) {
		if (world.isRemote)
			return false;

		int l = random.nextInt(6) + 6;// height

		if (j < 4 || j + l + 1 >= 256) {
			return false;
		}

		Block met = world.getBlock(i, j, k);

		while (met != Blocks.netherrack && met != Blocks.dirt && met != Blocks.grass) {
			j--;
			met = world.getBlock(i, j, k);

			if (met == Blocks.flowing_water | met == Blocks.water | met == Blocks.stone) {
				return false;
			}
		}
		j = j + 1;

		world.setBlock(i, j - 1, k, Block.getBlockById(87), 0, 3);// netherrack

		boolean flag = false;
		int l1 = 0;

		genCap(world, random, i, j + l / 4 + 2, k, block, 3, l);

		while (!flag && l1 < 6) {
			world.setBlock(i - 1 * l1, j + l1, k, block, 2, 3);
			world.setBlock(i + 1 * l1, j + l1, k, block, 2, 3);
			world.setBlock(i, j + l1, k - 1 * l1, block, 2, 3);
			world.setBlock(i, j + l1, k + 1 * l1, block, 2, 3);
			l1++;
			if (world.getBlock(i, j + l1, k + 1 * l1) == FNBlocks.netherLogs)
				flag = true;
		}

		return true;
	}

	public static void genCap(World world, Random random, int i3, int j3, int k3, Block block2, int blockmeta, int l) {
		int height = l / 6;
		int mult;
		int tier = 0;
		int x = 0;
		j3 = j3 + 1;
		for (int z = 0; z <= random.nextInt(Math.abs(l / 2 - 2)) + 2; z++) {
			for (int y = -height; y <= height; y++) {
				for (x = -height; x <= height; x++) {
					mult = x * x + y * y;
					if (mult <= height * height && mult >= (tier) * (tier)) {
						if (world.isAirBlock(i3 + x, j3 - z, k3 + y)) {
							world.setBlock(i3 + x, j3 - z, k3 + y, block2, blockmeta, 3);
						}
					}
					if (x == height && y == x)
						tier = x;
				}
			}
			if (height == l / 6)
				height = l / 3;
			else if (height == l / 3)
				height = l / 2;
			else if (height == l / 2)
				height = l * 2 / 3;
			else
				height = l * 5 / 6;
		}
	}
}
