/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.cli.categoryCommands;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import tec.bd.ApplicationContext;


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
import tec.bd.entity.categoryEntity;
/**
 *
 * @author yarman
 */
@CommandLine.Command(name = "catr", description="Find category by ID")
public class findCategoryByIdCommand implements Callable<Integer>{
   
    private static ApplicationContext applicationContext = ApplicationContext.init();
    
    @Parameters(paramLabel = "<id>", defaultValue = "0" ,description ="ID of the category")
    private int categoryID;
    
    

    @Override
    public Integer call() throws Exception {
        try{
            if(categoryID ==0){
              
             var categories =applicationContext.CategoryService.getCategories();
          if (categories.isEmpty()){
              System.out.println("No categories found");
              return 0;
          }
          for (categoryEntity category: categories){
              applicationContext.CategoryService.printCategory(category);
              System.out.println("\n\n");
              
              
          }
            return 0;
            }
            
            var category =applicationContext.CategoryService.getCategoryById(categoryID);

            if (category.isEmpty()){
                System.out.println("Category does not exists");
                return -1;
            }
          applicationContext.CategoryService.printCategory(category.get());
          
           return 0;
            
            
        }catch(Exception e){
            System.out.println("Ocurrio un error");
            return -1;
        }
        
    }
    
}
