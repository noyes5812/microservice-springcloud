package com.node3.cn.util;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *  
 *@Title: SnCreateTools.java
 *@Description  TODO(描述做什么)
 *@author yemingxin  
 *@date 2016-11-3 下午1:10:40 
 *@version V1.0
 */
public class SnCreateTools { 
	//private static final Logger log = Logger.getLogger(SnCreateTools.class);
	
	//AAA0000001B00GC2B100_E3A2 
	//600000MU700 D 15BP0 001
	public  static void main(String[] args){
		// 原厂料号  版本  工厂code  生产日期   流水号开始   kit   品牌暴风 数量
		snApplyTool("WB0CAKF1824" , "001",20,"2018-11-01"); 
		//System.out.println(CheckSNCrc.CheckCRC(" 98765432111201711290"));
	} 

	
	/**
	 *  
	 * @param  sn_pre_11  前11位  
	 * @param startSn 流水号开始 000  或者从数据库里取最大的那个
	 * @param count 数量  生产台数
	 * @param productTime  生产日期
	 * @return  
	 *  
	 */
	public static Map snApplyTool(String sn_pre_11, String startSn, int count,String productTime){ 
		//生成整机的两个文件 
		Map  map =create(  sn_pre_11,   startSn,   count,  productTime); 
		//有错误返回
		if(map ==null || (map !=null && map.get("errorCode") != null) ){ 
			return map;
		}  
		List<File> files =  (List<File>) map.get("files"); 
		List<String> list18 = (List<String>) map.get("list18");
		String startDecimal = (String) map.get("startDecimal");
		String endDecimal = (String) map.get("endDecimal");
		String start18 = (String) map.get("start18");
		String end18 = (String) map.get("end18");
		String str3_end = (String) map.get("str3_end"); 
		
		//打包 
		String today2 = DateUtil.getToday2(); 
		String alading_upload_file = SystemConfig.getPropertie("alading_upload_file");
		String alading_file = SystemConfig.getPropertie("alading_file");
		String path =  alading_file+File.separator +"snfile"+File.separator + today2  ;	//"yyyyMMdd";
		String zipFile_relative_path = path +File.separator+ "SN("+ productTime+")("+startDecimal +"-"+endDecimal + ")" +"_"+System.currentTimeMillis()+".zip";
		String zipFile_absolute_path = alading_upload_file +File.separator+ zipFile_relative_path;
		
		System.out.println(zipFile_absolute_path);
		
		//打包
		FileToZip.fileToZip(files,zipFile_absolute_path);  
		Map map_return = new HashMap();
		map_return.put("returnZipPath", zipFile_relative_path);
		map_return.put("snStart", start18); 
		map_return.put("snStartDecimal", startDecimal);
		map_return.put("snEnd", end18); 
		map_return.put("snEndDecimal", endDecimal);
		//存数据库 20位的不用存;只保存25位的
		map_return.put("snList",list18); 
		//log.info("zipFile_relative_path=="+zipFile_relative_path +"====zipFile_absolute_path=="+zipFile_absolute_path+ "===snStart====="+start18+ "==snEnd======"+end18);
		return map_return;
		 
	} 
	 
	//SD03ACT1824
	public static Map create(String sn_pre_11, String startSn, int count,String productTime  ){   
		//生成结束sn  =       
		Map<String, Object> result = new  HashMap<String, Object>();
		//log.info("snApplyTool-create--sn_pre_11="+sn_pre_11+ "&&startSn="+startSn+ "&&count="+count);
		List<String> list18 = new ArrayList<String>();
		//List<String> list14 = new ArrayList<String>(); 
		List<String> list_start_end = new ArrayList<String>(); 
		List<File> files = new ArrayList<File>();
		
		//从下一个开始
		int start_i = Hex34.to10(startSn) +1;
		int end_i= start_i + count;
		if(end_i>39000){
			result.put("errorCode", ErrorNumber.ParamErrorException);
			return   result;
		}
		for(int i=start_i ; i< end_i; i++){ 
    		String str3_temp = Hex34.toString(i,34);
    		String str3 = UtilCommon.left0(str3_temp,3) ;   
			String snCode_start14 =sn_pre_11 +  str3;  
			String strCRC = CheckSNCrc.CheckCRC(snCode_start14);
			String snCode_start18 = snCode_start14+strCRC; 
			//验证码4个0结尾的 跳过
			if("0000".equals(strCRC)){
				//log.info("验证码4个0结尾的 跳过:"+snCode_start18);
				++count;
				continue;
			} 
			list18.add(snCode_start18);
			//list14.add(snCode_start14);
			list_start_end.add(str3); 
		}	  
		String startDecimal = list_start_end.get(0);
		String endDecimal = list_start_end.get(list_start_end.size()-1); 
		String start18 = list18.get(0);
		String end18 = list18.get(list18.size()-1);	 
		//文件嫁
		String today2 = DateUtil.getToday2(); 
		String sn_save_path = SystemConfig.getPropertie("alading_upload_file");
		
		String alading_file=SystemConfig.getPropertie("alading_file");
		String path =  alading_file+File.separator +"snfile"+File.separator + today2  ;	//"yyyyMMdd";
	    //校验_暴风TV串号(2016-10-14)(00000-00010).txt  暴风TV串号(2016-10-14)(00000-00010).txt 
		String file18 =sn_save_path+File.separator+ path +File.separator +  "SN("+ productTime+")("+startDecimal +"-"+endDecimal + ").txt";
		createFile(list18,file18); 
		files.add(new File(file18));  
		
		result.put("list18", list18);  
		result.put("startDecimal", startDecimal);
		result.put("endDecimal", endDecimal);
		result.put("start18", start18);
		result.put("end18", end18); 
		result.put("files", files); 
		return result;
	}	
	
	/**
	 * 
	 * @param list20
	 * @param path
	 */
	public static void createFile(List<String> list20,String path){ 
	    File file = new File(path);
        File parent = file.getParentFile(); 
        if(parent!=null&&!parent.exists()){ 
        	parent.mkdirs(); 
        }  
	    FileOutputStream fos = null;
        try {
			fos = new FileOutputStream(file);
			 DataOutputStream dos=new DataOutputStream(fos);//DataOutputStream提供了写入任意对象的能力
			 for(String str :  list20){
				 dos.writeBytes(str+"\r\n"); 
			 } 
	        // dos.write("aa".getBytes("utf-8"));  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //log.info("生成文件ok");
	}
	 
 
 
	

	  
	
	
	
	
	
}
