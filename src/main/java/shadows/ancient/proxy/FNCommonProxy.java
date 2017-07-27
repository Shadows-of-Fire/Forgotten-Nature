package shadows.nature.Proxy;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockWoodSlab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import shadows.ancient.FNBlocks;
import shadows.ancient.FNFuelHandler;
import shadows.ancient.FNItems;
import shadows.ancient.ForgottenNature;
import shadows.ancient.biomes.BiomeGenCherryBlossomWoodland;
import shadows.ancient.biomes.BiomeGenCrystalForest;
import shadows.ancient.biomes.BiomeGenEucalyptusForest;
import shadows.ancient.biomes.BiomeGenGreatwoodForest;
import shadows.ancient.biomes.BiomeGenMapleForest;
import shadows.ancient.biomes.BiomeGenRedwoodForest;
import shadows.ancient.biomes.BiomeGenRedwoodForestHills;
import shadows.ancient.biomes.BiomeGenTropicalForest;
import shadows.ancient.biomes.BiomeGenTropicalForestHills;
import shadows.ancient.gen.FNWorldGenerator;

public class FNCommonProxy implements IGuiHandler {
	static Block newF = FNBlocks.fNFlowers;
	static Block newPlanks = FNBlocks.newPlanks1;
	static Block newPlanks2 = FNBlocks.newPlanks2;
	static Block newLogs = FNBlocks.newLogs1;
	static Block newLogs2 = FNBlocks.newLogs2;
	static Block newLogs3 = FNBlocks.newLogs3;
	static Block newSap = FNBlocks.fNSapling1;
	static Block newSap2 = FNBlocks.fNSapling2;
	static Block newSap3 = FNBlocks.fNSapling3;
	static Block newTorch = FNBlocks.newTorch;
	static Block crystalWood = FNBlocks.crystalWood;
	static Block crystalLeaves = FNBlocks.crystalLeaves;
	static Block newStones = FNBlocks.newStones;
	static Block blockCrystal = FNBlocks.crystalBlock;
	static Block crystalStone = FNBlocks.crystalStone;
	static Block newGlass = FNBlocks.FNGlass;
	static Block fence = FNBlocks.newFence;
	static Block sStairs1 = FNBlocks.newStoneStairs1;
	static Block sStairs2 = FNBlocks.newStoneStairs2;
	static Block sStairs3 = FNBlocks.newStoneStairs3;
	static Block sStairs4 = FNBlocks.newStoneStairs4;
	static Item newFoodDish = FNItems.FNBowlsItem;
	static Item newCropFood = FNItems.FNFoodItems;
	static Item newCropGoods = FNItems.FNGoodsItem;
	static BlockSlab halfStone = FNBlocks.newHalfStone;
	static Item sawItem = FNItems.sawItems;
	static Item sawTool = FNItems.sawItemTool;
	static BlockWoodSlab halfPlank = FNBlocks.newHalfPlanks1;
	static BlockWoodSlab halfPlank2 = FNBlocks.newHalfPlanks2;
	static Item ItemFruit = FNItems.fruitItems;
	static Item ItemNuts = FNItems.nutsItems;
	static Item ItemNewFood = FNItems.newFoodItem;
	static Item ItemNewFood2 = FNItems.newFoodItem2;
	static Item ItemNewFood3 = FNItems.newFoodItem3;
	static Item crystalItem = FNItems.crystalItem;
	static Item crystalToolIndex;
	static Item ItemNewCup = FNItems.cupItem;
	static Item ItemNewContainer = FNItems.newBucketItems;
	static Item carbonStuff = FNItems.carbonItem;
	static Item oPickaxe = FNItems.oPickaxeItem;
	static Item oAxe = FNItems.oAxeItem;
	static Item oHoe = FNItems.oHoeItem;
	static Item oShovel = FNItems.oShovelItem;
	static Item oSword = FNItems.oSwordItem;
	static Item tPickaxe = FNItems.titanStonePickaxe;
	static Item tSword = FNItems.titanStoneSword;
	static Item powders = FNItems.powdersItem;

	public static BiomeGenBase neoTropicalForest;
	public static BiomeGenBase neoRedwoodForest;
	public static BiomeGenBase neoTropicalForestHills;
	public static BiomeGenBase neoRedwoodForestHills;
	public static BiomeGenBase neoRedwoodForestSnowHills;
	public static BiomeGenBase neoRedwoodForestSnow;
	public static BiomeGenBase crystalForest;
	public static BiomeGenBase greatwoodForest;
	public static BiomeGenBase mapleForest;
	public static BiomeGenBase cherryBlossomWoodland;
	public static BiomeGenBase eucalyptusForest;

	public void registerWorldStuff(int biomeIDIndex, boolean tForest, boolean rwForest, boolean tForestHill, boolean rwForestHill, boolean cForest, boolean gForest, boolean mForest, boolean cBWoodland, boolean eForest) {
		addVillages();
		GameRegistry.registerFuelHandler(new FNFuelHandler());
		GameRegistry.registerWorldGenerator(new FNWorldGenerator(), 3);

		GameRegistry.addSmelting(FNBlocks.newLogs1, new ItemStack(Items.coal, 1, 1), 1);
		GameRegistry.addSmelting(FNBlocks.newLogs2, new ItemStack(Items.coal, 1, 1), 1);
		GameRegistry.addSmelting(FNBlocks.newLogs3, new ItemStack(Items.coal, 1, 1), 1);

		// add seeds to tall grass
		for (int x = 0; x < 11; x++) {
			MinecraftForge.addGrassSeed(new ItemStack(Item.getItemById(Item.getIdFromItem(FNItems.newSeedItems)), 1, x), ForgottenNature.newSeedWeight);
		}
		MinecraftForge.addGrassSeed(new ItemStack(Item.getItemById(Item.getIdFromItem(FNItems.FNFoodItems)), 1, 1), ForgottenNature.newSeedWeight);
		MinecraftForge.addGrassSeed(new ItemStack(Item.getItemById(Item.getIdFromItem(FNItems.FNFoodItems)), 1, 2), ForgottenNature.newSeedWeight);
		MinecraftForge.addGrassSeed(new ItemStack(Item.getItemById(Item.getIdFromItem(FNItems.FNFoodItems)), 1, 4), ForgottenNature.newSeedWeight);
		MinecraftForge.addGrassSeed(new ItemStack(Item.getItemById(Item.getIdFromItem(FNItems.FNFoodItems)), 1, 5), ForgottenNature.newSeedWeight);
		MinecraftForge.addGrassSeed(new ItemStack(Item.getItemById(Item.getIdFromItem(FNItems.FNFoodItems)), 1, 6), ForgottenNature.newSeedWeight);
		MinecraftForge.addGrassSeed(new ItemStack(Item.getItemById(Item.getIdFromItem(FNItems.FNFoodItems)), 1, 9), ForgottenNature.newSeedWeight);

		// flowers to be planted when bonemeal is used on grass
		for (int i = 0; i < 10; i++) {
			BiomeGenBase.forestHills.addFlower(newF, i, 10);
			BiomeGenBase.forest.addFlower(newF, i, 10);
			BiomeGenBase.birchForest.addFlower(newF, i, 10);
			BiomeGenBase.birchForestHills.addFlower(newF, i, 10);
			BiomeGenBase.plains.addFlower(newF, i, 10);
		}

		neoTropicalForest = (new BiomeGenTropicalForest(biomeIDIndex));
		neoTropicalForestHills = (new BiomeGenTropicalForestHills(biomeIDIndex + 1));
		neoRedwoodForest = (new BiomeGenRedwoodForest(biomeIDIndex + 2));
		neoRedwoodForestHills = (new BiomeGenRedwoodForestHills(biomeIDIndex + 3));
		crystalForest = (new BiomeGenCrystalForest(biomeIDIndex + 4));
		greatwoodForest = (new BiomeGenGreatwoodForest(biomeIDIndex + 5));
		mapleForest = (new BiomeGenMapleForest(biomeIDIndex + 6));
		cherryBlossomWoodland = (new BiomeGenCherryBlossomWoodland(biomeIDIndex + 8));
		eucalyptusForest = (new BiomeGenEucalyptusForest(biomeIDIndex + 9));

		if (gForest) {
			BiomeDictionary.registerBiomeType(greatwoodForest, Type.FOREST);
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(greatwoodForest, 10));
			BiomeManager.addSpawnBiome(greatwoodForest);
		}
		if (mForest) {
			BiomeDictionary.registerBiomeType(mapleForest, Type.FOREST);
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(mapleForest, 10));
			BiomeManager.addSpawnBiome(mapleForest);
		}
		if (cBWoodland) {
			BiomeDictionary.registerBiomeType(cherryBlossomWoodland, Type.FOREST);
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(cherryBlossomWoodland, 10));
			BiomeManager.addSpawnBiome(cherryBlossomWoodland);
		}
		if (eForest) {
			BiomeDictionary.registerBiomeType(eucalyptusForest, Type.FOREST);
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(eucalyptusForest, 10));
			BiomeManager.addSpawnBiome(eucalyptusForest);
		}
		if (tForest) {
			BiomeDictionary.registerBiomeType(neoTropicalForest, Type.FOREST);
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(neoTropicalForest, 10));
			BiomeManager.addSpawnBiome(neoTropicalForest);
		}
		if (rwForest) {
			BiomeDictionary.registerBiomeType(neoRedwoodForest, Type.FOREST);
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(neoRedwoodForest, 10));
			BiomeManager.addSpawnBiome(neoRedwoodForest);
		}
		if (tForestHill) {
			BiomeDictionary.registerBiomeType(neoTropicalForestHills, Type.FOREST);
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(neoTropicalForestHills, 10));
			BiomeManager.addSpawnBiome(neoTropicalForestHills);
		}
		if (rwForestHill) {
			BiomeDictionary.registerBiomeType(neoRedwoodForestHills, Type.FOREST);
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(neoRedwoodForestHills, 10));
			BiomeManager.addSpawnBiome(neoRedwoodForestHills);
		}
		if (cForest) {
			BiomeDictionary.registerBiomeType(crystalForest, Type.FOREST);
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(crystalForest, 10));
			BiomeManager.addSpawnBiome(crystalForest);
		}
	}

	public static void addVillages() {
		enableVillageSpawnBiomeChanges();
		MapGenVillage.villageSpawnBiomes.add(neoTropicalForest);
		MapGenVillage.villageSpawnBiomes.add(neoTropicalForestHills);
		MapGenVillage.villageSpawnBiomes.add(neoRedwoodForestHills);
		MapGenVillage.villageSpawnBiomes.add(neoRedwoodForest);
		MapGenVillage.villageSpawnBiomes.add(neoRedwoodForestSnowHills);
		MapGenVillage.villageSpawnBiomes.add(neoRedwoodForestSnow);
		MapGenVillage.villageSpawnBiomes.add(crystalForest);
	}

	private static void enableVillageSpawnBiomeChanges() {
		final List<BiomeGenBase> villageSpawnBiomes = new ArrayList();
		villageSpawnBiomes.addAll(MapGenVillage.villageSpawnBiomes);
		Field field = MapGenVillage.class.getDeclaredFields()[0];
		field.setAccessible(true);
		// Make the field non final and set it
		try {
			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

			field.set(null, villageSpawnBiomes);
		} catch (Exception e) {
			FMLLog.log(Level.ERROR, e, "Could not access village spawn biomes.");
			;
		}
	}

	public static void newRecipes() {
		{// for saplings
			GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.fNSapling1, 2, 6), new Object[] { new ItemStack(Item.getItemById(260), 1) });// apple
																																				// saps
			GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.fNSapling1, 2, 1), new Object[] { new ItemStack(ItemFruit, 1, 4) });// cherry
																																		// saps
			GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.fNSapling2, 2, 3), new Object[] { new ItemStack(ItemNuts, 1, 0) });// ginkgo
																																		// saps
			GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.fNSapling2, 2, 6), new Object[] { new ItemStack(ItemNuts, 1, 1) });// walnut
																																		// saps
			GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.fNSapling2, 2, 11), new Object[] { new ItemStack(ItemFruit, 1, 2) });// orange
																																		// saps
			GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.fNSapling2, 2, 12), new Object[] { new ItemStack(ItemFruit, 1, 3) });// peach
																																		// saps
			GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.fNSapling2, 2, 13), new Object[] { new ItemStack(ItemFruit, 1, 9) });// lemon
																																		// saps
			GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.fNSapling2, 2, 14), new Object[] { new ItemStack(ItemFruit, 1, 7) });// blueberry
																																		// saps
			GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.fNSapling2, 2, 15), new Object[] { new ItemStack(ItemFruit, 1, 8) });// raspberry
																																		// saps
			GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.fNSapling3, 2, 1), new Object[] { new ItemStack(ItemFruit, 1, 5) });// blackberry
																																		// saps
			GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.fNSapling3, 2, 0), new Object[] { new ItemStack(ItemFruit, 1, 6) });// huckleberry
																																		// saps
		}

		{// obsidian tools and armor. titanStone tools
			if (ForgottenNature.obsidianTools) {
				// titan stone
				GameRegistry.addRecipe(new ItemStack(FNBlocks.newStones, 1, 9), new Object[] { "&*&", "*%*", "&*&", '&', new ItemStack(Block.getBlockById(89), 1, 0), '*', new ItemStack(FNBlocks.crystalBlock, 1, 1), '%', new ItemStack(Item.getItemById(381), 1, 0) });// titanstone
																																																																			// from
																																																																			// glowstone
																																																																			// and
																																																																			// endereye
																																																																			// obsidian and titan
				GameRegistry.addRecipe(new ItemStack(FNItems.helmetObsidian, 1, 0), new Object[] { "&&&", "& &", "   ", '&', new ItemStack(Block.getBlockById(49), 1, 0) });// obsidianhelm
				GameRegistry.addRecipe(new ItemStack(FNItems.helmetObsidian, 1, 0), new Object[] { "   ", "&&&", "& &", '&', new ItemStack(Block.getBlockById(49), 1, 0) });// obsidianhelm
				GameRegistry.addRecipe(new ItemStack(FNItems.plateObsidian, 1, 0), new Object[] { "& &", "&&&", "&&&", '&', new ItemStack(Block.getBlockById(49), 1, 0) });// obsidianplate
				GameRegistry.addRecipe(new ItemStack(FNItems.legsObsidian, 1, 0), new Object[] { "&&&", "& &", "& &", '&', new ItemStack(Block.getBlockById(49), 1, 0) });// obsidianpants
				GameRegistry.addRecipe(new ItemStack(FNItems.bootsObsidian, 1, 0), new Object[] { "   ", "& &", "& &", '&', new ItemStack(Block.getBlockById(49), 1, 0) });// obsidianboots
				GameRegistry.addRecipe(new ItemStack(FNItems.bootsObsidian, 1, 0), new Object[] { "& &", "& &", "   ", '&', new ItemStack(Block.getBlockById(49), 1, 0) });// obsidianboots
				GameRegistry.addRecipe(new ItemStack(FNItems.helmetTitanStone, 1, 0), new Object[] { "&&&", "& &", "   ", '&', new ItemStack(FNBlocks.newStones, 1, 9) });// titanstonehelm
				GameRegistry.addRecipe(new ItemStack(FNItems.helmetTitanStone, 1, 0), new Object[] { "   ", "&&&", "& &", '&', new ItemStack(FNBlocks.newStones, 1, 9) });// titanstonehelm
				GameRegistry.addRecipe(new ItemStack(FNItems.plateTitanStone, 1, 0), new Object[] { "& &", "&&&", "&&&", '&', new ItemStack(FNBlocks.newStones, 1, 9) });// titanstoneplate
				GameRegistry.addRecipe(new ItemStack(FNItems.legsTitanStone, 1, 0), new Object[] { "&&&", "& &", "& &", '&', new ItemStack(FNBlocks.newStones, 1, 9) });// titanstonepants
				GameRegistry.addRecipe(new ItemStack(FNItems.bootsTitanStone, 1, 0), new Object[] { "   ", "& &", "& &", '&', new ItemStack(FNBlocks.newStones, 1, 9) });// titanstoneboots
				GameRegistry.addRecipe(new ItemStack(FNItems.bootsTitanStone, 1, 0), new Object[] { "& &", "& &", "   ", '&', new ItemStack(FNBlocks.newStones, 1, 9) });// titanstoneboots

				GameRegistry.addRecipe(new ItemStack(oPickaxe, 1, 0), new Object[] { "&&&", " s ", " s ", '&', new ItemStack(Block.getBlockById(49), 1, 0), 's', new ItemStack(Item.getItemById(280), 1) });// obsidianPa
																																																			// from
																																																			// stick
				GameRegistry.addRecipe(new ItemStack(oHoe, 1, 0), new Object[] { "&& ", " s ", " s ", '&', new ItemStack(Block.getBlockById(49), 1, 0), 's', new ItemStack(Item.getItemById(280), 1) });// obsidianHoe
																																																		// from
																																																		// stick
				GameRegistry.addRecipe(new ItemStack(oHoe, 1, 0), new Object[] { " &&", " s ", " s ", '&', new ItemStack(Block.getBlockById(49), 1, 0), 's', new ItemStack(Item.getItemById(280), 1) });// obsidianHoe
																																																		// from
																																																		// stick
				GameRegistry.addRecipe(new ItemStack(oAxe, 1, 0), new Object[] { "&& ", "&s ", " s ", '&', new ItemStack(Block.getBlockById(49), 1, 0), 's', new ItemStack(Item.getItemById(280), 1) });// obsidianAxe
																																																		// from
																																																		// stick
				GameRegistry.addRecipe(new ItemStack(oAxe, 1, 0), new Object[] { " &&", " s&", " s ", '&', new ItemStack(Block.getBlockById(49), 1, 0), 's', new ItemStack(Item.getItemById(280), 1) });// obsidianAxe
																																																		// from
																																																		// stick
				GameRegistry.addRecipe(new ItemStack(oShovel, 1, 0), new Object[] { " & ", " s ", " s ", '&', new ItemStack(Block.getBlockById(49), 1, 0), 's', new ItemStack(Item.getItemById(280), 1) });// obsidianShovel
																																																			// from
																																																			// stick
				GameRegistry.addRecipe(new ItemStack(oSword, 1, 0), new Object[] { " & ", " & ", " s ", '&', new ItemStack(Block.getBlockById(49), 1, 0), 's', new ItemStack(Item.getItemById(280), 1) });// obsidianSword
																																																			// from
																																																			// stick
				GameRegistry.addRecipe(new ItemStack(tPickaxe, 1, 0), new Object[] { "&&&", " s ", " s ", '&', new ItemStack(FNBlocks.newStones, 1, 9), 's', new ItemStack(Block.getBlockById(57), 1, 0) });// tsPa
																																																			// from
																																																			// titan(edge)
																																																			// diamond
																																																			// block(hilt)
				GameRegistry.addRecipe(new ItemStack(tSword, 1, 0), new Object[] { " & ", " & ", " s ", '&', new ItemStack(FNBlocks.newStones, 1, 9), 's', new ItemStack(Block.getBlockById(57), 1, 0) });// tsSword
																																																			// from
																																																			// titan(edge)
																																																			// diamond
																																																			// block(hilt)
			}
			GameRegistry.addRecipe(new ItemStack(FNItems.scythe, 1, 0), new Object[] { "&&s", " s&", "s  ", '&', new ItemStack(Items.iron_ingot, 1, 0), 's', new ItemStack(Items.stick, 1, 0) });// scythe
		}
		if (ForgottenNature.carbonItems) {// carbon recipes
			GameRegistry.addRecipe(new ItemStack(carbonStuff, 1, 0), new Object[] { "&&&", "&G&", "&&&", '&', new ItemStack(Item.getItemById(263), 1, 0), 'G', new ItemStack(Item.getItemById(318), 1) });// coal
																																																			// chunk
																																																			// from
																																																			// coal
																																																			// and
																																																			// flint
			GameRegistry.addRecipe(new ItemStack(carbonStuff, 1, 0), new Object[] { "&&&", "&G&", "&&&", '&', new ItemStack(Item.getItemById(263), 1, 1), 'G', new ItemStack(Item.getItemById(318), 1) });// coal
																																																			// chunk
																																																			// from
																																																			// charcoal
																																																			// and
																																																			// flint
			GameRegistry.addRecipe(new ItemStack(carbonStuff, 1, 1), new Object[] { "&&&", "&G&", "&&&", '&', new ItemStack(carbonStuff, 1, 0), 'G', new ItemStack(Block.getBlockById(49), 1) });// compressed
																																																	// coal
																																																	// chunk
																																																	// from
																																																	// coal
																																																	// chunk
																																																	// and
																																																	// obsidian
			GameRegistry.addRecipe(new ItemStack(Item.getItemById(264), 1), new Object[] { "&&&", "&&&", "&&&", '&', new ItemStack(carbonStuff, 1, 1) });// diamond
			GameRegistry.addRecipe(new ItemStack(carbonStuff, 6, 2), new Object[] { "&&&", "GGG", "&&&", '&', new ItemStack(Item.getItemById(287), 1), 'G', new ItemStack(Item.getItemById(263), 1, 0) });// carbon
																																																			// wafers
																																																			// from
																																																			// string
																																																			// and
																																																			// coal
			GameRegistry.addRecipe(new ItemStack(carbonStuff, 6, 2), new Object[] { "&&&", "GGG", "&&&", '&', new ItemStack(Item.getItemById(287), 1), 'G', new ItemStack(Item.getItemById(263), 1, 1) });// carbon
																																																			// wafers
																																																			// from
																																																			// string
																																																			// and
																																																			// charcoal
			GameRegistry.addRecipe(new ItemStack(Item.getItemById(262), 4), new Object[] { " f ", " s ", "&&&", '&', new ItemStack(carbonStuff, 1, 2), 's', new ItemStack(Item.getItemById(280), 1), 'f', new ItemStack(Item.getItemById(318), 1) });// arrows
																																																														// from
																																																														// wafers
																																																														// and
																																																														// flint
		}
		{// convenience recipes
			GameRegistry.addRecipe(new ItemStack(Item.getItemById(348), 8), new Object[] { "&&&", "&G&", "&&&", '&', new ItemStack(Item.getItemById(331), 1), 'G', new ItemStack(Item.getItemById(266), 1) });// easierGlowstone
																																																				// from
																																																				// redstone
																																																				// and
																																																				// gold
																																																				// ingot
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(318), 2), new Object[] { new ItemStack(Block.getBlockById(13), 1), new ItemStack(Block.getBlockById(13), 1), new ItemStack(Block.getBlockById(13), 1), new ItemStack(Block.getBlockById(13), 1) });// flint
																																																																				// from
																																																																				// gravel
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(280), 4), new Object[] { new ItemStack(Item.getItemById(352), 1), new ItemStack(Item.getItemById(352), 1) });// stick
																																														// from
																																														// bones
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(280), 1), new Object[] { new ItemStack(Block.getBlockById(6), 1, 0) });// stick
																																					// from
																																					// sapling
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(280), 1), new Object[] { new ItemStack(Block.getBlockById(6), 1, 1) });// stick
																																					// from
																																					// sapling
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(280), 1), new Object[] { new ItemStack(Block.getBlockById(6), 1, 2) });// stick
																																					// from
																																					// sapling
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(280), 1), new Object[] { new ItemStack(Block.getBlockById(6), 1, 3) });// stick
																																					// from
																																					// sapling
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(280), 1), new Object[] { new ItemStack(Block.getBlockById(6), 1, 4) });// stick
																																					// from
																																					// sapling
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(280), 1), new Object[] { new ItemStack(Block.getBlockById(6), 1, 5) });// stick
																																					// from
																																					// sapling
			for (int n = 0; n < 16; n++) {
				GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(280), 1), new Object[] { new ItemStack(newSap, 1, n) });// stick
				GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(280), 1), new Object[] { new ItemStack(newSap2, 1, n) });// stick
				GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(280), 1), new Object[] { new ItemStack(newSap3, 1, n) });// stick
			}
			GameRegistry.addRecipe(new ItemStack(Block.getBlockById(49), 8), new Object[] { "&&&", "&G&", "&&&", '&', new ItemStack(Item.getItemById(327), 1), 'G', new ItemStack(Item.getItemById(326), 1) });// easierObsidian
																																																				// from
																																																				// buckets
			GameRegistry.addShapelessRecipe(new ItemStack(Block.getBlockById(79), 1), new Object[] { new ItemStack(Block.getBlockById(80), 1), new ItemStack(Block.getBlockById(80), 1), new ItemStack(Block.getBlockById(80), 1), new ItemStack(Block.getBlockById(80), 1) });// ice
																																																																				// from
																																																																				// snow
			GameRegistry.addRecipe(new ItemStack(Block.getBlockById(110), 1), new Object[] { "&&&", "&G&", "&&&", '&', new ItemStack(Block.getBlockById(39), 1), 'G', new ItemStack(Block.getBlockById(3), 1) });// mycelium
																																																					// from
																																																					// mushroom
																																																					// and
																																																					// dirt

		}
		{// veggie bowls
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 0), new Object[] { new ItemStack(newCropFood, 1, 0), new ItemStack(newCropFood, 1, 6), new ItemStack(newCropFood, 1, 7), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 1), new Object[] { new ItemStack(newCropFood, 1, 1), new ItemStack(newCropFood, 1, 2), new ItemStack(newCropFood, 1, 3), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 2), new Object[] { new ItemStack(newCropFood, 1, 7), new ItemStack(newCropFood, 1, 14), new ItemStack(newCropFood, 1, 15), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 3), new Object[] { new ItemStack(newCropFood, 1, 1), new ItemStack(newCropFood, 1, 2), new ItemStack(newCropFood, 1, 3), new ItemStack(newCropFood, 1, 7), new ItemStack(newCropFood, 1, 14), new ItemStack(newCropFood, 1, 15), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 4), new Object[] { new ItemStack(newCropFood, 1, 2), new ItemStack(newCropFood, 1, 11), new ItemStack(newCropFood, 1, 11), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 4), new Object[] { new ItemStack(newCropFood, 1, 2), new ItemStack(newCropFood, 1, 2), new ItemStack(newCropFood, 1, 11), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 5), new Object[] { new ItemStack(newCropFood, 1, 4), new ItemStack(newCropFood, 1, 4), new ItemStack(newCropFood, 1, 5), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 5), new Object[] { new ItemStack(newCropFood, 1, 4), new ItemStack(newCropFood, 1, 5), new ItemStack(newCropFood, 1, 5), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 5), new Object[] { new ItemStack(newCropFood, 1, 4), new ItemStack(newCropFood, 1, 5), new ItemStack(newCropFood, 1, 12), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 5), new Object[] { new ItemStack(newCropFood, 1, 4), new ItemStack(newCropFood, 1, 4), new ItemStack(newCropFood, 1, 12), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 5), new Object[] { new ItemStack(newCropFood, 1, 4), new ItemStack(newCropFood, 1, 12), new ItemStack(newCropFood, 1, 12), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 6), new Object[] { new ItemStack(newCropFood, 1, 3), new ItemStack(newCropFood, 1, 6), new ItemStack(newCropFood, 1, 10), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 7), new Object[] { new ItemStack(newCropFood, 1, 11), new ItemStack(newCropFood, 1, 14), new ItemStack(newCropFood, 1, 15), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 9), new Object[] { new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 3), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 9), new Object[] { new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 6), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 9), new Object[] { new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 10), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 9), new Object[] { new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 11), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 9), new Object[] { new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 14), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 9), new Object[] { new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 15), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 10), new Object[] { new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 3), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 10), new Object[] { new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 6), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 10), new Object[] { new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 10), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 10), new Object[] { new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 11), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 10), new Object[] { new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 14), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 10), new Object[] { new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 15), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 11), new Object[] { new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 9), new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 13), new ItemStack(Item.getItemById(281), 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newFoodDish, 1, 12), new Object[] { new ItemStack(newCropFood, 1, 10), new ItemStack(newCropFood, 1, 11), new ItemStack(newCropFood, 1, 13), new ItemStack(newCropFood, 1, 14), new ItemStack(Item.getItemById(281), 1) });
			// fruit stuff
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {
					if (x != y) {
						GameRegistry.addShapelessRecipe(new ItemStack(ItemNewFood3, 1, 2), new Object[] { new ItemStack(ItemNewCup, 1, 0), new ItemStack(ItemFruit, 1, x), new ItemStack(ItemFruit, 1, y) });// juice
						GameRegistry.addShapelessRecipe(new ItemStack(ItemNewFood3, 1, 1), new Object[] { Item.getItemById(332), new ItemStack(ItemNewCup, 1, 0), new ItemStack(ItemFruit, 1, x), new ItemStack(ItemFruit, 1, y) });// smoothie
																																																									// from
																																																									// snowball
						GameRegistry.addShapelessRecipe(new ItemStack(ItemNewFood2, 1, 0), new Object[] { Item.getItemById(281), new ItemStack(ItemFruit, 1, x), new ItemStack(ItemFruit, 1, y), new ItemStack(Item.getItemById(260), 1) });// fruit
																																																											// salad
					}
					if (y < 3)
						GameRegistry.addShapelessRecipe(new ItemStack(ItemNewFood, 1, 4), new Object[] { Item.getItemById(297), new ItemStack(ItemFruit, 1, x), new ItemStack(ItemNuts, 1, y) });// fruit-nut
																																																	// bread
					for (int z = 0; z < 10; z++) {
						if (x != y) {
							if (y != z && x != z)
								GameRegistry.addShapelessRecipe(new ItemStack(ItemNewFood2, 1, 0), new Object[] { Item.getItemById(281), new ItemStack(ItemFruit, 1, x), new ItemStack(ItemFruit, 1, y), new ItemStack(ItemFruit, 1, z) });// fruit
																																																											// salad
							if (z < 3)
								GameRegistry.addShapelessRecipe(new ItemStack(ItemNewFood2, 1, 1), new Object[] { Item.getItemById(281), new ItemStack(ItemFruit, 1, x), new ItemStack(ItemFruit, 1, y), new ItemStack(ItemNuts, 1, z) });// frui-nut
																																																											// salad
						}
					}
				}
			}
			// berry bread from a set of berries.
			GameRegistry.addShapelessRecipe(new ItemStack(ItemNewFood, 1, 0), new Object[] { Item.getItemById(297), new ItemStack(ItemFruit, 1, 5), new ItemStack(ItemFruit, 1, 5) });
			GameRegistry.addShapelessRecipe(new ItemStack(ItemNewFood, 1, 1), new Object[] { Item.getItemById(297), new ItemStack(ItemFruit, 1, 6), new ItemStack(ItemFruit, 1, 6) });
			GameRegistry.addShapelessRecipe(new ItemStack(ItemNewFood, 1, 2), new Object[] { Item.getItemById(297), new ItemStack(ItemFruit, 1, 7), new ItemStack(ItemFruit, 1, 7) });
			GameRegistry.addShapelessRecipe(new ItemStack(ItemNewFood, 1, 3), new Object[] { Item.getItemById(297), new ItemStack(ItemFruit, 1, 8), new ItemStack(ItemFruit, 1, 8) });
			// Coconut milk from glass cup and coconut
			GameRegistry.addShapelessRecipe(new ItemStack(ItemNewFood3, 1, 0), new Object[] { new ItemStack(ItemNewCup, 1, 0), new ItemStack(ItemNuts, 1, 2) });
			// other crop goods
			GameRegistry.addShapelessRecipe(new ItemStack(Block.getBlockById(35), 1, 0), new Object[] { new ItemStack(newCropGoods, 1, 0), new ItemStack(newCropGoods, 1, 0), new ItemStack(newCropGoods, 1, 0), new ItemStack(newCropGoods, 1, 0) });// wool
																																																														// from
																																																														// cotton
			GameRegistry.addShapelessRecipe(new ItemStack(newCropGoods, 1, 2), new Object[] { new ItemStack(newCropGoods, 1, 1), new ItemStack(newCropGoods, 1, 1), new ItemStack(newCropGoods, 1, 1) });// rope yarn
			GameRegistry.addShapelessRecipe(new ItemStack(newCropGoods, 1, 3), new Object[] { new ItemStack(newCropGoods, 1, 2), new ItemStack(newCropGoods, 1, 2), new ItemStack(newCropGoods, 1, 2), new ItemStack(newCropGoods, 1, 2), new ItemStack(newCropGoods, 1, 2), new ItemStack(newCropGoods, 1, 2) });// rope
																																																																													// strand
			GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.rope, 1, 0), new Object[] { new ItemStack(newCropGoods, 1, 3), new ItemStack(newCropGoods, 1, 3), new ItemStack(newCropGoods, 1, 3), new ItemStack(newCropGoods, 1, 3), new ItemStack(newCropGoods, 1, 3), new ItemStack(newCropGoods, 1, 3) });// rope
			// dried bamboo
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 1, 12), new Object[] { new ItemStack(newPlanks, 1, 11) });
			// Bamboo planks
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 1, 11), new Object[] { new ItemStack(FNBlocks.hempCotBamCorn, 1, 11), new ItemStack(FNBlocks.hempCotBamCorn, 1, 11), new ItemStack(FNBlocks.hempCotBamCorn, 1, 11), new ItemStack(FNBlocks.hempCotBamCorn, 1, 11) });
			// gunpowder from nitre and sulfur//
			if (ForgottenNature.craftGunpowder) {
				GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(289), 3, 0), new Object[] { new ItemStack(powders, 1, 0), new ItemStack(powders, 1, 1), new ItemStack(Item.getItemById(263), 1, 0) });// gunpowder
																																																						// from
																																																						// powders
																																																						// and
																																																						// coal
				GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(289), 3, 0), new Object[] { new ItemStack(powders, 1, 0), new ItemStack(powders, 1, 1), new ItemStack(Item.getItemById(263), 1, 1) });// gunpowder
																																																						// from
																																																						// powders
																																																						// and
																																																						// charcoal
			}
		}
		{// Cobble and flint from new stones, bricks from new stones, stairs
			// from new stone bricks
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(318), 4), new Object[] { new ItemStack(newStones, 1, 0) });// flint
																																		// from
																																		// chert
			GameRegistry.addShapelessRecipe(new ItemStack(Block.getBlockById(4)), new Object[] { new ItemStack(newStones, 1, 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(Block.getBlockById(4)), new Object[] { new ItemStack(newStones, 1, 2) });
			GameRegistry.addShapelessRecipe(new ItemStack(Block.getBlockById(4)), new Object[] { new ItemStack(newStones, 1, 3) });
			GameRegistry.addShapelessRecipe(new ItemStack(Block.getBlockById(4)), new Object[] { new ItemStack(newStones, 1, 4) });
			// new stones to new bricks
			GameRegistry.addShapelessRecipe(new ItemStack(newStones, 4, 5), new Object[] { new ItemStack(newStones, 1, 1), new ItemStack(newStones, 1, 1), new ItemStack(newStones, 1, 1), new ItemStack(newStones, 1, 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newStones, 4, 6), new Object[] { new ItemStack(newStones, 1, 2), new ItemStack(newStones, 1, 2), new ItemStack(newStones, 1, 2), new ItemStack(newStones, 1, 2) });
			GameRegistry.addShapelessRecipe(new ItemStack(newStones, 4, 7), new Object[] { new ItemStack(newStones, 1, 3), new ItemStack(newStones, 1, 3), new ItemStack(newStones, 1, 3), new ItemStack(newStones, 1, 3) });
			GameRegistry.addShapelessRecipe(new ItemStack(newStones, 4, 8), new Object[] { new ItemStack(newStones, 1, 4), new ItemStack(newStones, 1, 4), new ItemStack(newStones, 1, 4), new ItemStack(newStones, 1, 4) });
			// new stone brick stairs
			GameRegistry.addRecipe(new ItemStack(sStairs1, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(FNBlocks.newStones, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(sStairs2, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(FNBlocks.newStones, 1, 6) });
			GameRegistry.addRecipe(new ItemStack(sStairs3, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(FNBlocks.newStones, 1, 7) });
			GameRegistry.addRecipe(new ItemStack(sStairs4, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(FNBlocks.newStones, 1, 8) });
			// new stones and bricks to half stones and bricks
			GameRegistry.addShapelessRecipe(new ItemStack(halfStone, 6, 0), new Object[] { new ItemStack(newStones, 1, 1), new ItemStack(newStones, 1, 1), new ItemStack(newStones, 1, 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(halfStone, 6, 1), new Object[] { new ItemStack(newStones, 1, 2), new ItemStack(newStones, 1, 2), new ItemStack(newStones, 1, 2) });
			GameRegistry.addShapelessRecipe(new ItemStack(halfStone, 6, 2), new Object[] { new ItemStack(newStones, 1, 3), new ItemStack(newStones, 1, 3), new ItemStack(newStones, 1, 3) });
			GameRegistry.addShapelessRecipe(new ItemStack(halfStone, 6, 3), new Object[] { new ItemStack(newStones, 1, 4), new ItemStack(newStones, 1, 4), new ItemStack(newStones, 1, 4) });
			GameRegistry.addShapelessRecipe(new ItemStack(halfStone, 6, 4), new Object[] { new ItemStack(newStones, 1, 5), new ItemStack(newStones, 1, 5), new ItemStack(newStones, 1, 5) });
			GameRegistry.addShapelessRecipe(new ItemStack(halfStone, 6, 5), new Object[] { new ItemStack(newStones, 1, 6), new ItemStack(newStones, 1, 6), new ItemStack(newStones, 1, 6) });
			GameRegistry.addShapelessRecipe(new ItemStack(halfStone, 6, 6), new Object[] { new ItemStack(newStones, 1, 7), new ItemStack(newStones, 1, 7), new ItemStack(newStones, 1, 7) });
			GameRegistry.addShapelessRecipe(new ItemStack(halfStone, 6, 7), new Object[] { new ItemStack(newStones, 1, 8), new ItemStack(newStones, 1, 8), new ItemStack(newStones, 1, 8) });
		}
		{// Dye from new flowers//
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(351), 1, 9), new Object[] { new ItemStack(newF, 1, 0) });
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(351), 1, 6), new Object[] { new ItemStack(newF, 1, 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(351), 1, 11), new Object[] { new ItemStack(newF, 1, 2) });
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(351), 1, 6), new Object[] { new ItemStack(newF, 1, 3) });
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(351), 1, 11), new Object[] { new ItemStack(newF, 1, 4) });
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(351), 1, 9), new Object[] { new ItemStack(newF, 1, 5) });
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(351), 1, 5), new Object[] { new ItemStack(newF, 1, 6) });
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(351), 1, 14), new Object[] { new ItemStack(newF, 1, 7) });
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(351), 1, 13), new Object[] { new ItemStack(newF, 1, 8) });
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(351), 1, 7), new Object[] { new ItemStack(newF, 1, 9) });
		}
		{// planks and new planks from new logs//
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 2), new Object[] { new ItemStack(newLogs, 1, 0) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs, 1, 2) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs, 1, 4) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 7), new Object[] { new ItemStack(newLogs, 1, 6) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 8), new Object[] { new ItemStack(newLogs, 1, 8) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs, 1, 10) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 10), new Object[] { new ItemStack(newLogs, 1, 12) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 3), new Object[] { new ItemStack(newLogs, 1, 14) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs2, 1, 0) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 0), new Object[] { new ItemStack(newLogs2, 1, 2) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 0), new Object[] { new ItemStack(newLogs2, 1, 4) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs2, 1, 6) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs2, 1, 8) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 0), new Object[] { new ItemStack(newLogs2, 1, 10) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 0), new Object[] { new ItemStack(newLogs2, 1, 12) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs2, 1, 14) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 0), new Object[] { new ItemStack(newLogs3, 1, 0) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 3), new Object[] { new ItemStack(newLogs3, 1, 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 5), new Object[] { new ItemStack(newLogs3, 1, 2) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 4), new Object[] { new ItemStack(newLogs3, 1, 3) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 9), new Object[] { new ItemStack(newLogs3, 1, 4) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 0), new Object[] { new ItemStack(newLogs3, 1, 5) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 3), new Object[] { new ItemStack(newLogs3, 1, 6) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 5), new Object[] { new ItemStack(newLogs3, 1, 7) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 4), new Object[] { new ItemStack(newLogs3, 1, 8) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 9), new Object[] { new ItemStack(newLogs3, 1, 9) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 0), new Object[] { new ItemStack(newLogs3, 1, 10) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 3), new Object[] { new ItemStack(newLogs3, 1, 11) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 5), new Object[] { new ItemStack(newLogs3, 1, 12) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 4), new Object[] { new ItemStack(newLogs3, 1, 13) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 9), new Object[] { new ItemStack(newLogs3, 1, 14) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 13), new Object[] { new ItemStack(FNBlocks.netherLogs, 1, 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 14), new Object[] { new ItemStack(FNBlocks.netherLogs, 1, 0) });

			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 2), new Object[] { new ItemStack(newLogs, 1, 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs, 1, 3) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs, 1, 5) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 7), new Object[] { new ItemStack(newLogs, 1, 7) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 8), new Object[] { new ItemStack(newLogs, 1, 9) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs, 1, 11) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 10), new Object[] { new ItemStack(newLogs, 1, 13) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 3), new Object[] { new ItemStack(newLogs, 1, 15) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs2, 1, 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 0), new Object[] { new ItemStack(newLogs2, 1, 3) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 0), new Object[] { new ItemStack(newLogs2, 1, 5) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs2, 1, 7) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs2, 1, 9) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 0), new Object[] { new ItemStack(newLogs2, 1, 11) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 0), new Object[] { new ItemStack(newLogs2, 1, 13) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 6), new Object[] { new ItemStack(newLogs2, 1, 15) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 0), new Object[] { new ItemStack(newLogs3, 1, 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 3), new Object[] { new ItemStack(newLogs3, 1, 3) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 5), new Object[] { new ItemStack(newLogs3, 1, 5) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 4), new Object[] { new ItemStack(newLogs3, 1, 7) });
			GameRegistry.addShapelessRecipe(new ItemStack(newPlanks, 4, 9), new Object[] { new ItemStack(newLogs3, 1, 9) });

			// parquet planks
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 0), new Object[] { "&& ", "&  ", "&  ", '&', new ItemStack(Block.getBlockById(5), 1, 0) });// =====harringbone
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 0), new Object[] { "&& ", "&  ", "&  ", '&', new ItemStack(Block.getBlockById(5), 1, 1) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 0), new Object[] { "&& ", "&  ", "&  ", '&', new ItemStack(Block.getBlockById(5), 1, 2) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 0), new Object[] { "&& ", "&  ", "&  ", '&', new ItemStack(Block.getBlockById(5), 1, 3) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 0), new Object[] { "&& ", "&  ", "&  ", '&', new ItemStack(Block.getBlockById(5), 1, 4) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 1), new Object[] { "& &", "   ", "& &", '&', new ItemStack(newPlanks, 1, 0) });/// =====X-parquet
																																				/// plank
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 1), new Object[] { "& &", "   ", "& &", '&', new ItemStack(newPlanks, 1, 10) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 1), new Object[] { "& &", "   ", "& &", '&', new ItemStack(Block.getBlockById(5), 1, 5) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 1), new Object[] { "& &", "   ", "& &", '&', new ItemStack(Block.getBlockById(5), 1, 1) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 2), new Object[] { "& &", " & ", "& &", '&', new ItemStack(newPlanks, 1, 4) });/// =====Frederiksborg
																																				/// parquet
																																				/// plank
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 2), new Object[] { "& &", " & ", "& &", '&', new ItemStack(newPlanks, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 2), new Object[] { "& &", " & ", "& &", '&', new ItemStack(Block.getBlockById(5), 1, 0) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 2), new Object[] { "& &", " & ", "& &", '&', new ItemStack(Block.getBlockById(5), 1, 3) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 3), new Object[] { "& &", "   ", "& &", '&', new ItemStack(newPlanks, 1, 6) });/// =====For
																																				/// Don
																																				/// Parquet
																																				/// plank
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 3), new Object[] { "& &", "   ", "& &", '&', new ItemStack(newPlanks, 1, 14) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 3), new Object[] { "& &", "   ", "& &", '&', new ItemStack(Block.getBlockById(5), 1, 0) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 4), new Object[] { " & ", "& &", " & ", '&', new ItemStack(newPlanks, 1, 6) });/// =====Lattice
																																				/// Parquet
																																				/// plank
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 4), new Object[] { " & ", "& &", " & ", '&', new ItemStack(Block.getBlockById(5), 1, 0) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 5), new Object[] { " & ", "& &", " & ", '&', new ItemStack(newPlanks, 1, 8) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 6), new Object[] { "& &", " & ", "& &", '&', new ItemStack(newPlanks, 1, 0) });/// =====Pavimente
																																				/// parquet
																																				/// plank
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 6), new Object[] { "& &", " & ", "& &", '&', new ItemStack(newPlanks, 1, 10) });
			GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 6), new Object[] { "& &", " & ", "& &", '&', new ItemStack(Block.getBlockById(5), 1, 1) });
		}
		{// netherrot spores and souldust from nether logs, soul sand and
			// netherrack
			GameRegistry.addShapelessRecipe(new ItemStack(powders, 8, 2), new Object[] { new ItemStack(FNBlocks.netherLogs, 1, 3), new ItemStack(Block.getBlockById(87)) });
			GameRegistry.addShapelessRecipe(new ItemStack(powders, 8, 3), new Object[] { new ItemStack(FNBlocks.netherLogs, 1, 0), new ItemStack(Block.getBlockById(88)) });
			// Nether mushroom
			GameRegistry.addShapelessRecipe(new ItemStack(newSap3, 2, 5), new Object[] { new ItemStack(FNBlocks.netherLogs, 1, 2) });// nether
																																		// mushroom
			GameRegistry.addShapelessRecipe(new ItemStack(newSap3, 4, 5), new Object[] { new ItemStack(FNBlocks.netherLogs, 1, 3) });// nether
																																		// mushroom
																																		// saw items//
			GameRegistry.addRecipe(new ItemStack(sawItem, 1, 0), new Object[] { "   ", "&&&", " & ", '&', new ItemStack(Item.getItemById(265), 1) });// sawtooth
																																						// from
																																						// iron
			GameRegistry.addRecipe(new ItemStack(sawItem, 1, 0), new Object[] { "&&&", " & ", "   ", '&', new ItemStack(Item.getItemById(265), 1) });// sawtooth
																																						// from
																																						// iron
			GameRegistry.addRecipe(new ItemStack(sawItem, 1, 2), new Object[] { "s&&", "& &", "&&&", 's', new ItemStack(Item.getItemById(265), 1), '&', new ItemStack(Block.getBlockById(5)) });// sawhandle
																																																// from
																																																// wood
																																																// and
																																																// iron
			GameRegistry.addShapelessRecipe(new ItemStack(sawItem, 1, 1), new Object[] { new ItemStack(sawItem, 1, 0), new ItemStack(sawItem, 1, 0), new ItemStack(sawItem, 1, 0), new ItemStack(sawItem, 1, 0) });// sawBlade
			GameRegistry.addShapelessRecipe(new ItemStack(sawTool, 1), new Object[] { new ItemStack(sawItem, 1, 1), new ItemStack(sawItem, 1, 2) });// saw
		}
		{// Sticks, tools and stairs from new planks.
			GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs1, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(newPlanks, 1, 0) });// new
																																						// stairs
																																						// from
																																						// new
																																						// planks
			GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs2, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(newPlanks, 1, 1) });// new
																																						// stairs
																																						// from
																																						// new
																																						// planks
			GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs3, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(newPlanks, 1, 2) });// new
																																						// stairs
																																						// from
																																						// new
																																						// planks
			GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs4, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(newPlanks, 1, 3) });// new
																																						// stairs
																																						// from
																																						// new
																																						// planks
			GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs5, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(newPlanks, 1, 4) });// new
																																						// stairs
																																						// from
																																						// new
																																						// planks
			GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs6, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(newPlanks, 1, 5) });// new
																																						// stairs
																																						// from
																																						// new
																																						// planks
			GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs7, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(newPlanks, 1, 6) });// new
																																						// stairs
																																						// from
																																						// new
																																						// planks
			GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs8, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(newPlanks, 1, 7) });// new
																																						// stairs
																																						// from
																																						// new
																																						// planks
			GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs10, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(newPlanks, 1, 9) });// new
																																						// stairs
																																						// from
																																						// new
																																						// planks
			GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs11, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(newPlanks, 1, 10) });// new
																																						// stairs
																																						// from
																																						// new
																																						// planks
			GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs12, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(newPlanks, 1, 11) });// new
																																						// stairs
																																						// from
																																						// new
																																						// planks
			GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs13, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(newPlanks, 1, 12) });// new
																																						// stairs
																																						// from
																																						// new
																																						// planks
			for (int x = 0; x < 15; x++) {
				GameRegistry.addRecipe(new ItemStack(newPlanks2, 4, 0), new Object[] { "&& ", "&  ", "&  ", '&', new ItemStack(newPlanks, 1, x) });// parquet
				GameRegistry.addShapelessRecipe(new ItemStack(Block.getBlockById(5), 1), new Object[] { new ItemStack(newPlanks, 1, x) });// special
																																			// planks
																																			// to
																																			// normal
																																			// planks
				if (x < 8) {
					GameRegistry.addRecipe(new ItemStack(halfPlank, 6, x), new Object[] { "   ", "   ", "&&&", '&', new ItemStack(newPlanks, 1, x) });// half
																																						// planks
																																						// from
																																						// new
																																						// planks
					GameRegistry.addRecipe(new ItemStack(halfPlank, 6, x), new Object[] { "   ", "&&&", "   ", '&', new ItemStack(newPlanks, 1, x) });// half
																																						// planks
																																						// from
																																						// new
																																						// planks
					GameRegistry.addRecipe(new ItemStack(halfPlank, 6, x), new Object[] { "&&&", "   ", "   ", '&', new ItemStack(newPlanks, 1, x) });// half
																																						// planks
																																						// from
																																						// new
																																						// planks
				} else if (x < 13) {
					GameRegistry.addRecipe(new ItemStack(halfPlank2, 6, x - 8), new Object[] { "   ", "   ", "&&&", '&', new ItemStack(newPlanks, 1, x) });// half
																																							// planks
																																							// from
																																							// new
																																							// planks
					GameRegistry.addRecipe(new ItemStack(halfPlank2, 6, x - 8), new Object[] { "   ", "&&&", "   ", '&', new ItemStack(newPlanks, 1, x) });// half
																																							// planks
																																							// from
																																							// new
																																							// planks
					GameRegistry.addRecipe(new ItemStack(halfPlank2, 6, x - 8), new Object[] { "&&&", "   ", "   ", '&', new ItemStack(newPlanks, 1, x) });// half
																																							// planks
																																							// from
																																							// new
																																							// planks
				}
				if (x < 13)
					GameRegistry.addRecipe(new ItemStack(sawItem, 1, 2), new Object[] { "s&&", "& &", "&&&", 's', new ItemStack(Item.getItemById(265), 1), '&', new ItemStack(newPlanks, 1, x) });// sawhandle
																																																	// from
																																																	// iron
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(280), 4), new Object[] { "   ", " & ", " & ", '&', new ItemStack(newPlanks, 1, x) });// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(280), 4), new Object[] { " & ", " & ", "   ", '&', new ItemStack(newPlanks, 1, x) });// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(280), 4), new Object[] { "   ", "&  ", "&  ", '&', new ItemStack(newPlanks, 1, x) });// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(280), 4), new Object[] { "&  ", "&  ", "   ", '&', new ItemStack(newPlanks, 1, x) });// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(280), 4), new Object[] { "   ", "  &", "  &", '&', new ItemStack(newPlanks, 1, x) });// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(280), 4), new Object[] { "  &", "  &", "   ", '&', new ItemStack(newPlanks, 1, x) });// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(270)), new Object[] { "&&&", " * ", " * ", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// woodpa
																																																	// from
																																																	// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(269)), new Object[] { " & ", " * ", " * ", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// woodshovel
																																																	// from
																																																	// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(269)), new Object[] { "&  ", "*  ", "*  ", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// woodshovel
																																																	// from
																																																	// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(269)), new Object[] { "  &", "  *", "  *", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// woodshovel
																																																	// from
																																																	// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(290)), new Object[] { "&& ", " * ", " * ", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// woodhoe
																																																	// from
																																																	// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(290)), new Object[] { " &&", " * ", " * ", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// woodhoe
																																																	// from
																																																	// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(271)), new Object[] { "&& ", "&* ", " * ", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// woodaxe
																																																	// from
																																																	// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(271)), new Object[] { " &&", " *&", " * ", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// woodaxe
																																																	// from
																																																	// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(268)), new Object[] { " & ", " & ", " * ", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// woodsword
																																																	// from
																																																	// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(268)), new Object[] { "&  ", "&  ", "*  ", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// woodsword
																																																	// from
																																																	// stick
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(268)), new Object[] { "  &", "  &", "  *", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// woodsword
																																																	// from
																																																	// stick
																																																	// workbench from new planks
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(58)), new Object[] { "   ", "&& ", "&& ", '&', new ItemStack(newPlanks, 1, x) });// workbench
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(58)), new Object[] { "&& ", "&& ", "   ", '&', new ItemStack(newPlanks, 1, x) });// workbench
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(58)), new Object[] { "   ", " &&", " &&", '&', new ItemStack(newPlanks, 1, x) });// workbench
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(58)), new Object[] { " &&", " &&", "   ", '&', new ItemStack(newPlanks, 1, x) });// workbench
				// chest, bookshelf, and stairs from new planks
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(54)), new Object[] { "&&&", "& &", "&&&", '&', new ItemStack(newPlanks, 1, x) });
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(47)), new Object[] { "&&&", "***", "&&&", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(340)) });// bookshelf
																																																	// from
																																																	// books
																																																	// and
																																																	// new
																																																	// planks
																																																	// boat and bowl from new planks
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(333)), new Object[] { "   ", "& &", "&&&", '&', new ItemStack(newPlanks, 1, x) });// boat
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(333)), new Object[] { "& &", "&&&", "   ", '&', new ItemStack(newPlanks, 1, x) });// boat
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(281), 4), new Object[] { "& &", " & ", "   ", '&', new ItemStack(newPlanks, 1, x) });// bowl
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(281), 4), new Object[] { "   ", "& &", " & ", '&', new ItemStack(newPlanks, 1, x) });// bowl
				// preasure plate, trap door and door from new planks
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(72)), new Object[] { "   ", "&& ", "   ", '&', new ItemStack(newPlanks, 1, x) });// wooden
																																							// pressure
																																							// plate
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(72)), new Object[] { "&& ", "   ", "   ", '&', new ItemStack(newPlanks, 1, x) });// wooden
																																							// pressure
																																							// plate
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(72)), new Object[] { "   ", "   ", "&& ", '&', new ItemStack(newPlanks, 1, x) });// wooden
																																							// pressure
																																							// plate
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(72)), new Object[] { "   ", "   ", " &&", '&', new ItemStack(newPlanks, 1, x) });// wooden
																																							// pressure
																																							// plate
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(72)), new Object[] { "   ", " &&", "   ", '&', new ItemStack(newPlanks, 1, x) });// wooden
																																							// pressure
																																							// plate
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(72)), new Object[] { " &&", "   ", "   ", '&', new ItemStack(newPlanks, 1, x) });// pressure
																																							// plate
																																							// wooden
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(96), 2), new Object[] { "&&&", "&&&", "   ", '&', new ItemStack(newPlanks, 1, x) });// trapdoor
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(96), 2), new Object[] { "   ", "&&&", "&&&", '&', new ItemStack(newPlanks, 1, x) });// trapdoor
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(324)), new Object[] { "&& ", "&& ", "&& ", '&', new ItemStack(newPlanks, 1, x) });// wood
																																						// door
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(324)), new Object[] { " &&", " &&", " &&", '&', new ItemStack(newPlanks, 1, x) });// wood
																																						// door
																																						// Jukebox, note block, piston and sign from new planks
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(84)), new Object[] { "&&&", "&*&", "&&&", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(264)) });// jukebox
																																																	// from
																																																	// diamond
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(25)), new Object[] { "&&&", "&*&", "&&&", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(331)) });// music
																																																	// block
																																																	// from
																																																	// redstone
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(33)), new Object[] { "&&&", "$*$", "$r$", '&', new ItemStack(newPlanks, 1, x), '$', Block.getBlockById(4), '*', new ItemStack(Item.getItemById(265)), 'r', new ItemStack(Item.getItemById(331)) });// piston
																																																																			// from
																																																																			// cobble,
																																																																			// iron
																																																																			// and
																																																																			// redstone
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(323)), new Object[] { "&&&", "&&&", " * ", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// sign
																																																	// from
																																																	// planks
																																																	// and
																																																	// stick
																																																	// bed and gate from new planks
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(355)), new Object[] { "&&&", "***", "   ", '*', new ItemStack(newPlanks, 1, x), '&', Block.getBlockById(35) });// bed
																																														// from
																																														// wool
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(355)), new Object[] { "   ", "&&&", "***", '*', new ItemStack(newPlanks, 1, x), '&', Block.getBlockById(35) });// bed
																																														// from
																																														// wool
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(85)), new Object[] { "*&*", "*&*", "   ", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// fence
																																																	// from
																																																	// sticks
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(85)), new Object[] { "   ", "*&*", "*&*", '&', new ItemStack(newPlanks, 1, x), '*', new ItemStack(Item.getItemById(280)) });// fence
																																																	// from
																																																	// sticks
			}
			{// Crystal Stuff
				// crystal half planks and stairs
				GameRegistry.addRecipe(new ItemStack(halfPlank2, 6, 5), new Object[] { "   ", "   ", "&&&", '&', new ItemStack(crystalWood, 1, 2) });// chalf
																																						// planks
																																						// from
																																						// new
																																						// cplanks
				GameRegistry.addRecipe(new ItemStack(halfPlank2, 6, 5), new Object[] { "   ", "&&&", "   ", '&', new ItemStack(crystalWood, 1, 2) });// chalf
																																						// planks
																																						// from
																																						// new
																																						// cplanks
				GameRegistry.addRecipe(new ItemStack(halfPlank2, 6, 5), new Object[] { "&&&", "   ", "   ", '&', new ItemStack(crystalWood, 1, 2) });// chalf
																																						// planks
																																						// from
																																						// new
																																						// cplanks
				GameRegistry.addRecipe(new ItemStack(halfPlank2, 6, 6), new Object[] { "   ", "   ", "&&&", '&', new ItemStack(crystalWood, 1, 3) });// dchalf
																																						// planks
																																						// from
																																						// new
																																						// cplanks
				GameRegistry.addRecipe(new ItemStack(halfPlank2, 6, 6), new Object[] { "   ", "&&&", "   ", '&', new ItemStack(crystalWood, 1, 3) });// dchalf
																																						// planks
																																						// from
																																						// new
																																						// cplanks
				GameRegistry.addRecipe(new ItemStack(halfPlank2, 6, 6), new Object[] { "&&&", "   ", "   ", '&', new ItemStack(crystalWood, 1, 3) });// dchalf
																																						// planks
																																						// from
																																						// new
																																						// cplanks
				GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs14, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(crystalWood, 1, 2) });// new
																																							// cstairs
																																							// from
																																							// new
																																							// cplanks
				GameRegistry.addRecipe(new ItemStack(FNBlocks.newStairs15, 4), new Object[] { "&  ", "&& ", "&&&", '&', new ItemStack(crystalWood, 1, 3) });// new
																																							// dcstairs
																																							// from
																																							// new
																																							// dcplanks
																																							// dark Crystal bricks from stone and dark focus crystal
				GameRegistry.addRecipe(new ItemStack(blockCrystal, 8, 3), new Object[] { "&&&", "&*&", "&&&", '&', new ItemStack(Block.getBlockById(1)), '*', new ItemStack(blockCrystal, 1, 1) });
				// Crystal bricks from stone and focus crystal
				GameRegistry.addRecipe(new ItemStack(blockCrystal, 8, 2), new Object[] { "&&&", "&*&", "&&&", '&', new ItemStack(Block.getBlockById(1)), '*', new ItemStack(blockCrystal, 1, 0) });
				// crystal mushroom from shards
				GameRegistry.addRecipe(new ItemStack(FNBlocks.mushroomCrystal, 1, 0), new Object[] { "&&&", " & ", "   ", '&', new ItemStack(crystalItem, 1, 1) });
				GameRegistry.addRecipe(new ItemStack(FNBlocks.mushroomCrystal, 1, 0), new Object[] { "   ", "&&&", " & ", '&', new ItemStack(crystalItem, 1, 1) });
				// crystal chunk from focus crystals
				GameRegistry.addShapelessRecipe(new ItemStack(crystalItem, 9, 2), new Object[] { new ItemStack(blockCrystal, 1, 0) });
				// black chunk from black focus crystals
				GameRegistry.addShapelessRecipe(new ItemStack(crystalItem, 9, 0), new Object[] { new ItemStack(blockCrystal, 1, 1) });
				// crystal shards from chunks
				GameRegistry.addShapelessRecipe(new ItemStack(crystalItem, 9, 1), new Object[] { new ItemStack(crystalItem, 1, 2) });
				// black shards from chunks
				GameRegistry.addShapelessRecipe(new ItemStack(crystalItem, 9, 4), new Object[] { new ItemStack(crystalItem, 1, 0) });
				// crystal chunk from crystal shards
				GameRegistry.addRecipe(new ItemStack(crystalItem, 1, 2), new Object[] { "&&&", "&&&", "&&&", '&', new ItemStack(crystalItem, 1, 1) });
				// black chunk from black shards
				GameRegistry.addRecipe(new ItemStack(crystalItem, 1, 0), new Object[] { "&&&", "&&&", "&&&", '&', new ItemStack(crystalItem, 1, 4) });
				// black crystal leaves from black shards
				GameRegistry.addShapelessRecipe(new ItemStack(crystalLeaves, 1, 0), new Object[] { new ItemStack(crystalItem, 1, 4), new ItemStack(crystalItem, 1, 4), new ItemStack(crystalItem, 1, 4), new ItemStack(crystalItem, 1, 4) });
				// crystal leaves from shards
				GameRegistry.addShapelessRecipe(new ItemStack(crystalLeaves, 1, 1), new Object[] { new ItemStack(crystalItem, 1, 1), new ItemStack(crystalItem, 1, 1), new ItemStack(crystalItem, 1, 1), new ItemStack(crystalItem, 1, 1) });
				// crystal planks
				GameRegistry.addShapelessRecipe(new ItemStack(crystalWood, 4, 3), new Object[] { new ItemStack(crystalWood, 1, 1) });
				// bcrystal planks
				GameRegistry.addShapelessRecipe(new ItemStack(crystalWood, 4, 2), new Object[] { new ItemStack(crystalWood, 1, 0) });
				// crystal sticks from shards
				GameRegistry.addRecipe(new ItemStack(crystalItem, 1, 3), new Object[] { "   ", " & ", " & ", '&', new ItemStack(crystalItem, 1, 1) });
				// crystal sticks from shards
				GameRegistry.addRecipe(new ItemStack(crystalItem, 1, 3), new Object[] { "   ", "&  ", "&  ", '&', new ItemStack(crystalItem, 1, 1) });
				// crystal sticks from shards
				GameRegistry.addRecipe(new ItemStack(crystalItem, 1, 3), new Object[] { "   ", "  &", "  &", '&', new ItemStack(crystalItem, 1, 1) });
				// crystal sticks from shards
				GameRegistry.addRecipe(new ItemStack(crystalItem, 1, 3), new Object[] { " & ", " & ", "   ", '&', new ItemStack(crystalItem, 1, 1) });
				// crystal sticks from shards
				GameRegistry.addRecipe(new ItemStack(crystalItem, 1, 3), new Object[] { "&  ", "&  ", "   ", '&', new ItemStack(crystalItem, 1, 1) });
				// crystal sticks from shards
				GameRegistry.addRecipe(new ItemStack(crystalItem, 1, 3), new Object[] { "  &", "  &", "   ", '&', new ItemStack(crystalItem, 1, 1) });
				// crystal sticks from planks
				GameRegistry.addRecipe(new ItemStack(crystalItem, 4, 3), new Object[] { "   ", " & ", " & ", '&', new ItemStack(crystalWood, 1, 2) });
				// crystal sticks from planks
				GameRegistry.addRecipe(new ItemStack(crystalItem, 4, 3), new Object[] { "   ", "&  ", "&  ", '&', new ItemStack(crystalWood, 1, 2) });
				// crystal sticks from planks
				GameRegistry.addRecipe(new ItemStack(crystalItem, 4, 3), new Object[] { "   ", "  &", "  &", '&', new ItemStack(crystalWood, 1, 2) });
				// crystal sticks from planks
				GameRegistry.addRecipe(new ItemStack(crystalItem, 4, 3), new Object[] { " & ", " & ", "   ", '&', new ItemStack(crystalWood, 1, 2) });
				// crystal sticks from planks
				GameRegistry.addRecipe(new ItemStack(crystalItem, 4, 3), new Object[] { "&  ", "&  ", "   ", '&', new ItemStack(crystalWood, 1, 2) });
				// crystal sticks from planks
				GameRegistry.addRecipe(new ItemStack(crystalItem, 4, 3), new Object[] { "  &", "  &", "   ", '&', new ItemStack(crystalWood, 1, 2) });
				// stone from shards
				GameRegistry.addRecipe(new ItemStack(crystalStone, 1, 0), new Object[] { "& &", " & ", "   ", '&', new ItemStack(crystalItem, 1, 1) });
				// stone from shards
				GameRegistry.addRecipe(new ItemStack(crystalStone, 1, 0), new Object[] { "   ", "& &", " & ", '&', new ItemStack(crystalItem, 1, 1) });
				// black stone from black shards
				GameRegistry.addRecipe(new ItemStack(crystalStone, 1, 1), new Object[] { "& &", " & ", "   ", '&', new ItemStack(crystalItem, 1, 4) });
				// black stone from black shards
				GameRegistry.addRecipe(new ItemStack(crystalStone, 1, 1), new Object[] { "   ", "& &", " & ", '&', new ItemStack(crystalItem, 1, 4) });
				// crystal block from chunks
				GameRegistry.addRecipe(new ItemStack(blockCrystal, 1, 0), new Object[] { "&&&", "&&&", "&&&", '&', new ItemStack(crystalItem, 1, 2) });
				// black block from black chunks
				GameRegistry.addRecipe(new ItemStack(blockCrystal, 1, 1), new Object[] { "&&&", "&&&", "&&&", '&', new ItemStack(crystalItem, 1, 0) });
				if (ForgottenNature.crystalTools) {
					GameRegistry.addRecipe(new ItemStack(FNItems.cPickaxeItem, 1, 0), new Object[] { "&&&", " * ", " * ", '&', new ItemStack(crystalItem, 1, 2), '*', new ItemStack(crystalItem, 1, 3) });
					GameRegistry.addRecipe(new ItemStack(FNItems.cAxeItem, 1, 0), new Object[] { "&& ", "&* ", " * ", '&', new ItemStack(crystalItem, 1, 2), '*', new ItemStack(crystalItem, 1, 3) });// axe
					GameRegistry.addRecipe(new ItemStack(FNItems.cAxeItem, 1, 0), new Object[] { " &&", " *&", " * ", '&', new ItemStack(crystalItem, 1, 2), '*', new ItemStack(crystalItem, 1, 3) });// second
																																																		// axe
					GameRegistry.addRecipe(new ItemStack(FNItems.cHoeItem, 1, 0), new Object[] { "&& ", " * ", " * ", '&', new ItemStack(crystalItem, 1, 2), '*', new ItemStack(crystalItem, 1, 3) });// hoe
					GameRegistry.addRecipe(new ItemStack(FNItems.cHoeItem, 1, 0), new Object[] { "&& ", " * ", " * ", '&', new ItemStack(crystalItem, 1, 2), '*', new ItemStack(crystalItem, 1, 3) });// second
																																																		// hoe
					GameRegistry.addRecipe(new ItemStack(FNItems.cShovelItem, 1, 0), new Object[] { " & ", " * ", " * ", '&', new ItemStack(crystalItem, 1, 2), '*', new ItemStack(crystalItem, 1, 3) });// shovel
					GameRegistry.addRecipe(new ItemStack(FNItems.cSwordItem, 1, 0), new Object[] { " & ", " & ", " * ", '&', new ItemStack(crystalItem, 1, 2), '*', new ItemStack(crystalItem, 1, 3) });// sword
					GameRegistry.addRecipe(new ItemStack(FNItems.dcPickaxeItem, 1, 0), new Object[] { "&&&", " * ", " * ", '&', new ItemStack(crystalItem, 1, 0), '*', new ItemStack(crystalItem, 1, 3) });// bpa
					GameRegistry.addRecipe(new ItemStack(FNItems.cAxeItem, 1, 0), new Object[] { "&& ", "&* ", " * ", '&', new ItemStack(crystalItem, 1, 0), '*', new ItemStack(crystalItem, 1, 3) });// baxe
					GameRegistry.addRecipe(new ItemStack(FNItems.cAxeItem, 1, 0), new Object[] { " &&", " *&", " * ", '&', new ItemStack(crystalItem, 1, 0), '*', new ItemStack(crystalItem, 1, 3) });// bsecond
																																																		// axe
					GameRegistry.addRecipe(new ItemStack(FNItems.cHoeItem, 1, 0), new Object[] { "&& ", " * ", " * ", '&', new ItemStack(crystalItem, 1, 0), '*', new ItemStack(crystalItem, 1, 3) });// bhoe
					GameRegistry.addRecipe(new ItemStack(FNItems.cHoeItem, 1, 0), new Object[] { "&& ", " * ", " * ", '&', new ItemStack(crystalItem, 1, 0), '*', new ItemStack(crystalItem, 1, 3) });// bsecond
																																																		// hoe
					GameRegistry.addRecipe(new ItemStack(FNItems.cShovelItem, 1, 0), new Object[] { " & ", " * ", " * ", '&', new ItemStack(crystalItem, 1, 0), '*', new ItemStack(crystalItem, 1, 3) });// bshovel
					GameRegistry.addRecipe(new ItemStack(FNItems.cSwordItem, 1, 0), new Object[] { " & ", " & ", " * ", '&', new ItemStack(crystalItem, 1, 0), '*', new ItemStack(crystalItem, 1, 3) });// bsword
				}
				GameRegistry.addRecipe(new ItemStack(newSap3, 1, 2), new Object[] { "&&&", " & ", " & ", '&', new ItemStack(crystalItem, 1, 1) });// cSap
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(58), 1), new Object[] { "   ", "&& ", "&& ", '&', new ItemStack(crystalWood, 1, 2) });// workbench
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(58), 1), new Object[] { "&& ", "&& ", "   ", '&', new ItemStack(crystalWood, 1, 2) });// workbench
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(58), 1), new Object[] { "   ", " &&", " &&", '&', new ItemStack(crystalWood, 1, 2) });// workbench
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(58), 1), new Object[] { " &&", " &&", "   ", '&', new ItemStack(crystalWood, 1, 2) });// workbench
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(58), 1), new Object[] { "   ", "&& ", "&& ", '&', new ItemStack(crystalWood, 1, 3) });// workbench
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(58), 1), new Object[] { "&& ", "&& ", "   ", '&', new ItemStack(crystalWood, 1, 3) });// workbench
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(58), 1), new Object[] { "   ", " &&", " &&", '&', new ItemStack(crystalWood, 1, 3) });// workbench
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(58), 1), new Object[] { " &&", " &&", "   ", '&', new ItemStack(crystalWood, 1, 3) });// workbench
				// Chest from crystal wood
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(54), 1), new Object[] { "&&&", "& &", "&&&", '&', new ItemStack(crystalWood, 1, 2) });// chest
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(54), 1), new Object[] { "&&&", "& &", "&&&", '&', new ItemStack(crystalWood, 1, 3) });// chest
				// book shelf from crystal wood
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(47), 1), new Object[] { "&&&", "***", "&&&", '&', new ItemStack(crystalWood, 1, 2), '*', new ItemStack(Item.getItemById(340)) });// bookshelf
																																																			// from
																																																			// book
				GameRegistry.addRecipe(new ItemStack(Block.getBlockById(47), 1), new Object[] { "&&&", "***", "&&&", '&', new ItemStack(crystalWood, 1, 3), '*', new ItemStack(Item.getItemById(340)) });// bookshelf
																																																			// from
																																																			// book
																																																			// bed from crystal wood
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(255)), new Object[] { "***", "&&&", "   ", '&', new ItemStack(crystalWood, 1, 2), '*', Block.getBlockById(35) });// bed
																																														// from
																																														// wool
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(255)), new Object[] { "   ", "***", "&&&", '&', new ItemStack(crystalWood, 1, 2), '*', Block.getBlockById(35) });// bed
																																														// from
																																														// wool
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(255)), new Object[] { "***", "&&&", "   ", '&', new ItemStack(crystalWood, 1, 3), '*', Block.getBlockById(35) });// bed
																																														// from
																																														// wool
				GameRegistry.addRecipe(new ItemStack(Item.getItemById(255)), new Object[] { "   ", "***", "&&&", '&', new ItemStack(crystalWood, 1, 3), '*', Block.getBlockById(35) });// bed
																																														// from
																																														// wool
																																														// crystal torches from crystal chunk and crystal stick
				GameRegistry.addRecipe(new ItemStack(newTorch, 8, 0), new Object[] { "   ", " * ", " & ", '&', new ItemStack(crystalItem, 1, 3), '*', new ItemStack(crystalItem, 1, 2) });// crystal
																																															// torch
				GameRegistry.addRecipe(new ItemStack(newTorch, 8, 0), new Object[] { " * ", " & ", "   ", '&', new ItemStack(crystalItem, 1, 3), '*', new ItemStack(crystalItem, 1, 2) });// crystal
																																															// torch
				GameRegistry.addRecipe(new ItemStack(newTorch, 8, 0), new Object[] { "   ", "*  ", "&  ", '&', new ItemStack(crystalItem, 1, 3), '*', new ItemStack(crystalItem, 1, 2) });// crystal
																																															// torch
				GameRegistry.addRecipe(new ItemStack(newTorch, 8, 0), new Object[] { "*  ", "&  ", "   ", '&', new ItemStack(crystalItem, 1, 3), '*', new ItemStack(crystalItem, 1, 2) });// crystal
																																															// torch
				GameRegistry.addRecipe(new ItemStack(newTorch, 8, 0), new Object[] { "   ", "  *", "  &", '&', new ItemStack(crystalItem, 1, 3), '*', new ItemStack(crystalItem, 1, 2) });// crystal
																																															// torch
				GameRegistry.addRecipe(new ItemStack(newTorch, 8, 0), new Object[] { "  *", "  &", "   ", '&', new ItemStack(crystalItem, 1, 3), '*', new ItemStack(crystalItem, 1, 2) });// crystal
																																															// torch
			}
			{// all about stains
				// animal oils from bucket and raw meat
				GameRegistry.addShapelessRecipe(new ItemStack(ItemNewCup, 1, 1), new Object[] { Item.getItemById(325), Item.getItemById(363) });// oils
																																				// from
																																				// beef
				GameRegistry.addShapelessRecipe(new ItemStack(ItemNewCup, 1, 1), new Object[] { Item.getItemById(325), Item.getItemById(365) });// oils
																																				// from
																																				// chicken
				GameRegistry.addShapelessRecipe(new ItemStack(ItemNewCup, 1, 1), new Object[] { Item.getItemById(325), Item.getItemById(349) });// oils
																																				// from
																																				// fish
				GameRegistry.addShapelessRecipe(new ItemStack(ItemNewCup, 1, 1), new Object[] { Item.getItemById(325), Item.getItemById(319) });// oils
																																				// from
																																				// pork
																																				// wood stains from animal oil and dye
				GameRegistry.addShapelessRecipe(new ItemStack(ItemNewContainer, 1, 2), new Object[] { new ItemStack(ItemNewCup, 1, 1), new ItemStack(Item.getItemById(351), 1, 3) });// stain
																																														// from
																																														// dye
																																														// -
																																														// brown
				GameRegistry.addShapelessRecipe(new ItemStack(ItemNewContainer, 1, 3), new Object[] { new ItemStack(ItemNewCup, 1, 1), new ItemStack(Item.getItemById(351), 1, 5) });// stain
																																														// from
																																														// dye
																																														// -
																																														// purple
				GameRegistry.addShapelessRecipe(new ItemStack(ItemNewContainer, 1, 4), new Object[] { new ItemStack(ItemNewCup, 1, 1), new ItemStack(Item.getItemById(351), 1, 1), new ItemStack(Item.getItemById(351), 1, 1) });// stain
																																																									// from
																																																									// dye
																																																									// -
																																																									// dark
																																																									// red
				GameRegistry.addShapelessRecipe(new ItemStack(ItemNewContainer, 1, 5), new Object[] { new ItemStack(ItemNewCup, 1, 1), new ItemStack(Item.getItemById(351), 1, 11), new ItemStack(Item.getItemById(351), 1, 11) });// stain
																																																									// from
																																																									// dye
																																																									// -
																																																									// dark
																																																									// yellow
				GameRegistry.addShapelessRecipe(new ItemStack(ItemNewContainer, 1, 6), new Object[] { new ItemStack(ItemNewCup, 1, 1), new ItemStack(Item.getItemById(351), 1, 3), new ItemStack(Item.getItemById(351), 1, 14) });// stain
																																																									// from
																																																									// dye
																																																									// -
																																																									// peach
				GameRegistry.addShapelessRecipe(new ItemStack(ItemNewContainer, 1, 7), new Object[] { new ItemStack(ItemNewCup, 1, 1), new ItemStack(Item.getItemById(351), 1, 14) });// stain
																																														// from
																																														// dye
				GameRegistry.addShapelessRecipe(new ItemStack(ItemNewContainer, 1, 8), new Object[] { new ItemStack(ItemNewCup, 1, 1), new ItemStack(Item.getItemById(351), 1, 1) });// stain
																																														// from
																																														// dye
																																														// -
																																														// red
				GameRegistry.addShapelessRecipe(new ItemStack(ItemNewContainer, 1, 9), new Object[] { new ItemStack(ItemNewCup, 1, 1), new ItemStack(Item.getItemById(351), 1, 11) });// stain
																																														// from
																																														// dye
																																														// -
																																														// yellow
				GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(351), 2, 3), new Object[] { new ItemStack(ItemNuts, 1, 3) });
				// new planks from new logs and stains
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 0), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 2), '&', newLogs });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 0), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 2), '&', newLogs2 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 0), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 2), '&', newLogs3 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 0), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 2), '&', Block.getBlockById(17) });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 1), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 3), '&', newLogs });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 1), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 3), '&', newLogs2 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 1), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 3), '&', newLogs3 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 1), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 3), '&', Block.getBlockById(17) });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 2), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 4), '&', newLogs });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 2), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 4), '&', newLogs2 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 2), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 4), '&', newLogs3 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 2), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 4), '&', Block.getBlockById(17) });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 3), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 5), '&', newLogs });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 3), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 5), '&', newLogs2 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 3), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 5), '&', newLogs3 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 3), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 5), '&', Block.getBlockById(17) });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 4), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 6), '&', newLogs });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 4), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 6), '&', newLogs2 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 4), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 6), '&', newLogs3 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 4), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 6), '&', Block.getBlockById(17) });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 5), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 7), '&', newLogs });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 5), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 7), '&', newLogs2 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 5), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 7), '&', newLogs3 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 5), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 7), '&', Block.getBlockById(17) });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 7), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 8), '&', newLogs });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 7), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 8), '&', newLogs2 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 7), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 8), '&', newLogs3 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 7), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 8), '&', Block.getBlockById(17) });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 9), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 9), '&', newLogs });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 9), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 9), '&', newLogs2 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 9), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 9), '&', newLogs3 });
				GameRegistry.addRecipe(new ItemStack(newPlanks, 32, 9), new Object[] { "&&&", "&*&", "&&&", '*', new ItemStack(ItemNewContainer, 1, 9), '&', Block.getBlockById(17) });
				GameRegistry.addRecipe(new ItemStack(ItemNewCup, 6, 0), new Object[] { "& &", "& &", "&&&", '&', Block.getBlockById(102) });
			}
			{// new glass
				GameRegistry.addRecipe(new ItemStack(newGlass, 5, 0), new Object[] { " & ", "&&&", " & ", '&', new ItemStack(Block.getBlockById(20)) });
				GameRegistry.addRecipe(new ItemStack(newGlass, 8, 1), new Object[] { "&&&", "&p&", "&&&", '&', new ItemStack(Block.getBlockById(20)), 'p', new ItemStack(Block.getBlockById(102)) });
				GameRegistry.addRecipe(new ItemStack(newGlass, 5, 2), new Object[] { "&s&", "s&s", "&s&", '&', new ItemStack(newGlass, 1, 1), 's', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(newGlass, 9, 3), new Object[] { "&&&", "&&&", "&&&", '&', new ItemStack(Block.getBlockById(20)) });
				GameRegistry.addRecipe(new ItemStack(newGlass, 5, 4), new Object[] { "&s&", "s&s", "&s&", '&', new ItemStack(newGlass, 1, 3), 's', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(newGlass, 4, 5), new Object[] { " & ", "& &", " & ", '&', new ItemStack(Block.getBlockById(20)) });
				GameRegistry.addRecipe(new ItemStack(newGlass, 5, 6), new Object[] { "&& ", " & ", " &&", '&', new ItemStack(Block.getBlockById(20)) });
				GameRegistry.addRecipe(new ItemStack(newGlass, 4, 7), new Object[] { "&& ", "&& ", "   ", '&', new ItemStack(Block.getBlockById(20)) });// 2x2
				GameRegistry.addRecipe(new ItemStack(newGlass, 4, 7), new Object[] { " &&", " &&", "   ", '&', new ItemStack(Block.getBlockById(20)) });// 2x2
				GameRegistry.addRecipe(new ItemStack(newGlass, 4, 7), new Object[] { "   ", "&& ", "&& ", '&', new ItemStack(Block.getBlockById(20)) });// 2x2
				GameRegistry.addRecipe(new ItemStack(newGlass, 4, 7), new Object[] { "   ", " &&", " &&", '&', new ItemStack(Block.getBlockById(20)) });// 2x2
				GameRegistry.addRecipe(new ItemStack(newGlass, 5, 8), new Object[] { "&s&", "s&s", "&s&", '&', new ItemStack(newGlass, 1, 7), 's', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(newGlass, 4, 9), new Object[] { "s&s", "& &", "s&s", '&', new ItemStack(Block.getBlockById(20)), 's', new ItemStack(Item.getItemById(280)) });// framed
																																																	// from
																																																	// sticks
				GameRegistry.addRecipe(new ItemStack(newGlass, 5, 10), new Object[] { "&s&", "s&s", "&s&", '&', new ItemStack(Block.getBlockById(20)), 's', new ItemStack(Item.getItemById(280)) });// framed
																																																	// from
																																																	// sticks
				GameRegistry.addRecipe(new ItemStack(newGlass, 5, 11), new Object[] { "s&s", "&s&", "s&s", '&', new ItemStack(Block.getBlockById(20)), 's', new ItemStack(Item.getItemById(280)) });// framed
																																																	// from
																																																	// sticks
				GameRegistry.addRecipe(new ItemStack(newGlass, 5, 12), new Object[] { "sss", "&&&", "sss", '&', new ItemStack(Block.getBlockById(20)), 's', new ItemStack(Item.getItemById(280)) });// framed
																																																	// from
																																																	// sticks
				GameRegistry.addRecipe(new ItemStack(newGlass, 4, 13), new Object[] { "& &", "   ", "& &", '&', new ItemStack(Block.getBlockById(20)) });
				GameRegistry.addRecipe(new ItemStack(newGlass, 5, 14), new Object[] { "ss ", "&& ", "&& ", '&', new ItemStack(Block.getBlockById(20)), 's', new ItemStack(Item.getItemById(280)) });// framed
																																																	// from
																																																	// sticks
				GameRegistry.addRecipe(new ItemStack(newGlass, 5, 14), new Object[] { " ss", " &&", " &&", '&', new ItemStack(Block.getBlockById(20)), 's', new ItemStack(Item.getItemById(280)) });// framed
																																																	// from
																																																	// sticks
				GameRegistry.addRecipe(new ItemStack(newGlass, 6, 15), new Object[] { "&s&", "&s&", "&s&", '&', new ItemStack(Block.getBlockById(20)), 's', new ItemStack(Item.getItemById(280)) });// framed
																																																	// from
																																																	// sticks
			}
			{// new fences from sticks and new planks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 0), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(newPlanks, 1, 0), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 0), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(newPlanks, 1, 0), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 1), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(newPlanks, 1, 1), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 1), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(newPlanks, 1, 1), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 2), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(newPlanks, 1, 2), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 2), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(newPlanks, 1, 2), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 3), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(newPlanks, 1, 3), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 3), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(newPlanks, 1, 3), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 4), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(newPlanks, 1, 4), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 4), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(newPlanks, 1, 4), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 5), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(newPlanks, 1, 5), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 5), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(newPlanks, 1, 5), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 6), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(newPlanks, 1, 6), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 6), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(newPlanks, 1, 6), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 7), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(newPlanks, 1, 7), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 7), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(newPlanks, 1, 7), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 8), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(newPlanks, 1, 8), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 8), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(newPlanks, 1, 8), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 9), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(newPlanks, 1, 9), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 9), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(newPlanks, 1, 9), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 10), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(newPlanks, 1, 10), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 10), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(newPlanks, 1, 10), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 11), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(newPlanks, 1, 11), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 11), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(newPlanks, 1, 11), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 12), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(newPlanks, 1, 12), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 12), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(newPlanks, 1, 12), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 13), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(crystalWood, 1, 2), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 13), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(crystalWood, 1, 2), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 14), new Object[] { "&*&", "&*&", "   ", '&', new ItemStack(crystalWood, 1, 3), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
				GameRegistry.addRecipe(new ItemStack(fence, 3, 14), new Object[] { "   ", "&*&", "&*&", '&', new ItemStack(crystalWood, 1, 3), '*', new ItemStack(Item.getItemById(280)) });// framed
																																															// from
																																															// sticks
			}
			{// flowerPot from vanilla flowerPot
				GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.flowerPot), new Object[] { Item.getItemById(390) });
			}
			{// camo
				GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.camo), new Object[] { new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.dye, 1, 5), new ItemStack(Items.dye, 1, 14), Blocks.dirt });
				GameRegistry.addShapelessRecipe(new ItemStack(FNBlocks.oneWayCamo), new Object[] { new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.dye, 1, 5), new ItemStack(Items.dye, 1, 14), Blocks.glass });
			}
			if (ForgottenNature.surfaceTeleporter) {
				GameRegistry.addShapelessRecipe(new ItemStack(FNItems.surfaceTeleportItem, 4, 0), new Object[] { new ItemStack(Items.ender_pearl), new ItemStack(Items.ender_pearl), new ItemStack(Items.blaze_powder) });
			}
		}
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
}
