package by.tc.task.controller.command.help;

import by.tc.task.controller.command.Command;
import by.tc.task.controller.constant.AttributeKey;
import by.tc.task.controller.constant.CommandParam;
import by.tc.task.controller.constant.PagePath;
import by.tc.task.controller.constant.ResponseConstruction;
import by.tc.task.dao.DAOFactory;
import by.tc.task.dao.auth.AuthDAO;
import by.tc.task.service.ServiceFactory;
import by.tc.task.service.auth.AuthService;
import by.tc.task.service.exception.AuthServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Y50-70 on 12.02.2018.
 */
public class EmailCode implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter(AttributeKey.EMAIL_CODE);
        AuthService authService = ServiceFactory.getInstance().getAuthService();
        try{
            authService.sendChangePasswordCode(email);
            HttpSession session = request.getSession();
            session.setAttribute(AttributeKey.EMAIL, email);
            response.sendRedirect(ResponseConstruction.FRONT_CONTROLLER +
                    ResponseConstruction.QUESTION_MARK +
                    ResponseConstruction.COMMAND +
                    ResponseConstruction.EQUALS +
                    CommandParam.CHANGE_PAGE +
                    ResponseConstruction.COMMAND_DELIMETER +
                    ResponseConstruction.PAGE +
                    ResponseConstruction.EQUALS +
                    PagePath.CODE_PAGE
            );
        } catch (AuthServiceException e) {
            e.printStackTrace();
        }
    }
}
