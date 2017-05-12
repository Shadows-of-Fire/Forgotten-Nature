package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNItems;

public class ItemNewSword extends ItemSword {
	@SideOnly(Side.CLIENT)
	private IIcon swordIcons;

	private int weaponDamage;
	private final ToolMaterial toolMaterial;

	public ItemNewSword(ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		this.maxStackSize = 1;
		this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
		this.weaponDamage = (int) (4 + par2EnumToolMaterial.getDamageVsEntity());
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return this.swordIcons;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		if (this == FNItems.cSwordItem)
			this.swordIcons = par1IconRegister.registerIcon("ForgottenNature:SwordLightCrystal");
		else if (this == FNItems.dcSwordItem)
			this.swordIcons = par1IconRegister.registerIcon("ForgottenNature:SwordDarkCrystal");
		else if (this == FNItems.oSwordItem)
			this.swordIcons = par1IconRegister.registerIcon("ForgottenNature:SwordObsidian");
		else if (this == FNItems.titanStoneSword)
			this.swordIcons = par1IconRegister.registerIcon("ForgottenNature:SwordTitanStone");
	}

	public float func_150893_a(ItemStack itemS1, Block block2) {
		if (block2 == Blocks.web) {
			return 15.0F;
		} else {
			Material material = block2.getMaterial();
			return material != Material.plants && material != Material.vine && material != Material.coral
					&& material != Material.leaves && material != Material.gourd ? 1.0F : 1.5F;
		}
	}

	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase,
			EntityLivingBase par3EntityLivingBase) {
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}

	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block block1, int par4, int par5,
			int par6, EntityLivingBase par7EntityLivingBase) {
		if ((double) block1.getBlockHardness(par2World, par4, par5, par6) != 0.0D) {
			par1ItemStack.damageItem(2, par7EntityLivingBase);
		}

		return true;
	}

	public int getDamageVsEntity(Entity par1Entity) {
		return this.weaponDamage;
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	public boolean func_150897_b(Block p_150897_1_)// can harvest???
	{
		return p_150897_1_ == Blocks.web;
	}

	public int getItemEnchantability() {
		return this.toolMaterial.getEnchantability();
	}

	public String getToolMaterialName() {
		return this.toolMaterial.toString();
	}

	public String getUnlocalizedName(ItemStack i) {
		if (this == FNItems.cSwordItem)
			return "csword";
		else if (this == FNItems.dcSwordItem)
			return "dsword";
		else if (this == FNItems.oSwordItem)
			return "osword";
		else
			return "tssword";
	}
}
