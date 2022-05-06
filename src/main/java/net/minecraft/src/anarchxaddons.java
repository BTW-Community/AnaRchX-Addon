package net.minecraft.src;

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
    private static int aaitemash_id = 19250;

    public static Item aaitemash;

    public static FCBlockFallingFullBlock aacoalcindersblock;

    @Override
    public void Initialize() {
        FCAddOnHandler.LogMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
        this.GetLanguageFilePrefix();

        aaitemash = new aaitemash(aaitemash_id-256);
        aacoalcindersblock = new aablockcoalcinders(aacoalcindersblock_id);
        Item.itemsList[aacoalcindersblock.blockID] = new ItemBlock(aacoalcindersblock.blockID - 256);

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
