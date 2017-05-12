package shadows.nature.Items;

//import net.minecraft.src.EntityPlayer;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;

public class ItemNewFence extends ItemBlock {
	public static final String[] names = new String[] { "brownfence", "purplefence", "darkredfence", "darkyellowfence",
			"peachfence", "orangefence", "brightwoodfence", "redwoodfence", "acaciafence", "brightyellowfence",
			"oldwoodfence", "bamboofence", "driedbamboofence", "crystalfence", "darkcrystalfence" };
	@SideOnly(Side.CLIENT)
	private IIcon[] fenceIcons;

	public ItemNewFence(Block j) {
		super(j);
		setMaxDamage(0);
		setHasSubtypes(true);
		// LanguageRegistry.addName(new ItemStack(this, 1, 8), "Acacia Fence");
		// removed after the appearance of vanilla acacai
	}

	public String getUnlocalizedName(ItemStack p1) {
		return super.getUnlocalizedName() + "." + names[p1.getItemDamage()];
	}

	public int getMetadata(int i) {
		return i;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4,
			int par5, int par6, int par7, float par8, float par9, float par10) {
		Block var11 = par3World.getBlock(par4, par5, par6);

		if (var11 == Blocks.snow)
			par7 = 1;
		else if (var11 != Blocks.vine && var11 != Blocks.tallgrass && var11 != Blocks.deadbush
				&& (var11 == null || !var11.isReplaceable(par3World, par4, par5, par6))) {
			if (par7 == 0)
				--par5;
			if (par7 == 1)
				++par5;
			if (par7 == 2)
				--par6;
			if (par7 == 3)
				++par6;
			if (par7 == 4)
				--par4;
			if (par7 == 5)
				++par4;
		}

		if (par1ItemStack.stackSize == 0)
			return false;
		else if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
			return false;
		else if (par5 == 255)
			return false;
		else if (par3World.canPlaceEntityOnSide(FNBlocks.newFence, par4, par5, par6, false, par7, par2EntityPlayer,
				par1ItemStack)) {
			Block var12 = FNBlocks.newFence;
			int var13 = this.getMetadata(par1ItemStack.getItemDamage());
			int var14 = FNBlocks.newFence.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, var13);

			if (placeBlockAt(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10,
					var14)) {
				par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F),
						(double) ((float) par6 + 0.5F), FNBlocks.newFence.stepSound.func_150496_b(),
						(var12.stepSound.getVolume() + 1.0F) / 2.0F, var12.stepSound.getPitch() * 0.8F);
				--par1ItemStack.stackSize;
			}

			return true;
		} else
			return false;
	}

	public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ, int metadata) {
		if (!world.setBlock(x, y, z, FNBlocks.newFence, metadata, 3))
			return false;

		if (world.getBlock(x, y, z) == FNBlocks.newFence) {
			FNBlocks.newFence.onBlockPlacedBy(world, x, y, z, player, stack);
			FNBlocks.newFence.onPostBlockPlaced(world, x, y, z, metadata);
		}
		return true;
	}
}