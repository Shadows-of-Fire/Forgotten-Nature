package shadows.nature.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemNewFood2 extends ItemFood {
	@SideOnly(Side.CLIENT)
	private IIcon[] saladIcons;

	public ItemNewFood2() {
		super(9, 0.7F, false);
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return this.saladIcons[i];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.saladIcons = new IIcon[2];

		this.saladIcons[0] = par1IconRegister.registerIcon("ForgottenNature:FoodFruitSalad");
		this.saladIcons[1] = par1IconRegister.registerIcon("ForgottenNature:FoodFruitNutSalad");
	}

	public ItemStack onEaten(ItemStack itemstack, World par2World, EntityPlayer player) {
		--itemstack.stackSize;
		player.getFoodStats().addStats(9, 0.7F);
		par2World.playSoundAtEntity(player, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		if (itemstack.getItemDamage() == 0)// fSalad
		{
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 2));
		} else// fnSalad
		{
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2 * 20, 1));
		}
		player.inventory.addItemStackToInventory(new ItemStack(Items.bowl));
		return itemstack;
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item i, CreativeTabs tabs, List list) {
		for (int j = 0; j < 2; j++) {
			list.add(new ItemStack(i, 1, j));
		}
	}

	public String getUnlocalizedName(ItemStack i) {
		switch (i.getItemDamage()) {
		case 0:
			return "fruitSalad";
		case 1:
			return "fruitNutSalad";
		default:
			return "";
		}
	}
}
