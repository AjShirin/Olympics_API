package com.codeline.Olympics.Olympics_API.Mailing;

import org.springframework.stereotype.Repository;

@Repository
public interface MailingRepository {
    String sendSimpleMail(EmailDetails emailDetails);

}
