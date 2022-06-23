package com.goit.javacore5.forum.command;

import com.goit.javacore5.forum.InMemoryMessageStorage;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class GetMessagesCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        resp.setContentType("text/html");

        Context simpleContext = new Context(
                req.getLocale(),
                Map.of("messages", InMemoryMessageStorage.getInstance().getAllMessages())
        );

        engine.process("forum", simpleContext, resp.getWriter());
        resp.getWriter().close();
    }
}
