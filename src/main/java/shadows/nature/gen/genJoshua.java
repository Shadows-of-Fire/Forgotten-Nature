package ForgottenNature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genJoshua extends WorldGenerator
{
	Block leaf;
    int leafmeta;
    int logmeta;
    Block log;
    public genJoshua(Block i, int j, Block k, int l)
    {
        leaf = i;
        leafmeta = j;
        log = k;
        logmeta = l;
    }
    public boolean generate(World world, Random random, int i, int j, int k)
    {
    	if(world.isRemote)
    		return false;
        int i1 = i;
        int j1 = j;
        int k1 = k;
        int met = Block.getIdFromBlock(world.getBlock(i, j, k));

        while ((met != 3) & (met != 2) & met != 12)
        {
            j--;
            met = Block.getIdFromBlock(world.getBlock(i, j, k));

            if (met == 8 | met == 9 | met == 1)
            {
                return false;
            }
        }

        j1 = j + 1;

        if (random.nextInt(3) == 0)
        {
            rootGen(world, random, i, j, k, -1, 0, log, logmeta);
        }

        if (random.nextInt(3) == 0)
        {
            rootGen(world, random, i, j, k, 1, 0, log, logmeta);
        }

        if (random.nextInt(3) == 0)
        {
            rootGen(world, random, i, j, k, 0, -1, log, logmeta);
        }

        if (random.nextInt(3) == 0)
        {
            rootGen(world, random, i, j, k, 0, 1, log, logmeta);
        }

        if (random.nextInt(3) == 0)
        {
            rootGen(world, random, i, j, k, -1, 1, log, logmeta);
        }

        if (random.nextInt(3) == 0)
        {
            rootGen(world, random, i, j, k, -1, -1, log, logmeta);
        }

        if (random.nextInt(3) == 0)
        {
            rootGen(world, random, i, j, k, 1, 1, log, logmeta);
        }

        if (random.nextInt(3) == 0)
        {
            rootGen(world, random, i, j, k, 1, -1, log, logmeta);
        }

        rootGen(world, random, i, j, k, 0, 0, log, logmeta);
        int h = random.nextInt(3) + 5;
        world.setBlock(i1, j1 - 1, k1, log, logmeta, 3);

        for (int jj = j1; jj <= j1 + h; jj++)
        {
            world.setBlock(i1, jj, k1, log, logmeta, 3);
            if (jj == j1 + h)
            {
                leafGen(world, i1, jj, k1, leaf, leafmeta);
            }

            if (jj - j1 >= h / 2)
            {
                if (random.nextInt(4) == 0)
                {
                    branch(world, random, i1, jj, k1, -1, 0, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(4) == 0)
                {
                    branch(world, random, i1, jj, k1, 1, 0, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(4) == 0)
                {
                    branch(world, random, i1, jj, k1, 0, -1, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(4) == 0)
                {
                    branch(world, random, i1, jj, k1, 0, 1, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(4) == 0)
                {
                    branch(world, random, i1, jj, k1, -1, 1, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(4) == 0)
                {
                    branch(world, random, i1, jj, k1, -1, -1, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(4) == 0)
                {
                    branch(world, random, i1, jj, k1, 1, 1, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(4) == 0)
                {
                    branch(world, random, i1, jj, k1, 1, -1, leaf, leafmeta, log, logmeta);
                }
            }
        }

        return true;
    }
    public static void branch(World world, Random random, int ii, int jj, int kk, int iD, int kD, Block leaf2, int leafmeta, Block log2, int logmeta)
    {
        for (int br = 0; br < 4; br++)
        {
            if (iD == -1 && random.nextInt(3) > 0)
            {
                ii--;
            }

            if (iD == 1 && random.nextInt(3) > 0)
            {
                ii++;
            }

            if (kD == -1 && random.nextInt(3) > 0)
            {
                kk--;
            }

            if (kD == 1 && random.nextInt(3) > 0)
            {
                kk++;
            }

            if (world.isAirBlock(ii, jj, kk) || world.getBlock(ii, jj, kk) == leaf2)
            {
                world.setBlock(ii, jj, kk, log2, logmeta, 3);
            }

            if (random.nextInt(2) == 0)
            {
                jj++;
            }

            if (br == 3 || random.nextInt(3) == 0)
            {
            	if (world.isAirBlock(ii, jj, kk) || world.getBlock(ii, jj, kk) == leaf2)
                	world.setBlock(ii, jj, kk, log2, logmeta, 3);
                leafGen(world, ii, jj, kk, leaf2, leafmeta);
            }
        }
    }
    public static void leafGen(World world, int i3, int j3, int k3, Block leaf2, int leafmeta)
    {
        for (int x = -1; x <= 1; x++)
        {
            for (int y = -1; y <= 1; y++)
            {
                for (int jh = -1; jh <= 1; jh++)
                {
                    if ((Math.abs(x) != 1 || Math.abs(y) != 1) && (Math.abs(y) != 1 || Math.abs(jh) != 1) && (Math.abs(x) != 1 || Math.abs(jh) != 1) && world.isAirBlock(i3 + x, j3 + jh, k3 + y))
                    {
                        world.setBlock(i3 + x, j3 + jh, k3 + y, leaf2, leafmeta, 3);
                    }
                }
            }
        }
    }
    public static void rootGen(World world, Random random, int ii, int jj, int kk, int iD, int kD, Block log2, int logmeta)
    {
        for (int br = 0; br < 6; br++)
        {
            if (iD == -1 && random.nextInt(3) == 0)
            {
                ii--;
            }

            if (iD == 1 && random.nextInt(3) == 0)
            {
                ii++;
            }

            if (kD == -1 && random.nextInt(3) == 0)
            {
                kk--;
            }

            if (kD == 1 && random.nextInt(3) == 0)
            {
                kk++;
            }

            jj--;
            int met = Block.getIdFromBlock(world.getBlock(ii, jj, kk));

            if (met == 0 | met == 2 | met == 3 | met == 12 | met == 24)
            {
            	world.setBlock(ii, jj, kk, log2, logmeta, 3);
            }
        }
    }
}