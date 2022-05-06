package btw.community.anarchx.tileentity;

import net.minecraft.src.*;

import static net.minecraft.src.FCBlockLogDamaged.GetIsStump;

public class aatileentitycampfire extends TileEntity {

    public aatileentitycampfire()
    {
        super();
    }

    private boolean formed;
    private boolean foundInvalidBlock;
    private int inventoriesFound;
    private IInventory inventory;
    private int checkX, checkY, checkZ;

    public void updateEntity() {
        super.updateEntity();
        if (worldObj.isRemote) {
            checkMultiblock();
            if (formed) {
                trackTimer();
                createCoalcinders();
            }
        }
    }


    private void createCoalcinders() {

    }

    private void trackTimer() {

    }

    private void checkMultiblock() {
        checkX++;
        if (checkX > 1) {
            checkX = -1;
            checkY++;
            if (checkY > 1) {
                checkY = -1;
                checkZ++;
                if (checkZ > 1) {
                    checkZ = -1;
                    formed = !foundInvalidBlock && inventoriesFound == 1;
                    foundInvalidBlock = false;
                    inventoriesFound = 0;
                    FCAddOnHandler.LogMessage("formed: " + formed);
                }
            }
        }
        if (checkX == 0 && checkY == 0 && checkZ == 0) return;
        int iTempBlockID = worldObj.getBlockId(xCoord + checkX, yCoord + checkY, zCoord + checkZ);
        Block block = Block.blocksList[iTempBlockID];

        if (checkX == 0 && checkZ == 0 && checkY == 1) {
            if (block != Block.dirt && block != Block.grass) {
                foundInvalidBlock = true;
            }
        } else if (checkY == 1 && (checkX != 0 ^ checkZ != 0)) {
            TileEntity te = worldObj.getBlockTileEntity(xCoord + checkX, yCoord + checkY, zCoord + checkZ);
            if (te instanceof IInventory) {
                inventoriesFound++;
                inventory = (IInventory) te;
            } else if (block != FCBlockLog.wood) {
                foundInvalidBlock = true;
            }
        } else if (block != FCBlockLog.wood) {
            foundInvalidBlock = true;
        }
    }
}
