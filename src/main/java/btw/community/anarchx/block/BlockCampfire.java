package btw.community.anarchx.block;

import btw.community.anarchx.tileentity.TileEntityCampfire;
import net.minecraft.src.*;

public class BlockCampfire extends BlockContainer
	{
	    public BlockCampfire(int iBlockID) {
			super( iBlockID, Material.iron);
			setUnlocalizedName( "AABlockCampfire" );
			this.setCreativeTab( CreativeTabs.tabBlock );
		}


		@Override
		public TileEntity createNewTileEntity(World var1) {
			return new TileEntityCampfire();
		}

	}