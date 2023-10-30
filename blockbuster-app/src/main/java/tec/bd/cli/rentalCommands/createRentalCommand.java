/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.cli.rentalCommands;
import tec.bd.cli.clientCommands.*;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import tec.bd.ApplicationContext;
import tec.bd.entity.rentalsEntity;;

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
@Command(name = "loanc", description="Create a new rental in Databse")
public class createRentalCommand implements Callable<Integer>{
   
    private static ApplicationContext applicationContext = ApplicationContext.init();
    
    @Parameters(paramLabel = "<movieID>", description ="ID of the movie to rent")
    private int movieID;
    
    @Parameters(paramLabel = "<clientID>", description ="ID of the client that  rents")
    private int clientID;
    
    @Parameters(paramLabel = "<rentalDate>", description ="Date where the rental ocurr")
    private Date rentalDate;
    
    

    @Override
    public Integer call() throws Exception {
        var rentalEntity = new rentalsEntity(this.rentalDate,this.clientID,this.movieID);
        try{
            
           applicationContext.RentalService.newRental(rentalEntity);
           System.out.println("The rental was createad succesfully");
           return 0;
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}
