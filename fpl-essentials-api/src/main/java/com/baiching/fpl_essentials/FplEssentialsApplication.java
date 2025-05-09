package com.baiching.fpl_essentials;

import com.baiching.fpl_essentials.model.EmailDetails;
import com.baiching.fpl_essentials.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class FplEssentialsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FplEssentialsApplication.class, args);
	}

}
