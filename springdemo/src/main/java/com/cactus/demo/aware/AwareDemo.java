package com.cactus.demo.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by liruigao
 * Date: 2019-12-05 14:35
 * Description:
 */

@Service
public class AwareDemo implements BeanNameAware, ResourceLoaderAware {
    private String beanName;
    private ResourceLoader resourceLoader;
    public void setBeanName(String s) {
        this.beanName = s;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void show() {
        System.out.println("beanName : " + beanName);
        Resource resource = resourceLoader.getResource("classpath:awaredemo/awaredemo.txt");
        String desc = resource.getDescription();
        System.out.println("resource desc : " + desc);
        try {
            String streamStr = IOUtils.toString(resource.getInputStream(), "utf-8");
            System.out.println("resource streamStr : " + streamStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
