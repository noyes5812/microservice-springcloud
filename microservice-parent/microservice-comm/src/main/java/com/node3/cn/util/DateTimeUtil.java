package com.node3.cn.util;

import com.node3.cn.enums.YYMMDDHHSSDateEnum;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 * 时间工具类
 *<p>Title:DateTimeUtil </p>
 *<p>Description: </p>
 *<p>Company: </p>
 * @author 123
 * @date 2018-6-29
 */
public class DateTimeUtil {
	
	/**
	 * 获取相差的天数
	 * @param start
	 * @param end
	 * @return
	 */
	public  static int CompareDays(String start,String end) {
		DateTime startDateTime = DateTime.parse(start, YYMMDDHHSSDateEnum.YYYY_MM_DD.getDateTimeFormatter());
		DateTime endDateTime = DateTime.parse(end, YYMMDDHHSSDateEnum.YYYY_MM_DD.getDateTimeFormatter());
		Period period=new Period(startDateTime,endDateTime,PeriodType.days());
		return period.getDays();
	}
	/**
	 * 获取相差的小时
	 * @param start
	 * @param end
	 * @return
	 */
	public  static int CompareHours(String start,String end) {
		DateTime startDateTime = DateTime.parse(start, YYMMDDHHSSDateEnum.YYYY_MM_DD_HH_MM_SS.getDateTimeFormatter());
		DateTime endDateTime = DateTime.parse(end, YYMMDDHHSSDateEnum.YYYY_MM_DD_HH_MM_SS.getDateTimeFormatter());
		Period period=new Period(startDateTime,endDateTime,PeriodType.hours());
		return period.getHours();
	}
	public static void main(String[] args) {
		int compareDays = CompareDays("2018-6-29","2018-7-24");
		System.out.println(compareDays);
		int comparehours = CompareHours("2018-6-29 16:07:20","2018-6-29 23:07:20");
		System.out.println(comparehours);
	}
}
