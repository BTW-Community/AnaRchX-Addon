package net.fabricmc.anarchxaddons;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.src.anarchxaddons;

public class anarchxaddonsPreLaunchInitializer implements PreLaunchEntrypoint {
    /**
     * Runs the PreLaunch entrypoint to register BTW-Addon.
     * Don't initialize anything else here, use
     * the method Initialize() in the Addon.
     */
    @Override
    public void onPreLaunch() {
        anarchxaddons.getInstance();
    }
}
