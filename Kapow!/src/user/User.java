/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.Date;

import common.CommonData;
import exception.InvalidGenreException;

/**
 * 
 * This class is for User data info and constructor
 *
 * @author Kitsu.
 */
public class User extends CommonData {

	/**
	 * 
	 * Class for User to create a User with Password. This class have the atributes:
	 * Telephone, Country, City, PostalCode, DNI, mail, Name User, Pass User.
	 *
	 * @author Kitsu.
	 */
	
	
	//Var needed in this class
    private String lastName;
    private int tele;
    private boolean genre;
    private String country;
    private String city;
    private int cp;
    private String dni;
    private String mail;
    private String nUser;
    private String passUser;

    //Constructor
    public User(String name, Date dateUser, String lastName, int tele, char genre, String country, String city, int cp, String dni, String mail, String nUser, String passUser) throws InvalidGenreException {

        super(name, dateUser);
        this.lastName = lastName;
        this.tele = tele;
        this.setGenre(genre);
        this.country = country;
        this.city = city;
        this.cp = cp;
        this.dni = dni;
        this.mail = mail;
        this.nUser = nUser;
        this.passUser = passUser;
    }
    
    //Get the last Name of the user
    public String getLastName() {
        return lastName;
    }
    
    //Set the lastName of the user
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
  //Get the last Telephone of the user
    public int getTele() {
        return tele;
    }
    //Set the telephone of the user
    public void setTele(int tele) {
        this.tele = tele;
    }
  //Get the last Genre of the user, this only can be F or M
    public char getGenre() {
        if (this.genre) {
            return 'F';
        } else {
            return 'M';
        }
    }
    
    
    //Exception for the genre of the user
    public final void setGenre(char genre) throws InvalidGenreException {
        if (genre == 'f' || genre == 'F') {
            this.genre = true;
        } else if (genre == 'm' || genre == 'M') {
            this.genre = false;
        } else {
            throw new InvalidGenreException(genre + " is not"
                    + "a valid genre. Only m and f are accepted.");
        }
    }
    
    //Get the country of the user
    public String getCountry() {
        return country;
    }
    
    //Set the country of the user
    public void setCountry(String country) {
        this.country = country;
    }
    
    //Get the city of the user
    public String getCity() {
        return city;
    }
    //Set the city of the user
    public void setCity(String city) {
        this.city = city;
    }
    //Get the PostalCode of the user
    public int getCp() {
        return cp;
    }
    //Set the PostalCode of the user
    public void setCp(int cp) {
        this.cp = cp;
    }
    //Get the DNI of the User
    public String getDni() {
        return dni;
    }
    //Set the DNI of the user
    public void setDni(String dni) {
        this.dni = dni;
    }
    //Get the email of the user
    public String getMail() {
        return mail;
    }
    //Set the email of the user
    public void setMail(String mail) {
        this.mail = mail;
    }
    //Get the NickName of the user
    public String getnUser() {
        return nUser;
    }
    //Set the nickName of the user
    public void setnUser(String nUser) {
        this.nUser = nUser;
    }
    //Get the password of the user	
    public String getPassUser() {
        return passUser;
    }
    //Set the password of the user
    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

}
