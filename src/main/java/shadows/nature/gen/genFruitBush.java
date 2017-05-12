package ForgottenNature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genFruitBush extends WorldGenerator
{
	Block leaf;
    int leafmeta;
    int logmeta;
    public genFruitBush(Block i, int j, int k)
    {
        leaf = i;
        leafmeta = j;
        logmeta = k;
    }
    public boolean generate(World world, Random random, int i, int j, int k)
    {
    	if(world.isRemote)
    		return false;
        int i1 = i;
        int j1 = j;
        int k1 = k;
        int met = Block.getIdFromBlock(world.getBlock(i, j, k));

        while ((met != 3) & (met != 2))
        {
            j--;
            met = Block.getIdFromBlock(world.getBlock(i, j, k));

            if (met == 8 | met == 9 | met == 1)
            {
                return false;
            }
        }

        world.setBlock(i1, j, k1, Block.getBlockById(3), 0, 3);//dirt
        j1 = j + 1;
        world.setBlock(i1, j1, k1, Block.getBlockById(17), 0, 3);//oak log
        leafGen(world, random, 2, i1, j1, k1, leaf, leafmeta);
        return true;
    }
    public static void leafGen(World world, Random random, int var, int i3, int j3, int k3, Block leaf2, int leafmeta)
    {
        int fruit = 0;

        for (int x = -var; x <= var; x++)
        {
            for (int y = -var; y <= var; y++)
            {
                if (random.nextInt(4) == 0)
                {
                    fruit = 1;
                }

                if ((Math.abs(x) != var || Math.abs(y) != var) && (Math.abs(x) != var - 1 || Math.abs(y) != var) && (Math.abs(x) != var || Math.abs(y) != var - 1) && world.isAirBlock(i3 + x, j3, k3 + y))
                {
                    world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta + fruit, 3);
                }

                fruit = 0;

                if (random.nextInt(4) == 0)
                {
                    fruit = 1;
                }

                if (Math.abs(x) < var && Math.abs(y) < var && (Math.abs(x) != var - 1 || Math.abs(y) != var - 1))
                {
                	if(world.isAirBlock(i3 + x, j3, k3 + y))
                	{
                		world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta + fruit, 3);
                    	world.setBlock(i3 + x, j3, k3 + y, leaf2, leafmeta + fruit, 3);
                	}
                }

                fruit = 0;
            }
        }
    }
}