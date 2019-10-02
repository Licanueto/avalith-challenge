package com.avalith.challenge.challenge.service;

import com.avalith.challenge.challenge.Model.Mail;
import com.avalith.challenge.challenge.Repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class MailService {

    private MailRepository mailRepository;

    @Autowired
    public MailService(@Qualifier("mailJpa") MailRepository mailRepository){
        this.mailRepository = mailRepository;
    }

    public void addMail(Mail m){
        // Dada la complejidad de la construcción podría usarse un builder
        Mail mail = new Mail(UUID.randomUUID(),
                                m.getFrom(),
                                m.getTo(),
                                m.getMessage(),
                                LocalDateTime.now());
        this.mailRepository.save(mail);
    }


    public void bulkImport(List<Mail> mails){
        mails.forEach(mail -> addMail(mail));
    }

    public List<Mail> getAll(){
        return this.mailRepository.findAll();
    }

    public Mail retrieveById(UUID id){
        return this.mailRepository.getOne(id);
    }

    public <M> void deleteMail(M mail){
        if(mail instanceof Mail)
            this.mailRepository.delete((Mail)mail);
        else if(mail instanceof UUID)
            this.mailRepository.deleteById((UUID)mail);
    }
}
