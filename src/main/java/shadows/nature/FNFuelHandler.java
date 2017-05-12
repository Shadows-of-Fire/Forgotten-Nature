package shadows.nature;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FNFuelHandler implements IFuelHandler {
	public int getBurnTime(ItemStack fuel) {
		int i = Item.getIdFromItem(fuel.getItem());
		if (i == Block.getIdFromBlock(FNBlocks.newLogs1) || i == Block.getIdFromBlock(FNBlocks.fNSapling2)
				|| i == Block.getIdFromBlock(FNBlocks.fNSapling3)) {
			return 500;
		}
		if (i == Block.getIdFromBlock(FNBlocks.newPlanks1) || i == Block.getIdFromBlock(FNBlocks.newPlanks2)) {
			return 300;
		}
		if (i == Block.getIdFromBlock(FNBlocks.fNSapling1) || i == Block.getIdFromBlock(FNBlocks.fNSapling2)
				|| i == Block.getIdFromBlock(FNBlocks.fNSapling3)) {
			return 100;
		}
		return 0;
	}
}
