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
/**
 *
 * @author yarman
 */
@Command(name = "catu", description="Update a category in Databse")
public class updateCategoryCommand implements Callable<Integer>{
    
    private static ApplicationContext applicationContext = ApplicationContext.init();
    
    @Parameters(paramLabel = "<id>", description ="ID of the category")
    private int categoryID;
    
    @Parameters(paramLabel = "<name>", description ="Name of the category")
    private String categoryName;
    
    @Parameters(paramLabel = "<description>", description ="Description of the category")
    private String categoryDescription;
    
   

    @Override
    public Integer call() throws Exception {
        var categoryEntity = new categoryEntity(this.categoryID , this.categoryName,this.categoryDescription);
        try{
            
           applicationContext.CategoryService.updateCategory(categoryEntity);
           System.out.println("The category was updated succesfully");
           return 0;
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}