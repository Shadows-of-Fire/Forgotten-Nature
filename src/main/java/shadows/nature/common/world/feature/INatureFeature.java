package shadows.nature.common.world.feature;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface INatureFeature {

	/**
	 * If this feature can generate at this position
	 */
	public boolean canGenerate(World world, BlockPos pos);

	/**
	 * Creates the feature in the given World.
	 */
	public void create(World world, BlockPos pos);
}
