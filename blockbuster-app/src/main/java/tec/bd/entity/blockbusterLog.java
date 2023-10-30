/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.entity;

import java.util.Date;

/**
 *
 * @author yarman
 */
public class blockbusterLog {
    private int id;
    private String tableName;
 private Date createdOn;
    private String entryText;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getEntryText() {
        return entryText;
    }

    public void setEntryText(String entryText) {
        this.entryText = entryText;
    }

    public blockbusterLog(int id, String tableName, Date createdOn, String entryText) {
        this.id = id;
        this.tableName = tableName;
        this.createdOn = createdOn;
        this.entryText = entryText;
    }
   
}
