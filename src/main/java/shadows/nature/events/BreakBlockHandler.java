package ForgottenNature.Handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;
import ForgottenNature.Proxy.FNItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;

public class BreakBlockHandler
{       
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    
    public void onEvent(HarvestDropsEvent event)
    {
        if (event.block == Blocks.stone && event.world.rand.nextInt(20) == 0)
        {
            event.drops.clear();
            event.drops.add(new ItemStack(FNItems.powdersItem, 1, 0));
        }
        else
        if(event.block == Blocks.sandstone && event.world.rand.nextInt(20) == 0)
        {
        	event.drops.clear();
            event.drops.add(new ItemStack(FNItems.powdersItem, 1, 1));
        }
        else
        if(event.block == FNBlocks.newStones && ForgottenNature.craftGunpowder && (event.blockMetadata == 2 || event.blockMetadata == 3))
        {
        	if(event.world.rand.nextInt(35) == 0)
        	{
	        	event.drops.clear();
	        	if(event.world.rand.nextInt(2) == 0)
	        		event.drops.add(new ItemStack(FNItems.powdersItem, 1, 0));
	        	else
	        		event.drops.add(new ItemStack(FNItems.powdersItem, 1, 1));
        	}
        }
        else
        if((event.block == Blocks.log || event.block == Blocks.log2) && !(event.world.getClosestPlayer(event.x, event.y, event.z, 10) == null))
        {
        	int met = event.blockMetadata;
        	int ct = harvestBlock(event.world, event.world.getClosestPlayer(event.x, event.y, event.z, 10), event.x, event.y, event.z);
        	event.drops.clear();
        	while(met > 3)
        		met = met - 4;
            event.drops.add(new ItemStack(event.block, ct + 1, met));
        }
    } 
    
    public int harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par2, int par3, int par4)
    {
        int count = 0;
        int ai[] = {par2, par3 + 1, par4};
        Boolean can = Boolean.valueOf(true);
        Boolean isAxe = false;
        ItemStack equipped = par2EntityPlayer.getCurrentEquippedItem();
        if(equipped != null && (equipped.getItem() == Items.golden_axe || equipped.getItem() == Items.iron_axe
        		|| equipped.getItem() == Items.diamond_axe || equipped.getItem() == FNItems.dcAxeItem 
        			|| equipped.getItem() == FNItems.cAxeItem || equipped.getItem() == FNItems.oAxeItem))
        	isAxe = true;
        	
        if (isAxe && (par1World.getBlock(ai[0], ai[1], ai[2]) == Blocks.log || par1World.getBlock(ai[0], ai[1], ai[2]) == Blocks.log2) && ForgottenNature.lumberjack == true)
        {
            for (int i1 = -1; i1 <= 1; i1++)
            {
                for (int j1 = -1; j1 <= 0; j1++)
                {
                    for (int i2 = -1; i2 <= 1; i2++)
                    {
                        if ((i1 + par2 != par2 || j1 + par3 != par3 || i2 + par4 != par4) && (par1World.getBlock(i1 + par2, j1 + par3, i2 + par4) == Blocks.log) || par1World.getBlock(i1 + par2, j1 + par3, i2 + par4) == Blocks.log2)
                        {
                            can = Boolean.valueOf(false);
                        }
                    }
                }
            }

            if (can.booleanValue())
            {
                int ai1[][] = new int[ForgottenNature.lumberjackPower][3];
                Boolean boolean2 = Boolean.valueOf(false);
                ai1[0][0] = par2;
                ai1[0][1] = par3 + 1;
                ai1[0][2] = par4;
                int j2 = 1;

                do
                {
                    for (int l2 = 0; l2 < ai1.length && ai1[l2] != null; l2++)
                    {
                        for (int k3 = -1; k3 <= 1; k3++)
                        {
                            for (int i4 = -1; i4 <= 1; i4++)
                            {
                                for (int j4 = -1; j4 <= 1; j4++)
                                {
                                    if (par1World.getBlock(ai1[l2][0] + k3, ai1[l2][1] + i4, ai1[l2][2] + j4) != Blocks.log && par1World.getBlock(ai1[l2][0] + k3, ai1[l2][1] + i4, ai1[l2][2] + j4) != Blocks.log2)
                                    {
                                        continue;
                                    }
                                    Boolean boolean3 = Boolean.valueOf(false);
                                    for (int k4 = 0; k4 < ai1.length; k4++)
                                    {
                                        if (ai1[k4][1] <= 0 || ai1[k4][1] >= 150)
                                        {
                                            continue;
                                        }
                                        int i5 = ai1[l2][0];
                                        int k5 = ai1[l2][1];
                                        int i6 = ai1[l2][2];
                                        int j6 = k3 + i5;
                                        int k6 = i4 + k5;
                                        int l6 = j4 + i6;
                                        int ai2[] = {j6, k6, l6};
                                        if (ai2[0] != ai1[k4][0] || ai2[1] != ai1[k4][1] || ai2[2] != ai1[k4][2])
                                        {
                                            continue;
                                        }
                                        boolean3 = Boolean.valueOf(true);
                                        break;
                                    }
                                    if (!boolean3.booleanValue() && j2 < ai1.length)
                                    {
                                        int l4 = ai1[l2][0];
                                        int j5 = ai1[l2][1];
                                        int l5 = ai1[l2][2];
                                        ai1[j2][0] = k3 + l4;
                                        ai1[j2][1] = i4 + j5;
                                        ai1[j2][2] = j4 + l5;
                                        boolean2 = Boolean.valueOf(true);
                                        j2++;
                                    }
                                }
                            }
                        }
                    }
                    boolean2 = Boolean.valueOf(false);
                }
                while (boolean2.booleanValue());
                for (int i3 = 0; i3 < ai1.length; i3++)
                {
                    if (par1World.getBlock(ai1[i3][0], ai1[i3][1], ai1[i3][2]) == Blocks.log && ai1[i3][1] > 0 && ai1[i3][1] < ForgottenNature.lumberjackPower)
                    {
                    	int met = par1World.getBlockMetadata(ai1[i3][0], ai1[i3][1], ai1[i3][2]);
                    	if(met >= 8)
                    		met = met - 8;
                    	else
                    	if(met >= 4)
                    		met = met - 4;
                    	count ++;
//                        dropBlockAsItem(par1World, ai1[i3][0], ai1[i3][1], ai1[i3][2], new ItemStack(Blocks.log, 1, met));
                        par1World.setBlock(ai1[i3][0], ai1[i3][1], ai1[i3][2], Blocks.air, 0, 3);
                        if(equipped.getItemDamage()+1 <= equipped.getMaxDamage() && ForgottenNature.lumberjackDamage)
                        	equipped.setItemDamage(equipped.getItemDamage()+1);
                    }
                    else 
                    if (par1World.getBlock(ai1[i3][0], ai1[i3][1], ai1[i3][2]) == Blocks.log2 && ai1[i3][1] > 0 && ai1[i3][1] < ForgottenNature.lumberjackPower)
                    {
                    	int met = par1World.getBlockMetadata(ai1[i3][0], ai1[i3][1], ai1[i3][2]);
                    	if(met >= 8)
                    		met = met - 8;
                    	else
                    	if(met >= 4)
                    		met = met - 4;
                    	count ++;
//                        dropBlockAsItem(par1World, ai1[i3][0], ai1[i3][1], ai1[i3][2], new ItemStack(Blocks.log, 1, met));
                        par1World.setBlock(ai1[i3][0], ai1[i3][1], ai1[i3][2], Blocks.air, 0, 3);
                        if(equipped.getItemDamage()+1 <= equipped.getMaxDamage() && ForgottenNature.lumberjackDamage)
                        equipped.setItemDamage(equipped.getItemDamage()+1);
                    }
                }
            }
        }
        return count;
    }
}
