package ForgottenNature.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNewFlowers extends ItemBlock
{
	public static final String[] names = new String[] {"alliumDrumstick", "bachelorsbutton", "billybuttons", "delphiniumbelladonna", 
			"fernfloweryarrow", "gerberadaisy", "hydrangea", "redrover", "snapdragon", "starofbethlehem"};
	
    public ItemNewFlowers(Block i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }
    
    public String getUnlocalizedName(ItemStack p1)
    {
        return super.getUnlocalizedName() + "." + names[p1.getItemDamage()]; 
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int i)
    {
        return FNBlocks.fNFlowers.getIcon(0, i);
    }
    public int getMetadata(int i)
    {
        return i & 15;
    }
    public int getPlacedBlockMetadata(int damage)
    {
        return damage;
    }
}
