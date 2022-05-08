package btw.community.anarchx.block;

import btw.community.anarchx.tileentity.TileEntityCampfire;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.*;

import java.util.Random;

public class BlockCampfire extends BlockContainer {

	private final FCModelBlockCampfire m_modelCampfire = new FCModelBlockCampfire();
	private FCModelBlock m_modelCollisionBase;

	public BlockCampfire(int iBlockID) {
		super(iBlockID, Material.iron);
		setHardness( 0.1F );
		SetBuoyant();
		setStepSound( soundWoodFootstep );
		setAlwaysStartlesAnimals();
		setUnlocalizedName("AABlockCampfire");
		this.setCreativeTab(CreativeTabs.tabBlock);
		InitModels();
	}

	private void InitModels()
	{
		m_modelCollisionBase = new FCModelBlock();
		m_modelCollisionBase.AddBox( 0D, 0D, 0D, 1D, 0.5D, 1D );
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityCampfire();
	}

	@Override
	public MovingObjectPosition collisionRayTrace( World world, int i, int j, int k, Vec3 startRay, Vec3 endRay )
	{

		FCModelBlock collisionModel = m_modelCollisionBase;

		return collisionModel.CollisionRayTrace( world, i, j, k, startRay, endRay );
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool( World world, int i, int j, int k )
	{
		return null;
	}

	@Override
	public AxisAlignedBB GetBlockBoundsFromPoolBasedOnState(
			IBlockAccess blockAccess, int i, int j, int k )
	{
			return AxisAlignedBB.getAABBPool().getAABB(
					0D, 0D, 0D, 1D, 0.5D, 1D );
	}

	@Override
	protected boolean canSilkHarvest()
	{
		return false;
	}

	@Override
	public int idDropped(int iMetadata, Random rand, int iFortuneModifier )
	{
		return 0;
	}

	// ------ CLIENT SIDE stuff ------

	@Override
	@Environment(EnvType.CLIENT)
	public void registerIcons( IconRegister register ) {
		blockIcon = register.registerIcon("fcBlockCampfire");
	}

	@Override
	@Environment(EnvType.CLIENT)
	public boolean shouldSideBeRendered( IBlockAccess blockAccess,
										 int iNeighborI, int iNeighborJ, int iNeighborK, int iSide )
	{
		return true;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public boolean RenderBlock(RenderBlocks renderBlocks, int i, int j, int k) {
		FCModelBlock transformedModel;

		if (!FCUtilsWorld.IsGroundCoverOnBlock(renderBlocks.blockAccess, i, j, k)) {
			transformedModel = m_modelCampfire.MakeTemporaryCopy();
		} else {
			transformedModel = m_modelCampfire.m_modelInSnow.MakeTemporaryCopy();
		}

		return transformedModel.RenderAsBlock(renderBlocks, this, i, j, k);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void RenderBlockAsItem( RenderBlocks renderBlocks, int iItemDamage, float fBrightness )
	{
		m_modelCampfire.RenderAsItemBlock( renderBlocks, this, iItemDamage );
	}
	// ------ END of CLIENT SIDE stuff ------
}