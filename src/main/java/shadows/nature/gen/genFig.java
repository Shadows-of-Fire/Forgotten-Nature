package shadows.nature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genFig extends WorldGenerator {
	Block leaf;
	int leafmeta;
	int logmeta;
	int size;
	Block oak = Block.getBlockById(17);

	public genFig(Block i, int j, int k, int s) {
		leaf = i;
		leafmeta = j;
		logmeta = k;
		size = s;// largeness.....
	}

	public boolean generate(World world, Random random, int i, int j, int k) {
		if (world.isRemote)
			return false;
		size = size + random.nextInt(6);
		int i1 = i;
		int j1 = j;
		int k1 = k;
		int i11;
		int j11;
		int k11;
		int met = Block.getIdFromBlock(world.getBlock(i, j, k));
		while ((met != 3) && (met != 2) && met != 1) {
			j--;
			met = Block.getIdFromBlock(world.getBlock(i, j, k));
			if (met == 8 || met == 9 || met == 1)
				return false;
		}
		j1 = j + 1;
		for (int i2 = -1; i2 <= 1; i2++) {
			for (int k2 = -1; k2 <= 1; k2++) {
				world.setBlock(i1 + i2, j1 - 1, k1 + k2, Block.getBlockById(3), 0, 3);// dirt
				for (int k3 = 0; k3 <= 4; k3++) {
					if (world.isAirBlock(i1 + i2, j1 + k3, k1 + k2) || (i2 == 0 && k3 == 0 && k2 == 0))
						world.setBlock(i1 + i2, j1 + k3, k1 + k2, oak, 0, 3);// oaklog
				}
			}
		}
		for (int g = 5; g <= 6 + size / 2; g++) {
			if (world.isAirBlock(i1, j1 + g, k1))
				world.setBlock(i1, j1 + g, k1, oak, 0, 3);// oak log
		}
		// First Branch
		mainBranch(world, random, i1 + 2, j1 + 4, k1 + 2, 1, 1, size, leaf, leafmeta, oak);
		mainBranch(world, random, i1 + 2, j1 + 4, k1, 1, 0, size, leaf, leafmeta, oak);
		inner(world, random, i1 + 1, j1 + 5, k1 + 1, 1, 1, size, leaf, leafmeta, oak);
		inner(world, random, i1 + 1, j1 + 5, k1, 1, 0, size, leaf, leafmeta, oak);
		innerInner(world, random, i1, j1 + 6 + size / 2, k1, 1, 1, size, leaf, leafmeta, oak);
		// Second main Branch
		mainBranch(world, random, i1 + 2, j1 + 4, k1 - 2, 1, -1, size, leaf, leafmeta, oak);
		mainBranch(world, random, i1, j1 + 4, k1 - 2, 0, -1, size, leaf, leafmeta, oak);
		inner(world, random, i1 + 1, j1 + 5, k1 - 1, 1, -1, size, leaf, leafmeta, oak);
		inner(world, random, i1, j1 + 5, k1 - 1, 0, -1, size, leaf, leafmeta, oak);
		innerInner(world, random, i1, j1 + 6 + size / 2, k1, 1, -1, size, leaf, leafmeta, oak);
		// third main branch
		mainBranch(world, random, i1 - 2, j1 + 4, k1 - 2, -1, -1, size, leaf, leafmeta, oak);
		mainBranch(world, random, i1 - 2, j1 + 4, k1, -1, 0, size, leaf, leafmeta, oak);
		inner(world, random, i1 - 1, j1 + 5, k1 - 1, -1, -1, size, leaf, leafmeta, oak);
		inner(world, random, i1 - 1, j1 + 5, k1, -1, 0, size, leaf, leafmeta, oak);
		innerInner(world, random, i1, j1 + 6 + size / 2, k1, -1, -1, size, leaf, leafmeta, oak);
		// fourth main branch
		mainBranch(world, random, i1 - 2, j1 + 4, k1 + 2, -1, 1, size, leaf, leafmeta, oak);
		mainBranch(world, random, i1, j1 + 4, k1 + 2, 0, 1, size, leaf, leafmeta, oak);
		inner(world, random, i1 - 1, j1 + 5, k1 + 1, -1, 1, size, leaf, leafmeta, oak);
		inner(world, random, i1, j1 + 5, k1 + 1, 0, 1, size, leaf, leafmeta, oak);
		innerInner(world, random, i1, j1 + 6 + size / 2, k1, -1, 1, size, leaf, leafmeta, oak);
		return true;
	}

	public static void mainBranch(World world, Random random, int i2, int j2, int k2, int iD, int kD, int size,
			Block leaf2, int leafmeta, Block oak) {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int bend = 0;
		int pos = 3 * size + size / 2;
		if (kD == 1 && iD == 0) {
			a = -1;
			b = 1;
			c = 1;
			d = 1;
		}
		if (kD == 1 && iD == -1) {
			a = -1;
			b = 0;
			c = 0;
			d = 1;
		}
		if (kD == 0 && iD == -1) {
			a = -1;
			b = 1;
			c = -1;
			d = -1;
		}
		if (kD == -1 && iD == -1) {
			a = -1;
			b = 0;
			c = 0;
			d = -1;
		}
		if (kD == -1 && iD == 0) {
			a = -1;
			b = -1;
			c = 1;
			d = -1;
		}
		if (kD == -1 && iD == 1) {
			a = 1;
			b = 0;
			c = 0;
			d = -1;
		}
		if (kD == 0 && iD == 1) {
			a = 1;
			b = 1;
			c = 1;
			d = -1;
		}
		if (kD == 1 && iD == 1) {
			a = 1;
			b = 1;
			c = -1;
			d = 1;
		}
		int ind = 0;
		while (ind < pos) {
			if (world.isAirBlock(i2, j2, k2))
				;
			{
				world.setBlock(i2, j2, k2, oak, 0, 3);// oaklog
				world.setBlock(i2, j2 - 1, k2, oak, 0, 3);// oaklog
			}
			if (iD == 0)
				i2 = i2 + random.nextInt(3) - 1;
			if (kD == 0)
				k2 = k2 + random.nextInt(3) - 1;
			if (kD == 1)
				k2 = k2 + random.nextInt(2);
			if (kD == -1)
				k2 = k2 - random.nextInt(2);
			if (iD == 1)
				i2 = i2 + random.nextInt(2);
			if (iD == -1)
				i2 = i2 - random.nextInt(2);
			if (bend == 0 && random.nextInt(2) == 0) {
				j2 = j2 + 1;
			}
			if (bend == 2 && random.nextInt(3) == 0) {
				j2 = j2 - 1;
			}
			if (random.nextInt(24) == 0) // secondary branches///////
			{
				secFlag(world, random, i2, j2, k2, a, b, size, leaf2, leafmeta, oak);
				secFlag(world, random, i2, j2, k2, c, d, size, leaf2, leafmeta, oak);
			}
			if (ind == pos / 3)
				bend = 1;
			if (ind == (2 * pos) / 3)
				bend = 2;
			ind++;
			if (ind == pos - 1 || random.nextInt(4) == 0) {
				genFigLeaves(world, i2, j2, k2, leaf2, leafmeta);
				if (world.isAirBlock(i2, j2, k2) || world.getBlock(i2, j2, k2) == leaf2)
					;
				world.setBlock(i2, j2, k2, oak, 0, 3);// oaklog
			}
		}
	}

	public static void secFlag(World world, Random random, int i11, int j11, int k11, int iD, int kD, int size,
			Block leaf2, int leafmeta, Block oak) {
		int index0 = 0;
		while (index0 < 2 * size) {
			j11 = j11 + random.nextInt(3) - 1;
			if (iD == 1)
				i11 = i11 + random.nextInt(2);
			if (iD == -1)
				i11 = i11 - random.nextInt(2);
			if (iD == 0)
				i11 = i11 + random.nextInt(3) - 1;
			if (kD == 1)
				k11 = k11 + random.nextInt(2);
			if (kD == -1)
				k11 = k11 - random.nextInt(2);
			if (kD == 0)
				k11 = k11 + random.nextInt(3) - 1;
			if (world.isAirBlock(i11, j11, k11) || world.getBlock(i11, j11, k11) == leaf2)
				;
			world.setBlock(i11, j11, k11, oak, 0, 3);// oaklog
			if (index0 == 2 * size - 1 || random.nextInt(5) == 0) {
				if (world.isAirBlock(i11, j11, k11) || world.getBlock(i11, j11, k11) == leaf2)
					;
				world.setBlock(i11, j11, k11, oak, 0, 3);// oaklog
				genFigLeaves(world, i11, j11, k11, leaf2, leafmeta);
			}
			index0++;
		}
	}

	public static void inner(World world, Random random, int i3, int j3, int k3, int iD, int kD, int size, Block leaf2,
			int leafmeta, Block oak) {
		int pos = 2 * size + size / 2;
		int index = 0;
		int jindex = 5;
		int rat;
		while (index < pos + 2 && jindex < 14) {
			if (world.isAirBlock(i3, j3, k3) || world.getBlock(i3, j3, k3) == leaf2)
				;
			world.setBlock(i3, j3, k3, oak, 0, 3);
			rat = 1 + index / 4;
			if (random.nextInt(rat) == 0) {
				j3++;
				jindex++;
			}
			if (iD == 0)
				i3 = i3 + random.nextInt(3) - 1;
			if (kD == 0)
				k3 = k3 + random.nextInt(3) - 1;
			if (kD == 1)
				k3 = k3 + random.nextInt(2);
			if (kD == -1)
				k3 = k3 - random.nextInt(2);
			if (iD == 1)
				i3 = i3 + random.nextInt(2);
			if (iD == -1)
				i3 = i3 - random.nextInt(2);
			index++;
			if (index == pos + 1 || random.nextInt(5) == 0 || jindex == 13) {
				genFigLeaves(world, i3, j3, k3, leaf2, leafmeta);
				if (world.isAirBlock(i3, j3, k3) || world.getBlock(i3, j3, k3) == leaf2)
					;
				world.setBlock(i3, j3, k3, oak, 0, 3);
			}
		}
	}

	public static void innerInner(World world, Random random, int i4, int j4, int k4, int iD, int kD, int size,
			Block leaf2, int leafmeta, Block oak) {
		int index1 = 0;
		int jindex1 = 6 + size / 2;
		while (index1 < 2 * size + 1 && jindex1 < 16) {
			if (world.isAirBlock(i4, j4, k4) || world.getBlock(i4, j4, k4) == leaf2)
				;
			world.setBlock(i4, j4, k4, oak, 0, 3);
			j4++;
			jindex1++;
			if (random.nextInt(3) == 0) {
				if (iD == -1)
					i4 = i4 - 1;
				if (iD == 1)
					i4 = i4 + 1;
			}
			if (random.nextInt(3) == 0) {
				if (kD == -1)
					k4 = k4 - 1;
				if (kD == 1)
					k4 = k4 + 1;
			}
			index1++;
			if (index1 == 2 * size || random.nextInt(5) == 0 || jindex1 == 15) {
				genFigLeaves(world, i4, j4, k4, leaf2, leafmeta);
				if (world.isAirBlock(i4, j4, k4) || world.getBlock(i4, j4, k4) == leaf2)
					;
				world.setBlock(i4, j4, k4, oak, 0, 3);
			}
		}
	}

	public static void genFigLeaves(World world, int i3, int j3, int k3, Block leaf2, int leafmeta) {
		for (int x = -3; x <= 3; x++) {
			for (int y = -3; y <= 3; y++) {
				if (Math.abs(x) + Math.abs(y) < 5) {
					if (world.isAirBlock(i3 + x, j3, k3 + y))
						;
					world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta, 3);
				}
				if ((Math.abs(x) < 3 && Math.abs(y) < 3) && (Math.abs(x) != 2 || Math.abs(y) != 2)) {
					if (world.isAirBlock(i3 + x, j3 + 1, k3 + y))
						;
					world.setBlock(i3 + x, j3 + 1, k3 + y, leaf2, leafmeta, 3);
					if (world.isAirBlock(i3 + x, j3 - 1, k3 + y))
						;
					world.setBlock(i3 + x, j3 - 1, k3 + y, leaf2, leafmeta, 3);
				}
			}
		}
	}
}
