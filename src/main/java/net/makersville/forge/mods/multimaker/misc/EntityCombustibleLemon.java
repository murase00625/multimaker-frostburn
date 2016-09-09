package net.makersville.forge.mods.multimaker.misc;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityCombustibleLemon extends EntityThrowable {
	
	public static final int ID = 0x0001;
	
	public EntityCombustibleLemon(World worldIn) {
		super(worldIn);
	}
	
	public EntityCombustibleLemon(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public EntityCombustibleLemon(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		
		this.worldObj.newExplosion(
					this, posX, posY, posZ, 2, true, false);
		// this.worldObj.createExplosion(this, posX, posY, posZ, 2, false);
		
		double accX = (Math.random() > 0.5) ? -0.1 * Math.random() : 0.1 * Math.random();
		//double accY = (Math.random() > 0.5) ? -0.5 : 0.5;
		double accZ = (Math.random() > 0.5) ? -0.1 * Math.random() : 0.1 * Math.random();
		
		this.worldObj.spawnEntityInWorld(
				new EntityLargeFireball(this.worldObj,
										posX, posY, posZ,
										accX, -0.01, accZ));
		
		accX = (Math.random() > 0.5) ? -0.1 * Math.random() : 0.1 * Math.random();
		accZ = (Math.random() > 0.5) ? -0.1 * Math.random() : 0.1 * Math.random();
		this.worldObj.spawnEntityInWorld(
				new EntitySmallFireball(this.worldObj,
										posX, posY, posZ,
										accX, -0.01, accZ));

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
	}

}
