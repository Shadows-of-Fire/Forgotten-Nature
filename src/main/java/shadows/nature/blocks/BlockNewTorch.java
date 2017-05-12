package ForgottenNature.Blocks;

import static net.minecraftforge.common.util.ForgeDirection.*;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNewTorch extends BlockTorch
{
	@SideOnly(Side.CLIENT)
    private IIcon torchIcon;
	
    public BlockNewTorch()
    {
        super();
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return this.torchIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.torchIcon = par1IconRegister.registerIcon("forgottennature:CrystalTorch");
    } 
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public int getRenderType()
    {
        return 2;
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
    	
    }

    @SideOnly(Side.CLIENT)
    public String getItemNameIS(ItemStack i)
    {
	    switch(i.getItemDamage())
	    {
		    case 0:return "Crystal Torch";
		    default:return "";
	    }
    }
}
