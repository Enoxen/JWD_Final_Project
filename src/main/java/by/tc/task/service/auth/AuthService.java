package by.tc.task.service.auth;

import by.tc.task.entity.AuthUserData;
import by.tc.task.entity.User;
import by.tc.task.service.exception.AuthServiceException;
import by.tc.task.service.exception.UserServiceException;

/**
 * Created by Y50-70 on 05.02.2018.
 */
public interface AuthService {

    boolean addNewUser(AuthUserData data) throws AuthServiceException;

    User authUser(AuthUserData data) throws AuthServiceException;

    boolean sendChangePasswordCode(String email) throws AuthServiceException;

    boolean checkUserCode(String code, String email) throws AuthServiceException;

}
