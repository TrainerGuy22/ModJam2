package dragonborn.rift.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class Config
{
	private static Configuration	config	= null;
	
	public static int DEFAULT_RIFT_DIMENSION_ID = 8;
	
	public static int DIMENSION_ID = DEFAULT_RIFT_DIMENSION_ID;
	
	public static void loadConfig(File configFile)
	{
		config = new Configuration(configFile);
		config.load();
		
		/** Load values into fields */
		DIMENSION_ID = getInt("dimension", "dimensionID", DEFAULT_RIFT_DIMENSION_ID);
	}
	
	public static Configuration getConfig()
	{
		return config;
	}
	
	public static int getInt(String category, String key, int defaultValue)
	{
		return config.get(category, key, defaultValue).getInt();
	}
}
