package com.cactus.demo.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by liruigao
 * Date: 2019-10-11 20:56
 * Description:
 */

@Configuration
@ComponentScan("com.cactus.demo.el")
// 注意配置文件和文本文件要放到resources目录下，才可以获取到该文件
@PropertySource("classpath:eldemo/test.properties")
public class ELConfig {

    @Value("hi 647")
    private String normal;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    // bean名字若未命名，则默认首字母小写
    @Value("#{demo.another}")
    private String demoAnother;

    @Value("classpath:eldemo/test.txt")
    private Resource testFile;

    @Value("http://www.baidu.com")
    private Resource testUrl;

    @Value("${book.name}")
    private String bookName;

    // 配置文件的数据同样可以通过Environment获取
    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void output() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(demoAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            //通过environment获取配置文件数据
            System.out.println("env : " + environment.getProperty("book.author"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
