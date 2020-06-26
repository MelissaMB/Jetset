package com.sisvuelo.aplication.service.email;

import com.sisvuelo.aplication.configuration.EmailConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private EmailConfiguration emailConfiguration;

    public MailService(EmailConfiguration emailConfiguration){
        this.emailConfiguration=emailConfiguration;
    }

    public void sendMail(String from, String to, String subject, String body){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(this.emailConfiguration.getHost());
        mailSender.setPort(this.emailConfiguration.getPort());
        mailSender.setUsername(this.emailConfiguration.getUsername());
        mailSender.setPassword(this.emailConfiguration.getPassword());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);

        mailSender.send(mailMessage);
    }
}
