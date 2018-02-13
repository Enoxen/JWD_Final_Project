package by.tc.task.service;


import by.tc.task.dao.DAOFactory;
import by.tc.task.dao.exception.DAOException;
import by.tc.task.service.admin.AdminService;
import by.tc.task.service.admin.impl.AdminServiceImpl;
import by.tc.task.service.auth.AuthService;
import by.tc.task.service.auth.impl.AuthServiceImpl;
import by.tc.task.service.exception.ServiceException;
import by.tc.task.service.search.SearchService;
import by.tc.task.service.search.impl.SearchServiceImpl;
import by.tc.task.service.user.UserService;
import by.tc.task.service.user.impl.UserServiceImpl;

/**
 * Created by Y50-70 on 12.11.2017.
 */
public class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final AdminService adminService = new AdminServiceImpl();
    private final SearchService searchService = new SearchServiceImpl();
    private final AuthService authService = new AuthServiceImpl();



    private ServiceFactory(){}
    public static void initService()throws ServiceException {
        try{
            DAOFactory.initDataSource();
        } catch (DAOException e) {
            throw new ServiceException("init service error", e);
        }
    }
    public static void destroyService() throws ServiceException {
        try{
            DAOFactory.destroyDataSource();
        } catch (DAOException e) {
            throw new ServiceException("destroy datasource service exception",e);
        }
    }
    public UserService getUserService() {
        return userService;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public SearchService getSearchService() {
        return searchService;
    }

    public AuthService getAuthService() {
        return authService;
    }

    public static ServiceFactory getInstance(){
        return instance;
    }

}
