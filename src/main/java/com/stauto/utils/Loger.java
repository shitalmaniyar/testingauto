package com.stauto.utils;

import org.apache.logging.log4j.Logger;

public class Loger {
private static boolean root=false;
	
	public static Logger getLogger(Class cls){
		if(root){
			return Loger.getLogger(cls);
		}
	//	PropertyConfigurator.configure("log4j.properties");
		root = true;
		return Loger.getLogger(cls);
	}

}
