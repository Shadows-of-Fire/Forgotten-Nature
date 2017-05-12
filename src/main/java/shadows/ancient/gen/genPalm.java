package shadows.nature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import shadows.ancient.FNBlocks;

public class genPalm extends WorldGenerator {
	Block leaf;
	int leafmeta;
	int logmeta;
	Block log;

	public genPalm(Block i, int j, Block k, int l) {
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
		int dir;
		int met = Block.getIdFromBlock(world.getBlock(i, j, k));

		while ((met != 3) & (met != 2) & (met != 12)) {
			j--;
			met = Block.getIdFromBlock(world.getBlock(i, j, k));

			if (met == 8 | met == 9 | met == 1) {
				return false;
			}
		}

		dir = random.nextInt(4);
		int h = 6 + random.nextInt(5);
		if (log == FNBlocks.newLogs3 && logmeta == 1)
			h = h - 2;

		if (random.nextInt(10) > 0) {
			world.setBlock(i, j, k, Block.getBlockById(3), 0, 3);// dirt

			for (j1 = 1; j1 <= h; j1++) {
				if (world.isAirBlock(i1, j + j1, k) || j1 == 0)
					world.setBlock(i1, j + j1, k, log, logmeta, 3);

				if (j1 == h) {
					leafGen(world, i1, j + j1, k, leaf, leafmeta);
				}
			}
		} else////////////////// An Under-arch Growth////////////////////
		{
			if (dir == 0) {
				growDirect(world, random, 1, 0, i1, j, k1, h, leaf, leafmeta, log, logmeta);
			}

			if (dir == 1) {
				growDirect(world, random, 0, 1, i1, j, k1, h, leaf, leafmeta, log, logmeta);
			}

			if (dir == 2) {
				growDirect(world, random, -1, 0, i1, j, k1, h, leaf, leafmeta, log, logmeta);
			}

			if (dir == 3) {
				growDirect(world, random, 0, -1, i1, j, k1, h, leaf, leafmeta, log, logmeta);
			}
		}

		return true;
	}

	public static void leafGen(World world, int i3, int j3, int k3, Block leaf2, int leafmeta) {
		for (int x = -3; x <= 3; x++) {
			for (int y = -3; y <= 3; y++) {
				if ((Math.abs(x) + Math.abs(y) <= 3) && world.isAirBlock(i3 + x, j3, k3 + y)) {
					world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta, 3);
				}

				if ((Math.abs(x) + Math.abs(y) == 3) && Math.abs(x) != 0 && Math.abs(y) != 0) {
					world.setBlock(i3 + x, j3, k3 + y, Block.getBlockById(0), 0, 3);// air
				}

				if (Math.abs(x) < 2 && Math.abs(y) < 2 && (Math.abs(x) != 1 || Math.abs(y) != 1)
						&& world.isAirBlock(i3 + x, j3 + 1, k3 + y)) {
					world.setBlock(i3 + x, j3 + 1, k3 + y, leaf2, leafmeta, 3);
				}
			}
		}
	}

	public static void growDirect(World world, Random random, int iD, int kD, int i2, int j2, int k2, int hight,
			Block leaf2, int leafmeta, Block log2, int logmeta) {
		int iind = 0;
		int kind = 0;

		if (world.isAirBlock(i2, j2, k2))
			world.setBlock(i2, j2, k2, log2, logmeta, 3);

		if (iD == 1) {
			if (world.isAirBlock(i2 - 1, j2, k2))
				world.setBlock(i2 - 1, j2, k2, log2, logmeta, 3);
		}

		if (iD == -1) {
			if (world.isAirBlock(i2 + 1, j2, k2))
				world.setBlock(i2 + 1, j2, k2, log2, logmeta, 3);
		}

		if (kD == 1) {
			if (world.isAirBlock(i2, j2, k2 - 1))
				world.setBlock(i2, j2, k2 - 1, log2, logmeta, 3);
		}

		if (kD == -1) {
			if (world.isAirBlock(i2, j2, k2 + 1))
				world.setBlock(i2, j2, k2 + 1, log2, logmeta, 3);
		}

		for (int j1 = 1; j1 <= hight; j1++) {
			if (iD == 1 && random.nextInt(2 + iind) == 0) {
				i2++;
			}

			if (iD == -1 && random.nextInt(2 + iind) == 0) {
				i2--;
			}

			if (kD == 1 && random.nextInt(2 + kind) == 0) {
				k2++;
			}

			if (kD == -1 && random.nextInt(2 + kind) == 0) {
				k2--;
			}

			iind++;
			kind++;
			if (world.isAirBlock(i2, j1 + j2, k2))
				world.setBlock(i2, j1 + j2, k2, log2, logmeta, 3);

			if (j1 == hight) {
				leafGen(world, i2, j1 + j2, k2, leaf2, leafmeta);
			}
		}
	}
}