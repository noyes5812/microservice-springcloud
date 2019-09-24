package com.node3.cn.filter;

import com.node3.cn.util.JWTUtil;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CustomRolesAuthorizationFilter extends RolesAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) {

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String authorization = httpServletRequest.getHeader("Authorization");
        if(authorization == null){
            return false;
        }

        String roles= JWTUtil.getRolesByToken(authorization);
        //Subject subject = getSubject(req, resp);
        String[] rolesArray = (String[]) mappedValue;
        //如果没有角色限制，直接放行
        if (rolesArray == null || rolesArray.length == 0) {
            return true;
        }
        for (String aRolesArray : rolesArray) {
            //若当前用户是rolesArray中的任何一个，则有权限访问
            if (roles.contains(aRolesArray)) {
                return true;
            }
        }

        return false;
    }

}
