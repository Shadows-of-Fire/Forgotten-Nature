package shadows.nature.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSurfaceTeleport extends Item {
	@SideOnly(Side.CLIENT)
	private IIcon[] field_94594_d;

	public static String[] blockNames = { "CoalChunk" };

	public ItemSurfaceTeleport() {
		super();
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(16);
	}

	public IIcon getIconFromDamage(int i) {
		return this.field_94594_d[i];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.field_94594_d = new IIcon[1];

		this.field_94594_d[0] = par1IconRegister.registerIcon("ForgottenNature:SurfaceTeleportItem");
	}

	public int getMetadata(int par1) {
		return par1 & 3;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer entityplayer) {
		int i = (int) entityplayer.posX;
		int k = (int) entityplayer.posZ;
		int j = world.getHeightValue(i, k);

		entityplayer.setPosition(i, j + 1, k);

		if (!entityplayer.capabilities.isCreativeMode)
			--par1ItemStack.stackSize;
		return par1ItemStack;
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item i, CreativeTabs tabs, List list) {
		list.add(new ItemStack(i, 1, 0));
	}

	public String getUnlocalizedName(ItemStack i) {
		switch (i.getItemDamage()) {
		case 0:
			return "surfaceTeleportItem";
		default:
			return "";
		}
	}
}
