package tec.bd.cli.categoryCommands;

import tec.bd.cli.clientCommands.findClientByIdCommand;
import tec.bd.cli.clientCommands.createClientCommand;
import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;
import tec.bd.ApplicationContext;
import tec.bd.cli.clientCommands.deleteClientCommand;
import tec.bd.cli.clientCommands.updateClientCommand;
import tec.bd.cli.categoryCommands.*;
import tec.bd.cli.getLogCommand;
import tec.bd.cli.movieCommands.*;
import tec.bd.cli.reviewCommands.*;

import tec.bd.cli.rentalCommands.*;

//import tec.bd.movies.cli.movies.CreateMovieCommand;
//import tec.bd.movies.cli.movies.DeleteMovieCommand;
//import tec.bd.movies.cli.movies.GetAllMoviesCommand;
//import tec.bd.movies.cli.movies.GetMovieCommand;

@Command(
        name = "Movies App",
        subcommands = {
//                GetAllMoviesCommand.class,
//                GetMovieCommand.class,
//                CreateMovieCommand.class,
               createClientCommand.class,
                HelpCommand.class,
                findClientByIdCommand.class,
                deleteClientCommand.class,
                updateClientCommand.class,
                createCategoryCommand.class,
                deleteCategoryCommand.class,
                findCategoryByIdCommand.class,
                updateCategoryCommand.class,
                createRentalCommand.class,
                deleteRentalCommand.class,
                findRentalByIdCommand.class,
                updateRentalCommand.class,
                createReviewCommand.class,
                deleteReviewCommand.class,
                findReviewByIdCommand.class,
                updateReviewCommand.class,
                getLogCommand.class,
                createMovieCommand.class,
                deleteMovieCommand.class,
                findMovieByIdCommand.class,
                updateMovieCommand.class,
                
                
        },
        description = "Movie Catalog")
public class MainCommand implements Runnable {

    @Override
    public void run() {
        ApplicationContext appContext = ApplicationContext.init();
        
        

    }
}
