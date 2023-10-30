package tec.bd.repository;

import com.zaxxer.hikari.HikariDataSource;
import tec.bd.entity.rentalsEntity;


import java.sql.*;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tec.bd.entity.clientEntity;

import static tec.bd.repository.Queries.*;
import tec.bd.repository.BaseRepository;

public class rentalRepositoryImpl extends BaseRepository<rentalsEntity, Integer> implements rentalRepository {

    public rentalRepositoryImpl(HikariDataSource hikariDataSource) {
        super(hikariDataSource);
    }

    @Override
    public List<rentalsEntity> findAll() {
        try {
            return this.query(RENTAL_FIND_ALL_QUERY);
        } catch (SQLException e) {
            System.out.println("Error when finding rental in the DB");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<rentalsEntity> findById(Integer entityId) {
        try {
            PreparedStatement stmt = this.connect().prepareStatement(RENTAL_FIND_BY_ID_QUERY);
            stmt.setInt(1, entityId);
            return this.query(stmt)
                    .stream()
                    .findFirst();
        } catch (SQLException e) {
            
            System.out.println("Error when finding rental by Id in the DB");
            throw new RuntimeException(e);
            
        }
    }

    @Override
    // se podria cambiar para que se use con el proceso almacenado
    public int save(rentalsEntity entity) {
        try {
            var cstmt = this.connect().prepareCall(RENTAL_CREATE_RENTAL_PROC_CALL);
            cstmt.setInt("p_client_id", entity.getClientID());
            cstmt.setInt("p_movie_id", entity.getMovieID());
            cstmt.setDate("p_rental_date", new java.sql.Date(entity.getRentalDate().getTime()));
            
            cstmt.registerOutParameter("p_new_rental", Types.INTEGER);
            cstmt.executeUpdate();
            var newrentalId = cstmt.getInt("p_new_rental");
            
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
            var cstmt = this.connect().prepareCall(RENTAL_DELETE_RENTAL_PROC_CALL);
            
            cstmt.setInt("p_id", entityId);
            cstmt.registerOutParameter("procedure_completed", Types.INTEGER);
            int affectedRows= cstmt.executeUpdate();
            var procedure_completed = cstmt.getInt("procedure_completed");
            if(procedure_completed==-1){
                throw new RuntimeException();
                
                
            }
            System.out.println("Delete rental, affected rows "+affectedRows);
            
        } catch (SQLException e) {
            System.out.println("Error when deleting category by ID in the DB \n "+e.getMessage());
            
            throw new RuntimeException(e);
        }
        catch (Exception a) {
            
            System.out.println("There rental may not exist, procedure not done");
            throw new RuntimeException(a);
        }
    }

    @Override
    public rentalsEntity update(rentalsEntity entity) {
         try {
            var cstmt = this.connect().prepareCall(RENTAL_UPDATE_RENTAL_PROC_CALL);
            
            cstmt.setInt("p_id", entity.getID());
            // May or may not need change
            //
            //
                   
            cstmt.setDate("p_rental_date", new java.sql.Date(entity.getRentalDate().getTime()));
            cstmt.setInt("p_client_id", entity.getClientID());
            cstmt.setInt("p_movie_id", entity.getMovieID());

          

            cstmt.registerOutParameter("p_procedure_status", Types.INTEGER);
            int affectedRows= cstmt.executeUpdate();
            var procedure_completed = cstmt.getInt("p_procedure_status");
            if(procedure_completed==-1){
                throw new RuntimeException();
                
                
            }
            System.out.println("Updated Rental, affected rows "+ affectedRows);
            return entity;
        } catch (SQLException e) {
            System.out.println("Error when updating rental by Id in the DB");
            throw new RuntimeException(e);
        }
        catch (Exception a) {
            System.out.println("The rental, client or movie provided may not exist");
            throw new RuntimeException(a);
        }
    }

    @Override
    protected rentalsEntity toEntity(ResultSet resultSet) throws SQLException {
        
        return new rentalsEntity(
                resultSet.getInt("id"),
                resultSet.getDate("rental_date"),
                resultSet.getInt("client_id"),
                                resultSet.getInt("movie_id")

                
        );
    }

    

    

}