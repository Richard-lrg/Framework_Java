package com.cactus.scheduledemo.core.controller;

import com.cactus.scheduledemo.core.helper.LoggerHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Created by liruigao on 2019-06-11.
 */
public class BaseController {

    protected static final int DEFAULT_INTEGER = -1;
    protected static final long DEFAULT_LONG = -1L;
    protected static final double DEFAULT_DOUBLE = 0.0D;

    public String getString(final Map<String, Object> paramMap, String paramName) {
        if (paramMap.get(paramName) != null) {
            return paramMap.get(paramName).toString();
        } else {
            return null;
        }
    }

    public Long getLong(final Map<String, Object> paramMap, String paramName) {
        String value = getString(paramMap, paramName);
        try {
            if (StringUtils.isNotBlank(value)) {
                if (StringUtils.isNumeric(value)) {
                    return Long.valueOf(value.trim());
                } else {
                    LoggerHelper.err(getClass(), "getLong from param error value is not null and not long value:{}",
                            value);
                    return DEFAULT_LONG;
                }
            }
        } catch (Exception e) {
            LoggerHelper.err(getClass(), "getLong error!" + value);
        }
        return null;
    }

    public Double getDouble(final Map<String, Object> paramMap, String paramName) {
        String value = getString(paramMap, paramName);
        try {
            if (StringUtils.isNotBlank(value)) {
                if (StringUtils.isNumeric(value)) {
                    return Double.valueOf(value.trim());
                } else {
                    LoggerHelper.err(getClass(), "getLong from param error value is not null and not long value:{}",
                            value);
                    return DEFAULT_DOUBLE;
                }
            }
        } catch (Exception e) {
            LoggerHelper.err(getClass(), "getDouble error!" + value);
        }
        return null;
    }

    public Integer getInteger(final Map<String, Object> paramMap, String paramName) {
        String value = getString(paramMap, paramName);
        try {
            if (StringUtils.isNotBlank(value)) {
                if (StringUtils.isNumeric(value)) {
                    return Integer.valueOf(value.trim());
                } else {
                    LoggerHelper.err(getClass(),
                            "getInteger from param error value is not null and not Integer value:{}", value);
                    return DEFAULT_INTEGER;
                }
            }
        } catch (Exception e) {
            LoggerHelper.err(getClass(), "getInteger error!" + value);
        }
        return null;
    }

    public Boolean getBoolean(final Map<String, Object> paramMap, String paramName) {
        String value = getString(paramMap, paramName);
        if (StringUtils.isNotBlank(value)) {
            return Boolean.parseBoolean(value);
        }
        return null;
    }
}
