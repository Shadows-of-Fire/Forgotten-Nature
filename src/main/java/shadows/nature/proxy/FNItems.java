package ForgottenNature.Proxy;

import ForgottenNature.Items.*;
import ForgottenNature.ForgottenNature;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class FNItems 
{
//  WOOD(0, 59, 2.0F, 0, 15),
//  STONE(1, 131, 4.0F, 1, 5),
//  IRON(2, 250, 6.0F, 2, 14),
//  EMERALD(3, 1561, 8.0F, 3, 10),
//  GOLD(0, 32, 12.0F, 0, 22);
    public static Item.ToolMaterial saw = EnumHelper.addToolMaterial("Saw", 3, 2000, 10.0F, 2, 14);
    public static Item.ToolMaterial obsidian = EnumHelper.addToolMaterial("Obsidian", 3, 1000, 10.0F, 3, 1);
    public static Item.ToolMaterial titanStone = EnumHelper.addToolMaterial("titanStone", 3, 15000, 25.0F, 4, 22);
	public static Item.ToolMaterial crystal = EnumHelper.addToolMaterial("Crystal", 1, 128, 7.0F, 2, 22);
	public static Item.ToolMaterial darkCrystal = EnumHelper.addToolMaterial("Dark Crystal", 3, 1000, 7.0F, 3, 8);
	
//  CLOTH(5, new int[]{1, 3, 2, 1}, 15),
//  CHAIN(15, new int[]{2, 5, 4, 1}, 12),
//  IRON(15, new int[]{2, 6, 5, 2}, 9),
//  GOLD(7, new int[]{2, 5, 3, 1}, 25),
//  DIAMOND(33, new int[]{3, 8, 6, 3}, 10);
	static ArmorMaterial armorObsidian = EnumHelper.addArmorMaterial("Obsidian", 29, new int[] {3, 7, 5, 3}, 1);
	static ArmorMaterial armorTitanStone = EnumHelper.addArmorMaterial("TitanStone", 50, new int[] {5, 10, 8, 5}, 25);
	
	public static CreativeTabs tab = ForgottenNature.tabFN;
	
	public static Item fruitItems = new ItemFruit().setUnlocalizedName("fruit").setCreativeTab(tab);
	public static Item nutsItems = new ItemNut().setUnlocalizedName("nuts").setCreativeTab(tab);
	public static Item newFoodItem = new ItemNewFood().setUnlocalizedName("newFood").setCreativeTab(tab);
	public static Item newBucketItems = new ItemNewContainer().setUnlocalizedName("newItems").setCreativeTab(tab);
	public static Item cPickaxeItem = new ItemNewPA(crystal).setUnlocalizedName("cPickaxe").setTextureName("forgottennature:PickaxeLightCrystal").setCreativeTab(tab);
	public static Item cAxeItem = new ItemNewAxe(crystal).setUnlocalizedName("cAxe").setTextureName("forgottennature:AxeLightCrystal").setCreativeTab(tab);
	public static Item cShovelItem = new ItemNewShovel(crystal).setUnlocalizedName("cShovel").setTextureName("forgottennature:ShovelLightCrystal").setCreativeTab(tab);
	public static Item cSwordItem = new ItemNewSword(crystal).setUnlocalizedName("cSword").setTextureName("forgottennature:SwordLightCrystal").setCreativeTab(tab);
	public static Item cHoeItem = new ItemNewHoe(crystal).setUnlocalizedName("cHoe").setTextureName("forgottennature:HoeLightCrystal").setCreativeTab(tab);
	public static Item dcPickaxeItem = new ItemNewPA(darkCrystal).setUnlocalizedName("dcPickaxe").setTextureName("forgottennature:PickaxeDarkCrystal").setCreativeTab(tab);
	public static Item dcAxeItem = new ItemNewAxe(darkCrystal).setUnlocalizedName("dcAxe").setTextureName("forgottennature:AxeDarkCrystal").setCreativeTab(tab);
	public static Item dcHoeItem = new ItemNewHoe(darkCrystal).setUnlocalizedName("dcHoe").setTextureName("forgottennature:HoeDarkCrystal").setCreativeTab(tab);
	public static Item dcShovelItem = new ItemNewShovel(darkCrystal).setUnlocalizedName("dcShovel").setTextureName("forgottennature:ShovelDarkCrystal").setCreativeTab(tab);
	public static Item dcSwordItem = new ItemNewSword(darkCrystal).setUnlocalizedName("dcSword").setTextureName("forgottennature:SwordDarkCrystal").setCreativeTab(tab);
	public static Item oPickaxeItem = new ItemNewPA(obsidian).setUnlocalizedName("obsidianPickaxe").setCreativeTab(tab);
	public static Item oAxeItem = new ItemNewAxe(obsidian).setUnlocalizedName("obsidianAxe").setCreativeTab(tab);
	public static Item oHoeItem = new ItemNewHoe(obsidian).setUnlocalizedName("obsidianHoe").setCreativeTab(tab);
	public static Item oShovelItem = new ItemNewShovel(obsidian).setUnlocalizedName("obsidianShovel").setCreativeTab(tab);
	public static Item oSwordItem = new ItemNewSword(obsidian).setUnlocalizedName("obsidianSword").setCreativeTab(tab);
	public static Item titanStonePickaxe = new ItemTitanStonePA(titanStone).setUnlocalizedName("titanStonePickaxe").setCreativeTab(tab);
	public static Item titanStoneSword = new ItemNewSword(titanStone).setUnlocalizedName("titanStoneSword").setCreativeTab(tab);
	public static Item scythe = new ItemScythe(Item.ToolMaterial.IRON).setUnlocalizedName("scythe").setCreativeTab(tab);///
	public static Item crystalItem = new ItemCrystal().setUnlocalizedName("crystal").setCreativeTab(tab);
	public static Item sawItemTool = new ItemSaw(saw).setUnlocalizedName("saw").setTextureName("forgottennature:Saw").setCreativeTab(tab);
	public static Item sawItems = new ItemSawItems().setUnlocalizedName("sawItems").setCreativeTab(tab);
	public static Item powdersItem = new ItemPowder().setUnlocalizedName("powders").setCreativeTab(tab);
	public static Item oreMats1 = new ItemOreMats(15,0).setUnlocalizedName("oreMats1").setCreativeTab(tab);
	public static Item oreMats2 = new ItemOreMats(15,1).setUnlocalizedName("oreMats2").setCreativeTab(tab);
	public static Item oreMats3 = new ItemOreMats(0,2).setUnlocalizedName("oreMats3").setCreativeTab(tab);
	public static Item newFoodItem2 = new ItemNewFood2().setUnlocalizedName("newFood2").setContainerItem(Items.bowl).setCreativeTab(tab);
	public static Item cupItem = new ItemNewCup().setUnlocalizedName("cup").setUnlocalizedName("Cup").setCreativeTab(tab);
	public static Item newFoodItem3 = new ItemNewFood3().setUnlocalizedName("newFood3").setContainerItem(cupItem).setCreativeTab(tab);
	public static Item newSeedItems = new ItemNewCropSeeds(Blocks.farmland).setUnlocalizedName("newSeeds").setCreativeTab(tab);
	public static Item FNFoodItems = new ItemNewCropFood(FNBlocks.kCelOniGar, FNBlocks.turnGinPea, FNBlocks.parsWChestRiceBrocc).setUnlocalizedName("FNFood").setUnlocalizedName("FNFood").setCreativeTab(tab);
	public static Item FNGoodsItem = new ItemNewCropGoods().setUnlocalizedName("FNGoods").setUnlocalizedName("FNGoods").setCreativeTab(tab);
	public static Item FNBowlsItem = new ItemFoodDish().setUnlocalizedName("FNBowls").setContainerItem(Items.bowl).setCreativeTab(tab);
	public static Item carbonItem = new ItemCarbon().setUnlocalizedName("carbonItems").setCreativeTab(tab);
	public static Item ropeItem = new ItemRope().setUnlocalizedName("ropeItem").setCreativeTab(tab);
	public static Item surfaceTeleportItem = new ItemSurfaceTeleport().setUnlocalizedName("surfaceTeleportItem").setCreativeTab(tab);
	
	  //armor 
    public static Item helmetObsidian = (new ItemNewArmor("helmetObsidian", armorObsidian, FNClientProxy.armorObsidian, 0)).setCreativeTab(tab);
    public static Item plateObsidian = (new ItemNewArmor("chestPlateObsidian", armorObsidian, FNClientProxy.armorObsidian, 1)).setCreativeTab(tab);
    public static Item legsObsidian = (new ItemNewArmor("leggingsObsidian", armorObsidian, FNClientProxy.armorObsidian, 2)).setCreativeTab(tab);
    public static Item bootsObsidian = (new ItemNewArmor("bootsObsidian", armorObsidian, FNClientProxy.armorObsidian, 3)).setCreativeTab(tab); 
    public static Item helmetTitanStone = (new ItemNewArmor("helmetTitanStone", armorTitanStone, FNClientProxy.armorTitanStone, 0)).setCreativeTab(tab);
    public static Item plateTitanStone = (new ItemNewArmor("chestPlateTitanStone", armorTitanStone, FNClientProxy.armorTitanStone, 1)).setCreativeTab(tab);
    public static Item legsTitanStone = (new ItemNewArmor("leggingsTitanStone", armorTitanStone, FNClientProxy.armorTitanStone, 2)).setCreativeTab(tab);
    public static Item bootsTitanStone = (new ItemNewArmor("bootsTitanStone", armorTitanStone, FNClientProxy.armorTitanStone, 3)).setCreativeTab(tab);
    
    public FNItems() 
	{
    	registerItems();
	}
    
    public static void registerItems()
	{
    	GameRegistry.registerItem(fruitItems, "fruit");
    	GameRegistry.registerItem(nutsItems, "nuts");
    	
    	if(ForgottenNature.obsidianTools)
    	{
    		GameRegistry.registerItem(oPickaxeItem, "obsidianPickaxe");
        	GameRegistry.registerItem(oAxeItem, "obsidianAxe");
        	GameRegistry.registerItem(oHoeItem, "obsidianHoe");
        	GameRegistry.registerItem(oShovelItem, "obsidianShovel");
        	GameRegistry.registerItem(oSwordItem, "obsidianSword");
        	GameRegistry.registerItem(titanStonePickaxe, "titanStonePickaxe");
        	GameRegistry.registerItem(titanStoneSword, "titanStoneSword");
    	}
    	GameRegistry.registerItem(scythe, "scythe");///
    	GameRegistry.registerItem(newFoodItem, "newFood");
		GameRegistry.registerItem(newBucketItems, "newItems");
		GameRegistry.registerItem(cPickaxeItem, "cPickaxe");
		GameRegistry.registerItem(cAxeItem, "cAxe");
		GameRegistry.registerItem(cShovelItem, "cShovel");
		GameRegistry.registerItem(cSwordItem, "cSword");
		GameRegistry.registerItem(cHoeItem, "cHoe");
		GameRegistry.registerItem(dcPickaxeItem, "dcPickaxe");
		GameRegistry.registerItem(dcAxeItem, "dcAxe");
		GameRegistry.registerItem(dcHoeItem, "dcHoe");
		GameRegistry.registerItem(dcShovelItem, "dcShovel");
		GameRegistry.registerItem(dcSwordItem, "dcSword");
		GameRegistry.registerItem(crystalItem, "crystal");
		GameRegistry.registerItem(sawItemTool, "saw");
		GameRegistry.registerItem(sawItems, "sawItems");
		GameRegistry.registerItem(powdersItem, "powders");
		
		if(ForgottenNature.newOres)
		{
			GameRegistry.registerItem(oreMats1, "oreMats1");
			GameRegistry.registerItem(oreMats2, "oreMats2");
			GameRegistry.registerItem(oreMats3, "oreMats3");
		}
		
		GameRegistry.registerItem(newFoodItem2, "newFood2");
		GameRegistry.registerItem(cupItem, "cup");
		GameRegistry.registerItem(newFoodItem3, "newFood3");
		GameRegistry.registerItem(newSeedItems, "newSeeds");
		GameRegistry.registerItem(FNFoodItems, "FNFood");
		GameRegistry.registerItem(FNGoodsItem, "FNGoods");
		GameRegistry.registerItem(FNBowlsItem, "FNBowls");
		GameRegistry.registerItem(carbonItem, "carbonItems");
		GameRegistry.registerItem(ropeItem, "ropeItem");
		GameRegistry.registerItem(surfaceTeleportItem, "surfaceTeleportItem");
		
		GameRegistry.registerItem(helmetObsidian, "helmetObsidian");
		GameRegistry.registerItem(plateObsidian, "chestPlateObsidian");
		GameRegistry.registerItem(legsObsidian, "leggingsObsidian");
		GameRegistry.registerItem(bootsObsidian, "bootsObsidian");
		GameRegistry.registerItem(helmetTitanStone, "helmetTitanStone");
		GameRegistry.registerItem(plateTitanStone, "chestPlateTitanStone");
		GameRegistry.registerItem(legsTitanStone, "leggingsTitanStone");
		GameRegistry.registerItem(bootsTitanStone, "bootsTitanStone");
	}
}
