package tec.bd;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import tec.bd.repository.CategoryRepository;
import tec.bd.repository.CategoryRepositoryImpl;
import tec.bd.repository.LogRepository;
import tec.bd.repository.LogRepositoryImpl;
import tec.bd.service.FeatureFlags;
import tec.bd.service.FeatureFlags;
//import tec.bd.movies.repository.CategoryRepository;
//import tec.bd.movies.repository.CategoryRepositoryImpl;
import tec.bd.repository.MovieRepository;
import tec.bd.repository.MovieRepositoryImpl;
import tec.bd.repository.clientRepository;
import tec.bd.repository.clientRepositoryImpl;
import tec.bd.repository.rentalRepository;
import tec.bd.repository.rentalRepositoryImpl;
import tec.bd.repository.reviewRepository;
import tec.bd.repository.reviewRepositoryImpl;
import tec.bd.service.MovieService;
import tec.bd.service.MovieServiceImpl;
import tec.bd.service.categoryService;
import tec.bd.service.categoryServiceImpl;
import tec.bd.service.clientService;
import tec.bd.service.clientServiceImpl;
import tec.bd.service.logService;
import tec.bd.service.logServiceImpl;
import tec.bd.service.rentalService;
import tec.bd.service.rentalServiceImpl;
import tec.bd.service.reviewService;
import tec.bd.service.reviewServiceImpl;
//import tec.bd.movies.repository.MovieRepositoryImpl;
//import tec.bd.movies.services.FeatureFlags;
//import tec.bd.movies.services.MovieService;
//import tec.bd.movies.services.MovieServiceImpl;

public class ApplicationContext {

   public FeatureFlags featureFlags;
//
//    public CategoryRepository categoryRepository;
   
   //CLientRepo
   public clientRepository clientRepository;
     public clientService clientService;
     
     //Category Repo
   public CategoryRepository categoryRepository;
     public categoryService CategoryService;
     
      //Rental Repo
   public rentalRepository RentalRepository;
     public rentalService RentalService;

     //Review Repo
   public reviewRepository ReviewRepository;
     public reviewService ReviewService;
     
       //log Repo
   public LogRepository logRepository;
     public logService LogService;
     
     //movie repo
   public MovieRepository movieRepository;
     public MovieService movieService;
    private ApplicationContext() {

    }

    public static ApplicationContext init() {
        ApplicationContext appContext = new ApplicationContext();

        var hikariConfig = initHikariDataSource();

        appContext.featureFlags = new FeatureFlags();
           //appContext.categoryRepository = initCategoryRepository(hikariConfig);
           
           //Client Repo
            appContext.clientRepository = initClientRepository(hikariConfig);
            appContext.clientService = initClientService(appContext.clientRepository,
           appContext.featureFlags);
            
            //Category Repo
            appContext.categoryRepository = initCategoryRepository(hikariConfig);
            appContext.CategoryService = initCategoryService(appContext.categoryRepository,
           appContext.featureFlags);
            
             //Rental Repo
            appContext.RentalRepository = initRentalRepository(hikariConfig);
            appContext.RentalService = initRentalService(appContext.RentalRepository,
           appContext.featureFlags);
            
             //Review Repo
            appContext.ReviewRepository = initReviewRepository(hikariConfig);
            appContext.ReviewService = initReviewService(appContext.ReviewRepository,
           appContext.featureFlags);
            
             //Review Repo
            appContext.logRepository = initLogRepository(hikariConfig);
            appContext.LogService = initLogService(appContext.logRepository,
           appContext.featureFlags);
            
              //Movie Repo
            appContext.movieRepository = initMovieRepository(hikariConfig);
            appContext.movieService = initMovieService(appContext.movieRepository,
           appContext.featureFlags);
            
            

        return appContext;
    }

    private static HikariDataSource initHikariDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        var jdbcUrl = "jdbc:mysql://localhost:3306/blockbuster";//jdbc:mysql://localhost:3306/blockbuster
        var username = "blockbusterappuser";//rooot
        var password = "blockbusterapppass";//1234
//         var jdbcUrl = System.getenv("MOVIES_DB_JDBC");//jdbc:mysql://localhost:3306/blockbuster
//        var username = System.getenv("MOVIES_DB_USERNAME");//rooot
//        var password = System.getenv("MOVIES_DB_PASSWORD");//1234
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.addDataSourceProperty("connectionTestQuery", "SELECT 1");
        hikariConfig.addDataSourceProperty("maximumPoolSize", "4");
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(hikariConfig);
    }


    //Init Client
    private static clientRepository initClientRepository(HikariDataSource hikariDataSource) {
        return new clientRepositoryImpl(hikariDataSource);
    }

     private static clientService initClientService(clientRepository ClientRepository,                                                 
                                                 FeatureFlags featureFlags) {
        return new clientServiceImpl(ClientRepository,  featureFlags);
      }
     
     private static CategoryRepository initCategoryRepository(HikariDataSource hikariDataSource) {
        return new CategoryRepositoryImpl(hikariDataSource);
    }

     private static categoryService initCategoryService(CategoryRepository categoryRepository,                                                 
                                                 FeatureFlags featureFlags) {
        return new categoryServiceImpl(categoryRepository,  featureFlags);
      }
      private static rentalRepository initRentalRepository(HikariDataSource hikariDataSource) {
        return new rentalRepositoryImpl(hikariDataSource);
    }

     private static rentalService initRentalService(rentalRepository RentalRepository,                                                 
                                                 FeatureFlags featureFlags) {
        return new rentalServiceImpl(RentalRepository,  featureFlags);
      }
       private static reviewRepository initReviewRepository(HikariDataSource hikariDataSource) {
        return new reviewRepositoryImpl(hikariDataSource);
    }

     private static reviewService initReviewService(reviewRepository ReviewRepository,                                                 
                                                 FeatureFlags featureFlags) {
        return new reviewServiceImpl(ReviewRepository,  featureFlags);
      }
     
       private static LogRepository initLogRepository(HikariDataSource hikariDataSource) {
        return new LogRepositoryImpl(hikariDataSource);
    }

     private static logService initLogService(LogRepository logRepository,                                                 
                                                 FeatureFlags featureFlags) {
        return new logServiceImpl(logRepository,  featureFlags);
      }
         private static MovieRepository initMovieRepository(HikariDataSource hikariDataSource) {
        return new MovieRepositoryImpl(hikariDataSource);
    }

     private static MovieService initMovieService(MovieRepository movieRepository,                                                 
                                                 FeatureFlags featureFlags) {
        return new MovieServiceImpl(movieRepository,  featureFlags);
      }

}
