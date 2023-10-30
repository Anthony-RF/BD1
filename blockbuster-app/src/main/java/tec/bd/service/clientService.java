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
//import tec.bd.movies.repository.MovieRepository;
import static java.util.Objects.requireNonNull;
import tec.bd.entity.clientEntity;
public interface clientService {

    List<clientEntity> getClients();

    Optional<clientEntity> getClientById(int clientId);

    clientEntity newClient(clientEntity client);

    void removeClient(int clientId);

    clientEntity updateClient(clientEntity client);
    void printClient (clientEntity client);

}