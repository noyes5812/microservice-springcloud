package com.node3.cn.web;
import com.node3.cn.util.DateUtil;
import com.node3.cn.util.StringTools;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * <b>Title：</b>BaseController.java<br/>
 * <b>Description：</b> Controller继承类，封装一些公用的调用方法<br/>
 * <b>Copyright (c) 2019 ASPire Tech.</b>
 *
 */
public class BaseController {
    protected static final String UTF8 = "UTF-8";

    /**
     * 返回操作成功Map
     * @param data
     * @return
     */
    protected <T> Map<String, Object> success(T data) {
        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("data", data);
        modelMap.put("success", true);
        return modelMap;
    }

    /**
     * 返回操作失败Map
     * @param message 错误信息
     * @return
     */
    protected Map<String, Object> fail(String message) {
        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("message", message);
        modelMap.put("success", false);
        return modelMap;
    }
    /**
     *
     * @param message 错误信息
     * @return
     * @throws IOException
     */
    protected void fail(HttpServletResponse response, String message) throws IOException {
        outputString(response, JSONObject.fromObject(fail(message)).toString());
    }
    /**
     *
     * @param message 错误信息
     * @return
     * @throws IOException
     */
    protected <T> void success(HttpServletResponse response,T message) throws IOException {
        outputString(response,JSONObject.fromObject(success(message)).toString());
    }
    protected void output(final HttpServletResponse response,
                          String contentType, String characterEncoding, String obj)
            throws IOException {
        disableCache(response);
        response.setContentType(contentType);
        response.setCharacterEncoding(characterEncoding);
        response.getWriter().write(obj);
        response.getWriter().flush();
        response.getWriter().close();
    }
    protected void disableCache(HttpServletResponse response) {
        response.setHeader("Pragma", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
    }
    protected void outputMatch(HttpServletRequest request, final HttpServletResponse response, String obj)
            throws IOException {
        String requested = request.getHeader("x-requested-with");
        if (StringTools.isEmptyString(requested)){
            requested = request.getHeader("X-Requested-With");
        }
        if (null != requested && requested.equalsIgnoreCase("XMLHttpRequest")){
            output(response, "application/json", UTF8, obj);
        }else{
            String rtnName = request.getParameter("rtnName");
            if (isNotEmpty(rtnName)){
                outputJS(request,response, "var " + rtnName + "=" +obj);
            }else{
                output(response, "text/html", UTF8, obj);
            }

        }
    }
    protected void outputString(final HttpServletResponse response, String obj)
            throws IOException {
        output(response, "text/html", UTF8, obj);
    }
    protected void outputJSON(HttpServletRequest request,
                              HttpServletResponse response, String msg) throws IOException {
        output(response, "application/json", UTF8, msg);
    }
    protected void outputJS(HttpServletRequest request,
                            HttpServletResponse response, String msg) throws IOException {
        output(response, "application/javascript", UTF8, msg);
    }
    /**
     * 返回操作失败Map
     * @param code 返回码
     * @param message 错误信息
     * @return
     */
    protected Map<String, Object> fail(String code,String message) {
        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("code", code);
        modelMap.put("message", message);
        modelMap.put("success", false);
        return modelMap;
    }
    /**
     * 获得HttpServletRequest
     *
     * @return
     * @see javax.servlet.http.HttpServletRequest
     */
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
    }
    /**
     * 获得HttpServletRequest
     *
     * @return
     * @see javax.servlet.http.HttpServletRequest
     */
    protected HttpSession getSession() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (sra != null) {
            return sra.getRequest().getSession();
        }
        return null;
    }

    /**
     * 判断字符串是否为NULL或空串
     *
     * @param value
     *            判断字符串
     * @return true or false
     */
    protected boolean isEmpty(String value) {
        return value == null || "".equals(value.trim());
    }

    protected boolean isEmpty(Long value) {
        return value == null;
    }

    /**
     * 判断字符串是否非空（非null和非""）
     *
     * @param value
     *            判断字符串
     * @return true or false
     */
    protected boolean isNotEmpty(String value) {
        return value != null && !"".equals(value.trim());
    }

    protected boolean isNotEmpty(Long value) {
        return value != null;
    }
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            /*@Override
            public void setAsText(String text) {
                setValue(text == null ? null : StringEscapeUtils
                        .escapeHtml4(text.trim()));
            }*/
            @Override
            public void setAsText(String text) {
                setValue(text == null ? null : text.trim());
            }
            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                if (isNotEmpty(text)){
                    if (text.length() == 10){
                        setValue(DateUtil.getDate(text,DateUtil.PATTEM_DATE));
                    }else if (text.length() == 19){
                        setValue(DateUtil.getDate(text,DateUtil.PATTEM_DATE_TIME));
                    }
                }
            }
        });
    }
    /**
     * 获得请求者IP地址
     *
     * @param request
     * @return
     */
    protected String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if(StringUtils.isNotBlank(ip)){
            String[] arr = ip.split(",");
            if(arr.length > 0){
                ip = arr[0];
            }
        }
        return ip;
    }

}
