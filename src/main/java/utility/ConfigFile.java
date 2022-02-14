package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.ini4j.Ini;
import org.ini4j.Profile.Section;

import DataReaders.IniFile;

@SuppressWarnings("unused")
public class ConfigFile {
     
               
                
                static Ini ini = IniFile.loadINI(System.getProperty("user.dir")+"//src//test//resources//Config//Config.ini");
                
                
 
    
    public static String getEnvironment () throws FileNotFoundException{
    	
    			
    			
                Section common = ini.get("Common");
                                String   environment = common.get("Environment");
                //            System.out.println(environment);
                                return environment;
                
    }
    
    
    public  static String getConfigValue(String object) {
    	ConfigFile obj = new ConfigFile();
                String val = null ;
				try {
					val = ini.get(getEnvironment(), object);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Catch Block of ConfigValue");
					e.printStackTrace();
				}      
                if (val!= null){
                    //  System.out.println("Value of '"+object+"' is :- "+val  );
                }else{
                      System.out.println("No value found in Config File");
                }
                return val;
    } 
    
    
    
               
        }
