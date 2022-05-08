package net.fabricmc.anarchxaddons.mixin;

import btw.community.anarchx.tileentity.TileEntityCampfire;
import net.minecraft.src.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;


@Mixin(TileEntityRenderer.class)
public class TileEntityRendererMixin {
    /*private Map specialRendererMap = new HashMap();

    @Inject(at = @At("TAIL"), method = "<init>")
    private void inject(CallbackInfo ci){
        specialRendererMap.put( TileEntityCampfire.class, new FCTileEntityCampfireRenderer() );
    }
    Caused by: org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException:
    Invalid descriptor on
    anarchxaddons.mixins.json:TileEntityRendererMixin->
    @Inject::inject
    (Ljava/util/Map;Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;)V!
    Expected
    (Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;)V
    but found
    (Ljava/util/Map;Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;)V
    [INJECT Applicator Phase ->
    anarchxaddons.mixins.json:TileEntityRendererMixin ->
    Apply Injections ->
    ->
    Inject ->
    anarchxaddons.mixins.json:TileEntityRendererMixin->
    @Inject::inject(Ljava/util/Map;Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;)V]


    @Inject(at = @At("TAIL"), method = "readFromNBT", cancellable = true)
	public void readFromNBT(NBTTagCompound tag , CallbackInfo ci) {
		//super.readFromNBT( tag );
		if ( tag.hasKey( "fcCappedCounter" ) )
		{
			set_burntimecapped(tag.getInteger("fcCappedCounter"));
			FCAddOnHandler.LogMessage("[FCLogger] READ " + burntimecapped() + " from NBT");
		}
	}

	@Inject(at = @At("TAIL"), method = "writeToNBT", cancellable = true)
	public void writeToNBT(NBTTagCompound tag , CallbackInfo ci) {
		//super.readFromNBT( tag );
		tag.setInteger( "fcCappedCounter", burntimecapped() );
		FCAddOnHandler.LogMessage("[FCLogger] WROTE " + burntimecapped() + " to NBT");
	}

	@Inject(at = @At("TAIL"), method = "OnFirstLit", remap=false, cancellable = true)
	public void OnFirstLit(CallbackInfo ci){
		set_burntimecapped(0);
		FCAddOnHandler.LogMessage("[FCLogger] Capped timer = " + burntimecapped());
	}

	@Inject(at = @At("HEAD"), method = "RelightSmouldering", remap=false, cancellable = true)
	private void RelightSmouldering( CallbackInfo ci){
		NBTTagCompound tag = new NBTTagCompound();
		set_burntimecapped(tag.getInteger("fcCappedCounter"));
		FCAddOnHandler.LogMessage("[FCLogger] Capped timer = " + burntimecapped());
	}

	@Inject(at = @At("TAIL"), method = "updateEntity", cancellable = true)
	public void updateEntity( CallbackInfo ci) {
		//super.updateEntity();
		checkmultiblock();
		if (formed()){
			FCAddOnHandler.LogMessage("[FCLogger] It is formed");
			//if capped for ( 15 * FCUtilsMisc.m_iTicksPerMinute )
			//turn all log/smouldering blocks into coal cinders
			//
		}
	}
@Redirect(method = "AddBurnTime", at = @At(value = "FIELD", target = "Lnet.minecraft.src/FCTileEntityCampfire;AddBurnTime(I)V;m_iBurnTimeCountdown:I", opcode = Opcodes.PUTFIELD))
	public void AddBurnTime( FCTileEntityCampfire FCTileEntityCampfire, int iBurnTime ){
		FCTileEntityCampfire..m_iBurnTimeCountdown = 24000;
	}


@ModifyVariable(at = @At("STORE"), method = "AddBurnTime", ordinal = -1, remap=false)
	public int AddBurnTime(int x) {
		return 24000;
	}*/

}
