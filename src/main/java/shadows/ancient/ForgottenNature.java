/*package shadows.nature;

import org.apache.logging.log4j.Level;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.gen.RemoveBiomes;
import shadows.ancient.proxy.FNClientProxy;
import shadows.ancient.proxy.FNCommonProxy;

//@Mod(modid = "ForgottenNature", name = "ForgottenNature", version = "1.7.19")

public class ForgottenNature {
	@SidedProxy(clientSide = "ForgottenNature.Proxy.FNClientProxy", serverSide = "ForgottenNature.Proxy.FNCommonProxy")
	public static FNCommonProxy proxy;

	// block&Item Ids
	public static boolean newOres;
	public static boolean camo;
	public static int biomeIDIndex;

	public static int newSeedWeight;
	public static int bamSpreadBuffer;
	public static boolean bambooGeneration;
	public static boolean bambooSpread;
	public static boolean floatingIslands;
	public static boolean surfaceTeleporter;

	public static boolean lumberjack;
	public static boolean lumberjackDamage;
	public static int lumberjackPower;
	public static boolean carbonItems;
	// Trees and plants
	public static boolean AngelOak;
	public static boolean Eucalyptus;
	public static boolean Fig;
	public static boolean Jacaranda;
	public static boolean Sequoia;
	public static boolean Apple;
	public static boolean YellowMaple;
	public static boolean RedMaple;
	public static boolean DesertIronwood;
	public static boolean Cypress;
	public static boolean Cherry;
	public static boolean Joshua;
	public static boolean Willow;
	public static boolean decBush;
	public static boolean everBush;
	public static boolean palm;
	public static boolean dWillow;
	public static boolean cedar;
	public static boolean ginkgo;
	public static boolean poplar;
	public static boolean beech;
	public static boolean walnut;
	public static boolean wTopEucalyptus;
	public static boolean bukkit;
	public static boolean banana;
	public static boolean orange;
	public static boolean peach;
	public static boolean lemon;
	public static boolean blueberry;
	public static boolean raspberry;
	public static boolean blackberry;
	public static boolean huckleberry;
	// Biomes
	public static boolean redwoodForest;
	public static boolean tropicalForest;
	public static boolean tropicalForestHill;
	public static boolean redwoodForestHill;
	public static boolean crystalForest;
	public static boolean greatwoodForest;
	public static boolean mapleForest;
	public static boolean cherryBlossomWoodland;
	public static boolean eucalyptusForest;

	public static float redwoodForestHillMax;
	public static float redwoodForestHillMin;
	public static float tropicalForestHillMax;
	public static float tropicalForestHillMin;
	public static float eucalyptusForestMax;
	public static float eucalyptusForestMin;
	public static float greatwoodForestMax;
	public static float greatwoodForestMin;
	public static float mapleForestMax;
	public static float mapleForestMin;
	public static float cherryBlossomWoodlandMax;
	public static float cherryBlossomWoodlandMin;

	// vanBiomes
	public static boolean vanDesert;
	public static boolean vanExtremeHills;
	public static boolean vanMesa;
	public static boolean vanForest;
	public static boolean vanBirchForest;
	public static boolean vanRoofedForest;
	public static boolean vanJungle;
	public static boolean vanIcePlains;
	public static boolean vanSwampland;
	public static boolean vanTaiga;
	public static boolean vanMegaTaiga;

	public static boolean figFruit;
	public static boolean obsidianTools;
	public static boolean crystalTools;
	public static boolean craftGunpowder;
	public static boolean crystalMushrooms;

	public static int newTreePerChunkCount;

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		FNClientProxy.registerRenderStuff();

		new FNBlocks();// Initialize all blocks

		new FNItems();// Initialize all items

		new RemoveBiomes(vanDesert, vanExtremeHills, vanMesa, vanForest, vanBirchForest, vanRoofedForest, vanJungle,
				vanIcePlains, vanSwampland, vanTaiga, vanMegaTaiga);

		proxy.registerWorldStuff(biomeIDIndex, tropicalForest, redwoodForest, tropicalForestHill, redwoodForestHill,
				crystalForest, greatwoodForest, mapleForest, cherryBlossomWoodland, eucalyptusForest);

		FNClientProxy.newRecipes();
	}

	public static CreativeTabs tabFN = new CreativeTabs("tabFN") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			ItemStack iStack = new ItemStack(FNBlocks.fNSapling1); // FNiSapling
			return iStack.getItem();
		}

		@Override
		@SideOnly(Side.CLIENT)
		public int func_151243_f() {
			return 8;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try {
			cfg.load();

			biomeIDIndex = cfg.get(Configuration.CATEGORY_GENERAL, "Biome ID Index. 7 total", 70).getInt();

			/////////////////////////////////////////////////////////////////////////////////////////////////////
			// whether bamboo will generate and spread or not.
			bambooGeneration = cfg.get(Configuration.CATEGORY_GENERAL, "Bamboo Generation", true).getBoolean(true);
			bambooSpread = cfg.get(Configuration.CATEGORY_GENERAL, "Bamboo Spread", true).getBoolean(true);
			// bamboo spread
			Property bamSpreadb = cfg.get(Configuration.CATEGORY_GENERAL, "Bamboo Spread Buffer", 200);
			bamSpreadb.comment = "BAMBOO SPREAD BUFFER (below) sets the spread mitigation for bamboo. The higher it is set, the slower it spreads.";
			bamSpreadBuffer = bamSpreadb.getInt(200);
			if (bamSpreadBuffer < 1)
				bamSpreadBuffer = 1;
			// floating islands
			floatingIslands = cfg.get(Configuration.CATEGORY_GENERAL, "Generate Floating Islands", true)
					.getBoolean(true);
			surfaceTeleporter = cfg.get(Configuration.CATEGORY_GENERAL, "Allow Surface Teleporter", true)
					.getBoolean(true);
			// seed drop chance
			Property seedDrop = cfg.get(Configuration.CATEGORY_GENERAL, "Crop Seeds Drop Weight", 10);
			seedDrop.comment = "CROP SEEDS DROP WEIGHT (below) is the chance in which new seeds will drop from tall grass. Setting it to zero will DISABLE all new seed drops. "
					+ "10 sets the drop chance equal to wheat seeds. Higher numbers will make the new seeds more common than wheat seeds.";
			newSeedWeight = seedDrop.getInt(10);

			obsidianTools = cfg.get(Configuration.CATEGORY_GENERAL, "Crafting: Obsidian Tools and Armor", true)
					.getBoolean(true);
			crystalTools = cfg.get(Configuration.CATEGORY_GENERAL, "Crafting: Crystal Tools", true).getBoolean(true);
			lumberjack = cfg.get(Configuration.CATEGORY_GENERAL, "Lumberjack", true).getBoolean(true);
			lumberjackDamage = cfg.get(Configuration.CATEGORY_GENERAL, "Lumberjack Extra damage to Axe", true)
					.getBoolean(true);
			lumberjackPower = cfg.get(Configuration.CATEGORY_GENERAL, "Lumberjack Power", 1600).getInt();
			newOres = cfg.get(Configuration.CATEGORY_GENERAL, "Blocks: New Ores", false).getBoolean(false);
			camo = cfg.get(Configuration.CATEGORY_GENERAL, "Blocks: Camouflage", true).getBoolean(true);
			Fig = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Fig", true).getBoolean(true);
			Apple = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Apple", true).getBoolean(true);
			Cherry = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Cherry", true).getBoolean(true);
			Joshua = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Joshua", true).getBoolean(true);
			Willow = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Willow", true).getBoolean(true);
			Cypress = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Cypress", true).getBoolean(true);
			Sequoia = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Sequoia", true).getBoolean(true);
			RedMaple = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Red Maple", true).getBoolean(true);
			AngelOak = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Angel Oak", true).getBoolean(true);
			Jacaranda = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Jacaranda", true).getBoolean(true);
			Eucalyptus = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Eucalyptus", true).getBoolean(true);
			YellowMaple = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Yellow Maple", true).getBoolean(true);
			DesertIronwood = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Desert Ironwood", true).getBoolean(true);
			decBush = cfg.get(Configuration.CATEGORY_GENERAL, "Bushes: Deciduous Bush", true).getBoolean(true);
			everBush = cfg.get(Configuration.CATEGORY_GENERAL, "Bushes: Evergreen Bush", true).getBoolean(true);
			palm = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Palm", true).getBoolean(true);
			dWillow = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Desert Willow", true).getBoolean(true);
			cedar = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Cedar", true).getBoolean(true);
			ginkgo = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Ginkgo", true).getBoolean(true);
			poplar = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Poplar", true).getBoolean(true);
			beech = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Beech", true).getBoolean(true);
			walnut = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Walnut", true).getBoolean(true);
			wTopEucalyptus = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: WideTop Eucalyptus", true)
					.getBoolean(true);
			bukkit = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Bukkit Tree", true).getBoolean(true);
			banana = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Banana", true).getBoolean(true);
			orange = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Orange", true).getBoolean(true);
			peach = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Peach", true).getBoolean(true);
			lemon = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Lemon", true).getBoolean(true);
			blueberry = cfg.get(Configuration.CATEGORY_GENERAL, "Bushes: Blueberry Bush", true).getBoolean(true);
			raspberry = cfg.get(Configuration.CATEGORY_GENERAL, "Bushes: Raspberry Bush", true).getBoolean(true);
			blackberry = cfg.get(Configuration.CATEGORY_GENERAL, "Bushes: Blackberry Bush", true).getBoolean(true);
			huckleberry = cfg.get(Configuration.CATEGORY_GENERAL, "Bushes: Huckleberry Bush", true).getBoolean(true);
			redwoodForest = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Redwood Forest", true).getBoolean(true);
			tropicalForest = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Tropical Forest", true).getBoolean(true);
			tropicalForestHill = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Tropical Forest Hills", true)
					.getBoolean(true);
			redwoodForestHill = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Redwood Forest Hills", true)
					.getBoolean(true);
			crystalForest = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Crystal Forest", true).getBoolean(true);
			greatwoodForest = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Greatwood Forest", true)
					.getBoolean(true);
			mapleForest = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Maple Forest", true).getBoolean(true);
			eucalyptusForest = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Eucalyptus Forest", true)
					.getBoolean(true);
			cherryBlossomWoodland = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Cherry Blossom Woodland", true)
					.getBoolean(true);
			crystalMushrooms = cfg.get(Configuration.CATEGORY_GENERAL, "Blocks: Crystal Mushrooms", true)
					.getBoolean(true);
			carbonItems = cfg.get(Configuration.CATEGORY_GENERAL, "Recipes: Carbon Item", true).getBoolean(true);

			vanDesert = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Desert", true).getBoolean(true);
			vanExtremeHills = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Extreme Hills", true)
					.getBoolean(true);
			vanMesa = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Mesa", true).getBoolean(true);
			vanForest = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Forest", true).getBoolean(true);
			vanBirchForest = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Birch Forest", true)
					.getBoolean(true);
			vanRoofedForest = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Roofed Forest", true)
					.getBoolean(true);
			vanJungle = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Jungle", true).getBoolean(true);
			vanIcePlains = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Ice Plains", true).getBoolean(true);
			vanSwampland = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Swampland", true).getBoolean(true);
			vanTaiga = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Taiga", true).getBoolean(true);
			vanMegaTaiga = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Mega Taiga", true).getBoolean(true);

			redwoodForestHillMax = cfg
					.get(Configuration.CATEGORY_GENERAL, "Biomes: Redwood Forest Hill - Max Height", 10).getInt();
			if (redwoodForestHillMax > 20)
				redwoodForestHillMax = 20;
			redwoodForestHillMin = cfg
					.get(Configuration.CATEGORY_GENERAL, "Biomes: Redwood Forest Hill - Min Height", 1).getInt();
			if (redwoodForestHillMin < -10)
				redwoodForestHillMin = -10;
			tropicalForestHillMax = cfg
					.get(Configuration.CATEGORY_GENERAL, "Biomes: Tropical Forest Hill - Max Height", 10).getInt();
			if (tropicalForestHillMax > 20)
				tropicalForestHillMax = 20;
			tropicalForestHillMin = cfg
					.get(Configuration.CATEGORY_GENERAL, "Biomes: Tropical Forest Hill - Min Height", 1).getInt();
			if (tropicalForestHillMin < -10)
				tropicalForestHillMin = -10;
			eucalyptusForestMax = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Eucalyptus Forest - Max Height", 3)
					.getInt();
			if (eucalyptusForestMax > 20)
				eucalyptusForestMax = 20;
			eucalyptusForestMin = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Eucalyptus Forest - Min Height", 1)
					.getInt();
			if (eucalyptusForestMin < -10)
				eucalyptusForestMin = -10;
			greatwoodForestMax = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Greatwood Forest - Max Height", 5)
					.getInt();
			if (greatwoodForestMax > 20)
				greatwoodForestMax = 20;
			greatwoodForestMin = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Greatwood Forest - Min Height", 1)
					.getInt();
			if (greatwoodForestMin < -10)
				greatwoodForestMin = -10;
			mapleForestMax = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Maple Forest - Max Height", 3).getInt();
			if (mapleForestMax > 20)
				mapleForestMax = 20;
			mapleForestMin = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Maple Forest - Min Height", 1).getInt();
			if (mapleForestMin < -10)
				mapleForestMin = -10;
			Property cBWoodlandH = cfg.get(Configuration.CATEGORY_GENERAL,
					"Biomes: Cherry Blossom Woodland - Max Height", 3);
			cBWoodlandH.comment = "Height Settings (below) are height multipliers for each biome. Range: -10 to 20. Don't set the min height larger than the max.";
			cherryBlossomWoodlandMax = cBWoodlandH.getInt();
			if (cherryBlossomWoodlandMax > 20)
				cherryBlossomWoodlandMax = 20;
			cherryBlossomWoodlandMin = cfg
					.get(Configuration.CATEGORY_GENERAL, "Biomes: Cherry Blossom Woodland - Min Height", 1).getInt();
			if (cherryBlossomWoodlandMin < -10)
				cherryBlossomWoodlandMin = -10;

			figFruit = cfg.get(Configuration.CATEGORY_GENERAL, "Blocks: Fig Fruit", true).getBoolean(true);
			craftGunpowder = cfg.get(Configuration.CATEGORY_GENERAL, "Recipes: Gunpowder", true).getBoolean(true);
			newTreePerChunkCount = cfg.get(Configuration.CATEGORY_GENERAL, "New Trees Weight", 5).getInt();
		} catch (Throwable err) {
			FMLLog.log(Level.ERROR, err, "Forgotten Nature has a problem loading configuration", new Object[1]);
		} finally {
			cfg.save();
		}
	}
}*/