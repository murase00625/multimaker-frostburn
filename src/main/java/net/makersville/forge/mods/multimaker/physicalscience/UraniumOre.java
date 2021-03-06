package net.makersville.forge.mods.multimaker.physicalscience;

import java.util.Random;

import net.makersville.forge.mods.multimaker.MultiMakerBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UraniumOre extends Block {
	private Item uraniumDrop;
	private int meta=0;
	private int least=1;
	private int most=1;
	
	public static final String NAME = "uraniumOre";
	
	public UraniumOre(Uranium drop) {
		super(Material.ROCK);
		this.uraniumDrop = drop;
		MultiMakerBlocks.initializeBlock(
				this, NAME, CreativeTabs.BUILDING_BLOCKS);

		this.setHardness(15f);
		this.setResistance(20f);
		this.setHarvestLevel("pickaxe", 2);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return this.uraniumDrop;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return this.meta;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return this.least;
	}
	
}
