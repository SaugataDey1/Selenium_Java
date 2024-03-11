package com.base.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils extends Base
{
	public static void read_system_config_properties() throws IOException
	{
		systemconfigproperties = new Properties();
		String read_system_configfile_Path = projectPath+"/resources/SystemConfig.properties";
		FileInputStream fis = new FileInputStream(read_system_configfile_Path);
		systemconfigproperties.load(fis);
	}
	
	
	public static void read_data_config_properties() throws IOException
	{
		/*
		dataconfigproperties = new Properties();
		String read_data_configfile_Path = projectPath+"/DataConfig.properties";
		FileInputStream fis = new FileInputStream(read_data_configfile_Path);
        dataconfigproperties.load(fis);
        */
	}
	

}
