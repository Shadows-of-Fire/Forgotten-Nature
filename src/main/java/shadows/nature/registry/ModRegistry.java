package shadows.nature.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shadows.nature.common.block.BlockBushling;
import shadows.nature.common.block.BlockEnumLog;
import shadows.nature.common.block.BlockBushLeaves;
import shadows.nature.common.block.BlockMetaLeaves;
import shadows.nature.common.item.ItemFoodBasic;
import shadows.nature.util.ILateUpdateEnum;
import shadows.nature.util.NatureData;

public class ModRegistry {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final List<IRecipe> RECIPES = new ArrayList<IRecipe>();
	public static final List<ILateUpdateEnum> LATE_ENUMS = new ArrayList<ILateUpdateEnum>();
	
	public static final Item BLACKBERRY = new ItemFoodBasic("blackberry", 2);
	public static final Item BLUEBERRY = new ItemFoodBasic("blueberry", 2);
	public static final Item RASPBERRY = new ItemFoodBasic("raspberry", 2);
	public static final Item HUCKLEBERRY = new ItemFoodBasic("huckleberry", 3);

	public static final Block LEAF_1 = new BlockMetaLeaves("leaf");
	public static final Block LOG_1 = new BlockEnumLog<NatureData.LogSet1>("log1", NatureData.LogSet1.class);
	public static final Block LOG_2 = new BlockEnumLog<NatureData.LogSet2>("log2", NatureData.LogSet2.class);
	public static final Block LOG_3 = new BlockEnumLog<NatureData.LogSet3>("log3", NatureData.LogSet3.class);
	public static final Block LOG_4 = new BlockEnumLog<NatureData.LogSet4>("log4", NatureData.LogSet4.class);
	public static final Block BUSH = new BlockBushLeaves();
	public static final Block BUSHLING = new BlockBushling();

	@SubscribeEvent
	public void onBlockRegister(Register<Block> e) {
		e.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public void onItemRegister(Register<Item> e) {
		e.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public void onRecipeRegister(Register<IRecipe> e) {
		e.getRegistry().registerAll(RECIPES.toArray(new IRecipe[0]));
	}

}
