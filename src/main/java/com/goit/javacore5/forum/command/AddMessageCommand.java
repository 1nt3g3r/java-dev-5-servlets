package com.goit.javacore5.forum.command;

import com.goit.javacore5.forum.InMemoryMessageStorage;
import com.goit.javacore5.forum.Message;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class AddMessageCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        String author = req.getParameter("author");
        String content = req.getParameter("content");

        Message message = new Message();
        message.setAuthor(author);
        message.setContent(content);
        message.setId(UUID.randomUUID().toString());

        InMemoryMessageStorage.getInstance().add(message);

        resp.sendRedirect("/app/forum");
    }
}
