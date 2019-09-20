package com.node3.cn.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * <b>Title：</b>DateUtil.java<br/>
 * <b>Description：</b> 日期操作工具类<br/>
 * <b>@author： </b>yemignxin<br/>
 * <b>@date：</b>2012-7-2 下午04:05:18<br/> 
 * 
 */
public class DateUtil {
	protected static Logger log = LoggerFactory.getLogger(DateUtil.class);
	public static final String PATTEM_DATE = "yyyy-MM-dd";
	public static final String PATTEM_DATE3 = "yyyyMM";
	public static final String PATTEM_DATE4 = "MM-dd";
	public static final String PATTEM_DATE2 = "yyyy年MM月dd日";
	public static final String PATTEM2_DATE = "yyyyMMdd";
	public static final String PATTEM_TIME = "HH:mm:ss";
	public static final String PATTEM_HHMM = "HH:mm";
	public static final String PATTEM_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTEM_DATE_TIME2 = "yyyyMMddHHmmss";
	public static final String PATTEM_DATE_TIME3 = "yyyyMMddHHmmssSSS";

	public static final String PATTEM_TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";

	public static final String PATTEM_DAY_BEGIN = "yyyy-MM-dd 00:00:00";
	public static final String PATTEM_DAY_END = "yyyy-MM-dd 23:59:59";
	public static final long ONEDAY_MILLISECONDS = 24 * 60 * 60 * 1000;

	public static final int DATE_COMPARE_BEFORE = -1;
	public static final int DATE_COMPARE_BETWEEN = 0;
	public static final int DATE_COMPARE_AFTER = 1;
	
	/**
	 * 获取指定日期的时间戳
	 * 
	 * @param date
	 *            某X日期
	 * @param minute
	 *            增加的分钟数值
	 * @return 某X日期时间戳  单位：s 
	 * @author zhuangruhai
	 */
	public static Long getTimeStamp(Date date, int minute) {
		if(minute > 0){
			date = getAddValueDate(date, Calendar.MINUTE, minute);
		}
		return date.getTime() / 1000 ;
	}
	
	/**
	 * 根据指定日期添加数值（天，时，分，秒）
	 * 
	 * @param date
	 *            某X日期
	 * @param Template
	 *            增加的模板值  天，时，分，秒
	 * @param value
	 *            增加的数值
	 * @return 增加之后的日期
	 * @author zhuangruhai
	 */
	public static Date getAddValueDate(Date date,int Template ,int value ) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Template, value);
		return c.getTime() ;
	}
	

	//根据秒返回分秒组合
	public static String getMinMM(String mm){
		StringBuilder time = new StringBuilder();
		if(StringUtils.isNotBlank(mm)){
			Float i = Float.valueOf(mm);
			Integer j = 0 ;
			Integer h = i.intValue();
			if(i > 60){
				j = h/60 ; //分
				h = h%60 ; //秒
			}
			String strJ = (j > 0 && j <10) ? "0"+j : j+"" ;
			String strH = (h > 0 && h <10) ? "0"+h : h+"" ;
			time.append( j > 0 ? strJ+":":"00:");
			time.append( h > 0 ? strH+"":"00");
			
		}else{
			time.append("00:00");
		}
		return time.toString() ;
	}
	/**
	 * 将字符串转换成时间格式
	 * 
	 * @param value
	 *            字符串
	 * @param pattem
	 *            格式
	 * @return 时间类型对象
	 * @author zhuangruhai
	 */
	public static Date getDate(String value, String pattem) {
		SimpleDateFormat format = null;
		if (pattem != null) {
			format = new SimpleDateFormat(pattem);
		} else {
			format = new SimpleDateFormat(PATTEM_DATE_TIME);
		}
		try {
			return format.parse(value);
		} catch (Exception e) {
			log.error("getDate:", e);
			return null;
		}
	}

	/**
	 * 把字符转换成时间，格式为默认格式
	 * 
	 * @param value
	 *            字符串
	 * @return 时间类型对象
	 * @author zhuangruhai
	 */
	public static Date getDate(String value) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(PATTEM_DATE_TIME);
			return format.parse(value);
		} catch (Exception e) {
			log.error("getDate:", e);
			return null;
		}
	}

	/**
	 * 格式化时间
	 * 
	 * @param date
	 *            时间
	 * @param pattem
	 *            格式
	 * @return 字符串类型的时间
	 * @author zhuangruhai
	 */
	public static String formatDate(Date date, String pattem) {
		if (date != null) {
			try {
				SimpleDateFormat format = new SimpleDateFormat(pattem);
				return format.format(date);
			} catch (Exception e) {
				return "";
			}

		}
		return "";
	}

	/**
	 * 以默认格式格式化时间
	 * 
	 * @param date
	 *            时间
	 * @return 字符串类型的时间
	 * @author zhuangruhai
	 */
	public static String formatDate(Date date) {
		if (date != null) {
			SimpleDateFormat format = new SimpleDateFormat(PATTEM_DATE_TIME);
			return format.format(date);
		}
		return null;
	}

	/**
	 * 获得当前时间的默认格式字符串
	 * 
	 * @return 字符串类型的时间
	 * @author zhuangruhai
	 */
	public static String now() {
		return formatDate(new Date());
	}
	public static String now2() {
		return formatDate(new Date(),PATTEM_DATE_TIME2);
	}

	public static String now3() {
		return formatDate(new Date(),PATTEM_DATE_TIME3);
	}
	/**
	 * 获得今天时间日期格式的字符串
	 * 
	 * @return 字符串类型的日期 yyyy-MM-dd
	 * @author zhuangruhai
	 */
	public static String getToday() {
		return formatDate(new Date(), PATTEM_DATE);
	}

	/**
	 * 获得今天时间日期格式的字符串
	 * 
	 * @return 字符串类型的日期 yyyyMMdd
	 * @author zhuangruhai
	 */
	public static String getToday2() {
		return formatDate(new Date(), PATTEM2_DATE);
	}

	/**
	 * 获得明天时间日期格式的字符串
	 * 
	 * @return 字符串类型的日期
	 * @author zhuangruhai
	 */
	public static String getTomorrow() {
		long time = new Date().getTime() + ONEDAY_MILLISECONDS;
		return formatDate(new Date(time), PATTEM_DATE);
	}

	/**
     * 格式化日期 今天=“” 昨天=昨天 昨天之前=星期？
     * 
     * @param releaseTime 发布时间
     * @param status 状态值
     * @param minute 延时分钟数值
     * @param createTime 创建时间
     * 
     * @return 当前日期是XX
     */
    public static String getFormatDate(Byte status , Byte minute ,Date createTime) {
    	if(status == -1){
    		//根据创建时间戳 与当前时间戳 得出时间差
    		Long timeDifference = new Date().getTime() - createTime.getTime() ;
    		Long i = (timeDifference / 1000) / 60 ;
    		if(i == 0){
    			return minute == 60 ? "1小时后发送" : minute +"分钟后发送" ;
    		}
    		Long j = minute - i ;
    		return  j > 0 ? j +"分钟后发送" : "1分钟后发送" ;
    	}
    	else if (status == 0){
    		return "已撤回";
    	}
    	else if (status == 1){
    		//截取年月日进行比较
    		String dtStr = formatDate(createTime, DateUtil.PATTEM_DATE_TIME);
        	String hms = dtStr.substring(10,dtStr.length());
        	String ymd = dtStr.substring(0, 10);
        	//匹配今天，昨天，星期？
        	if(ymd.equals(getToday())){
        		ymd = "" ;
        	}else if(ymd.equals(getYesterdayString())){
        		ymd = "昨天" ; 
        	}else{
        		String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
                Calendar cal = Calendar.getInstance();
                cal.setTime(createTime);
                int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
                if (w < 0)
                    w = 0;
                ymd = weekDays[w] ;
        	}
            return ymd + hms;
    	}
    	return "" ;
    }
	/**
	 * 获得昨时间日期格式的字符串
	 * 
	 * @return 字符串类型的日期
	 * @author zhuangruhai
	 */
	public static String getYesterdayString() {
		long time = new Date().getTime() - ONEDAY_MILLISECONDS;
		return formatDate(new Date(time), PATTEM_DATE);
	}

	public static Date getYesterday() {
		long time = new Date().getTime() - ONEDAY_MILLISECONDS;
		return  new Date(time) ;
	}	
	
	/**
	 * 获得今天开始时间点 如：2011-09-09 00:00:00
	 * 
	 * @return 今天开始时间
	 * @author zhuangruhai
	 */
	public static String getTodayBegin() {
		return formatDate(new Date(), PATTEM_DAY_BEGIN);
	}

	/**
	 * 获得今天的结束时间 如：2011-09-09 23:59:59
	 * 
	 * @return 今天的结束时间
	 * @author zhuangruhai
	 */
	public static String getTodayEnd() {
		return formatDate(new Date(), PATTEM_DAY_END);
	}

	/**
	 * 获得某天的开始时间
	 * 
	 * @param dateStr
	 *            字符类型的时间
	 * @return 某天的开始时间
	 * @author zhuangruhai
	 */
	public static String getDayBegin(String dateStr) {
		if (StringTools.isEmptyString(dateStr) || dateStr.length() < 10)
			return null;
		return dateStr.substring(0, 10) + " 00:00:00";
	}

	/**
	 * 获得某天的开始时间
	 * 
	 * @param date
	 *            时间
	 * @return 某天的开始时间
	 * @author zhuangruhai
	 */
	public static String getDayBegin(Date date) {
		if (date == null)
			return null;
		return formatDate(date, PATTEM_DAY_BEGIN);
	}

	/**
	 * 获得某天的结束时间
	 * 
	 * @param dateStr
	 *            字符类型的时间
	 * @return 某天的结束时间
	 * @author zhuangruhai
	 */
	public static String getDayEnd(String dateStr) {
		if (StringTools.isEmptyString(dateStr) || dateStr.length() < 10)
			return null;
		return dateStr.substring(0, 10) + " 23:59:59";
	}

	/**
	 * 获得某天的结束时间
	 * 
	 * @param date
	 *            时间
	 * @return 某天的结束时间
	 * @author zhuangruhai
	 */
	public static String getDayEnd(Date date) {
		if (date == null)
			return null;
		return formatDate(date, PATTEM_DAY_END);
	}

	/**
	 * 当前时间与一段时间进行比较
	 * 
	 * @param begin
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return 比较结果 -1 在时间段之前，0 在时间段内，1 在时间段后
	 * @author zhuangruhai
	 */
	public static int compareTimeByNow(Date begin, Date end) {
		long now = new Date().getTime();
		if (now < begin.getTime())
			return DATE_COMPARE_BEFORE;
		if (now > end.getTime())
			return DATE_COMPARE_AFTER;

		return DATE_COMPARE_BETWEEN;
	}

	/**
	 * 当前时间与一段时间进行比较
	 * 
	 * @param begin
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return 比较结果 -1 在时间段之前，0 在时间段内，1 在时间段后
	 * @author zhuangruhai
	 */
	public static int compareTimeByNow(String begin, String end) {
		long now = new Date().getTime();
		if (now < getDate(begin).getTime())
			return DATE_COMPARE_BEFORE;
		if (now > getDate(end).getTime())
			return DATE_COMPARE_AFTER;

		return DATE_COMPARE_BETWEEN;
	}

	/**
	 * 判断当前时间是否在一段时间内
	 * 
	 * @param begin
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return 比较结果 true 在时间段内 false 不在时间段内
	 * @author zhuangruhai
	 */
	public static boolean isBetweenTime(Date begin, Date end) {
		return compareTimeByNow(begin, end) == DATE_COMPARE_BETWEEN;
	}

	/**
	 * 判断当前时间是否在一段时间内
	 * 
	 * @param begin
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return 比较结果 true 在时间段内 false 不在时间段内
	 * @author zhuangruhai
	 */
	public static boolean isBetweenTime(String begin, String end) {
		return compareTimeByNow(begin, end) == DATE_COMPARE_BETWEEN;
	}

	/**
	 * 计算当前时间与给出时间的毫秒数
	 * 
	 * @param date
	 *            时间点
	 * @return 毫秒数
	 * @author zhuangruhai
	 */
	public static long calTimeByNow(Date date) {
		return new Date().getTime() - date.getTime();
	}

	/**
	 * 计算当前时间与给出时间的毫秒数
	 * 
	 * @param date
	 *            时间点
	 * @return 毫秒数
	 * @author zhuangruhai
	 */
	public static long calTimeByNow(String date) {
		return new Date().getTime() - getDate(date).getTime();
	}

	/**
	 * 在当前时间点上加上/减去一定天数
	 * 
	 * @param days
	 *            需要加/减的天数
	 * @return 加上/减去后的时间点
	 * @author zhuangruhai
	 */
	public static Date addDays(int days) {
		return new Date(new Date().getTime() + days * ONEDAY_MILLISECONDS);
	}

	/**
	 * 在当前时间点上加上/减去一定天数 并转成字符串返回
	 * 
	 * @param days
	 *            需要加/减的天数
	 * @return 加上/减去后的时间点
	 * @author zhuangruhai
	 */
	public static String addDaysForStr(int days) {
		return formatDate(addDays(days));
	}

	/**
	 * 在当前时间点上加上/减去一定的毫秒数
	 * 
	 * @param milliseconds
	 *            加上/减去的毫秒数
	 * @return 加上/减去后的时间点
	 * @author zhuangruhai
	 */
	public static Date addMilliseconds(int milliseconds) {
		return new Date(new Date().getTime() + milliseconds);
	}

	/**
	 * 在当前时间点上加上/减去一定的毫秒数 并转成字符串返回
	 * 
	 * @param milliseconds
	 *            加上/减去的毫秒数
	 * @return 加上/减去后的时间点
	 * @author zhuangruhai
	 */
	public static String addMillisecondsForStr(int milliseconds) {
		return formatDate(addMilliseconds(milliseconds));
	}

	/**
	 * 在当前时间点萨很难过加上/减去一定的秒数
	 * 
	 * @param seconds
	 *            加上/减去的秒数
	 * @return 加上/减去后的时间点
	 * @author zhuangruhai
	 */
	public static Date addSeconds(int seconds) {
		return new Date(new Date().getTime() + 1000 * seconds);
	}

	/**
	 * 在当前时间点萨很难过加上/减去一定的秒数 并转成字符串返回
	 * 
	 * @param seconds
	 *            加上/减去的秒数
	 * @return 加上/减去后的时间点
	 * @author zhuangruhai
	 */
	public static String addSecondsForStr(int seconds) {
		return formatDate(addSeconds(seconds));
	}

	public static int getMin(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.MINUTE);
	}

	/**
	 * 获取Date中的小时(24小时)
	 * 
	 * @param d
	 * @return
	 */
	public static int getHour(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取Date中的秒
	 * 
	 * @param d
	 * @return
	 */
	public static int getSecond(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.SECOND);
	}

	/**
	 * 获取xxxx-xx-xx的日
	 * 
	 * @param d
	 * @return
	 */
	public static int getDay(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取月份，1-12月
	 * 
	 * @param d
	 * @return
	 */
	public static int getMonth(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取19xx,20xx形式的年
	 * 
	 * @param d
	 * @return
	 */
	public static int getYear(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.YEAR);
	}

	public static String getYYYYMMDDHHMMSSDate(Date date) {
		if (date == null)
			return null;
		String yyyy = getYear(date) + "";
		String mm = getMonth(date) + "";
		String dd = getDay(date) + "";
		String hh = getHour(date) + "";
		String min = getMin(date) + "";
		String ss = getSecond(date) + "";

		mm = StringUtils.rightPad(mm, 2, "0");
		dd = StringUtils.rightPad(dd, 2, "0");
		hh = StringUtils.rightPad(hh, 2, "0");
		min = StringUtils.rightPad(min, 2, "0");
		ss = StringUtils.rightPad(ss, 2, "0");

		return yyyy + mm + dd + hh + min + ss;
	}

	public static String getCurTimeStamp() {
		return formatDate(new Date(), PATTEM_TIMESTAMP);
	}

	/**
	 * 根据给定年月得到上一个月，格式：yyyyMM 如果传入格式不符合要求，将反回""
	 * 
	 * @param yearMonth
	 *            支持格式：yyyyMM yyyy-MM yyyy-MM-dd
	 * @return month 格式：yyyyMM
	 */
	public static String getBeforeMonth(String yearMonth) {
		String beforeMonth = "";
		if (null == yearMonth) {
			return "";
		}
		yearMonth = yearMonth.replace("-", "");
		if (yearMonth.length() == 6 || yearMonth.length() == 5
				|| yearMonth.length() == 8) {
			try {
				Integer.parseInt(yearMonth);
			} catch (Exception e) {
				log.error("Integer.parseInt(yearMonth)=>", e);
			}
			String year = yearMonth.substring(0, 4);
			Integer yearI = Integer.parseInt(year);
			String month = yearMonth.substring(4, 6);
			Integer monthI = Integer.parseInt(month);
			if (monthI >= 10) {
				if (monthI == 10) {
					beforeMonth = year + "0" + (monthI - 1);
				} else {
					beforeMonth = year + (monthI - 1);
				}
			} else if (monthI == 1) {
				beforeMonth = (yearI - 1) + "12";
			} else {
				beforeMonth = year + "0" + (monthI - 1);
			}
		}
		return beforeMonth;
	}

	/**
	 * 根据给定年月得到上一个月，格式：yyyyMM 如果传入格式不符合要求，将反回""
	 * 
	 * @param yearMonth
	 *            支持格式：yyyyMM yyyy-MM yyyy-MM-dd
	 * @return month 格式：yyyyMM
	 */
	public static String getAfterMonth(String yearMonth) {
		String afterMonth = "";
		if (null == yearMonth) {
			return "";
		}
		yearMonth = yearMonth.replace("-", "");
		if (yearMonth.length() == 6 || yearMonth.length() == 5
				|| yearMonth.length() == 8) {
			try {
				Integer.parseInt(yearMonth);
			} catch (Exception e) {
				log.error("Integer.parseInt(yearMonth)", e);
			}
			String year = yearMonth.substring(0, 4);
			Integer yearI = Integer.parseInt(year);
			String month = yearMonth.substring(4, 6);
			Integer monthI = Integer.parseInt(month);
			if (monthI >= 9) {
				afterMonth = year + (monthI + 1);
				if (monthI == 12) {
					afterMonth = (yearI + 1) + "01";
				}
			} else {
				afterMonth = year + "0" + (monthI + 1);
			}
		}
		return afterMonth;
	}

	/**
	 * 根据传个日期得到月年，格式：yyyyMM 如传入格式不对，原格式反回
	 * 
	 * @param date
	 *            日期，支持格式：yyyy-MM-dd yyyy.MM.dd yyyy/MM/dd
	 * @return value yyyyMM
	 */
	public static String getYearMonth(String date) {
		String value = "";
		if (null == date || date.equals("")) {
			return "";
		}
		if (date.contains("-")) {
			date = date.replace("-", "");
		} else if (date.contains(".")) {
			date = date.replace(".", "");
		} else if (date.contains("/")) {
			date = date.replace("/", "");
		} else {
			return date;
		}
		String year = date.substring(0, 4);
		String month = date.substring(4, 6);
		value = year + month;
		return value;
	}

	/**
	 * 根据两个时间，得到之间间隔，不保护当月数，如 2014-02 2014-05 间隔为2个月 即可3，4两个月 支持参数格式：yyyy-MM-dd
	 * yyyy-MM yyyyMM
	 * 
	 * @param starDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return
	 */
	public static int getMonthSpacingNum(String starDateStr, String endDateStr) {
		int monthSpacingNum = 0;
		if (null == starDateStr || "".equals(starDateStr) || null == endDateStr
				|| "".equals(endDateStr)) {
			log.error("getMonthSpacingNum() 时间格式错误starDateStr=" + starDateStr
					+ "，endDateStr=" + endDateStr
					+ " 支持参数格式：yyyy-MM-dd yyyy-MM yyyyMM");
			return monthSpacingNum;
		}
		if (starDateStr.indexOf("-") == -1
				&& (starDateStr.length() == 5 || starDateStr.length() == 6)) {
			starDateStr = starDateStr.substring(0, 4) + "-"
					+ starDateStr.substring(4, starDateStr.length());
		}
		if (endDateStr.indexOf("-") == -1
				&& (endDateStr.length() == 5 || endDateStr.length() == 6)) {
			endDateStr = endDateStr.substring(0, 4) + "-"
					+ endDateStr.substring(4, endDateStr.length());
		}
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM");
		try {
			Date starDate = sd.parse(starDateStr);
			Date endDate = sd.parse(endDateStr);
			int sYear = getYear(starDate);
			int sMonth = getMonth(starDate);
			int eYear = getYear(endDate);
			int eMonth = getMonth(endDate);
			int fullMonth = 12; // 一年的十二个月
			if (sYear - eYear <= -1) {
				// 表示结束时间相对当前是近期时间，开始时间是相对结束时间的过去时间
				// 如starDateStr=2013-04,endDateStr=2014-06
				int yearSpacingNum = eYear - sYear - 1;// 年间隔，除去本年,
														// 如2014年间隔2012年数为1
				// 计算开始年到的月份到12月份的间隔数， 如2013-04 12-4=8 8就是间隔数之一
				int monthSNumTemp = fullMonth - sMonth;
				// 结束年的月份数就是间隔数，如2014-06 6就是间隔数之一
				monthSpacingNum = monthSNumTemp + eMonth - 1;
				// 加上年份间隔月,1年12个月
				monthSpacingNum += yearSpacingNum * fullMonth;
			} else if (sYear - eYear >= 1) {
				// 表示开始时间相对当前是近期时间，结束时间是相对开始时间的过去时间
				// 如starDateStr=2014-04,endDateStr=2013-06
				int yearSpacingNum = sYear - eYear - 1;// 年间隔，除去本年,
														// 如2014年间隔2013年数为1
				// 计算结束年到12月份的间隔数，如2013-07 12-7=5 5就是间隔数之一
				int monthSNumTemp = fullMonth - eMonth;
				// 开始年的月份数就是间隔数，如2014-05 5就是间隔数之一，当前月要去掉，
				monthSpacingNum = monthSNumTemp + sMonth - 1;
				// 加上年份间隔月,1年12个月
				monthSpacingNum += yearSpacingNum * fullMonth;
			} else {
				// 表示在同一年的，直接月份计算
				if (sMonth - eMonth <= -1) {
					// 表示开始时间相对结束时间为过去时间，如2014-03 2014-08
					monthSpacingNum = eMonth - sMonth - 1;
				} else if (sMonth - eMonth >= 1) {
					// 表示结束时间相对开始时间为过去时间，如2014-08 2014-03
					monthSpacingNum = sMonth - eMonth - 1;
				}
			}
		} catch (ParseException e) {
			log.error("时间格式错误starDateStr=" + starDateStr + "，endDateStr="
					+ endDateStr, e);
			e.printStackTrace();
		}
		return monthSpacingNum;
	}

	/**
	 * 返回天数
	 * 
	 * @param date1
	 *            开始
	 * @param date2结束
	 * @return
	 */
	public static int betweenDays(Date date1, Date date2) {
		long min = date2.getTime() - date1.getTime();
		long d = min / 1000 / 3600 / 24;
		return new Long(d).intValue();
	}

	public static int betweenMonths(Date date1, Date date2) {
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(date1);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(date2);
		int c = (cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR)) * 12
				+ cal1.get(Calendar.MONTH) - cal2.get(Calendar.MONTH);
		return c == 0 && cal1.get(Calendar.DATE) > cal2.get(Calendar.DATE) ? 1
				: c;
	}

	 
	public static  Calendar getBeforeDayCount( int day) {  
		    Calendar c = Calendar.getInstance();  
	        c.add(Calendar.DATE, day);  
	        return c; 

	}
	
	public static int daysBetween(String smdate,String bdate){ 
           SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
           Calendar cal = Calendar.getInstance();
           long time1 = 0;
           long time2 = 0; 
            try{
                cal.setTime(sdf.parse(smdate));
                time1 = cal.getTimeInMillis(); 
                cal.setTime(sdf.parse(bdate)); 
                time2 = cal.getTimeInMillis(); 
                }catch(Exception e){
                     e.printStackTrace();
                    }
           long between_days=(time2-time1)/(1000*3600*24); 
           return Integer.parseInt(String.valueOf(between_days)); 
    }
	
	/**
	 * 获得今天时间日期格式的字符串
	 * 
	 * @return 字符串类型的日期 HH:mm
	 * @author zhuangruhai
	 */
	public static String getHHMM() {
		return formatDate(new Date(), PATTEM_HHMM);
	}
	
	public static String getHHMMSS(){
		return formatDate(new Date(), PATTEM_TIME);
	}
	
	
	
    public static long dateToTimestamp(String time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(time);
            long ts = date.getTime() / 1000;
            return ts;
        } catch (ParseException e) {
            return 0;
        }
    }
    
    
	// 获取当天的开始时间
	public static Date getDayBegin() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
 
	// 获取当天的结束时间
	public static Date getDayEnd() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
 
	// 获取昨天的开始时间
	public static Date getBeginDayOfYesterday() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayBegin());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}
 
	// 获取昨天的结束时间
	public static Date getEndDayOfYesterDay() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayEnd());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}
 
	// 获取明天的开始时间
	public static Date getBeginDayOfTomorrow() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayBegin());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
 
	// 获取明天的结束时间
	public static Date getEndDayOfTomorrow() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayEnd());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
 
	// 获取本周的开始时间
	@SuppressWarnings("unused")
	public static Date getBeginDayOfWeek() {
		Date date = new Date();
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek);
		return getDayStartTime(cal.getTime());
	}
 
	// 获取本周的结束时间
	public static Date getEndDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfWeek());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date weekEndSta = cal.getTime();
		return getDayEndTime(weekEndSta);
	}
 
	// 获取上周的开始时间
	@SuppressWarnings("unused")
	public static Date getBeginDayOfLastWeek() {
		Date date = new Date();
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek - 7);
		return getDayStartTime(cal.getTime());
	}
 
	// 获取上周的结束时间
	public static Date getEndDayOfLastWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfLastWeek());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date weekEndSta = cal.getTime();
		return getDayEndTime(weekEndSta);
	}
 
	// 获取本月的开始时间
	public static Date getBeginDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		return getDayStartTime(calendar.getTime());
	}
 
	// 获取本月的结束时间
	public static Date getEndDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), getNowMonth() - 1, day);
		return getDayEndTime(calendar.getTime());
	}
 
	// 获取上月的开始时间
	public static Date getBeginDayOfLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 2, 1);
		return getDayStartTime(calendar.getTime());
	}
 
	// 获取上月的结束时间
	public static Date getEndDayOfLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 2, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), getNowMonth() - 2, day);
		return getDayEndTime(calendar.getTime());
	}
 
	// 获取本年的开始时间
	public static Date getBeginDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DATE, 1);
		return getDayStartTime(cal.getTime());
	}
 
	// 获取本年的结束时间
	public static Date getEndDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DATE, 31);
		return getDayEndTime(cal.getTime());
	}
 
	// 获取某个日期的开始时间
	public static Timestamp getDayStartTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Timestamp(calendar.getTimeInMillis());
	}
 
	// 获取某个日期的结束时间
	public static Timestamp getDayEndTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return new Timestamp(calendar.getTimeInMillis());
	}
 
	// 获取今年是哪一年
	public static Integer getNowYear() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return Integer.valueOf(gc.get(1));
	}
 
	// 获取本月是哪一月
	public static int getNowMonth() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return gc.get(2) + 1;
	}
 
	// 两个日期相减得到的天数
	public static int getDiffDays(Date beginDate, Date endDate) {
		if (beginDate == null || endDate == null) {
			throw new IllegalArgumentException("getDiffDays param is null!");
		}
		long diff = (endDate.getTime() - beginDate.getTime())
				/ (1000 * 60 * 60 * 24);
		int days = new Long(diff).intValue();
		return days;
	}
 
	// 两个日期相减得到的毫秒数
	public static long dateDiff(Date beginDate, Date endDate) {
		long date1ms = beginDate.getTime();
		long date2ms = endDate.getTime();
		return date2ms - date1ms;
	}
 
	// 获取两个日期中的最大日期
	public static Date max(Date beginDate, Date endDate) {
		if (beginDate == null) {
			return endDate;
		}
		if (endDate == null) {
			return beginDate;
		}
		if (beginDate.after(endDate)) {
			return beginDate;
		}
		return endDate;
	}
 
	// 获取两个日期中的最小日期
	public static Date min(Date beginDate, Date endDate) {
		if (beginDate == null) {
			return endDate;
		}
		if (endDate == null) {
			return beginDate;
		}
		if (beginDate.after(endDate)) {
			return endDate;
		}
		return beginDate;
	}
 
	// 返回某月该季度的第一个月
	public static Date getFirstSeasonDate(Date date) {
		final int[] SEASON = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4 };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int sean = SEASON[cal.get(Calendar.MONTH)];
		cal.set(Calendar.MONTH, sean * 3 - 3);
		return cal.getTime();
	}
 
	// 返回某个日期下几天的日期
	public static Date getNextDay(Date date, int i) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) + i);
		return cal.getTime();
	}
 
	// 返回某个日期前几天的日期
	public static Date getFrontDay(Date date, int i) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - i);
		return cal.getTime();
	}    
    
	public static void main(String[] args) {
		
		Date date = new Date();
		Date date2 = getDate("2018-09-27 14:44:15");
		Long i = date.getTime() - date2.getTime() ;
		System.out.println(getBeginDayOfWeek());
		 
 

	}
}
