/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.service;

import java.util.List;
import static java.util.Objects.requireNonNull;
import tec.bd.entity.blockbusterLog;
import tec.bd.entity.rentalsEntity;
import tec.bd.repository.LogRepository;
import tec.bd.repository.rentalRepository;

/**
 *
 * @author yarman
 */
public class logServiceImpl implements logService{
    
    private final FeatureFlags featureFlags;
    private final LogRepository logRepository;
    
    public logServiceImpl(LogRepository logRepository , FeatureFlags featureFlags){
        requireNonNull(logRepository);
        requireNonNull(featureFlags);
        this.featureFlags=featureFlags;
        this.logRepository = logRepository;
       
        
    }
    @Override
    public List<blockbusterLog> getLogs() {
        return this.logRepository.findAll();
    }

    @Override
    public List<blockbusterLog> getFirstNLogs(int n) {
        return this.logRepository.findLastN(n);
    }
    
    @Override
    public void printLog(blockbusterLog log){
        System.out.println(
        "Log ID: " + log.getId()+
                "\nLog  TableName: " + log.getTableName()
                +"\nCreated on " +log.getCreatedOn()+
                "\nEntry text " + log.getEntryText()
                
        );
    }
}
