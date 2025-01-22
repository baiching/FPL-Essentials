package com.baiching.fpl_essentials.service.impl;

import com.baiching.fpl_essentials.model.EmailDetails;
import com.baiching.fpl_essentials.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Environment env;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendSimpleEmail(EmailDetails emailDetails) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try{
            //SimpleMailMessage mailMessage = new SimpleMailMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom("bachmarma@gmail.com");
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setText(emailDetails.getMsgBody());
            mimeMessageHelper.setSubject(emailDetails.getSubject());

            mailSender.send(mimeMessageHelper.getMimeMessage());

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
