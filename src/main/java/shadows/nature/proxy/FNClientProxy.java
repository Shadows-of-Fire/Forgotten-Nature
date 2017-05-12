package ForgottenNature.Proxy;

import ForgottenNature.ForgottenNature;
import ForgottenNature.Blocks.BlockNewFence;
import ForgottenNature.Blocks.BlockNewFlowerPot;
import ForgottenNature.Blocks.BlockNewLogs1;
import ForgottenNature.Blocks.BlockNewLogs2;
import ForgottenNature.Blocks.BlockNewLogs3;
import ForgottenNature.Blocks.BlockNewLogs4;
import ForgottenNature.Renderers.RenderFences;
import ForgottenNature.Renderers.RenderLogs;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;

public class FNClientProxy extends FNCommonProxy
{	
	public static int armorObsidian;
	public static int armorTitanStone;
	public final static int FNLogRenderID = RenderingRegistry.getNextAvailableRenderId();
	public final static int FNFenceRenderID = RenderingRegistry.getNextAvailableRenderId();
	
	public static void registerRenderStuff()
	{
		RenderingRegistry.registerBlockHandler(FNLogRenderID, new RenderLogs());
		BlockNewLogs1.setRenderId(FNLogRenderID);
		BlockNewLogs2.setRenderId(FNLogRenderID);
		BlockNewLogs3.setRenderId(FNLogRenderID);
		BlockNewLogs4.setRenderId(FNLogRenderID);
		RenderingRegistry.registerBlockHandler(FNFenceRenderID, new RenderFences());
		BlockNewFence.setRenderId(FNFenceRenderID);
    }
}
