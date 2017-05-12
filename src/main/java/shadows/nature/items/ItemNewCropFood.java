package shadows.nature.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNBlocks;

public class ItemNewCropFood extends ItemFood {
	@SideOnly(Side.CLIENT)
	private IIcon[] cropFoodIcons;

	private Block oniGar;
	private Block pTGinger;
	private Block wChestnut;

	public ItemNewCropFood(Block kCelOniGar, Block turnGinPea, Block parsWChestRiceBrocc) {
		super(1, 0.2F, false);
		oniGar = kCelOniGar;
		pTGinger = turnGinPea;
		wChestnut = parsWChestRiceBrocc;
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return this.cropFoodIcons[i];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.cropFoodIcons = new IIcon[16];

		this.cropFoodIcons[0] = par1IconRegister.registerIcon("forgottennature:CropCelery");
		this.cropFoodIcons[1] = par1IconRegister.registerIcon("forgottennature:CropOnion");
		this.cropFoodIcons[2] = par1IconRegister.registerIcon("forgottennature:CropGarlic");
		this.cropFoodIcons[3] = par1IconRegister.registerIcon("forgottennature:CropCorn");
		this.cropFoodIcons[4] = par1IconRegister.registerIcon("forgottennature:CropPeanuts");
		this.cropFoodIcons[5] = par1IconRegister.registerIcon("forgottennature:CropTurnip");
		this.cropFoodIcons[6] = par1IconRegister.registerIcon("forgottennature:CropGinger");
		this.cropFoodIcons[7] = par1IconRegister.registerIcon("forgottennature:CropParsley");
		this.cropFoodIcons[9] = par1IconRegister.registerIcon("forgottennature:CropWaterChestnut");
		this.cropFoodIcons[10] = par1IconRegister.registerIcon("forgottennature:CropRice");
		this.cropFoodIcons[11] = par1IconRegister.registerIcon("forgottennature:CropTomato");
		this.cropFoodIcons[12] = par1IconRegister.registerIcon("forgottennature:CropCabbage");
		this.cropFoodIcons[13] = par1IconRegister.registerIcon("forgottennature:CropPineapple");
		this.cropFoodIcons[14] = par1IconRegister.registerIcon("forgottennature:CropGrapes");
		this.cropFoodIcons[15] = par1IconRegister.registerIcon("forgottennature:CropBroccoli");
	}

	public ItemStack onEaten(ItemStack itemstack, World par2World, EntityPlayer entityplayer) {
		--itemstack.stackSize;
		entityplayer.getFoodStats().func_151686_a(this, itemstack);
		par2World.playSoundAtEntity(entityplayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);

		if (itemstack.getItemDamage() == 0)// celery
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 10 * 20, 2));
		} else if (itemstack.getItemDamage() == 1)// onion
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 2));
		} else if (itemstack.getItemDamage() == 2)// garlic
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 10 * 20, 1));
		} else if (itemstack.getItemDamage() == 3)// Corn
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
		} else if (itemstack.getItemDamage() == 4)// Peanuts
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2 * 20, 1));
		} else if (itemstack.getItemDamage() == 5)// turnips
		{
			entityplayer.clearActivePotions();
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2 * 20, 1));
		} else if (itemstack.getItemDamage() == 6)// ginger
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 10 * 20, 1));
		} else if (itemstack.getItemDamage() == 7)// parsley
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 10 * 20, 1));
		} else if (itemstack.getItemDamage() == 9)// WChestnut
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 10 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
		} else if (itemstack.getItemDamage() == 10)// rice
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
		} else if (itemstack.getItemDamage() == 11)// tomatoes
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 7 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 7 * 20, 1));
		} else if (itemstack.getItemDamage() == 12)// cabbage
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 2));
		} else if (itemstack.getItemDamage() == 13)// pineapples
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 10 * 20, 1));
		} else if (itemstack.getItemDamage() == 14)// grapes
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
		} else if (itemstack.getItemDamage() == 15)// broccoli
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 2));
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 2));
		}
		return itemstack;
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer par2EntityPlayer, World world, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		if (par7 != 1)
			return false;
		else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, itemstack)
				&& par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, itemstack)) {
			Block var8 = world.getBlock(par4, par5, par6);
			if (var8 == Blocks.farmland && world.isAirBlock(par4, par5 + 1, par6)) {
				if (itemstack.getItemDamage() == 1)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.kCelOniGar, 4, 3);// onion
				else if (itemstack.getItemDamage() == 2)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.kCelOniGar, 8, 3);// garlic
				else if (itemstack.getItemDamage() == 4)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.turnGinPea, 0, 3);// peanuts
				else if (itemstack.getItemDamage() == 5)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.turnGinPea, 4, 3);// turnip
				else if (itemstack.getItemDamage() == 6)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.turnGinPea, 8, 3);// ginger
				else if (itemstack.getItemDamage() == 9)
					world.setBlock(par4, par5 + 1, par6, FNBlocks.parsWChestRiceBrocc, 8, 3);// wchestnut
				--itemstack.stackSize;
				return true;
			} else
				return false;
		} else
			return false;
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item i, CreativeTabs tabs, List list) {
		for (int j = 0; j < 16; j++) {
			if (j == 8)
				j++;
			list.add(new ItemStack(i, 1, j));
		}
	}

	public String getUnlocalizedName(ItemStack i) {
		switch (i.getItemDamage()) {
		case 0:
			return "knobCSticks";
		case 1:
			return "onionBulb";
		case 2:
			return "garlicBulb";
		case 3:
			return "cornEar";
		case 4:
			return "peanuts";
		case 5:
			return "turnip";
		case 6:
			return "ginger";
		case 7:
			return "parsley";
		case 8:
			return "cotton";
		case 9:
			return "waterChestnut";
		case 10:
			return "rice";
		case 11:
			return "tomato";
		case 12:
			return "cabbage";
		case 13:
			return "pineapple";
		case 14:
			return "grapes";
		case 15:
			return "broccoli";
		default:
			return "";
		}
	}
}