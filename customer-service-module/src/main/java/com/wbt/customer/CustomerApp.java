package com.wbt.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = {"com.wbt.customer", "com.wbt.amqp"})
// This will help access RabbitMQ Producer defined in later package
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wbt.clients")
@PropertySources({@PropertySource("classpath:clients-${spring.profiles.active}.properties")})
public class CustomerApp {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApp.class, args);
    }
}
