package tec.bd.repository;

import com.zaxxer.hikari.HikariDataSource;
import tec.bd.entity.reviewEntity;


import java.sql.*;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tec.bd.entity.clientEntity;

import static tec.bd.repository.Queries.*;
import tec.bd.repository.BaseRepository;

public class reviewRepositoryImpl extends BaseRepository<reviewEntity, Integer> implements reviewRepository {

    public reviewRepositoryImpl(HikariDataSource hikariDataSource) {
        super(hikariDataSource);
    }

    @Override
    public List<reviewEntity> findAll() {
        try {
            return this.query(REVIEW_FIND_ALL_QUERY);
        } catch (SQLException e) {
            System.out.println("Error when finding review in the DB");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<reviewEntity> findById(Integer entityId) {
        try {
            PreparedStatement stmt = this.connect().prepareStatement(REVIEW_FIND_BY_ID_QUERY);
            stmt.setInt(1, entityId);
            return this.query(stmt)
                    .stream()
                    .findFirst();
        } catch (SQLException e) {
            System.out.println("Error when finding review by Id in the DB");
            throw new RuntimeException(e);
            
        }
    }

    @Override
    // se podria cambiar para que se use con el proceso almacenado
    public int save(reviewEntity entity) {
        try {
            var cstmt = this.connect().prepareCall(REVIEW_CREATE_REVIEW_PROC_CALL);
            cstmt.setInt("p_client_id", entity.getClientID());
            cstmt.setInt("p_movie_id", entity.getMovieID());
            cstmt.setBigDecimal("p_rating", entity.getRating());
            
            cstmt.setString("p_review_text", entity.getReviewText());
            
            cstmt.setDate("p_created_on", new java.sql.Date(entity.getCreatedOn().getTime()));
            
            cstmt.registerOutParameter("p_new_review", Types.INTEGER);
            cstmt.executeUpdate();
            var newrentalId = cstmt.getInt("p_new_review");
            
            cstmt.close();
            return newrentalId;
        } catch (SQLException e) {
            System.out.println("Error when invoking stored procedure");
            throw new RuntimeException(e);
        }
    }

    

    @Override
    public void delete(Integer entityId) {
        try {
            var cstmt = this.connect().prepareCall(REVIEW_DELETE_REVIEW_PROC_CALL);
            
            cstmt.setInt("p_id", entityId);
            cstmt.registerOutParameter("procedure_completed", Types.INTEGER);
            int affectedRows= cstmt.executeUpdate();
            var procedure_completed = cstmt.getInt("procedure_completed");
            if(procedure_completed==-1){
                throw new RuntimeException();
                
                
            }
            System.out.println("Delete review, affected rows "+affectedRows);
            
        } catch (SQLException e) {
            System.out.println("Error when deleting review by ID in the DB \n "+e.getMessage());
            
            throw new RuntimeException(e);
        }
        catch (Exception a) {
            
            System.out.println("There review may not exist, procedure not done");
            throw new RuntimeException(a);
        }
    }

    @Override
    public reviewEntity update(reviewEntity entity) {
         try {
            var cstmt = this.connect().prepareCall(REVIEW_UPDATE_REVIEW_PROC_CALL);
            
            cstmt.setInt("p_id", entity.getID());
            // May or may not need change
            //
            //
                   
            cstmt.setInt("p_client_id", entity.getClientID());
            cstmt.setInt("p_movie_id", entity.getMovieID());
            cstmt.setBigDecimal("p_rating", entity.getRating());
            
            cstmt.setString("p_review_text", entity.getReviewText());
            
            cstmt.setDate("p_created_on", new java.sql.Date(entity.getCreatedOn().getTime()));

          

            cstmt.registerOutParameter("p_procedure_status", Types.INTEGER);
            int affectedRows= cstmt.executeUpdate();
            var procedure_completed = cstmt.getInt("p_procedure_status");
            if(procedure_completed==-1){
                throw new RuntimeException();
                
                
            }
            System.out.println("Updated Review, affected rows "+ affectedRows);
            return entity;
        } catch (SQLException e) {
            System.out.println("Error when updating rental by Id in the DB");
            throw new RuntimeException(e);
        }
        catch (Exception a) {
            System.out.println("The review, client or movie provided may not exist");
            throw new RuntimeException(a);
        }
    }

    @Override
    protected reviewEntity toEntity(ResultSet resultSet) throws SQLException {
        
        return new reviewEntity(
                resultSet.getInt("id"),
                resultSet.getBigDecimal("rating"),
                resultSet.getString("review_text"),
                resultSet.getDate("created_on"),
                
                resultSet.getInt("client_id"),
                                resultSet.getInt("movie_id")

                
        );
    }

    

    

}