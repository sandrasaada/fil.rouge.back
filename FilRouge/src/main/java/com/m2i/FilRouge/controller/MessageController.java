package com.m2i.FilRouge.controller;

import com.m2i.FilRouge.entity.Message;
import com.m2i.FilRouge.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
@CrossOrigin
public class MessageController {
    @Autowired
    private MessageService service;

    @GetMapping("")
    public List<Message> getAll(){
        return service.getAllMessages();
    }

    @GetMapping("/{id}")
    public Optional<Message> getById(@PathVariable Long id){
        return service.getMessageById(id);
    }

    @PostMapping("")
    public Message post(@RequestBody Message message){
        return service.addMessage(message);
    }

    @PutMapping("/edit/{id}")
    public Message update(@PathVariable Long id, @RequestBody Message message){
        message.setId(id);
        return service.updateMessage(message);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.deleteMessage(id);
    }
}
