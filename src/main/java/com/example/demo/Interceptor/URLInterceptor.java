package com.example.demo.Interceptor;

import com.example.demo.annotation.PermissionEnum;
import com.example.demo.annotation.SelfPermission;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tianxianglan on 2017/6/2.
 */

public class URLInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)o;
        SelfPermission selfPermitition = handlerMethod.getMethodAnnotation(SelfPermission.class);
        String token = httpServletRequest.getParameter("token");
        if (selfPermitition != null) {
            PermissionEnum[] permissionEnums = selfPermitition.value();
            for (PermissionEnum permission : permissionEnums){
                /*
                * 获取用户的权限值，与permission进行比对，只要有一个符合即可返回true
                * */
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
