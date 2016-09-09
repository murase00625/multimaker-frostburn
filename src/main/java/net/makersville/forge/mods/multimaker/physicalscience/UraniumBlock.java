package net.makersville.forge.mods.multimaker.physicalscience;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UraniumBlock extends Block {
	
	public static final String NAME = "uraniumBlock";
	
	public UraniumBlock(Uranium uranium) {
		super(new Uranium.UraniumMaterial());
		defaultSettings();
		this.setRecipe(uranium);
	}
	
	public void defaultSettings() {
		ItemBlock ib = new ItemBlock(this);
		this.setRegistryName(NAME);
		ib.setRegistryName(NAME);
		this.setUnlocalizedName(this.getRegistryName().toString());
		GameRegistry.register(this);
		GameRegistry.register(ib);
		
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setLightLevel(0.85f);
		
	}
	
	public void setRecipe(Uranium u) {
		GameRegistry.addRecipe(new ItemStack(this),
				"uuu",
				"uuu",
				"uuu",
				'u', u);
	}
	

}
