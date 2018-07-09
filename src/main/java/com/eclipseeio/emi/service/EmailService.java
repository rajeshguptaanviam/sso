package com.eclipseeio.emi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;
    private String MAIL_FROM = "testmailpersonalcmp@gmail.com";

    @Async
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("testmailpersonalcmp@gmail.com");
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }
    @Async
    public void sendHtmlMail(String to, String subject, String text) {
        try {
            MimeMessage mail = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            try {
                helper.setFrom(MAIL_FROM, "Admin");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            helper.setTo(to);
            mail.setFrom(MAIL_FROM);
            helper.setSubject(subject);
            helper.setText(text, true);
            emailSender.send(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
