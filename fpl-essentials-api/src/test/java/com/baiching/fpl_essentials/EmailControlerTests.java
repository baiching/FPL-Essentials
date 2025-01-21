package com.baiching.fpl_essentials;

import com.baiching.fpl_essentials.model.EmailDetails;
import com.baiching.fpl_essentials.service.EmailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailControlerTests {

    @Test
    @BeforeEach
    @GetMapping("/sendMail")
    public void sendMail() {
        EmailServiceImpl emailService = new EmailServiceImpl();
        EmailDetails details = new EmailDetails();
        details.setRecipient("{baichingc@gmail.com}");
        details.setSubject("This is a test");
        details.setMsgBody("did you get iy");
        //assertTrue(emailService.sendSimpleEmail(details));
    }
}
