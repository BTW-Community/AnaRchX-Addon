package net.minecraft.src;

import btw.community.anarchx.block.aablockcampfire;
import btw.community.anarchx.block.aablockcoalcinders;
import btw.community.anarchx.item.aaitemash;
import btw.community.anarchx.tileentity.aatileentitycampfire;

/**
 * @author AnaRchX(sanedsf)
 *
 */

public class anarchxaddons extends FCAddOn {
    private static anarchxaddons instance;

    private anarchxaddons() {
        super("AnaRchX-Addons", "0.1.-dev", "AA");
    }

    private static int aacoalcindersblock_id = 4051;
    private static int aablockcampfire_id = 4052;
    private static int aaitemash_id = 19250;

    public static Item aaitemash;

    public static FCBlockFallingFullBlock aacoalcindersblock;
    public static Block aablockcampfire;

    @Override
    public void Initialize() {
        FCAddOnHandler.LogMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
        this.GetLanguageFilePrefix();

        aaitemash = new aaitemash(aaitemash_id-256);

        aacoalcindersblock = new aablockcoalcinders(aacoalcindersblock_id);
        Item.itemsList[aacoalcindersblock.blockID] = new ItemBlock(aacoalcindersblock.blockID - 256);

        aablockcampfire = new aablockcampfire(aablockcampfire_id);
        Item.itemsList[aablockcampfire.blockID] = new ItemBlock(aablockcampfire.blockID - 256);
        TileEntity.addMapping(aatileentitycampfire.class, "aatileentitycampfire");

        FCAddOnHandler.LogMessage(this.getName() + " Initialized");
    }

    @Override
    public String GetLanguageFilePrefix()
    {
        return "AA";
    }

    public static anarchxaddons getInstance() {
        if (instance == null)
            instance = new anarchxaddons();
        return instance;
    }
}
