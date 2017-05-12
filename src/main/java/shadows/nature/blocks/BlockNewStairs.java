package ForgottenNature.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import ForgottenNature.Proxy.FNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockNewStairs extends BlockStairs
{
    private static final int[][] field = new int[][] {{2, 6}, {3, 7}, {2, 3}, {6, 7}, {0, 4}, {1, 5}, {0, 1}, {4, 5}};
    private boolean bool1;
    private int i2;
    private static final String __OBFID = "CL_00000314";
    private Block block;

    public BlockNewStairs(Block block1, int i1)
    {
        super(block1, i1);
        this.setHardness(2.0F);
        this.setResistance(5F / 3.0F);
        this.setStepSound(block1.stepSound);
        this.setLightOpacity(255);
        block = block1;
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
    	if(block == FNBlocks.crystalWood || block == FNBlocks.crystalBlock)
    		return 1;
    	else
    		return 0;
    }
    
    public boolean isOpaqueCube()
    {
    	return false;
    }
}