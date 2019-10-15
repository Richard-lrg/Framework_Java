package com.cactus.demo.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by liruigao
 * Date: 2019-10-11 20:37
 * Description:
 * 声明为Bean
 * Scope为prototype，此时每次调用都会新建一个实例
 */

@Service
@Scope("prototype")
public class BeanTwo {
}
