package com.goit.javacore5.forum.command;

import com.goit.javacore5.forum.InMemoryMessageStorage;
import com.goit.javacore5.forum.MessageStorage;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteMessageCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        String id = req.getParameter("id");
        InMemoryMessageStorage.getInstance().deleteById(id);

        resp.sendRedirect("/app/forum");
    }
}
