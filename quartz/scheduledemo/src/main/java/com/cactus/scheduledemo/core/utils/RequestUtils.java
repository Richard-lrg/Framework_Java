package com.cactus.scheduledemo.core.utils;

import com.alibaba.fastjson.JSON;
import com.cactus.scheduledemo.core.helper.LoggerHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.IOUtils;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * request请求工具类
 * Created by liruigao on 2019-06-11.
 */
public class RequestUtils {
    /**
     * 根据请求Request取得服务器的主机名称
     * @param request
     * @return
     */
    public static final String getServerName(final HttpServletRequest request) {
        String serverName = request.getServerName();
        if ("127.0.0.1".equals(serverName) || "localhost".equals(serverName)) {
            try {
                InetAddress address = InetAddress.getLocalHost();
                serverName = address.getHostAddress();
            } catch (UnknownHostException e) {
                LoggerHelper.err(RequestUtils.class, "", e);
                return serverName;
            }
        }
        return serverName;
    }

    /**
     * 取得WEB客户端IP地址
     * @param request
     * @return
     */
    public static String getClientIP(final HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 根据请求Request构建URL
     * @param request
     * @param servletPath
     * @return
     */
    public static final String getAbsoluteUrl(final HttpServletRequest request, String servletPath) {
        String serverName = getServerName(request);
        String path = request.getContextPath() + servletPath;
        StringBuffer urlBuff = new StringBuffer(request.getScheme());
        urlBuff.append("://");
        String port = request.getServerPort() == 80 ? "" : ":" + String.valueOf(request.getServerPort());
        urlBuff.append(serverName).append(port).append(path);
        return urlBuff.toString();
    }

    /**
     * 请求参数转换成Map
     * @param request
     * @return
     */
    public static Map<String, Object> convertRequestToMap(final HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        Map<String, Object> map = null;
        if (request.getMethod().equalsIgnoreCase("POST")) {
            map = convertRequestToMapOfPost(request);
            // 有时提交方式为POST，但是参数却在request parameters 中
            // 需要特殊处理，已post参数为主
            if (map == null) {
                map = new HashMap<String, Object>();
            }
            Enumeration<String> paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                if (!map.containsKey(paramName)) {
                    // GET参数不覆盖POST参数
                    map.put(paramName, request.getParameter(paramName));
                }
            }
        } else {
            map = convertRequestToMapOfGet(request);
        }
        return map;
    }

    private static Map<String, Object> convertRequestToMapOfPost(final HttpServletRequest request) {
        Map<String, Object> map = null;
        try {
            String paramsString = IOUtils.toString(request.getInputStream(), "UTF-8");
            try {
                if (StringUtils.isNotBlank(paramsString)) {
                    map = JSON.parseObject(paramsString, HashMap.class);
                }
            } catch (Exception e) {
                LoggerHelper.err(RequestUtils.class, e.getMessage(), e);
            }
        } catch (IOException e) {
            LoggerHelper.err(RequestUtils.class, e.getMessage(), e);
        }
        return map;
    }

    private static Map<String, Object> convertRequestToMapOfGet(final HttpServletRequest request) {
        Enumeration<String> paramNames = request.getParameterNames();
        Map<String, Object> map = new HashMap<String, Object>();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            map.put(paramName, request.getParameter(paramName));
        }
        return map;
    }
}
