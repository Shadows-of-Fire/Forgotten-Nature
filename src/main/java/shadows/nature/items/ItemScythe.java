package ForgottenNature.Items;

import java.util.Set;

import com.google.common.collect.Sets;

import ForgottenNature.Proxy.FNBlocks;
import ForgottenNature.Proxy.FNItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemScythe extends ItemHoe
{
	@SideOnly(Side.CLIENT)
    private IIcon field_94594_d;
	    
    public ItemScythe(Item.ToolMaterial toolmaterial)
    {
    	super(toolmaterial);
    	this.setMaxDamage(toolmaterial.getMaxUses());
        maxStackSize = 1;
    }
    
    public IIcon getIconFromDamage(int i)
    {
    	return this.field_94594_d;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
    	field_94594_d = par1IconRegister.registerIcon("ForgottenNature:Scythe");
    }

    public String getUnlocalizedName(ItemStack i)
    {
    	return "scythe";
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
			if (blk == Blocks.double_plant || blk == Blocks.tallgrass || blk.isLeaves(world, par4, par5, par6) || blk == Blocks.red_flower || blk == Blocks.yellow_flower || blk == FNBlocks.fNFlowers)
            {
                for(int i = -3; i <= 3; i++)
                {
            		for(int k = -3; k <= 3; k++)
            		{
            			if((k > -3 && k < 3) || (i > -3 && i < 3))
            			{
            				blk = world.getBlock(par4 + i, par5, par6 + k);
            				met = world.getBlockMetadata(par4 + i, par5, par6 + k);
            				if(blk == Blocks.double_plant || blk == Blocks.tallgrass || blk.isLeaves(world, par4 + i, par5, par6 + k) || blk == Blocks.red_flower || blk == Blocks.yellow_flower || blk == FNBlocks.fNFlowers)
            				{
                				blk.harvestBlock(world, entityplayer, par4 + i, par5, par6 + k, met);
            					world.setBlockToAir(par4 + i, par5, par6 + k);
            					world.getBlock(par4 + i, par5 - 1, par6 + k).updateTick(world, par4 + i, par5 - 1, par6 + k, world.rand);
	                    		if(equipped.getItemDamage() + 1 <= equipped.getMaxDamage())
	                    			par1ItemStack.damageItem(1, entityplayer);
            				}
            			}
            		}
                }
                return true;
            }
    	}
    	return false;
    }
}
