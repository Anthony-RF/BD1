/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.repository;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import tec.bd.entity.blockbusterLog;


import com.zaxxer.hikari.HikariDataSource;


import java.sql.*;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static tec.bd.repository.Queries.*;
import tec.bd.repository.BaseRepository;
/**
 *
 * @author yarman
 */
public class LogRepositoryImpl extends BaseRepository<blockbusterLog, Integer> implements LogRepository {

    public LogRepositoryImpl(HikariDataSource hikariDataSource) {
        super(hikariDataSource);
    }

    @Override
    public List<blockbusterLog> findAll() {
        try {
            return this.query(FIND_ALL_FROM_LOG);
        } catch (SQLException e) {
            System.out.println("Error when finding logs in the DB");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<blockbusterLog> findLastN(int n) {
        try {
            PreparedStatement stmt = this.connect().prepareStatement(FIND_N_FROM_LOG);
            stmt.setInt(1, n);
            return this.query(stmt);
        } catch (SQLException e) {
            System.out.println("Error when finding log by Id in the DB");
            throw new RuntimeException(e);
            
        }
    }

    @Override
    // se podria cambiar para que se use con el proceso almacenado
    public int save(blockbusterLog entity) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    

    

    @Override
    protected blockbusterLog toEntity(ResultSet resultSet) throws SQLException {
        
        return new blockbusterLog(
                resultSet.getInt("id"),
                resultSet.getString("table_name"),
                
                resultSet.getDate("created_on"),
                                resultSet.getString("entry_text")

                
                

                
        );
    }

    @Override
    public void delete(Integer entityID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public blockbusterLog update(blockbusterLog entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<blockbusterLog> findById(Integer entityID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    

}