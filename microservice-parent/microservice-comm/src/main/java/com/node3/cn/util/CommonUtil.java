package com.node3.cn.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 终端接口返回消息体
 * @author liufeng
 * @date 2018-2-6
 */
public class CommonUtil {

	public static String resultFail(String type, String resultCode) {
		JSONObject json = new JSONObject();
		json.put("success", false);
		json.put("data", "");
		json.put("messageId", MessageIdUtil.createMessageId(type));
		json.put("message",PropertyUtil.getProperty(resultCode));
		return json.toString();
	}
	
}
