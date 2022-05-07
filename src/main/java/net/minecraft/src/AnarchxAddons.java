package net.minecraft.src;

import btw.community.anarchx.block.BlockCampfire;
import btw.community.anarchx.block.BlockCoalCinders;
import btw.community.anarchx.item.ItemAsh;
import btw.community.anarchx.tileentity.TileEntityCampfire;

/**
 * @author AnaRchX(sanedsf)
 *
 */

public class AnarchxAddons extends FCAddOn {
    private static AnarchxAddons instance;

    private AnarchxAddons() {
        super("AnaRchX-Addons", "0.1.-dev", "AA");
    }

    private static int BlockCoalCinders_id = 4051;
    private static int BlockCampfire_id = 4052;
    private static int ItemAsh_id = 19250;

    public static Item ItemAsh;

    public static FCBlockFallingFullBlock BlockCoalCinders;
    public static Block BlockCampfire;

    @Override
    public void Initialize() {

        FCAddOnHandler.LogMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
        this.GetLanguageFilePrefix();

        // ------ Item ------
        ItemAsh = new ItemAsh(ItemAsh_id-256);

        // ------ Block ------
        BlockCoalCinders = new BlockCoalCinders(BlockCoalCinders_id);
        BlockCampfire = new BlockCampfire(BlockCampfire_id);

        // ------ ItemList ------
        Item.itemsList[BlockCoalCinders.blockID] = new ItemBlock(BlockCoalCinders.blockID - 256);
        Item.itemsList[BlockCampfire.blockID] = new ItemBlock(BlockCampfire.blockID - 256);

        // ------ TileEntity ------
        TileEntity.addMapping(TileEntityCampfire.class, "AATileEntityCampfire");

        FCAddOnHandler.LogMessage(this.getName() + " Initialized");
    }

    @Override
    public String GetLanguageFilePrefix()
    {
        return "AA";
    }

    public static AnarchxAddons getInstance() {
        if (instance == null)
            instance = new AnarchxAddons();
        return instance;
    }
}
