package com.m2i.FilRouge.controller;

import com.m2i.FilRouge.entity.Channel;
import com.m2i.FilRouge.entity.Message;
import com.m2i.FilRouge.entity.User;
import com.m2i.FilRouge.service.ChannelService;
import com.m2i.FilRouge.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/channels")
public class ChannelController {
    @Autowired
    private ChannelService service;
    @Autowired
    private MessageService mService;

    @GetMapping("")
    public List<Channel> getAll(){
        return service.getAllChannels();
    }

    @GetMapping("/{id}/messages")
    public List<Message> getByChannel(@PathVariable Long id){
        Channel channel = service.getChannelById(id).get();
        return mService.getMessagesByChannel(channel);
    }

    @PostMapping("/{id}")
    public Message post(@RequestBody Message message, @PathVariable Long id){
        Channel channel = service.getChannelById(id).get();
        message.setChannel(channel);
        return mService.addMessage(message);
    }

    @GetMapping("/{id}")
    public Optional<Channel> getById(@PathVariable Long id){
        return service.getChannelById(id);
    }

    @GetMapping("/{id}/users")
    public List<User> getChannelUsers(@PathVariable Long id){
        return service.getChannelUsers(id);
    }

    @PostMapping("/{id}/users")
    public Channel addUsers(@PathVariable Long id, @RequestBody List<Long> userIds){
        return service.addUsers(id, userIds);
    }

    @PostMapping("")
    public Channel post(@RequestBody Channel channel){
        return service.addChannel(channel);
    }
    @PostMapping("/general")
    public Channel setGeneralChannel(){
        return service.setGeneralChannel();
    }

    @PutMapping("/edit/{id}")
    public Channel update(@PathVariable Long id, @RequestBody Channel channel){
        channel.setId(id);
        return service.updateChannel(channel);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.deleteChannel(id);
    }
}
