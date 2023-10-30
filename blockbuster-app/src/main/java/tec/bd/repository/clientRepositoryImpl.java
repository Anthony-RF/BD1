package tec.bd.repository;

import com.zaxxer.hikari.HikariDataSource;
import tec.bd.entity.categoryEntity;
import tec.bd.entity.movieEntity;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tec.bd.entity.clientEntity;

import static tec.bd.repository.Queries.*;
import tec.bd.repository.BaseRepository;

public class clientRepositoryImpl extends BaseRepository<clientEntity, Integer> implements clientRepository {

    private final static Logger LOGGER = LoggerFactory.getLogger(MovieRepositoryImpl.class);
    public clientRepositoryImpl(HikariDataSource hikariDataSource) {
        super(hikariDataSource);
    }

    @Override
    public List<clientEntity> findAll() {
        try {
            return this.query(CLIENT_FIND_ALL_QUERY);
        } catch (SQLException e) {
            System.out.println("Error when finding clients in the DB\n");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<clientEntity> findById(Integer entityId) {
        try {
            PreparedStatement stmt = this.connect().prepareStatement(CLIENT_FIND_BY_ID_QUERY);
            stmt.setInt(1, entityId);
            return this.query(stmt)
                    .stream()
                    .findFirst();
        } catch (SQLException e) {
            System.out.println("Error when finding client by Id in the DB\n");
            throw new RuntimeException(e);
            
        }
    }

    @Override
    // se podria cambiar para que se use con el proceso almacenado
    public int save(clientEntity client) {
         try {
            var cstmt = this.connect().prepareCall(CLIENT_CREATE_CLIENT_PROC_CALL);
            cstmt.setString("p_name", client.getName());
            cstmt.setString("p_lastname", client.getLastname());
            cstmt.setString("p_email", client.getEmail());
            cstmt.setString("p_phone_number", client.getPhone_number());
            cstmt.registerOutParameter("p_new_client_id", Types.INTEGER);
            cstmt.executeUpdate();
            var newclientId = cstmt.getInt("p_new_client_id");
            
            cstmt.close();
            return newclientId;
        } catch (SQLException e) {
            System.out.println("Error when invoking stored procedure");
            throw new RuntimeException(e);
        }
    }

    @Override
    public int callCreateClientProcedure(clientEntity client) {
        try {
            var cstmt = this.connect().prepareCall(CLIENT_CREATE_CLIENT_PROC_CALL);
            cstmt.setString("p_name", client.getName());
            cstmt.setString("p_lastname", client.getLastname());
            cstmt.setString("p_email", client.getEmail());
            cstmt.setString("p_phone_number", client.getPhone_number());
            cstmt.registerOutParameter("p_new_client_id", Types.INTEGER);
            cstmt.executeUpdate();
            var newclientId = cstmt.getInt("p_new_client_id");
            if(newclientId ==-1){
                System.out.println("Couldnt delete client");
                 cstmt.close();
                 cstmt.close();
            return newclientId;
            }
            System.out.println("Client with Id " + newclientId +" created");
            
            cstmt.close();
            return newclientId;
        } catch (SQLException e) {
            System.out.println("Error when invoking stored procedure");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer entityId) {
        try {
            var cstmt = this.connect().prepareCall(CLIENT_DELETE_CLIENT_PROC_CALL);
            
            cstmt.setInt("p_id", entityId);
            cstmt.registerOutParameter("procedure_completed", Types.INTEGER);
            int affectedRows= cstmt.executeUpdate();
            var procedure_completed = cstmt.getInt("procedure_completed");
            
            if(procedure_completed==-1){
                throw new RuntimeException();
                
                
            }
            System.out.println("Delete client, affected rows "+affectedRows);
            
        } catch (SQLException e) {
            System.out.println("Error when client movie by ID in the DB \n "+e.getMessage());
            
            throw new RuntimeException(e);
        }
        catch (Exception a) {
            
            System.out.println("Either the client has a rental or a review, or it doesnt exist, procedure not done");
            throw new RuntimeException(a);
        }
    }

    @Override
    public clientEntity update(clientEntity entity) {
         try {
            var cstmt = this.connect().prepareCall(CLIENT_UPDATE_CLIENT_PROC_CALL);
            
            cstmt.setInt("p_id", entity.getId());
            cstmt.setString("p_name", entity.getName());
            cstmt.setString("p_lastname", entity.getLastname());
            cstmt.setString("p_email", entity.getEmail());            
            cstmt.setString("p_phone_number", entity.getPhone_number());

            cstmt.registerOutParameter("p_procedure_status", Types.INTEGER);
            int affectedRows= cstmt.executeUpdate();
            var procedure_completed = cstmt.getInt("p_procedure_status");
            if(procedure_completed==-1){
                throw new RuntimeException();
                
                
            }
            System.out.println("Updated Movie, affected rows "+ affectedRows);
            return entity;
        } catch (SQLException e) {
            System.out.println("Error when updating client by Id in the DB");
            throw new RuntimeException(e);
        }
        catch (Exception a) {
            System.out.println("The client does not exists");
            throw new RuntimeException(a);
        }
    }

    @Override
    protected clientEntity toEntity(ResultSet resultSet) throws SQLException {
        
        return new clientEntity(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("lastname"),
                resultSet.getString("email"),
                resultSet.getString("phone_number")
                
        );
    }

    

    

}