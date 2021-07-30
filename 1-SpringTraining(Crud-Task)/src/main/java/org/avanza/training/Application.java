package org.avanza.training;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories("org.avanza.training.data.*")
@ComponentScan(basePackages = {"org.avanza.training.*"})
@EntityScan("org.avanza.training.data.*")

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
