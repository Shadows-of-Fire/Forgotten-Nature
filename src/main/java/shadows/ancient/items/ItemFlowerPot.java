package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFlowerPot extends ItemBlock {
	private IIcon potIcon;

	public ItemFlowerPot(Block i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public IIcon getIconFromDamage(int i) {
		return this.potIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.potIcon = par1IconRegister.registerIcon("ForgottenNature:flowerPotItem");
	}

	public int getMetadata(int i) {
		return i;
	}
}