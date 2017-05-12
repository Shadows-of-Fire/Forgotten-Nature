package ForgottenNature.Items;

import java.util.List;

import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import ForgottenNature.ForgottenNature;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCrystalStone extends ItemBlock
{
	public static final String[] names = new String[] {"crystalstone", "darkcrystalstone"};
	
	@SideOnly(Side.CLIENT)
    private IIcon[] field_94594_d;
	
    public ItemCrystalStone(Block i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }
    
    public String getUnlocalizedName(ItemStack p1)
    {
    	return super.getUnlocalizedName() + "." + names[p1.getItemDamage()]; 
    }
    
    public int getMetadata(int i)
    {
        return i;
    }
    
    public int getPlacedBlockMetadata(int damage)
    {
        return damage;
    }
    
    public IIcon getIconFromDamage(int i)
    {
        return FNBlocks.crystalStone.getIcon(0, i);
    }
}