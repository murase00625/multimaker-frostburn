package net.makersville.forge.mods.multimaker.orchard;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Cherry extends ItemFood implements DroppableFruit {

	public static final String NAME = "cherry";
	
	// The drop probability settings for this fruit from a vanilla Leaves block.
	// { base chance, deviation, optimal temp, min temp, max temp, min rainfall,
	//   max rainfall, max number of drops }
	private float DROP_SETTINGS[] =
		{1f, 2.0f, 0.7f, 0.19f, 0.85f, 0.4f, 0.6f, 2f};
		
	@Override
	public float[] getDropStats() {
		return DROP_SETTINGS;
	}
	
	public Cherry() {
		super(5, 1.3f, false);
		this.setRegistryName(NAME);
		this.setUnlocalizedName(this.getRegistryName().toString());
		GameRegistry.register(this);
		
		this.setCreativeTab(CreativeTabs.FOOD);
	}

}
