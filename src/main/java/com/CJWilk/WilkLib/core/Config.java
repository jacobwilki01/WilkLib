package com.CJWilk.WilkLib.core;

import org.apache.logging.log4j.Level;

import net.minecraftforge.common.config.Configuration;

public class Config {
	//Categories
	private static final String CATEGORY_GENERAL = "general";
	
	//Public Values
	public static boolean test = true;
	
	//Call in CommonProxy
	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initGeneralConfig(cfg);
		} catch (Exception e1) {
			CoreData.logger.log(Level.ERROR,  "Problem loading config file!", e1);
		} finally {
			if (cfg.hasChanged()) {
				cfg.save();
			}
		}
	}
	
	//General Configuration
	private static void initGeneralConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General Configuration");
		test = cfg.getBoolean("testBoolean", CATEGORY_GENERAL, test, "First boolean for the Config!");
	}
}
