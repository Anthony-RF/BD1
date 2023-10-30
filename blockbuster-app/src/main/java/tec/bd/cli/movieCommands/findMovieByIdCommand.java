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
import tec.bd.entity.movieEntity;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.slf4j.Logger;
import java.util.Date;
import java.util.UUID;
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
@CommandLine.Command(name = "movr", description="Find movie by ID")
public class findMovieByIdCommand implements Callable<Integer>{
    private final static Logger LOGGER = LoggerFactory.getLogger(findMovieByIdCommand.class);
    private static ApplicationContext applicationContext = ApplicationContext.init();
    
    @Parameters(paramLabel = "<id>", defaultValue = "0" ,description ="ID of the movie")
    private int movieID;
    
    

    @Override
    public Integer call() throws Exception {
        try{
            if(movieID ==0){
              
             var movies =applicationContext.movieService.getMovies();
          if (movies.isEmpty()){
              System.out.println("No movies found");
              return 0;
          }
          for (movieEntity movie: movies){
              applicationContext.movieService.printMovie(movie);
              System.out.println("\n\n");
              
              
          }
            return 0;
            }
            
            var movie =applicationContext.movieService.getMovieById(movieID);

            if (movie.isEmpty()){
                System.out.println("Movie does not exists");
                return -1;
            }
          applicationContext.movieService.printMovie(movie.get());
          
           return 0;
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}
