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
 * Class for User to create a User with Password. This class have the atributes:
 * Telephone, Country, City, PostalCode, DNI, mail, Name User, Pass User.
 *
 * @author Kitsu.
 */
public class User extends CommonData {

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTele() {
        return tele;
    }

    public void setTele(int tele) {
        this.tele = tele;
    }

    public char getGenre() {
        if (this.genre) {
            return 'f';
        } else {
            return 'm';
        }
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getnUser() {
        return nUser;
    }

    public void setnUser(String nUser) {
        this.nUser = nUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

}
