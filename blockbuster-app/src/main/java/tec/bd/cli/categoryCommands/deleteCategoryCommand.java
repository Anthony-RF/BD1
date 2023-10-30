/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.cli.categoryCommands;
import tec.bd.cli.clientCommands.createClientCommand;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import tec.bd.ApplicationContext;


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
@Command(name = "catd", description="Delete a category  in Databse")
public class deleteCategoryCommand implements Callable<Integer>{
  
    private static ApplicationContext applicationContext = ApplicationContext.init();
    
    @Parameters(paramLabel = "<id>", description ="Name of the category")
    private int categoryID;
    
    

    @Override
    public Integer call() throws Exception {
        try{
           
           applicationContext.CategoryService.removeCategory(categoryID);
           
           return 0;
            
            
        }catch(Exception e){
            System.out.println("An error ocurred");
            return -1;
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}
