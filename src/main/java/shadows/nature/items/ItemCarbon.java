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

public class ItemCarbon extends Item
{
	@SideOnly(Side.CLIENT)
	private IIcon[] field_94594_d;

    public ItemCarbon()
    {
        super();
        setMaxDamage(0);
        setHasSubtypes(true);
        setMaxStackSize(64);
    }
    public IIcon getIconFromDamage(int i)
    {
    	return this.field_94594_d[i];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.field_94594_d = new IIcon[3];

        this.field_94594_d[0] = par1IconRegister.registerIcon("ForgottenNature:CoalChunk");
        this.field_94594_d[1] = par1IconRegister.registerIcon("ForgottenNature:CompressedCoalChunk");
        this.field_94594_d[2] = par1IconRegister.registerIcon("ForgottenNature:ThinCarbonWafers");
    }
    public int getMetadata(int par1)
    {
        return par1 & 3;
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
		    case 0:return "coalChunk";
		    case 1:return "compCoalChunk";
		    case 2:return "carbonWafers";
		    default:return "";
	    }
    }
}
