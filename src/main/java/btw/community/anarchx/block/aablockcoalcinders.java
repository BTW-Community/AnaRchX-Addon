package btw.community.anarchx.block;

import net.minecraft.src.*;

import java.util.Random;

public class aablockcoalcinders extends FCBlockFallingFullBlock
	{
	    public aablockcoalcinders(int iBlockID )
	    {
	        super( iBlockID, Material.rock );
	        
	        setHardness( 1F );
	        SetShovelsEffectiveOn();
	        
	        SetBuoyant();
	        
	        setStepSound( soundGravelFootstep );
	        
	        setUnlocalizedName( "AABlockCoalCinders" );
	        
	        this.setCreativeTab( CreativeTabs.tabBlock );
	    }
	    
	    @Override
	    public int idDropped(int par1, Random par2Random, int par3)
	    {
	    	int rnd = par2Random.nextInt(2);
	    	if (rnd == 0 || rnd == 1)
	    	{
	    		return Item.coal.itemID;
	    	}
	    	else
	    	{
	    		return net.minecraft.src.FCBetterThanWolves.fcItemCoalDust.itemID;
	    	}
	    }
	    
	    @Override
	    public int quantityDropped(Random par1Random)
	    {
	        return 1 + par1Random.nextInt(2);
	    }
	    
	    @Override
	    public float GetMovementModifier(World world, int i, int j, int k )
	    {
	    	return 0.80F;
	    }
	    
		@Override
		public boolean DropComponentItemsOnBadBreak( World world, int i, int j, int k, int iMetadata, float fChanceOfDrop )
		{
			DropItemsIndividualy( world, i, j, k, FCBetterThanWolves.fcItemCoalDust.itemID, 1, 0, fChanceOfDrop );
			DropItemsIndividualy( world, i, j, k, FCBetterThanWolves.fcItemCoalDust.itemID, 2, 0, 0.75F );
			DropItemsIndividualy( world, i, j, k, anarchxaddons.aaitemash.itemID, 2, 0, fChanceOfDrop);
			DropItemsIndividualy( world, i, j, k, anarchxaddons.aaitemash.itemID, 6, 0, 0.75F);
			
			return true;
		}
	    
		@Override
	    public boolean CanBePistonShoveled( World world, int i, int j, int k )
	    {
	    	return false;
	    }
		
		@Override
	    public boolean CanReedsGrowOnBlock( World world, int i, int j, int k )
	    {
	    	return false;
	    }
	    
		@Override
	    public boolean CanCactusGrowOnBlock( World world, int i, int j, int k )
	    {
	    	return false;
	    }
		
		@Override
		public void registerIcons(IconRegister register) {
			blockIcon = register.registerIcon("AABlockCoalCinders");
		}
	    
	    //------------- Class Specific Methods ------------//    
	    
		//----------- Client Side Functionality -----------//
	}