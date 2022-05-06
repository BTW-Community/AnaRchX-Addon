package net.fabricmc.anarchxaddons.mixin;

import net.minecraft.src.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FCTileEntityCampfire.class)
//@Mixin(FCBlockBed.class)
public class FCTileEntityCampfireMixin /*extends BlockBed {
	public FCTileEntityCampfireMixin(int par1) {
		super(par1);
	}

	@Inject(at = @At("HEAD"), method = "onBlockActivated", cancellable = true)
	private void onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int iFacing, float fXClick, float fYClick, float fZClick, CallbackInfoReturnable<Boolean> cir) {
		FCAddOnHandler.LogMessage("This worked");
		cir.setReturnValue(super.onBlockActivated(world, i, j, k, player, iFacing, fXClick, fYClick, fZClick));
	}*/
	extends TileEntity {
	int m_iBurnTimeSinceCapped = 0;
	private boolean formed = true;

	@Inject(at = @At("HEAD"), method = "readFromNBT", remap = false, cancellable = true)
	public void readFromNBT(NBTTagCompound tag , CallbackInfo ci) {
		//super.readFromNBT( tag );
		if ( tag.hasKey( "fcBurnTime" ) )
		{
			m_iBurnTimeSinceCapped = tag.getInteger( "fcCappedCounter" );
			FCAddOnHandler.LogMessage("[FCLogger] READ " + m_iBurnTimeSinceCapped + " from NBT");
		}
	}

	@Inject(at = @At("TAIL"), method = "writeToNBT", remap = false, cancellable = true)
	public void writeToNBT(NBTTagCompound tag , CallbackInfo ci) {
		//super.readFromNBT( tag );
		tag.setInteger( "fcCappedCounter", m_iBurnTimeSinceCapped );
		FCAddOnHandler.LogMessage("[FCLogger] WROTE " + m_iBurnTimeSinceCapped + " to NBT");
	}

	@Inject(at = @At("TAIL"), method = "updateEntity", remap = false, cancellable = true)
	public void updateEntity( CallbackInfo ci) {
		//super.updateEntity();
		checkmultiblock();
		if (formed){
			FCAddOnHandler.LogMessage("[FCLogger] It is formed");
			//if capped for ( 15 * FCUtilsMisc.m_iTicksPerMinute )
			//turn all log/smouldering blocks into coal cinders
			//
		}

	}

	@Inject(at = @At("TAIL"), method = "OnFirstLit", remap = false, cancellable = true)
	public void OnFirstLit(CallbackInfo ci){
		m_iBurnTimeSinceCapped = 0;
		FCAddOnHandler.LogMessage("[FCLogger] Capped timer = " + m_iBurnTimeSinceCapped);
	}

	@Inject(at = @At("HEAD"), method = "RelightSmouldering", remap = false, cancellable = true)
	private void RelightSmouldering( CallbackInfo ci){
		NBTTagCompound tag = new NBTTagCompound();
		m_iBurnTimeSinceCapped = tag.getInteger("fcCappedCounter");
		FCAddOnHandler.LogMessage("[FCLogger] Capped timer = " + m_iBurnTimeSinceCapped);
	}

	public void checkmultiblock(){
		System.out.println("[System] Checked the multiblock");
		FCAddOnHandler.LogMessage("[FCLogger] Checked the multiblock");
		//check each block around the campfire
		//if block is not from the chosen list
		//	return formed=false
		//else block is from the list
		//	check next block
		//	increment caped timer
		//	return formed=true
	}
}