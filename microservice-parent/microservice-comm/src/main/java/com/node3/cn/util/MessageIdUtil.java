package com.node3.cn.util;

import java.util.Random;

public class MessageIdUtil {
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
}
