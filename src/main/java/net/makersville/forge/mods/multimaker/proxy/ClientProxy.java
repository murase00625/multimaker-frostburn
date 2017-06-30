package net.makersville.forge.mods.multimaker.proxy;

import net.makersville.forge.mods.multimaker.MultiMakerBlocks;
import net.makersville.forge.mods.multimaker.MultiMakerItems;
import net.makersville.forge.mods.multimaker.misc.CombustibleLemon;
import net.makersville.forge.mods.multimaker.misc.EntityCombustibleLemon;
import net.makersville.student.examplemod.ItemDictionary;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	private String modid = "";
	
	public void setModID(String id) {
		modid = id;
	}
	
	@Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        
        RenderingRegistry.registerEntityRenderingHandler(
				EntityCombustibleLemon.class,
				new IRenderFactory<EntityCombustibleLemon>() {

					@Override
					public Render<? super EntityCombustibleLemon>
						createRenderFor(RenderManager manager) {
							return new RenderSnowball(manager,
								MultiMakerItems.getItem(CombustibleLemon.NAME),
								Minecraft.getMinecraft().getRenderItem());
					}
					
				});
        
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        
        MultiMakerItems.renderItems();
        MultiMakerBlocks.renderBlocks();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
