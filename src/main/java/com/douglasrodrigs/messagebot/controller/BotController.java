package com.douglasrodrigs.messagebot.controller;

import com.douglasrodrigs.messagebot.model.Bot;
import com.douglasrodrigs.messagebot.repository.BotRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/bots"})
public class BotController {

    private BotRepository repository;

    BotController(BotRepository botRepository) { this.repository = botRepository; };

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)
                .map(response -> ResponseEntity.ok().body(response))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Bot create(@RequestBody Bot bot){
        return repository.save(bot);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity updateBot(@PathVariable("id") long id,
                                 @RequestBody Bot bot) {
        return repository.findById(id)
                .map(response -> {
                    response.setName(bot.getName());
                    Bot botUpdated = repository.save(response);
                    return ResponseEntity.ok().body(botUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(response -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
