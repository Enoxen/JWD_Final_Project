package by.tc.task.controller.command.help;

import by.tc.task.controller.command.Command;
import by.tc.task.controller.constant.AttributeKey;
import by.tc.task.controller.constant.PagePath;
import by.tc.task.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Y50-70 on 21.11.2017.
 */
public class ChangeLocale implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException{

    }
}
