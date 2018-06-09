package com.reservation;

import java.util.Properties;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.reservation.service.impl.StorageService;

@SpringBootApplication
public class Reservation2Application implements CommandLineRunner {

	@PostConstruct
	  void started() {
	    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	  }
	
	@Resource
	StorageService storageService;
	public static void main(String[] args) {
		SpringApplication.run(Reservation2Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		storageService.deleteAll();
		storageService.init();		
	}
	
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.happyhours.tn");
	    mailSender.setPort(587);
	     
	    mailSender.setUsername("contact@happyhours.tn");
	    mailSender.setPassword("WaJvvsG8WaJvvsG8");
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");

	    
	     
	    return mailSender;
	}

	    
}
