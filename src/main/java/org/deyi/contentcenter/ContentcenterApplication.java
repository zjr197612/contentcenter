package org.deyi.contentcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication //默认扫描启动类所有包以及所有子包里的所有类
@MapperScan("org.deyi")
@EnableDiscoveryClient
public class ContentcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentcenterApplication.class, args);
    }

    //将这个方法返回的对象添加到Spring容器中,id:方法名
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
