package shadows.nature;

import ForgottenNature.TileEntities.TileEntityCamo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockWoodSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import shadows.nature.blocks.BlockCamo;
import shadows.nature.blocks.BlockCrystalBlock;
import shadows.nature.blocks.BlockCrystalLeaves;
import shadows.nature.blocks.BlockCrystalMushroom;
import shadows.nature.blocks.BlockCrystalMushroomBlock;
import shadows.nature.blocks.BlockCrystalStone;
import shadows.nature.blocks.BlockCrystalWood;
import shadows.nature.blocks.BlockFluidLightGas;
import shadows.nature.blocks.BlockGrapeTomCabPine;
import shadows.nature.blocks.BlockHempCotBamCorn;
import shadows.nature.blocks.BlockKCelOniGar;
import shadows.nature.blocks.BlockNetherLeaves;
import shadows.nature.blocks.BlockNetherLogs;
import shadows.nature.blocks.BlockNewFence;
import shadows.nature.blocks.BlockNewFlowerPot;
import shadows.nature.blocks.BlockNewFlowers;
import shadows.nature.blocks.BlockNewFruit;
import shadows.nature.blocks.BlockNewHalfPlanks;
import shadows.nature.blocks.BlockNewHalfStone;
import shadows.nature.blocks.BlockNewLeaves;
import shadows.nature.blocks.BlockNewLogs1;
import shadows.nature.blocks.BlockNewLogs2;
import shadows.nature.blocks.BlockNewLogs3;
import shadows.nature.blocks.BlockNewLogs4;
import shadows.nature.blocks.BlockNewPlanks;
import shadows.nature.blocks.BlockNewSap1;
import shadows.nature.blocks.BlockNewSap2;
import shadows.nature.blocks.BlockNewSap3;
import shadows.nature.blocks.BlockNewStairs;
import shadows.nature.blocks.BlockNewStone;
import shadows.nature.blocks.BlockNewTorch;
import shadows.nature.blocks.BlockOres;
import shadows.nature.blocks.BlockParsWChestRiceBroc;
import shadows.nature.blocks.BlockPeaTurnGinger;
import shadows.nature.blocks.BlockRope;
import shadows.nature.blocks.FNBlockGlass;
import shadows.nature.events.BreakBlockHandler;
import shadows.nature.items.ItemBamboo;
import shadows.nature.items.ItemBlockCamo;
import shadows.nature.items.ItemCrystalBlock;
import shadows.nature.items.ItemCrystalLeaves;
import shadows.nature.items.ItemCrystalStone;
import shadows.nature.items.ItemCrystalWood;
import shadows.nature.items.ItemFlowerPot;
import shadows.nature.items.ItemNetherLeaves;
import shadows.nature.items.ItemNetherLogs;
import shadows.nature.items.ItemNewFence;
import shadows.nature.items.ItemNewFlowers;
import shadows.nature.items.ItemNewGlass;
import shadows.nature.items.ItemNewHalfPlanks;
import shadows.nature.items.ItemNewHalfPlanks2;
import shadows.nature.items.ItemNewHalfStone;
import shadows.nature.items.ItemNewLeaves;
import shadows.nature.items.ItemNewLogs1;
import shadows.nature.items.ItemNewLogs2;
import shadows.nature.items.ItemNewLogs3;
import shadows.nature.items.ItemNewLogs4;
import shadows.nature.items.ItemNewPlanks1;
import shadows.nature.items.ItemNewPlanks2;
import shadows.nature.items.ItemNewSap;
import shadows.nature.items.ItemNewStone;
import shadows.nature.items.ItemOre;
import shadows.nature.items.ItemTorch;

public class FNBlocks {
	public static CreativeTabs tab = ForgottenNature.tabFN;

	public static Block newTorch = new BlockNewTorch().setStepSound(Block.soundTypeGlass).setLightLevel(1.0F)
			.setBlockName("crystalTorch").setCreativeTab(tab);
	public static Block mushroomCrystal = new BlockCrystalMushroom().setHardness(0.5F)
			.setStepSound(Block.soundTypeGlass).setLightLevel(0.8F).setBlockName("cMushroom").setCreativeTab(tab);
	public static Block mushroomCrystalBlock = new BlockCrystalMushroomBlock().setHardness(2.0F)
			.setStepSound(Block.soundTypeGlass).setLightLevel(0.9F).setBlockName("cMushroomBlock").setCreativeTab(tab);
	public static Block kCelOniGar = new BlockKCelOniGar();
	public static Block turnGinPea = new BlockPeaTurnGinger();
	public static Block parsWChestRiceBrocc = new BlockParsWChestRiceBroc();
	public static Block hempCotBamCorn = new BlockHempCotBamCorn().setCreativeTab(tab);
	public static Block grapeTomCabPine = new BlockGrapeTomCabPine();
	public static Block newFruit = new BlockNewFruit(FNItems.nutsItems, FNItems.fruitItems);
	public static Block newLeaves1 = new BlockNewLeaves(ForgottenNature.figFruit, newFruit, 7, 0).setCreativeTab(tab)
			.setBlockName("FNLeaves1");
	public static Block newLeaves2 = new BlockNewLeaves(false, null, 7, 1).setCreativeTab(tab)
			.setBlockName("FNLeaves2");
	public static Block newLeaves3 = new BlockNewLeaves(false, newFruit, 7, 2).setCreativeTab(tab)
			.setBlockName("FNLeaves3");
	public static Block newLeaves4 = new BlockNewLeaves(false, newFruit, 7, 3).setCreativeTab(tab)
			.setBlockName("FNLeaves4");
	public static Block newLeaves5 = new BlockNewLeaves(false, null, 7, 4).setCreativeTab(tab)
			.setBlockName("FNLeaves5");
	public static Block newLeaves6 = new BlockNewLeaves(false, null, 1, 5).setCreativeTab(tab)
			.setBlockName("FNLeaves6");
	public static Block netherLeaves = new BlockNetherLeaves().setCreativeTab(tab);
	public static Block newLogs1 = new BlockNewLogs1().setCreativeTab(tab);
	public static Block newLogs2 = new BlockNewLogs2().setCreativeTab(tab);
	public static Block newLogs3 = new BlockNewLogs3().setCreativeTab(tab);
	public static Block newLogs4 = new BlockNewLogs4();
	public static Block netherLogs = new BlockNetherLogs().setCreativeTab(tab);
	public static Block fNSapling1 = new BlockNewSap1().setHardness(0.0F).setStepSound(Block.soundTypeGrass)
			.setCreativeTab(tab);
	public static Block fNSapling2 = new BlockNewSap2().setHardness(0.0F).setStepSound(Block.soundTypeGrass)
			.setCreativeTab(tab);
	public static Block fNSapling3 = new BlockNewSap3().setHardness(0.0F).setStepSound(Block.soundTypeGrass)
			.setCreativeTab(tab);
	public static Block newPlanks1 = new BlockNewPlanks(0).setCreativeTab(tab).setBlockName("FNPlanks1");
	public static Block newPlanks2 = new BlockNewPlanks(1).setCreativeTab(tab).setBlockName("FNPlanks2");;
	public static BlockWoodSlab newHalfPlanks1 = (BlockWoodSlab) new BlockNewHalfPlanks(false, 0).setHardness(2.0F)
			.setResistance(5F).setStepSound(Block.soundTypeWood).setBlockName("halfPlank").setCreativeTab(tab);
	public static BlockWoodSlab newHalfPlanks2 = (BlockWoodSlab) new BlockNewHalfPlanks(false, 1).setHardness(2.0F)
			.setResistance(5F).setStepSound(Block.soundTypeWood).setBlockName("halfPlank2").setCreativeTab(tab);
	public static BlockWoodSlab newDoubleHalfPlanks1 = (BlockWoodSlab) new BlockNewHalfPlanks(true, 0).setHardness(2.0F)
			.setResistance(5F).setStepSound(Block.soundTypeWood).setBlockName("dHalfPlank");
	public static BlockWoodSlab newDoubleHalfPlanks2 = (BlockWoodSlab) new BlockNewHalfPlanks(true, 1).setHardness(2.0F)
			.setResistance(5F).setStepSound(Block.soundTypeWood).setBlockName("dHalfPlank2");
	public static Block crystalStone = new BlockCrystalStone().setCreativeTab(tab);
	public static Block crystalBlock = new BlockCrystalBlock().setCreativeTab(tab);
	public static Block crystalWood = new BlockCrystalWood().setCreativeTab(tab);
	public static Block crystalLeaves = new BlockCrystalLeaves().setCreativeTab(tab);
	public static Block newFence = new BlockNewFence("planks_oak", Material.wood).setCreativeTab(tab);
	public static Block fNFlowers = new BlockNewFlowers().setHardness(0.0F).setStepSound(Block.soundTypeGrass)
			.setCreativeTab(tab);
	public static Block newStairs1 = new BlockNewStairs(FNBlocks.newPlanks1, 0).setBlockName("FNWStairs1")
			.setCreativeTab(tab);
	public static Block newStairs2 = new BlockNewStairs(FNBlocks.newPlanks1, 1).setBlockName("FNWStairs2")
			.setCreativeTab(tab);
	public static Block newStairs3 = new BlockNewStairs(FNBlocks.newPlanks1, 2).setBlockName("FNWStairs3")
			.setCreativeTab(tab);
	public static Block newStairs4 = new BlockNewStairs(FNBlocks.newPlanks1, 3).setBlockName("FNWStairs4")
			.setCreativeTab(tab);
	public static Block newStairs5 = new BlockNewStairs(FNBlocks.newPlanks1, 4).setBlockName("FNWStairs5")
			.setCreativeTab(tab);
	public static Block newStairs6 = new BlockNewStairs(FNBlocks.newPlanks1, 5).setBlockName("FNWStairs6")
			.setCreativeTab(tab);
	public static Block newStairs7 = new BlockNewStairs(FNBlocks.newPlanks1, 6).setBlockName("FNWStairs7")
			.setCreativeTab(tab);
	public static Block newStairs8 = new BlockNewStairs(FNBlocks.newPlanks1, 7).setBlockName("FNWStairs8")
			.setCreativeTab(tab);
	// public static Block newStairs9; //acacia - removed as Mojang added acacia
	// to vanilla
	public static Block newStairs10 = new BlockNewStairs(FNBlocks.newPlanks1, 9).setBlockName("FNWStairs10")
			.setCreativeTab(tab);
	public static Block newStairs11 = new BlockNewStairs(FNBlocks.newPlanks1, 10).setBlockName("FNWStairs11")
			.setCreativeTab(tab);
	public static Block newStairs12 = new BlockNewStairs(FNBlocks.newPlanks1, 11).setBlockName("FNWStairs12")
			.setCreativeTab(tab);
	public static Block newStairs13 = new BlockNewStairs(FNBlocks.newPlanks1, 12).setBlockName("FNWStairs13")
			.setCreativeTab(tab);
	public static Block newStairs14 = new BlockNewStairs(FNBlocks.crystalWood, 2).setBlockName("FNWStairs14")
			.setLightLevel(0.8F).setCreativeTab(tab);
	public static Block newStairs15 = new BlockNewStairs(FNBlocks.crystalWood, 3).setBlockName("FNWStairs15")
			.setLightLevel(0.8F).setCreativeTab(tab);
	public static Block newStones = new BlockNewStone().setCreativeTab(tab);
	public static Block newOres1 = new BlockOres(11, 0).setCreativeTab(tab).setBlockName("FNOres1");
	public static Block newOres2 = new BlockOres(12, 1).setCreativeTab(tab).setBlockName("FNOres2");
	public static Block newStoneStairs1 = new BlockNewStairs(newStones, 5).setBlockName("FNSStairs1")
			.setCreativeTab(tab);
	public static Block newStoneStairs2 = new BlockNewStairs(newStones, 6).setBlockName("FNSStairs2")
			.setCreativeTab(tab);
	public static Block newStoneStairs3 = new BlockNewStairs(newStones, 7).setBlockName("FNSStairs3")
			.setCreativeTab(tab);
	public static Block newStoneStairs4 = new BlockNewStairs(newStones, 8).setBlockName("FNSStairs4")
			.setCreativeTab(tab);
	public static Block newCrystalStairs1 = new BlockNewStairs(FNBlocks.crystalBlock, 2).setBlockName("FNCStairs1")
			.setLightLevel(0.8F).setCreativeTab(tab);
	public static Block newCrystalStairs2 = new BlockNewStairs(FNBlocks.crystalBlock, 3).setBlockName("FNCStairs2")
			.setLightLevel(0.8F).setCreativeTab(tab);
	public static BlockSlab newHalfStone = (BlockSlab) new BlockNewHalfStone(false).setBlockName("FNHalfStone")
			.setCreativeTab(tab);
	public static BlockSlab newDoubleHalfStone = (BlockSlab) new BlockNewHalfStone(true).setBlockName("FNdHalfStone");
	public static Block FNGlass = new FNBlockGlass(Material.glass, false).setCreativeTab(tab);
	public static Block camo = new BlockCamo(false).setBlockName("falseBlock").setCreativeTab(tab).setHardness(0.5F)
			.setLightOpacity(100);
	public static Block oneWayCamo = new BlockCamo(true).setBlockName("oneWayCamo").setCreativeTab(tab)
			.setHardness(0.5F);

	public static Block flowerPot = new BlockNewFlowerPot().setHardness(0.0F).setStepSound(Block.soundTypeStone)
			.setBlockName("flowerPot").setCreativeTab(tab);
	public static Block rope = new BlockRope().setHardness(0.5F).setResistance(1F).setStepSound(Block.soundTypeGrass)
			.setBlockName("rope");

	public static Fluid hydrogen = new Fluid("Hydrogen").setGaseous(true).setDensity(-1).setViscosity(1)
			.setUnlocalizedName("H2");
	public static Fluid helium = new Fluid("Helium").setGaseous(true).setDensity(-1).setViscosity(1)
			.setUnlocalizedName("He");
	public static Fluid steam = new Fluid("Steam").setGaseous(true).setDensity(-1).setViscosity(3000)
			.setUnlocalizedName("H2Ov");
	public static Fluid methane = new Fluid("Methane").setGaseous(true).setDensity(-1).setViscosity(2)
			.setUnlocalizedName("CH4");
	public static Fluid oxygen = new Fluid("Oxygen").setGaseous(true).setDensity(20).setViscosity(2000)
			.setUnlocalizedName("O2");
	public static Fluid oil = new Fluid("Oil").setGaseous(true).setDensity(2000).setViscosity(3000)
			.setUnlocalizedName("oil");

	public static Block hydrogenBlock;
	public static Block steamBlock;
	public static Block heliumBlock;
	public static Block methaneBlock;
	public static Block oxygenBlock;
	public static Block oilBlock;

	public FNBlocks() {
		registerBlocks();
		regiserFluids();
		MinecraftForge.EVENT_BUS.register(new BreakBlockHandler());
	}

	public static void regiserFluids() {
		FluidRegistry.registerFluid(hydrogen);
		hydrogenBlock = new BlockFluidLightGas(hydrogen, Material.water, 0).setBlockName("H2");
		GameRegistry.registerBlock(hydrogenBlock, "H2");

		FluidRegistry.registerFluid(steam);
		steamBlock = new BlockFluidLightGas(steam, Material.water, 2).setBlockName("H2Ov");
		GameRegistry.registerBlock(steamBlock, "H2Ov");

		FluidRegistry.registerFluid(helium);
		heliumBlock = new BlockFluidLightGas(helium, Material.water, 1).setBlockName("He");
		GameRegistry.registerBlock(heliumBlock, "He");

		FluidRegistry.registerFluid(methane);
		methaneBlock = new BlockFluidLightGas(methane, Material.water, 3).setBlockName("CH4");
		GameRegistry.registerBlock(methaneBlock, "CH4");

		FluidRegistry.registerFluid(oxygen);
		oxygenBlock = new BlockFluidLightGas(oxygen, Material.water, 4).setBlockName("O2");
		GameRegistry.registerBlock(oxygenBlock, "O2");

		FluidRegistry.registerFluid(oil);
		oilBlock = new BlockFluidLightGas(oil, Material.water, 5).setBlockName("oil");
		GameRegistry.registerBlock(oilBlock, "oil");

		FluidContainerRegistry.registerFluidContainer(oil, new ItemStack(FNItems.newBucketItems, 1, 1),
				new ItemStack(Items.bucket));

	}

	public static void registerBlocks() {
		GameRegistry.registerBlock(newTorch, ItemTorch.class, "Crystal Torch");
		GameRegistry.registerBlock(mushroomCrystal, "cMushroom");
		GameRegistry.registerBlock(mushroomCrystalBlock, "cMushroomBlock");
		GameRegistry.registerBlock(kCelOniGar, "newCrops1");
		GameRegistry.registerBlock(turnGinPea, "newCrops2");
		GameRegistry.registerBlock(parsWChestRiceBrocc, "newCrops3");
		GameRegistry.registerBlock(hempCotBamCorn, ItemBamboo.class, "newCrops4");
		GameRegistry.registerBlock(grapeTomCabPine, "newCrops5");
		GameRegistry.registerBlock(newFruit, "FNFruit");
		GameRegistry.registerBlock(newLeaves1, ItemNewLeaves.class, "FNLeaves1");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newLeaves1), 30, 60);
		GameRegistry.registerBlock(newLeaves2, ItemNewLeaves.class, "FNLeaves2");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newLeaves2), 30, 60);
		GameRegistry.registerBlock(newLeaves3, ItemNewLeaves.class, "FNLeaves3");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newLeaves3), 30, 60);
		GameRegistry.registerBlock(newLeaves4, ItemNewLeaves.class, "FNLeaves4");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newLeaves4), 30, 60);
		GameRegistry.registerBlock(newLeaves5, ItemNewLeaves.class, "FNLeaves5");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newLeaves5), 30, 60);
		GameRegistry.registerBlock(newLeaves6, ItemNewLeaves.class, "FNLeaves6");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newLeaves6), 30, 60);
		GameRegistry.registerBlock(netherLeaves, ItemNetherLeaves.class, "netherLeaves");
		GameRegistry.registerBlock(newLogs1, ItemNewLogs1.class, "FNLogs1");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newLogs1), 5, 5);
		GameRegistry.registerBlock(newLogs2, ItemNewLogs2.class, "FNLogs2");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newLogs2), 5, 5);
		GameRegistry.registerBlock(newLogs3, ItemNewLogs3.class, "FNLogs3");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newLogs3), 5, 5);
		GameRegistry.registerBlock(newLogs4, ItemNewLogs4.class, "FNLogs4");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newLogs4), 5, 5);
		GameRegistry.registerBlock(netherLogs, ItemNetherLogs.class, "netherFNLogs");
		GameRegistry.registerBlock(FNBlocks.fNSapling1, ItemNewSap.class, "FNSapling1");
		GameRegistry.registerBlock(FNBlocks.fNSapling2, ItemNewSap.class, "FNSapling2");
		GameRegistry.registerBlock(FNBlocks.fNSapling3, ItemNewSap.class, "FNSapling3");
		GameRegistry.registerBlock(newPlanks1, ItemNewPlanks1.class, "FNPlanks1");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newPlanks1), 5, 20);
		GameRegistry.registerBlock(newPlanks2, ItemNewPlanks2.class, "FNPlanks2");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newPlanks2), 5, 20);

		GameRegistry.registerBlock(crystalStone, ItemCrystalStone.class, "crystalStone");
		GameRegistry.registerBlock(crystalBlock, ItemCrystalBlock.class, "crystalBlock");
		GameRegistry.registerBlock(crystalWood, ItemCrystalWood.class, "crystalWood");
		GameRegistry.registerBlock(crystalLeaves, ItemCrystalLeaves.class, "crystalLeaves");
		GameRegistry.registerBlock(newFence, ItemNewFence.class, "nFence");
		GameRegistry.registerBlock(fNFlowers, ItemNewFlowers.class, "newflowers");

		GameRegistry.registerBlock(newStairs1, "FNWStairs1");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs1), 5, 20);
		GameRegistry.registerBlock(newStairs2, "FNWStairs2");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs2), 5, 20);
		GameRegistry.registerBlock(newStairs3, "FNWStairs3");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs3), 5, 20);
		GameRegistry.registerBlock(newStairs4, "FNWStairs4");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs4), 5, 20);
		GameRegistry.registerBlock(newStairs5, "FNWStairs5");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs5), 5, 20);
		GameRegistry.registerBlock(newStairs6, "FNWStairs6");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs6), 5, 20);
		GameRegistry.registerBlock(newStairs7, "FNWStairs7");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs7), 5, 20);
		GameRegistry.registerBlock(newStairs8, "FNWStairs8");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs8), 5, 20);
		GameRegistry.registerBlock(newStairs10, "FNWStairs10");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs10), 5, 20);
		GameRegistry.registerBlock(newStairs11, "FNWStairs11");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs11), 5, 20);
		GameRegistry.registerBlock(newStairs12, "FNWStairs12");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs12), 5, 20);
		GameRegistry.registerBlock(newStairs13, "FNWStairs13");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs13), 5, 20);
		GameRegistry.registerBlock(newStairs14, "FNWStairs14");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs14), 5, 20);
		GameRegistry.registerBlock(newStairs15, "FNWStairs15");
		Blocks.fire.func_149842_a(Block.getIdFromBlock(newStairs15), 5, 20);

		GameRegistry.registerBlock(newStones, ItemNewStone.class, "FNStone");

		if (ForgottenNature.newOres) {
			GameRegistry.registerBlock(newOres1, ItemOre.class, "FNOres1");
			GameRegistry.registerBlock(newOres2, ItemOre.class, "FNOres2");
		}

		GameRegistry.registerBlock(newStoneStairs1, "FNSStairs1");
		GameRegistry.registerBlock(newStoneStairs2, "FNSStairs2");
		GameRegistry.registerBlock(newStoneStairs3, "FNSStairs3");
		GameRegistry.registerBlock(newStoneStairs4, "FNSStairs4");
		GameRegistry.registerBlock(newCrystalStairs1, "FCSStairs1");
		GameRegistry.registerBlock(newCrystalStairs2, "FCSStairs2");
		GameRegistry.registerBlock(FNBlocks.newHalfPlanks1, ItemNewHalfPlanks.class, "halfPlank");
		GameRegistry.registerBlock(FNBlocks.newHalfPlanks2, ItemNewHalfPlanks2.class, "halfPlank2");
		GameRegistry.registerBlock(FNBlocks.newDoubleHalfPlanks1, ItemNewHalfPlanks.class, "dHalfPlank");
		GameRegistry.registerBlock(FNBlocks.newDoubleHalfPlanks2, ItemNewHalfPlanks2.class, "dHalfPlank2");
		GameRegistry.registerBlock(FNBlocks.newHalfStone, ItemNewHalfStone.class, "FNHalfStone");
		GameRegistry.registerBlock(FNBlocks.newDoubleHalfStone, ItemNewHalfStone.class, "FNdHalfStone");
		GameRegistry.registerBlock(FNGlass, ItemNewGlass.class, "nGlass");

		if (ForgottenNature.camo) {
			GameRegistry.registerTileEntity(TileEntityCamo.class, "camouflage");// tileentity
			GameRegistry.registerBlock(camo, ItemBlockCamo.class, "falseBlock");
			GameRegistry.registerBlock(oneWayCamo, ItemBlockCamo.class, "oneWayCamo");
		}

		GameRegistry.registerBlock(flowerPot, ItemFlowerPot.class, "flowerPot");
		Item.getItemFromBlock(flowerPot).setTextureName("ForgottenNature:FlowerPotItem");
		GameRegistry.registerBlock(rope, "rope");
	}
}
