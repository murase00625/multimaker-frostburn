package net.makersville.forge.mods.multimaker.physicalscience;

import net.makersville.forge.mods.multimaker.MultiMakerBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class LeadBlock extends Block {
	
	public static final String NAME = "leadBlock";
	private Item plumbum;
	
	public LeadBlock(Item pb) {
		super(new LeadPb.LeadMaterial());
		this.plumbum = pb;
		
		MultiMakerBlocks.initializeBlock(
				this, NAME, CreativeTabs.BUILDING_BLOCKS);
		
		GameRegistry.addRecipe(new ItemStack(this),
				"pp",
				"pp",
				'p', plumbum);

		GameRegistry.addRecipe(new ItemStack(plumbum, 4), "b", 'b', this);
	}
}
