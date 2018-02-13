package by.tc.task.dao.auth;

import by.tc.task.dao.exception.AuthDAOException;
import by.tc.task.entity.AuthUserData;
import by.tc.task.entity.User;


/**
 * Created by Y50-70 on 10.01.2018.
 */
public interface AuthDAO {
    boolean addNewUser(String login, String password, String email, String role) throws AuthDAOException;

    User authUser(String login, String password) throws AuthDAOException;

    boolean authPassChangeEmail(String email) throws AuthDAOException;

    boolean putAuthCodeToDb(String code, String email) throws AuthDAOException;

    boolean removeAuthCodeFromDb(String email) throws AuthDAOException;

    String getAuthCodeFromDb(String email) throws AuthDAOException;
}
