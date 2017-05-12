package ForgottenNature.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import ForgottenNature.ForgottenNature;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNewCup extends Item
{
	@SideOnly(Side.CLIENT)
	private IIcon[] cupIcons;

    public ItemNewCup()
    {
        super();
        setMaxDamage(0);
        setHasSubtypes(true);
        setMaxStackSize(64);
    }
    public IIcon getIconFromDamage(int i)
    {
    	return this.cupIcons[i];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.cupIcons = new IIcon[2];

        this.cupIcons[0] = par1IconRegister.registerIcon("forgottennature:GlassCup");
        this.cupIcons[1] = par1IconRegister.registerIcon("forgottennature:AnimalOil");
    }
    public int getMetadata(int par1)
    {
        return par1 & 3;
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item i, CreativeTabs tabs, List list)
    {
    	for(int j = 0; j < 2; j++)
    	{
    		list.add(new ItemStack(i, 1, j));
    	}
    }
    
    public String getUnlocalizedName(ItemStack i)
    {
	    switch(i.getItemDamage())
	    {
		    case 0:return "glassCup";
		    case 1:return "animalOil";
		    default:return "";
	    }
    }
}
