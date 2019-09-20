/**
 * 
 */
package com.node3.cn.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 
public class SystemConfig {
	private static final Logger logger = LoggerFactory.getLogger(SystemConfig.class);
	
	private static SystemConfig INSTANCE;
	
	private final Map<String,String> config = new HashMap<String, String>();
	
	
	private SystemConfig(File... configFiles){
		refresh(configFiles);
	}
	
	private void refresh(File... configFiles){
		if(configFiles != null){
			try{
				Map<String,String> props = new HashMap<String, String>();
				for(File file : configFiles){
					if(file.exists()){
						logger.info("加载系统参数配置文件:{}",file.getPath());
						Properties prop = new Properties();
						InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
						prop.load(reader);
						Enumeration<?> names = prop.propertyNames();
						while(names.hasMoreElements()){
							String key = names.nextElement().toString();
							props.put(key, prop.getProperty(key));
						}
					}
				}
				config.clear();
				config.putAll(props);
			}catch(Exception e){
				throw new RuntimeException(e);
			}
			//afterLoad();
		}
	}
	
//	private void afterLoad(){
//		//ftp工作目录
//		if(config.get("workDirRoot") != null){
//			FileDirSetHelper.setWorkDirRoot(config.get("workDirRoot").toString());
//		}
//	}
	
	public static synchronized void loadConfig(File... configFiles){
		if(INSTANCE == null){
			INSTANCE = new SystemConfig(configFiles);
		}else{
			INSTANCE.refresh(configFiles);
		}
	}
	
	public static String getPropertie(String name){
		return getPropertie(name, null);
	}
	
	public static String getPropertie(String name,String defaultValue){
		if(INSTANCE == null){
			throw new RuntimeException("系统参数未加载");
		}
		if(INSTANCE.config.get(name) != null){
			return INSTANCE.config.get(name);
		}
		return defaultValue;
	}

	public static void main(String[] args) {
		String alading_upload_file = getPropertie("alading_upload_file");
		System.out.println(alading_upload_file);
	}

}
