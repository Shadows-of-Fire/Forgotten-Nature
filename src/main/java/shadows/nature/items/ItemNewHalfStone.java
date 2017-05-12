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

public class ItemNewHalfStone extends ItemSlab {
	private final Block block;
	private final static BlockSlab slab = FNBlocks.newHalfStone;
	private final static BlockSlab dSlab = FNBlocks.newDoubleHalfStone;
	public static final String[] rockType = new String[] { "granite", "gneiss", "hornfels", "marble", "granitebricks",
			"gneissbricks", "hornfelsbricks", "marblebricks" };

	public ItemNewHalfStone(Block i) {
		super(i, slab, dSlab, false);
		setMaxDamage(0);
		setHasSubtypes(true);
		this.block = i;
	}

	public String getUnlocalizedName(ItemStack p1) {
		return super.getUnlocalizedName() + "." + rockType[p1.getItemDamage()];
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return FNBlocks.newHalfStone.getIcon(0, i);
	}

	public int getMetadata(int i) {
		return i;
	}

	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_,
			int p_77648_5_, int p_77648_6_, int direction, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		if (this.block == dSlab) {
			return super.onItemUse(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, direction,
					p_77648_8_, p_77648_9_, p_77648_10_);
		} else if (p_77648_1_.stackSize == 0) {
			return false;
		} else if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, direction, p_77648_1_)) {
			return false;
		} else {
			Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
			int i1 = p_77648_3_.getBlockMetadata(p_77648_4_, p_77648_5_, p_77648_6_);
			int j1 = i1 & 7;
			boolean flag = (i1 & 8) != 0;

			if ((direction == 1 && !flag || direction == 0 && flag) && block == this.block
					&& j1 == p_77648_1_.getItemDamage()) {
				if (p_77648_3_.checkNoEntityCollision(
						this.block.getCollisionBoundingBoxFromPool(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_))
						&& p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, FNBlocks.newDoubleHalfStone, j1,
								3)) {
					p_77648_3_.playSoundEffect((double) ((float) p_77648_4_ + 0.5F),
							(double) ((float) p_77648_5_ + 0.5F), (double) ((float) p_77648_6_ + 0.5F),
							this.block.stepSound.func_150496_b(), (this.block.stepSound.getVolume() + 1.0F) / 2.0F,
							this.block.stepSound.getPitch() * 0.8F);
					--p_77648_1_.stackSize;
				}

				return true;
			} else {
				return this.funcCheck(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, direction)
						? true
						: super.onItemUse(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_,
								direction, p_77648_8_, p_77648_9_, p_77648_10_);
			}
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
					&& p_150946_3_.setBlock(p_150946_4_, p_150946_5_, p_150946_6_, FNBlocks.newDoubleHalfStone, j1,
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