package ForgottenNature.Blocks;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import ForgottenNature.ForgottenNature;

public class BlockNewFence extends BlockFence
{
	@SideOnly(Side.CLIENT)
    private IIcon[] fenceIcons;
	private static int renderId;
    
    public BlockNewFence(String par2Str, Material par3Material)
    {
        super(par2Str, par3Material);
        setHardness(2.0F);
        setResistance(5.0F);
        setStepSound(Block.soundTypeWood);
        setBlockName("nFence");
    }
    
    public static void setRenderId(int renderIdReceived) 
    {
        renderId = renderIdReceived;
    }
    
    @Override
	public int getRenderType() 
    {
    	return renderId;
	}
    
    public int quantityDropped(Random random)
    {
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
    		return this.fenceIcons[par2];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.fenceIcons = new IIcon[15];

    	this.fenceIcons[0] = par1IconRegister.registerIcon("forgottennature:PlankBrown");
    	this.fenceIcons[1] = par1IconRegister.registerIcon("forgottennature:PlankPurple");
    	this.fenceIcons[2] = par1IconRegister.registerIcon("forgottennature:PlankDarkRed");
    	this.fenceIcons[3] = par1IconRegister.registerIcon("forgottennature:PlankDarkYellow");
    	this.fenceIcons[4] = par1IconRegister.registerIcon("forgottennature:PlankPeach");
    	this.fenceIcons[5] = par1IconRegister.registerIcon("forgottennature:PlankOrange");
    	this.fenceIcons[6] = par1IconRegister.registerIcon("forgottennature:PlankBrightwood");
    	this.fenceIcons[7] = par1IconRegister.registerIcon("forgottennature:PlankRedwood");
    	this.fenceIcons[8] = par1IconRegister.registerIcon("forgottennature:PlankAcacia");
    	this.fenceIcons[9] = par1IconRegister.registerIcon("forgottennature:PlankBrightYellow");
    	this.fenceIcons[10] = par1IconRegister.registerIcon("forgottennature:PlankOld");
    	this.fenceIcons[11] = par1IconRegister.registerIcon("forgottennature:PlankBamboo");	
    	this.fenceIcons[12] = par1IconRegister.registerIcon("forgottennature:PlankDriedBamboo");	
    	this.fenceIcons[13] = par1IconRegister.registerIcon("forgottennature:LightCrystalPlank");
    	this.fenceIcons[14] = par1IconRegister.registerIcon("forgottennature:DarkCrystalPlank");
    }

    public boolean canConnectFenceTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        Block l = par1IBlockAccess.getBlock(par2, par3, par4);

        if (l != this && l != Blocks.fence_gate)
        {
            return l != null && l.getMaterial().isOpaque() && l.renderAsNormalBlock() ? l.getMaterial() != Material.gourd : false;
        }
        else
        {
            return true;
        }
    }
    
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return true;
    }
    
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.harvestBlock(world, entityplayer, i, j, k, l);
        l = l & 15;
        if (l == 0)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 0));    //brown
        }

        if (l == 1)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 1));    //purple
        }

        if (l == 2)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 2));    //dark red
        }

        if (l == 3)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 3));    //dark yellow
        }

        if (l == 4)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 4));    //peach
        }

        if (l == 5)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 5));    //orange
        }

        if (l == 6)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 6));    //brightwood
        }

        if (l == 7)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 7));    //vibrantRedwood
        }
        
        if (l == 8)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 8));    //acacia
        }
        
        if (l == 9)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 9));    //brightYellow
        }
        
        if (l == 10)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 10));    //oldWood
        }
        
        if (l == 11)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 11));    //bamboo
        }
        
        if (l == 12)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 12));    //dried bamboo
        }
        
        if (l == 13)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 13));    //crystal
        }
        
        if (l == 14)
        {
            dropBlockAsItem(world, i, j, k, new ItemStack(this, 1, 14));    //dcrystal
        }
    }
    
    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1)
    {
        super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
       
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item i, CreativeTabs tabs, List list)
    {
    	for(int j = 0; j < 15; j++)
    	{
    		list.add(new ItemStack(i, 1, j));
    	}
    }
}
