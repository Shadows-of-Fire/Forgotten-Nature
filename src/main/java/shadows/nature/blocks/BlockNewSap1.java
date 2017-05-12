package ForgottenNature.Blocks;

import java.util.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;
import ForgottenNature.WorldGen.*;

public class BlockNewSap1 extends BlockFlower
{
	@SideOnly(Side.CLIENT)
	static IIcon[] saplingIcons;
	private static int ID = Block.getIdFromBlock(FNBlocks.fNSapling1);
	
    public BlockNewSap1()
    {
        super(ID);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        setBlockName("FNSapling1");
    }
    
    public String getUnlocalizedName(ItemStack p1)
    {
        return super.getUnlocalizedName() + "." + p1.getItemDamage();
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
            return this.saplingIcons[par2];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.saplingIcons = new IIcon[16];

        this.saplingIcons[0] = par1IconRegister.registerIcon("ForgottenNature:SaplingDesertIronwood");
        this.saplingIcons[1] = par1IconRegister.registerIcon("ForgottenNature:SaplingCherry");
        this.saplingIcons[2] = par1IconRegister.registerIcon("ForgottenNature:SaplingRedMaple");
        this.saplingIcons[3] = par1IconRegister.registerIcon("ForgottenNature:SaplingAngel");
        this.saplingIcons[4] = par1IconRegister.registerIcon("ForgottenNature:SaplingYellowMaple");
        this.saplingIcons[5] = par1IconRegister.registerIcon("ForgottenNature:SaplingJacaranda");
        this.saplingIcons[6] = par1IconRegister.registerIcon("ForgottenNature:SaplingApple");
        this.saplingIcons[7] = par1IconRegister.registerIcon("ForgottenNature:SaplingEucalyptus");
        this.saplingIcons[8] = par1IconRegister.registerIcon("ForgottenNature:SaplingSequoia");
        this.saplingIcons[9] = par1IconRegister.registerIcon("ForgottenNature:SaplingFig");
        this.saplingIcons[10] = par1IconRegister.registerIcon("ForgottenNature:SaplingCypress");
//        this.saplingIcons[10] = 
        this.saplingIcons[12] = par1IconRegister.registerIcon("ForgottenNature:SaplingJoshua");
        this.saplingIcons[13] = par1IconRegister.registerIcon("ForgottenNature:SaplingSwampWillow");
        this.saplingIcons[14] = par1IconRegister.registerIcon("ForgottenNature:SaplingDeciduousBush");
        this.saplingIcons[15] = par1IconRegister.registerIcon("ForgottenNature:SaplingEvergreenBush");
    }
    
    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if (world.isRemote)
        {
            return;
        }
        super.updateTick(world, i, j, k, random);
        if (world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(14) == 0)
        {
            growTree(world, i, j, k, random);
        }
    }

    public void growTree(World world, int i, int j, int k, Random random)
    {
        int l = world.getBlockMetadata(i, j, k) & 15;
        world.setBlockToAir(i, j, k);
        Object obj = null;
        if (l == 1)
        {
            obj = new genCherry(FNBlocks.newLeaves2, 1, FNBlocks.newLogs1, 0);    //cherry
        }
        else if (l == 2)
        {
            obj = new genCherry(FNBlocks.newLeaves1, 0, Block.getBlockById(17), 0);    //red maple
        }
        else if (l == 3)
        {
            obj = new genAngel(FNBlocks.newLeaves1, 1);    //angel oak
        }
        else if (l == 4)
        {
            obj = new genCherry(FNBlocks.newLeaves1, 2, Block.getBlockById(17), 0);    //yellow maple
        }
        else if (l == 5)
        {
            obj = new genCherry(FNBlocks.newLeaves1, 3, Block.getBlockById(17), 0);    //jacaranda
        }
        else if (l == 6)
        {
            obj = new genFruit(true, FNBlocks.newLeaves2, 3, Block.getBlockById(17), 0, 1);    //apple
        }
        else if (l == 7)
        {
            obj = new genEucalyptus(FNBlocks.newLeaves1, 7, FNBlocks.newLogs1, 4);    //eucalyptus\
        }
        else if (l == 8)
        {
            obj = new genSequoia(FNBlocks.newLeaves2, 0, FNBlocks.newLogs1, 6);    //sequoia
        }
        else if (l == 9)
        {
            int size = 2 + random.nextInt(6);
            obj = new genFig(FNBlocks.newLeaves1, 4, 0, size); //Fig
        }
        else if (l == 10)
        {
            obj = new genCypress(FNBlocks.newLeaves1, 5, Block.getBlockById(17), 1);    //Cypress
        }
        else if (l == 12)
        {
            obj = new genJoshua(FNBlocks.newLeaves2, 7, FNBlocks.newLogs1, 10);    //Joshua
        }
        else if (l == 13)
        {
            int size = 2 + random.nextInt(6);
            obj = new genWillow(FNBlocks.newLeaves3, 0, FNBlocks.newLogs1, 12, size); //willow
        }
        else if (l == 14)
        {
            obj = new genDecBush(FNBlocks.newLeaves3, 1, 0);    //decBush
        }
        else if (l == 15)
        {
            obj = new genEverBush(FNBlocks.newLeaves3, 2, 1);    //everBush
        }
        else
        {
            obj = new genDesertTree(FNBlocks.newLeaves1, 6, FNBlocks.newLogs1, 2);    //Desert tree
        }

        if (!((WorldGenerator)(obj)).generate(world, random, i, j, k))
        {
            world.setBlock(i, j, k, this, l, 3);
        }
    }
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par2, float par3, float par4, float par5)
    {
        ItemStack equipped = entityplayer.getCurrentEquippedItem();
        if (equipped == null)
        {
            return false;
        }
        if ((equipped.getItem() == Items.dye) && (equipped.getItemDamage() == 15))  //if bone meal
        {
            growTree(world, i, j, k, world.rand);
            if(!entityplayer.capabilities.isCreativeMode)
            	equipped.stackSize -= 1;
        }
        return false;
    }
    public int damageDropped(int i)
    {
        return i & 15;
    }
    
    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) 
    {
        return Item.getItemFromBlock(this);
    }
}
