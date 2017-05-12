package ForgottenNature.Blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockOres extends Block
{
	@SideOnly(Side.CLIENT)
    private IIcon[] stoneIcons;
	private int metaM;
	public int ind;

	public BlockOres(int metaMax, int oreInd)
	{
		super(Material.rock);
		setHardness(1.5F);
        setResistance(10.0F);
        setStepSound(Block.soundTypeStone);
        metaM = metaMax;
        ind = oreInd;
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return this.stoneIcons[par2];
    }
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.stoneIcons = new IIcon[16];

        if(ind == 0)
        {
	    	this.stoneIcons[0] = par1IconRegister.registerIcon("ForgottenNature:barite");		//for Barium
			this.stoneIcons[1] = par1IconRegister.registerIcon("ForgottenNature:bertrandite");	//for Beryllium
			this.stoneIcons[2] = par1IconRegister.registerIcon("ForgottenNature:erythrite");	//for Cobalt
			this.stoneIcons[3] = par1IconRegister.registerIcon("ForgottenNature:molybdenite");	//for Molybdenum. trace copper and tungsten
			this.stoneIcons[4] = par1IconRegister.registerIcon("ForgottenNature:stibnite");		//for Antimony
			this.stoneIcons[5] = par1IconRegister.registerIcon("ForgottenNature:monazite");		//for Neodymium (best pMagnets), thorium (nuclear fuel), ytterbium (nuclear fuel), samarium (2nd best pMagnets), erbium (nuclear control rods). Note that mu-metals (nickel-iron alloys) are great magnetic shunts.
			this.stoneIcons[6] = par1IconRegister.registerIcon("ForgottenNature:feldspar");		//for Potassium, Aluminum, Silicon
			this.stoneIcons[7] = par1IconRegister.registerIcon("ForgottenNature:fluorite");		//for Calcium, main=Fluorine --a GAS!!
			this.stoneIcons[8] = par1IconRegister.registerIcon("ForgottenNature:halite");		//for Salt
			this.stoneIcons[9] = par1IconRegister.registerIcon("ForgottenNature:pentlandite");	//for Nickel and some Iron
			this.stoneIcons[10] = par1IconRegister.registerIcon("ForgottenNature:petalite");	//for Lithium (batteries and lube). Lithium is also in granite.
			this.stoneIcons[11] = par1IconRegister.registerIcon("ForgottenNature:pyrite");		//for some Iron, but its powder is used to recover iron, gold, copper, cobalt and nickel
        }
        else
        {
			this.stoneIcons[0] = par1IconRegister.registerIcon("ForgottenNature:bauxite");		//for Aluminum, trace Gallium. Gallium is 1% in coal
			this.stoneIcons[1] = par1IconRegister.registerIcon("ForgottenNature:galena");		//for Lead and Silver, trace Vanadium
			this.stoneIcons[2] = par1IconRegister.registerIcon("ForgottenNature:chromite");		//for Chrome, trace Iron
			this.stoneIcons[3] = par1IconRegister.registerIcon("ForgottenNature:malachite");	//for Copper
			this.stoneIcons[4] = par1IconRegister.registerIcon("ForgottenNature:pyrolusite");	//for Manganese. Traces of Manganese can be found around Iron.
			this.stoneIcons[5] = par1IconRegister.registerIcon("ForgottenNature:PGMore");		//for Platinum Group Metals (platinum, palladium, rhodium, iridium, osmium, ruthenium)
			this.stoneIcons[6] = par1IconRegister.registerIcon("ForgottenNature:sulfur");		//for Sulfur
			this.stoneIcons[7] = par1IconRegister.registerIcon("ForgottenNature:tantalite");	//for Tantalum (refractory)
			this.stoneIcons[8] = par1IconRegister.registerIcon("ForgottenNature:ilmenite");		//for Titanium, some Iron
			this.stoneIcons[9] = par1IconRegister.registerIcon("ForgottenNature:tungsten");		//for Tungsten
			this.stoneIcons[10] = par1IconRegister.registerIcon("ForgottenNature:uranium");		//for Uranium
			this.stoneIcons[11] = par1IconRegister.registerIcon("ForgottenNature:sphalerite");	//for Sphalerite
			this.stoneIcons[12] = par1IconRegister.registerIcon("ForgottenNature:tin");			//for Tin
        }
    }
	
	public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    
    public int damageDropped(int i)
    {
        return i & 15;
    }
    
    public Item getItemDropped(int p_1_, Random ran, int p_3_)
    {
        return Item.getItemFromBlock(this);
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item i, CreativeTabs p2, List list)
    {
		for(int j = 0; j < metaM + 1; j++)
		{
			list.add(new ItemStack(i, 1, j));
		}
    }
}
