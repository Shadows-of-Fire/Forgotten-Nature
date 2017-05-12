package ForgottenNature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genFloatingIsland extends WorldGenerator
{
    int size = 10;
    
    public genFloatingIsland(){}
    
    public boolean generate(World world, Random random, int i2, int j2, int k2)
    {
    	if(world.isRemote)
    		return false;
    	size = size + random.nextInt(26);
    	int powSize = (int)Math.pow(size,2);
        int i = i2;
        int j = j2;
        int k = k2;
        
        int y = size/2;
        int heightLeft = 255 - j - 40;
        
        if(heightLeft < 1)
        	heightLeft = 1;
        
        int h = 20 + random.nextInt(heightLeft);

        float coef;
        int placeIndex = 0;
        int firstRan = 0;
        int secondRan = 0;
        int thirdRan = 0;
        int fourthRan = 0;
        
        for(int up = y + 20; up >= 0; up--)
        {
        	coef = (float) up / (float) y;
        	
	        for(int r = 0; r <= powSize; r++)
	        {
	        	for(int d = 0; d <= powSize; d++)
	            {
	        		if(up <= y)
	        		{
		        		if((float)(Math.pow(r, 2) + (float)Math.pow(d, 2)) <= (coef*powSize))
		        		{
		        			if(up < y - 1 && random.nextInt(18) == 0)
		        			{
		        				placeIndex = random.nextInt(4) + 1;
		        				if(placeIndex == 1)
		        				{
		        					firstRan = random.nextInt(h/4);
		        				}
		        				else
		        				if(placeIndex == 2)
		        				{
		        					secondRan = random.nextInt(h/4);
		        				}
		        				else
				        		if(placeIndex == 3)
				        		{
				        			thirdRan = random.nextInt(h/4);
				        		}
				        		else
						        if(placeIndex == 4)
						        {
						        	fourthRan = random.nextInt(h/4);
						        }
		        			}
		        			else
		        			{
		        				placeIndex = 0;
		        			}
		        				
		        			
		        			world.setBlock(r+i, j + up + h - firstRan, d+k, world.getBlock(r+i, j - y + up, d+k), world.getBlockMetadata(r+i, j - y + up, d+k), 3);
		        			world.setBlock(-r+i, j + up + h - secondRan, d+k, world.getBlock(-r+i, j - y + up, d+k), world.getBlockMetadata(-r+i, j - y + up, d+k), 3);
		        			world.setBlock(r+i, j + up + h - thirdRan, -d+k, world.getBlock(r+i, j - y + up, -d+k), world.getBlockMetadata(r+i, j - y + up, -d+k), 3);
		        			world.setBlock(-r+i, j + up + h - fourthRan, -d+k, world.getBlock(-r+i, j - y + up, -d+k), world.getBlockMetadata(-r+i, j - y + up, -d+k), 3);
		        			world.setBlockToAir(r+i, j - y + up, d+k);
		        			world.setBlockToAir(-r+i, j - y + up, d+k);
		        			world.setBlockToAir(r+i, j - y + up, -d+k);
		        			world.setBlockToAir(-r+i, j - y + up, -d+k);
		        			
		        			firstRan = 0;
		        	        secondRan = 0;
		        	        thirdRan = 0;
		        	        fourthRan = 0;
		        		}
	        		}
	        		else
	        		if((Math.pow(r, 2) + Math.pow(d, 2)) <= (powSize))
	        		{
	        			world.setBlock(r+i, j + up + h, d+k, world.getBlock(r+i, j - y + up, d+k), world.getBlockMetadata(r+i, j - y + up, d+k), 3);
	        			world.setBlock(-r+i, j + up + h, d+k, world.getBlock(-r+i, j - y + up, d+k), world.getBlockMetadata(-r+i, j - y + up, d+k), 3);
	        			world.setBlock(r+i, j + up + h, -d+k, world.getBlock(r+i, j - y + up, -d+k), world.getBlockMetadata(r+i, j - y + up, -d+k), 3);
	        			world.setBlock(-r+i, j + up + h, -d+k, world.getBlock(-r+i, j - y + up, -d+k), world.getBlockMetadata(-r+i, j - y + up, -d+k), 3);
	        			world.setBlockToAir(r+i, j - y + up, d+k);
	        			world.setBlockToAir(-r+i, j - y + up, d+k);
	        			world.setBlockToAir(r+i, j - y + up, -d+k);
	        			world.setBlockToAir(-r+i, j - y + up, -d+k);
	        		}
	            }
	        }
        }

        return true;
    }
}

