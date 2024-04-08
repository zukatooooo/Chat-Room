package org.example.request;

import org.example.model.ChatRoom;

public class AddNewChatRequest {
    ChatRoom chatRoom;

    public void addNewChatRequest(String name, String maxCapacity) {
        this.chatRoom = new ChatRoom();
        chatRoom.setName(name);
        chatRoom.setMaxCapacity(Integer.parseInt(maxCapacity));
    }
}
