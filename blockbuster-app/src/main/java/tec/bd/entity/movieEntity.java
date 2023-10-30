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
public class movieEntity {
    private int id;
    private String title;
    private Date releaseDate;
    private int categoryID;
    private int units_available;

    public categoryEntity getCategory() {
        return category;
    }

    public void setCategory(categoryEntity category) {
        this.category = category;
    }
    private categoryEntity category;

    public movieEntity(int id, String title, Date releaseDate, int categoryID, int units_available) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.categoryID = categoryID;
        this.units_available = units_available;
    }
    public movieEntity( String title, Date releaseDate, int categoryID, int units_available) {
        
        this.title = title;
        this.releaseDate = releaseDate;
        this.categoryID = categoryID;
        this.units_available = units_available;
    }
    
    public movieEntity( ) {
        
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getUnits_available() {
        return units_available;
    }

    public void setUnits_available(int units_available) {
        this.units_available = units_available;
    }
    
}
