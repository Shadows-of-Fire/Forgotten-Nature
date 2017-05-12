package ForgottenNature.Items;

import java.util.ArrayList;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;

import ForgottenNature.ForgottenNature;
import ForgottenNature.Proxy.FNBlocks;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSaw extends ItemTool
{
	/** an array of the blocks this axe is effective against */
    public static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] {
        	FNBlocks.newPlanks1,FNBlocks.newLogs1,FNBlocks.newLogs2,FNBlocks.newLogs3,
        	Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, 
        	Blocks.double_wooden_slab, Blocks.wooden_slab, Blocks.pumpkin, Blocks.lit_pumpkin, 
        	FNBlocks.crystalWood});
    
    public float func_150893_a(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && blocksEffectiveAgainst.contains(par2Block) ? this.efficiencyOnProperMaterial : 1.0F;
    }
    
    public ItemSaw(ToolMaterial toolmaterial)
    {
        super(2.0F, toolmaterial, blocksEffectiveAgainst);
        maxStackSize = 1;
    }

    public String getUnlocalizedName(ItemStack i)
    {
		return "saw";
    }
}