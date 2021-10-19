package net.minecraft.src;

public class AAItemAsh1 extends Item
{
    public AAItemAsh1(int par1)
    {
        super(par1);
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabDecorations);
        setUnlocalizedName("AAAshPile");
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        if ( !par2World.isRemote ){
        	par2World.playSoundAtEntity(par3EntityPlayer, "mob.irongolem.throw", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));


        	double dTargetXPos = par3EntityPlayer.posX;
        	double dTargetZPos = par3EntityPlayer.posZ;
        	FCEntitySoulSand sandEntity = (FCEntitySoulSand) EntityList.createEntityOfType(FCEntitySoulSand.class, par2World, par3EntityPlayer.posX, par3EntityPlayer.posY + 1.0D - (double)par3EntityPlayer.yOffset, par3EntityPlayer.posZ );
        	sandEntity.MoveTowards( dTargetXPos, dTargetZPos );
        	par2World.spawnEntityInWorld( sandEntity );
        }
        GenerateAshOnBurn( par2World, (int) par3EntityPlayer.posX, (int) par3EntityPlayer.posY, (int) par3EntityPlayer.posZ - 1 );
        return par1ItemStack;
    }
    
    protected void GenerateAshOnBurn( World world, int i, int j, int k )
	{
		for ( int iTempJ = j; iTempJ > 0; iTempJ-- )
		{
			if ( FCBlockAshGroundCover.CanAshReplaceBlock( world, i, iTempJ, k ) )
			{
		    	int iBlockBelowID = world.getBlockId( i, iTempJ - 1, k );
		    	Block blockBelow = Block.blocksList[iBlockBelowID];
		    	
		    	if ( blockBelow != null && blockBelow.CanGroundCoverRestOnBlock( world, i, iTempJ - 1, k ) )
		    	{
		    		world.setBlockWithNotify( i, iTempJ, k, FCBetterThanWolves.fcBlockAshGroundCover.blockID );
		    		
		    		break;
		    	}
			}
			else if ( world.getBlockId( i, iTempJ, k ) != Block.fire.blockID )
			{
				break;
			}
		}
	}
}
