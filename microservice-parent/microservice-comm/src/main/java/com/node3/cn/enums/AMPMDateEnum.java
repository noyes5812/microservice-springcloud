package com.node3.cn.enums;

import com.google.common.collect.Range;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;

/**
 * 获取中午还是
 * 
 * @author panhui
 * 
 */
public enum AMPMDateEnum {

	BEFORE_DAWN(1f, Range.closedOpen(0f, 5f), "凌晨"), //
    morning(8f, Range.closedOpen(5f, 8f), "早上"), //
    Shangwu(8f, Range.closedOpen(8f, 11f), "上午"),
    noon(12f, Range.closedOpen(11f, 13f), "中午"), //
    afternoon(15f, Range.closedOpen(13f, 19f), "下午"), //
    night(18f, Range.closedOpen(19f, 24f), "晚上"); //

    /** 匹配所有AMPM的正则，如果枚举对象有修改，需要同时更新此处 **/
    public static final String RULE_OF_AMPM = "凌晨|早晨|早间|晨间|早上|上午|今早|明早|中午|午间|下午|午后|pm|PM|晚上|夜间|夜里|今晚|明晚";

    // 默认时间点
    private Float defaultTime;
    // AMPM的时间区间
    private Range<Float> timeRanges;

    // 匹配的正则规则
    private String rule;

    private AMPMDateEnum(Float defaultTime, Range<Float> timeRanges, String rule) {
        this.setDefaultTime(defaultTime);
        this.setTimeRanges(timeRanges);
        this.setRule(rule);
    }

   

    public Float getDefaultTime() {
        return defaultTime;
    }

    public void setDefaultTime(Float defaultTime) {
        this.defaultTime = defaultTime;
    }

    public Range<Float> getTimeRanges() {
        return timeRanges;
    }

    public void setTimeRanges(Range<Float> timeRanges) {
        this.timeRanges = timeRanges;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
    public static AMPMDateEnum valueOfS(String timem) { 
    	LocalTime parse = LocalTime.parse(timem);
    	String s = parse.toString(DateTimeFormat.forPattern("H.m"));
        for(AMPMDateEnum type : AMPMDateEnum.values()) {  
            if(type.timeRanges.contains(Float.valueOf(s))) {  
                return type;  
            }  
        }  
        return null;  
    } 
    public static void main(String[] args) {
    	System.out.println(valueOfS("19:34:21").getRule());
	}
 
}
