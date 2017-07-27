package shadows.nature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genBukkit extends WorldGenerator {
	Block leaf;
	int leafmeta;
	Block log;
	int logmeta;

	public genBukkit(Block i, int j, Block k, int l) {
		leaf = i;
		leafmeta = j;
		log = k;
		logmeta = l;
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

		j1 = j + 1;
		int h = 12 + random.nextInt(3);
		world.setBlock(i1, j1 - 1, k1, Block.getBlockById(3), 0, 3);// dirt

		for (int jj = 0; jj <= h; jj++) {
			if (world.isAirBlock(i1, j1 + jj, k1) || jj == 0)
				world.setBlock(i1, j1 + jj, k1, log, logmeta, 3);

			if (jj == h) {
				branch(world, random, h, i1, j1, jj, k1, -1, 0, leaf, leafmeta, log, logmeta);
				branch(world, random, h, i1, j1, jj, k1, 1, 0, leaf, leafmeta, log, logmeta);
				branch(world, random, h, i1, j1, jj, k1, 0, -1, leaf, leafmeta, log, logmeta);
				branch(world, random, h, i1, j1, jj, k1, 0, 1, leaf, leafmeta, log, logmeta);
			}
		}

		return true;
	}

	public static void branch(World world, Random random, int H, int ii, int j, int jj, int kk, int iD, int kD, Block leaf2, int leafmeta, Block log2, int logmeta) {
		int index = 0;
		jj = jj + j;

		while (index <= 6) {
			if (iD == -1) {
				ii--;
			}

			if (iD == 1) {
				ii++;
			}

			if (kD == -1) {
				kk--;
			}

			if (kD == 1) {
				kk++;
			}

			if (world.isAirBlock(ii, j + jj, kk) || world.getBlock(ii, j + jj, kk) == leaf2) {
				world.setBlock(ii, jj, kk, log2, logmeta, 3);
			}

			jj++;

			if (index >= 4 && random.nextInt(3) == 0) {
				jj--;
				if (iD == -1) {
					ii++;
				}

				if (iD == 1) {
					ii--;
				}

				if (kD == -1) {
					kk++;
				}

				if (kD == 1) {
					kk--;
				}
			}

			if (index == 6) {
				if (world.isAirBlock(ii, jj, kk) || world.getBlock(ii, jj, kk) == leaf2)
					world.setBlock(ii, jj, kk, log2, logmeta, 3);
				extraWood(world, iD, kD, ii, jj, kk, log2, logmeta, leaf2, leafmeta);
				leafGen(world, ii, jj, kk, leaf2, leafmeta);
			}

			index++;
		}
	}

	public static void leafGen(World world, int i3, int j3, int k3, Block leaf2, int leafmeta) {
		for (int x = -5; x <= 5; x++) {
			for (int y = -5; y <= 5; y++) {
				if ((Math.abs(x) + Math.abs(y) < 7) && world.isAirBlock(i3 + x, j3, k3 + y)) {
					world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta, 3);
				}

				if (Math.abs(x) < 5 && Math.abs(y) < 5 && (Math.abs(x) + Math.abs(y) < 6)) {
					if (world.isAirBlock(i3 + x, j3 + 1, k3 + y)) {
						world.setBlock(i3 + x, j3 + 1, k3 + y, leaf2, leafmeta, 3);
					}

					if (world.isAirBlock(i3 + x, j3 - 1, k3 + y)) {
						world.setBlock(i3 + x, j3 - 1, k3 + y, leaf2, leafmeta, 3);
					}
				}
			}
		}
	}

	public static void extraWood(World world, int iD, int kD, int ii, int jj, int kk, Block log2, int logmeta, Block leaf2, int leafmeta) {
		for (int x = -2; x <= 2; x++) {
			for (int y = -2; y <= 2; y++) {
				if (y != 0 && x == 0 || y == 0 && x != 0) {
					if (world.isAirBlock(ii + x, jj, kk + y) || world.getBlock(ii + x, jj, kk + y) == leaf2)
						world.setBlock(ii + x, jj, kk + y, log2, logmeta, 3);
				}
			}
		}

		if (iD == 1) {
			if (world.isAirBlock(ii - 3, jj, kk) || world.getBlock(ii - 3, jj, kk) == leaf2)
				world.setBlock(ii - 3, jj, kk, log2, logmeta, 3);
			if (world.isAirBlock(ii - 4, jj, kk) || world.getBlock(ii - 4, jj, kk) == leaf2)
				world.setBlock(ii - 4, jj, kk, log2, logmeta, 3);
			leafGen(world, ii - 7, jj, kk, leaf2, leafmeta);
		}

		if (iD == -1) {
			if (world.isAirBlock(ii + 3, jj, kk) || world.getBlock(ii + 3, jj, kk) == leaf2)
				world.setBlock(ii + 3, jj, kk, log2, logmeta, 3);
			if (world.isAirBlock(ii + 4, jj, kk) || world.getBlock(ii + 4, jj, kk) == leaf2)
				world.setBlock(ii + 4, jj, kk, log2, logmeta, 3);
		}

		if (kD == 1) {
			if (world.isAirBlock(ii, jj, kk - 3) || world.getBlock(ii, jj, kk - 3) == leaf2)
				world.setBlock(ii, jj, kk - 3, log2, logmeta, 3);
			if (world.isAirBlock(ii, jj, kk - 4) || world.getBlock(ii, jj, kk - 4) == leaf2)
				world.setBlock(ii, jj, kk - 4, log2, logmeta, 3);
		}

		if (kD == -1) {
			if (world.isAirBlock(ii, jj, kk + 3) || world.getBlock(ii, jj, kk + 3) == leaf2)
				world.setBlock(ii, jj, kk + 3, log2, logmeta, 3);
			if (world.isAirBlock(ii, jj, kk + 4) || world.getBlock(ii, jj, kk + 4) == leaf2)
				world.setBlock(ii, jj, kk + 4, log2, logmeta, 3);
		}
	}
}