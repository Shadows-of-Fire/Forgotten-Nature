package ForgottenNature.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSawItems extends Item
{
	@SideOnly(Side.CLIENT)
	private IIcon[] sawIcons;

    public ItemSawItems()
    {
        super();
        setMaxDamage(0);
        setHasSubtypes(true);
        setMaxStackSize(64);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int i)
    {
    	return this.sawIcons[i];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.sawIcons = new IIcon[10];

        this.sawIcons[0] = par1IconRegister.registerIcon("forgottennature:SawTooth");
        this.sawIcons[1] = par1IconRegister.registerIcon("forgottennature:SawBlade");
        this.sawIcons[2] = par1IconRegister.registerIcon("forgottennature:SawHandle");
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item i, CreativeTabs tabs, List list)
    {
    	for(int j = 0; j < 3; j++)
    	{
    		list.add(new ItemStack(i, 1, j));
    	}
    }
    public String getUnlocalizedName(ItemStack i)
    {
	    switch(i.getItemDamage())
	    {
		    case 0:return "sawTooth";
		    case 1:return "sawBlade";
		    case 2:return "sawHandle";
		    default:return "";
	    }
    }
}
