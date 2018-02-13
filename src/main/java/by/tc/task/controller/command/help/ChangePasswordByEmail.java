package by.tc.task.controller.command.help;

import by.tc.task.controller.command.Command;
import by.tc.task.controller.constant.AttributeKey;
import by.tc.task.controller.constant.ResponseConstruction;
import by.tc.task.entity.AuthUserData;
import by.tc.task.entity.User;
import by.tc.task.service.ServiceFactory;
import by.tc.task.service.exception.UserServiceException;
import by.tc.task.service.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Y50-70 on 13.02.2018.
 */
public class ChangePasswordByEmail implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String newPassword = request.getParameter(AttributeKey.NEW_PASSWORD);
        String confirmPassword = request.getParameter(AttributeKey.CONFIRM_PASSWORD);
        String email = (String)session.getAttribute(AttributeKey.EMAIL);
        UserService userService = ServiceFactory.getInstance().getUserService();
        AuthUserData userData = new AuthUserData();
        userData.setEmail(email);
        userData.setNewPassword(newPassword);
        userData.setPasswordConfirm(confirmPassword);
        System.out.println(userData);

        try {
            User user = userService.changePassword(userData);
            System.out.println(user);
            session.setAttribute("user",user);
            response.sendRedirect(ResponseConstruction.FRONT_CONTROLLER +
                    ResponseConstruction.QUESTION_MARK +
                    ResponseConstruction.COMMAND +
                    ResponseConstruction.EQUALS +
                    ResponseConstruction.AFTER_REGISTRATION);
        } catch (UserServiceException e) {
            e.printStackTrace();
        }
    }
}
