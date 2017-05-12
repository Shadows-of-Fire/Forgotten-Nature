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

public class ItemNewCropGoods extends Item
{
	@SideOnly(Side.CLIENT)
	private IIcon[] goodsIcons;

    public ItemNewCropGoods()
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
    	return this.goodsIcons[i];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.goodsIcons = new IIcon[4];

        this.goodsIcons[0] = par1IconRegister.registerIcon("ForgottenNature:GoodsCottonBalls");
        this.goodsIcons[1] = par1IconRegister.registerIcon("ForgottenNature:GoodsHempFibers");
        this.goodsIcons[2] = par1IconRegister.registerIcon("ForgottenNature:GoodsRopeYarn");
        this.goodsIcons[3] = par1IconRegister.registerIcon("ForgottenNature:GoodsRopeStrand");
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item i, CreativeTabs tabs, List list)
    {
    	for(int j = 0; j < 4; j++)
    	{
    		list.add(new ItemStack(i, 1, j));
    	}
    
    }
    public String getUnlocalizedName(ItemStack i)
    {
	    switch(i.getItemDamage())
	    {
		    case 0:return "cottonBalls";
		    case 1:return "hempFibers";
		    case 2:return "ropeYarn";
		    case 3:return "ropeStrand";
		    default:return "";
	    }
    }
}
