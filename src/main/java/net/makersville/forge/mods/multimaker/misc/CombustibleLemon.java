package net.makersville.forge.mods.multimaker.misc;

import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CombustibleLemon extends Item {
	

	public static final String NAME = "combustibleLemon";
	
	public CombustibleLemon() {
		this.setRegistryName(NAME);
		this.setUnlocalizedName(this.getRegistryName().toString());
		GameRegistry.register(this);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if (!playerIn.capabilities.isCreativeMode)
        {
            --itemStackIn.stackSize;
        }
		
		playerIn.swingArm(hand);
		
		if (!worldIn.isRemote)
        {
			Vec3d lookdir = playerIn.getLookVec();
            EntityCombustibleLemon ecl = new EntityCombustibleLemon(worldIn, playerIn);
            ecl.motionX = 2 * lookdir.xCoord;
            ecl.motionY = lookdir.yCoord;
            ecl.motionZ = 2 * lookdir.zCoord;
			worldIn.spawnEntityInWorld(ecl);
        }
		
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	}


	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(ChatFormatting.RED + "Burn your house down!!");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

}
