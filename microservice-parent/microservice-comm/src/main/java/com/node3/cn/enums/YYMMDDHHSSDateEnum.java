package com.node3.cn.enums;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


/**
 * 时间转换
 * 
 * @author panhui
 * 
 */
public enum YYMMDDHHSSDateEnum {

	YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss",DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"),DateTimeFormat.forPattern("yyyy年M月d日  h点m分s秒"), "标准格式"),
	YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm",DateTimeFormat.forPattern("yyyy-MM-dd HH:mm"),DateTimeFormat.forPattern("yyyy年M月d日  h点m分"), "年月日时分"),
	YYYY_MM_DD("yyyy-MM-dd",DateTimeFormat.forPattern("yyyy-MM-dd"),DateTimeFormat.forPattern("yyyy年M月d日"), "年月日"), //
	MM_DD("MM-dd",DateTimeFormat.forPattern("MM-dd"),DateTimeFormat.forPattern("M月d日 "), "月日"),
	HH_mm_ss("HH:mm:ss",DateTimeFormat.forPattern("HH:mm:ss"),DateTimeFormat.forPattern("h点m分s秒"), "时分秒24小时"), //
	HH_mm("HH:mm",DateTimeFormat.forPattern("HH:mm"),DateTimeFormat.forPattern("H点m分"), "时分24小时"), //
	hh_mm("hh:mm", DateTimeFormat.forPattern("hh:mm"),DateTimeFormat.forPattern("h点mm分"),"时分12小时"),
	MM_SS("mm:ss",DateTimeFormat.forPattern("mm:ss"),DateTimeFormat.forPattern("mm分ss秒"),"分秒"); //
	
	
    // AMPM的时间区间
    private String format;
    private DateTimeFormatter dateTimeFormatter;
    private DateTimeFormatter dateTimeFormatter2;
    // 匹配的正则规则
    private String value;

    private YYMMDDHHSSDateEnum(String format, DateTimeFormatter dateTimeFormatter, DateTimeFormatter dateTimeFormatter2, String value) {
        this.setFormat(format);
        this.setDateTimeFormatter(dateTimeFormatter);
        this.setDateTimeFormatter2(dateTimeFormatter2);
        this.setValue(value);
    }

	public String getFormat() {
		return format;
	}
	
	public DateTimeFormatter getDateTimeFormatter() {
		return dateTimeFormatter;
	}
	
	public DateTimeFormatter getDateTimeFormatter2() {
		return dateTimeFormatter2;
	}

	public void setDateTimeFormatter2(DateTimeFormatter dateTimeFormatter2) {
		this.dateTimeFormatter2 = dateTimeFormatter2;
	}

	public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
    
   

 
}
