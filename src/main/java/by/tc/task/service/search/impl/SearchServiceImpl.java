package by.tc.task.service.search.impl;

import by.tc.task.dao.DAOFactory;
import by.tc.task.dao.exception.SearchDAOException;
import by.tc.task.dao.search.SearchDAO;
import by.tc.task.entity.FilmData;
import by.tc.task.entity.FilmOutput;
import by.tc.task.entity.Person;
import by.tc.task.entity.Review;
import by.tc.task.service.exception.SearchServiceException;
import by.tc.task.service.search.SearchService;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Y50-70 on 08.02.2018.
 */
public class SearchServiceImpl implements SearchService {
    @Override
    public FilmOutput getRandomFilm(String locale) throws SearchServiceException {
        try{
            SearchDAO searchDAO = DAOFactory.getInstance().getSearchDAO();
            return searchDAO.getRandomFilm(locale);
        } catch (SearchDAOException e) {
            throw new SearchServiceException("get random film service error",e);
        }
    }

    @Override
    public LinkedHashSet<FilmOutput> advancedSearch(FilmData filmData, String locale) throws SearchServiceException {
        try{
            SearchDAO searchDAO = DAOFactory.getInstance().getSearchDAO();
            return searchDAO.advancedSearch(filmData, locale);
        }
        catch (SearchDAOException e){
            throw new SearchServiceException("advanced search service error",e);
        }
    }

    @Override
    public List<FilmOutput> searchByPerson(Person person, String locale, int startPos, int amount) throws SearchServiceException {
        try{
            SearchDAO searchDAO = DAOFactory.getInstance().getSearchDAO();
            return searchDAO.searchByPerson(person, locale, startPos, amount);
        }
        catch (SearchDAOException e){
            throw new SearchServiceException("search by person service error",e);
        }
    }

    @Override
    public LinkedHashSet<FilmOutput> searchByTitle(String title, String locale, int startPos, int amount) throws SearchServiceException {
        try{
            SearchDAO searchDAO = DAOFactory.getInstance().getSearchDAO();
            return searchDAO.searchByTitle(title, locale, startPos, amount);
        }
        catch (SearchDAOException e){
            throw new SearchServiceException("search by title service error",e);
        }
    }

    @Override
    public List<Review> getFilmReviews(int filmId, int startPos, int amount) throws SearchServiceException {
        try{
            SearchDAO searchDAO = DAOFactory.getInstance().getSearchDAO();
            return searchDAO.getFilmReviews(filmId, startPos, amount);
        }
        catch (SearchDAOException e){
            throw new SearchServiceException("get film reviews service error",e);
        }
    }
}
