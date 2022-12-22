package com.m2i.FilRouge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "channels")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(targetEntity = Message.class, mappedBy = "channel")
    private List<Message> messages;

    @ManyToMany
    @JoinTable(name = "channels_users", joinColumns = { @JoinColumn(name = "channel_id") }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<User> users;

    public Channel(Long id, String description, String name){
        this.id = 1L;
        this.description = "Canal Général";
        this.name = "Général";

        id = this.id;
        description = this.description;
        name = this.name;
    }
}
