package shadows.nature.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import shadows.nature.common.world.gen.BushGenerator;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		GameRegistry.registerWorldGenerator(new BushGenerator(), 1);
	}

	public void init(FMLInitializationEvent e) {
	}

	public void postInit(FMLPostInitializationEvent e) {

	}

}
