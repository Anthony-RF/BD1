/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.entity;

/**
 *
 * @author yarman
 */
public class clientEntity {
    private int  id;
    private String name;
    private String lastname;
    private String email;
    private String phone_number;

    public clientEntity( ) {
        
       
    }
    public clientEntity( String name, String lastname, String email, String phone_number) {
        
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
    }
     public clientEntity( int id,String name, String lastname, String email, String phone_number) {
        this.id=id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
    }
     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    
    
}
