package net.makersville.forge.mods.multimaker.physicalscience;

import net.makersville.forge.mods.multimaker.MultiMakerBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UraniumBlock extends Block {
	
	public static final String NAME = "uraniumBlock";
	
	public UraniumBlock(Uranium uranium) {
		super(new Uranium.UraniumMaterial());
		MultiMakerBlocks.initializeBlock(
				this, NAME, CreativeTabs.BUILDING_BLOCKS);
		this.setLightLevel(0.85f);
		this.setRecipe(uranium);
	}
	
	public void setRecipe(Uranium u) {
		GameRegistry.addRecipe(new ItemStack(this),
				"uuu",
				"uuu",
				"uuu",
				'u', u);
	}
	

}
