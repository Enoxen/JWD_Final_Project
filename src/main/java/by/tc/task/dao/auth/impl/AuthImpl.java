package by.tc.task.dao.auth.impl;

import by.tc.task.dao.auth.AuthDAO;
import by.tc.task.dao.constant.DAODbQuery;
import by.tc.task.dao.datasource.DataSource;
import by.tc.task.dao.exception.AuthDAOException;
import by.tc.task.dao.help.AuthHelp;
import by.tc.task.dao.user.impl.UserDAOImpl;
import by.tc.task.dao.util.Encryptor;
import by.tc.task.dao.exception.DataSourceDAOException;
import by.tc.task.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Y50-70 on 10.01.2018.
 */
public class AuthImpl implements AuthDAO {


    @Override
    public boolean addNewUser(String login, String password, String email, String role) throws AuthDAOException {
        Connection connection = null;

        try{
            connection = DataSource.getConnection();
            if(isLoginFree(login, connection)) {

                int rowsUser;
                try (PreparedStatement addUser = connection.prepareStatement(DAODbQuery.SQL_ADD_NEW_USER)) {

                    String salt = Encryptor.generateSalt();

                    addUser.setString(1, login);
                    addUser.setString(2, email);
                    addUser.setString(3, Encryptor.getPasswordHashCode(password, salt));
                    addUser.setString(4, salt);
                    addUser.setString(5, role);
                    rowsUser = addUser.executeUpdate();
                }
                return rowsUser != 0;
            }
            else {
                return false;
            }

        } catch (SQLException | DataSourceDAOException | NoSuchAlgorithmException e) {
            throw new AuthDAOException("adding new user to db error", e);
        }
        finally {
            DataSource.closeConnection(connection);
        }
    }
    private boolean isLoginFree(String login, Connection connection) throws AuthDAOException {
        try{

            try (PreparedStatement isFree = connection.prepareStatement(DAODbQuery.SQL_IS_LOGIN_FREE)) {
                isFree.setString(1, login);
                try (ResultSet selectResult = isFree.executeQuery()) {
                    if (selectResult.next()) {
                        String str = selectResult.getString(1);
                        System.out.println(str);
                        return str == null;
                    } else {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            throw new AuthDAOException("login db validation error", e);
        }
    }
    @Override
    public User authUser(String login, String password) throws AuthDAOException {
        Connection connection = null;
        try {
            connection = DataSource.getConnection();
            try (PreparedStatement authUser = connection.prepareStatement(DAODbQuery.SQL_AUTHORIZE_USER_BY_LOGIN)) {

                authUser.setString(1, login);
                try (ResultSet authDataFromDb = authUser.executeQuery()) {
                    if (authDataFromDb.isBeforeFirst()) {
                        System.out.println("kek");
                        authDataFromDb.next();
                        String dbLogin = authDataFromDb.getString(1);
                        String dbPassword = authDataFromDb.getString(2);
                        String dbSalt = authDataFromDb.getString(3);
                        String dbRole = authDataFromDb.getString(4);
                        String dbEmail = authDataFromDb.getString(6);
                        int dbUserId = authDataFromDb.getInt(5);
                        System.out.println(Encryptor.getPasswordHashCode(password,dbSalt));
                        System.out.println(dbPassword);
                        if (/*login.equals(dbLogin) &&*/ Encryptor.getPasswordHashCode(password, dbSalt).equals(dbPassword)) {
                            return makeUserFromDbResponse(dbLogin, dbRole, dbUserId, dbEmail);
                        } else {
                            System.out.println("pek");
                            return null;
                        }
                    } else {
                        return null;
                    }
                }
            }
        } catch (DataSourceDAOException|SQLException|NoSuchAlgorithmException e) {
            throw new AuthDAOException("user auth problems", e);
        }
        finally {
            DataSource.closeConnection(connection);
        }
    }

    private User makeUserFromDbResponse(String dbLogin, String dbRole, int dbUserId, String dbEmail){
        User user = new User();
        user.setLogin(dbLogin);
        user.setRole(dbRole);
        user.setUserId(dbUserId);
        user.setEmail(dbEmail);
        return user;
    }
    @Override
    public boolean authPassChangeEmail(String email) throws AuthDAOException {
        Connection connection = null;
        try{
            connection = DataSource.getConnection();
            return AuthHelp.authEmail(email,connection);
        } catch (DataSourceDAOException | SQLException e) {
            throw new AuthDAOException("auth email to change pass DAO error",e);
        }
        finally {
            DataSource.closeConnection(connection);
        }
    }

    @Override
    public boolean putAuthCodeToDb(String code, String email) throws AuthDAOException {
        Connection connection = null;
        try{
            connection = DataSource.getConnection();
            try (PreparedStatement putCode = connection.prepareStatement(DAODbQuery.SQL_PUT_AUTH_CODE_TO_DB)) {
                putCode.setString(1,code);
                putCode.setString(2,email);
                int rowsUpd = putCode.executeUpdate();
                return rowsUpd != 0;
            }
        } catch (DataSourceDAOException | SQLException e) {
            throw new AuthDAOException("put auth code to db error",e);
        }
        finally {
            DataSource.closeConnection(connection);
        }
    }

    @Override
    public boolean removeAuthCodeFromDb(String email) throws AuthDAOException {
        Connection connection = null;
        try{
            connection = DataSource.getConnection();
            int rowsUpd;
            try (PreparedStatement removeCode = connection.prepareStatement(DAODbQuery.SQL_REMOVE_AUTH_CODE_FROM_DB)) {
                removeCode.setString(1, email);
                rowsUpd = removeCode.executeUpdate();
            }
            return rowsUpd != 0;
        } catch (DataSourceDAOException | SQLException e) {
            throw new AuthDAOException("remove auth code from db error",e);
        }
        finally {
            DataSource.closeConnection(connection);
        }
    }

    @Override
    public String getAuthCodeFromDb(String email) throws AuthDAOException {
        Connection connection = null;
        try{
            connection = DataSource.getConnection();
            try (PreparedStatement getCode = connection.prepareStatement(DAODbQuery.SQL_GET_AUTH_CODE_FROM_DB)) {
                getCode.setString(1,email);
                try (ResultSet code = getCode.executeQuery()) {
                    if (code.isBeforeFirst()){
                        code.next();
                        return code.getString(1);
                    }
                    else {
                        return null;
                    }
                }
            }
        } catch (DataSourceDAOException | SQLException e) {
            throw new AuthDAOException("get auth code dao error",e);
        }
        finally {
            DataSource.closeConnection(connection);
        }
    }
}
