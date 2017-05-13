package shadows.nature;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import shadows.nature.proxy.CommonProxy;
import shadows.nature.util.NatureData;

@Mod(modid = NatureData.MODID, version = NatureData.VERSION, name = NatureData.NAME)
public class Nature {

	@SidedProxy(clientSide = "shadows.nature.proxy.ClientProxy", serverSide = "shadows.nature.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance
	public static Nature instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}

}
