package ForgottenNature.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockExplosive extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon field_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_b;

    public BlockExplosive()
    {
        super(Material.tnt);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 0 ? this.field_b : (side == 1 ? this.field_a : this.blockIcon);
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World world, int i, int j, int k)
    {
        super.onBlockAdded(world, i, j, k);

        if (world.isBlockIndirectlyGettingPowered(i, j, k))
        {
            this.onBlockDestroyedByPlayer(world, i, j, k, 1);
            world.setBlockToAir(i, j, k);
        }
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, Block blk)
    {
        if (world.isBlockIndirectlyGettingPowered(i, j, k))
        {
            this.onBlockDestroyedByPlayer(world, i, j, k, 1);
            world.setBlockToAir(i, j, k);
        }
    }

    public int quantityDropped(Random ran)
    {
        return 1;
    }

    /**
     * Called upon the block being destroyed by an explosion
     */
    public void onBlockDestroyedByExplosion(World world, int i, int j, int k, Explosion explo)
    {
        if (!world.isRemote)
        {
            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(world, (double)((float)i + 0.5F), (double)((float)j + 0.5F), (double)((float)k + 0.5F), explo.getExplosivePlacedBy());
            entitytntprimed.fuse = world.rand.nextInt(entitytntprimed.fuse / 4) + entitytntprimed.fuse / 8;
            world.spawnEntityInWorld(entitytntprimed);
        }
    }

    public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int met)
    {
        this.prime(world, i, j, k, met, (EntityLivingBase)null);
    }

    public void prime(World p_150114_1_, int p_150114_2_, int p_150114_3_, int p_150114_4_, int p_150114_5_, EntityLivingBase p_150114_6_)
    {
        if (!p_150114_1_.isRemote)
        {
            if ((p_150114_5_ & 1) == 1)
            {
                EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(p_150114_1_, (double)((float)p_150114_2_ + 0.5F), (double)((float)p_150114_3_ + 0.5F), (double)((float)p_150114_4_ + 0.5F), p_150114_6_);
                p_150114_1_.spawnEntityInWorld(entitytntprimed);
                p_150114_1_.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
            }
        }
    }

    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer eplayer, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (eplayer.getCurrentEquippedItem() != null && eplayer.getCurrentEquippedItem().getItem() == Items.flint_and_steel)
        {
            this.prime(world, i, j, k, 1, eplayer);
            world.setBlockToAir(i, j, k);
            eplayer.getCurrentEquippedItem().damageItem(1, eplayer);
            return true;
        }
        else
        {
            return super.onBlockActivated(world, i, j, k, eplayer, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
        }
    }

    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        if (entity instanceof EntityArrow && !world.isRemote)
        {
            EntityArrow entityarrow = (EntityArrow)entity;

            if (entityarrow.isBurning())
            {
                this.prime(world, i, j, k, 1, entityarrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase)entityarrow.shootingEntity : null);
                world.setBlockToAir(i, j, k);
            }
        }
    }

    public boolean canDropFromExplosion(Explosion explo)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconReg)
    {
        this.blockIcon = iconReg.registerIcon(this.getTextureName() + "_side");
        this.field_a = iconReg.registerIcon(this.getTextureName() + "_top");
        this.field_b = iconReg.registerIcon(this.getTextureName() + "_bottom");
    }
}
