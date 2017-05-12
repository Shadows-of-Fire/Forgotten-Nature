package ForgottenNature.Items;

import java.util.ArrayList;
import java.util.Set;

import com.google.common.collect.Sets;

import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTitanStonePA extends ItemTool
{
	@SideOnly(Side.CLIENT)
    private IIcon field_94594_d;
	
	private static Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] {FNBlocks.newPlanks1,
			FNBlocks.newLogs1,FNBlocks.newLogs2,FNBlocks.newLogs3, Blocks.planks, 
			Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.wooden_slab, Blocks.double_wooden_slab, 
        	Blocks.pumpkin, Blocks.lit_pumpkin, FNBlocks.crystalWood, Blocks.grass, Blocks.dirt, 
        	Blocks.sand, Blocks.gravel, Blocks.snow, Blocks.snow_layer, Blocks.clay, Blocks.farmland, 
        	Blocks.soul_sand, Blocks.mycelium, Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, 
        	Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, 
        	Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, 
        	Blocks.ice,Blocks.lapis_ore, Blocks.lapis_block, Blocks.obsidian, FNBlocks.crystalStone});
    
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() >= 1 : 
        	(par1Block != Blocks.diamond_block && par1Block != Blocks.diamond_ore ? 
			(par1Block == Blocks.emerald_ore ? this.toolMaterial.getHarvestLevel() >= 1 : 
			(par1Block != Blocks.gold_block && par1Block != Blocks.gold_ore ? 
			(par1Block != Blocks.iron_block && par1Block != Blocks.iron_ore ? 
			(par1Block != Blocks.lapis_block && par1Block != Blocks.lapis_ore ? 
			(par1Block != Blocks.redstone_ore && par1Block != Blocks.lit_redstone_ore ? 
			(par1Block.getMaterial() == Material.rock ? true : par1Block.getMaterial() == Material.iron) : 
			this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : 
			this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2)) : 
			this.toolMaterial.getHarvestLevel() >= 1);
    }
	
    public ItemTitanStonePA(ToolMaterial toolmaterial)
    {
        super(2, toolmaterial, blocksEffectiveAgainst);
        maxStackSize = 1;
    }
    
    public float func_150893_a(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && (par2Block.getMaterial() == Material.iron || 
        		par2Block.getMaterial() == Material.rock || par2Block.getMaterial() == Material.wood) ? 
        			this.efficiencyOnProperMaterial : 1.0F;
    }
    
    public boolean func_150897_b(Block p_150897_1_)
    {
        return true;
    }
    
    public IIcon getIconFromDamage(int i)
    {
    	return this.field_94594_d;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.field_94594_d = par1IconRegister.registerIcon("ForgottenNature:PickaxeTitanStone");
    }

    public String getUnlocalizedName(ItemStack i)
    {
    	return "tspaxe";
    }
    
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer entityplayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	if (!world.isRemote)
    	{
	    	byte var8 = 0;
	    	ItemStack equipped = entityplayer.getCurrentEquippedItem();
	    	Block blk = world.getBlock(par4, par5, par6);
	    	int met;
	    	if (!entityplayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
	            return false;
	    	if(blk != Blocks.bedrock && blk != Blocks.chest && blk != Blocks.ender_chest)
	    	//4,5,6=>i,j,k
	    	{
    			if (par7 == 0)
	            {
	                for(int i = -1; i <= 1; i++)
	                {
	                	for(int j = 0; j <= 2; j++)
	                	{
	                		for(int k = -1; k <= 1; k++)
	                		{
	                			blk = world.getBlock(par4 + i, par5 + j, par6 + k);
	                			met = world.getBlockMetadata(par4 + i, par5 + j, par6 + k);
	                			
	                			if(blk != Blocks.bedrock && blk != Blocks.water && 
	                					blk != Blocks.flowing_water && blk != Blocks.lava && 
	                					blk != Blocks.flowing_lava)
	                			{
	                				world.setBlockToAir(par4 + i, par5 + j, par6 + k);
	                				blk.dropBlockAsItem(world, par4 + i, par5 + j, par6 + k, met, 0);
	                				
	                        		if(equipped.getItemDamage()+1 <= equipped.getMaxDamage())
	                        			par1ItemStack.damageItem(1, entityplayer);
	                			}
	                		}
	                	}
	                }
	            }
    			
    			else
	    		if (par7 == 1)
	            {
	                for(int i = -1; i <= 1; i++)
	                {
	                	for(int j = 0; j <= 2; j++)
	                	{
	                		for(int k = -1; k <= 1; k++)
	                		{
	                			blk = world.getBlock(par4 + i, par5 - j, par6 + k);
	                			met = world.getBlockMetadata(par4 + i, par5 - j, par6 + k);
	                			
	                			if(blk != Blocks.bedrock && blk != Blocks.water && 
	                					blk != Blocks.flowing_water && blk != Blocks.lava && 
	                					blk != Blocks.flowing_lava)
	                			{
	                				world.setBlockToAir(par4 + i, par5 - j, par6 + k);
	                				blk.dropBlockAsItem(world, par4 + i, par5 - j, par6 + k, met, 0);
	                				
	                        		if(equipped.getItemDamage()+1 <= equipped.getMaxDamage())
	                        			par1ItemStack.damageItem(1, entityplayer);
	                			}
	                		}
	                	}
	                }
	            }

	    		else
	    		if (par7 == 2)
	            {
	                for(int i = -1; i <= 1; i++)
	                {
	                	for(int j = -1; j <= 1; j++)
	                	{
	                		for(int k = 0; k <= 2; k++)
	                		{
	                			blk = world.getBlock(par4 + i, par5 + j, par6 + k);
	                			met = world.getBlockMetadata(par4 + i, par5 + j, par6 + k);
	                			
	                			if(blk != Blocks.bedrock && blk != Blocks.water && 
	                					blk != Blocks.flowing_water && blk != Blocks.lava && 
	                					blk != Blocks.flowing_lava)
	                			{
	                				world.setBlockToAir(par4 + i, par5 + j, par6 + k);
	                				blk.dropBlockAsItem(world, par4 + i, par5 + j, par6 + k, met, 0);
	                				
	                        		if(equipped.getItemDamage()+1 <= equipped.getMaxDamage())
	                        			par1ItemStack.damageItem(1, entityplayer);
	                			}
	                		}
	                	}
	                }
	            }
	    		
    			else
	    		if (par7 == 3)
	            {
	                for(int i = -1; i <= 1; i++)
	                {
	                	for(int j = -1; j <= 1; j++)
	                	{
	                		for(int k = 0; k <= 2; k++)
	                		{
	                			blk = world.getBlock(par4 + i, par5 + j, par6 - k);
	                			met = world.getBlockMetadata(par4 + i, par5 + j, par6 - k);
	                			
	                			if(blk != Blocks.bedrock && blk != Blocks.water && 
	                					blk != Blocks.flowing_water && blk != Blocks.lava && 
	                					blk != Blocks.flowing_lava)
	                			{
	                				world.setBlockToAir(par4 + i, par5 + j, par6 - k);
	                				blk.dropBlockAsItem(world, par4 + i, par5 + j, par6 - k, met, 0);
	                				
	                        		if(equipped.getItemDamage()+1 <= equipped.getMaxDamage())
	                        			par1ItemStack.damageItem(1, entityplayer);
	                			}
	                		}
	                	}
	                }
	            }
	    		
	    		else
    			if (par7 == 4)
	            {
	                for(int i = 0; i <= 2; i++)
	                {
	                	for(int j = -1; j <= 1; j++)
	                	{
	                		for(int k = -1; k <= 1; k++)
	                		{
	                			blk = world.getBlock(par4 + i, par5 + j, par6 + k);
	                			met = world.getBlockMetadata(par4 + i, par5 + j, par6 + k);
	                			
	                			if(blk != Blocks.bedrock && blk != Blocks.water && 
	                					blk != Blocks.flowing_water && blk != Blocks.lava && 
	                					blk != Blocks.flowing_lava)
	                			{
	                				world.setBlockToAir(par4 + i, par5 + j, par6 + k);
	                				blk.dropBlockAsItem(world, par4 + i, par5 + j, par6 + k, met, 0);
	                				
	                        		if(equipped.getItemDamage()+1 <= equipped.getMaxDamage())
	                        			par1ItemStack.damageItem(1, entityplayer);
	                			}
	                		}
	                	}
	                }
	            }
    			
	    		else
	    		if (par7 == 5)
	            {
	                for(int i = 0; i <= 2; i++)
	                {
	                	for(int j = -1; j <= 1; j++)
	                	{
	                		for(int k = -1; k <= 1; k++)
	                		{
	                			blk = world.getBlock(par4 - i, par5 + j, par6 + k);
	                			met = world.getBlockMetadata(par4 - i, par5 + j, par6 + k);
	                			
	                			if(blk != Blocks.bedrock && blk != Blocks.water && 
	                					blk != Blocks.flowing_water && blk != Blocks.lava && 
	                					blk != Blocks.flowing_lava)
	                			{
	                				world.setBlockToAir(par4 - i, par5 + j, par6 + k);
	                				blk.dropBlockAsItem(world, par4 - i, par5 + j, par6 + k, met, 0);
	                				
	                        		if(equipped.getItemDamage()+1 <= equipped.getMaxDamage())
	                        			par1ItemStack.damageItem(1, entityplayer);
	                			}
	                		}
	                	}
	                }
	            }
	    		return true;
	    	}    	
	    	return false;
    	}
    	return false;
    }
}