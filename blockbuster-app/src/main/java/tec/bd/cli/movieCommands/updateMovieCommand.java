/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.cli.movieCommands;
import tec.bd.cli.clientCommands.*;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import tec.bd.ApplicationContext;
import tec.bd.entity.clientEntity;;

import java.util.concurrent.Callable;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.slf4j.Logger;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;
import tec.bd.entity.movieEntity;
import java.util.concurrent.Callable;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.slf4j.Logger;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;
/**
 *
 * @author yarman
 */
@Command(name = "movu", description="Update a  movie in Databse")
public class updateMovieCommand implements Callable<Integer>{
    
    private static ApplicationContext applicationContext = ApplicationContext.init();
    
    @Parameters(paramLabel = "<id>", description ="ID of the client")
    private int movieID;
     @Parameters(paramLabel = "<title>", description ="Title of the movie")
    private String movieTitle;
    
    @Parameters(paramLabel = "<release_date>", description ="Release date of the movie")
    private Date releaseDate;
    
    @Parameters(paramLabel = "<categoryID>", description ="ID of the category")
    private int categoryID;
    
    @Parameters(paramLabel = "<units_available>", description ="Units available to rent")
    private int unitsAvailable;

    @Override
    public Integer call() throws Exception {
                var movieEntity = new movieEntity(this.movieID,this.movieTitle,this.releaseDate,this.categoryID,this.unitsAvailable);

        try{
           
           applicationContext.movieService.updateMovie(movieEntity);
           System.out.println("The movie was updated succesfully");
           return 0;
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}