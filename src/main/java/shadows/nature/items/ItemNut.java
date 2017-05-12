package ForgottenNature.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNut extends ItemFood
{
	@SideOnly(Side.CLIENT)
	private IIcon[] nutIcons;
	public static final String[] names = new String[] {"ginkgoNuts", "walnuts", "orange"};

    public ItemNut()
    {
        super(1, 0.4F, false);
        setMaxDamage(0);
        setHasSubtypes(true);
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabFood);
    }
    
    public String getUnlocalizedName(ItemStack p1)
    {
        int i = MathHelper.clamp_int(p1.getItemDamage(), 0, 15);
        return super.getUnlocalizedName() + "." + names[i];
    }
    
    @Override
	@SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int i)
    {
    	return this.nutIcons[i];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.nutIcons = new IIcon[3];

        this.nutIcons[0] = par1IconRegister.registerIcon("forgottennature:FoodGinkgoNuts");
        this.nutIcons[1] = par1IconRegister.registerIcon("forgottennature:FoodWalnuts");
        this.nutIcons[2] = par1IconRegister.registerIcon("forgottennature:FoodCoconut");
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item i, CreativeTabs tabs, List list)
    {
    	for(int j = 0; j < 3; j++)
    	{
    		list.add(new ItemStack(i, 1, j));
    	}
    }
}
