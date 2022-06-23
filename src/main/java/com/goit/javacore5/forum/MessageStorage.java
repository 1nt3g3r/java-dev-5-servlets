package com.goit.javacore5.forum;

import java.util.List;

public interface MessageStorage {
    List<Message> getAllMessages();
    void add(Message message);
    void deleteById(String id);
}
