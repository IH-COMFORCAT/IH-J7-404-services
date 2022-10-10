package com.ironhack.Controllers;

import com.ironhack.Controllers.entity.*;
import com.ironhack.Controllers.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.*;
import java.util.*;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		productRepository.saveAll(List.of(
			new Product("Super Smash Bros", new BigDecimal(49.99), 100l, Category.DIGITAL, Genre.SPORTS),
			new Product("Call of Duty", new BigDecimal(59.99), 100l, Category.PHYSICAL, Genre.SHOOTER),
			new Product("Fifa 23", new BigDecimal(79.99), 100l, Category.DIGITAL, Genre.SPORTS),
			new Product("Final Fantasy", new BigDecimal(49.99), 100l, Category.DIGITAL, Genre.OPEN_WORLD),
			new Product("StarCraft", new BigDecimal(25.99), 100l, Category.PHYSICAL, Genre.SHOOTER),
			new Product("Sims", new BigDecimal(39.99), 100l, Category.DIGITAL, Genre.OPEN_WORLD),
			new Product("League of Legends", new BigDecimal(49.99), 100l, Category.DIGITAL, Genre.MOBA)
		));


	}
}
