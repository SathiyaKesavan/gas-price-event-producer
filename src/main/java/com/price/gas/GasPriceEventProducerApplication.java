package com.price.gas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GasPriceEventProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasPriceEventProducerApplication.class, args);
	}

}
