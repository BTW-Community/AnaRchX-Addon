package net.minecraft.src;

public class AADefs {
	
	public static AADefs instance = new AADefs();
	
	//BLOCK ID's
	private static int
		id_coalcindersblock = 4051;
	//end 4096
	
	//ITEM ID's
	private static int
		id_ashpileitem = 19250;
		//end 32000
	
	public static Item ashpileitem;
	public static FCBlockFallingFullBlock coalcindersblock;
	
	public static void addDefinitions() {
		
		//addTileEntityDefs();

		ashpileitem = new AAItemAsh1(id_ashpileitem - 256);
		
		coalcindersblock = new AABlockCoalCinders(id_coalcindersblock);
		Item.itemsList[coalcindersblock.blockID] = new ItemBlock(coalcindersblock.blockID - 256);
		
		FCBetterThanWolves.fcBlockLogSmouldering = (FCBlockLogSmouldering) Block.replaceBlock(FCBetterThanWolves.fcBlockLogSmouldering.blockID, AABlockLogSmouldering.class);
	}


	//private static void addTileEntityDefs() {
		//Custom entities
		//TileEntity.addMapping(SCTileEntityCuttingBoard.class, "SCCuttingBoard");

	//}
}