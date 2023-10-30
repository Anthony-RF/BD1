package tec.bd.service;


import java.util.List;
import java.util.Optional;
import tec.bd.entity.movieEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static java.util.Objects.requireNonNull;
import tec.bd.entity.rentalsEntity;
import tec.bd.entity.clientEntity;
public interface rentalService {

    List<rentalsEntity> getRentals();

    Optional<rentalsEntity> getRentalById(int rentalId);

    rentalsEntity newRental(rentalsEntity newRental);

    void removeRental(int rentalId);

    rentalsEntity updateRentals(rentalsEntity rental);
    void printRental (rentalsEntity rental);

}