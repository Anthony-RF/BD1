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

public class CategoryRepositoryImpl extends BaseRepository<categoryEntity, Integer> implements CategoryRepository {

    private final static Logger LOGGER = LoggerFactory.getLogger(MovieRepositoryImpl.class);
    public CategoryRepositoryImpl(HikariDataSource hikariDataSource) {
        super(hikariDataSource);
    }

    @Override
    public List<categoryEntity> findAll() {
        try {
            return this.query(CATEGORY_FIND_ALL_QUERY);
        } catch (SQLException e) {
            System.out.println("Error when finding category in the DB");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<categoryEntity> findById(Integer entityId) {
        try {
            PreparedStatement stmt = this.connect().prepareStatement(CATEGORY_FIND_BY_ID_QUERY);
            stmt.setInt(1, entityId);
            
            return this.query(stmt)
                    .stream()
                    .findFirst();
        } catch (SQLException e) {
            System.out.println("Error when finding category by Id in the DB");
            throw new RuntimeException(e);
            
        }
    }

    @Override
    // se podria cambiar para que se use con el proceso almacenado
    public int save(categoryEntity entity) {
        try {
            var cstmt = this.connect().prepareCall(CATEGORY_CREATE_CATEGORY_PROC_CALL);
            cstmt.setString("p_name", entity.getName());
            cstmt.setString("p_description", entity.getDescription());
            
            cstmt.registerOutParameter("p_new_category_id", Types.INTEGER);
            cstmt.executeUpdate();
            var newcategoryId = cstmt.getInt("p_new_category_id");
            
            cstmt.close();
            return newcategoryId;
        } catch (SQLException e) {
            System.out.println("Error when invoking stored procedure");
            throw new RuntimeException(e);
        }
    }

    

    @Override
    public void delete(Integer entityId) {
        try {
            var cstmt = this.connect().prepareCall(CATEGORY_DELETE_CATEGORY_PROC_CALL);
            
            cstmt.setInt("p_id", entityId);
            cstmt.registerOutParameter("procedure_completed", Types.INTEGER);
            int affectedRows= cstmt.executeUpdate();
            var procedure_completed = cstmt.getInt("procedure_completed");
            if(procedure_completed==-1){
                throw new RuntimeException();
                
                
            }
            System.out.println("Delete category, affected rows "+affectedRows);
            
        } catch (SQLException e) {
            System.out.println("Error when deleting category by ID in the DB \n "+e.getMessage());
            
            throw new RuntimeException(e);
        }
        catch (Exception a) {
            
            System.out.println("There is a movie with this category asigned, or the category does not exists, procedure not done");
            throw new RuntimeException(a);
        }
    }

    @Override
    public categoryEntity update(categoryEntity entity) {
         try {
            var cstmt = this.connect().prepareCall(CATEGORY_UPDATE_CATEGORY_PROC_CALL);
            
            cstmt.setInt("p_id", entity.getId());
            cstmt.setString("p_name", entity.getName());
            cstmt.setString("p_description", entity.getDescription());
          

            cstmt.registerOutParameter("process_status", Types.INTEGER);
            int affectedRows= cstmt.executeUpdate();
            var procedure_completed = cstmt.getInt("process_status");
            if(procedure_completed==-1){
                throw new RuntimeException();
                
                
            }
            System.out.println("Updated Category, affected rows "+ affectedRows);
            return entity;
        } catch (SQLException e) {
            System.out.println("Error when updating category by Id in the DB");
            throw new RuntimeException(e);
        }
        catch (Exception a) {
            System.out.println("The category does not exists");
            throw new RuntimeException(a);
        }
    }

    @Override
    protected categoryEntity toEntity(ResultSet resultSet) throws SQLException {
        
        return new categoryEntity(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("description")
                
        );
    }

    

    

}