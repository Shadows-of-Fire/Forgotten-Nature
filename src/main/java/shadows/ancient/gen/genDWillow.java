package shadows.nature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genDWillow extends WorldGenerator {
	Block leaf;
	int leafmeta;
	Block log;
	int logmeta;

	public genDWillow(Block i, int j, Block k, int l) {
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

		while ((met != 3) & (met != 2) && met != 12) {
			j--;
			met = Block.getIdFromBlock(world.getBlock(i, j, k));

			if (met == 8 | met == 9 | met == 1) {
				return false;
			}
		}

		j1 = j + 1;

		if (random.nextInt(10) > 0) {
			int h = random.nextInt(3) + 5;
			world.setBlock(i1, j1 - 1, k1, Block.getBlockById(3), 0, 3);// dirt

			for (int jj = 0; jj <= h; jj++) {
				if (world.isAirBlock(i1, j1 + jj, k1) || jj == 0) {
					world.setBlock(i1, j1 + jj, k1, log, logmeta, 3);
				}

				if (jj == h - 2) {
					branch(world, random, 2, i1, j1, jj, k1, -1, 0, leaf, leafmeta, log, logmeta);
					branch(world, random, 2, i1, j1, jj, k1, 1, 0, leaf, leafmeta, log, logmeta);
					branch(world, random, 2, i1, j1, jj, k1, 0, -1, leaf, leafmeta, log, logmeta);
					branch(world, random, 2, i1, j1, jj, k1, 0, 1, leaf, leafmeta, log, logmeta);
				}

				if (jj > 1 & jj < h) {
					if (random.nextInt(5) == 0) {
						branch(world, random, h, i1, j1, jj, k1, -1, 0, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(5) == 0) {
						branch(world, random, h, i1, j1, jj, k1, 1, 0, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(5) == 0) {
						branch(world, random, h, i1, j1, jj, k1, 0, -1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(5) == 0) {
						branch(world, random, h, i1, j1, jj, k1, 0, 1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(5) == 0) {
						branch(world, random, h, i1, j1, jj, k1, -1, 1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(5) == 0) {
						branch(world, random, h, i1, j1, jj, k1, -1, -1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(5) == 0) {
						branch(world, random, h, i1, j1, jj, k1, 1, 1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(5) == 0) {
						branch(world, random, h, i1, j1, jj, k1, 1, -1, leaf, leafmeta, log, logmeta);
					}
				}
			}
		} else////////////////// A larger growth////////////////////
		{
			int hl;
			int h = random.nextInt(7) + 7;
			world.setBlock(i1, j1 - 1, k1, Block.getBlockById(3), 0, 3);// dirt

			for (int jj = 0; jj <= h; jj++) {
				if (jj == h - 2) {
					branch(world, random, 2, i1, j1, jj, k1, -1, 0, leaf, leafmeta, log, logmeta);
					branch(world, random, 2, i1, j1, jj, k1, 1, 0, leaf, leafmeta, log, logmeta);
					branch(world, random, 2, i1, j1, jj, k1, 0, -1, leaf, leafmeta, log, logmeta);
					branch(world, random, 2, i1, j1, jj, k1, 0, 1, leaf, leafmeta, log, logmeta);
				}

				if (world.isAirBlock(i1, j1 + jj, k1)) {
					world.setBlock(i1, j1 + jj, k1, log, logmeta, 3);
				}

				if (jj > 1 & jj < h) {
					hl = h / jj + 1;

					if (random.nextInt(hl) == 0) {
						branch(world, random, h, i1, j1, jj, k1, -1, 0, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(hl) == 0) {
						branch(world, random, h, i1, j1, jj, k1, 1, 0, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(hl) == 0) {
						branch(world, random, h, i1, j1, jj, k1, 0, -1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(hl) == 0) {
						branch(world, random, h, i1, j1, jj, k1, 0, 1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(hl) == 0) {
						branch(world, random, h, i1, j1, jj, k1, -1, 1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(hl) == 0) {
						branch(world, random, h, i1, j1, jj, k1, -1, -1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(hl) == 0) {
						branch(world, random, h, i1, j1, jj, k1, 1, 1, leaf, leafmeta, log, logmeta);
					}

					if (random.nextInt(hl) == 0) {
						branch(world, random, h, i1, j1, jj, k1, 1, -1, leaf, leafmeta, log, logmeta);
					}
				}
			}
		}

		return true;
	}

	public static void branch(World world, Random random, int H, int ii, int j, int jj, int kk, int iD, int kD,
			Block leaf2, int leafmeta, Block log2, int logmeta) {
		int index = 0;
		jj = jj + j;

		while (index <= H) {
			if (iD == -1 && random.nextInt(3) > 0) {
				ii--;

				if (kD == 0 && random.nextInt(4) == 0) {
					kk = kk + random.nextInt(3) - 1;
				}
			}

			if (iD == 1 && random.nextInt(3) > 0) {
				ii++;

				if (kD == 0 && random.nextInt(4) == 0) {
					kk = kk + random.nextInt(3) - 1;
				}
			}

			if (kD == -1 && random.nextInt(3) > 0) {
				kk--;

				if (iD == 0 && random.nextInt(4) == 0) {
					ii = ii + random.nextInt(3) - 1;
				}
			}

			if (kD == 1 && random.nextInt(3) > 0) {
				kk++;

				if (iD == 0 && random.nextInt(4) == 0) {
					ii = ii + random.nextInt(3) - 1;
				}
			}

			if (world.isAirBlock(ii, j + jj, kk) || world.getBlock(ii, j + jj, kk) == leaf2) {
				world.setBlock(ii, jj, kk, log2, logmeta, 3);
			}

			if (random.nextInt(3) > 0) {
				jj++;
			}

			if (index == H || random.nextInt(6) == 0) {
				if (world.isAirBlock(ii, jj, kk) || world.getBlock(ii, jj, kk) == leaf2)
					world.setBlock(ii, jj, kk, log2, logmeta, 3);
				leafGen(world, ii, jj, kk, leaf2, leafmeta);
			}

			index++;
		}
	}

	public static void leafGen(World world, int i3, int j3, int k3, Block leaf2, int leafmeta) {
		if (world.isAirBlock(i3, j3 + 1, k3) || world.getBlock(i3, j3 + 1, k3) == leaf2)
			world.setBlock(i3, j3 + 1, k3, leaf2, leafmeta, 3);
		if (world.isAirBlock(i3, j3 + 2, k3) || world.getBlock(i3, j3 + 2, k3) == leaf2)
			world.setBlock(i3, j3 + 2, k3, leaf2, leafmeta, 3);

		for (int jh = 1; jh >= -2; jh--) {
			if (world.isAirBlock(i3, j3 + jh - 1, k3)) {
				world.setBlock(i3, j3 + jh - 1, k3, leaf2, leafmeta, 3);
			}

			for (int x = -1; x <= 1; x++) {
				for (int y = -1; y <= 1; y++) {
					if ((x != 0 | y != 0) && (Math.abs(x) != 1 | Math.abs(y) != 1)
							&& world.isAirBlock(i3 + x, j3 + jh, k3 + y)) {
						world.setBlock(i3 + x, j3 + jh, k3 + y, leaf2, leafmeta, 3);
					}
				}
			}
		}
	}
}