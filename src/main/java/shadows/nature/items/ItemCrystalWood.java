package ForgottenNature.Items;

import java.util.ArrayList;
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

public class ItemCrystalWood extends ItemBlock
{
    public static String[] names = {"crystalLog", "darkcrystallog", "crystalPlank","darkCrystalPlank"};
    public ItemCrystalWood(Block i)
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
        return FNBlocks.crystalWood.getIcon(0, i);
    }
}