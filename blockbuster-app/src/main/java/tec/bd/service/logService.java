/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tec.bd.service;

import java.util.List;
import tec.bd.entity.blockbusterLog;
import tec.bd.entity.clientEntity;

/**
 *
 * @author yarman
 */
public interface logService {
    List<blockbusterLog> getLogs();
    List<blockbusterLog> getFirstNLogs(int n);
    void printLog (blockbusterLog log);
}
