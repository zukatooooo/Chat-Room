package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chatroom")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "max-capacity")
    int maxCapacity;

    public ChatRoom(int id, String name, int maxCapacity) {
        this.id = id;
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
