package ForgottenNature.Blocks;

import java.util.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockNewPlanks extends Block
{
	@SideOnly(Side.CLIENT)
    private IIcon[] plankIcons;
	private int plankInd;
	
    public BlockNewPlanks(int plankIndex)
    {
        super(Material.wood);
        setHardness(2.0F);
        setResistance(5F);
        setStepSound(Block.soundTypeWood);
        plankInd = plankIndex;
    }
    
    public IIcon getIcon(int par1, int par2)
    {
    	return this.plankIcons[par2];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.plankIcons = new IIcon[15];

        if(plankInd == 0)
        {
	    	this.plankIcons[0] = par1IconRegister.registerIcon("ForgottenNature:PlankBrown");
	    	this.plankIcons[1] = par1IconRegister.registerIcon("ForgottenNature:PlankPurple");
			this.plankIcons[2] = par1IconRegister.registerIcon("ForgottenNature:PlankDarkRed");
			this.plankIcons[3] = par1IconRegister.registerIcon("ForgottenNature:PlankDarkYellow");
			this.plankIcons[4] = par1IconRegister.registerIcon("ForgottenNature:PlankPeach");
			this.plankIcons[5] = par1IconRegister.registerIcon("ForgottenNature:PlankOrange");
			this.plankIcons[6] = par1IconRegister.registerIcon("ForgottenNature:PlankBrightwood");
			this.plankIcons[7] = par1IconRegister.registerIcon("ForgottenNature:PlankRedwood");
			//this.plankIcons[8] = 
			this.plankIcons[9] = par1IconRegister.registerIcon("ForgottenNature:PlankBrightYellow");
			this.plankIcons[10] = par1IconRegister.registerIcon("ForgottenNature:PlankOld");
			this.plankIcons[11] = par1IconRegister.registerIcon("ForgottenNature:PlankBamboo");
			this.plankIcons[12] = par1IconRegister.registerIcon("ForgottenNature:PlankDriedBamboo");
			this.plankIcons[13] = par1IconRegister.registerIcon("ForgottenNature:PlankNetherBlaze");
			this.plankIcons[14] = par1IconRegister.registerIcon("ForgottenNature:PlankNetherAsh");
        }
        else
        if(plankInd == 1)
        {
        	this.plankIcons[0] = par1IconRegister.registerIcon("ForgottenNature:PlankHerringbone");
        	this.plankIcons[1] = par1IconRegister.registerIcon("ForgottenNature:PlankXParquet");
    		this.plankIcons[2] = par1IconRegister.registerIcon("ForgottenNature:PlankFrederiksborgParquet");
    		this.plankIcons[3] = par1IconRegister.registerIcon("ForgottenNature:PlankForDonParquet");
    		this.plankIcons[4] = par1IconRegister.registerIcon("ForgottenNature:PlankLatticeParquet");
    		this.plankIcons[5] = par1IconRegister.registerIcon("ForgottenNature:PlankSquareDiamondParquet");
    		this.plankIcons[6] = par1IconRegister.registerIcon("ForgottenNature:PlankPavimentiParquet");
        }
    }
    
    public int quantityDropped(Random random)
    {
        return 1;
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }
    
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.harvestBlock(world, entityplayer, i, j, k, l);
    }

    public int damageDropped(int i)
    {
        return i & 15;
    }
    
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	if(plankInd == 0)
    	{
	        int var6 = par1World.getBlockMetadata(par2, par3, par4);
	        float dis = 1.0F;
	        double var7 = (double)((float)par2 + dis/par1World.rand.nextInt(11));
	        double var9 = (double)((float)par3 + dis/par1World.rand.nextInt(11));
	        double var11 = (double)((float)par4 + dis/par1World.rand.nextInt(11));
	
	        if (var6 == 13)
	        {
	            par1World.spawnParticle("flame", var7, var9, var11, 0.0D, 0.0D, 0.0D);
	            par1World.spawnParticle("flame", var7, var9, var11, 0.0D, 0.0D, 0.0D);
	        }
	        else if (var6 == 14)
	        {
	            par1World.spawnParticle("smoke", var7, var9, var11, 0.0D, 0.0D, 0.0D);
	            par1World.spawnParticle("smoke", var7, var9, var11, 0.0D, 0.0D, 0.0D);
	        }
    	}
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item i, CreativeTabs p_149666_2_, List list)
    {
    	if(plankInd == 0)
    	{
	    	for(int j = 0; j < 15; j++)
	    	{
	    		if(j != 8)
	    			list.add(new ItemStack(i, 1, j));
	    	}
    	}
    	else
    	if(plankInd == 1)
    	{
    		for(int j = 0; j < 7; j++)
        	{
        		list.add(new ItemStack(i, 1, j));
        	}
    	}
    }
}