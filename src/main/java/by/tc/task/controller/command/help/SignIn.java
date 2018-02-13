package by.tc.task.controller.command.help;

import by.tc.task.controller.command.Command;
import by.tc.task.controller.constant.AttributeKey;
import by.tc.task.controller.constant.ResponseConstruction;

import by.tc.task.entity.AuthUserData;
import by.tc.task.entity.User;
import by.tc.task.service.ServiceFactory;
import by.tc.task.service.auth.AuthService;
import by.tc.task.service.exception.AuthServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Y50-70 on 19.11.2017.
 */
public class SignIn implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType(AttributeKey.CONTENT_TYPE);

        AuthUserData userData = new AuthUserData();
        userData.setLogin(request.getParameter(AttributeKey.LOGIN).trim());
        userData.setNewPassword(request.getParameter(AttributeKey.PASSWORD));
        AuthService authService = ServiceFactory.getInstance().getAuthService();

        try {
            System.out.println(userData);
            User user = authService.authUser(userData);
            System.out.println(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(ResponseConstruction.FRONT_CONTROLLER +
                    ResponseConstruction.QUESTION_MARK +
                    ResponseConstruction.COMMAND +
                    ResponseConstruction.EQUALS +
                    ResponseConstruction.AFTER_REGISTRATION);
        } catch (AuthServiceException | IOException e) {
            e.printStackTrace();
        }
    }
}
