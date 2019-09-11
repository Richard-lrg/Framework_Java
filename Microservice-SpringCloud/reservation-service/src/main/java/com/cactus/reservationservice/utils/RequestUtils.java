package com.cactus.reservationservice.utils;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liruigao
 * Date: 2019-09-11 14:53
 * Description:
 */


public class RequestUtils {

    public static Map<String, Object> convertRequest2Map(final HttpServletRequest request) {
        if (null == request) {
            return null;
        }
        Map<String, Object> result = null;
        if (request.getMethod().equalsIgnoreCase("post")) {
            result = convertPostRequest2Map(request);
            // 特殊情况：提交方式为POST，但参数却在request parameters中，需要特殊处理
            if (null == result) {
                result = convertGetRequest2Map(request);
            }
        } else {
            result = convertGetRequest2Map(request);
        }
        return result;
    }

    private static Map<String, Object> convertPostRequest2Map(final HttpServletRequest request) {
        Map<String, Object> result = null;
        try {
            String requestStr = IOUtils.toString(request.getInputStream(), "UTF-8");
            if (StringUtils.isNotBlank(requestStr)) {
                result = JSON.parseObject(requestStr, HashMap.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static Map<String, Object> convertGetRequest2Map(final HttpServletRequest request) {
        Map<String, Object> result = null;
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String parameter = request.getParameter(name);
            result.put(name, parameter);
        }
        return result;
    }
}
