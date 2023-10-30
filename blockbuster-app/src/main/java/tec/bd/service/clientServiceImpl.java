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
import tec.bd.entity.clientEntity;
import tec.bd.repository.clientRepository;
/**
 *
 * @author Yarman
 */
public class clientServiceImpl implements clientService {
    private final static Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);
    private final FeatureFlags featureFlags;
    private final clientRepository ClientRepository;
    
    public clientServiceImpl(clientRepository ClientRepository, FeatureFlags featureFlags){
        requireNonNull(ClientRepository);
        requireNonNull(featureFlags);
        this.featureFlags=featureFlags;
        this.ClientRepository = ClientRepository;
       
        
    }

    @Override
    public List<clientEntity> getClients() {
        return this.ClientRepository.findAll();
    }

    @Override
    public Optional<clientEntity> getClientById(int clientId) {
         return this.ClientRepository.findById(clientId);
         
         
        
    }

    @Override
    public clientEntity newClient(clientEntity client) {
        requireNonNull(client);
        System.out.println("Creating client...");
        var newClientID = this.ClientRepository.callCreateClientProcedure(client);
        System.out.println("New client created with ID "+newClientID+ "\n");
        // Falta Cambiar este metodo
        return new clientEntity();
    }

    @Override
    public void removeClient(int clientId) {
        requireNonNull(clientId);
        System.out.println("Deleting client");
        this.ClientRepository.delete(clientId);

    }

    @Override
    public clientEntity updateClient(clientEntity client) {
        requireNonNull(client);
        this.ClientRepository.update(client);
        return client;
    }
    @Override
    public void printClient(clientEntity client){
        System.out.println(
        "Client ID: " + client.getId()+
                "\nClient Name: " +client.getName()
                +"\nClient LastName " +client.getLastname()+
                "\nClient PhoneNumber" +client.getPhone_number()+
                "\nClient Email " +client.getEmail()
        );
    }
    
}
