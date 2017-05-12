package ForgottenNature.WorldGen;
import java.util.Random;

import ForgottenNature.Proxy.FNBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genCedar extends WorldGenerator
{
    Block leaf;
    int leafmeta;
    Block log;
    int logmeta;
    public genCedar(Block i, int j, Block k, int l)
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
        int j1;
        int k1 = k;
        int met = Block.getIdFromBlock(world.getBlock(i, j, k));

        while ((met != 3) && (met != 2))
        {
            j--;
            met = Block.getIdFromBlock(world.getBlock(i, j, k));

            if (met == 8 || met == 9 || met == 1)
            {
                return false;
            }
        }

        j1 = j + 1;

        if (random.nextInt(10) < 9)
        {
            int h = random.nextInt(10) + 9;
            world.setBlock(i1, j1 - 1, k1, Block.getBlockById(3), 0, 3);

            for (int jj = 0; jj <= h; jj++)
            {
            	if(world.isAirBlock(i1, j1 + jj, k1) || world.getBlock(i1, j1 + jj, k1) == leaf || jj == 0)
            		world.setBlock(i1, j1 + jj, k1, log, logmeta, 3);

                if (jj == h)
                {
                    leafTop(world, i1, j1 + jj, k1, leaf, leafmeta, log);
                }

                if (jj > 5 & jj < h)
                {
                    if (jj == h - 1)
                    {
                        leafGen(world, 2, i1, j1 + jj, k1, leaf, leafmeta, log);
                    }

                    if (jj == h - 4)
                    {
                        for (int next = 1; next < 3; next++)
                        {
                        	if(world.isAirBlock(i1 + next, j1 + jj - 2, k1) || world.getBlock(i1 + next, j1 + jj - 2, k1) == leaf)
                        		world.setBlock(i1 + next, j1 + jj - 2, k1, log, logmeta, 3);
                        	if(world.isAirBlock(i1 - next, j1 + jj - 2, k1) || world.getBlock(i1 - next, j1 + jj - 2, k1) == leaf)
                        		world.setBlock(i1 - next, j1 + jj - 2, k1, log, logmeta, 3);
                        	if(world.isAirBlock(i1, j1 + jj - 2, k1 + next) || world.getBlock(i1, j1 + jj - 2, k1 + next) == leaf)
                        		world.setBlock(i1, j1 + jj - 2, k1 + next, log, logmeta, 3);
                        	if(world.isAirBlock(i1, j1 + jj - 2, k1 - next) || world.getBlock(i1, j1 + jj - 2, k1 - next) == leaf)
                        		world.setBlock(i1, j1 + jj - 2, k1 - next, log, logmeta, 3);
                        }

                        leafGen(world, 3, i1, j1 + jj, k1, leaf, leafmeta, log);
                    }

                    if (jj == h - 7)
                    {
                        for (int next = 1; next <= 3; next++)
                        {
                        	if(world.isAirBlock(i1 + next, j1 + jj - 2, k1) || world.getBlock(i1 + next, j1 + jj - 2, k1) == leaf)
                        		world.setBlock(i1 + next, j1 + jj - 2, k1, log, logmeta, 3);
                        	if(world.isAirBlock(i1 - next, j1 + jj - 2, k1) || world.getBlock(i1 - next, j1 + jj - 2, k1) == leaf)
                            	world.setBlock(i1 - next, j1 + jj - 2, k1, log, logmeta, 3);
                        	if(world.isAirBlock(i1, j1 + jj - 2, k1 + next) || world.getBlock(i1, j1 + jj - 2, k1 + next) == leaf)
                            	world.setBlock(i1, j1 + jj - 2, k1 + next, log, logmeta, 3);
                        	if(world.isAirBlock(i1, j1 + jj - 2, k1 - next) || world.getBlock(i1, j1 + jj - 2, k1 - next) == leaf)
                            	world.setBlock(i1, j1 + jj - 2, k1 - next, log, logmeta, 3);
                        }

                        leafGen(world, 4, i1, j1 + jj, k1, leaf, leafmeta, log);
                    }

                    if (jj == h - 10)
                    {
                        leafGen(world, 3, i1, j1 + jj, k1, leaf, leafmeta, log);
                    }

                    if (jj == h - 13)
                    {
                        leafGen(world, 2, i1, j1 + jj, k1, leaf, leafmeta, log);
                    }
                }
            }
        }
        else//////////////////A larger growth////////////////////
        {
            int h = random.nextInt(12) + 12;
            world.setBlock(i1, j1 - 1, k1, Block.getBlockById(3), 0, 3);

            for (int jj = h; jj >= 0; jj--)
            {
            	if(world.isAirBlock(i1, j1 + jj, k1))
                world.setBlock(i1, j1 + jj, k1, log, logmeta, 3);

                if (jj > 5 & jj < h)
                {
                    if (jj == h - 1)
                    {
                        leafGen(world, 2, i1, j1 + jj, k1, leaf, leafmeta, log);
                    }

                    if (jj == h - 4)
                    {
                        for (int next = 1; next < 3; next++)
                        {
                        	if(world.isAirBlock(i1 + next, j1 + jj - 2, k1) || world.getBlock(i1 + next, j1 + jj - 2, k1) == leaf)
                        		world.setBlock(i1 + next, j1 + jj - 2, k1, log, logmeta, 3);
                        	if(world.isAirBlock(i1 - next, j1 + jj - 2, k1) || world.getBlock(i1 - next, j1 + jj - 2, k1) == leaf)
                        		world.setBlock(i1 - next, j1 + jj - 2, k1, log, logmeta, 3);
                        	if(world.isAirBlock(i1, j1 + jj - 2, k1 + next) || world.getBlock(i1, j1 + jj - 2, k1 + next) == leaf)
                        		world.setBlock(i1, j1 + jj - 2, k1 + next, log, logmeta, 3);
                        	if(world.isAirBlock(i1, j1 + jj - 2, k1 - next) || world.getBlock(i1, j1 + jj - 2, k1 - next) == leaf)
                        		world.setBlock(i1, j1 + jj - 2, k1 - next, log, logmeta, 3);
                        }

                        leafGen(world, 3, i1, j1 + jj, k1, leaf, leafmeta, log);
                    }

                    if (jj == h - 7)
                    {
                        for (int next = 1; next <= 3; next++)
                        {
                        	if(world.isAirBlock(i1 + next, j1 + jj - 2, k1) || world.getBlock(i1 + next, j1 + jj - 2, k1) == leaf)
                        		world.setBlock(i1 + next, j1 + jj - 2, k1, log, logmeta, 3);
                        	if(world.isAirBlock(i1 - next, j1 + jj - 2, k1) || world.getBlock(i1 - next, j1 + jj - 2, k1) == leaf)
                        		world.setBlock(i1 - next, j1 + jj - 2, k1, log, logmeta, 3);
                        	if(world.isAirBlock(i1, j1 + jj - 2, k1 + next) || world.getBlock(i1, j1 + jj - 2, k1 + next) == leaf)
                        		world.setBlock(i1, j1 + jj - 2, k1 + next, log, logmeta, 3);
                        	if(world.isAirBlock(i1, j1 + jj - 2, k1 - next) || world.getBlock(i1, j1 + jj - 2, k1 - next) == leaf)
                        		world.setBlock(i1, j1 + jj - 2, k1 - next, log, logmeta, 3);
                        }

                        leafGen(world, 4, i1, j1 + jj, k1, leaf, leafmeta, log);
                    }

                    if (jj == h - 10)
                    {
                        for (int next = 1; next <= 4; next++)
                        {
                        	if(world.isAirBlock(i1 + next, j1 + jj - 2, k1) || world.getBlock(i1 + next, j1 + jj - 2, k1) == leaf)
                        		world.setBlock(i1 + next, j1 + jj - 2, k1, log, logmeta, 3);
                        	if(world.isAirBlock(i1 - next, j1 + jj - 2, k1) || world.getBlock(i1 - next, j1 + jj - 2, k1) == leaf)
                        		world.setBlock(i1 - next, j1 + jj - 2, k1, log, logmeta, 3);
                        	if(world.isAirBlock(i1, j1 + jj - 2, k1 + next) || world.getBlock(i1, j1 + jj - 2, k1 + next) == leaf)
                        		world.setBlock(i1, j1 + jj - 2, k1 + next, log, logmeta, 3);
                        	if(world.isAirBlock(i1, j1 + jj - 2, k1 - next) || world.getBlock(i1, j1 + jj - 2, k1 - next) == leaf)
                        		world.setBlock(i1, j1 + jj - 2, k1 - next, log, logmeta, 3);
                        }

                        leafGen(world, 5, i1, j1 + jj, k1, leaf, leafmeta, log);
                    }

                    if (jj == h - 13)
                    {
                    	if(world.isAirBlock(i1 + 1, j1 + jj - 2, k1) || world.getBlock(i1 + 1, j1 + jj - 2, k1) == leaf)
                    		world.setBlock(i1 + 1, j1 + jj - 2, k1, log, logmeta, 3);
                    	if(world.isAirBlock(i1 - 1, j1 + jj - 2, k1) || world.getBlock(i1 - 1, j1 + jj - 2, k1) == leaf)
                    		world.setBlock(i1 - 1, j1 + jj - 2, k1, log, logmeta, 3);
                        if(world.isAirBlock(i1, j1 + jj - 2, k1 + 1) || world.getBlock(i1, j1 + jj - 2, k1 + 1) == leaf)
                        	world.setBlock(i1, j1 + jj - 2, k1 + 1, log, logmeta, 3);
                        if(world.isAirBlock(i1, j1 + jj - 2, k1 - 1) || world.getBlock(i1, j1 + jj - 2, k1 - 1) == leaf)
                        	world.setBlock(i1, j1 + jj - 2, k1 - 1, log, logmeta, 3);
                        int r = random.nextInt(3) + 2;
                        leafGen(world, r, i1, j1 + jj, k1, leaf, leafmeta, log);
                    }
                }

                if (jj == h)
                {
                    leafTop(world, i1, j1 + jj, k1, leaf, leafmeta, log);
                }
            }
        }

        return true;
    }
    public static void leafGen(World world, int var, int i3, int j3, int k3, Block leaf, int leafmeta, Block log)
    {
        if (var == 2)
        {
            for (int x = -3; x <= 3; x++)
            {
                for (int y = -3; y <= 3; y++)
                {
                    if (world.isAirBlock(i3 + x, j3, k3 + y) && (Math.abs(x) + Math.abs(y) < 2))
                    {
                        world.setBlock(i3 + x, j3, k3 + y, leaf, leafmeta, 3);
                    }

                    if (world.isAirBlock(i3 + x, j3 - 1, k3 + y) && (Math.abs(x) + Math.abs(y) < 3))
                    {
                        world.setBlock(i3 + x, j3 - 1, k3 + y, leaf, leafmeta, 3);
                    }

                    if (world.isAirBlock(i3 + x, j3 - 2, k3 + y) && (Math.abs(x) + Math.abs(y) < 5))
                    {
                        world.setBlock(i3 + x, j3 - 2, k3 + y, leaf, leafmeta, 3);
                    }
                }
            }
        }

        if (var == 3)
        {
            for (int x = -4; x <= 4; x++)
            {
                for (int y = -4; y <= 4; y++)
                {
                    if (world.isAirBlock(i3 + x, j3, k3 + y) && (Math.abs(x) + Math.abs(y) < 3))
                    {
                        world.setBlock(i3 + x, j3, k3 + y, leaf, leafmeta, 3);
                    }

                    if (world.isAirBlock(i3 + x, j3 - 1, k3 + y) && (Math.abs(x) + Math.abs(y) < 5))
                    {
                        world.setBlock(i3 + x, j3 - 1, k3 + y, leaf, leafmeta, 3);
                    }

                    if (world.isAirBlock(i3 + x, j3 - 2, k3 + y) && (Math.abs(x) + Math.abs(y) < 7))
                    {
                        world.setBlock(i3 + x, j3 - 2, k3 + y, leaf, leafmeta, 3);
                    }
                }
            }
        }

        if (var == 4)
        {
            for (int x = -5; x <= 5; x++)
            {
                for (int y = -5; y <= 5; y++)
                {
                    if (world.isAirBlock(i3 + x, j3, k3 + y) && (Math.abs(x) + Math.abs(y) < 5))
                    {
                        world.setBlock(i3 + x, j3, k3 + y, leaf, leafmeta, 3);
                    }

                    if (world.isAirBlock(i3 + x, j3 - 1, k3 + y) && (Math.abs(x) + Math.abs(y) < 7))
                    {
                        world.setBlock(i3 + x, j3 - 1, k3 + y, leaf, leafmeta, 3);
                    }

                    if (world.isAirBlock(i3 + x, j3 - 2, k3 + y) && (Math.abs(x) + Math.abs(y) < 8))
                    {
                        world.setBlock(i3 + x, j3 - 2, k3 + y, leaf, leafmeta, 3);
                    }
                }
            }
        }

        if (var == 5)
        {
            for (int x = -6; x <= 6; x++)
            {
                for (int y = -6; y <= 6; y++)
                {
                    if (world.isAirBlock(i3 + x, j3, k3 + y) && (Math.abs(x) + Math.abs(y) < 7))
                    {
                        world.setBlock(i3 + x, j3, k3 + y, leaf, leafmeta, 3);
                    }

                    if (world.isAirBlock(i3 + x, j3 - 1, k3 + y) && (Math.abs(x) + Math.abs(y) < 8))
                    {
                        world.setBlock(i3 + x, j3 - 1, k3 + y, leaf, leafmeta, 3);
                    }

                    if (world.isAirBlock(i3 + x, j3 - 2, k3 + y) && (Math.abs(x) + Math.abs(y) < 9))
                    {
                        world.setBlock(i3 + x, j3 - 2, k3 + y, leaf, leafmeta, 3);
                    }
                }
            }
        }
    }
    public static void leafTop(World world, int i3, int j3, int k3, Block leaf, int leafmeta, Block log)
    {
        for (int x = -2; x <= 2; x++)
        {
            for (int y = -2; y <= 2; y++)
            {
                if (world.isAirBlock(i3 + x, j3, k3 + y) && (Math.abs(x) + Math.abs(y) < 3))
                {
                    world.setBlock(i3 + x, j3, k3 + y, leaf, leafmeta, 3);
                }

                if (world.isAirBlock(i3 + x, j3 + 1, k3 + y) && (Math.abs(x) + Math.abs(y) < 2))
                {
                    world.setBlock(i3 + x, j3 + 1, k3 + y, leaf, leafmeta, 3);
                }

                if (world.isAirBlock(i3 + x, j3 + 2, k3 + y) && (Math.abs(x) == 0 && Math.abs(y) == 0))
                {
                    world.setBlock(i3 + x, j3 + 2, k3 + y, leaf, leafmeta, 3);
                }
            }
        }
    }
}