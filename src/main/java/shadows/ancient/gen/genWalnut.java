package shadows.nature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genWalnut extends WorldGenerator {
	Block leaf;
	int leafmeta;
	Block log;
	int logmeta;

	public genWalnut(Block i, int j, Block k, int l) {
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
		int hl;
		int h = random.nextInt(15) + 8;
		world.setBlock(i1, j1 - 1, k1, Block.getBlockById(3), 0, 3);// dirt

		for (int jj = 0; jj <= h; jj++) {
			if (world.isAirBlock(i1, j1 + jj, k1) || jj == 0)
				world.setBlock(i1, j1 + jj, k1, log, logmeta, 3);

			if (jj == h) {
				leafGen(world, i1, j1 + jj, k1, leaf, leafmeta);
			}

			if (jj > 3 & jj < h) {
				hl = h / (jj - 2) + 1;

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

		return true;
	}

	public static void branch(World world, Random random, int H, int ii, int j, int jj, int kk, int iD, int kD,
			Block leaf2, int leafmeta, Block log2, int logmeta) {
		int index = 0;
		int lengthToGo = H - jj;
		jj = jj + j;

		while (index <= lengthToGo) {
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

			if (index == lengthToGo || random.nextInt(6) == 0) {
				if (world.isAirBlock(ii, jj, kk) || world.getBlock(ii, jj, kk) == leaf2)
					world.setBlock(ii, jj, kk, log2, logmeta, 3);
				leafGen(world, ii, jj, kk, leaf2, leafmeta);
			}

			index++;
		}
	}

	public static void leafGen(World world, int i3, int j3, int k3, Block leaf2, int leafmeta) {
		for (int x = -3; x <= 3; x++) {
			for (int y = -3; y <= 3; y++) {
				if ((Math.abs(x) != 3 || Math.abs(y) != 3) && (Math.abs(x) != 2 || Math.abs(y) != 3)
						&& (Math.abs(x) != 3 || Math.abs(y) != 2) && world.isAirBlock(i3 + x, j3, k3 + y)) {
					world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta, 3);
				}

				if (Math.abs(x) < 3 && Math.abs(y) < 3 && (Math.abs(x) != 2 || Math.abs(y) != 2)) {
					if (world.isAirBlock(i3 + x, j3 + 1, k3 + y)) {
						world.setBlock(i3 + x, j3 + 1, k3 + y, leaf2, leafmeta, 3);
					}

					if (world.isAirBlock(i3 + x, j3 - 1, k3 + y)) {
						world.setBlock(i3 + x, j3 - 1, k3 + y, leaf2, leafmeta, 3);
					}
				}

				if (Math.abs(x) + Math.abs(y) < 2) {
					if (world.isAirBlock(i3 + x, j3 + 2, k3 + y)) {
						world.setBlock(i3 + x, j3 + 2, k3 + y, leaf2, leafmeta, 3);
					}

					if (world.isAirBlock(i3 + x, j3 - 2, k3 + y)) {
						world.setBlock(i3 + x, j3 - 2, k3 + y, leaf2, leafmeta, 3);
					}
				}
			}
		}
	}
}