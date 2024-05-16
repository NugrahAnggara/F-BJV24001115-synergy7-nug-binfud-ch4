package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bej1Synergy7NugrahAnggaraSiregarChallange4Application {

	public static void main(String[] args) {
		SpringApplication.run(Bej1Synergy7NugrahAnggaraSiregarChallange4Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
