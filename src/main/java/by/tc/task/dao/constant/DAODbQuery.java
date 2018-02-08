package by.tc.task.dao.constant;


/**
 * Created by Y50-70 on 12.11.2017.
 */
public class DAODbQuery {

    // auth user queries
    public static final  String SQL_IS_LOGIN_FREE = "select username from user where username = ?";
    public static final String SQL_ADD_NEW_USER = "insert into user (username, email, password, salt, role) values(?,?,?,?,?)";
    public static final String SQL_AUTHORIZE_USER_BY_LOGIN = "select username, password, salt, role,user_id, email from user where (username = ?)";
    public static final String SQL_UPDATE_USER_PASSWORD_BY_LOGIN = "update user set password = ?, salt = ? where username = ?";
    public static final String SQL_GET_USER_PASSWORD = "select password, salt from user where username = ?";
    public static final String SQL_UPDATE_USER_PASSWORD_BY_EMAIL = "update user set password = ? where email = ?";
    public static final String SQL_AUTH_USER_EMAIL = "select email from user where email = ?";
    public static final String SQL_UPDATE_USER_LOGIN = "update user set username = ? where user_id = ?";
    public static final String SQL_GET_USER_ID_BY_LOGIN = "select user_id from user where username = ?";
    public static final String SQL_UPDATE_USER_EMAIL_BY_LOGIN = "update user set email = ? where username = ?";
    public static final String SQL_GET_UPDATED_USER_DATA = "select user_id, username, email, role, is_banned from user where username = ? xor email = ?";
    public static final String SQL_PUT_AUTH_CODE_TO_DB = "update user set code = ? where email = ?";
    public static final String SQL_REMOVE_AUTH_CODE_FROM_DB = "update user set code = null where email = ?";
    public static final String SQL_GET_AUTH_CODE_FROM_DB = "select code from user where email = ?";


    // admin queries
    public static final String SQL_BAN_USER_BY_LOGIN = "update user set is_banned = ? where username = ?";
    public static final String SQL_CALL_DELETE_FILM_FROM_DB = "call delete_film(?)";
    public static final String SQL_GIVE_ADMIN_RIGHTS = "update user set role = 'admin'  where username = ?";
    public static final String SQL_REMOVE_ADMIN_RIGHTS = "update user set role = 'user'  where username = ?";


    //actor queries
    public static final String SQL_INSERT_ACTOR_INTO_TABLE = "insert into actor_test(actor_name, actor_surname, actor_name_EN, actor_surname_EN) values(?,?,?,?)";
    public static final String SQL_GET_ACTOR_ID_BY_NAME_SURNAME = "select actor_id from actor where actor_name = ? and actor_surname = ?";
    public static final String SQL_GET_ACTOR_ID_BY_NAME_SURNAME_LOCAL = "select actor_id from actor where actor_name_EN = ? and actor_surname_EN = ?";
    public static final String SQL_GET_ACTOR_ID_REPEAT_CHECK = "select actor_id from actor_test where actor_name = ? and actor_surname = ? and actor_name_EN = ? and actor_surname_EN = ?";
    public static final String SQL_CONNECT_ACTOR_WITH_FILM = "insert into actor_has_film_test(actor_id, film_id) values(?,?)";
    public static final String SQL_GET_MAX_ACTOR_ID = "select max(actor_id) from actor_test";

    //director queries
    public static final String SQL_GET_DIRECTOR_ID_REPEAT_CHECK = "select director_id from director_test where director_name = ? and director_surname = ? and director_name_EN = ? and director_surname_EN = ?";
    public static final String SQL_GET_DIRECTOR_MAX_ID = "select max(director_id) from director_test";
    public static final String SQL_CONNECT_DIRECTOR_WITH_A_FILM = "insert into director_has_film_test(director_id, film_id) values(?,?)";
    public static final String SQL_INSERT_DIRECTOR_INTO_TABLE = "insert into director_test(director_name,director_surname,director_name_EN, director_surname_EN) values(?,?,?,?)";

    //user action queries
    public static final String SQL_ADD_FILM_TO_FAVORITE = "insert into favorite_films (film_id, user_id) values(?,?)";
    public static final String SQL_DELETE_FROM_FAVORITE = "delete from favorite_films where user_id = ? and film_id = ?";
    public static final String SQL_FOLLOW_USER = "insert into user_follows (user_id,user_to_follow_id) values(?,?)";
    public static final String SQL_UNFOLLOW_USER = "delete from user_follows where user_id = ? and user_to_follow_id = ?";
    public static final String SQL_ADD_REVIEW = "insert into reviews(review_text, film_id, user_id) values(?,?,?)";
    public static final String SQL_DELETE_USER_REVIEW = "delete from reviews where id_review = ?";

    //film queries
    public static final String SQL_INSERT_FILM_DATA_INTO_TABLE = "insert into film_test(film_default_title,film_default_description,film_year, film_loc_title, film_loc_description, film_add_date) values(?,?,?,?,?,?)";
    public static final String SQL_GET_FILM_ID_BY_TITLE = "select film_id from film where (film_default_title = ?) or (film_loc_title = ?)";
    public static final String SQL_CONNECT_FILM_WITH_GENRE = "insert into film_has_genre_test(film_id,genre_id) values(?,?)";
    public static final String SQL_GET_MAX_FILM_ID = "select max(film_id) from film_test";
    public static final String SQL_CALL_RECOUNT_RATING = "call recountRating(?,?,?)";
    public static final String SQL_GET_ALL_FILM_ID = "select film_id from film;";
    public static final String SQL_GET_FILM_BY_ID = "select film_id,film_default_title, film_default_descripption,f from film;";
    public static final String SQL_GET_FILM_REVIEWS = "select film_id, user_id, review_text from reviews where film_id = ? limit ?,?";
    public static final String SQL_GET_USER_REVIEWS = "select id_review, film_id, review_text, reviews.user_id \n" +
            "from reviews where reviews.film_id = ? limit ?,?";
    public static final String SQL_GET_USER_MARKS = "select  marks.film_id, user_mark, marks.user_id, film.film_default_title\n" +
            "from marks \n" +
            "join film on film.film_id = marks.film_id where user_id = ? limit ?,?;";
    public static final String SQL_GET_USER_MARKS_EN = "select  marks.film_id, user_mark, film.film_loc_title\n" +
            "from marks \n" +
            "join film on film.film_id = marks.film_id where user_id = ? limit ?,?;";

    public static final String SQL_GET_USER_FAVORITE_FILMS = "select film.film_poster, film.film_id\n" +
            "from film\n" +
            "join favorite_films on favorite_films.film_id = film.film_id\n" +
            "where favorite_films.user_id = ?;";
    //pagination


    private DAODbQuery(){}
}
