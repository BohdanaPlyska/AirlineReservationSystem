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
      simpleMailMessage.setFrom("");
      simpleMailMessage.setTo(to);
      simpleMailMessage.setSubject(subject);
      simpleMailMessage.setText(message);

      JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
      mailSender.setHost("smtp.gmail.com");
      mailSender.setPort(25);

      mailSender.setUsername("");
      mailSender.setPassword("");

      Properties props = mailSender.getJavaMailProperties();
      props.put("mail.transport.protocol", "smtp");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.debug", "true");
      props.put("mail.smtp.ssl.protocols", "TLSv1.2");
      props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

      mailSender.send(simpleMailMessage);
   }

//   $EmailFrom = “bohdana.plyska@gmail.com”
//   $EmailTo = “bohdana.plyska@gmail.com”
//   $usr="bohdana.plyska@gmail.com"
//   $pass="giokdjqrkvpjwpup"
//   $Subject = “The subject of your email”
//   $Body = “What do you want your email to say”
//   $SMTPServer = “smtp.gmail.com”
//   $SMTPClient = New-Object Net.Mail.SmtpClient($SmtpServer, 587)
//   $SMTPClient.EnableSsl = $true
//   $SMTPClient.Credentials = New-Object System.Net.NetworkCredential(“usr”, “pass”)
//   $SMTPClient.Send($EmailFrom, $EmailTo, $Subject, $Body)

    public void sendMessage( String to, String subject, String message) {

       SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
       simpleMailMessage.setFrom("bohdana.plyska@gmail.com");
       simpleMailMessage.setTo(to);
       simpleMailMessage.setSubject(subject);
       simpleMailMessage.setText(message);

       this.emailSender.send(simpleMailMessage);
   }

}