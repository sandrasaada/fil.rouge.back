package com.m2i.FilRouge.controller;

import com.m2i.FilRouge.entity.Channel;
import com.m2i.FilRouge.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/channels")
public class ChannelController {
    @Autowired
    private ChannelService service;

    @GetMapping("")
    public List<Channel> getAll(){
        return service.getAllChannels();
    }

    @GetMapping("/{id}")
    public Optional<Channel> getById(@PathVariable Long id){
        return service.getChannelById(id);
    }

    @PostMapping("")
    public Channel post(@RequestBody Channel channel){
        return service.addChannel(channel);
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
