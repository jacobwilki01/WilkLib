package main.java.CJWilk.WilkLib.core;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CoreData.MODID, name = CoreData.MODNAME, version = CoreData.MODVERSION, useMetadata = true)
public class CoreData<proxy> {
	//Mod Information
	public static final String MODID = "wilklib";
	public static final String MODNAME = "WilkLib";
	public static final String MODVERSION = "1.12.2-0.0.1";
	
	//Proxies
    @SidedProxy(clientSide = "main.java.CJWilk.WilkLib.core.ClientProxy", serverSide = "main.java.CJWilk.WilkLib.core.ServerProxy")
    public static CommonProxy proxy;
    
    //Mod Instance
    @Mod.Instance
    public static CoreData instance;
    
    public static Logger logger;
    
    //Forge Init
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
