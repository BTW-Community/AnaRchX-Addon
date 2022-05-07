package net.fabricmc.anarchxaddons;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.src.AnarchxAddons;

public class AnarchxAddonsPreLaunchInitializer implements PreLaunchEntrypoint {
    /**
     * Runs the PreLaunch entrypoint to register BTW-Addon.
     * Don't initialize anything else here, use
     * the method Initialize() in the Addon.
     */
    @Override
    public void onPreLaunch() {
        AnarchxAddons.getInstance();
    }
}
