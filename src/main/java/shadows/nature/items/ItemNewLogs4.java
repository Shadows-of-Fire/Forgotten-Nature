package ForgottenNature.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemNewLogs4 extends ItemBlock
{
	public static final String[] names = new String[] {"cherrylog*", "desertwillowlog*", "ironwoodlog*", 
			"cedarlog*", "eucalyptuslog*", "ginkgolog*", "sequoialog*", "beechlog*", "dummy*", "walnutlog", 
			"joshualog*", "dummy2*", "swampwillowlog*", "dummy3*", "palmlog*", "widetopeucalyptuslog*"};
	
    public ItemNewLogs4(Block i)
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
}