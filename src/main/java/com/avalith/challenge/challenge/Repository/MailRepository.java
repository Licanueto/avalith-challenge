package com.avalith.challenge.challenge.Repository;

import com.avalith.challenge.challenge.Model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("mailJpa")
public interface MailRepository extends JpaRepository<Mail, UUID> {
}
