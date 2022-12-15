package com.m2i.FilRouge.service;

import com.m2i.FilRouge.entity.Channel;
import com.m2i.FilRouge.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {
    @Autowired
    private ChannelRepository repo;

    public List<Channel> getAllChannels(){
        return repo.findAll();
    }

    public Optional<Channel> getChannelById(Long id){
        return repo.findById(id);
    }

    public Channel addChannel(Channel channel){
        return repo.save(channel);
    }

    public void deleteChannel(Long id){
        repo.findById(id).orElse(null);
        repo.deleteById(id);
    }

    public Channel updateChannel(Channel channel){
        Channel newChannel = repo.findById(channel.getId()).orElse(null);
        if(newChannel != null){
            newChannel.setName(channel.getName());
            newChannel.setDescription(channel.getDescription());
            repo.save(newChannel);
        }
        return newChannel;
    }
}
