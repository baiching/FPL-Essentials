package com.baiching.fpl_essentials.service;

import com.baiching.fpl_essentials.model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender mailSender;

    private Environment env;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendSimpleEmail(EmailDetails emailDetails) {

        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(env.getProperty("spring.mail.username"));
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setText(emailDetails.getMsgBody());
            mailMessage.setSubject(emailDetails.getSubject());

            mailSender.send(mailMessage);

            return "Mail sent successfully";
        }
        catch (Exception e) {
            return "Failed to sent the mail";
        }
    }

    @Override
    public String sendEmailWithAttachments(EmailDetails emailDetails) {
        return "";
    }
}
