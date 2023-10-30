/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tec.bd.repository;

import java.util.List;
import tec.bd.entity.blockbusterLog;

/**
 *
 * @author yarman
 */
public interface LogRepository extends CRUDRepository<blockbusterLog, Integer> {
    List<blockbusterLog> findLastN(int n);
    
}
