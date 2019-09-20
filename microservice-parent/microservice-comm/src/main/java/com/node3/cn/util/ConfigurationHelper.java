package com.node3.cn.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.node3.cn.constant.Constant;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;


/**
 * 配置文件帮助类.
 * 
 * @author 
 * 
 */
public final class ConfigurationHelper {
    /**
     * logger.
     */
    private static final Logger logger = LoggerFactory
                            .getLogger(ConfigurationHelper.class);
    /**
     * xml文件后缀名.
     */
    private static final String XML = ".xml";
    /**
     * properties文件后缀名.
     */
    private static final String PROPERTIES = ".properties";
    /**
     * HTTP协议前缀.
     */
    private static final String HTTP = "HTTP://";

    /**
     * 开发配置文件根目录.
     */
    private static String basePath  = null;
    private static String deployPath = null;
    
    
    public static String getDeployPath() {
		return getBasePath() + File.separator + Constant.DEPLOY_PATH;
	}

	public static void setDeployPath(String deployPath) {
		ConfigurationHelper.deployPath = deployPath;
	}

	/**
     * 私有构造涵数，防止被构造.
     */
    private ConfigurationHelper() {

    }

    /**
     * 设置开发配置文件根目录.
     * @parambasePath 根目录.
     */
    public static void setBasePath(String path) {
        basePath = path;                
    }
    
    /**
     * 得到开发配置文件根目录.
     * @return 根目录.
     */
    public static String getBasePath() {
    	if(basePath == null){
    		return System.getProperty("user.dir");
    	}
        return basePath;                
    }

    /**
     * 根据配置文件名得到配置文件流.
     * 
     * @param configurationFileName
     *            配置文件名
     * @return 配置文件流
     */
    public static InputStream readConfiguration(String configurationFileName) {
        // 得到配置文件全路径名（如果设置了basePath，fileName=basePath+configurationFileName）
        String fileName = getFullFileName(configurationFileName);
        return readBaseConfiguration(fileName);
     
    }
    
    /**
     * 根据配置文件名得到配置文件流.
     * 
     * @paramconfigurationFileName
     *            配置文件名
     * @return 配置文件流
     */
    private static InputStream readBaseConfiguration(String fileName) {
        if (fileName == null) {
            return null;
        }
     
        // 检查配置文件是否URL文件
        boolean isUrl = isUrlFile(fileName);
        
        if (isUrl) {
            URL url;
            try {
                url = new URL(fileName);
                return url.openStream();
            } catch (MalformedURLException e) {
                logger.error("打开URL配置文件失败，URL=" + fileName,e);
            } catch (IOException e) {
                logger.error("打开URL配置文件失败，URL=" + fileName,e);
            }
            return null;
        } else {
            try {
                File file = new File(fileName);
                FileInputStream fileInputStream = new FileInputStream(file);
                return fileInputStream;
            } catch (FileNotFoundException e) {
                logger.error("打开配置文件失败，filename=" + fileName,e);
            }
            return null;
        }
    }
    
    /**
     * 根据开发配置文件名得到开发配置对象.
     * 
     * @param configurationFileName
     *            配置文件名
     * @return 配置对象
     */
    public static Configuration getConfiguration(String configurationFileName) {
    	return getConfiguration(configurationFileName,0,false);
    }

    /**
     * 根据开发配置文件名得到开发配置对象.
     * 
     * @param configurationFileName
     *            配置文件名
     * @param refreshDelay
     *            刷新时间(微秒单位)
     * @return 配置对象
     */
    public static Configuration getConfiguration(String configurationFileName,
            long refreshDelay) {
    	return getConfiguration(configurationFileName,refreshDelay,false);
    }
    
    /**
     * 根据开发配置文件名得到开发配置对象.
     * 
     * @param configurationFileName
     *            配置文件名
     * @param refreshDelay
     *            刷新时间(微秒单位)
     * @param delimiterParsingDisabled 
     * 			     是否关闭界定符解析          
     * @return 配置对象
     */
    public static Configuration getConfiguration(String configurationFileName,
            long refreshDelay, boolean delimiterParsingDisabled) {
    	 // 得到配置文件全路径名（如果设置了basePath，fileName=basePath+configurationFileName）
        String fileName = getFullFileName(configurationFileName);
    	return getBaseConfiguration(fileName,refreshDelay,delimiterParsingDisabled);
    }
    
    /**
     * 根据配置文件名得到配置对象.
     * 
     * @paramconfigurationFileName
     *            配置文件名
     * @param refreshDelay
     *            刷新时间(微秒单位)
     * @param delimiterParsingDisabled 
     * 			     是否关闭界定符解析
     * @return 配置对象
     */
    private static Configuration getBaseConfiguration(String fileName,
            long refreshDelay, boolean delimiterParsingDisabled) {
        if (fileName == null) {
            return null;
        }
        
        // 检查配置文件类型
        boolean isXmlFile = false;
        if (fileName.endsWith(XML)) {
            isXmlFile = true;
        } else if (fileName.endsWith(PROPERTIES)) {
            isXmlFile = false;
        } else {
            return null;
        }

        // 检查配置文件是否URL文件
        boolean isUrl = isUrlFile(fileName);

        if (isXmlFile) {
            XMLConfiguration xmlConfiguration = new XMLConfiguration();
            xmlConfiguration.setDelimiterParsingDisabled(delimiterParsingDisabled);
            if (isUrl) {
                try {
                    xmlConfiguration.load(new URL(fileName));
                } catch (ConfigurationException e) {
                    logger.error("打开URL配置文件失败，URL=" + fileName,e);
                    return null;
                } catch (MalformedURLException e) {
                    logger.error("打开URL配置文件失败，URL=" + fileName,e);
                    return null;
                }
            } else {
                try {
                    xmlConfiguration.load(fileName);
                } catch (ConfigurationException e) {
                    logger.error("打开配置文件失败，filename=" + fileName,e);
                    return null;
                }
            }
            // 如果需要定时刷新,设置刷新策略
            if (refreshDelay > 0) {
                FileChangedReloadingStrategy fileChangedReloadingStrategy = new FileChangedReloadingStrategy();
                fileChangedReloadingStrategy.setConfiguration(xmlConfiguration);
                fileChangedReloadingStrategy.setRefreshDelay(refreshDelay);
                xmlConfiguration.setReloadingStrategy(fileChangedReloadingStrategy);
            }
            return xmlConfiguration;
        } else {
            PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();
            propertiesConfiguration.setDelimiterParsingDisabled(delimiterParsingDisabled);
            if (isUrl) {
                try {
                    propertiesConfiguration.load(new URL(fileName));
                } catch (ConfigurationException e) {
                    logger.error("打开URL配置文件失败，URL=" + fileName,e);
                    return null;
                } catch (MalformedURLException e) {
                    logger.error("打开URL配置文件失败，URL=" + fileName,e);
                    return null;
                }
            } else {
                try {
                    propertiesConfiguration.load(
                            fileName);
                } catch (ConfigurationException e) {
                    logger.error("打开配置文件失败，filename=" + fileName,e);
                    return null;
                }
            }

            // 如果需要定时刷新,设置刷新策略
//            if (refreshDelay > 0) {
//                FileChangedReloadingStrategy reloadingStrategy = null;
//                if (isUrl) {
//                    reloadingStrategy = new RemoteFileChangedReloadingStrategy();
//                } else {
//                    reloadingStrategy = new FileChangedReloadingStrategy();
//                }
//                reloadingStrategy.setConfiguration(propertiesConfiguration);
//                reloadingStrategy.setRefreshDelay(refreshDelay);
//                propertiesConfiguration.setReloadingStrategy(reloadingStrategy);
//
//            }
            return propertiesConfiguration;
        }

    }

    /**
     * 得到开发配置文件全路径名.
     * @param fileName 配置文件名
     * @return 全路径名
     */
//    public static String getFullFileName(String fileName) {
//    	if(fileName == null) return null;
//        if (basePath != null) {
//            return basePath + File.separator + fileName;
//        }
//        return fileName;
//    }
 
    /**
     * 得到开发配置文件全路径名.
     * @param fileName 配置文件名
     * @return 全路径名
     */
    public static String getFullFileName(String fileName) {
    	if(fileName == null) return null;
        if (deployPath  == null) {
        	deployPath = getDeployPath(); 
        }
        return deployPath + File.separator + fileName;
    }    
    /**
     * 是否URL配置文件.
     * @param fileName 配置文件名
     * @return 全路径名
     */
    private static boolean isUrlFile(String fileName) {
        if (fileName.toUpperCase().startsWith(HTTP)) {
            return true;
        }
        return false;
    }

}

