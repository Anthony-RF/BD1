/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.service;

import static java.lang.constant.ConstantDescs.NULL;
import java.util.List;
import java.util.Optional;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tec.bd.entity.movieEntity;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
//import tec.bd.movies.repository.MovieRepository;
import static java.util.Objects.requireNonNull;
import tec.bd.entity.rentalsEntity;
import tec.bd.entity.clientEntity;
import tec.bd.repository.rentalRepository;
import tec.bd.repository.clientRepository;
/**
 *
 * @author Yarman
 */
public class rentalServiceImpl implements rentalService {
    
    private final FeatureFlags featureFlags;
    private final rentalRepository RentalRepository;
    
    public rentalServiceImpl(rentalRepository RentalRepository , FeatureFlags featureFlags){
        requireNonNull(RentalRepository);
        requireNonNull(featureFlags);
        this.featureFlags=featureFlags;
        this.RentalRepository = RentalRepository;
       
        
    }

    @Override
    public List<rentalsEntity> getRentals() {
        return this.RentalRepository.findAll();
    }

    @Override
    public Optional<rentalsEntity> getRentalById(int rentalId) {
         return this.RentalRepository.findById(rentalId);
         
         
        
    }

    @Override
    public rentalsEntity newRental(rentalsEntity rental) {
        requireNonNull(rental);
        System.out.println("Creating rental...");
        var newRentalID = this.RentalRepository.save(rental);
        System.out.println("New client rental with ID "+newRentalID);
        // Falta Cambiar este metodo
        rental.setID(newRentalID);
        return rental;
    }

    @Override
    public void removeRental(int rentalId) {
        requireNonNull(rentalId);
        System.out.println("Deleting rental");
        this.RentalRepository.delete(rentalId);

    }

    @Override
    public rentalsEntity updateRentals(rentalsEntity rental) {
        requireNonNull(rental);
        this.RentalRepository.update(rental);
        return rental;
    }
    @Override
    public void printRental(rentalsEntity rental){
        System.out.println(
        "Rental ID: " + rental.getID()+
                "\nRental Date: " +rental.getRentalDate()
                +"\nClient ID " +rental.getClientID()
                               +"\nMovie ID " +rental.getMovieID()

        );
    }
    
}
