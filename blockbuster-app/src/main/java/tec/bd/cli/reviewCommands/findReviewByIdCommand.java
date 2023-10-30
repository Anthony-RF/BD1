/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.cli.reviewCommands;
import tec.bd.cli.rentalCommands.*;
import tec.bd.cli.clientCommands.*;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import tec.bd.ApplicationContext;
import tec.bd.entity.clientEntity;;
import java.util.Date;
import java.util.UUID;



import java.util.concurrent.Callable;
import tec.bd.entity.reviewEntity;
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
@CommandLine.Command(name = "revr", description="Find review by ID, find all by not putting ID")
public class findReviewByIdCommand implements Callable<Integer>{
    private static ApplicationContext applicationContext = ApplicationContext.init();
    
    @Parameters(paramLabel = "<id>", defaultValue = "0" ,description ="ID of the review")
    private int reviewID;
    
    

    @Override
    public Integer call() throws Exception {
        try{
            if(reviewID ==0){
              
             var reviews =applicationContext.ReviewService.getReviews();
          if (reviews.isEmpty()){
              System.out.println("No reviews found");
              return 0;
          }
          for (reviewEntity review: reviews){
              applicationContext.ReviewService.printReview(review);
              System.out.println("\n\n");
              
              
          }
            return 0;
            }
            
            var review =applicationContext.ReviewService.getReviewById(reviewID);

            if (review.isEmpty()){
                System.out.println("Review does not exists");
                return -1;
            }
          applicationContext.ReviewService.printReview(review.get());
          
           return 0;
            
            
        }catch(Exception e){
            System.out.println("Ocurrio un error");
            return -1;
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}
