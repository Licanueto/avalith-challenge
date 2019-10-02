package com.avalith.challenge.challenge.controller;

import com.avalith.challenge.challenge.Model.Mail;
import com.avalith.challenge.challenge.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/mail")
public class MailController {

    private final MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping
    public void addMail(@RequestBody Mail mail){
        this.mailService.addMail(mail);
    }

    @PostMapping("/addBulk")
    public void addBulk(@RequestBody List<Mail> mails){
        this.mailService.bulkImport(mails);
    }

    @GetMapping("/all")
    public List<Mail> getMails(){
        return this.mailService.getAll();
    }
    @GetMapping(path = "{id}")
    public Mail getMail(@PathVariable UUID id){
        return this.mailService.retrieveById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMail(@PathVariable UUID id){
        this.mailService.deleteMail(id);
    }
}
