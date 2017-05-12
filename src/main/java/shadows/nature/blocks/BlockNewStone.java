package ForgottenNature.Blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;
import ForgottenNature.Proxy.FNItems;

public class BlockNewStone extends Block
{
	@SideOnly(Side.CLIENT)
    private IIcon[] stoneIcons;
	
    public BlockNewStone()
    {
        super(Material.rock);
        setHardness(1.5F);
        setResistance(10.0F);
        setStepSound(Block.soundTypeStone);
        setBlockName("FNStone");
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return this.stoneIcons[par2];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.stoneIcons = new IIcon[10];

    	this.stoneIcons[0] = par1IconRegister.registerIcon("ForgottenNature:StoneChert");
		this.stoneIcons[1] = par1IconRegister.registerIcon("ForgottenNature:StoneGranite");
		this.stoneIcons[2] = par1IconRegister.registerIcon("ForgottenNature:StoneGneiss");
		this.stoneIcons[3] = par1IconRegister.registerIcon("ForgottenNature:StoneHornfels");
		this.stoneIcons[4] = par1IconRegister.registerIcon("ForgottenNature:StoneMarble");
		this.stoneIcons[5] = par1IconRegister.registerIcon("ForgottenNature:BricksGranite");
		this.stoneIcons[6] = par1IconRegister.registerIcon("ForgottenNature:BricksGneiss");
		this.stoneIcons[7] = par1IconRegister.registerIcon("ForgottenNature:BricksHornfels");
		this.stoneIcons[8] = par1IconRegister.registerIcon("ForgottenNature:BricksMarble");
		this.stoneIcons[9] = par1IconRegister.registerIcon("ForgottenNature:TitanStoneBlock");
    }
    
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    
    public int damageDropped(int i)
    {
        return i & 15;
    }
    
    public Item getItemDropped(int p_149650_1_, Random ran, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }
    
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item i, CreativeTabs p2, List list)
    {
		for(int j = 0; j < 10; j++)
		{
			list.add(new ItemStack(i, 1, j));
		}
    }
}