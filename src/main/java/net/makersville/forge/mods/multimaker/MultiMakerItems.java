package net.makersville.forge.mods.multimaker;

import java.util.HashMap;

import net.makersville.forge.mods.multimaker.misc.Bacon;
import net.makersville.forge.mods.multimaker.misc.CombustibleLemon;
import net.makersville.forge.mods.multimaker.misc.EntityCombustibleLemon;
import net.makersville.forge.mods.multimaker.misc.GlassSword;
import net.makersville.forge.mods.multimaker.misc.Lemonade;
import net.makersville.forge.mods.multimaker.orchard.Cherry;
import net.makersville.forge.mods.multimaker.orchard.ChocolateLiquor;
import net.makersville.forge.mods.multimaker.orchard.CocoaNibs;
import net.makersville.forge.mods.multimaker.orchard.DarkChocolate;
import net.makersville.forge.mods.multimaker.orchard.DroppableFruit;
import net.makersville.forge.mods.multimaker.orchard.FruitDrops;
import net.makersville.forge.mods.multimaker.orchard.Lemon;
import net.makersville.forge.mods.multimaker.orchard.MilkChocolate;
import net.makersville.forge.mods.multimaker.orchard.OrangeFruit;
import net.makersville.forge.mods.multimaker.physicalscience.LeadPb;
import net.makersville.forge.mods.multimaker.physicalscience.Uranium;
import net.makersville.forge.mods.util.ForgeUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MultiMakerItems {
	
	public static HashMap<String,Item> itemMap =
			new HashMap<String,Item>();
	
	public static void initializeItem(
			Item item,
			String resourceName,
			CreativeTabs tab) {
		item.setRegistryName(resourceName);
		item.setUnlocalizedName(item.getRegistryName().toString());
		item.setCreativeTab(tab);
		GameRegistry.register(item);
	}
	
	public static void createItems() {
		itemMap.put(Uranium.NAME, new Uranium());
		itemMap.put(LeadPb.NAME, new LeadPb());
		itemMap.put(OrangeFruit.NAME, new OrangeFruit());
		itemMap.put(CocoaNibs.NAME, new CocoaNibs());
		itemMap.put(ChocolateLiquor.NAME, new ChocolateLiquor());
		itemMap.put(DarkChocolate.NAME, new DarkChocolate());
		itemMap.put(MilkChocolate.NAME, new MilkChocolate());
		itemMap.put(Lemon.NAME, new Lemon());
		itemMap.put(Cherry.NAME, new Cherry());
		itemMap.put(GlassSword.NAME, new GlassSword());
		itemMap.put(Bacon.NAME, new Bacon());
		itemMap.put(Lemonade.NAME, new Lemonade());
		itemMap.put(CombustibleLemon.NAME, new CombustibleLemon());

	}
	
	public static Item getItem(String resourceName) {
		return itemMap.get(resourceName);
	}
	
	
	/**
	 * Sets up rendering for custom items.
	 * Minecraft 1.9 and later enforces the use of registry names, which not only
	 * helps keep your code clean, but makes it easier to set up the renderer.
	 * 
	 * Custom entities that are heavily dependent on Items are also set up here.
	 */
	public static void renderItems() {
		for (Item i : itemMap.values()) {
			ForgeUtils.renderItem(i);
		}
		
		EntityRegistry.registerModEntity(
				EntityCombustibleLemon.class,
				"Combustible Lemon",
				EntityCombustibleLemon.ID, 
				MultiMaker.instance, 
				64, 10, true);
	}
	
	
	
	public static void assignFruit(FruitDrops fd) {
		fd.addFruit((DroppableFruit) itemMap.get(OrangeFruit.NAME));
		fd.addFruit((DroppableFruit) itemMap.get(Cherry.NAME));
		fd.addFruit((DroppableFruit) itemMap.get(Lemon.NAME));
	}
	
	public static Item getFruitForDrop(DroppableFruit df) {
		
		if (df instanceof OrangeFruit) return itemMap.get(OrangeFruit.NAME);
		if (df instanceof Cherry) return itemMap.get(Cherry.NAME);
		if (df instanceof Lemon) return itemMap.get(Lemon.NAME);
		
		return null;
	}
	
	public static void registerRecipes() {
		Item cocoaNibs = itemMap.get(CocoaNibs.NAME);
		Item chocolateLiquor = itemMap.get(ChocolateLiquor.NAME);
		Item darkChocolate = itemMap.get(DarkChocolate.NAME);
		Item milkChocolate = itemMap.get(MilkChocolate.NAME);
		Item lemon = itemMap.get(Lemon.NAME);
		Item combustibleLemon = itemMap.get(CombustibleLemon.NAME);
		GameRegistry.addSmelting(new ItemStack(Items.DYE, 1, EnumDyeColor.BROWN.getDyeDamage()),
				new ItemStack(cocoaNibs), 1f);
		
		GameRegistry.addShapelessRecipe(new ItemStack(chocolateLiquor),
				new Object[] {cocoaNibs});
		GameRegistry.addShapelessRecipe(new ItemStack(darkChocolate, 2),
				new Object[] {chocolateLiquor, Items.SUGAR});
		GameRegistry.addShapelessRecipe(new ItemStack(milkChocolate, 4),
				new Object[] {chocolateLiquor, Items.SUGAR, Items.MILK_BUCKET});
		GameRegistry.addShapelessRecipe(new ItemStack(lemon, 64),
				new Object[] {Items.CAKE});
		
		GameRegistry.addRecipe(new ItemStack(combustibleLemon, 4),
				"flf",
				"ltl",
				"flf",
				'l', lemon,
				't', Item.getItemFromBlock(Blocks.TNT),
				'f', Items.FIRE_CHARGE
				);
	}
	
}
