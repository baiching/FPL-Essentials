package com.baiching.fpl_essentials.service;

import com.baiching.fpl_essentials.model.EmailDetails;

public interface EmailService {
    String sendSimpleEmail(EmailDetails emailDetails);

    String sendEmailWithAttachments(EmailDetails emailDetails);
}
