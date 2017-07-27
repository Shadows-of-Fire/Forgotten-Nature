package shadows.nature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import shadows.ancient.FNBlocks;

public class genNetherTree extends WorldGenerator {
	Block leaf = FNBlocks.netherLeaves;
	int leafmeta;
	int I;
	Block log = FNBlocks.netherLogs;
	int logmeta;
	int dir = 0;

	public genNetherTree(int i, int k, int is) {
		leafmeta = i;
		logmeta = k;
		I = is;
	}

	public boolean generate(World world, Random random, int i, int j, int k) {
		if (world.isRemote)
			return false;
		if (I == 0) {
			return false;
		}

		int l = random.nextInt(3) + 2;

		if (j < 1 || j + l + 1 > 256) {
			return false;
		}

		int soilBlockId = Block.getIdFromBlock(world.getBlock(i, j - 1, k));

		while (soilBlockId != 87 && soilBlockId != 2 && soilBlockId != 3)// netherrack,
																			// dirt,
																			// grass
		{
			j--;
			soilBlockId = Block.getIdFromBlock(world.getBlock(i, j, k));

			if (soilBlockId == 8 | soilBlockId == 9 | soilBlockId == 1) {
				return false;
			}
		}
		j = j + 1;

		int brightest = world.getBlockLightValue(i, j, k);
		int next = 0;
		world.setBlock(i, j - 2, k, Block.getBlockById(87), 0, 3);// netherrack
		world.setBlock(i, j - 1, k, log, logmeta, 3);

		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				next = world.getBlockLightValue(i + x, j, k + y);
				if (next > brightest) {
					brightest = next;
					if (x == -1 && y == x)
						dir = 1;
					else if (x == -1 && y == 0)
						dir = 2;
					else if (x == -1 && y == 1)
						dir = 3;
					else if (x == 0 && y == 1)
						dir = 4;
					else if (x == 1 && y == x)
						dir = 5;
					else if (x == 1 && y == 0)
						dir = 6;
					else if (x == 1 && y == -1)
						dir = 7;
					else if (x == 0 && y == -1)
						dir = 8;
				}
			}
		}

		for (int l1 = 0; l1 < l; l1++) {
			if (dir == 0) {
				if (world.isAirBlock(i, j + l1, k) || l1 == 0)
					world.setBlock(i, j + l1, k, log, logmeta, 3);
				if (l1 == l - 1)
					genLeaves(world, random, i, j + l1, k, leaf, leafmeta);
				for (int j3 = 0; j3 <= 1; j3++) {
					if (random.nextInt(8) == 0) {
						branches(world, random, i, j + j3, k, 1, 0, leaf, leafmeta, log, logmeta);
					}
					if (random.nextInt(8) == 0) {
						branches(world, random, i, j + j3, k, -1, 0, leaf, leafmeta, log, logmeta);
					}
					if (random.nextInt(8) == 0) {
						branches(world, random, i, j + j3, k, -1, 1, leaf, leafmeta, log, logmeta);
					}
					if (random.nextInt(8) == 0) {
						branches(world, random, i, j + j3, k, 0, 1, leaf, leafmeta, log, logmeta);
					}
					if (random.nextInt(8) == 0) {
						branches(world, random, i, j + j3, k, 0, -1, leaf, leafmeta, log, logmeta);
					}
					if (random.nextInt(8) == 0) {
						branches(world, random, i, j + j3, k, 1, 1, leaf, leafmeta, log, logmeta);
					}
					if (random.nextInt(8) == 0) {
						branches(world, random, i, j + j3, k, -1, -1, leaf, leafmeta, log, logmeta);
					}
					if (random.nextInt(8) == 0) {
						branches(world, random, i, j + j3, k, 1, -1, leaf, leafmeta, log, logmeta);
					}
				}
			} else if (dir == 1) {
				if (world.isAirBlock(i - 1 * l1, j + l1, k - 1 * l1) || world.getBlock(i - 1 * l1, j + l1, k - 1 * l1) == leaf)
					world.setBlock(i - 1 * l1, j + l1, k - 1 * l1, log, logmeta, 3);
				if (l1 == l - 1)
					genLeaves(world, random, i - 1 * l1, j + l1, k - 1 * l1, leaf, leafmeta);
				for (int j3 = 0; j3 <= 1; j3++) {
					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, -1, 0, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, 0, -1, leaf, leafmeta, log, logmeta);
					}
				}
			} else if (dir == 2) {
				if (world.isAirBlock(i - 1 * l1, j + l1, k) || world.getBlock(i - 1 * l1, j + l1, k) == leaf)
					world.setBlock(i - 1 * l1, j + l1, k, log, logmeta, 3);
				if (l1 == l - 1)
					genLeaves(world, random, i - 1 * l1, j + l1, k, leaf, leafmeta);
				for (int j3 = 0; j3 <= 1; j3++) {
					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, -1, -1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, -1, 1, leaf, leafmeta, log, logmeta);
					}
				}
			} else if (dir == 3) {
				if (world.isAirBlock(i - 1 * l1, j + l1, k + 1 * l1) || world.getBlock(i - 1 * l1, j + l1, k + 1 * l1) == leaf)
					world.setBlock(i - 1 * l1, j + l1, k + 1 * l1, log, logmeta, 3);
				if (l1 == l - 1)
					genLeaves(world, random, i - 1 * l1, j + l1, k + 1 * l1, leaf, leafmeta);
				for (int j3 = 0; j3 <= 1; j3++) {
					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, -1, 0, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, 1, 0, leaf, leafmeta, log, logmeta);
					}
				}
			} else if (dir == 4) {
				if (world.isAirBlock(i, j + l1, k + 1 * l1) || world.getBlock(i, j + l1, k + 1 * l1) == leaf)
					world.setBlock(i, j + l1, k + 1 * l1, log, logmeta, 3);
				if (l1 == l - 1)
					genLeaves(world, random, i, j + l1, k + 1 * l1, leaf, leafmeta);
				for (int j3 = 0; j3 <= 1; j3++) {
					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, -1, 1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, 1, 1, leaf, leafmeta, log, logmeta);
					}
				}
			} else if (dir == 5) {
				if (world.isAirBlock(i + 1 * l1, j + l1, k + 1 * l1) || world.getBlock(i + 1 * l1, j + l1, k + 1 * l1) == leaf)
					world.setBlock(i + 1 * l1, j + l1, k + 1 * l1, log, logmeta, 3);
				if (l1 == l - 1)
					genLeaves(world, random, i + 1 * l1, j + l1, k + 1 * l1, leaf, leafmeta);
				for (int j3 = 0; j3 <= 1; j3++) {
					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, 0, 1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, 1, 0, leaf, leafmeta, log, logmeta);
					}
				}
			} else if (dir == 6) {
				if (world.isAirBlock(i + 1 * l1, j + l1, k) || world.getBlock(i + 1 * l1, j + l1, k) == leaf)
					world.setBlock(i + 1 * l1, j + l1, k, log, logmeta, 3);
				if (l1 == l - 1)
					genLeaves(world, random, i + 1 * l1, j + l1, k, leaf, leafmeta);
				for (int j3 = 0; j3 <= 1; j3++) {
					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, 1, 1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, 1, -1, leaf, leafmeta, log, logmeta);
					}
				}
			} else if (dir == 7) {
				if (world.isAirBlock(i + 1 * l1, j + l1, k - 1 * l1) || world.getBlock(i + 1 * l1, j + l1, k - 1 * l1) == leaf)
					world.setBlock(i + 1 * l1, j + l1, k - 1 * l1, log, logmeta, 3);
				if (l1 == l - 1)
					genLeaves(world, random, i + 1 * l1, j + l1, k - 1 * l1, leaf, leafmeta);
				for (int j3 = 0; j3 <= 1; j3++) {
					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, 1, 0, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, 0, -1, leaf, leafmeta, log, logmeta);
					}
				}
			} else if (dir == 8) {
				if (world.isAirBlock(i, j + l1, k - 1 * l1) || world.getBlock(i, j + l1, k - 1 * l1) == leaf)
					world.setBlock(i, j + l1, k - 1 * l1, log, logmeta, 3);
				if (l1 == l - 1)
					genLeaves(world, random, i, j + l1, k - 1 * l1, leaf, leafmeta);
				for (int j3 = 0; j3 <= 1; j3++) {
					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, -1, -1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(2) == 0) {
						branches(world, random, i, j + j3, k, 1, -1, leaf, leafmeta, log, logmeta);
					}
				}
			}
		}
		return true;
	}

	public static void branches(World world, Random random, int ii, int jj, int kk, int iD, int kD, Block leaf2, int leafmeta, Block log2, int logmeta) {
		for (int br = 0; br < 4; br++) {
			if (iD == -1 && random.nextInt(2) == 0)
				ii--;

			if (iD == 1 && random.nextInt(2) == 0)
				ii++;

			if (kD == -1 && random.nextInt(2) == 0)
				kk--;

			if (kD == 1 && random.nextInt(2) == 0)
				kk++;

			if (world.isAirBlock(ii, jj, kk) || world.getBlock(ii, jj, kk) == leaf2)
				world.setBlock(ii, jj, kk, log2, logmeta, 3);

			if (br == 3)
				genLeaves(world, random, ii, jj, kk, leaf2, leafmeta);

			jj++;
		}
	}

	public static void genLeaves(World world, Random random, int i3, int j3, int k3, Block leaf2, int leafmeta) {
		for (int x = -2; x <= 2; x++) {
			for (int y = -2; y <= 2; y++) {
				if (Math.abs(x) != 2 || Math.abs(y) != 2) {
					if (world.isAirBlock(i3 + x, j3, k3 + y)) {
						world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta, 3);
					}
				}

				if ((Math.abs(x) < 2 && Math.abs(y) < 2) && (Math.abs(x) != 1 || Math.abs(y) != 1)) {
					if (world.isAirBlock(i3 + x, j3 + 1, k3 + y)) {
						world.setBlock(i3 + x, j3 + 1, k3 + y, leaf2, leafmeta, 3);
					}
				}

				if ((Math.abs(x) < 2 && Math.abs(y) < 2) && (Math.abs(x) != 1 || Math.abs(y) != 1)) {
					if (world.isAirBlock(i3 + x, j3 - 1, k3 + y)) {
						world.setBlock(i3 + x, j3 - 1, k3 + y, leaf2, leafmeta, 3);
					}
				}
			}
		}
	}
}
