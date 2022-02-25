package com.ngconnect.service;

import javax.mail.internet.MimeMessage;
import javax.mail.Message.RecipientType;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.ngconnect.beans.MessageWithAttachment;

public class MailMessageServiceImpl implements MessageService {

	private JavaMailSender javaMailSender;
	private SimpleMailMessage simpleMailMessage;

	public MailMessageServiceImpl(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}
	
	

	@Override
	public void dispatch(MessageWithAttachment messageWithAttachment) {

		simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(messageWithAttachment.getFrom());
		simpleMailMessage.setTo(messageWithAttachment.getTo()[0]);
		simpleMailMessage.setText(messageWithAttachment.getContent());
		simpleMailMessage.setSubject(messageWithAttachment.getSubject());
		
		javaMailSender.send(simpleMailMessage);
		System.out.println("Change the order, the message has been successfully sent>>>");

		/*
		 * javaMailSender.send(new MimeMessagePreparator() {
		 * 
		 * @Override public void prepare(MimeMessage mimeMessage) throws Exception {
		 * mimeMessage.setFrom(messageWithAttachment.getFrom());
		 *//** TODO To be fixed as we are sending to a single email address *//*
																				 * mimeMessage.setRecipients(
																				 * RecipientType.TO,
																				 * messageWithAttachment.getTo()[0]);
																				 * mimeMessage.setText(
																				 * messageWithAttachment.getContent());
																				 * MimeMessageHelper mimeMessageHelper =
																				 * new
																				 * MimeMessageHelper(mimeMessage,true);
																				 * System.out.
																				 * println("The meessage has been sent successfully"
																				 * );
																				 * 
																				 * } });
																				 */
	}
}
