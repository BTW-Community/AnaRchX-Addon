package net.minecraft.src;

/**
 * @author AnaRchX(sanedsf)
 *
 */

public class AnarchxAddons extends FCAddOn {
    
    public AnarchxAddons() {
        super("AnaRchX's Addons", "0.0.dev", "AA");
    }
    
    @Override
    public void Initialize() {
    	FCAddOnHandler.LogMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
		this.GetLanguageFilePrefix();
		AADefs aadefs = AADefs.instance;
    	aadefs.addDefinitions();
    	//AARecipes.addRecipes();
		
    	FCAddOnHandler.LogMessage(this.getName() + " Initialized");
    }
    
    @Override
	public String GetLanguageFilePrefix()
	{
		return "AA";
	}
}