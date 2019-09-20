package com.node3.cn.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


import java.io.IOException;
import java.util.*;

public class ImageIdentyUtil {

    private static final Logger LOGGER = Logger.getLogger(ImageIdentyUtil.class);


    public static List<Map<String, String>> getSougoIdenty(byte[]fileBytes, String imageUrl) throws IOException {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        String response = getSougoFlowers(fileBytes);
        if (StringUtils.isNotEmpty(response)) {
            try {
                JSONObject flowers = JSONObject.parseObject(response).getJSONObject("flowers");
                JSONArray array = flowers.getJSONArray("objs");
                if (array != null && !array.isEmpty()) {
                    JSONObject object = array.getJSONObject(0);
                    String[] scores = object.getString("scores").split(",");
                    String[] names = object.getString("names").split(",");
                    int len = 3;
                    if (names.length < 3) {
                        len = names.length;
                    }
                    for (int i = 0; i < len; i++) {
                        String name = names[i];
                        String score = scores[i];
                        Map<String, String> map = new HashMap<>(3);
                        map.put("name", name);
                        map.put("baike",getSougoBaikeAddr(name));
                        map.put("score", score);
                        list.add(map);
                    }
                }
            } catch (Exception e) {
                LOGGER.info("识别图片失败,请检查图片是否能访问到, imageUrl:" + imageUrl);
            }
        }
        return list;
    }

    private static String getSougoBaikeAddr(String name) {
        String url = SystemConfig.getPropertie("sougo_baike_url") + name;
        Map<String,String> result = HttpClientRequest.doGet(url);
        String response = result.get("responseStr");
        if (StringUtils.isNotEmpty(response)){
            JSONObject object = JSONObject.parseObject(response);
            return object.getString("wapLink");
        }
        return null;
    }



    private static String getSougoFlowers(byte[] fileBytes){
        String url = SystemConfig.getPropertie("flower_url");
        String pid = SystemConfig.getPropertie("flower_pid");
        String key = SystemConfig.getPropertie("flower_key");
        String salt = String.valueOf(System.currentTimeMillis());
        String service = SystemConfig.getPropertie("flower_service");
        String image = Base64Util.encode(fileBytes);
        String sign = MD5Util.MD5Encode(pid + service + salt + image.substring(0,1024) + key);

        Map<String, String> params = new HashMap<>();
        params.put("pid", pid);
        params.put("service", service);
        params.put("salt", salt);
        params.put("image", image);
        params.put("sign", sign);

        Map<String, String> result = HttpClientRequest.doPost(url, params);
        LOGGER.info("请求花草识别：" + result);
        return result.get("responseStr");
    }
}
