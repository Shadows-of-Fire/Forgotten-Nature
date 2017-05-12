package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;

public class ItemNewLogs1 extends ItemBlock {
	Block log = FNBlocks.newLogs1;
	public static final String[] names = new String[] { "cherrylog", "*cherrylog", "ironwoodlog", "*ironwoodlog",
			"eucalyptuslog", "*eucalyptuslog", "sequoialog", "*sequoialog", "dummy", "*dummy", "joshualog",
			"*joshualog", "swampwillowlog", "*swampwillowlog", "palmlog", "*palmlog" };

	public ItemNewLogs1(Block i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
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
		int var10 = 0;

		if (var11 == Blocks.snow)
			par7 = 1;
		else if (var11 != Blocks.vine && var11 != Blocks.tallgrass && var11 != Blocks.deadbush
				&& (var11 == null || !var11.canReplace(par3World, par4, par5, par6, par7, par1ItemStack))) {
			if (par7 == 0) {
				var10 = 0;
				--par5;
			}
			if (par7 == 1) {
				var10 = 0;
				++par5;
			}
			if (par7 == 2) {
				var10 = 0;
				log = FNBlocks.newLogs4;
				--par6;
			}
			if (par7 == 3) {
				var10 = 0;
				log = FNBlocks.newLogs4;
				++par6;
			}
			if (par7 == 4) {
				var10 = 1;
				--par4;
			}
			if (par7 == 5) {
				var10 = 1;
				++par4;
			}
		}

		if (par1ItemStack.stackSize == 0)
			return false;
		else if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
			return false;
		else if (par5 == 255 && log.getMaterial().isSolid())
			return false;
		else if (par3World.canPlaceEntityOnSide(log, par4, par5, par6, false, par7, par2EntityPlayer, par1ItemStack)) {
			Block var12 = log;
			int met = 0;
			int var13 = this.getMetadata(par1ItemStack.getItemDamage());
			int var14 = log.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, var13);
			if (log == FNBlocks.newLogs1) {
				met = var14 + var10;
			} else {
				if (var14 % 2 == 0)
					met = var14 + var10;
				else
					met = var14;
			}

			if (placeBlockAt(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10,
					met)) {
				par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F),
						(double) ((float) par6 + 0.5F), Block.soundTypeWood.getBreakSound(),
						(var12.stepSound.getVolume() + 1.0F) / 2.0F, var12.stepSound.getPitch() * 0.8F);
				--par1ItemStack.stackSize;
			}
			log = FNBlocks.newLogs1;
			return true;
		} else
			return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean canPlaceItemBlockOnSide(World par1World, int par2, int par3, int par4, int par5,
			EntityPlayer par6EntityPlayer, ItemStack par7ItemStack) {
		Block var8 = par1World.getBlock(par2, par3, par4);

		if (var8 == Blocks.snow)
			par5 = 1;
		else if (var8 != Blocks.vine && var8 != Blocks.tallgrass && var8 != Blocks.deadbush
				&& (var8 == null || !var8.canReplace(par1World, par2, par3, par4, par5, par7ItemStack))) {
			if (par5 == 0)
				--par3;
			if (par5 == 1)
				++par3;
			if (par5 == 2)
				--par4;
			if (par5 == 3)
				++par4;
			if (par5 == 4)
				--par2;
			if (par5 == 5)
				++par2;
		}

		return par1World.canPlaceEntityOnSide(log, par2, par3, par4, false, par5, (Entity) null, par7ItemStack);
	}

	public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ, int metadata) {
		if (!world.setBlock(x, y, z, log, metadata, 3))
			return false;

		if (world.getBlock(x, y, z) == log) {
			log.onBlockPlacedBy(world, x, y, z, player, stack);
			log.onPostBlockPlaced(world, x, y, z, metadata);
		}
		return true;
	}
}