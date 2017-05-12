package ForgottenNature.Blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class FNBlockGlass extends BlockBreakable
{
	@SideOnly(Side.CLIENT)
    private IIcon[] glassIcons;
	
    public FNBlockGlass(Material par3Material, boolean par4)
    {
        super("glass", par3Material, par4);
        setHardness(0.3F);
        setStepSound(Block.soundTypeGlass);
        setBlockName("nGlass");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return this.glassIcons[par2];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.glassIcons = new IIcon[16];

    	this.glassIcons[0] = par1IconRegister.registerIcon("ForgottenNature:GlassBlackLattice");
		this.glassIcons[1] = par1IconRegister.registerIcon("ForgottenNature:GlassWide3x3");
		this.glassIcons[2] = par1IconRegister.registerIcon("ForgottenNature:GlassFramedWide3x3");
		this.glassIcons[3] = par1IconRegister.registerIcon("ForgottenNature:Glass3x3");
		this.glassIcons[4] = par1IconRegister.registerIcon("ForgottenNature:GlassFramed3x3");
		this.glassIcons[5] = par1IconRegister.registerIcon("ForgottenNature:GlassDoubleDiamond");
		this.glassIcons[6] = par1IconRegister.registerIcon("ForgottenNature:GlassPinwheel");
		this.glassIcons[7] = par1IconRegister.registerIcon("ForgottenNature:Glass2x2");
		this.glassIcons[8] = par1IconRegister.registerIcon("ForgottenNature:GlassFramed2x2");
		this.glassIcons[9] = par1IconRegister.registerIcon("ForgottenNature:GlassDiamondLattice");
		this.glassIcons[10] = par1IconRegister.registerIcon("ForgottenNature:GlassDoubleLattice");
		this.glassIcons[11] = par1IconRegister.registerIcon("ForgottenNature:GlassSquareLattice");
		this.glassIcons[12] = par1IconRegister.registerIcon("ForgottenNature:GlassPeaking");
		this.glassIcons[13] = par1IconRegister.registerIcon("ForgottenNature:GlassCircle");
		this.glassIcons[14] = par1IconRegister.registerIcon("ForgottenNature:GlassDoubleDoor");
		this.glassIcons[15] = par1IconRegister.registerIcon("ForgottenNature:Glass2x1");
    }
    
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item i, CreativeTabs tabs, List list)
    {
    	for(int j = 0; j < 16; j++)
    	{
    		list.add(new ItemStack(i, 1, j));
    	}
    }
}
