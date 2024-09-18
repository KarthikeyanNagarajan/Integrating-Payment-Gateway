package com.karthik.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class PaymentIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentIntegrationApplication.class, args);
	}

}
