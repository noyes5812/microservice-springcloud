package com.node3.cn.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ImageRecognition {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageRecognition.class);

    /**
     * 在配置文件中配置：phantomjs路径 + 空格 + codes.js的路径
     */
    private static String command = SystemConfig.getPropertie("phantomjs_path");

    /**
     *
     * @param imageUrl 图片的url地址
     * @return
     * @throws IOException
     */
    public static String getImageToHtml(String imageUrl)throws IOException{
        long startTime = System.currentTimeMillis();
        String result = getPhantomJsHtmml(imageUrl);
        LOGGER.info("搜狗图片识别开销时间：" +(System.currentTimeMillis() - startTime));
        return result;
    }


    /**
     * 执行phantomjs命令加载url地址html的内容和执行页面的js代码
     * 并且返回完整的html内容
     * @param url
     * @return
     * @throws IOException
     */
    private static String getPhantomJsHtmml(String url) throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec(command + " " + url);
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sbf = new StringBuffer();
        String tmp = "";
        while ((tmp = br.readLine()) != null){
            sbf.append(tmp);
        }

        String[] result = sbf.toString().split("companyServiceMod");
        String result2 = "";
        if(result.length >= 2){
            result2 = result[1];
            if(result2.length() > 200){
                result2 = result2.substring(0, 200);
            }
        }
        return result2;
    }

}
