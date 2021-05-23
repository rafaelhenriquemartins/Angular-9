package io.github.rafael;

import io.github.rafael.modelEntity.Cliente;
import io.github.rafael.modelRepository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication{

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
