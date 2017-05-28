package shadows.nature.util;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IHasModelLocation {
	
	@SideOnly(Side.CLIENT)
	public void registerModels();

}
