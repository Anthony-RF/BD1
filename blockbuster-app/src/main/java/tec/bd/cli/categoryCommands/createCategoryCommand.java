/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.cli.categoryCommands;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import tec.bd.ApplicationContext;
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
import tec.bd.entity.categoryEntity;
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
@Command(name = "catc", description="Create a new category in Databse")
public class createCategoryCommand implements Callable<Integer>{
    
    private static ApplicationContext applicationContext = ApplicationContext.init();
    
    @Parameters(paramLabel = "<name>", description ="Name of the category")
    private String categoryName;
    
    @Parameters(paramLabel = "<Description>", description ="Description of the category")
    private String categoryDescription;
    
    

    @Override
    public Integer call() throws Exception {
        var categoryEntity = new categoryEntity(this.categoryName,this.categoryDescription);
        try{
            
           applicationContext.CategoryService.newCategory(categoryEntity);
           System.out.println("The category was createad succesfully");
           return 0;
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}
