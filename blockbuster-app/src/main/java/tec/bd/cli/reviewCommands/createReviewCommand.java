/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.cli.reviewCommands;
import java.math.BigDecimal;
import java.math.RoundingMode;
import tec.bd.cli.categoryCommands.*;
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
import static java.util.function.Predicate.not;
/**
 *
 * @author yarman
 */
@Command(name = "revc", description="Create a new review in Databse")
public class createReviewCommand implements Callable<Integer>{
    
    private static ApplicationContext applicationContext = ApplicationContext.init();
    
    @Parameters(paramLabel = "<movieID>", description ="Id of the movie")
    private int movieId ;
    
    @Parameters(paramLabel = "<clientID>", description ="Id of the client")
    private int clientId ;
    
    @Parameters(paramLabel = "<rating>", description ="Rating of the review. Values from 0.0 to 5.0")
    private BigDecimal rating ;
    
    @Parameters(paramLabel = "<ReviewText>", description ="Text of the review")
    private String reviewText;
    
    @Parameters(paramLabel = "<reviewDate>", description ="Date of the review")
    private Date reviewDate;
    public static boolean isBetween(BigDecimal value, BigDecimal min, BigDecimal max) {
        return value.compareTo(min) >= 0 && value.compareTo(max) <= 0;
    }
    

    @Override
    public Integer call() throws Exception {
        boolean isBetween05 = isBetween(rating,new BigDecimal("0"),new BigDecimal("5"));
        this.rating = this.rating.setScale(2,RoundingMode.HALF_UP);
        if  (!isBetween05){
            
            System.out.println("The rating needs to be between 0 and 5.");
        }
        var reviewEntity = new reviewEntity(this.rating,this.reviewText,this.reviewDate,this.clientId,this.movieId);
        try{
            
           applicationContext.ReviewService.newReview(reviewEntity);
           System.out.println("The review was createad succesfully");
           return 0;
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}
