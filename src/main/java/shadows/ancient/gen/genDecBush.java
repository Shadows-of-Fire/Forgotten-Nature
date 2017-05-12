package shadows.nature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genDecBush extends WorldGenerator {
	Block leaf;
	int leafmeta;
	int logmeta;

	public genDecBush(Block i, int j, int k) {
		leaf = i;
		leafmeta = j;
		logmeta = k;
	}

	public boolean generate(World world, Random random, int i, int j, int k) {
		if (world.isRemote)
			return false;
		int i1 = i;
		int j1 = j;
		int k1 = k;
		int met = Block.getIdFromBlock(world.getBlock(i, j, k));

		while ((met != 3) & (met != 2)) {
			j--;
			met = Block.getIdFromBlock(world.getBlock(i, j, k));

			if (met == 8 | met == 9 | met == 1) {
				return false;
			}
		}

		world.setBlock(i1, j, k1, Block.getBlockById(3), 0, 3);// dirt
		j1 = j + 1;
		world.setBlock(i1, j1, k1, Block.getBlockById(17), 0, 3);// oak log
		int r = random.nextInt(11);

		if (r > 2) {
			leafGen(world, random, 2, r, i1, j1, k1, leaf, leafmeta);
		}

		if (r == 2 || r == 1) {
			if (world.isAirBlock(i1, j1 + 1, k1) || world.getBlock(i1, j1 + 1, k1) == leaf)
				world.setBlock(i1, j1 + 1, k1, Block.getBlockById(17), 0, 3);
			if (world.isAirBlock(i1, j1, k1 + 1) || world.getBlock(i1, j1, k1 + 1) == leaf)
				world.setBlock(i1, j1, k1 + 1, Block.getBlockById(17), 0, 3);
			if (world.isAirBlock(i1, j1, k1 - 1) || world.getBlock(i1, j1, k1 - 1) == leaf)
				world.setBlock(i1, j1, k1 - 1, Block.getBlockById(17), 0, 3);
			if (world.isAirBlock(i1 + 1, j1, k1) || world.getBlock(i1 + 1, j1, k1) == leaf)
				world.setBlock(i1 + 1, j1, k1, Block.getBlockById(17), 0, 3);
			if (world.isAirBlock(i1 - 1, j1, k1) || world.getBlock(i1 - 1, j1, k1) == leaf)
				world.setBlock(i1 - 1, j1, k1, Block.getBlockById(17), 0, 3);
			leafGen(world, random, 2, r, i1, j1, k1, leaf, leafmeta);
		}

		if (r == 0) {
			if (world.isAirBlock(i1, j1 + 1, k1) || world.getBlock(i1, j1 + 1, k1) == leaf)
				world.setBlock(i1, j1 + 1, k1, Block.getBlockById(17), 0, 3);
			if (world.isAirBlock(i1, j1, k1 + 1) || world.getBlock(i1, j1, k1 + 1) == leaf)
				world.setBlock(i1, j1, k1 + 1, Block.getBlockById(17), 0, 3);
			if (world.isAirBlock(i1, j1, k1 - 1) || world.getBlock(i1, j1, k1 - 1) == leaf)
				world.setBlock(i1, j1, k1 - 1, Block.getBlockById(17), 0, 3);
			if (world.isAirBlock(i1 + 1, j1, k1) || world.getBlock(i1 + 1, j1, k1) == leaf)
				world.setBlock(i1 + 1, j1, k1, Block.getBlockById(17), 0, 3);
			if (world.isAirBlock(i1 - 1, j1, k1) || world.getBlock(i1 - 1, j1, k1) == leaf)
				world.setBlock(i1 - 1, j1, k1, Block.getBlockById(17), 0, 3);
			leafGen(world, random, 3, r, i1, j1, k1, leaf, leafmeta);
		}

		return true;
	}

	public static void leafGen(World world, Random random, int var, int ran, int i3, int j3, int k3, Block leaf2,
			int leafmeta) {
		int met1;
		for (int x = -var; x <= var; x++) {
			for (int y = -var; y <= var; y++) {
				met1 = Block.getIdFromBlock(world.getBlock(i3 + x, j3, k3 + y));
				if (ran > 2) {
					if (world.isAirBlock(i3 + x, j3, k3 + y) && (Math.abs(x) != var || Math.abs(y) != var)
							&& (Math.abs(x) != var - 1 || Math.abs(y) != var)
							&& (Math.abs(x) != var || Math.abs(y) != var - 1)
							&& (met1 == 0 || met1 == 31 || met1 == 37 || met1 == 38 || met1 == 78)) {
						world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta, 3);
					}

					if (Math.abs(x) < var && Math.abs(y) < var && (Math.abs(x) != var - 1 || Math.abs(y) != var - 1)) {
						if (world.isAirBlock(i3 + x, j3 + 1, k3 + y))
							world.setBlock(i3 + x, j3 + 1, k3 + y, leaf2, leafmeta, 3);
						if (world.isAirBlock(i3 + x, j3 - 1, k3 + y))
							world.setBlock(i3 + x, j3 - 1, k3 + y, leaf2, leafmeta, 3);
					}
				}

				if (ran == 2 || ran == 1) {
					if (world.isAirBlock(i3 + x, j3, k3 + y) && (Math.abs(x) != var || Math.abs(y) != var)
							&& (met1 == 0 || met1 == 31 || met1 == 37 || met1 == 38 || met1 == 78)) {
						world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta, 3);
					}

					if ((Math.abs(x) != var || Math.abs(y) != var) && (Math.abs(x) != var - 1 || Math.abs(y) != var)
							&& (Math.abs(x) != var || Math.abs(y) != var - 1)) {
						if (world.isAirBlock(i3 + x, j3 + 1, k3 + y))
							world.setBlock(i3 + x, j3 + 1, k3 + y, leaf2, leafmeta, 3);
						if (world.isAirBlock(i3 + x, j3 - 1, k3 + y))
							world.setBlock(i3 + x, j3 - 1, k3 + y, leaf2, leafmeta, 3);
					}

					if (Math.abs(x) < var && Math.abs(y) < var && (Math.abs(x) != var - 1 || Math.abs(y) != var - 1)
							&& world.isAirBlock(i3 + x, j3 + 2, k3 + y)) {
						world.setBlock(i3 + x, j3 + 2, k3 + y, leaf2, leafmeta, 3);
					}
				}

				if (ran == 0) {
					if (world.isAirBlock(i3 + x, j3, k3 + y) && (Math.abs(x) != var || Math.abs(y) != var)
							&& (Math.abs(x) != var - 1 || Math.abs(y) != var)
							&& (Math.abs(x) != var || Math.abs(y) != var - 1)
							&& (met1 == 0 || met1 == 31 || met1 == 37 || met1 == 38 || met1 == 78)) {
						world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta, 3);
					}

					if ((Math.abs(x) + Math.abs(y) < 4)) {
						if (world.isAirBlock(i3 + x, j3 + 1, k3 + y))
							world.setBlock(i3 + x, j3 + 1, k3 + y, leaf2, leafmeta, 3);
						if (world.isAirBlock(i3 + x, j3 - 1, k3 + y))
							world.setBlock(i3 + x, j3 - 1, k3 + y, leaf2, leafmeta, 3);
					}

					if (Math.abs(x) < var && Math.abs(y) < var && (Math.abs(x) + Math.abs(y) < 3)
							&& world.isAirBlock(i3 + x, j3 + 2, k3 + y)) {
						world.setBlock(i3 + x, j3 + 2, k3 + y, leaf2, leafmeta, 3);
					}
				}
			}
		}
	}
}