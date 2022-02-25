package com.ngconnect.autoconfiguration;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.ngconnect.service.MailMessageServiceImpl;
import com.ngconnect.service.MessageService;

@Configuration
@ConditionalOnProperty(prefix = "spring.mail", name = "host")
@AutoConfigureAfter(JavaMailSender.class)
public class JavaMailSenderConfiguration {
	
	public JavaMailSenderConfiguration() {
		System.out.println("JavaMailSenderConfiguration()");
	}
	
	

	@Bean
	public MessageService messageService(JavaMailSender javaMailSender) {
		MailMessageServiceImpl messageService = null;
		messageService =  new MailMessageServiceImpl(javaMailSender);
		//messageService.setSimpleMailMessage(simpleMailMessage);
		return messageService;
	}
}
