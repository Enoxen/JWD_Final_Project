package by.tc.task.controller.command.help;

import by.tc.task.controller.command.Command;
import by.tc.task.controller.constant.AttributeKey;
import by.tc.task.controller.constant.CommandParam;
import by.tc.task.controller.constant.PagePath;
import by.tc.task.controller.constant.ResponseConstruction;
import by.tc.task.entity.FilmData;
import by.tc.task.entity.FilmOutput;
import by.tc.task.service.ServiceFactory;
import by.tc.task.service.exception.SearchServiceException;
import by.tc.task.service.search.SearchService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Y50-70 on 13.02.2018.
 */
public class SearchByCategory implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.setAttribute(AttributeKey.LOCALE,"ru");
        String locale = (String) session.getAttribute(AttributeKey.LOCALE);
        FilmData data = makeUserDataObjectFromRequest(request);
        SearchService searchService = ServiceFactory.getInstance().getSearchService();
        try {
            LinkedHashSet<FilmOutput> result = searchService.advancedSearch(data, locale);
            List<FilmOutput> list = new ArrayList<>();
            list.addAll(result);
            System.out.println(data);
            System.out.println(result);
            session.setAttribute(AttributeKey.ADVANCED_SEARCH_RESULT, list);
            System.out.println(session.getAttribute(AttributeKey.ADVANCED_SEARCH_RESULT));
            response.sendRedirect(ResponseConstruction.FRONT_CONTROLLER +
                    ResponseConstruction.QUESTION_MARK +
                    ResponseConstruction.COMMAND +
                    ResponseConstruction.EQUALS +
                    CommandParam.CHANGE_PAGE +
                    ResponseConstruction.COMMAND_DELIMETER +
                    ResponseConstruction.PAGE +
                    ResponseConstruction.EQUALS +
                    PagePath.SEARCH_RESULT);

        } catch (SearchServiceException e) {
            e.printStackTrace();
        }
    }

    private FilmData makeUserDataObjectFromRequest(HttpServletRequest request){
        FilmData filmData = new FilmData();

        String filmTitle = request.getParameter(AttributeKey.FILM_TITLE);
        if (!filmTitle.isEmpty()){
            filmData.setDefaultTitle(filmTitle);
        }
        int filmYear;
        if (request.getParameter(AttributeKey.FILM_YEAR).isEmpty()){
            filmYear = 0;
        }
        else {
            filmYear = Integer.parseInt(request.getParameter(AttributeKey.FILM_YEAR));
        }
        filmData.setYear(filmYear);
        String [] genres = request.getParameterValues(AttributeKey.FILM_GENRE);
        if (genres != null) {
            List<Integer> genreId = new ArrayList<>();
            for (String genre : genres) {
                genreId.add(Integer.parseInt(genre));
            }
            filmData.setGenresIn(genreId);
        }
        if (!request.getParameter(AttributeKey.FILM_INTERVAL_FROM).equals("-") &&
                !request.getParameter(AttributeKey.FILM_INTERVAL_TO).equals("-")){
            int[] interval = new int[2];
            interval[0] = Integer.parseInt(request.getParameter(AttributeKey.FILM_INTERVAL_FROM));
            interval[1] = Integer.parseInt(request.getParameter(AttributeKey.FILM_INTERVAL_TO));
            filmData.setInterval(interval);
        }
        return filmData;
    }
}
