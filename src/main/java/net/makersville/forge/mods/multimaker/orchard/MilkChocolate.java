package net.makersville.forge.mods.multimaker.orchard;

import net.makersville.forge.mods.util.PotionSelect;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MilkChocolate extends ItemFood {

	public static final String NAME = "milkChocolate";
	
	public MilkChocolate() {
		super(8, 4f, false);
		this.setRegistryName(NAME);
		this.setUnlocalizedName(this.getRegistryName().toString());
		GameRegistry.register(this);
		
		this.setAlwaysEdible();
		this.setCreativeTab(CreativeTabs.FOOD);
		
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn,
			EntityLivingBase playerIn) {
		playerIn.addPotionEffect(
				new PotionEffect(
						Potion.getPotionById(PotionSelect.SPEED),
						480*20, 4));
		playerIn.addPotionEffect(
				new PotionEffect(
						Potion.getPotionById(PotionSelect.JUMP),
						480*20, 4));
		playerIn.addPotionEffect(
				new PotionEffect(
						Potion.getPotionById(PotionSelect.HASTE),
						480*20, 4));
		return super.onItemUseFinish(stack, worldIn, playerIn);
	}
	
	
	
}
