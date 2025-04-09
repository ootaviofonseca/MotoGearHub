package com.example.MotoGearHub;

import com.example.MotoGearHub.main.Main;
import com.example.MotoGearHub.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MotoGearHubApplication implements CommandLineRunner {
	@Autowired
	private BrandRepository brandRepository;

	public static void main(String[] args) {
		SpringApplication.run(MotoGearHubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Main main = new Main(brandRepository);
		main.displayMenu();
	}

}
