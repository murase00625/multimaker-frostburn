package net.makersville.forge.mods.multimaker;

import java.util.HashMap;

import net.makersville.forge.mods.multimaker.physicalscience.LeadBlock;
import net.makersville.forge.mods.multimaker.physicalscience.LeadPb;
import net.makersville.forge.mods.multimaker.physicalscience.Uranium;
import net.makersville.forge.mods.multimaker.physicalscience.UraniumBlock;
import net.makersville.forge.mods.multimaker.physicalscience.UraniumOre;
import net.makersville.forge.mods.util.ForgeUtils;
import net.minecraft.block.Block;

public class MultiMakerBlocks {
	
	public static HashMap<String, Block> blockMap =
			new HashMap<String, Block>();
	
	public static Block uraniumOre;
	public static Block leadBlock;
	public static Block uraniumBlock;
		
	public static void createBlocks() {
		uraniumOre = new UraniumOre(
			(Uranium) MultiMakerItems.getItem(Uranium.NAME));
		leadBlock = new LeadBlock(
			MultiMakerItems.getItem(LeadPb.NAME));
		uraniumBlock = new UraniumBlock(
			(Uranium) MultiMakerItems.getItem(Uranium.NAME));
		blockMap.put(UraniumOre.NAME, uraniumOre);
		blockMap.put(LeadBlock.NAME, leadBlock);
		blockMap.put(UraniumBlock.NAME, uraniumBlock);
	}
	
	public static Block getBlock (String resourceName) {
		return blockMap.get(resourceName);
	}
	
	public static void renderBlocks() {
		for (Block b : blockMap.values()) {
			ForgeUtils.renderBlock(b);
		}
	}
	
}
