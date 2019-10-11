package com.cactus.aopdemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liruigao
 * Date: 2019-10-11 15:01
 * Description: 拦截规则的注解
 * 1. @Target
 * 用于描述注解的使用范围
 * ElementType枚举类型，元注解中的枚举值决定了一个注解可以标记的范围
 *      TYPE ： 类型上面  用于描述类、接口(包括注解类型) 或enum声明
 *      FIELD ： 用于描述字段
 *      METHOD ：方法
 *      PARAMETER ： 参数 【参数名】
 *      CONSTRUCTOR ： 构造方法
 *      LOCAL_VARIABLE ： 局部变量
 *      ANNOTATION_TYPE ： 可以打在注解上面
 *      PACKAGE ：可以打在包上面
 *      TYPE_PARAMETER ： 参数类型【形式参数类型】
 *2. @Retention
 * 用于描述一个注解存在的生命周期【源码，字节码文件，运行时】
 * 枚举值RetentionPolicy：几个值决定了几个状态：
 * 		SOURCE ：表示一个注解可以存在于源码中==>java的源码中
 *      CLASS ：表示 一个注解可以在源码中，并且可以在字节码文件中
 *      RUNTIME ：表示 一个注解可以在源码、字节码、及运行时期该注解都会存在
 *
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
    String name();
}
