package com.tenpo.challengeBackend;

import com.tenpo.challengeBackend.dao.PercentageCacheRepository;
import com.tenpo.challengeBackend.entity.Percentage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ChallengeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeBackendApplication.class, args);
	}

}
