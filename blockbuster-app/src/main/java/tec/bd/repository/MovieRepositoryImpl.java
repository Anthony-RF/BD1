package tec.bd.repository;

import com.zaxxer.hikari.HikariDataSource;
import tec.bd.entity.categoryEntity;
import tec.bd.entity.movieEntity;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static tec.bd.repository.Queries.*;
import tec.bd.repository.BaseRepository;

public class MovieRepositoryImpl extends BaseRepository<movieEntity, Integer> implements MovieRepository {

    private final static Logger LOGGER = LoggerFactory.getLogger(MovieRepositoryImpl.class);
    public MovieRepositoryImpl(HikariDataSource hikariDataSource) {
        super(hikariDataSource);
    }

    @Override
    public List<movieEntity> findAll() {
        try {
            return this.query(MOVIES_FIND_ALL_QUERY);
        } catch (SQLException e) {
            LOGGER.error("Error when finding movies in the DB", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<movieEntity> findById(Integer entityId) {
        try {
            PreparedStatement stmt = this.connect().prepareStatement(MOVIES_FIND_BY_ID_QUERY);
            stmt.setInt(1, entityId);
            return this.query(stmt)
                    .stream()
                    .findFirst();
        } catch (SQLException e) {
            LOGGER.error("Error when finding movie by Id in the DB", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int save(movieEntity entity) {
        try(var conn = this.connect()) {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE); // Creo que mas util en Updates
            Savepoint savepointOne = conn.setSavepoint("savepoint_one");
            try (
                PreparedStatement stmt = conn.prepareStatement(MOVIES_INSERT_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, entity.getTitle());
                stmt.setDate(2, new java.sql.Date(entity.getReleaseDate().getTime()));
                stmt.setInt(3, entity.getCategoryID());
                stmt.setInt(4, entity.getUnits_available());
                var rowsAffected = stmt.executeUpdate(); // se realiza la operacion de escritura
                conn.commit();

                LOGGER.debug("Rows Affected {}", rowsAffected);

                var resultSet = stmt.getGeneratedKeys();

                if (resultSet.next()) {
                    var lastInsertedId = resultSet.getInt(1);
                        System.out.println("Movie created with id "+ lastInsertedId);
                    
                    return 1;
                }
            } catch (SQLException e) {
                try {
                    LOGGER.debug("Transaction is being rolled out");
                    conn.rollback(savepointOne);
                } catch (Exception rex) {
                    LOGGER.error("Cant rollback savepointOne operation", rex);
                    throw new RuntimeException(rex);
                }
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            LOGGER.error("Error when saving movie in the DB", e);
            throw new RuntimeException(e);
        }
        return 0;
    }

   
    @Override
    public void delete(Integer entityId) {
        try(var conn = this.connect()) {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE); // Creo que mas util en Updates
            Savepoint savepointOne = conn.setSavepoint("savepoint_one");
            try (
                PreparedStatement stmt = conn.prepareStatement(MOVIES_DELETE_MOVIE_ID, PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, entityId);
                var rowsAffected = stmt.executeUpdate(); // se realiza la operacion de escritura
                conn.commit();

                var resultSet = stmt.getGeneratedKeys();

                System.out.println("Movie deleted");
            } catch (SQLException e) {
                try {
                    LOGGER.debug("Transaction is being rolled out");
                    conn.rollback(savepointOne);
                } catch (Exception rex) {
                    LOGGER.error("Cant rollback savepointOne operation", rex);
                    throw new RuntimeException(rex);
                }
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            LOGGER.error("Error when saving movie in the DB", e);
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public movieEntity update(movieEntity entity) {
         try(var conn = this.connect()) {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE); // Creo que mas util en Updates
            Savepoint savepointOne = conn.setSavepoint("savepoint_one");
            try (
                PreparedStatement stmt = conn.prepareStatement(MOVIES_UPDATE_MOVIE, PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, entity.getTitle());
                stmt.setDate(2, new java.sql.Date(entity.getReleaseDate().getTime()));
                stmt.setInt(3, entity.getCategoryID());
                stmt.setInt(4, entity.getUnits_available());
                stmt.setInt(5, entity.getId());
                var rowsAffected = stmt.executeUpdate(); // se realiza la operacion de escritura
                conn.commit();

                LOGGER.debug("Rows Affected {}", rowsAffected);

                var resultSet = stmt.getGeneratedKeys();

                System.out.println("Movie updated");
                    
                    return entity;
                
            } catch (SQLException e) {
                try {
                    LOGGER.debug("Transaction is being rolled out");
                    conn.rollback(savepointOne);
                } catch (Exception rex) {
                    LOGGER.error("Cant rollback savepointOne operation", rex);
                    throw new RuntimeException(rex);
                }
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            LOGGER.error("Error when saving movie in the DB", e);
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    protected movieEntity toEntity(ResultSet resultSet) throws SQLException {
        
        return new movieEntity(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getDate("release_date"),
                resultSet.getInt("category_id"),
                resultSet.getInt("units_available")
                
        );
    }

}