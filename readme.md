# Spring Boot Multi-module Application

Hands on multi-module application development with Spring Boot 3.x and Spring Cloud with Java 17.

## Modules

* Clients (OpenFeign to link services)
* Eureka Server
* Customer Service
* Fraud Service
* Notification Service
* Api Gateway
* RabbitMQ

## Dependencies

- Spring Cloud starter  netflix-eureka-server
- Spring Cloud starter  netflix-eureka-client
- Spring Cloud starter OpenFeign
- Spring Cloud Starter Gateway
- Spring Boot Starter Web
- Lombok
- Spring Starter Data JPA
- Spring Boot Starter Test
- PostgreSQL
- Micrometer Observation
- Micrometer Tracing Bridge Brave
- Zipkin Reporter Brave
- Spring Boot Actuator
- Feign Micrometer
- Spring Boot Starter AMQP
- JIB

# Docker Compose with services as containers

- Postgres
- PgAdmin
- Zipkin
- RabbitMQ

# Useful resources

- For configuring JIB [Dockerizing a Spring Boot Application](https://betulsahinn.medium.com/dockerizing-a-spring-boot-application-and-using-the-jib-maven-plugin-95c329866f34)
- For Spring Boot 3 [Micrometer + Zipkin instead of Sleuth + Zipkin](https://www.appsdeveloperblog.com/micrometer-and-zipkin-in-spring-boot/)
- Zipkin baseUrl [How to configure zipkin baseUrl in SpringBoot 3](https://stackoverflow.com/questions/75758772/how-to-configure-zipkin-baseurl-in-springboot-3)
- Piotr's TechBlog [Microservices with Spring Boot 3 and Spring Cloud](https://piotrminkowski.com/2023/03/13/microservices-with-spring-boot-3-and-spring-cloud/)

## Credit

🔥 Happy Coding!