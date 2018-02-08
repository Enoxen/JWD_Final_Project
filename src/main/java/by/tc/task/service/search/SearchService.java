package by.tc.task.service.search;

import by.tc.task.dao.exception.SearchDAOException;
import by.tc.task.entity.FilmData;
import by.tc.task.entity.FilmOutput;
import by.tc.task.entity.Person;
import by.tc.task.entity.Review;
import by.tc.task.service.exception.SearchServiceException;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Y50-70 on 07.02.2018.
 */
public interface SearchService {
    FilmOutput getRandomFilm(String locale) throws SearchDAOException, SearchServiceException;
    LinkedHashSet<FilmOutput> advancedSearch(FilmData filmData, String locale) throws SearchServiceException;
    List<FilmOutput> searchByPerson(Person person, String locale, int startPos, int amount) throws SearchServiceException;
    LinkedHashSet<FilmOutput> searchByTitle(String title, String locale, int startPos, int amount) throws SearchServiceException;
    List<Review> getFilmReviews(int filmId, int startPos, int amount) throws SearchServiceException;
}
