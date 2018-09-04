package com.springboot.base.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mr.PanYang on 2018/7/16.
 * <p>
 * 全局捕获异常
 * 1.  返回 json 格式
 * 2.  返回页面
 * <p>
 * 缺点：不通用，一般采用 aop 统一处理web请求日志
 */
@ControllerAdvice(basePackages = "com.springboot.base.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody   //返回json格式
    public Map<String, Object> errorResult() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("errorCode", "500");
        resultMap.put("errorMsg", "全局异常信息错误!");
        return resultMap;
    }

}
