package by.tc.task.service.auth.impl;

import by.tc.task.dao.DAOFactory;
import by.tc.task.dao.auth.AuthDAO;
import by.tc.task.dao.exception.AuthDAOException;
import by.tc.task.dao.user.UserDAO;
import by.tc.task.entity.AuthUserData;
import by.tc.task.entity.User;
import by.tc.task.service.auth.AuthService;
import by.tc.task.service.exception.AuthServiceException;
import by.tc.task.service.exception.EmailSendServiceException;
import by.tc.task.service.exception.UserServiceException;
import by.tc.task.service.util.email.Email;
import by.tc.task.service.util.generate.RandomString;
import by.tc.task.service.validation.AuthValidator;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Y50-70 on 05.02.2018.
 */
public class AuthServiceImpl implements AuthService {
    @Override
    public boolean addNewUser(AuthUserData data) throws AuthServiceException {
        if (!AuthValidator.isValidRegistrationData(data.getLogin(), data.getNewPassword(), data.getEmail())) {
            System.out.println("kekpek");
            return false;
        } else {
            try {
                final String userRole = "user";
                DAOFactory.getInstance().getAuthDAO().addNewUser(data.getLogin(), data.getNewPassword(), data.getEmail(), userRole);
                return true;
            } catch (AuthDAOException e) {
                throw new AuthServiceException("registration error", e);
            }
        }
    }

    @Override
    public User authUser(AuthUserData data) throws AuthServiceException {
        if (!AuthValidator.isValidAuthData(data)) {
            System.out.println("ololo");
            return null;
        } else {
            try {
                return DAOFactory.getInstance().getAuthDAO().authUser(data.getLogin(), data.getNewPassword());
            } catch (AuthDAOException e) {
                throw new AuthServiceException("authorization error", e);
            }
        }
    }

    @Override
    public boolean sendChangePasswordCode(String email) throws AuthServiceException {
        if (!AuthValidator.isValidEmail(email)) {
            System.out.println("kek");
            return false;
        } else {
            try {
                RandomString gen = new RandomString(5, ThreadLocalRandom.current());
                String code = gen.nextString();
                System.out.println(code);
                AuthDAO authDAO = DAOFactory.getInstance().getAuthDAO();
                if (authDAO.authPassChangeEmail(email)){
                    authDAO.putAuthCodeToDb(code, email);
                    Email.sendEmail(email,code);
                    return true;
                }
                else {
                    return false;
                }
            } catch (AuthDAOException|EmailSendServiceException e) {
                throw new AuthServiceException("prepare auth code service exception",e);
            }
        }
    }

    @Override
    public boolean checkUserCode(String code, String email) throws AuthServiceException {
        AuthDAO authDAO = DAOFactory.getInstance().getAuthDAO();
        try{
            String codeCheck = authDAO.getAuthCodeFromDb(email);
            authDAO.removeAuthCodeFromDb(email);
            return codeCheck.equals(code);
        } catch (AuthDAOException e) {
            throw new AuthServiceException("check user code service exception",e);
        }
    }
}
