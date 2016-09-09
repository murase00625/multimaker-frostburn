package net.makersville.forge.mods.multimaker.misc;

import net.makersville.forge.mods.util.PotionSelect;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Lemonade extends ItemFood {
	
	public static final String NAME = "lemonade";
	int[] potionIDs = { PotionSelect.SATURATION,
						PotionSelect.REGEN };
	PotionSelect lemonPotions;
	
	public Lemonade() {
		super(4, 3f, false);
		this.setRegistryName(NAME);
		this.setUnlocalizedName(this.getRegistryName().toString());
		GameRegistry.register(this);
		
		// this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(1);
		this.setAlwaysEdible();
		
		lemonPotions = new PotionSelect(potionIDs);
		lemonPotions.selectPotion(this, 600, 2, 0.5f);
	}
	
	public EnumAction getItemUseAction(ItemStack food)
	{
		return EnumAction.DRINK;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn,
			EntityPlayer player) {
		super.onFoodEaten(stack, worldIn, player);
		lemonPotions.selectPotion(this, 600, 2, 0.5f);
		
		stack = new ItemStack(Items.GLASS_BOTTLE);
	}

}
