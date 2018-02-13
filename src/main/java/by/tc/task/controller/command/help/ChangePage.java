package by.tc.task.controller.command.help;

import by.tc.task.controller.command.Command;
import by.tc.task.controller.constant.AttributeKey;
import by.tc.task.controller.constant.PagePath;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Y50-70 on 12.02.2018.
 */
public class ChangePage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = request.getParameter(AttributeKey.PAGE_NAME);
        RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.PAGE_PATTERN+pageName+PagePath.FORMAT);
        dispatcher.forward(request,response);
    }
}
