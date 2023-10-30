/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.repository;
import java.util.Date;
import tec.bd.entity.clientEntity;

/**
 *
 * @author Yarman
 */
public interface clientRepository extends CRUDRepository<clientEntity, Integer> {

    
    int callCreateClientProcedure(clientEntity client);
}
