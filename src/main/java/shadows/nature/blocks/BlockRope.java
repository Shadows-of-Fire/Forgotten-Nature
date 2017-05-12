package ForgottenNature.Blocks;

import java.util.*;

import ForgottenNature.Proxy.FNItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import static net.minecraftforge.common.util.ForgeDirection.*;

public class BlockRope extends Block
{
	@SideOnly(Side.CLIENT)
    private IIcon ropeIcon;
	
    public BlockRope()
    {
        super(Material.circuits);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int par1, int par2)
    {
        return this.ropeIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.ropeIcon = par1IconRegister.registerIcon("forgottennature:Rope");
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        int var5 = par1World.getBlockMetadata(par2, par3, par4);
        float var6 = 0.125F;

        if (var5 == 1)
        {
            this.setBlockBounds(0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 4)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var6);
        }

        if (var5 == 8)
        {
            this.setBlockBounds(1.0F - var6, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 2)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, var6, 1.0F, 1.0F);
        }

        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        int var5 = par1World.getBlockMetadata(par2, par3, par4);
        float var6 = 0.125F;

        if (var5 == 1)
        {
            this.setBlockBounds(0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 4)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var6);
        }

        if (var5 == 8)
        {
            this.setBlockBounds(1.0F - var6, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 2)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, var6, 1.0F, 1.0F);
        }

        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
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
        return 20;
    }
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.isSideSolid(par2 - 1, par3, par4, EAST) ||
               par1World.isSideSolid(par2 + 1, par3, par4, WEST) ||
               par1World.isSideSolid(par2, par3, par4 - 1, SOUTH) ||
               par1World.isSideSolid(par2, par3, par4 + 1, NORTH);
    }
    public void onBlockPlaced(World par1World, int par2, int par3, int par4, int par5)
    {
        int var6 = par1World.getBlockMetadata(par2, par3, par4);

        if ((var6 == 0 || par5 == 1) && par1World.isSideSolid(par2, par3, par4 + 1, NORTH))
        {
            var6 = 1;
        }

        if ((var6 == 0 || par5 == 4) && par1World.isSideSolid(par2, par3, par4 - 1, SOUTH))
        {
            var6 = 4;
        }

        if ((var6 == 0 || par5 == 8) && par1World.isSideSolid(par2 + 1, par3, par4, WEST))
        {
            var6 = 8;
        }

        if ((var6 == 0 || par5 == 2) && par1World.isSideSolid(par2 - 1, par3, par4, EAST))
        {
            var6 = 2;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, var6, 4);
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5)
    {
        int var6 = par1World.getBlockMetadata(par2, par3, par4);
        boolean var7 = false;

        if (var6 == 1 && par1World.isSideSolid(par2, par3, par4 + 1, NORTH))
        {
            var7 = true;
        }

        if (var6 == 4 && par1World.isSideSolid(par2, par3, par4 - 1, SOUTH))
        {
            var7 = true;
        }

        if (var6 == 8 && par1World.isSideSolid(par2 + 1, par3, par4, WEST))
        {
            var7 = true;
        }

        if (var6 == 2 && par1World.isSideSolid(par2 - 1, par3, par4, EAST))
        {
            var7 = true;
        }

        if (!var7 && par1World.getBlock(par2, par3 + 1, par4) != this)
        {
            par1World.setBlockToAir(par2, par3, par4);
        }

        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
    }
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.harvestBlock(world, entityplayer, i, j, k, l);
        if(world.getBlock(i, j + 1, k) != this)
        {
        	dropBlockAsItem(world, i, j + 1, k, new ItemStack(FNItems.ropeItem));
        }
    	for(int next = j; next > 0; next--)
    	{
    		if(world.getBlock(i, next, k) == this)
    			world.setBlockToAir(i, next, k);
    	}
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }
    
    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
    {
        return true;
    }
}
