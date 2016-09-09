package net.makersville.forge.mods.multimaker.physicalscience;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Uranium extends Item {
	public static final String NAME = "uranium";
	
	public static ToolMaterial URANIUM = 
			EnumHelper.addToolMaterial("URANIUM", 3, 1234, 10f, 3.6f, 6);
	
	public Uranium() {
		super();
		this.setRegistryName(NAME);
		this.setUnlocalizedName(this.getRegistryName().toString());
		GameRegistry.register(this);
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}
	
	public static class UraniumMaterial extends Material {
		public UraniumMaterial() {
			super(MapColor.OBSIDIAN);
			this.setRequiresTool();
		}
	}
	
}
