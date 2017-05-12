package shadows.nature.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNItems;

public class ItemNewFood3 extends ItemFood {
	@SideOnly(Side.CLIENT)
	private IIcon[] drinkIcons;

	public ItemNewFood3() {
		super(9, 0.6F, false);
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
		setContainerItem(FNItems.cupItem);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return this.drinkIcons[i];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.drinkIcons = new IIcon[10];

		this.drinkIcons[0] = par1IconRegister.registerIcon("ForgottenNature:FoodCoconutMilk");
		this.drinkIcons[1] = par1IconRegister.registerIcon("ForgottenNature:FoodFruitSmoothie");
		this.drinkIcons[2] = par1IconRegister.registerIcon("ForgottenNature:FoodFruitJuice");
	}

	public ItemStack onEaten(ItemStack stack, World par2World, EntityPlayer player) {
		--stack.stackSize;
		player.getFoodStats().addStats(9, 0.6F);
		par2World.playSoundAtEntity(player, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		this.onFoodEaten(stack, par2World, player);
		player.inventory.addItemStackToInventory(new ItemStack(FNItems.cupItem));
		return stack;
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item i, CreativeTabs tabs, List list) {
		for (int j = 0; j < 3; j++) {
			list.add(new ItemStack(i, 1, j));
		}
	}

	public String getUnlocalizedName(ItemStack i) {
		switch (i.getItemDamage()) {
		case 0:
			return "coconutMilk";
		case 1:
			return "fruitSmoothie";
		case 2:
			return "fruitJuice";
		default:
			return "";
		}
	}
}
