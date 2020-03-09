package com.nap.up;

import com.nap.up.config.BeanNameUnique;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @creator napuping
 * @createTime 2020/3/2
 * @description
 */
//@EnableAsync
@EnableSwagger2
//@EnableHystrix
//@EnableDiscoveryClient
//@EnableFeignClients
//@EnableScheduling
//@EnableTransactionManagement
@SpringBootApplication
@MapperScan(value = "com.nap.up.**.mapper", nameGenerator = BeanNameUnique.class)
@ComponentScan(nameGenerator = BeanNameUnique.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
