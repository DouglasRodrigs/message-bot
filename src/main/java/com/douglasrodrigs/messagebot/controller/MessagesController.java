package com.douglasrodrigs.messagebot.controller;

import com.douglasrodrigs.messagebot.model.Messages;
import com.douglasrodrigs.messagebot.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/messages"})
public class MessagesController {
    @Autowired
    private MessagesRepository repository;

    @GetMapping(path = {"/{conversationId}"})
    public List findAll(@PathVariable long conversationId){
        return repository.findByConversationId(conversationId);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)
                .map(response -> ResponseEntity.ok().body(response))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Messages create(@RequestBody Messages messages){
        return repository.save(messages);
    }
}
