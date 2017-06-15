package com.example.demo.Interceptor;

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
        /*System.out.println("preHandle");
        HandlerMethod handlerMethod = (HandlerMethod)o;
        SelfPermission selfPermitition = handlerMethod.getMethodAnnotation(SelfPermission.class);

        if (selfPermitition != null) {
            MethodParameter[] parameters = handlerMethod.getMethodParameters();
            for (MethodParameter para : parameters){
                System.out.println(para.getMember());
            }
            String str = httpServletRequest.getParameter("token");
            System.out.println("str  "+ str);
            PermissionEnum[] permissionEnums = selfPermitition.value();
            for (PermissionEnum oo : permissionEnums){
                System.out.println(oo.name());
            }
        }
        else
            System.out.println("selePermission is null");*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
