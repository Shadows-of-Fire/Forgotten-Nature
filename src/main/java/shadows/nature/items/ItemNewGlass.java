package ForgottenNature.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNewGlass extends ItemBlock
{
	public static final String[] names = new String[] {"blacklattice", "wide3x3", "ramedwide3x3", "3x3", "framed3x3", 
			"doublediamond", "pinwheel", "2x2", "framed2x2", "diamondlattice", "doublelattice", "squarelattice", 
			"peakingwindow", "circle", "doubledoor", "2x1"};
    public ItemNewGlass(Block i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }
    
    public String getUnlocalizedName(ItemStack p1)
    {
        return super.getUnlocalizedName() + "." + names[p1.getItemDamage()]; 
    }
   
    public IIcon getIconFromDamage(int i)
    {
        return FNBlocks.FNGlass.getIcon(0, i);
    }
    
    public int getMetadata(int i)
    {
        return i;
    }
}