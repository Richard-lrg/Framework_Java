package com.cactus.demo.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by liruigao
 * Date: 2019-10-11 20:37
 * Description:
 * 声明为Bean
 * Scope默认为singleton，一个Spring容器中只会存在一个实例
 */

@Service
//@Scope("singleton")
public class BeanOne {
}
