package com.node3.cn.util;

import java.util.HashMap;
import java.util.Map;


public class ErrorNumber {
	//获取链接异常
	public static final String RequestException="1111";
	//获取链接异常
	public static final String ConException="1000";
	//链接关闭异常
	public static final String ConCloseException="1001";
	//数据库执行异常
	public static final String SQLException="1002";
	//未知异常
	public static final String UnkownException="2000";
	
	//缺少请求参数激活码
	public static final String ParamACTErrorException="2010";
	//缺少请求参数SN
	public static final String ParamSNErrorException="2011";
	//缺少请求参数MAC
	public static final String ParamMACErrorException="2012";
	//缺少请求参数SoftID
	public static final String ParamSoftIDErrorException="2013";
	//缺少请求参数系统软件版本号
	public static final String ParamSysVerErrorException="2014";

	//缺少请求参数加密后的数据
	public static final String ParamDataErrorException="2016";
	//缺少请求参数校验码
	public static final String ParamVerifyErrorException="2017";
	//缺少请求参数数量count
	public static final String ParamCountErrorException="2018";
	//串号校验不符
	public static final String ParamSNCheckException="2019";
	//数据库中不存在对应的软件物料号
	public static final String ParamSoftIDisNullException="2020";
	//数据库中不存在对应的平台ID
	public static final String ParamPlatformIDisNullException="2021";
	//缺少请求参数系统软件svn版本
    public static final String ParamSysBuildErrorException="2022";
	
	//查询所有闹铃失败
	public static final String SELECT_ALL_ALARM = "2023";
	//闹铃新增成功
	//public static final String ADD_ALARM_SUCCESS = "2024";
	//闹铃删除成功
	//public static final String DEL_ALARM_SUCCESS = "2025";
	//资源查询根据Id
	public static final String RESOURCE_SELECT_FAIL = "2026";
	//闹铃修改成功
	//public static final String CHANGE_ALARM_SUCCESS = "2027";
	//闹铃新增失败
	public static final String ADD_ALARM_FAIL = "2028";
	//闹铃修改失败
	public static final String CHANGE_ALARM_FAIL = "2029";
	//闹铃删除失败
	public static final String DELETE_ALARM_FAIL = "2030";
	//字符转换异常
	public static final String CN_CHARACTER_TRANSFER_EXCEPTION = "2031";
	//参数为空
	public static final String PARAM_IS_NULL = "2032";
	//请正确设置开始日期和结束日期，开始日期应该小于结束日期
	public static final String START_DATE_SHOULD_BEFORE_END_DATE = "2033";
	//参数Md5加密验证错误
	public static final String PARAM_MD5VALID_ERROR = "2034";
	//缺少请求参数签名
	public static final String PhoneErrorException="2035";
	//非法用户
	public static final String UnlawfullyException="2003";
    //授权码不足
	public static final String LicenseNotEnoughException="2004";
    //生成文件错误
	public static final String CreateFileException="2005";
    //会话过期
	public static final String SessionTimeoutException="2006";
    //登录重复
	public static final String LoginRepeatException="2007";
    //根据mac查询唤醒列表为空
	public static final String MacByAwakenException="2008";
	
    //加密串号及MAC地址结果为空
	public static final String SN_MAC_EncodeException="3001";
	//获取资源失败
	public static final String GET_RESOURCE_FAILException = "3002";
	public static final String SUCCESS = "0000";
	
	
	
	//设备不存在
	public static final String DEVICE_NOT_FOUNDEXCEPTION = "3010";
	//设备无效
	public static final String DEVICE_NOT_ACTIVEEXCEPTION = "3011";
	//用户未绑定此设备
	public static final String USER_NOT_BINDEXCEPTION = "3012";
	
	
	
	/****订阅相关***/
	
	//订阅失败
	public static final String SUB_SERVICE_FAIL = "4000";
	
	//订阅场景不存在
	public static final String SUB_SERVICE_SCENE_NO = "4001";
	
	
	//订阅场景不存在
	public static final String SUB_SERVICE_YED = "4002";
	
	//未订阅不能取消订阅
	public static final String SUB_SERVICE_NOSTATEEXIST = "4003";
	
	
	//系统自带订阅不能取消订阅
	public static final String SUB_SERVICE_SYSTYPE = "4004";
	
	//技能不存在
	public static final String SKILL_NOSTATEEXIST = "5000";
	
	//订阅失败
	//public static final String SUB_SERVICE_ISEXIST = "4004";
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//输入的账号不存在，请注册
	public static final String VALID_ACCOUNT_CODE_ERROR="8001";
	 
	
	//输入的账号不存在，请注册
	public static final String VALID_ACCOUNT_CODE5_ERROR="8005";
	 
	
	//验证码错误
	public static final String VALID_CODE_ERROR="8000"; 	
	
	//验证码错误 ，超过3次 ，从新发生验证码
	public static final String VALID_THREE_CODE_ERROR="8003";
	 
		
	//验证码已经过期,请从新获取
	public static final String VALID_OVERDUE_CODE_ERROR="8002";
		 
	
	//短信渠道获取验证码失败
	public static final String ShortMessageException="8012"; 	
	
	//验证码错误超过10次，请明天登入
	public static final String VALID_TEN_CODE_ERROR="8010";  
	
    //系统异常
	public static final String SystemException="9999";	
    //参数格式错误
	public static final String ParamFormatException="2002";	
    //注册失败
	public static final String RegisterException="1002";
    //注册失败
	public static final String RegisterImException="1003";
    //"帐号或密码错误!登录失败"
	public static final String AccountException="1001";
    //"帐号或密码错误!登录失败"
	public static final String QueryUserInfoException="1009";	
	// 签名 不对等
	public static final String ParamSignErrorException="2015";
    //缺少请求参数
	public static final String ParamErrorException="2001";
	//第一次登录，注册验证 
	
    //"帐号或密码错误!登录失败"
	public static final String OriginalPwdException="2011";
	
    //"获取环信账号失败"
	public static final String GetImException="5001";
    //"获取环信账号失败"
	public static final String AlarmNotHaveException="5003";	
	
    //缺少请求参数
	public static final String SnCountErrorException="7001";
	
    //服务已经下线
	public static final String serviceOffLineException="7010";
    //服务未订阅
	public static final String serviceNoSubstatesException="7011";
 
	public static   Map errorCodeMap= new HashMap(); 
	static {  
		errorCodeMap.put(SUCCESS, "操作成功");
		errorCodeMap.put(RequestException, "请求失败");
		errorCodeMap.put(SystemException, "系统异常!");
		errorCodeMap.put(ParamFormatException, "参数校验错误!");
		errorCodeMap.put(AccountException, "账户或密码错误，请重新填写"); 
		errorCodeMap.put(RegisterException, "注册失败");
		errorCodeMap.put(RegisterImException, "注册IM失败");
		errorCodeMap.put(VALID_TEN_CODE_ERROR, "当天获取验证码达到上限请明天再试"); 
		errorCodeMap.put(ShortMessageException, "获取验证码失败"); 
		errorCodeMap.put(VALID_OVERDUE_CODE_ERROR, "验证码已经过期,请重新获取！"); 
		errorCodeMap.put(VALID_THREE_CODE_ERROR, "验证码连续输错三次,请重新获取！"); 
		errorCodeMap.put(VALID_CODE_ERROR, "验证码错误"); 
		errorCodeMap.put(VALID_ACCOUNT_CODE5_ERROR, "账号已存在"); 
		errorCodeMap.put(VALID_ACCOUNT_CODE_ERROR, "输入的账号不存在，请注册");
		errorCodeMap.put(OriginalPwdException, "原密码错误");
		
		errorCodeMap.put(DEVICE_NOT_FOUNDEXCEPTION, "设备不存在");
		errorCodeMap.put(DEVICE_NOT_ACTIVEEXCEPTION, "设备无效");
		errorCodeMap.put(USER_NOT_BINDEXCEPTION, "用户未绑定此设备");
		
		errorCodeMap.put(ParamSignErrorException, "签名错误");
		errorCodeMap.put(ParamErrorException, "请求参数值错误");
		
		errorCodeMap.put(GET_RESOURCE_FAILException, "获取资源失败");
		
		errorCodeMap.put(PARAM_MD5VALID_ERROR, "参数MD5校验错误");
		//errorCodeMap.put(ADD_ALARM_SUCCESS,"闹铃新增成功");
		//errorCodeMap.put(DEL_ALARM_SUCCESS,"闹铃删除成功");
		errorCodeMap.put(RESOURCE_SELECT_FAIL,"根据ID获取资源失败");
		//errorCodeMap.put(CHANGE_ALARM_SUCCESS ,"闹铃修改成功");
		errorCodeMap.put(ADD_ALARM_FAIL ,"闹铃新增失败");
		errorCodeMap.put(CHANGE_ALARM_FAIL ,"闹铃修改失败");
		errorCodeMap.put(DELETE_ALARM_FAIL ,"闹铃删除失败");
		errorCodeMap.put(CN_CHARACTER_TRANSFER_EXCEPTION ,"中文字符转换异常");
		errorCodeMap.put(PARAM_IS_NULL ,"闹铃删除失败");
		errorCodeMap.put(AlarmNotHaveException ,"没有最新的闹钟");
		
		errorCodeMap.put(START_DATE_SHOULD_BEFORE_END_DATE ,"中文字符转换异常");
		
		errorCodeMap.put(SUB_SERVICE_FAIL ,"订阅异常");
		errorCodeMap.put(SUB_SERVICE_SCENE_NO ,"订阅场景不存在");
		errorCodeMap.put(SUB_SERVICE_YED ,"重复订阅");
		errorCodeMap.put(SUB_SERVICE_NOSTATEEXIST ,"未订阅不能取消订阅");
		errorCodeMap.put(SUB_SERVICE_SYSTYPE ,"系统自带,不能取消订阅");
		
		errorCodeMap.put(GetImException ,"获取环信账号失败");
		errorCodeMap.put(SnCountErrorException ,"SN申请数额过大");
		
		errorCodeMap.put(serviceOffLineException ,"服务已经下线");
		errorCodeMap.put(serviceNoSubstatesException ,"服务未订阅");
		errorCodeMap.put(UnkownException ,"未知异常");
		
		errorCodeMap.put(PhoneErrorException ,"手机号码已存在");
		
		errorCodeMap.put(SKILL_NOSTATEEXIST ,"没找到相关技能");
		
		errorCodeMap.put(MacByAwakenException, "获取唤醒列表失败");
	  }  
	
}
