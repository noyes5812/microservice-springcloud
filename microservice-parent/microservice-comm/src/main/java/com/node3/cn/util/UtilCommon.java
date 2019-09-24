package com.node3.cn.util;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;

import net.sf.json.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;

import org.apache.commons.lang.StringUtils;

/**
 * 
 *@Title: UtilCommon.java
 *@Description  TODO(描述做什么)
 *@author yemingxin  
 *@date 2017-3-23 下午4:36:02 
 *@version V1.0
 */
public class UtilCommon {

	
	//private static final Logger logger = Logger.getLogger(UtilCommon.class);
	  
    private final static String CHARSET_UTF8 = "UTF-8";
    private final static String SEPARATOR_AND = "&";
    private final static String SEPARATOR_EQUAL = "=";
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
	
	/**
	 * 
	 * @parami  需要补0的数字
	 * @param digit  总位数
	 * @return
	 */
	public static String left0(String str,int digit){ 
		if(digit == str.length()){
			return str;
		}
		 String str_temp = String.format("%1$0"+(digit-str.length())+"d",0) +str;
		 return str_temp;
	}
/**
 * 时间戳+ uuid前15位   == 32
 * @return
 */
	public static String get32str(){
		String str32 = DateUtil.now3()+"wy" + UUID.randomUUID().toString().replace("-", "").substring(0, 13); 
		return str32;
	} 
	public static String get32str(String flag){ 
		String str32 = DateUtil.now3()+ flag + UUID.randomUUID().toString().replace("-", "").substring(0, 13); 
		return str32;
	}	
	

	public static String get20str(){
		String str32 = DateUtil.now3() + UUID.randomUUID().toString().replace("-", "").substring(0, 3); 
		return str32;
	} 
	/**
	 * 获取业务Id
	 **/
	public static String getSecId(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static JSONObject isJson(String content){

	    try {
	    	JSONObject  jasonObject = JSONObject.fromObject(content);
	        return  jasonObject;
	   } catch (Exception e) {
	        return null;
	  }
	}	
	
	

	/**
	 * 
	 * @param sceneType 场景的英文命名，比如闹铃就是alarm
	 * @return
	 */
	public static String createMessageId(String sceneType){
		Random random = new Random();
		String[] str = {"1","2","3","4","5","6","7","8","9","5","a","b","c","d","e",
				"f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		Long time = System.currentTimeMillis();
		String temp = "";
		for(int i = 0 ; i<5;i++){
			int j = random.nextInt(str.length);
			temp += str[j];
		}
		return sceneType + temp +time.toString();
	}
	//得mac+userid
	public static String getMacUserId(String mac,String userId){ 
		return mac + "_" + userId;
	}	

	
	//请求的时间戳。日期格式按照ISO8601标准表示，并需要使用UTC时间
	/**
	 * 传入Data类型日期，返回字符串类型时间（ISO8601标准时间）
	 * 
	 * @param date
	 * @return
	 */
	public static String getISO8601Timestamp(Date date) {
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
		df.setTimeZone(tz);
		String nowAsISO = df.format(date);
		return nowAsISO;
	}
	//请求的时间戳。日期格式按照ISO8601标准表示，并需要使用UTC时间
	public static String getISO8601Timestamp2(Date date) {
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss'Z'");
		df.setTimeZone(tz);
		String nowAsISO = df.format(date);
		return nowAsISO;
	}
	   
    /// 请求参数排序  为以后sign加密使用
    /// </summary>
    /// <param name="paramlst">参数列表</param>
    /// <param name="IsToUpper">是否转大写</param>
    /// <param name="IsDirect">是否直接加上签名Key</param>
    /// <returns></returns>
    public static String GenerateSign(Map<String, String> paraMap,boolean urlEncode, boolean keyToLower,String privateKey)
    {
    	String buff = "";
    	  try{ 
		    	List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(paraMap.entrySet());
		        Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>()
		        { 
		            @Override
		            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2)
		            {
		                return (o1.getKey()).toString().compareTo(o2.getKey());
		            }
		        }); 
		        // 构造URL 键值对的格式
	            StringBuilder buf = new StringBuilder();
	            for (Map.Entry<String, String> item : infoIds)
	            {
	                if (StringUtils.isNotBlank(item.getKey()))
	                {
	                    String key = item.getKey();
	                    String val = item.getValue();
	                    if (urlEncode)
	                    {
	                        val = URLEncoder.encode(val, CHARSET_UTF8);
	                    }
	                    if (keyToLower)
	                    {
	                        buf.append(key.toLowerCase() + SEPARATOR_EQUAL + val);
	                    } else
	                    {
	                        buf.append(key + SEPARATOR_EQUAL + val);
	                    }
	                    buf.append(SEPARATOR_AND);
	                } 
	            }
	            buff = buf.toString();
	            if (buff.isEmpty() == false)
	            {
	                buff = buff.substring(0, buff.length() - 1);
	            }
	        } catch (Exception e)
	        {
	           return null;
	        }

    	  return buff;
    }
    
	public static String getShuziMap(String str) {
		Map<String, String> shuzi = new HashMap<String, String>(); 
		shuzi.put("yi", "1");
		shuzi.put("er", "2");
		shuzi.put("san", "3");
		shuzi.put("si", "4");
		shuzi.put("wu", "5");
		shuzi.put("liu", "6");
		shuzi.put("qi", "7");
		shuzi.put("ba", "8");
		shuzi.put("jiu", "9");
		shuzi.put("shi", "10");

		shuzi.put("shiyi", "11");
		shuzi.put("shiyier", "12");
		shuzi.put("shiyisan", "13");
		shuzi.put("shiyisi", "14");
		shuzi.put("shiyiwu", "15");
		shuzi.put("shiyiliu", "16");
		shuzi.put("shiyiqi", "17");
		shuzi.put("shiyiba", "18");
		shuzi.put("shiyijiu", "19");
		shuzi.put("ershi", "20");
		
		shuzi.put("eryi", "21");
		shuzi.put("erer", "22");
		shuzi.put("ersan", "23");
		shuzi.put("ersi", "24");
		shuzi.put("erwu", "25");
		shuzi.put("erliu", "26");
		shuzi.put("erqi", "27");
		shuzi.put("erba", "28");
		shuzi.put("erjiu", "29");
		shuzi.put("sanshi", "30");
		
		shuzi.put("sanyi", "31");
		shuzi.put("saner", "32");
		shuzi.put("sansan", "33");
		shuzi.put("sansi", "34");
		shuzi.put("sanwu", "35");
		shuzi.put("sanliu", "36");
		shuzi.put("sanqi", "37");
		shuzi.put("sanba", "38");
		shuzi.put("sanjiu", "39");
		shuzi.put("sishi", "40");
		
		shuzi.put("siyi", "41");
		shuzi.put("sier", "42");
		shuzi.put("sisan", "43");
		shuzi.put("sisi", "44");
		shuzi.put("siwu", "45");
		shuzi.put("siliu", "46");
		shuzi.put("siqi", "47");
		shuzi.put("siba", "48");
		shuzi.put("sijiu", "49");
		shuzi.put("sishi", "50");		
		String pinyin = UtilCommon.getPinYinByStr(str);
		return shuzi.get(pinyin);
		
	}    
	//汉字 转拼音
	public static String  getPinYinByStr(String  chineseCharacters){ 
		String str = "";
        char[] charArray = chineseCharacters.toCharArray();
        StringBuilder pinyin = new StringBuilder();
        for(int i=0; i<charArray.length; i++){
        	//判断是不是中文字符，如果是中文字符才处理。
            if(Character.toString(charArray[i]).matches("[\\u4E00-\\u9FA5]+")){
            	str = PinyinHelper.toHanyuPinyinStringArray(charArray[i])[0];
            	str = str.substring(0, str.length()-1);
                pinyin.append(str);
            }else{
                pinyin.append(charArray[i]);
            } 
        }  
        return pinyin.toString();
        
	}
	
    /**
     * 如果有内容可以进行播放，返回播放的TTS回复语
     * @return
     */
	public static String getTts(String[] str){ 
        List<String> answers = Arrays.asList(str); 
        int index = 0;
        if(answers.size() > 1){
        	index = new Random().nextInt(answers.size() - 1);
        }
        String answerTmpl = answers.get(index); 
        return answerTmpl;
    }
	public static String getTts(String[] str,String target){ 
		String answerTmpl  = getTts(str);
		String answerTmp2  = answerTmpl.replace("$", target); 
        return answerTmp2;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = getPinYinByStr("朗文PLE");
		 System.out.println(s);
	}
}
