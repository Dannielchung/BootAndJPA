package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cvter on 2017/6/2.
 */
public class PermissionInterceptor {
    @Autowired
    private PermissionManagerService permissionManagerService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取用户信息
        UserResultDto user = (UserResultDto) httpServletRequest.getAttribute(Constants.CURRENT_USER);
        if(user == null)
            return false;
        String uid = user.getUid();              //用户UID

        //获取拦截方法信息
        HandlerMethod handlerMethod = (HandlerMethod) o;
        RequiredPermission requiredPermission =
                handlerMethod.getMethodAnnotation(RequiredPermission.class);
        if (requiredPermission == null)
            return true;

        //获取请求方法r_code
        Permission[] rCode = requiredPermission.permission();
        //只要有其中一个权限即可访问
        if (rCode == null || rCode.length == 0)
            return true;
        String[] code = new String[rCode.length];
        for (int i = 0; i < rCode.length; i++) {
            code[i] = rCode[i].toString();
        }
        if (permissionManagerService.hasPermission(uid, code)) {
            LOGGER.info("通过权限验证");
            return true;
        } else {
            //返回无调用权限说明
            LOGGER.info("无权限执行方法");
            String json = JsonUtils.objectToJson(CommonResult.build(StatusCode.RESOURCE_NOT_FOUND.getStatusCode(),
                    "无权限进行操作"));
            httpServletResponse.getOutputStream().write(json.getBytes("UTF-8"));
            httpServletResponse.setContentType("text/json; charset=UTF-8");
            return false;
        }
    }


}
}
