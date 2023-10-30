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
import tec.bd.entity.clientEntity;;
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
import tec.bd.entity.rentalsEntity;

import java.util.concurrent.Callable;
import org.slf4j.Logger;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;
/**
 *
 * @author yarman
 */
@Command(name = "loanu", description="Update a  rent in Databse")
public class updateRentalCommand implements Callable<Integer>{
    private static ApplicationContext applicationContext = ApplicationContext.init();
    
    @Parameters(paramLabel = "<id>", description ="ID of the rental")
    private int rentalID;
    @Parameters(paramLabel = "<movieID>", description ="ID of the movie to rent")
    private int movieID;
    
    @Parameters(paramLabel = "<clientID>", description ="ID of the client that  rents")
    private int clientID;
    
    @Parameters(paramLabel = "<rentalDate>", description ="Date Of rental")
    private Date rentalDate;

    @Override
    public Integer call() throws Exception {
        var rentalEntity = new rentalsEntity(this.rentalID ,this.rentalDate, this.clientID,this.movieID);
        try{
          
           applicationContext.RentalService.updateRentals(rentalEntity);
           System.out.println("The client was updated succesfully");
           return 0;
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}