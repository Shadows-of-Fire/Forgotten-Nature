package ForgottenNature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genFruit extends WorldGenerator
{
	Block leaf;
    int leafmeta;
    int I;
    Block log;
    int logmeta;
    public genFruit(boolean flag, Block i, int j, Block k, int l, int is)
    {
        flower = flag;
        leaf = i;
        leafmeta = j;
        log = k;
        logmeta = l;
        I = is;
    }
    public boolean generate(World world, Random random, int i, int j, int k)
    {
    	if(world.isRemote)
    		return false;
        if (I == 0)
        {
            return false;
        }

        int l = random.nextInt(3) + 4;

        if (j < 1 || j + l + 1 > 256)
        {
            return false;
        }

        int met = Block.getIdFromBlock(world.getBlock(i, j - 1, k));

        if (met != 2 && met != 3 || j >= 256 - l - 1)//grass dirt
        {
            return false;
        }

        world.setBlock(i, j - 1, k, Block.getBlockById(3), 0, 3);//dirt

        for (int l1 = 0; l1 < l; l1++)
        {
        	if(world.isAirBlock(i, j + l1, k) || l1 == 0)
        		world.setBlock(i, j + l1, k, log, logmeta, 3);

            if (l1 == l - 1)
            {
                genLeaves(world, random, flower, i, j + l1, k, leaf, leafmeta);
            }
        }

        for (int j3 = 0; j3 <= 1; j3++)
        {
            if (random.nextInt(8) == 0)
            {
                branches(world, random, flower, i, j + j3, k, -1, 0, leaf, leafmeta, log, logmeta);
            }

            if (random.nextInt(8) == 0)
            {
                branches(world, random, flower, i, j + j3, k, 1, 0, leaf, leafmeta, log, logmeta);
            }

            if (random.nextInt(8) == 0)
            {
                branches(world, random, flower, i, j + j3, k, 0, -1, leaf, leafmeta, log, logmeta);
            }

            if (random.nextInt(8) == 0)
            {
                branches(world, random, flower, i, j + j3, k, 0, 1, leaf, leafmeta, log, logmeta);
            }

            if (random.nextInt(8) == 0)
            {
                branches(world, random, flower, i, j + j3, k, -1, 1, leaf, leafmeta, log, logmeta);
            }

            if (random.nextInt(8) == 0)
            {
                branches(world, random, flower, i, j + j3, k, -1, -1, leaf, leafmeta, log, logmeta);
            }

            if (random.nextInt(8) == 0)
            {
                branches(world, random, flower, i, j + j3, k, 1, 1, leaf, leafmeta, log, logmeta);
            }

            if (random.nextInt(8) == 0)
            {
                branches(world, random, flower, i, j + j3, k, 1, -1, leaf, leafmeta, log, logmeta);
            }
        }

        return true;
    }
    public static void branches(World world, Random random, boolean flower, int ii, int jj, int kk, int iD, int kD, Block leaf2, int leafmeta, Block log2, int logmeta)
    {
        for (int br = 0; br < 4; br++)
        {
            if (iD == -1 && random.nextInt(2) == 0)
            {
                ii--;
            }

            if (iD == 1 && random.nextInt(2) == 0)
            {
                ii++;
            }

            if (kD == -1 && random.nextInt(2) == 0)
            {
                kk--;
            }

            if (kD == 1 && random.nextInt(2) == 0)
            {
                kk++;
            }
            
            if(world.isAirBlock(ii, jj, kk) || world.getBlock(ii, jj, kk) == leaf2)
            	world.setBlock(ii, jj, kk,  log2, logmeta, 3);

            if (br == 3)
            {
                genLeaves(world, random, flower, ii, jj, kk, leaf2, leafmeta);
            }

            jj++;
        }
    }
    public static void genLeaves(World world, Random random, boolean flower, int i3, int j3, int k3, Block leaf2, int leafmeta)
    {
        for (int x = -2; x <= 2; x++)
        {
            for (int y = -2; y <= 2; y++)
            {
                if (Math.abs(x) != 2 || Math.abs(y) != 2)
                {
                	if(world.isAirBlock(i3 + x, j3, k3 + y))
                    {
                        if (random.nextInt(4) > 0 | flower == false)
                        {
                            world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta, 3);
                        }
                        else
                        {
                            world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta + 1, 3);
                        }
                    }
                }

                if ((Math.abs(x) < 2 && Math.abs(y) < 2) && (Math.abs(x) != 1 || Math.abs(y) != 1))
                {
                	if(world.isAirBlock(i3 + x, j3 + 1, k3 + y))
                    {
                        if (random.nextInt(4) > 0 | flower == false)
                        {
                            world.setBlock(i3 + x, j3 + 1, k3 + y, leaf2, leafmeta, 3);
                        }
                        else
                        {
                            world.setBlock(i3 + x, j3 + 1, k3 + y, leaf2, leafmeta + 1, 3);
                        }
                    }
                }
            }
        }
    }
    boolean flower;
}
