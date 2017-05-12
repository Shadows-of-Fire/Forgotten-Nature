package ForgottenNature.Blocks;

import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWoodSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockNewHalfPlanks extends BlockWoodSlab
{
    public static final String[] woodType1 = new String[] {"brown", "purple", "dark red", "dark yellow", 
    												"peach", "orange", "brightwood","vibrant redwood"};
    public static final String[] woodType2 = new String[] {"acacia", "bright yellow", "old wood","bamboo",
													"dried bamboo","crystal","dcrystal"};
    
	@SideOnly(Side.CLIENT)
    private IIcon[] hPlankIcons;
	private int slabInd;
	
    public BlockNewHalfPlanks(boolean par2, int slabIndex)
    {
        super(par2);
        setLightOpacity(0);
        setHardness(2.0F);
        setStepSound(Block.soundTypeWood);
        slabInd = slabIndex;
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
    	return 1;
    }
    
    public boolean isOpaqueCube()
    {
    	return false;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
    	if(par2 > 7)
    		par2 = par2 - 8;
    	
    	return this.hPlankIcons[par2];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.hPlankIcons = new IIcon[8];

        if(slabInd == 0)
        {
	    	this.hPlankIcons[0] = par1IconRegister.registerIcon("ForgottenNature:PlankBrown");
			this.hPlankIcons[1] = par1IconRegister.registerIcon("ForgottenNature:PlankPurple");
			this.hPlankIcons[2] = par1IconRegister.registerIcon("ForgottenNature:PlankDarkRed");
			this.hPlankIcons[3] = par1IconRegister.registerIcon("ForgottenNature:PlankDarkYellow");
			this.hPlankIcons[4] = par1IconRegister.registerIcon("ForgottenNature:PlankPeach");
			this.hPlankIcons[5] = par1IconRegister.registerIcon("ForgottenNature:PlankOrange");
			this.hPlankIcons[6] = par1IconRegister.registerIcon("ForgottenNature:PlankBrightwood");
			this.hPlankIcons[7] = par1IconRegister.registerIcon("ForgottenNature:PlankRedwood");
        }
        else
        if(slabInd == 1)
        {
//        	this.hPlankIcons[0] = par1IconRegister.registerIcon("ForgottenNature:PlankAcacia");
    		this.hPlankIcons[1] = par1IconRegister.registerIcon("ForgottenNature:PlankBrightYellow");
    		this.hPlankIcons[2] = par1IconRegister.registerIcon("ForgottenNature:PlankOld");
    		this.hPlankIcons[3] = par1IconRegister.registerIcon("ForgottenNature:PlankBamboo");
    		this.hPlankIcons[4] = par1IconRegister.registerIcon("ForgottenNature:PlankDriedBamboo");
    		this.hPlankIcons[5] = par1IconRegister.registerIcon("ForgottenNature:LightCrystalPlank");
    		this.hPlankIcons[6] = par1IconRegister.registerIcon("ForgottenNature:DarkCrystalPlank");
        }
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
    	if(slabInd == 0)
    		return Item.getItemFromBlock(FNBlocks.newHalfPlanks1);
    	else
    		return Item.getItemFromBlock(FNBlocks.newHalfPlanks2);
    }

    protected ItemStack createStackedBlock(int met)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, met & 7);
    }

    public String func_150002_b(int par1)
    {
    	if(slabInd == 0)
    	{
	        if(par1 < 0 || par1 >= woodType1.length)
	        {
	            par1 = 0;
	        }
	
	        return super.getUnlocalizedName() + "." + woodType1[par1];
    	}
    	else
    	{
    		if(par1 < 0 || par1 >= woodType2.length)
	        {
	            par1 = 0;
	        }
	
	        return super.getUnlocalizedName() + "." + woodType2[par1];
    	}
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
    	if(slabInd == 0)
    	{
	        if (par1 != Item.getItemFromBlock(FNBlocks.newDoubleHalfPlanks1))
	        {
	            for (int j = 0; j < 8; ++j)
	            {
	                par3List.add(new ItemStack(par1, 1, j));
	            }
	        }
    	}
    	else
		if (par1 != Item.getItemFromBlock(FNBlocks.newDoubleHalfPlanks2))
        {
            for (int j = 1; j < 7; ++j)
            {
                par3List.add(new ItemStack(par1, 1, j));
            }
        }
    }
}
