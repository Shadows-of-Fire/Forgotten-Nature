package shadows.nature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genSequoia extends WorldGenerator {
	Block leaf;
	int leafmeta;
	Block log;
	int logmeta;

	public genSequoia(Block i, int j, Block k, int l) {
		leaf = i;
		leafmeta = j;
		log = k;
		logmeta = l;
	}

	public boolean generate(World world, Random random, int i, int j, int k) {
		if (world.isRemote)
			return false;
		int l = random.nextInt(23) + 16;
		int ls = l - 4;
		int i1;
		int byte0 = 1;
		int iin = i;
		int kin = k;
		int sub = 1;
		int flag1 = 0;
		int center = 0;
		int border = 0;

		if (random.nextInt(4) == 0) {
			byte0 = 1;

			if (random.nextInt(3) == 0) {
				byte0 = 2;
			}
		} else {
			flag1 = 1;
		}

		int byte1 = byte0;
		int met = Block.getIdFromBlock(world.getBlock(i + 1, j, k));

		if (met == 8 | met == 9) {
			return false;
		}

		met = Block.getIdFromBlock(world.getBlock(i, j, k));

		while ((met != 3) & (met != 2)) {
			j--;
			met = Block.getIdFromBlock(world.getBlock(i, j, k));

			if (met == 8 || met == 9 || met == 1) {
				return false;
			}
		}

		if (met != 2 && met != 3) {
			return false;
		}

		i1 = j + 1;

		if (flag1 == 0) {
			for (int j1 = -byte0; j1 <= byte0; j1++) {
				for (int j2 = -byte0; j2 <= byte0; j2++) {
					if (j1 == byte0) {
						world.setBlock(iin + j1, i1, kin + j2, Blocks.air, 0, 3);// air
					}

					world.setBlock(iin + j1, i1 - 1, kin + j2, Blocks.dirt, 0, 3);// dirt

					for (int k3 = 0; k3 <= l; k3++) {
						if (world.isAirBlock(iin + j1, i1 + k3, kin + j2) || (j1 == 0 && j2 == 0 && k3 == 0))
							world.setBlock(iin + j1, i1 + k3, kin + j2, log, logmeta, 3);
					}

					if (byte0 == Math.abs(j1) && byte0 == Math.abs(j2) && byte0 != 1) {
						for (int j3 = l; j3 >= 0; j3--) {
							world.setBlock(iin + j1, i1 + j3, kin + j2, Block.getBlockById(0), 0, 3);// air

							if (j3 >= l / 2 && (world.isAirBlock(iin + j1, i1 + j3, kin + j2))) {
								world.setBlock(iin + j1, i1 + j3, kin + j2, leaf, leafmeta, 3);
							}
						}
					}
				}
			}

			byte0 = byte0 + 1;

			for (int k1 = -byte0; k1 <= byte0; k1++) {
				for (int k2 = -byte0; k2 <= byte0; k2++) {
					if (byte0 != Math.abs(k1) && byte0 != Math.abs(k2)) {
						continue;
					}

					for (int j4 = l / 2; j4 <= l; j4++) {
						if (random.nextInt(1) == 0 && (world.isAirBlock(iin + k1, i1 + j4, kin + k2)))
							;
						world.setBlock(iin + k1, i1 + j4, kin + k2, leaf, leafmeta, 3);
					}
				}
			}

			byte0 = byte0 + 1;

			for (int l1 = -byte0; l1 <= byte0; l1++) {
				for (int l2 = -byte0; l2 <= byte0; l2++) {
					if ((byte0 == Math.abs(l2) || byte0 == Math.abs(l1)) || (Math.abs(l2) == byte0 - 1 && Math.abs(l1) == byte0 - 1)) {
						border = 1; // shaping the top of the tree
					}

					if (border == 0 && random.nextInt(4) > 0 && (world.isAirBlock(iin + l1, i1 + l + 2, kin + l2))) {
						world.setBlock(iin + l1, i1 + l + 2, kin + l2, leaf, leafmeta, 3);
					} else {
						border = 0;
					}

					if (byte0 != Math.abs(l1) && byte0 != Math.abs(l2)) {
						continue;
					}

					for (int l4 = l / 2; l4 <= l; l4++) {
						if (random.nextInt(5) > 0 && l4 > l / 2 && (world.isAirBlock(iin + l1, i1 + l4, kin + l2))) {
							world.setBlock(iin + l1, i1 + l4, kin + l2, leaf, leafmeta, 3);
						}
					}
				}
			}

			byte0 = byte0 + 1;

			for (int i2 = -byte0; i2 <= byte0; i2++) {
				for (int i3 = -byte0; i3 <= byte0; i3++) {
					if ((byte0 == Math.abs(i2) || byte0 == Math.abs(i3)) || (Math.abs(i2) == byte0 - 1 && Math.abs(i3) == byte0 - 1)) {
						border = 1; // shaping the top of the tree
					}

					if (border == 0 && random.nextInt(4) > 0 && (world.isAirBlock(iin + i2, i1 + l + 1, kin + i3))) {
						world.setBlock(iin + i2, i1 + l + 1, kin + i3, leaf, leafmeta, 3);
					} else {
						border = 0;
					}

					if ((byte0 != Math.abs(i2) && byte0 != Math.abs(i3)) || (byte0 == Math.abs(i2) && byte0 == Math.abs(i3))) {
						continue;
					}

					for (int j5 = l / 2; j5 <= l; j5++) {
						if (random.nextInt(2) > 0 && (Math.abs(i2) != byte0 || Math.abs(i3) != byte0 - 1) && (Math.abs(i2) != byte0 - 1 || Math.abs(i3) != byte0) && j5 > l / 2 + 1 && (world.isAirBlock(iin + i2, i1 + j5, kin + i3))) {
							world.setBlock(iin + i2, i1 + j5, kin + i3, leaf, leafmeta, 3);
						}
					}
				}
			}

			for (int j3 = l / 2; j3 <= l - 3; j3++) {
				if (random.nextInt(2) == 0) {
					branches(world, random, iin - byte1, i1 + j3, kin, -1, 0, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(2) == 0) {
					branches(world, random, iin + byte1, i1 + j3, kin, 1, 0, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(2) == 0) {
					branches(world, random, iin, i1 + j3, kin - byte1, 0, -1, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(2) == 0) {
					branches(world, random, iin, i1 + j3, kin + byte1, 0, 1, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(2) == 0) {
					branches(world, random, iin - byte1, i1 + j3, kin + byte1, -1, 1, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(2) == 0) {
					branches(world, random, iin - byte1, i1 + j3, kin - byte1, -1, -1, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(2) == 0) {
					branches(world, random, iin + byte1, i1 + j3, kin + byte1, 1, 1, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(2) == 0) {
					branches(world, random, iin + byte1, i1 + j3, kin - byte1, 1, -1, leaf, leafmeta, log, logmeta);
				}
			}

			return true;
		} else {
			byte0 = 1;

			for (int j1 = -byte0; j1 <= byte0 - sub; j1++) {
				for (int j2 = -byte0; j2 <= byte0 - sub; j2++) {
					if (j1 == byte0) {
						world.setBlock(iin + j1, i1, kin + j2, Block.getBlockById(0), 0, 3);// air
					}

					world.setBlock(iin + j1, i1 - 1, kin + j2, Block.getBlockById(3), 0, 3);// dirt
					world.setBlock(iin + j1, i1, kin + j2, log, logmeta, 3);

					for (int k3 = 1; k3 <= ls; k3++) {
						if (world.isAirBlock(iin + j1, i1 + k3, kin + j2) || (j1 == 0 && k3 == 0 && j2 == 0))
							world.setBlock(iin + j1, i1 + k3, kin + j2, log, logmeta, 3);
					}
				}
			}

			border = 0;
			byte0 = byte0 + 2;

			for (int l1 = -byte0; l1 <= byte0 - sub; l1++) {
				for (int l2 = -byte0; l2 <= byte0 - sub; l2++) {
					if ((l2 == -3 || l2 == 2 || l1 == -3 || l1 == 2)) {
						border = 1; // shaping the top of the tree
					}

					if (border == 0 && random.nextInt(4) > 0 && (world.isAirBlock(iin + l1, i1 + ls + 2, kin + l2))) {
						world.setBlock(iin + l1, i1 + ls + 2, kin + l2, leaf, leafmeta, 3);
					} else {
						border = 0;
					}

					if ((l1 == -1 || l1 == 0) && (l2 == -1 || l2 == 0)) {
						continue;
					}

					for (int k4 = ls / 2; k4 <= ls; k4++) {
						if (random.nextInt(5) > 0 && k4 > ls / 2 && (world.isAirBlock(iin + l1, i1 + k4, kin + l2))) {
							world.setBlock(iin + l1, i1 + k4, kin + l2, leaf, leafmeta, 3);
						}
					}
				}
			}

			border = 0;
			byte0 = byte0 + 1;

			for (int i2 = -byte0; i2 <= byte0 - sub; i2++) {
				for (int i3 = -byte0; i3 <= byte0 - sub; i3++) {
					if ((i2 == -4 || i2 == 3 || i3 == -4 || i3 == 3)) {
						border = 1; // shaping the top of the tree
					}

					if (border == 0 && random.nextInt(4) > 0 && (world.isAirBlock(iin + i2, i1 + ls + 1, kin + i3))) {
						world.setBlock(iin + i2, i1 + ls + 1, kin + i3, leaf, leafmeta, 3);
					} else {
						border = 0;
					}

					if ((i2 != -4 && i2 != 3) && (i3 != -4 && i3 != 3)) {
						center = 1;
					}

					if ((i2 == -4 || i2 == 3) && (i3 == -4 || i3 == 3)) {
						continue;
					}

					if (center == 0) {
						for (int j5 = ls / 2; j5 <= ls; j5++) {
							if (random.nextInt(3) > 0 && j5 > ls / 2 + 1 && (world.isAirBlock(iin + i2, i1 + j5, kin + i3))) {
								world.setBlock(iin + i2, i1 + j5, kin + i3, leaf, leafmeta, 3);
							}
						}
					} else {
						center = 0;
					}
				}
			}

			for (int j3 = l / 2; j3 <= l - 6; j3++) {
				if (random.nextInt(4) == 0) {
					branches(world, random, iin - 1, i1 + j3, kin, -1, 0, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(4) == 0) {
					branches(world, random, iin, i1 + j3, kin, 1, 0, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(4) == 0) {
					branches(world, random, iin, i1 + j3, kin - 1, 0, -1, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(4) == 0) {
					branches(world, random, iin, i1 + j3, kin, 0, 1, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(4) == 0) {
					branches(world, random, iin - 1, i1 + j3, kin, -1, 1, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(4) == 0) {
					branches(world, random, iin - 1, i1 + j3, kin - 1, -1, -1, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(4) == 0) {
					branches(world, random, iin, i1 + j3, kin, 1, 1, leaf, leafmeta, log, logmeta);
				}

				if (random.nextInt(4) == 0) {
					branches(world, random, iin, i1 + j3, kin - 1, 1, -1, leaf, leafmeta, log, logmeta);
				}
			}

			return true;
		}
	}

	public static void branches(World world, Random random, int ii, int jj, int kk, int iD, int kD, Block leaf2, int leafmeta, Block log2, int logmeta) {
		for (int br = 0; br < 9; br++) {
			if (iD == -1 && random.nextInt(3) == 0) {
				ii--;
			}

			if (iD == 1 && random.nextInt(3) == 0) {
				ii++;
			}

			if (kD == -1 && random.nextInt(3) == 0) {
				kk--;
			}

			if (kD == 1 && random.nextInt(3) == 0) {
				kk++;
			}

			if (world.isAirBlock(ii, jj, kk) || world.getBlock(ii, jj, kk) == leaf2) {
				world.setBlock(ii, jj, kk, log2, logmeta, 3);
			}

			if (br == 8 || random.nextInt(6) == 0) {
				genSeqLeaves(world, ii, jj, kk, leaf2, leafmeta);
			}

			jj++;
		}
	}

	public static void genSeqLeaves(World world, int i3, int j3, int k3, Block leaf2, int leafmeta) {
		for (int x = -3; x <= 3; x++) {
			for (int y = -3; y <= 3; y++) {
				if ((Math.abs(x) != 3 || Math.abs(y) != 3) && (Math.abs(x) != 2 || Math.abs(y) != 3) && (Math.abs(x) != 3 || Math.abs(y) != 2)) {
					if (world.isAirBlock(i3 + x, j3, k3 + y)) {
						world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta, 3);
					}
				}

				if ((Math.abs(x) < 3 && Math.abs(y) < 3) && (Math.abs(x) != 2 || Math.abs(y) != 2)) {
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
}
