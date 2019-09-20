package com.node3.cn.util;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoftwareTools {
	private static final Logger log = LoggerFactory.getLogger(SoftwareTools.class);
	
	/**
	 * 
	 * @param software6    前6位
	 * @param maxSoftware  最大物料号；
	 * @return '11153701'
	 */
	public static String createSoftware(String software6, String maxSoftware){ 
		//String  yearWeek = getYearWeek(); 
		String  num = "01";
		if(!StringUtils.isBlank(maxSoftware)){
			String temp =  maxSoftware.substring(6, 8);
			int num_temp = Integer.valueOf(temp) +1  ; 
			num = right0(num_temp, 2);
		}  
		return software6 + num; 
	}
	
	//检验软件物料号 
	public static String checkSoftware(String maxSoftware){ 
		String temp =  maxSoftware.substring(6, 8);
		int num = Integer.valueOf(temp) +1  ;
		if(num >99){
			return "序号已经超过99,软件物料号申请过多";
		}
		return "";
	}	
	
	/**
	 * 
	 * @param softwareType   1位为1时表示主芯片软件，为2时表示mboot软件，为3时表示屏参软件；
	 * @param softwareSubType   1 表示Android系统软件，为2表示linux系列软件；软件为mboot软件或屏参软件时，暂无子类别，默认为0；
	 * @return 
	 */
	public static String getSoftware6(String softwareType, String softwareSubType){ 
		String  yearWeek = getYearWeek(); 
		String  result = softwareType + softwareSubType +   yearWeek ; 
		return result ; 
	}	
 
	// 申请年份 + 周            共4位
		private static String getYearWeek(){   
			Calendar cl = Calendar.getInstance(); 
			cl.setTime(new Date()); 
			int year = cl.get(Calendar.YEAR);  
			int week = cl.get(Calendar.WEEK_OF_YEAR); 
			int second = cl.get(Calendar.SECOND); 
			String yearWeek = (year+"").substring(2,4)+week+second; 
			return yearWeek;
		}
		
		/**
		 * 
		 * @param i  需要补0的数字
		 * @param digit  总位数
		 * @return
		 */
		public static String right0(int i,int digit){
			 String regular  = "%0"+ digit+"d" ;
			 String str = String.format(regular, i);    
			 return str;
		}

}
