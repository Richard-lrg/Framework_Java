package com.cactus.reservationservice;

import com.cactus.reservationservice.dao.IUserDAO;
import com.cactus.reservationservice.domin.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

/**
 * 数据服务端，包括功能：
 * 1.数据crud
 * 2.动态获取配置文件
 * 3.服务注册与发现
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}

	// 服务启动即运行
	@Bean
	ApplicationRunner sampleData(IUserDAO iUserDAO) {
		return applicationArguments -> {
			Stream.of("lrg","pqt","wr","dt","qjy")
					.forEach(name -> iUserDAO.save(new User(name, "this is a user")));
			iUserDAO.findAll().forEach(System.out::println);
		};
	}
}


