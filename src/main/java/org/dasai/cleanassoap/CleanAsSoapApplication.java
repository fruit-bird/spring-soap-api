package org.dasai.cleanassoap;

import jakarta.xml.ws.Endpoint;
import org.dasai.cleanassoap.entities.Product;
import org.dasai.cleanassoap.repositories.ProductRepository;
import org.dasai.cleanassoap.services.ProductWebService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CleanAsSoapApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CleanAsSoapApplication.class, args);

        String url = "http://localhost:8080/";

        ProductWebService productWebService = context.getBean(ProductWebService.class);
        Endpoint.publish(url, productWebService);

        System.out.println("Service running at " + url);
    }

    @Bean
    public CommandLineRunner run(ProductRepository productRepository) {
        return (args) -> {
            productRepository.save(new Product(null, "Product 1", 100.0, new Date()));
            productRepository.save(new Product(null, "Product 2", 200.0, new Date()));
            productRepository.save(new Product(null, "Product 3", 300.0, new Date()));
        };
    }
}
