package com.eclipseeio.emi;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication ss = new SpringApplication(Application.class);
		//ss.setBannerMode(Banner.Mode.OFF);
		ss.run(args);

	}
}


