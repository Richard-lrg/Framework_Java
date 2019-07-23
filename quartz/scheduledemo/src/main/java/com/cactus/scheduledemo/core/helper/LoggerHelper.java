package com.cactus.scheduledemo.core.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liruigao on 2019-06-11.
 *
 * 日志工具
 */
public class LoggerHelper {
    /**
     * info
     * @param currentClass
     * @param message      写入的日志消息
     */
    public static void info(Class<?> currentClass, String message, Object... args) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.info(message, args);
    }

    /**
     * info
     * @param currentClass
     * @param message      写入的日志消息
     * @param t            记录抛出的异常信息。
     */
    public static void info(Class<?> currentClass, String message, Throwable t) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.info(message, t);
    }

    /**
     * info
     * @param currentClass
     * @param message
     * @param t
     * @param args
     */
    public static void info(Class<?> currentClass, String message, Throwable t, Object... args) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.info(message, t);
        log.info(message, args);
    }

    /**
     * debug
     * @param currentClass
     * @param message      写入的日志消息
     */
    public static void debug(Class<?> currentClass, String message, Object... args) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.debug(message, args);
    }

    /**
     * debug
     * @param currentClass
     * @param message      写入的日志消息
     * @param t            记录抛出的异常信息。
     */
    public static void debug(Class<?> currentClass, String message, Throwable t) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.debug(message, t);
    }

    /**
     * debug
     * @param currentClass
     * @param message
     * @param t
     * @param args
     */
    public static void debug(Class<?> currentClass, String message, Throwable t, Object... args) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.debug(message, t);
        log.debug(message, args);
    }

    /**
     * warn
     * @param currentClass
     * @param message      写入的日志消息
     */
    public static void warn(Class<?> currentClass, String message, Object... args) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.warn(message, args);
    }

    /**
     * warn
     * @param currentClass
     * @param message      写入的日志消息
     * @param t            记录抛出的异常信息。
     */
    public static void warn(Class<?> currentClass, String message, Throwable t) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.warn(message, t);
    }

    /**
     * warn
     * @param currentClass
     * @param message
     * @param t
     * @param args
     */
    public static void warn(Class<?> currentClass, String message, Throwable t, Object... args) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.warn(message, t);
        log.warn(message, args);
    }

    /**
     * error
     * @param currentClass
     * @param message      写入的日志消息
     */
    public static void err(Class<?> currentClass, String message, Object... args) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.error(message, args);
    }

    /**
     * error
     * @param message 写入的日志消息
     */
    public static void err(Class<?> currentClass, String message, Throwable t) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.error(message, t);
    }

    /**
     * err
     * @param currentClass
     * @param message
     * @param t
     * @param args
     */
    public static void err(Class<?> currentClass, String message, Throwable t, Object... args) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.error(message, args);
        log.error(message, t);
    }
}
