package btw.community.anarchx.tileentity;

import net.minecraft.src.Block;
import net.minecraft.src.FCAddOnHandler;
import net.minecraft.src.FCBlockLog;
import net.minecraft.src.TileEntity;

public class TileEntityCampfire extends TileEntity {

    public TileEntityCampfire() {
        super();
    }

    private boolean formed;
    private boolean foundInvalidBlock;
    //private int inventoriesFound;
    //private IInventory inventory;
    private int checkX;
    private int checkY;
    private int checkZ;

    public void updateEntity() {
        super.updateEntity();

        if (!worldObj.isRemote) {
            checkMultiblock(3);
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

    /**
     * Checks if the multiblock can be formed.
     * //* @param checkingX X offset
     * //* @param checkingY Y offset
     * //* @param checkingZ Z offset
     *
     * @param iSize How big is the size of the multiblock with no walls 3, 5, 7 etc.
     */
    private void checkMultiblock(int iSize) {

        iSize = (int) Math.ceil((double) iSize / 2);

        for (checkX = -iSize; checkX < iSize + 1; checkX++) {
            for (checkY = -iSize; checkY < iSize + 1; checkY++) {
                for (checkZ = -iSize; checkZ < iSize + 1; checkZ++) {

                    // Campfire Tile Entity
                    if (checkX == 0 && checkY == 0 && checkZ == 0) {
                        continue;
                    }

                    int iTempBlockID = worldObj.getBlockId(xCoord + checkX, yCoord + checkY, zCoord + checkZ);
                    Block block = Block.blocksList[iTempBlockID];

                    if (checkX == -iSize || checkX == iSize){
                        if (checkY == -iSize|| checkY == iSize) {
                            foundInvalidBlock = false;
                            continue;
                        }
                    }

                    if (checkZ == -iSize || checkZ == iSize){
                        if (checkY == -iSize|| checkY == iSize) {
                            foundInvalidBlock = false;
                            continue;
                        }
                    }

                    if (checkZ == -iSize || checkZ == iSize){
                        if (checkX == -iSize|| checkX == iSize) {
                            foundInvalidBlock = false;
                            continue;
                        }
                    }

                    if (checkY == iSize || checkY == -iSize ||
                            checkX == iSize || checkX == -iSize ||
                            checkZ == iSize || checkZ == -iSize)
                    {
                        if (block != FCBlockLog.blockIron) {
                            foundInvalidBlock = true;
                            //FCAddOnHandler.LogMessage("Found Invalid Block at walls " + (xCoord + checkX) + " ," + (yCoord + checkY) + " ," + (zCoord + checkZ));
                            return;
                        }
                    } else {
                        if (block != FCBlockLog.wood) {
                            foundInvalidBlock = true;
                            formed = false;
                            //FCAddOnHandler.LogMessage("Found Invalid Block at logs " + (xCoord + checkX) + " ," + (yCoord + checkY) + " ," + (zCoord + checkZ));
                            return;
                        }
                    }
                }
            }
        }

        formed = !foundInvalidBlock;
        foundInvalidBlock = false;
        //FCAddOnHandler.LogMessage("formed: " + formed);


        /*// Checks for a tile entity that is an inventory
        } else if (checkY == 1 && (checkX != 0 ^ checkZ != 0)) {
            TileEntity te = worldObj.getBlockTileEntity(xCoord + checkX, yCoord + checkY, zCoord + checkZ);
            if (te instanceof IInventory) {
                inventoriesFound++;
                inventory = (IInventory) te;
            }*/
    }
}
