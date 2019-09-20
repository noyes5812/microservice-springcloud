package com.node3.cn.util;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.node3.cn.enums.AMPMDateEnum;
import com.node3.cn.enums.YYMMDDHHSSDateEnum;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;

/**
 * 日期转中文所有的默认时间获取
 *<p>Title:GetJoDateUtil </p>
 *<p>Description: </p>
 *<p>Company: </p>
 * @author 123
 * @date 2018-5-4
 */
public class GetJoDateUtil {
	
	/**
	 * 小夜灯  是否打开  0关闭 1打开    
	 * @param beginTime
	 * @return
	 * @throws ParseException
	 */
	public static String isLight(String beginTime) throws ParseException{
		//获取小夜灯开始时间   开始必須小于结束时间
		String alarm_start_time = StringUtils.trim(SystemConfig.getPropertie("alarm_start_time"));
		//获取小夜灯结束时间
		String alarm_end_time = StringUtils.trim(SystemConfig.getPropertie("alarm_end_time"));
		/*String alarm_start_time="08:00";
		String alarm_end_time="19:00";*/
		String date = LocalDate.now().toString();
		DateTime start=DateTime.parse(date+" "+alarm_start_time,YYMMDDHHSSDateEnum.YYYY_MM_DD_HH_MM.getDateTimeFormatter());
		DateTime end=DateTime.parse(date+" "+alarm_end_time,YYMMDDHHSSDateEnum.YYYY_MM_DD_HH_MM.getDateTimeFormatter());
        Interval interval=new Interval(start,end);
		if (interval.contains(DateTime.parse(date+" "+beginTime,YYMMDDHHSSDateEnum.YYYY_MM_DD_HH_MM.getDateTimeFormatter()))){ 
		    return "0";
		}else{ 
			return "1";
		} 
	}
	
	
	
	
	
	/**
	 * 获取今天还是明天 还是年月日
	 * @param date
	 * @return
	 */
	private  static String valueOfS(String date) {
		LocalDate now = LocalDate.now();
		int month = now.getMonthOfYear();
		int dayOfMonth1 = now.getDayOfMonth();
		int dayOfMonth2 = now.plusDays(1).getDayOfMonth();
		int dayOfMonth3 = now.plusDays(2).getDayOfMonth();
		LocalDate localDate;
		try {
			localDate = LocalDate.parse(date);
		} catch (Exception e) {
			if (StringUtils.isNotEmpty(date)){
				localDate = LocalDate.parse(LocalDate.now().getYear()+"-"+date);
			}else{
				localDate = LocalDate.parse(String.valueOf(LocalDate.now()));
			}
		}
		if(now.getYear()!=localDate.getYear()){
			return localDate.toString(YYMMDDHHSSDateEnum.YYYY_MM_DD.getDateTimeFormatter2());
		}
		if (dayOfMonth1 == localDate.getDayOfMonth() && month == localDate.getMonthOfYear()) {
			return  "今天";
		}else if(dayOfMonth2==localDate.getDayOfMonth() && month == localDate.getMonthOfYear()){
			return  "明天";
		}else if(dayOfMonth3==localDate.getDayOfMonth() && month == localDate.getMonthOfYear()){
			return "后天";
		}
		return localDate.toString(YYMMDDHHSSDateEnum.MM_DD.getDateTimeFormatter2());
	}
	
	/**
	 * 这是没有 今天后天  明天
	 * @param date
	 * @return
	 */
	private static String valueOfH(String date) {
		LocalDate localDate;
		try {
			localDate = LocalDate.parse(date);
		} catch (Exception e) {
			localDate = LocalDate.parse(LocalDate.now().getYear()+"-"+date);
		}
		return LocalDate.now().getYear() == localDate.getYear() ? localDate
				.toString(YYMMDDHHSSDateEnum.MM_DD.getDateTimeFormatter2()) : localDate
				.toString(YYMMDDHHSSDateEnum.YYYY_MM_DD.getDateTimeFormatter2());
	}
	
	/**
	 * 这是有今天后天  针对 单次
	 * @param date
	 * @param time
	 * @return
	 */
	public static String getYMDHS(String date,String time){
    	String valueOfS;
    	String rule;
    	String string;
    	if(date==null||date==""){
    		valueOfS="";
    	}else{
    		valueOfS= valueOfS(date);
    	}
    	if(time==null||time==""){
    		rule="";
    		string="";
    	}else{
    		 rule = AMPMDateEnum.valueOfS(time).getRule();
        	 string = LocalTime.parse(time).toString(YYMMDDHHSSDateEnum.hh_mm.getDateTimeFormatter());
    	}
    	return valueOfS+rule+string;
    }
	/**
	 * 这是不用今天 后天 明天 针对范围的闹钟
	 * @param date
	 * @param time
	 * @return
	 */
	public static String getYMDHSH(String date,String time){
    	String valueOfS;
    	String rule;
    	String string;
    	if(date==null||date==""){
    		valueOfS="";
    	}else{
    		valueOfS= valueOfH(date);
    	}
    	if(time==null||time==""){
    		rule="";
    		string="";
    	}else{
    		 rule = AMPMDateEnum.valueOfS(time).getRule();
        	 string = LocalTime.parse(time).toString(YYMMDDHHSSDateEnum.hh_mm.getDateTimeFormatter());
    	}
    	return valueOfS+rule+string;
    }
	/**
	 * 获取最近的闹钟
	 * @param date 开始的年月日
	 * @param time 时分
	 * @return
	 */
	public static String getNearAlarm(String date ,String time){
		for (int i = 0; i < 8; i++) {
    		LocalDate plusDays = LocalDate.now().plusDays(i);
    		DateTime parse = DateTime.parse(plusDays.toString()+" "+time, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm"));
    		if(StringUtils.contains(date, ""+plusDays.getDayOfWeek())&&parse.isAfterNow()){
    			return GetJoDateUtil.getYMDHS(plusDays.toString(),time);
    		}
		}
		return null;
	}
	
    public static void main(String[] args) {
    	/*System.out.println(getYMDHSH("2018-05-13","11:09"));
    	String value="1234567";
    	String str="17:02";
    	System.out.println(getNearAlarm(value,str));*/
    	System.out.println(getYMDHS("2018-05-29",""));
    	 StringBuilder sb=new StringBuilder();
    	//用,分开    不包含null   
    	Joiner skipNulls = Joiner.on(",").skipNulls();
    	StringBuilder appendTo = skipNulls.appendTo(sb, "1","2");
    	
    	System.out.println(appendTo);
      //用,分开    有null替换 
	  System.out.println(Joiner.on(",").useForNull("none").join(1,null,3));
	  //
      System.out.println(Joiner.on(",").skipNulls().join(Arrays.asList(1,2,3,4,null,6)));
      
      Map<String,String>map=new HashMap<>();
      map.put("key1","value1");
      map.put("key2","value2");
      map.put("key3","value3");
      System.out.println(Joiner.on(",").withKeyValueSeparator("=").join(map));
      String join = Joiner.on("").skipNulls().join( Splitter.on(",").trimResults().split("  1 , 2 ,  3 "));
      System.out.println(join+"   a");
      /*
      on():指定分隔符来分割字符串
      limit():当分割的子字符串达到了limit个时则停止分割
      fixedLength():根据长度来拆分字符串
      trimResults():去掉子串中的空格
      omitEmptyStrings():去掉空的子串
      withKeyValueSeparator():要分割的字符串中key和value间的分隔符,分割后的子串中key和value间的分隔符默认是=
     */
    System.out.println(Splitter.on(",").limit(3).trimResults().split(" a,  b,  c,  d"));//[ a, b, c,d]
    System.out.println(Splitter.fixedLength(3).split("1 2 3"));//[1 2,  3]
    System.out.println(Splitter.on(" ").omitEmptyStrings().splitToList("1  2 3"));
    System.out.println(Splitter.on(",").omitEmptyStrings().split("1,,,,2,,,,3")+"aa");//[1, 2, 3]
    System.out.println(Splitter.on(",").trimResults().split("  1 , 2 ,,  3 ")); //[1, 2, 3],默认的连接符是,
    System.out.println(Splitter.on(";").withKeyValueSeparator(":").split("a:1;b:2;c:3"));//{a=1, b=2, c=3}
    String join2 = Joiner.on("").skipNulls().join("2", "3","4");
    System.out.println(join2);
    
    
    Iterable<String> split = Splitter.on(",").trimResults().split("1,2");
    String join3 = Joiner.on(":").join(split);
    System.out.println(join3);
    
	    Stopwatch stopwatch = Stopwatch.createStarted();
	    for(int i=0; i<100000; i++){
	    	
	    }
	    long nanos = stopwatch.elapsed(TimeUnit.MILLISECONDS);
	    System.out.println(nanos);
	}
}
