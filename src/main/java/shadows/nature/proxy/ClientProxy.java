package shadows.nature.proxy;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import shadows.nature.registry.NatureBlocks;
import shadows.nature.util.IHasModelLocation;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		for(Block block : NatureBlocks.getBlocks()){
			if(block instanceof IHasModelLocation) ((IHasModelLocation) block).registerModels();
		}
	}
}
