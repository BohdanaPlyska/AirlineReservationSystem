package com.example.demo.emailsender;

import lombok.RequiredArgsConstructor;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;


@Service
@RequiredArgsConstructor
public class EmailService{

   private final JavaMailSender emailSender;

   public void sendMessage1(String to, String subject, String message) {

      SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
      simpleMailMessage.setFrom("bohdana.plyska@gmail.com");
      simpleMailMessage.setTo(to);
      simpleMailMessage.setSubject(subject);
      simpleMailMessage.setText(message);

      JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
      mailSender.setHost("smtp.gmail.com");
      mailSender.setPort(465);

      mailSender.setUsername("bohdana.plyska@gmail.com");
      mailSender.setPassword("giokdjqrkvpjwpup");

      Properties props = mailSender.getJavaMailProperties();
      props.put("mail.transport.protocol", "smtp");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.debug", "true");
      props.put("mail.smtp.ssl.protocols", "TLSv1.2");
      props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      props.put("mail.smtp.socketFactory.port", 465);
      props.put("mail.properties.mail.smtp.socketFactory.fallback", "true");
      props.put("mail.properties.mail.smtp.ssl", "true");

      mailSender.send(simpleMailMessage);
   }

    public void sendMessage( String to, String subject, String message) {

       SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
       simpleMailMessage.setFrom("bohdana.plyska@gmail.com");
       simpleMailMessage.setTo(to);
       simpleMailMessage.setSubject(subject);
       simpleMailMessage.setText(message);

       this.emailSender.send(simpleMailMessage);
   }

}