package net.makersville.forge.mods.multimaker;

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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MultiMakerItems {
	
	public static Item orange;
	public static Item uranium;
	public static Item plumbum;
	public static Item cocoaNibs;
	public static Item chocolateLiquor;
	public static Item darkChocolate;
	public static Item milkChocolate;	
	public static Item cherry;
	public static Item lemon;
	public static Item glassSword;
	public static Item bacon;
	public static Item lemonade;
	public static Item combustibleLemon;
	
	public static void createItems() {
		uranium = new Uranium();
		plumbum = new LeadPb();
		orange = new OrangeFruit();
		cocoaNibs = new CocoaNibs();
		chocolateLiquor = new ChocolateLiquor();
		darkChocolate = new DarkChocolate();
		milkChocolate = new MilkChocolate();
		lemon = new Lemon();
		cherry = new Cherry();
		glassSword = new GlassSword();
		bacon = new Bacon();
		lemonade = new Lemonade();
		combustibleLemon = new CombustibleLemon();
	}
	
	
	/**
	 * Sets up rendering for custom items.
	 * Minecraft 1.9 and later enforces the use of registry names, which not only
	 * helps keep your code clean, but makes it easier to set up the renderer.
	 * 
	 * Custom entities that are heavily dependent on Items are also set up here.
	 */
	public static void renderItems() {
		ForgeUtils.renderItem(orange);
		ForgeUtils.renderItem(uranium);
		ForgeUtils.renderItem(plumbum);
		ForgeUtils.renderItem(cocoaNibs);
		ForgeUtils.renderItem(chocolateLiquor);
		ForgeUtils.renderItem(darkChocolate);
		ForgeUtils.renderItem(milkChocolate);
		ForgeUtils.renderItem(lemon);
		ForgeUtils.renderItem(cherry);
		ForgeUtils.renderItem(glassSword);
		ForgeUtils.renderItem(bacon);
		ForgeUtils.renderItem(lemonade);
		ForgeUtils.renderItem(combustibleLemon);
		
		EntityRegistry.registerModEntity(
				EntityCombustibleLemon.class,
				"Combustible Lemon",
				EntityCombustibleLemon.ID, 
				MultiMaker.instance, 
				64, 10, true);
	}
	
	@Deprecated
	public static void renderItems(String modid) {
		ForgeUtils.renderItem(modid, Uranium.NAME);
		ForgeUtils.renderItem(modid, LeadPb.NAME);
		ForgeUtils.renderItem(modid, OrangeFruit.NAME);
		ForgeUtils.renderItem(modid, CocoaNibs.NAME);
		ForgeUtils.renderItem(modid, ChocolateLiquor.NAME);
		ForgeUtils.renderItem(modid, DarkChocolate.NAME);
		ForgeUtils.renderItem(modid, MilkChocolate.NAME);
		ForgeUtils.renderItem(modid, Lemon.NAME);
		ForgeUtils.renderItem(modid, Cherry.NAME);
		ForgeUtils.renderItem(modid, GlassSword.NAME);
		ForgeUtils.renderItem(modid, Bacon.NAME);
		ForgeUtils.renderItem(modid, Lemonade.NAME);
	}
	
	public static void assignFruit(FruitDrops fd) {
		fd.addFruit((DroppableFruit) orange);
		fd.addFruit((DroppableFruit) cherry);
		fd.addFruit((DroppableFruit) lemon);
	}
	
	public static Item getFruitForDrop(DroppableFruit df) {
		
		if (df instanceof OrangeFruit) return orange;
		if (df instanceof Cherry) return cherry;
		if (df instanceof Lemon) return lemon;
		
		return null;
	}
	
	public static void registerRecipes() {
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
