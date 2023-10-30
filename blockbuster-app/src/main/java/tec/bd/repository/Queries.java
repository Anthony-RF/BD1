package tec.bd.repository;

public class Queries {

    /**
     * Queries for Movies
     */
    public static final String MOVIES_FIND_ALL_QUERY  = "select id, title, release_date, category_id, units_available  " +
            "from movie ";
    
    public static final String MOVIES_FIND_BY_ID_QUERY = "select id, title, release_date, category_id, units_available " +
            "from movie where id = ?";
    public static final String MOVIES_INSERT_QUERY = "insert into movie (title, release_date, category_id, units_available) values (?, ?, ? , ?)";
    
    public static final String MOVIES_DELETE_MOVIE_ID = "delete from movie where id = ?";

    public static final String MOVIES_UPDATE_MOVIE = "update movie set title = ?, release_date = ?, category_id = ? , units_available = ? where id = ?";

    
    
    //Client querys
    public static final String CLIENT_FIND_ALL_QUERY  = "select id, name, lastname, email, phone_number " +
            "from client";
    public static final String CLIENT_FIND_BY_ID_QUERY = "select id, name, lastname, email, phone_number " +
            "from client  where id = ?";
    public static final String CLIENT_INSERT_QUERY = "insert into client (name, lastname, email, phone_numer) values (?, ?, ?,?)";
    
    public static final String CLIENT_CREATE_CLIENT_PROC_CALL = "call create_client(?, ?, ?, ?, ?)";
    public static final String CLIENT_DELETE_CLIENT_PROC_CALL = "call delete_client(?, ?)";
    public static final String CLIENT_UPDATE_CLIENT_PROC_CALL = "call update_client(? , ?, ?, ?, ?, ?)";
    
    // Category querys
    public static final String CATEGORY_FIND_ALL_QUERY  = "select id, name, description  " +
            "from category";
    public static final String CATEGORY_FIND_BY_ID_QUERY = "select id, name, description " +
            " from category  where id = ?";
    public static final String CATEGORY_CREATE_CATEGORY_PROC_CALL = "call create_category(?, ?, ?)";
    public static final String CATEGORY_DELETE_CATEGORY_PROC_CALL = "call delete_category(?, ?)";
    public static final String CATEGORY_UPDATE_CATEGORY_PROC_CALL = "call update_category(? , ?, ?, ?)";
    
    //Rental Queries
    
    public static final String RENTAL_FIND_ALL_QUERY  = "select id, rental_date, client_id , movie_id  " +
            "from rentals";
    public static final String RENTAL_FIND_BY_ID_QUERY = "select id, rental_date, client_id , movie_id " +
            "from rentals  where id = ?";
    public static final String RENTAL_CREATE_RENTAL_PROC_CALL = "call create_rental(?, ?, ?,?)";
    public static final String RENTAL_DELETE_RENTAL_PROC_CALL = "call delete_rental(?, ?)";
    public static final String RENTAL_UPDATE_RENTAL_PROC_CALL = "call update_category(? , ?, ?, ?, ?)";
    
    
    
    
    
    
    
    //Review Queries
     public static final String REVIEW_FIND_ALL_QUERY  = "select id, movie_id, client_id , rating, review_text, created_on  " +
            "from review";
    public static final String REVIEW_FIND_BY_ID_QUERY = "select id, movie_id, client_id , rating, review_text, created_on " +
            "from review  where id = ?";
    public static final String REVIEW_CREATE_REVIEW_PROC_CALL = "call create_review(?, ?, ?,?,?, ?)";
    public static final String REVIEW_DELETE_REVIEW_PROC_CALL = "call delete_review(?, ?)";
    public static final String REVIEW_UPDATE_REVIEW_PROC_CALL = "call update_review(? , ?, ?, ?, ?, ?, ? )";
    
    public static final String FIND_ALL_FROM_LOG = "select id, table_name, created_on, entry_text from blockbuster_log order by created_on desc;";
     public static final String FIND_N_FROM_LOG = "select id, table_name, created_on, entry_text from blockbuster_log order by created_on desc  limit ?;";
    
    
    
}
