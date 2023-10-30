/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tec.bd.repository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author yarman
 */
public interface CRUDRepository<T, ID extends Serializable> {
    List<T> findAll();
    Optional<T> findById (ID entityID);
    int save (T entity);
    void delete(ID entityID);
    T update(T entity);
}
