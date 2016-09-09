package net.makersville.forge.mods.multimaker.physicalscience;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class LeadPb extends Item {
	public static final String NAME = "plumbum";
	
	public static ToolMaterial LEAD =
			EnumHelper.addToolMaterial("LEAD", 1, 50, 2f, 1f, 1);
	
	public LeadPb() {
		this.setRegistryName(NAME);
		this.setUnlocalizedName(this.getRegistryName().toString());
		GameRegistry.register(this);
		
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}
	
	public static class LeadMaterial extends Material {
		public LeadMaterial() {
			super(MapColor.STONE);
			this.setRequiresTool();
		}
	}
}
