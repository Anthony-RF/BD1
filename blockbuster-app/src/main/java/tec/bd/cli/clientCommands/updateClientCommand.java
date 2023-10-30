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
/**
 *
 * @author yarman
 */
@Command(name = "cliu", description="Update a  client in Databse")
public class updateClientCommand implements Callable<Integer>{
    private final static Logger LOGGER = LoggerFactory.getLogger(createClientCommand.class);
    private static ApplicationContext applicationContext = ApplicationContext.init();
    
    @Parameters(paramLabel = "<id>", description ="ID of the client")
    private int clientID;
    @Parameters(paramLabel = "<name>", description ="Name of the client")
    private String clientName;
    
    @Parameters(paramLabel = "<lastname>", description ="Lastname of the client")
    private String clientLastName;
    
    @Parameters(paramLabel = "<email>", description ="Email of the client")
    private String clientEmail;
    
    @Parameters(paramLabel = "<PhoneNumber>", description ="Phone number of the client")
    private String phoneNumber;

    @Override
    public Integer call() throws Exception {
        var clientEntity = new clientEntity(this.clientID , this.clientName,this.clientLastName,this.clientEmail,this.phoneNumber);
        try{
            applicationContext.featureFlags.setCreateClientViaStoredProcedureEnabled(true);
           applicationContext.clientService.updateClient(clientEntity);
           System.out.println("The client was updated succesfully");
           return 0;
            
            
        }catch(Exception e){
            LOGGER.error(e.getMessage(),e);
            return -1;
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}