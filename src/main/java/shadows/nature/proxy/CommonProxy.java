package shadows.nature.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import shadows.nature.common.world.gen.BushGenerator;
import shadows.nature.registry.ModRegistry;
import shadows.nature.util.ILateUpdateEnum;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(new ModRegistry());
		GameRegistry.registerWorldGenerator(new BushGenerator(), 1);
	}

	public void init(FMLInitializationEvent e) {
	}

	public void postInit(FMLPostInitializationEvent e) {
		for(ILateUpdateEnum d : ModRegistry.LATE_ENUMS) d.update();
	}

}
