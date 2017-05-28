package shadows.nature.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import shadows.nature.common.item.ItemFoodBasic;

public class NatureItems {

	/**
	 * A list of all items in Forgotten Nature. This list is populated by items
	 * on construction, ItemBlocks are not included.
	 */
	private static List<Item> NATURE_REGISTRY = new ArrayList<Item>();

	public static final Item BLACKBERRY = new ItemFoodBasic("blackberry", 2);
	public static final Item BLUEBERRY = new ItemFoodBasic("blueberry", 2);
	public static final Item RASPBERRY = new ItemFoodBasic("raspberry", 2);
	public static final Item HUCKLEBERRY = new ItemFoodBasic("huckleberry", 3);
	
	/**
	 * @return A list of all items in Forgotten Nature. Does not include
	 *         ItemBlocks.
	 */
	public static List<Item> getItems() {
		return NATURE_REGISTRY;
	}

	/**
	 * @param item
	 *            An item to be added to the list of all Forgotten Nature items.
	 */
	public static void add(Item item) {
		NATURE_REGISTRY.add(item);
	}

}
