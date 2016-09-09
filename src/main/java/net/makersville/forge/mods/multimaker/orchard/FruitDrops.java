package net.makersville.forge.mods.multimaker.orchard;

import java.util.ArrayList;
import java.util.Random;

import net.makersville.forge.mods.multimaker.MultiMakerItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FruitDrops {
	
	// The indices for the various data values used to calculate drop rate
	//  based on biome temp and rainfall.
	private static final int BASE_CHANCE = 0;
	private static final int DEVIATION = 1;
	private static final int OPTIMAL_TEMP = 2;
	private static final int TEMP_MIN = 3;
	private static final int TEMP_MAX = 4;
	private static final int RAIN_MIN = 5;
	private static final int RAIN_MAX = 6;
	private static final int MAX_DROP = 7;
	
	private static final int RAND_MAX = 300;
	
	private ArrayList<DroppableFruit> fruitList;
	
	public FruitDrops() {
		fruitList = new ArrayList<DroppableFruit>();
	}
	
	public void addFruit(DroppableFruit fruit) {
		fruitList.add(fruit);
	}
	
	@SubscribeEvent
	public void dropFruit(BlockEvent.HarvestDropsEvent evt) {
		
		if (evt.getState().getBlock() == Blocks.LEAVES) {
			
			Random rand = evt.getWorld().rand;
//			BiomeGenBase biome = evt.getWorld().getBiomeGenForCoords(evt.getPos());
			Biome biome = evt.getWorld().getBiomeGenForCoords(evt.getPos());
			
			float settings[];
			
			for (DroppableFruit fruit : fruitList) {
				settings = fruit.getDropStats();
				if (settings == null || settings.length != 8 && evt.getHarvester() != null) {
					evt.getHarvester().addChatComponentMessage(
							new TextComponentString(TextFormatting.RED +
									"The settings on " + ((ItemFood) fruit).getUnlocalizedName() + " are incorrect!"));
				} else if (fruitDropped(fruit.getDropStats(), biome, rand)) {
					int drop = rand.nextInt((int) fruit.getDropStats()[MAX_DROP]) + 1;
					
					evt.getDrops().add(new ItemStack(MultiMakerItems.getFruitForDrop(fruit), drop));
				}	
			}
			
		}
	}
	
	public boolean fruitDropped(float settings[], Biome biome, Random rand) {
		
		float temperature = biome.getTemperature();
		float rainfall = biome.getRainfall();
		
		if (temperature > settings[TEMP_MIN] &&
			temperature < settings[TEMP_MAX] &&
			rainfall > settings[RAIN_MIN] &&
			rainfall < settings[RAIN_MAX]) {
			int probability = (int) settings[BASE_CHANCE];
			int deviation = rand.nextInt((int) settings[DEVIATION]);
			int bonus = 0;
			
			if (Math.abs(temperature - settings[OPTIMAL_TEMP]) < 0.1) {
				bonus = 5;
			} else if (Math.abs(temperature - settings[OPTIMAL_TEMP]) < 0.3) {
				bonus = 2;
			}
			probability += deviation + bonus;
			
			if (probability >= (rand.nextInt(RAND_MAX) + 1)) {
				return true;
			}
		}
		
		return false;
	}
}
