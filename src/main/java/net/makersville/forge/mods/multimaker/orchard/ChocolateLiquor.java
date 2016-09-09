package net.makersville.forge.mods.multimaker.orchard;

import net.makersville.forge.mods.util.PotionSelect;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ChocolateLiquor extends ItemFood {

	public static final String NAME = "chocolateLiquor";
	
	public ChocolateLiquor() {
		super(3, 1, false);
		this.setRegistryName(NAME);
		this.setUnlocalizedName(this.getRegistryName().toString());
		GameRegistry.register(this);
		
		this.setCreativeTab(CreativeTabs.FOOD);
		this.setPotionEffect(
				new PotionEffect(Potion.getPotionById(PotionSelect.SPEED), 240, 3), 1f);
		this.setAlwaysEdible();
		
	}
	
	
}
