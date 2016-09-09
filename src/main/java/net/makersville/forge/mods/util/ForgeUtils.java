package net.makersville.forge.mods.util;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ForgeUtils {
	
	/**
	 * Use renderItem(Item).
	 *
	 */
	@Deprecated
	public static void renderItem(String modid, String name) {
		String key = modid + ":" + name;
		Item modItem = GameRegistry.findItem(modid, name);
		
		ModelResourceLocation mrl =
			new ModelResourceLocation(key, "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(modItem, 0, mrl);
	}
	
	public static void renderItem(Item item) {
		ModelResourceLocation mrl =
				new ModelResourceLocation(item.getRegistryName(), "inventory");
		Minecraft.getMinecraft().getRenderItem()
		.getItemModelMesher().register(item, 0, mrl);
	}
	
	/**
	 * Use renderBlock(Block).
	 * 
	 */
	@Deprecated
	public static void renderBlock(String modid, String name, Block block) {
		String key = modid + ":" + name;
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(key, "inventory"));
	}
	
	public static void renderBlock(Block block) {
		ModelResourceLocation mrl =
				new ModelResourceLocation(block.getRegistryName(), "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(Item.getItemFromBlock(block), 0, mrl);
	}
}
