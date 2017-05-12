package ForgottenNature.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlowerPot extends ItemBlock
{
	private IIcon potIcon;
    public ItemFlowerPot(Block i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }
   
    public IIcon getIconFromDamage(int i)
    {
        return this.potIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
    	this.potIcon = par1IconRegister.registerIcon("ForgottenNature:flowerPotItem");
    }
    
    public int getMetadata(int i)
    {
        return i;
    }
}