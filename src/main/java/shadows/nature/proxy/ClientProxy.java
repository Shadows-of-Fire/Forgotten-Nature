package shadows.nature.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import shadows.nature.registry.NatureBlocks;
import shadows.nature.registry.NatureItems;
import shadows.nature.util.IHasModelLocation;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		for (Block block : NatureBlocks.getBlocks()) {
			if (block instanceof IHasModelLocation)
				((IHasModelLocation) block).registerModels();
		}
		for (Item item : NatureItems.getItems()) {
			if (item instanceof IHasModelLocation)
				((IHasModelLocation) item).registerModels();
		}
	}
}
