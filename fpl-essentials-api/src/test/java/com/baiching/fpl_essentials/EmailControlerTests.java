package com.baiching.fpl_essentials;

import com.baiching.fpl_essentials.model.EmailDetails;
import com.baiching.fpl_essentials.service.EmailService;
import com.baiching.fpl_essentials.service.EmailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class EmailControlerTests {
    @Autowired
    EmailService mailService;
    @Test
    @BeforeEach
    @GetMapping("/sendMail")
    public void sendMail() {
        EmailServiceImpl emailService = new EmailServiceImpl();
        EmailDetails details = new EmailDetails();
        details.setRecipient("{baichingc@gmail.com}");
        details.setSubject("This is a test");
        details.setMsgBody("did you get iy");
        emailService.sendSimpleEmail(details);
    }
}
