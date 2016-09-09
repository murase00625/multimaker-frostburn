package net.makersville.forge.mods.multimaker.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GlassSword extends ItemSword {
	
	public static final String NAME = "glassSword";
	public static ToolMaterial GLASS =
			EnumHelper.addToolMaterial("GLASS", 1, 1, 3.0f, 36.0f, 15);
	
	public GlassSword() {
		super(GLASS);
		this.setRegistryName(NAME);
		this.setUnlocalizedName(this.getRegistryName().toString());
		GameRegistry.register(this);

		this.setCreativeTab(CreativeTabs.COMBAT);
		
		GameRegistry.addRecipe(
				new ItemStack(this),
				" g ",
				" g ",
				" w ",     
				'g', Blocks.GLASS_PANE,
				'w', Items.WOODEN_SWORD
				);
	}
}
