package shadows.nature.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shadows.nature.registry.ModRegistry;
import shadows.nature.util.IHasModelLocation;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onModelRegister(ModelRegistryEvent e) {
		for (Block block : ModRegistry.BLOCKS) {
			if (block instanceof IHasModelLocation)
				((IHasModelLocation) block).registerModels();
		}
		for (Item item : ModRegistry.ITEMS) {
			if (item instanceof IHasModelLocation)
				((IHasModelLocation) item).registerModels();
		}
	}
}
