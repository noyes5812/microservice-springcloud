package com.node3.cn.util;
/**
 * @ClassName:      ErrorNumberMsg
 * @Description:    错误代码及提示信息枚举类 （错误码设计规则请参考showdoc文档：http://showdoc.alading.com/index.php?s=/1&page_id=146）
 * @author:           zhouguoxun
 * @date:            2018-04-26 20:22
 */
public enum ErrorNumberMsg {
	ALAD_OPT_SUCCESS("99060000","操作成功"), //操作成功 
	ALAD_OPT_FAIL("99060001", "数据处理异常") ,
	//终端接口-终端主动拉取接口 模块代码 “09”
	ALAD_QUERY_AWAKEN_LIST_SQLEXCEPTION("21100001","查询唤醒列表sql异常"),
	
	ALAD_QUERY_AWAKEN_LIST_RESULT_EMPTY_FAIL("21100002","查询唤醒列表为空"),
	
	ALAD_QUERY_AWAKEN_LIST_MAC_EMPTY_FAIL("21100003","查询唤醒列表MAC值为空"),
	
	ALAD_QUERY_AWAKEN_LIST_EXCEPTION_FAIL("21100004","根据MAC查询当日的唤醒列表sql异常，exception={?}"),
	
	
	//APP接口-技能（服务）接口 模块代码 “02”
	ALAD_ALARM_SIGN_VAILD_FAIL("12020005","签名校验失败"),//签名错误[原有提示信息] 保留

	ALAD_QUERY_ALARM_lIST_SUCCESS("12020004","操作成功"), //不显示
	
	ALAD_QUERY_ALARM_RESOURCEID_EMPTY_FAIL("12020001","数据请求失败"),//获取资源失败[原有提示信息] 闹钟接口查询资源资源ID为空值
	
	ALAD_ADD_ALARM_PARAM_SIGN_VALID_EXCEPTION_FAIL("12020002","保存失败"), //闹铃修改失败[原有提示信息] 增加闹钟校验参数，签名时异常
	
	ALAD_ADD_ALARM_URLDECODER_NAME_EXCEPTION_FAIL("12020003","保存失败"), //中文字符转换异常[原有提示信息]  增加闹钟名称转译异常【utf8】
	
	ALAD_ADD_ALARM_DEVICE_NOT_ONLINE_FAIL("12020006","小闹闹离线了"), //设备不存在[原有提示信息]
	
	ALAD_ADD_ALARM_EXCEPTION_FAIL("12020007","保存失败"), //闹钟新增失败[原有提示信息] 新增闹钟SQL异常失败
	
	ALAD_UPDATE_ALARM_STATUS_URLDECODER_NAME_EXCEPTION_FAIL("12020008","保存失败"), //中文字符转换异常[原有提示信息] 修改闹钟状态名称转译异常【utf8】
	
	ALAD_UPDATE_ALARM_STATUS_PARAM_SIGN_VALID_EXCEPTION_FAIL("12020009","保存失败"), //闹铃修改失败[原有提示信息]       这个前端没有这个功能 修改闹钟校验参数，签名时异常

	ALAD_UPDATE_ALARM_STATUS_DEVICE_NOT_ONLINE_FAIL("12020010","小闹闹离线了"), //设备不存在[原有提示信息] 请先为设备联网吧！

	ALAD_UPDATE_ALARM_STATUS_EXCEPTION_FAIL("12020011","保存失败"), //闹钟新增失败[原有提示信息]                     修改为 修改闹钟失败

	ALAD_DELETE_ALARM_ALARMID_EMPTY_FAIL("12020012","删除失败"), //闹铃删除失败[原有提示信息]                  修改为 删除闹钟失败
	
	ALAD_DELETE_ALARM_DEVICE_NOT_ONLINE_FAIL("12020013","小闹闹离线了"), //设备不存在[原有提示信息]

	ALAD_DELETE_ALARM_EXCEPTION_FAIL("12020014","删除失败"), //闹钟删除失败[原有提示信息]                            修改为 删除闹钟失败
	

	ALAD_QUERY_ALARM_RESOURCE_EXCEPTION_FAIL("12020015","数据请求失败"),//获取资源失败[原有提示信息] 根据资源ID查询资源sql异常失败
	
	ALAD_QUERY_LATELY_ALARM_EMPTY_FAIL("12020016","数据请求失败"),//没有最新的闹钟[原有提示信息]Lately
	
	ALAD_QUERY_LATELY_ALARM_EXCEPTION_FAIL("12020017","数据请求失败"),//系统异常[原有提示信息]Lately              修改 获取闹钟列表失败

	ALAD_GET_MESSAGE_ALARM_SUB_EXCEPTION_FAIL("22020018","数据请求失败"), //系统异常！[原有提示信息]    获取闹钟及订阅服务失败！

	ALAD_APP_REPORT_SUCCESS("22020019","操作成功"), //操作成功！[原有提示信息]

	ALAD_APP_REPORT_EXCEPTION_FAIL("22020020","上报信息失败"), //上报app信息失败！[原有提示信息]

	ALAD_GET_SKILL_MAC_USERID_EMPTY_FAIL("22020021","数据请求失败"), //参数校验错误!！[原有提示信息]   获取技能接口Mac或UserID为空值！

	ALAD_GET_SKILL_EXCEPTION_FAIL("22020022","数据请求失败"), //获取技能接口失败!！[原有提示信息]

	ALAD_SUB_SCRIPTION_MAC_USERID_SUBSTATE_SKILLID_EMPTY_FAIL("22020023","数据请求失败"), //参数校验错误!！[原有提示信息]  订阅接口Mac或UserID，技能ID，状态值为空值！
	
	ALAD_SUB_SCRIPTION_SYSTEM_UNCANSEL_FAIL("22020024","系统服务不能取消订阅"), //系统自带,不能取消订阅!！[原有提示信息]

	ALAD_SUB_SCRIPTION_REPEAT_FAIL("22020025","重复订阅"), //重复订阅!！[原有提示信息]
	
	ALAD_SUB_SCRIPTION_UNCANSEL_FAIL("22020026","未订阅不能取消订阅"), //未订阅不能取消订阅！[原有提示信息]

	ALAD_SUB_SCRIPTION_FAIL("22020027","订阅失败"), //订阅异常![原有提示信息]订阅场景不存在

	ALAD_SUB_SCRIPTION_NOTEXIST_FAIL("22020028","订阅失败"), //订阅场景不存在![原有提示信息]

	ALAD_SUB_SCRIPTION_SUCCESS("22020029","订阅成功"), //订阅成功![原有提示信息]订阅成功
	
	ALAD_SUB_SCRIPTION_CANCELSUCCESS("22020036","取消订阅成功"), //取消订阅成功![原有提示信息]订阅成功

	ALAD_SUB_SCRIPTION_EXCEPTION_FAIL("22020030","订阅失败"), //订阅失败![原有提示信息]没找到相关技能
	
	ALAD_GET_SKILL_BYID_MAC_USERID_SKILLID_EMPTY_FAIL("22020031","数据请求失败"), //参数格式错误![原有提示信息] 根据ID查询技能Mac、用户ID、技能ID为空值

	ALAD_GET_SKILL_BYID_NOTEXIST_FAIL("22020032","技能已下架"), //没找到相关技能![原有提示信息]
	
	ALAD_GET_SKILL_BYID_EXCEPTION_FAIL("22020033","订阅失败"), //订阅失败![原有提示信息]
	
	//出现已订阅整点报时的提示语：
			//已经订阅过整点报时类的其他服务，是否要更换为新的服务呢？
			//出现已订阅每日订阅的提示语：
			//已经订阅过每日订阅类的其他服务，是否要更换为新的服务呢？
	
														  //已订阅其他的整点报时，是否更换为这个？
	ALAD_GET_SKILL_ONTIMESERVCIE_EXCEPTION_FAIL("22020034","已经订阅过整点报时类的其他服务，是否要更换为新的服务呢？"), //订阅失败![原有提示信息]
	
	ALAD_GET_SKILL_EVERYDAYSERVCIE_EXCEPTION_FAIL("22020035","已经订阅过每日订阅类的其他服务，是否要更换为新的服务呢？"), //订阅失败![原有提示信息]
	

	ALAD_ADD_ALARM_SUCCESS("12020034","新增成功"), //新增闹钟成功[原有提示信息]

	ALAD_UPDATE_ALARM_SUCCESS("12020035","修改成功"), //修改闹钟成功[原有提示信息]

	ALAD_DELETE_ALARM_SUCCESS("12020036","删除成功"), //删除闹钟成功[原有提示信息]
	
	
	//APP首页轮播图
	ALAD_GET_HOMEBANNER_EMPTY_FAIL("22020037","数据请求失败"), //参数校验错误!！[原有提示信息]   ！
	
	
	//APP接口-用户相关接口 模块代码 “01”  
	ALAD_VERIFICATION_CODE_600_FAIL("12009999","操作频繁，每小时只能获取5次"),//验证码在60秒内 不管，会动态修改msg
	
	ALAD_VERIFICATION_CODE_60_FAIL("12010000","操作频繁，每60秒只能获取1次"),//验证码在60秒内 不管，会动态修改msg
	
	ALAD_VERIFICATION_CODE_OVERDUE_FAIL("12010001","验证码已经过期，请重新获取"),//验证码已经过期,请重新获取！[原有提示信息]

	ALAD_VERIFICATION_CODE_THREE_ERROR_FAIL("12010002","验证码连续输错3次，请重新获取"),//验证码连续输错三次,请重新获取！[原有提示信息]
	
	ALAD_VERIFICATION_CODE_ERROR_FAIL("12010003","验证码错误，请重新输入"),//验证码错误[原有提示信息]
	
	ALAD_REGISTER_USER_EXCEPTION_FAIL("12010004","注册失败"),//系统异常[原有提示信息] 用户注册sql异常失败!

	ALAD_LOGIN_USER_PSD_OR_USER_ERROR("12010005","账户或密码错误，请重新输入"),//账户或密码错误，请重新填写[原有提示信息]
	
	ALAD_LOGIN_USER_EXCEPTION_FAIL("12010006","登录失败"), //系统异常[原有提示信息]  登录失败！SQL异常失败
	
	ALAD_QUERY_USER_IS_LOGIN_EXCEPTION_FAIL("12010007","登录失败"), //系统异常[原有提示信息]                    提示 登录失败

	ALAD_QUERY_USERINFO_USERID_EMPTY_FAIL("12010008","数据请求失败"), //系统异常[原有提示信息]                       提示  用户信息获取失败

	ALAD_QUERY_USERINFO_EXCEPTION_FAIL("12010009","数据请求失败"), //系统异常[原有提示信息]                         提示  用户信息获取失败

	ALAD_QUERY_USERACCOUNT_USERID_EMPTY_FAIL("12010010","数据请求失败"), //系统异常[原有提示信息]   查询用户账户信息用户ID为空！           

	ALAD_QUERY_USERACCOUNT_EXCEPTION_FAIL("12010011","数据请求失败"), //系统异常[原有提示信息]     查询用户账户信息SQL异常失败！            

	ALAD_UPDATE_USERINFO_SIGH_EMPTY_FAIL("12010012","修改失败"), //throw exception,先改为统一格式[原有提示信息]  修改用户信息签名为空！

	ALAD_UPDATE_USERINFO_EXCEPTION_FAIL("12010013","修改失败"), //系统异常[原有提示信息]                          提示 修改用户信息失败

	ALAD_UPDATE_USERINFO_SET_PASSWORD_EXCEPTION_FAIL("12010014","设置失败"), //系统异常[原有提示信息]             提示 设置密码失败
	
	ALAD_UPDATE_USERINFO_UPDATE_PASSWORD_EMPTY_FAIL("12010015","旧密码输入错误"), //系统异常[原有提示信息]  

	ALAD_UPDATE_USERINFO_UPDATE_PASSWORD_EXCEPTION_FAIL("12010016","修改失败"), //系统异常[原有提示信息]  修改用户密码SQL异常失败！

	ALAD_UPDATE_USERINFO_FIND_PASSWORD_EMPTY_FAIL("12010017","找回密码失败"), //系统异常[原有提示信息]  ？？？？旧密码输入错误为什么会提示这个

	ALAD_UPDATE_USERINFO_FIND_PASSWORD_EXCEPTION_FAIL("12010018","找回密码失败"), //系统异常[原有提示信息]            提示 找回密码失败
	
	ALAD_UPDATE_USERINFO_UPDATE_PHONE_REPEATBINDING_FAIL("12010019","手机号已被注册，请更换绑定手机号"), //系统异常[原有提示信息]   重复绑定手机号码！         
 
	ALAD_UPDATE_USERINFO_UPDATE_PHONE_EXCEPTION_FAIL("12010020","找回密码失败"), //系统异常[原有提示信息]             提示  找回密码失败

	ALAD_REGISTER_IM__FAIL("12010021","注册IM失败"), //注册IM失败[原有提示信息] 

	ALAD_REGISTER_IM__EXCEPTION_FAIL("12010022","注册IM失败"), //注册IM失败[原有提示信息] 注册IM异常失败！

	ALAD_BINDING_MODE_SUCCESS("12010023","绑定成功"), //绑定成功！[原有提示信息] 

	ALAD_BINDING_MODE_EXCEPTION_FAIL("12010024","绑定失败"), //绑定成功！[原有提示信息] 
	 
	ALAD_UN_BINDING_MODE_SUCCESS("12010025","解绑成功"), //解绑成功！[原有提示信息] 

	ALAD_UN_BINDING_MODE_EXCEPTION_FAIL("12010026","解绑失败"), //解绑成功！[原有提示信息] 

	ALAD_QUERY_FRIEND_LIST_EXCEPTION_FAIL("12010027","获取好友列表失败"), //系统异常！[原有提示信息] 

	ALAD_FIND_FRIEND_INFO_USERID_OR_SEARCHNAME_EMPTY_FAIL("12010028","查找好友失败"), //系统异常！[原有提示信息]
	
	ALAD_FIND_FRIEND_INFO_EXCEPTION_FAIL("12010029","查找好友失败"), //系统异常！[原有提示信息]

	ALAD_GET_VALIDCODE_PHONE_FAIL("12010030","手机号码不正确"), //参数格式错误！[原有提示信息]

	ALAD_GET_VALIDCODE_PHONE_EMPTY_FAIL("12010031","手机号码为空"), //参数格式错误！[原有提示信息] 

	ALAD_GET_VALIDCODE_COUNT_PASS_TEN_FAIL("12010032","当天获取验证码达到上限请明天再试"), //当天获取验证码达到上限请明天再试[原有提示信息]

	ALAD_GET_VALIDCODE_THIRDPARTY_FAIL("12010033","获取验证码失败"), //获取验证码失败[原有提示信息]

	ALAD_GET_VALIDCODE_EXCEPTION_FAIL("12010034","获取验证码失败"), //获取验证码失败[原有提示信息]获取验证码异常失败！

	ALAD_QUERY_FRIEND_LIST_USERID_MAC_EMPTY_FAIL("12010035","数据请求失败"), //系统异常！[原有提示信息] 获取好友列表userID、mac为空！
	
	ALAD_BINDING_QUERY_SUCCESS("12010036","查询绑定用户成功"), //绑定成功！[原有提示信息] 

	ALAD_BINDING_QUERY_EXCEPTION_FAIL("12010037","查询绑定用户失败"), //绑定成功！[原有提示信息] 
	
	//APP接口-设备相关接口 模块代码 “03”   

	ALAD_INSERT_BINDING_USERID_MAC_NET_TIMESTAMP_EMPTY_FAIL("12030001","数据请求失败"), //请求参数值错误！[原有提示信息]

	ALAD_INSERT_BINDING_SUCCESS("12030002","绑定成功"), //设备绑定成功！[原有提示信息]
	
	ALAD_INSERT_BINDING_EXCEPTION_FAIL("12030003","绑定失败"), //设备绑定失败！[原有提示信息]
	
	ALAD_SWITCH_DEVICE_SUCCESS("12030004","切换成功"), //设备切换成功！[原有提示信息]

	ALAD_SWITCH_DEVICE_EXCEPTION_FAIL("12030005","切换失败"), //设备切换失败！[原有提示信息] 
	
	ALAD_RENAME_DEVICE_SUCCESS("12030006","保存成功"), //设备重命名成功！[原有提示信息]

	ALAD_RENAME_DEVICE_EXCEPTION_FAIL("12030007","保存失败"), //设备重命名失败！[原有提示信息] 

	ALAD_QUERY_DEVICE_LIST_EXCEPTION_FAIL("12030008","数据请求失败"), //获取用户下的设备列表失败！[原有提示信息] 

	ALAD_DELETE_BINDING_SUCCESS("12030009","解绑成功"), //解绑成功！[原有提示信息]
	
	ALAD_DELETE_BINDING_EXCEPTION_FAIL("12030010","绑定失败"), //解绑失败！[原有提示信息]
	
	ALAD_SAVE_LEAVING_MSG_SUCCESS("12030011","发送成功"), //留言成功
	
	ALAD_SAVE_LEAVING_MSG_TEXT_IS_NULL_FAIL("12030012","请输入代言内容"), //请输入代言内容

	ALAD_SAVE_LEAVING_MSG_DEVICE_NOT_ONLINE_FAIL("12030013","小闹闹离线了"), //小闹闹离线了

	ALAD_SAVE_LEAVING_MSG_FAIL("12030014","发送失败"), //留言失败
	
	

	//APP接口-升级相关接口 模块代码 “04”   

	ALAD_GET_UPGRADE_APPINFO_EXCEPTION_FAIL("12040001","系统异常"), //系统异常！[原有提示信息]
	
	ALAD_GET_TERMINALINFO_DEVICE_NOT_ONLINE_FAIL("12040002","小闹闹离线了"), //设备不存在[原有提示信息]请先为设备联网吧！

	ALAD_GET_TERMINALINFO_EXCEPTION_FAIL("12040003","获取终端版本信息失败"), //系统异常[原有提示信息]

	ALAD_TRIGGER_UPGRADE_DEVICE_NOT_ONLINE_FAIL("12040004","小闹闹离线了"), //设备不存在[原有提示信息] 请先为设备联网吧！

	ALAD_TRIGGER_UPGRADE_USERID_MAC_EMPTY_FAIL("12040005","数据请求失败"), //参数错误[原有提示信息]             提示：获取技能接口失败！

	ALAD_TRIGGER_UPGRADE_EXCEPTION_FAIL("12040006","终端升级失败"), //系统异常[原有提示信息] 
	
	ALAD_DEVICE_NOT_EXIST_FAIL("12040007", "设备未报备"), // 设备未报备
	
	//终端接口-推送消息相关接口 模块代码 “05”   
	
	ALAD_USER_NOT_BIND_DEVICE_EXCEPTION("12050001","用户未绑定此设备"), //用户未绑定此设备！[原有提示信息]                       

	ALAD_SET_FREETIME_SUCCESS("12050002","设置成功"), //无！[原有提示信息]

	ALAD_SET_FREETIME_EXCEPTION_FAIL("12050003","设置失败"), //免打扰时间设置失败！[原有提示信息]

	ALAD_SET_FREETIME_PARAMTER_FORMAT_ERROR("12050004","设置失败"), // 免打扰时间格式错误
	
	ALAD_SET_SNAIL_SLEEP_EXCEPTION("12050005", "设置失败"),
	
	ALAD_SET_SNAIL_SLEEP_SUCCESS("12050006", "设置成功"),
	
	ALAD_SET_SNAIL_SLEEP_PARAMTER_FORMAT_ERROR("12050007", "设置失败"),

	//APP接口-图片识别接口 模块代码 “10”
	ALAD_IMAGE_IDENTY_FAIL("12100001","图片无法正常识别"),//验证码已经过期,请重新获取！[原有提示信息]
	ALAD_IMAGE_TYPE_FAIL("12100002","图片识别失败"),//验证码已经过期,请重新获取！[原有提示信息]获取识别图片类型失败

	
	//缺少请求参数
	ALAD_REQUEST_EXCEPTION_FAIL("12060001", "缺少请求参数"), // 缺少请求参数
	
	ALAD_QUERY_NO_TERMINAL_VERSION("12060002", "没有最新版本信息") ,

	ALAD_DEVICE_IN_FREE_TIME("12060003", "当前小闹闹处于免打扰模式") ,

	ALAD_DEVICE_IN_DELAY_FREE_TIME("12060004", "所选时间小闹闹处于免打扰模式") ,

	/**朗文错误提示**/

	EN_SIGN_ERROR("13010110", "签名校验失败!"),

	EN_PLAN_CREATE_PARAM_ERROR("13010001", "数据不完整，不能创建学习计划!"),

	EN_PLAN_CREATE_ERROR("13010002", "创建学习计划出现异常!"),

	EN_PLAN_CREATE_TIME_REPEATED("13010003", "改学习计划时间与其他学习计划时间出现冲突，请调整一下时间!"),

	EN_PLAN_QUERY_ERROR("13010004", "获取学习计划出现异常!"),

	EN_PLAN_PLAY_ERROR("13010005", "播放学习计划出现异常!"),

	EN_PLAN_DELETE_ERROR("13010006", "删除学习计划出现异常!"),

	EN_PLAN_UPDATE_PARAM_ERROR("13010007", "数据不完整，不能更改学习计划!"),

	EN_PLAN_UPDATE_ERROR("13010008", "更改学习计划出现异常!"),

	EN_PLAN_ADD_PARAM_ERROR("13010009", "数据不完整，不能增加学习章节!"),

	EN_PLAN_ADD_ERROR("13010010", "增加学习章节出现异常!"),

	EN_PLAN_TASKS_ERROR("13010011", "获取未完成作业出现异常!"),
	
	
	EN_PLAY_NO_DATA_NULL_ERROR("13010030", "无此教材!"),

	EN_NO_DATA_NULL_ERROR("13010031", "暂无数据"),
	
	
	//yemingxin
	EN_PLAY_PRAMA_NULL_ERROR("13010040", "朗文参数为空异常!"),
	EN_PLAY_PRAMA_FORMART_ERROR("13010041", "朗文参数格式出现异常!"),
	
	//档发创建 
	EN_ARCHIVES_CREAT_EXICT_ERROR("13010042", "档案已存在,创建失败!"),
	EN_BUY_ERROR("13010043", "你还没有开学习权限，请上手机app上购买相关服务"),


	/**微信公众号作业-zhoufangduo**/
	HOMEWORK_PARAM_ERROR("13010101", "参数不完整!"),
	HOMEWORK_CHAPTER_EMPTY("13010102", "章节的内容id不能为空!"),
	HOMEWORK_CREATE_SUCCESS("13010103", "作业发布成功!"),
	HOMEWORK_CREATE_FAIL("13010104", "发布作业失败!"),
	HOMEWORK_GET_FAIL("13010105", "获取作业内容失败!"),
	HOMEWORK_ADD_SUCCESS("13010105", "添加作业成功，请到阿拉的夜晚APP上学习吧!"),
	HOMEWORK_ADD_FAIL("13010106", "添加作业失败!"),
	HOMEWORK_DETAILS_FAIL("13010107", "获取作业详情失败!"),
	HOMEWORK_IMAGES_EMPTY("13010108", "图片不能为空！"),
	HOMEWORK_IMAGES_UPLOAD_FAIL("13010109", "上传图片失败!"),
	HOMEWORK_ADD_REPEAT("13010111", "该作业已添加，请勿重复添加!"),
	NOT_BUY_THIS_BOOK("13010112", "同步失败，原因是你当前登录账号绑定设备尚未开通该教材!"),
	NOT_BIND_SN("13010113", "同步失败，原因是你当前登录的账号没有绑定小闹闹!"),

	/**商品**/
	GOODS_PAGE_LIST_FAIL("13010115", "获取商品列表失败!"),

	GOODS_VIEW_FAIL("13010116", "获取商品详情失败!"),

	GOODS_PARAM_SN("13010117", "参数SN不能为空!"),

	ORDER_NOT_EXISTS("13010118", "该订单已过期，请重新下单!"),

	ORDER_PAY_FAIL("13010119", "微信下单失败!"),

	OPEN_ID_IS_EMPTY("13010120", "微信open_id不能为空!"),

	GOODS_PARAM_ID("13010121", "商品Id不能为空!"),

	/** 订单 */
	SHOPPING_CAR_SAME_BOOK("13020001", "购物车已存在相同的教材"),
	
	ORDER_IS_NULL_ERROR("13020003", "请添加商品进行结算"),
	 
	EN_USER_IS_NULL_ERROR("13020002", "用户为空"),
	
	GOODS_IS_INVALID("13020004", "加入购物车失败，该商品已下架"),
	
	EN_CAR_IS_HAVE_BOOK("13020005", "购物车存在已开通的教材，请勿重复购买"),

	EN_MEDAL_IS_SHARE("13020006", "已分享"),

	EN_INFO_IS_NOT_EXISTS("13020007", "无此信息")
	;

	private ErrorNumberMsg(String code, String msg){
		this.msg = msg ;
		this.code = code ;
	}
	
	private String msg ;
	private String code ;
	public String getMsg() {
		return msg;
	}
	public String getCode() {
		return code;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
