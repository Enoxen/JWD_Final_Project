package by.tc.task.controller.command.help;

import by.tc.task.controller.command.Command;
import by.tc.task.controller.constant.AttributeKey;
import by.tc.task.controller.constant.ResponseConstruction;
import by.tc.task.entity.AuthUserData;
import by.tc.task.entity.User;
import by.tc.task.service.ServiceFactory;
import by.tc.task.service.auth.AuthService;
import by.tc.task.service.exception.AuthServiceException;
import by.tc.task.service.exception.ServiceException;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Y50-70 on 19.11.2017.
 */
public class SignUp implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType(AttributeKey.CONTENT_TYPE);

        AuthUserData userData = new AuthUserData();
        userData.setLogin(request.getParameter(AttributeKey.LOGIN).trim());
        userData.setNewPassword(request.getParameter(AttributeKey.PASSWORD));
        userData.setEmail(request.getParameter(AttributeKey.EMAIL));

        AuthService authService = ServiceFactory.getInstance().getAuthService();

        try {
            System.out.println(authService.addNewUser(userData));
            response.sendRedirect(ResponseConstruction.FRONT_CONTROLLER +
                    ResponseConstruction.QUESTION_MARK +
                    ResponseConstruction.COMMAND +
                    ResponseConstruction.EQUALS +
                    ResponseConstruction.AFTER_REGISTRATION +
                    ResponseConstruction.COMMAND_DELIMETER);
        } catch (AuthServiceException | IOException e) {
            e.printStackTrace();
        }


    }
}
