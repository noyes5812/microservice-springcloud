/**
 * 
 */
package com.node3.cn.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 

/**
 * 
 *@Title: EmailUtil.java
 *@Description  TODO(描述做什么)
 *@author yemingxin  
 *@date 2017-6-21 下午3:45:55 
 *@version V1.0
 */
public class EmailUtil {
	private static final Logger logger = LoggerFactory.getLogger(EmailUtil.class);
	 
	
	/**
	 * 批量拆分邮件地址
	 * @param emailAddresses
	 * @param spliter
	 * @return
	 */
	public static List<String> splitEmailAddress(List<String> emailAddresses,String spliter){
		List<String> emails = new LinkedList<String>();
		if(emailAddresses != null && StringUtils.isNotEmpty(spliter)){
			for(String email : emailAddresses){
				emails.addAll(splitEmailAddress(email, spliter));
			}
		}else{
			if(emailAddresses != null){
				emails.addAll(emailAddresses);
			}
		}
		return emails;
	}
	
	/**
	 * 拆分邮件地址
	 * @param emailAddress
	 * @param spliter
	 * @return
	 */
	public static List<String> splitEmailAddress(String emailAddress,String spliter){
		List<String> emails = new LinkedList<String>();
		if(!StringUtils.isEmpty(emailAddress) && !StringUtils.isEmpty(spliter)){
			String[] emailAttr = emailAddress.split(spliter);
			if(emailAttr != null){
				for(String email : emailAttr){
					if(StringUtils.isNotEmpty(email)){
						emails.add(email.trim());
					}
				}
			}
		}else{
			emails.add(emailAddress);
		}
		return emails;
	}
	
	public static void main(String[] arg){ 
			String emailAdress = SystemConfig.getPropertie("emailAdress");
			logger.info("巡检任务告警邮件地址是"+emailAdress);
			List<String> adresses = EmailUtil.splitEmailAddress(emailAdress,","); 
			String title = "test告警邮件title";
			String content = "test任务告警邮件content";
			//告警内容为空 ， 即不发送告警邮件
			if(StringUtils.isNotBlank(content)){
				 
			}
			logger.info("发送邮件end");
		 
	}
}
