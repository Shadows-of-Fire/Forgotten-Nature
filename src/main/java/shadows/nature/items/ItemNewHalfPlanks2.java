package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNBlocks;

public class ItemNewHalfPlanks2 extends ItemSlab {
	private final Block block;
	private final static BlockSlab slab = FNBlocks.newHalfPlanks2;
	private final static BlockSlab dSlab = FNBlocks.newDoubleHalfPlanks2;
	public static final String[] woodType = new String[] { "acaciaWoodSlab", "brightYellowWoodSlab", "oldWoodSlab",
			"bambooSlab", "driedBambooSlab", "crystalSlab", "darkCrystalSlab" };

	public ItemNewHalfPlanks2(Block i) {
		super(i, slab, dSlab, false);
		setMaxDamage(0);
		setHasSubtypes(true);
		this.block = i;
		if (i == dSlab) {
			// LanguageRegistry.addName(new ItemStack(this, 1, 0), "Acacia Wood
			// Slab");//removed since MC added vanilla version
		}
	}

	public String getUnlocalizedName(ItemStack p1) {
		return super.getUnlocalizedName() + "." + woodType[p1.getItemDamage()];
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		if (i > 6)
			i = -6;
		return FNBlocks.newHalfPlanks2.getIcon(0, i);
	}

	public int getMetadata(int i) {
		return i;
	}

	public int getPlacedBlockMetadata(int damage) {
		return damage;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4,
			int par5, int par6, int par7, float par8, float par9, float par10) {
		if (this.block == dSlab)
			return super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9,
					par10);
		else if (par1ItemStack.stackSize == 0)
			return false;
		else if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
			return false;
		else {
			Block block = par3World.getBlock(par4, par5, par6);
			int var12 = par3World.getBlockMetadata(par4, par5, par6);
			int var13 = var12 & 7;
			boolean var14 = (var12 & 8) != 0;

			if ((par7 == 1 && !var14 || par7 == 0 && var14) && block == this.block
					&& var13 == par1ItemStack.getItemDamage()) {
				if (par3World
						.checkNoEntityCollision(this.block.getCollisionBoundingBoxFromPool(par3World, par4, par5, par6))
						&& par3World.setBlock(par4, par5, par6, FNBlocks.newDoubleHalfPlanks2, var13, 3)) {
					par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F),
							(double) ((float) par6 + 0.5F), this.block.stepSound.soundName,
							(this.block.stepSound.getVolume() + 1.0F) / 2.0F, this.block.stepSound.getPitch() * 0.8F);
					--par1ItemStack.stackSize;
				}

				return true;
			} else
				return this.funcCheck(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7) ? true
						: super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8,
								par9, par10);
		}
	}

	private boolean funcCheck(ItemStack p_150946_1_, EntityPlayer p_150946_2_, World p_150946_3_, int p_150946_4_,
			int p_150946_5_, int p_150946_6_, int direction) {
		if (direction == 0) {
			--p_150946_5_;
		}

		if (direction == 1) {
			++p_150946_5_;
		}

		if (direction == 2) {
			--p_150946_6_;
		}

		if (direction == 3) {
			++p_150946_6_;
		}

		if (direction == 4) {
			--p_150946_4_;
		}

		if (direction == 5) {
			++p_150946_4_;
		}

		Block block = p_150946_3_.getBlock(p_150946_4_, p_150946_5_, p_150946_6_);
		int i1 = p_150946_3_.getBlockMetadata(p_150946_4_, p_150946_5_, p_150946_6_);
		int j1 = i1 & 7;

		if (block == this.block && j1 == p_150946_1_.getItemDamage()) {
			if (p_150946_3_.checkNoEntityCollision(
					this.block.getCollisionBoundingBoxFromPool(p_150946_3_, p_150946_4_, p_150946_5_, p_150946_6_))
					&& p_150946_3_.setBlock(p_150946_4_, p_150946_5_, p_150946_6_, FNBlocks.newDoubleHalfPlanks2, j1,
							3)) {
				p_150946_3_.playSoundEffect((double) ((float) p_150946_4_ + 0.5F),
						(double) ((float) p_150946_5_ + 0.5F), (double) ((float) p_150946_6_ + 0.5F),
						this.block.stepSound.func_150496_b(), (this.block.stepSound.getVolume() + 1.0F) / 2.0F,
						this.block.stepSound.getPitch() * 0.8F);
				--p_150946_1_.stackSize;
			}

			return true;
		} else {
			return false;
		}
	}
}