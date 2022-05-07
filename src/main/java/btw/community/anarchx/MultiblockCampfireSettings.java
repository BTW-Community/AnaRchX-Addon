package btw.community.anarchx;

public class MultiblockCampfireSettings {

	public static int m_iBurnTimeSinceCapped = 0;
	public static boolean formed = false;

	public static void checkMultiblock(){
		//FCAddOnHandler.LogMessage("[FCLogger] Checked the multiblock");
		//check each block around the 3x3 of the center campfire
		//if any of those blocks is not from the chosen list of accepted wall blocks
		//	return formed=false |it is not considered a multiblock|
		//else |block is from the list|
		//	check next block
		//if all blocks passed the walls test
		//	increment caped timer
		//	return formed=true
	}

	public static void checkOutput(){
		//if multiblock formed
		//if m_iBurnTimeSinceCapped > (15 * FCUtilsMisc.m_iTicksPerMinute)
		//
	}

	//geters

	public static int burntimecapped()
	{
		return m_iBurnTimeSinceCapped;
	}

	public static boolean formed()
	{
		return formed;
	}

	//setters

	public static void set_burntimecapped(int par)
	{
		m_iBurnTimeSinceCapped=par;
	}

	public static void set_formed(boolean par)
	{
		formed=par;
	}

	/*
	@Override
	public void RandomUpdateTick( World world, int i, int j, int k, Random rand )
	{
		if (world.getGameRules().getGameRuleBooleanValue("doFireTick")) {
			if ( !CheckForGoOutInRain( world, i, j, k ) )
			{			
				net.minecraft.src.FCBlockFire.CheckForSmoulderingSpreadFromLocation( world, i, j, k );

				int iBurnLevel = GetBurnLevel( world, i, j, k );

				if ( iBurnLevel == 0 )
				{
					if ( !net.minecraft.src.FCBlockFire.HasFlammableNeighborsWithinSmoulderRange( world, i, j, k ) )
					{
						int iMetadata = world.getBlockMetadata( i, j, k );

						iMetadata = SetBurnLevel( iMetadata, 1 );

						if ( IsSupportedBySolidBlocks( world, i, j, k ) )
						{
							// intentionally leaves the flag as true if it's already set

							iMetadata = SetShouldSuppressSnapOnFall( iMetadata, true );
						}

						world.setBlockMetadataWithNotify( i, j, k, iMetadata );

						ScheduleCheckForFall( world, i, j, k );
					}
				}
				else if ( rand.nextInt( m_iChanceOfDecay ) == 0 && iscovered( world, i, j, k ))  // added by Anarchx
				{
					if ( iBurnLevel < 1 ) //get to the end at a quicker stage
					{
						SetBurnLevel( world, i, j, k, iBurnLevel + 1 );
					}
					else
					{
						int result = rand.nextInt( m_iChanceOfCoalCinders );
						if ( result <= 70 && iscovered( world, i, j, k ))
						{
							world.setBlockWithNotify( i, j, k, aadefs.coalcindersblock.blockID );
							world.playAuxSFX( FCBetterThanWolves.m_iFireFizzSoundAuxFXID, i, j, k, 0 );
						}
						else
						{
							ConvertToCinders( world, i, j, k );
							world.playAuxSFX( FCBetterThanWolves.m_iFireFizzSoundAuxFXID, i, j, k, 0 );
						}
					}
				}
				else if ( rand.nextInt( m_iChanceOfDecay ) == 0 ) //original FC method without fizz
				{
					if ( iBurnLevel < 3 )
					{
						SetBurnLevel( world, i, j, k, iBurnLevel + 1 );
					}
					else
					{
						ConvertToCinders( world, i, j, k );
						world.playAuxSFX( FCBetterThanWolves.m_iFireFizzSoundAuxFXID, i, j, k, 0 );
					}
				}
			}
		}
	}
	
	private boolean CheckForGoOutInRain( World world, int i, int j, int k )
	{
		if ( world.rand.nextInt( m_iChanceOfExtinguishInRain ) == 0 )
		{
			if ( world.IsRainingAtPos( i, j + 1, k ) )
			{
				world.playAuxSFX( FCBetterThanWolves.m_iFireFizzSoundAuxFXID, i, j, k, 0 );

				ConvertToCinders( world, i, j, k );

				return true;
			}
		}

		return false;
	}
	
	private void ConvertToCinders( World world, int i, int j, int k )
	{
		if ( GetIsStump( world, i, j, k ) )
		{
			int iNewMetadata = FCBetterThanWolves.fcBlockWoodCinders.SetIsStump( 0, true );

			world.setBlockAndMetadataWithNotify( i, j, k, FCBetterThanWolves.fcBlockWoodCinders.blockID, iNewMetadata );
		}
		else
		{
			world.setBlockWithNotify( i, j, k, FCBetterThanWolves.fcBlockWoodCinders.blockID );
		}
	}
	
	public boolean iscovered(World world, int i, int j, int k) // added by Anarchx
	{
		List<Material> blockslist = new ArrayList<Material>();
		for (int iFacing = 1; iFacing <= 5; iFacing++) //this needs to be 5 to get all sides
		{
			FCUtilsBlockPos tempPos = new net.minecraft.src.FCUtilsBlockPos(i, j, k, iFacing);
		
			int iTempBlockID = world.getBlockId(tempPos.i, tempPos.j, tempPos.k);
			Block tempBlock = Block.blocksList[iTempBlockID];
			if (tempBlock == null) //air blocks give null
			{
				blockslist.add(Material.air);
			}
			else
			{
				blockslist.add(tempBlock.blockMaterial);
			}
		}
		for (int iMat = 0; iMat <= 4; iMat++)
		{
			if ( blockslist.get(iMat) == Material.glass ||
					blockslist.get(iMat) == Material.grass ||
					blockslist.get(iMat) == Material.ground ||
					blockslist.get(iMat) == Material.iron ||
					blockslist.get(iMat) == Material.piston ||
					blockslist.get(iMat) == Material.pumpkin ||
					blockslist.get(iMat) == Material.rock ||
					blockslist.get(iMat) == Material.sand ||
					blockslist.get(iMat) == Material.sponge ||
					blockslist.get(iMat) == Material.tnt ||
					blockslist.get(iMat) == Material.wood ||
					blockslist.get(iMat) == FCBetterThanWolves.fcMaterialCement ||
					blockslist.get(iMat) == FCBetterThanWolves.fcMaterialLog ||
					blockslist.get(iMat) == FCBetterThanWolves.fcMaterialNetherRock
					)
			{
				if (iMat >= 4) //if all blocks pass the test
				{
					return true;
				}
				//then check the next block
			}
			else
			{
				return false;
			}
		}
		return false;
	}
	@Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float var5 = 0.125F;						//minx,0		miny,0		minz,0			max,0+1				may,0+1 - 0.125F					maxz 0+1
        return AxisAlignedBB.getAABBPool().getAABB((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - var5), (double)(par4 + 1));
    }
    
	@Override
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.attackEntityFrom(DamageSource.inFire, 1);
    }*/
}
