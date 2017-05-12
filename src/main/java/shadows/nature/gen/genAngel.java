package ForgottenNature.WorldGen;
import java.util.Random;

import ForgottenNature.Proxy.FNBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genAngel extends WorldGenerator
{
    Block leaf;
    int leafmeta;
    public genAngel(Block i, int j)
    {
        leaf = i;
        leafmeta = j;
    }
    public boolean generate(World world, Random random, int i, int j, int k)
    {
    	if(world.isRemote)
    		return false;
        int bh = random.nextInt(4) + 3;
        int mag = 15 + random.nextInt(25);
        int i1 = i;
        int j1 = j;
        int k1 = k;
        int i11;
        int j11;
        int k11;
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
        j1 = j + 1;
        for (int i2 = -1; i2 <= 1; i2++)
        {
            for (int k2 = -1; k2 <= 1; k2++)
            {
            	world.setBlock(i1 + i2, j1 - 1, k1 + k2, Block.getBlockById(3), 0, 3);//dirt
                for (int k3 = 0; k3 <= bh; k3++)
                {
                	if(world.isAirBlock(i1 + i2, j1 + k3, k1 + k2) || (k3 == 0 && i2 == 0 && k2 == 0))
                		world.setBlock(i1 + i2, j1 + k3, k1 + k2, Block.getBlockById(17), 0, 3);//oak log
                }
                if(world.isAirBlock(i1, j1 + bh + 1, k1))
                	world.setBlock(i1, j1 + bh + 1, k1, Block.getBlockById(17), 0, 3);//oak log
            }
        }
        for(int id = -1; id <= 1; id++)
        {
        	for(int kd = -1; kd <= 1; kd++)
        	{
        		if(id != 0 || kd != 0)
        		{
        			mainBranch(world, random, mag, id, kd, i1, j1 + bh, k1, leaf, leafmeta);
        			innerMainBranch(world, random, mag, id, kd, i1, j1 + bh, k1, leaf, leafmeta);
        			innerInnerBranch(world, random, mag, id, kd, i1, j1 + bh, k1, leaf, leafmeta);
        		}
        	}
        }
        return true;
	}
    public static void mainBranch(World world, Random random, int size, int iD, int kD, int i2, int j2, int k2, Block leaf2, int leafmeta)
    {
    	int bend = 0;
    	int index = 0;
    	if(iD == 1)
    		i2 = i2 + 2;
    	if(iD == -1)
    		i2 = i2 - 2;
    	if(kD == 1)
    		k2 = k2 + 2;
    	if(kD == -1)
    		k2 = k2 - 2;
    	while(index < size)
    	{	if(bend == 0 && random.nextInt(4) == 0)
        		j2++; 
        	if(bend == 1 && random.nextInt(2) == 0)
        		j2++;
        	if(bend == 2)
        		j2++;
        	if(world.isAirBlock(i2, j2, k2))
        		world.setBlock(i2, j2, k2, Block.getBlockById(17), 0, 3);//oak log
    		if(random.nextInt(3) == 0 || index == size - 1)
    			leafGen(world, i2, j2, k2, leaf2, leafmeta);
    		if(iD == 0)
        		i2 = i2 + random.nextInt(3) - 1;
    		if(iD == 1)
    			i2 = i2 + random.nextInt(2);
        	if(iD == -1)
        		i2 = i2 - random.nextInt(2);
        	if(kD == 0)
        		k2 = k2 + random.nextInt(3) - 1;
        	if(kD == 1)
        		k2 = k2 + random.nextInt(2);
        	if(kD == -1)
        		k2 = k2 - random.nextInt(2);
        	if(index == size/3)
        		bend = 1;
        	if(index == 2*size/3)
        		bend = 2;
        	if(random.nextInt(4) == 0)
        		secondary(world, random, size/2 - index/2, iD, kD, i2, j2, k2, leaf2, leafmeta);
        	index++;
    	}
    }
    public static void innerMainBranch(World world, Random random, int size, int iD, int kD, int i2, int j2, int k2, Block leaf2, int leafmeta)
    {
    	int bend2 = 0;
    	int index = 0;
    	while(index < 2*size/3)
    	{
    		if(world.isAirBlock(i2, j2, k2) || world.getBlock(i2, j2, k2) == leaf2)
    			world.setBlock(i2, j2, k2, Block.getBlockById(17), 0, 3);//oak log
    		if(random.nextInt(3) == 0 || index == 2*size/3 - 1)
    			leafGen(world, i2, j2, k2, leaf2, leafmeta);
    		if(iD == 0)
        		i2 = i2 + random.nextInt(3) - 1;
    		if(iD == 1)
    			i2 = i2 + random.nextInt(2);
        	if(iD == -1)
        		i2 = i2 - random.nextInt(2);
        	if(kD == 0)
            	k2 = k2 + random.nextInt(3) - 1;
        	if(kD == 1)
        		k2 = k2 + random.nextInt(2);
        	if(kD == -1)
        		k2 = k2 - random.nextInt(2);
        	if(random.nextInt(6) == 0 && index > size/3)
        		secondary(world, random, size/3 - index/3, iD, kD, i2, j2, k2, leaf2, leafmeta);
        	j2++; 
        	index++;
    	}
    }
    public static void innerInnerBranch(World world, Random random, int size, int iD, int kD, int i2, int j2, int k2, Block leaf2, int leafmeta)
    {
    	int index = 0;
    	while(index < size/3)
    	{
    		if(world.isAirBlock(i2, j2, k2) || world.getBlock(i2, j2, k2) == leaf2)
    			world.setBlock(i2, j2, k2, Block.getBlockById(17), 0, 3); // oak log
    		if(random.nextInt(3) == 0 || index == size/3 - 1)
    			leafGen(world, i2, j2, k2, leaf2, leafmeta);
    		if(iD == 0)
        		i2 = i2 + random.nextInt(3) - 1;
    		if(iD == 1)
    			i2 = i2 + random.nextInt(2);
        	if(iD == -1)
        		i2 = i2 - random.nextInt(2);
        	if(kD == 0)
            	k2 = k2 + random.nextInt(3) - 1;
        	if(kD == 1)
        		k2 = k2 + random.nextInt(2);
        	if(kD == -1)
        		k2 = k2 - random.nextInt(2); 
        	if(random.nextInt(6) == 0 && index > size/6)
        		secondary(world, random, size/6 - index/6, iD, kD, i2, j2, k2, leaf2, leafmeta);
        	j2++;
        	index++;
    	}
    }
    public static void secondary(World world, Random random, int size2, int iiD, int kkD, int i3, int j3, int k3, Block leaf2, int leafmeta)
    {
    	int index = 0;
    	for(int branch = 0; branch < 2; branch ++)
    	{
    		int i4 = i3;
    		int j4 = j3;
    		int k4 = k3;
	    	while(index < size2)
	    	{
	        	if(random.nextInt(2) == 0)
	        		j4++;
	        	if(world.isAirBlock(i4, j4, k4))
	        		world.setBlock(i4, j4, k4, Block.getBlockById(17), 0, 3); //oak log
	    		if(random.nextInt(4) == 0 || index == size2 - 1)
	    			leafGen(world, i4, j4, k4, leaf2, leafmeta);
	    		if(kkD == 0)
	    		{
	    			if(iiD == 1)
	    				i4 = i4 + random.nextInt(2);
	    			else
	    				i4 = i4 - random.nextInt(2);
	        		if(branch == 0)
	        			k4 = k4 + random.nextInt(2);
	        		else
	        			k4 = k4 - random.nextInt(2);
	    		}
	    		if(iiD == 0)
	    		{
	    			if(kkD == 1)
	    				k4 = k4 + random.nextInt(2);
	    			else
	    				k4 = k4 - random.nextInt(2);
	        		if(branch == 0)
	        			i4 = i4 + random.nextInt(2);
	        		else
	        			i4 = i4 - random.nextInt(2);
	    		}
	    		if(iiD == 1)
	    		{
	    			if(kkD == 1)
	    			{
	    				if(branch == 0)
		        			k4 = k4 + random.nextInt(2);
		        		else
		        			i4 = i4 + random.nextInt(2);
	    			}
	    			if(kkD == -1)
	    			{
	    				if(branch == 0)
		        			k4 = k4 - random.nextInt(2);
		        		else
		        			i4 = i4 + random.nextInt(2);
	    			}
	        		
	    		}
	    		if(iiD == -1)
	    		{
	    			if(kkD == 1)
	    			{
	    				if(branch == 0)
		        			k4 = k4 + random.nextInt(2);
		        		else
		        			i4 = i4 - random.nextInt(2);
	    			}
	    			if(kkD == -1)
	    			{
	    				if(branch == 0)
		        			k4 = k4 - random.nextInt(2);
		        		else
		        			i4 = i4 - random.nextInt(2);
	    			}
	        		
	    		}
	        	index++;
	    	}
    	}
    }
    public static void leafGen(World world, int i11, int j11, int k11, Block leaf2, int leafmeta)
    {
        for (int x = -3; x <= 3; x++)
        {
            for (int y = -3; y <= 3; y++)
            {
                if ((Math.abs(x) != 3 || Math.abs(y) != 3) && (Math.abs(x) != 3 || Math.abs(y) != 2) && (Math.abs(x) != 2 || Math.abs(y) != 3) && (x != 0 || y != 0))
                {
                    if (world.isAirBlock(i11 + x, j11, k11 + y))
                    {
                        world.setBlock(i11 + x, j11, k11 + y, leaf2, leafmeta, 2);
                    }
                }
                if ((Math.abs(x) < 3 && Math.abs(y) < 3) && (Math.abs(x) != 2 || Math.abs(y) != 2))
                {
                    if (world.isAirBlock(i11 + x, j11 - 1, k11 + y))
                    {
                        world.setBlock(i11 + x, j11 - 1, k11 + y, leaf2, leafmeta, 2);
                    }
                    if (world.isAirBlock(i11 + x, j11 + 1, k11 + y))
                    {
                        world.setBlock(i11 + x, j11 + 1, k11 + y, leaf2, leafmeta, 2);
                    }
                }
            }
        }
    }
}
