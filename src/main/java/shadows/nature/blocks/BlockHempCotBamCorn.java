package ForgottenNature.Blocks;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.*;
import java.util.Random;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;
import ForgottenNature.Proxy.FNItems;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHempCotBamCorn extends BlockFlower
{
	@SideOnly(Side.CLIENT)
    private IIcon[] cropIcons;
	
	private Item seed;
	private Item food;
	private static int ID = Block.getIdFromBlock(FNBlocks.hempCotBamCorn);
	
    public BlockHempCotBamCorn()
    {
        super(ID);
        this.seed = FNItems.newSeedItems;
        this.food = FNItems.FNFoodItems;
        this.setTickRandomly(true);
        this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.5F, 0.9F);
        setBlockName("newCrops4");
        setStepSound(Block.soundTypeGrass);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
    		return this.cropIcons[par2];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.cropIcons = new IIcon[16];

        for (int i = 0; i < 16; ++i)
        {
            this.cropIcons[0] = par1IconRegister.registerIcon("ForgottenNature:Corn_0");
        	this.cropIcons[1] = par1IconRegister.registerIcon("ForgottenNature:Corn_1");
        	this.cropIcons[2] = par1IconRegister.registerIcon("ForgottenNature:Corn_2");
        	this.cropIcons[3] = par1IconRegister.registerIcon("ForgottenNature:Corn_3");
        	this.cropIcons[4] = par1IconRegister.registerIcon("ForgottenNature:Cotton_0");
        	this.cropIcons[5] = par1IconRegister.registerIcon("ForgottenNature:Cotton_1");
        	this.cropIcons[6] = par1IconRegister.registerIcon("ForgottenNature:Cotton_2");
        	this.cropIcons[7] = par1IconRegister.registerIcon("ForgottenNature:Cotton_3");
        	this.cropIcons[8] = par1IconRegister.registerIcon("ForgottenNature:Bamboo_0");
        	this.cropIcons[9] = par1IconRegister.registerIcon("ForgottenNature:Bamboo_1");
        	this.cropIcons[10] = par1IconRegister.registerIcon("ForgottenNature:Bamboo_2");
        	this.cropIcons[11] = par1IconRegister.registerIcon("ForgottenNature:Bamboo_3");
        	this.cropIcons[12] = par1IconRegister.registerIcon("ForgottenNature:Hemp_0");
        	this.cropIcons[13] = par1IconRegister.registerIcon("ForgottenNature:Hemp_1");
        	this.cropIcons[14] = par1IconRegister.registerIcon("ForgottenNature:Hemp_2");
        	this.cropIcons[15] = par1IconRegister.registerIcon("ForgottenNature:Hemp_3");
        }
    }
    
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
    {
        Block plant = plantable.getPlant(world, x, y + 1, z);
        Block soil = world.getBlock(x, y + 1, z);

        if (plant == this || soil == Blocks.netherrack)
        {
            return true;
        }

        return false;
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);

            if((var6 == 0 || var6 == 4 || var6 == 12) && par1World.getBlock(par2, par3 - 1, par4) == this)
            {
            	par1World.setBlock(par2, par3, par4, Blocks.air, 0, 3);
            }
            
            if(var6 > 8 && var6 < 12 && (par1World.getBlockMetadata(par2, par3 - 1, par4) < var6 || par1World.getBlockMetadata(par2, par3 - 1, par4) > 11) && par1World.getBlock(par2, par3 - 1, par4) == this)
            {
            	par1World.setBlock(par2, par3, par4, Blocks.air, 0, 3);
            }
            
            if(par1World.getBlock(par2, par3 - 9, par4) != this)
            {
            	if(var6 == 11 && ForgottenNature.bambooSpread)
            	{
            		for(int spreadx = -1; spreadx < 2; spreadx++)
            		{
            			for(int spreadz = -1; spreadz < 2; spreadz++)
            			{
            				if(par5Random.nextInt(ForgottenNature.bamSpreadBuffer) == 0 && (par1World.getBlock(par2 + spreadx, par3 - 2, par4 + spreadz) == Blocks.dirt || par1World.getBlock(par2 + spreadx, par3 - 2, par4 + spreadz) == Blocks.grass) && par1World.getBlock(par2 + spreadx, par3 - 1, par4 + spreadz) == Blocks.air)
            				{
            					par1World.setBlock(par2 + spreadx, par3 - 1, par4 + spreadz, this, 8, 3);
            				}
            			}
            		}
            	}
	            if((var6 > 8 && var6 < 12) && par1World.getBlock(par2, par3 + 1, par4) == Blocks.air)
	            {
	            	par1World.setBlock(par2, par3 + 1, par4, this, 8, 3);
	            }
            }
            
            if(var6 == 1 && par5Random.nextInt(10) == 0 && par1World.getBlock(par2, par3 + 1, par4) == Blocks.air)
            {
            	par1World.setBlock(par2, par3 + 1, par4, this, 2, 3);
            }
            
            Block underblock = par1World.getBlock(par2, par3 - 1, par4);
            int undermet = par1World.getBlockMetadata(par2, par3 - 1, par4);
            if((ForgottenNature.bambooGeneration && var6 > 7 && var6 < 11 && par5Random.nextInt(2) == 0) && (underblock == Blocks.dirt || underblock == Blocks.grass || (underblock == this && (undermet == var6 + 2 || undermet == 11))))
            {
            	par1World.setBlock(par2, par3, par4, this, var6 + 1, 3);
            }
            
            if (var6 == 0 || var6 == 2 || (var6 > 3 && var6 < 7) || (var6 > 11 && var6 <15))
            {
                float var7 = this.getGrowthRate(par1World, par2, par3, par4);

                if (par5Random.nextInt((int)(25.0F / var7) + 1) == 0)
                {
                    ++var6;
                    par1World.setBlock(par2, par3, par4, this, var6, 3);
                }
            }
        }
    }
    
    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
    {
        this.func_150170_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
    }

    protected final boolean func_150170_e(World p_150170_1_, int p_150170_2_, int p_150170_3_, int p_150170_4_)
    {
        if (!this.canBlockStay(p_150170_1_, p_150170_2_, p_150170_3_, p_150170_4_))
        {
            this.dropBlockAsItemWithChance(p_150170_1_, p_150170_2_, p_150170_3_, p_150170_4_, p_150170_1_.getBlockMetadata(p_150170_2_, p_150170_3_, p_150170_4_), 1.0F, 0);
            p_150170_1_.setBlockToAir(p_150170_2_, p_150170_3_, p_150170_4_);
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par2, float par3, float par4, float par5)
    {
    	int full;
        ItemStack equipped = entityplayer.getCurrentEquippedItem();
        if (equipped == null)
            return false;
        if ((equipped.getItem() == Items.dye) && (equipped.getItemDamage() == 15))  //if bone meal
        {
        	full = 0;
        	int met = world.getBlockMetadata(i, j, k);
        	if (met == 0 || met == 1)
        	{
        		full = 1;
        	}
        	else if (met == 2)
        	{
        		full = 3;
        	}
        	else if (met > 3 && met < 7)
        	{
        		full = 7;
        	}
        	else if (met > 7 && met < 11)
        	{
        		full = 11;
        	}
        	else if(met > 11)
        	{
        		full = 15;
        	}
        	else
        		return false;
        	world.setBlockMetadataWithNotify(i, j, k, full, 3);
        	if(full == 1 && world.getBlockMetadata(i, j + 1, k) == 0)
        		world.setBlock(i, j + 1, k, this, 3, 3);
            equipped.stackSize -= 1;
        }
        return false;
    }

    /**
     * Gets the growth rate for the crop. Setup to encourage rows by halving growth rate if there is diagonals, crops on
     * different sides that aren't opposing, and by adding growth for every crop next to this one (and for crop below
     * this one). Args: x, y, z
     */
    private float getGrowthRate(World par1World, int par2, int par3, int par4)
    {
        float var5 = 1.0F;
        Block var6 = par1World.getBlock(par2, par3, par4 - 1);
        Block var7 = par1World.getBlock(par2, par3, par4 + 1);
        Block var8 = par1World.getBlock(par2 - 1, par3, par4);
        Block var9 = par1World.getBlock(par2 + 1, par3, par4);
        Block var10 = par1World.getBlock(par2 - 1, par3, par4 - 1);
        Block var11 = par1World.getBlock(par2 + 1, par3, par4 - 1);
        Block var12 = par1World.getBlock(par2 + 1, par3, par4 + 1);
        Block var13 = par1World.getBlock(par2 - 1, par3, par4 + 1);
        boolean var14 = var8 == this || var9 == this;
        boolean var15 = var6 == this || var7 == this;
        boolean var16 = var10 == this || var11 == this || var12 == this || var13 == this;

        for (int var17 = par2 - 1; var17 <= par2 + 1; ++var17)
        {
            for (int var18 = par4 - 1; var18 <= par4 + 1; ++var18)
            {
            	Block var19 = par1World.getBlock(var17, par3 - 1, var18);
                float var20 = 0.0F;

                if (var19 == Blocks.farmland)
                {
                    var20 = 1.0F;

                    if (par1World.getBlockMetadata(var17, par3 - 1, var18) > 0)
                    {
                        var20 = 2.0F;
                    }
                }

                if (var17 != par2 || var18 != par4)
                {
                    var20 /= 3.0F;
                }

                var5 += var20;
            }
        }

        if (var16 || var14 && var15)
        {
            var5 /= 2.0F;
        }

        return var5;
    }

    public int getRenderType()
    {
        return 1;
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int met, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(world, i, j, k, met, par6, par7);
        met = met & 15;
        if (met == 3)
        {
        	dropBlockAsItem(world, i, j, k, new ItemStack(food,1,3));//corn
        }
        else if (met == 7)
        {
        	dropBlockAsItem(world, i, j, k, new ItemStack(FNItems.FNGoodsItem,1,0));//cotton
        }
        else if (met == 11)
        {
        	dropBlockAsItem(world, i, j, k, new ItemStack(Item.getItemFromBlock(FNBlocks.hempCotBamCorn),1,11));//bamboo
        }
        else if (met == 15)
        {
        	dropBlockAsItem(world, i, j, k, new ItemStack(FNItems.FNGoodsItem,1,1));//hemp
        }
        
        for (int n = 0; n < 5; n++)
        {
            if ((met == 3) && (world.rand.nextInt(3) == 0))
            {
            	dropBlockAsItem(world, i, j, k, new ItemStack(seed,1,1));
            }
            else if ((met == 7) && (world.rand.nextInt(3) == 0))
            {
            	dropBlockAsItem(world, i, j, k, new ItemStack(seed,1,2));
            }
            else if ((met == 15) && (world.rand.nextInt(3) == 0))
            {
            	dropBlockAsItem(world, i, j, k, new ItemStack(seed,1,8));
            }
        }
    }

    public int quantityDropped(Random par1Random)
    {
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item i, CreativeTabs tabs, List list)
    {
    	list.add(new ItemStack(this, 1, 11));
    }
}