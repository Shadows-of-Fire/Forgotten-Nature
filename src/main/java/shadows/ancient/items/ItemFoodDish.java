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

public class ItemFoodDish extends ItemFood {
	@SideOnly(Side.CLIENT)
	private IIcon bowlIcon;

	private int oniGar;
	private int pTGinger;
	private int wChestnut;

	public ItemFoodDish() {
		super(3, 1.0F, false);
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
		// celGingPars//oniGarCorn//ParsGrapeBroc//oniGarCornParGrapeBroc//garTomTom/GarGarTom//PeaPeaTurn/PeaTurnTrun/PeaTurnCab/PeaPeaCab/PeaCabCab
		// CornGingRice//TomGrapeBroc//PinePine(Corn,gin,rice,tom,grape,broc)//WchestWchest(corn/gin/rice/tom/grape/broc)
		// WchestWchestPinePine//grapePineTomRice
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return this.bowlIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.bowlIcon = par1IconRegister.registerIcon("forgottennature:VeggieBowl");
	}

	public ItemStack onEaten(ItemStack itemstack, World par2World, EntityPlayer entityplayer) {
		--itemstack.stackSize;
		entityplayer.getFoodStats().func_151686_a(this, itemstack);
		par2World.playSoundAtEntity(entityplayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);

		if (itemstack.getItemDamage() == 0)// Veggie Bowl (resistance):
											// celGingPars
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 20 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
		} else if (itemstack.getItemDamage() == 1)// Veggie Bowl (speed):
													// oniGarCorn
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3 * 20, 1));
		} else if (itemstack.getItemDamage() == 2)// Veggie Bowl (The Getaway):
													// ParsGrapeBroc
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20 * 20, 2));
			entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 10 * 20, 1));
		} else if (itemstack.getItemDamage() == 3)// Veggie Bowl (Major
													// Fleeing):
													// oniGarCornParGrapeBroc
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 30 * 20, 2));
			entityplayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 15 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 10 * 20, 1));
		} else if (itemstack.getItemDamage() == 4)// Veggie Bowl (Mining):
													// garTomTom/ GarGarTom
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 25 * 20, 2));
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3 * 20, 1));
		} else if (itemstack.getItemDamage() == 5)// Veggie Bowl (Clensing
													// Regen):
													// PeaPeaTurn/PeaTurnTrun/PeaTurnCab/PeaPeaCab/PeaCabCab
		{
			entityplayer.clearActivePotions();
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 10 * 20, 1));
		} else if (itemstack.getItemDamage() == 6)// Veggie Bowl (regen):
													// CornGingRice
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 3));
			entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 5 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10 * 20, 1));
		} else if (itemstack.getItemDamage() == 7)// Veggie Bowl (Regen
													// Berserk): TomGrapeBroc
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 5 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 2));
			entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10 * 20, 1));
		} else if (itemstack.getItemDamage() == 9)// Veggie Bowl (NightEye
													// Regen):
													// PinePine(Corn,gin,rice,tom,grape,broc)
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 15 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2 * 20, 2));
		} else if (itemstack.getItemDamage() == 10)// Veggie Bowl (Amphibious
													// Regen):
													// WchestWchest(corn/gin/rice/tom/grape/broc)
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2 * 20, 2));
			entityplayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 15 * 20, 1));
		} else if (itemstack.getItemDamage() == 11)// Veggie Bowl (Amphibious
													// NightEye):
													// WchestWchestPinePine
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 15 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 4 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 15 * 20, 1));
		} else if (itemstack.getItemDamage() == 12)// Veggie Bowl (Warrior):
													// grapePineTomRice
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 7 * 20, 1));
		}
		entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.bowl));
		// this.onFoodEaten(itemstack, par2World, entityplayer);
		return itemstack;
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item i, CreativeTabs tabs, List list) {
		for (int j = 0; j < 13; j++) {
			if (j == 8)
				j++;
			list.add(new ItemStack(i, 1, j));
		}
	}

	public String getUnlocalizedName(ItemStack i) {
		switch (i.getItemDamage()) {
		case 0:
			return "veggieBowl(resistance)";
		case 1:
			return "veggieBowl(speed)";
		case 2:
			return "veggieBowl(theGetaway)";
		case 3:
			return "veggieBowl(majorFleeing)";
		case 4:
			return "veggieBowl(mining)";
		case 5:
			return "veggieBowl(cleansingRegen)";
		case 6:
			return "veggieBowl(regen)";
		case 7:
			return "veggieBowl(regenBerserk)";
		case 8:
			return "empty";
		case 9:
			return "veggieBowl(nighteyeRegen)";
		case 10:
			return "veggieBowl(amphibiousRegen)";
		case 11:
			return "veggieBowl(amphibiousNighteye)";
		case 12:
			return "veggieBowl(warrior)";
		default:
			return "";
		}
	}
}
