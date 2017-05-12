package ForgottenNature.Blocks;

import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockNewFlowerPot extends BlockFlowerPot
{
	@SideOnly(Side.CLIENT)
    private IIcon[] flowPotIcon;
	private static int renderId;
	
    public BlockNewFlowerPot()
    {
        super();
        this.setBlockBoundsForItemRender();
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
    		return this.flowPotIcon[0];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.flowPotIcon = new IIcon[1];
        this.flowPotIcon[0] = par1IconRegister.registerIcon("ForgottenNature:FlowerPot");
    }
    
    private boolean func_149928_a(Block blk, int p_149928_2_)
    {
        return blk != Blocks.yellow_flower && blk != Blocks.red_flower && blk != Blocks.cactus && 
        		blk != Blocks.brown_mushroom && blk != Blocks.red_mushroom && blk != Blocks.sapling && 
        		blk != FNBlocks.fNFlowers && blk != FNBlocks.fNSapling1 && blk != FNBlocks.fNSapling2 && 
        		blk != FNBlocks.fNSapling3 && blk != FNBlocks.mushroomCrystal && blk != FNBlocks.crystalStone &&
        		blk != FNBlocks.mushroomCrystal &&
        		blk != Blocks.deadbush ? blk == Blocks.tallgrass && p_149928_2_ == 2 : true;
    }
    
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();

        if (itemstack != null && itemstack.getItem() instanceof ItemBlock)
        {
            TileEntityFlowerPot tileentityflowerpot = this.func_149929_e(world, i, j, k);

            if (tileentityflowerpot != null)
            {
                if (tileentityflowerpot.getFlowerPotItem() != null)
                {
                    return false;
                }
                else
                {
                    Block block = Block.getBlockFromItem(itemstack.getItem());

                    if (!this.func_149928_a(block, itemstack.getItemDamage()))
                    {
                        return false;
                    }
                    else
                    {
                        tileentityflowerpot.func_145964_a(itemstack.getItem(), itemstack.getItemDamage());
                        tileentityflowerpot.markDirty();

                        if (!world.setBlockMetadataWithNotify(i, j, k, itemstack.getItemDamage(), 2))
                        {
                        	world.markBlockForUpdate(i, j, k);
                        }

                        if (!entityplayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                        {
                        	entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, (ItemStack)null);
                        }

                        return true;
                    }
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        TileEntityFlowerPot tileentityflowerpot = this.func_149929_e(p_149694_1_, p_149694_2_, p_149694_3_, p_149694_4_);
        return tileentityflowerpot != null && tileentityflowerpot.getFlowerPotItem() != null ? tileentityflowerpot.getFlowerPotItem() : Item.getItemFromBlock(FNBlocks.flowerPot);
    }
    
    public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_)
    {
        TileEntityFlowerPot tileentityflowerpot = this.func_149929_e(p_149643_1_, p_149643_2_, p_149643_3_, p_149643_4_);
        return tileentityflowerpot != null && tileentityflowerpot.getFlowerPotItem() != null ? tileentityflowerpot.getFlowerPotData() : 0;
    }
    
    public void onBlockHarvested(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_)
    {
        super.onBlockHarvested(p_149681_1_, p_149681_2_, p_149681_3_, p_149681_4_, p_149681_5_, p_149681_6_);

        if (p_149681_6_.capabilities.isCreativeMode)
        {
            TileEntityFlowerPot tileentityflowerpot = this.func_149929_e(p_149681_1_, p_149681_2_, p_149681_3_, p_149681_4_);

            if (tileentityflowerpot != null)
            {
                tileentityflowerpot.func_145964_a(Item.getItemById(0), 0);
            }
        }
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }
    
    private TileEntityFlowerPot func_149929_e(World world, int i, int j, int k)
    {
        TileEntity tileentity = world.getTileEntity(i, j, k);
        return tileentity != null && tileentity instanceof TileEntityFlowerPot ? (TileEntityFlowerPot)tileentity : null;
    }
    
    public TileEntity createNewTileEntity(World world, int p_149915_2_)
    {
    	Block sap1 = FNBlocks.fNSapling1;
    	Block sap2 = FNBlocks.fNSapling2;
    	Block sap3 = FNBlocks.fNSapling3;
    	Block flowers = FNBlocks.fNFlowers;
        Object object = null;
        byte b0 = 0;

        switch (p_149915_2_)
        {
            case 1:
                object = Blocks.red_flower;
                b0 = 0;
                break;
            case 2:
                object = Blocks.yellow_flower;
                break;
            case 3:
                object = Blocks.sapling;
                b0 = 0;
                break;
            case 4:
                object = Blocks.sapling;
                b0 = 1;
                break;
            case 5:
                object = Blocks.sapling;
                b0 = 2;
                break;
            case 6:
                object = Blocks.sapling;
                b0 = 3;
                break;
            case 7:
                object = Blocks.red_mushroom;
                break;
            case 8:
                object = Blocks.brown_mushroom;
                break;
            case 9:
                object = Blocks.cactus;
                break;
            case 10:
                object = Blocks.deadbush;
                break;
            case 11:
                object = Blocks.tallgrass;
                b0 = 2;
                break;
            case 12:
                object = Blocks.sapling;
                b0 = 4;
                break;
            case 13:
                object = Blocks.sapling;
                b0 = 5;
                break;
            case 14:///////////////////
                object = sap1;
                b0 = 0;
                break;
            case 15:
                object = sap1;
                b0 = 1;
                break;
            case 16:
                object = sap1;
                b0 = 2;
                break;
            case 17:
                object = sap1;
                b0 = 3;
                break;
            case 18:
                object = sap1;
                b0 = 4;
                break;
            case 19:
                object = sap1;
                b0 = 5;
                break;
            case 20:
                object = sap1;
                b0 = 6;
                break;
            case 21:
                object = sap1;
                b0 = 7;
                break;
            case 22:
                object = sap1;
                b0 = 8;
                break;
            case 23:
                object = sap1;
                b0 = 9;
                break;
            case 24:
                object = sap1;
                b0 = 10;
                break;
            case 25:
                object = sap1;
                b0 = 11;
                break;
            case 26:
                object = sap1;
                b0 = 12;
                break;
            case 27:
                object = sap1;
                b0 = 13;
                break;
            case 28:
                object = sap1;
                b0 = 14;
                break;
            case 29:
                object = sap1;
                b0 = 15;
                break;
            case 30:
                object = sap2;
                b0 = 0;
                break;
            case 31:
                object = sap2;
                b0 = 1;
                break;
            case 32:
                object = sap2;
                b0 = 2;
                break;
            case 33:
                object = sap2;
                b0 = 3;
                break;
            case 34:
                object = sap2;
                b0 = 4;
                break;
            case 35:
                object = sap2;
                b0 = 5;
                break;
            case 36:
                object = sap2;
                b0 = 6;
                break;
            case 37:
                object = sap2;
                b0 = 7;
                break;
            case 38:
                object = sap2;
                b0 = 8;
                break;
            case 39:
                object = sap2;
                b0 = 9;
                break;
            case 40:
                object = sap2;
                b0 = 10;
                break;
            case 41:
                object = sap2;
                b0 = 11;
                break;
            case 42:
                object = sap2;
                b0 = 12;
                break;
            case 43:
                object = sap2;
                b0 = 13;
                break;
            case 44:
                object = sap2;
                b0 = 14;
                break;
            case 45:
                object = sap2;
                b0 = 15;
                break;
            case 46:
                object = sap3;
                b0 = 0;
                break;
            case 47:
                object = sap3;
                b0 = 1;
                break;
            case 48:
                object = sap3;
                b0 = 2;
                break;
            case 49:
                object = sap3;
                b0 = 3;
                break;
            case 50:
                object = sap3;
                b0 = 4;
                break;
            case 51:
                object = sap3;
                b0 = 5;
            case 52:
                object = FNBlocks.crystalStone;
                b0 = 0;
                break;
            case 53:
                object = FNBlocks.crystalStone;
                b0 = 1;
                break;
            case 54:
                object = FNBlocks.mushroomCrystal;
                b0 = 0;
                break;
            case 55:
                object = flowers;
                b0 = 0;
                break;
            case 56:
                object = flowers;
                b0 = 1;
                break;
            case 57:
                object = flowers;
                b0 = 2;
                break;
            case 58:
                object = flowers;
                b0 = 3;
                break;
            case 59:
                object = flowers;
                b0 = 4;
                break;
            case 60:
                object = flowers;
                b0 = 5;
            case 61:
                object = flowers;
                b0 = 6;
                break;
            case 62:
                object = flowers;
                b0 = 7;
                break;
            case 63:
                object = flowers;
                b0 = 8;
                break;
            case 64:
                object = flowers;
                b0 = 9;
        }

        return new TileEntityFlowerPot(Item.getItemFromBlock((Block)object), b0);
    }
}
