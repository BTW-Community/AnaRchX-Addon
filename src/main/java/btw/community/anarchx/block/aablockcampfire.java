package btw.community.anarchx.block;

import btw.community.anarchx.tileentity.aatileentitycampfire;
import net.minecraft.src.*;

public class aablockcampfire extends BlockContainer
	{
	    public aablockcampfire(int iBlockID) {
			super( iBlockID, Material.iron);
			setUnlocalizedName( "AABlockCampfire" );
			this.setCreativeTab( CreativeTabs.tabBlock );
		}


		@Override
		public TileEntity createNewTileEntity(World var1) {
			return new aatileentitycampfire();
		}

	}