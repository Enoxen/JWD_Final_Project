package by.tc.task;

import by.tc.task.dao.DAOFactory;
import by.tc.task.dao.auth.AuthDAO;
import by.tc.task.dao.exception.DAOException;
import by.tc.task.dao.search.SearchDAO;
import by.tc.task.dao.util.Encryptor;
import by.tc.task.entity.FilmData;
import by.tc.task.service.ServiceFactory;
import by.tc.task.service.auth.AuthService;
import by.tc.task.service.exception.ServiceException;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Y50-70 on 11.01.2018.
 */
public class Tester {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        try {
            DAOFactory.initDataSource();
            SearchDAO s = DAOFactory.getInstance().getSearchDAO();
            FilmData d = new FilmData();
            d.setYear(1998);
            System.out.println(s.advancedSearch(d,"ru"));
        } catch (DAOException e) {
            e.printStackTrace();
        }
        /*String salt = "1e93eff45f1807b561193695da7839f674eb46dd693e6efffb6293bf3314b9ce";
        System.out.println(Encryptor.getPasswordHashCode("1522122Rbh",salt));*/
    }
}









