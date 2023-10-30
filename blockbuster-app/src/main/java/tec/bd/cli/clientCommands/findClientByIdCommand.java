/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.cli.clientCommands;
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
@CommandLine.Command(name = "clir", description="Find client by ID")
public class findClientByIdCommand implements Callable<Integer>{
    private final static Logger LOGGER = LoggerFactory.getLogger(findClientByIdCommand.class);
    private static ApplicationContext applicationContext = ApplicationContext.init();
    
    @Parameters(paramLabel = "<id>", defaultValue = "0" ,description ="ID of the client")
    private int clientID;
    
    

    @Override
    public Integer call() throws Exception {
        try{
            if(clientID ==0){
              
             var clients =applicationContext.clientService.getClients();
          if (clients.isEmpty()){
              System.out.println("No clients found");
              return 0;
          }
          for (clientEntity client: clients){
              applicationContext.clientService.printClient(client);
              System.out.println("\n\n");
              
              
          }
            return 0;
            }
            
            var client =applicationContext.clientService.getClientById(clientID);

            if (client.isEmpty()){
                System.out.println("Client does not exists");
                return -1;
            }
          applicationContext.clientService.printClient(client.get());
          
           return 0;
            
            
        }catch(Exception e){
            System.out.println("Ocurrio un error");
            return -1;
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}
