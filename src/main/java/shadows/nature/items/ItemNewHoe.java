package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNItems;

public class ItemNewHoe extends ItemHoe {
	@SideOnly(Side.CLIENT)
	private IIcon hoeIcons;

	protected Item.ToolMaterial theToolMaterial;

	public ItemNewHoe(Item.ToolMaterial par2ToolMaterial) {
		super(par2ToolMaterial);
		this.maxStackSize = 1;
		this.setMaxDamage(par2ToolMaterial.getMaxUses());
	}

	public IIcon getIconFromDamage(int i) {
		return this.hoeIcons;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		if (this == FNItems.cHoeItem)
			this.hoeIcons = par1IconRegister.registerIcon("ForgottenNature:HoeLightCrystal");
		else if (this == FNItems.dcHoeItem)
			this.hoeIcons = par1IconRegister.registerIcon("ForgottenNature:HoeDarkCrystal");
		else if (this == FNItems.oHoeItem)
			this.hoeIcons = par1IconRegister.registerIcon("ForgottenNature:HoeObsidian");
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4,
			int par5, int par6, int par7, float par8, float par9, float par10) {
		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
			return false;
		} else {
			UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
			if (MinecraftForge.EVENT_BUS.post(event)) {
				return false;
			}
			if (event.getResult() == Result.ALLOW) {
				par1ItemStack.damageItem(1, par2EntityPlayer);
				return true;
			}

			Block var11 = par3World.getBlock(par4, par5, par6);
			Block var12 = par3World.getBlock(par4, par5 + 1, par6);

			if ((par7 == 0 || var12 != Blocks.air || var11 != Blocks.grass) && var11 != Blocks.dirt) {
				return false;
			} else {
				Block var13 = Blocks.farmland;
				par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F),
						(double) ((float) par6 + 0.5F), var13.stepSound.soundName,
						(var13.stepSound.getVolume() + 1.0F) / 2.0F, var13.stepSound.getPitch() * 0.8F);

				if (par3World.isRemote) {
					return true;
				} else {
					par3World.setBlock(par4, par5, par6, var13, 0, 2);
					par1ItemStack.damageItem(1, par2EntityPlayer);
					return true;
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	public String getUnlocalizedName(ItemStack i) {
		if (this == FNItems.cHoeItem)
			return "choe";
		else if (this == FNItems.dcHoeItem)
			return "dhoe";
		else
			return "ohoe";
	}
}
