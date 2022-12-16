package com.m2i.FilRouge.controller;

import com.m2i.FilRouge.entity.Channel;
import com.m2i.FilRouge.entity.User;
import com.m2i.FilRouge.repository.UserRepository;
import com.m2i.FilRouge.service.ChannelService;
import com.m2i.FilRouge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/channels")
public class ChannelController {
    @Autowired
    private ChannelService cService;
    @Autowired
    private UserService uService;

    @GetMapping("")
    public List<Channel> getAll(){
        return cService.getAllChannels();
    }

    @GetMapping("/{id}")
    public Optional<Channel> getById(@PathVariable Long id){
        return cService.getChannelById(id);
    }

    @GetMapping("/{id}/users")
    public Set<User> getChannelUsers(@PathVariable Long id){
        return cService.getChannelUsers(id);
    }

    @PostMapping("/{id}/users")
    public Channel addUsersToChannel(@PathVariable Long id, @RequestBody List<Long> userIds){
        return cService.addUsersToChannel(id, userIds);
    }

    @PostMapping("")
    public Channel post(@RequestBody Channel channel){
        return cService.addChannel(channel);
    }

    @PutMapping("/edit/{id}")
    public Channel update(@PathVariable Long id, @RequestBody Channel channel){
        channel.setId(id);
        return cService.updateChannel(channel);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        cService.deleteChannel(id);
    }
}
