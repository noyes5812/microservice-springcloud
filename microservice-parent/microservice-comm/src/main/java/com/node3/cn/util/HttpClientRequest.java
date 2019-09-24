package com.node3.cn.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;
import java.util.zip.Adler32;

import javax.net.ssl.SSLContext;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;


public class HttpClientRequest {
		private static final Logger logger = Logger.getLogger(HttpClientRequest.class.getName());
	/**
	 * 返回json
	 * @param url
	 * @param head_map
	 * @param map
	 * @param charset
	 * @return
	 */
	public static Map<String, String> doPost(String url,Map<String,String> head_map,Map<String,String> map,String charset){  
	        HttpPost httpPost = null;  
	        Map<String,String> resultMap = new HashMap<String,String>();
	        String responseStr=""; 
	        String responseCode=""; 
	        try{  
	        	HttpClient httpClient = new DefaultHttpClient();  
	            httpPost = new HttpPost(url);  
	            
	            // 设置请求的header
	            if(head_map != null){
		            Iterator iterator_head = head_map.entrySet().iterator();  
		            while(iterator_head.hasNext()){  
		                Entry<String,String> elem = (Entry<String, String>) iterator_head.next();   
		                httpPost.addHeader(elem.getKey(),elem.getValue()); 
		            } 	            	
	            }
 
	            //设置参数  
	            List<NameValuePair> list = new ArrayList<NameValuePair>();  
	            Iterator iterator = map.entrySet().iterator();  
	            while(iterator.hasNext()){  
	                Entry<String,String> elem = (Entry<String, String>) iterator.next();  
	                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));  
	            }  
	            if(list.size() > 0){  
	                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);  
	                httpPost.setEntity(entity);  
	            }  
	            HttpResponse response = httpClient.execute(httpPost);    
	            if(response != null){  
		            // 检验返回码
		            responseCode = response.getStatusLine().getStatusCode() +"";
	                HttpEntity resEntity = response.getEntity();   
	                if(resEntity != null){  
	                	responseStr = EntityUtils.toString(resEntity,charset);  
	                }  
	            } 
	            resultMap.put("responseCode", responseCode +"");
	            resultMap.put("responseStr", responseStr);
	        }catch(Exception ex){  
	            ex.printStackTrace();  
	        }  
	        return resultMap;  
	    }  
	    
	    
    public static Map<String,String> doPost(String url,Map<String,String> map,String charset){  
        return doPost( url,null, map, charset); 
    } 
    public static Map<String,String> doPost(String url,Map<String,String> map){  
        return doPost( url,null, map, "utf-8"); 
    } 	    
    
    public static Map<String,String> doGet(String url){ 
        Map<String,String> headMap = new HashMap<String,String>(); 
        return doGet( url, headMap);
        //....result是用户信息,站内业务以及具体的json转换这里也不写了...
    } 
    
    public static Map<String,String> doGet(String url,Map<String, String> headMap){ 
        Map<String,String> resultMap = new HashMap<String,String>();
        String responseStr=""; 
        String responseCode="";
          try {
                // 根据地址获取请求
                HttpGet httpGet = new HttpGet(url);//这里发送get请求
                // 获取当前客户端对象
                CloseableHttpClient httpClient = HttpClients.createDefault();  
                if (headMap != null && headMap.size() > 0) {  
                    Set<String> keySet = headMap.keySet();  
                   for (String key : keySet) {  
                        httpGet.addHeader(key, headMap.get(key));  
                   }  
               }
                // 通过请求对象获取响应对象
                HttpResponse response = httpClient.execute(httpGet); 
                logger.info("doGet StatusLine=="+response.getStatusLine()); 
                //System.out.println("responseStr=="+ EntityUtils.toString(response.getEntity(),"utf-8"));
                // 判断网络连接状态码是否正常(0--200都数正常)
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                	responseStr= EntityUtils.toString(response.getEntity(),"utf-8");
//                    System.out.println("responseStr="+responseStr);  
                   
                } 
            } catch (Exception e) { 
                e.printStackTrace();
            }
          resultMap.put("responseCode", responseCode +"");
          resultMap.put("responseStr", responseStr);
          
        return resultMap;
        //....result是用户信息,站内业务以及具体的json转换这里也不写了...
    }    
 
  

/** 
     * 将返回结果转化为String 
     *  
     * @param entity 
     * @return 
    * @throws Exception 
     */  
   private static String getRespString(HttpEntity entity) throws Exception {  
        if (entity == null) {  
           return null;  
        }  
        InputStream is = entity.getContent();  
       StringBuffer strBuf = new StringBuffer();  
       byte[] buffer = new byte[4096];  
       int r = 0;  
       while ((r = is.read(buffer)) > 0) {  
            strBuf.append(new String(buffer, 0, r, "UTF-8"));  
        }  
        return strBuf.toString();  
    }  

  
 /**
  * post  发送json
  * @param jsonObj
  * @param url
  * @return
  */
	    public static boolean httpPostWithJson(JSONObject jsonObj, String url){
	        boolean isSuccess = false;
	        HttpPost post = null;
	        try {
	            HttpClient httpClient = new DefaultHttpClient(); 
	            // 设置超时时间
	            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 30000);
	            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 30000);
	            post = new HttpPost(url);
	            // 构造消息头
	            post.setHeader("Content-type", "application/json; charset=utf-8");
	            post.setHeader("Connection", "Close"); 
	            // 构建消息实体
	            logger.info("httpPostWithJson发送的json数据=="+jsonObj.toString()); 
	            StringEntity entity = new StringEntity(jsonObj.toString(), Charset.forName("UTF-8"));
	            entity.setContentEncoding("UTF-8");
	            // 发送Json格式的数据请求
	            entity.setContentType("application/json");
	            post.setEntity(entity);
	            HttpResponse response = httpClient.execute(post);
	            // 检验返回码
	            int statusCode = response.getStatusLine().getStatusCode(); 
	           InputStream is =  response.getEntity().getContent();
	           String resultStr = IOUtils.toString(is,"utf-8");
	           logger.info("httpPostWithJson返回的结果="+resultStr);
	            //打印返回信息
	            if(statusCode != HttpStatus.SC_OK){
	            	//logger.error("httpPostWithJson请求出错: "+statusCode);
	                isSuccess = false;
	            }else{
	                  isSuccess = true; 
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            isSuccess = false;
	        }finally{
	            if(post != null){
	                try {
	                    post.releaseConnection();
	                    Thread.sleep(500);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return isSuccess;
	    }
	    /**
	     * post  发送json
	     * @param jsonObj
	     * @param url
	     * @return
	     */
	    public static Map<String,String>  httpPostJson(JSONObject jsonObj,String url){
	        //boolean isSuccess = false;
	        Map<String,String> resultMap = new HashMap<String,String>();
	        HttpPost post = null;
	        try {
	            HttpClient httpClient = new DefaultHttpClient(); 
	            // 设置超时时间
	            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 30000);
	            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 30000);
	            post = new HttpPost(url);
	            // 构造消息头
	            post.setHeader("Content-type", "application/json; charset=UTF-8");
	            post.setHeader("Connection", "Close"); 
	            // 构建消息实体
	            logger.info("发送的json数据=="+jsonObj.toString());
	            //System.out.println("发送的json数据=="+jsonObj.toString());
	            StringEntity entity = new StringEntity(jsonObj.toString(), Charset.forName("UTF-8"));
	            entity.setContentEncoding("UTF-8");
	            // 发送Json格式的数据请求
	            entity.setContentType("application/json");
	            post.setEntity(entity);
	            HttpResponse response = httpClient.execute(post);
	            // 检验返回码
	            int responseCode = response.getStatusLine().getStatusCode();
	            HttpEntity response_entity=response.getEntity();//调用getEntity()方法获取到一个HttpEntity实例
	            String responseStr="";
	            if(response_entity != null){
	            	responseStr=EntityUtils.toString(response_entity,"UTF-8");//用EntityUtils.toString()这个静态方
	            }  
	            resultMap.put("responseCode", responseCode +"");
	            resultMap.put("responseStr", responseStr);
	     
	        } catch (Exception e) {
	            e.printStackTrace(); 
	        }finally{
	            if(post != null){
	                try {
	                    post.releaseConnection();
	                    Thread.sleep(500);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return resultMap;
	    }
 	    
	    
	    /**
	     * 发送https请求
	     * @param url
	     * @return
	     */
	    public static String getDataHttps(String url) {  
	    	          
	    	       CloseableHttpClient client = createSSLClientDefault();  
	    	        HttpGet getMethod = new HttpGet(); 
	    	        String data = null ;
	    	        try {  
	    	            getMethod.setURI(new URI(url));  
	    	            HttpResponse response = client.execute(getMethod);   
	    	            HttpEntity entity = response.getEntity();  
	    	            data = EntityUtils.toString(entity); 
	    	            return data;  
	    	       } catch (Exception e) {  
	    	    	   //logger.error("HttpUtilsError"+e);
	    	        }   
	    	        return "";  
	    	    }  

	    
	    
	    public static CloseableHttpClient createSSLClientDefault() {  
	    	        try {  
	    	            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {  
	    	                // 信任所有  
	    	                @Override  
	    	                public boolean isTrusted(X509Certificate[] chain, String authType) {  
	    	                    return true;  
	    	                }  
	    	            }).build();  
	    	            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);  
	    	           return HttpClients.custom().setSSLSocketFactory(sslsf).build();  
	    	        } catch (KeyManagementException e) {  
	    	        	//logger.error("SSLUtilsErrorKetManage"+e);
	    	        } catch (NoSuchAlgorithmException e) {  
	    	        	//logger.error("SSLUtilsErrorNOAlgorithm"+e);
	    	        } catch (KeyStoreException e) {  
	    	        	//logger.error("SSLUtilsErrorKeyStore"+e);
	    	        }  
	    	        return HttpClients.createDefault();  
	    	    }  

	    
	    
	    
	    
	    public static byte[] dataPost(String strURL,Map<String,String>head_map, String params){   
	        // 创建一个httppost请求
	        HttpClient httpClient = new DefaultHttpClient();
	        HttpPost httpPost = new HttpPost(strURL);
	        byte[] strResult = null;
	        try { 
	            Iterator iterator_head = head_map.entrySet().iterator();  
	            while(iterator_head.hasNext()){  
	                Entry<String,String> elem = (Entry<String, String>) iterator_head.next();   
	                httpPost.addHeader(elem.getKey(),elem.getValue()); 
	            } 	
	            
	            StringEntity entity = new StringEntity(params, "utf-8");// 解决中文乱码问题
	            entity.setContentEncoding("UTF-8");
	            entity.setContentType("application/text");
	            httpPost.setEntity(entity);
	            HttpResponse  response = httpClient.execute(httpPost);
	            strResult = EntityUtils.toByteArray((response.getEntity()));
	            //System.out.println("查看返回的结果：" + strResult.length);
				return strResult;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
				httpPost.releaseConnection();
			}
	        return new byte[0];
	       
	    } 
 	    
    public void testPost(){  
 	   String url = "http://semantictest.speech.sogou.com/opensemantic";    
        Map<String,String> paramMap = new HashMap<String,String>();
        paramMap.put("text", "今天天气如何"); 
        paramMap.put("city", "天津市");
        paramMap.put("imei_no", "testuserid"); 
        paramMap.put("clearHistory", "1"); 
        paramMap.put("time", "1446199455726"); 
        paramMap.put("appid", "HXOD4474");  
        Map<String,String> result =  doPost(url,  paramMap,"utf-8");
        System.out.println("result:"+result);  
    }  	    
    public void testwangyi(){  
    	String url = "https://api.netease.im/nimserver/user/create.action";  
        String appKey = "54f581cd08418134dd4de95a451a36f3";
        String appSecret = "cb300778ea10";
        String nonce =  "alading";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
 
    	Map<String, String> headMap = new HashMap<String, String>();
        // 设置请求的header
        headMap.put("AppKey", appKey);
        headMap.put("Nonce", nonce);
        headMap.put("CurTime", curTime);
        headMap.put("CheckSum", checkSum);
        headMap.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        
    	Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("accid", "accid1234567890"); //网易云通信ID，最大长度32字符，必须保证一个 02ba8c3fecdc0eae798a9fe585861c4b
 
         Map<String,String> result =  doPost(url, headMap, paramMap,"utf-8");
         logger.info("testwangyi result:"+result);  
         //result:{"code":200,"info":{"token":"02ba8c3fecdc0eae798a9fe585861c4b","accid":"accid1234567890","name":""}}
     }       
    

	public static void freeTimeId() {
		//推送到终端
		String url = "http://172.18.0.228:8080/alading-websocket-service/mesreceive";
    	Map<String, String> headMap = new HashMap<String, String>();
        // 设置请求的header
        headMap.put("messageId", "messageId");
        headMap.put("messageContent", "messageContent");
        headMap.put("target", "target"); 
        
        
        Map<String,String> re =  doPost(url,headMap);
        
        
		System.out.println("flag:"+re.get("responseStr"));
	}	

	public static void IsOnLine() {
		//推送到终端
		String url = "http://172.18.0.228:8080/alading-websocket-service/isonline?id=84:20:96:CF:C5:D2";
    	Map<String, String> headMap = new HashMap<String, String>();  
        Map<String,String> responseStr =  doGet(url,headMap); 
        JSONObject  jasonObject = JSONObject.fromObject(responseStr.get("responseStr"));
		System.out.println("flag:"+jasonObject.get("isOnLine"));
	}
	
	public static void tts() throws UnsupportedEncodingException {
		//推送到终端
		String url = "http://onlinetts.speech.sogou.com/index.tts?";
		Map<String, String> map = new HashMap<String, String>(); 
    	Map<String, String> headMap = new HashMap<String, String>();  
    	String content  = "升级失败了，我们将重新升级，请耐心等待";
    	String data = java.net.URLEncoder.encode(content,"utf-8");
    	System.out.println("data="+content);
    	int data_length = data.length();
    	String param = "version=1&imei_no=352945052498086&speed=1.0&volume=1.0&pitch=1.0&speaker=6&sampling_rate=16&audio_format=2&languages=1&start_time=";
    	long start_time = 1524811092;//getSecondTimestamp(new Date());
    	Adler32 al = new Adler32();
    	al.update(content.getBytes());
    	long i = al.getValue();
    	
    	String content_no = i+"";
    	System.out.println("i="+i);
    	param = param + start_time + "&data_length=" + data_length + "&sequence_no=1&appid=HXOD4474&content_no="+content_no+ "&package_name=com.aladding.test&pt=linux";
    	
    	String signc = getSHA256Str((param+"&appkey=B3d6WsxA"));
    	 System.out.println("param="+param);
    	 System.out.println("signc="+signc);
    	headMap.put("S-SIGN-V", "1");
    	headMap.put("S-SIGN-C", signc);
    	 url = url+param;
    	 System.out.println("url="+url);
    	 System.out.println("data="+data);
    	 map.put("data", data);
    	 byte[]   result = dataPost(url,headMap,data); 
    	 FileOutputStream out = null;
    	 BufferedOutputStream buff=null;
    	 try {
			out = new FileOutputStream(new File("C:\\add1.mp3"));
			buff = new BufferedOutputStream(out);
			try {
				buff.write(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            //关闭流
            if(out != null){
                try {
                	out.close();
                	buff.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
//         String str = responseStr.get("responseStr");
//         String code = responseStr.get("responseCode");
//		System.out.println("code:"+code+"&str:"+str);   	 
    	 
    	 
 
	}
	
	public static int getSecondTimestamp(Date date){  
	    if (null == date) {  
	        return 0;  
	    }  
	    String timestamp = String.valueOf(date.getTime());  
	    int length = timestamp.length();  
	    if (length > 3) {  
	        return Integer.valueOf(timestamp.substring(0,length-3));  
	    } else {  
	        return 0;  
	    }  
	} 
	  public static String getSHA256Str(String str){
	        MessageDigest messageDigest;
	        String encdeStr = "";
	        try {
	            messageDigest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
	            encdeStr = Hex.encodeHexString(hash);
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        return encdeStr;
	    }
	  
	  public static String backMsg(){
		  String  receiveMessage = "{    'messageId': 'alarmzrsim1526291855847',  'resultCode': '0000'   	}";
	    	JSONObject jasonObject = UtilCommon.isJson(receiveMessage);
	    	String url = "http://127.0.0.1:8080/alading-interface-message/backMsg/optMsg.ajax";
	    	Map<String,String> resultMap =null;
	    	if(jasonObject !=null && StringUtils.isNotBlank(url)){ 
	    		 Map<String,String> bodyMap = new HashMap<String,String>();
	    		 bodyMap.put("backMsg", receiveMessage);
				  resultMap = HttpClientRequest.doPost(url, bodyMap);
				System.out.println("resultMap: responseCode="+resultMap.get("responseCode"));
				System.out.println("resultMap: responseStr="+resultMap.get("responseStr"));
	    	}
	    	return resultMap.get("responseCode");
	  }
   public static void main(String[] args){  
	   HttpClientRequest main = new HttpClientRequest();  
       //main.test();
	   try {
		main.backMsg();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
   }

    
  

   
	 
	 
	 
	
	  

   
    
    
    
 
 
}