package com.node3.cn.util;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;


public class MapUtil {
	public static Map sortMapByKey(Map  map) {
		if (map == null || map.isEmpty()) {
			return null;
		} 
		Map<String, Object> sortMap = new TreeMap<String, Object>(
				new Comparator<String>(){
					@Override
					public int compare(String str1, String str2) { 
						return str1.compareTo(str2);
					} 
				});

		sortMap.putAll(map);

		return sortMap;
	}
 
}
