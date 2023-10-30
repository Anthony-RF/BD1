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
public class rentalsEntity {
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public rentalsEntity(int ID, Date rentalDate, int clientID, int movieID) {
        this.ID = ID;
        this.rentalDate = rentalDate;
        this.clientID = clientID;
        this.movieID = movieID;
    }
    public rentalsEntity( Date rentalDate, int clientID, int movieID) {
        
        this.rentalDate = rentalDate;
        this.clientID = clientID;
        this.movieID = movieID;
    }
    public rentalsEntity(  int clientID, int movieID) {
        
        
        this.clientID = clientID;
        this.movieID = movieID;
    }
    public rentalsEntity( ) {
        
       
    }
    private Date rentalDate;
    private int clientID;
    private int movieID;
    
}
