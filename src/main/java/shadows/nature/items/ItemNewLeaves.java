package ForgottenNature.Items;

import java.util.List;

import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemNewLeaves extends ItemBlock
{
	public static final String[] names1 = new String[] {"redmapleleaves", "angeloakleaves", "yellowmapleleaves", 
			"jacarandaleaves", "figleaves", "cypressleaves", "desertironwoodleaves", "eucalyptusleaves"};
	public static final String[] names2 = new String[] {"sequoialeaves", "pinkcherryleaves", "whitecherryleaves", 
			"appleleaves", "applebudleaves", "applefruitleaves", "dummy", "joshualeaves"};
	public static final String[] names3 = new String[] {"swampwillowleaves", "deciduousbushleaves", "evergreenbushleaves", 
			"palmleaves", "desertwillowleaves", "cedarleaves", "ginkgoleaves", "poplarleaves"};
	public static final String[] names4 = new String[] {"beechleaves", "walnutleaves", "dummy", 
			"widetopeucalyptusleaves", "bukkitleaves", "bananaleaves", "orangeleaves", "peachleaves"};
	public static final String[] names5 = new String[] {"lemonleaves", "blueberryleaves", "blueberryfruitleaves", 
			"raspberryleaves", "raspberryfruitleaves", "blackberryleaves", "blackberryfruitleaves", "cherryfruitleaves"};
	public static final String[] names6 = new String[] {"huckleberryleaves", "huckleberryfruitleaves"};
	Block blk;
    public ItemNewLeaves(Block i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
        blk = i;
    }
    
    public String getUnlocalizedName(ItemStack p1)
    {
    	if(blk == FNBlocks.newLeaves1)
    		return super.getUnlocalizedName() + "." + names1[p1.getItemDamage()]; 
    	else if(blk == FNBlocks.newLeaves2)
    		return super.getUnlocalizedName() + "." + names2[p1.getItemDamage()]; 
    	else if(blk == FNBlocks.newLeaves3)
    		return super.getUnlocalizedName() + "." + names3[p1.getItemDamage()]; 
    	else if(blk == FNBlocks.newLeaves4)
    		return super.getUnlocalizedName() + "." + names4[p1.getItemDamage()]; 
    	else if(blk == FNBlocks.newLeaves5)
    		return super.getUnlocalizedName() + "." + names5[p1.getItemDamage()]; 
    	else
    		return super.getUnlocalizedName() + "." + names6[p1.getItemDamage()]; 
    }
    
    public int getMetadata(int i)
    {
        return i & 7;
    }
    
    public IIcon getIconFromDamage(int i)
    {
    	if(blk == FNBlocks.newLeaves1)
    		return FNBlocks.newLeaves1.getIcon(0, i);
    	else if(blk == FNBlocks.newLeaves2)
    		return FNBlocks.newLeaves2.getIcon(0, i);
    	else if(blk == FNBlocks.newLeaves3)
    		return FNBlocks.newLeaves3.getIcon(0, i);
    	else if(blk == FNBlocks.newLeaves4)
    		return FNBlocks.newLeaves4.getIcon(0, i);
    	else if(blk == FNBlocks.newLeaves5)
    		return FNBlocks.newLeaves5.getIcon(0, i);
    	else
    		return FNBlocks.newLeaves6.getIcon(0, i);
    }
    
    public int getPlacedBlockMetadata(int damage)
    {
        return damage;
    }
}
