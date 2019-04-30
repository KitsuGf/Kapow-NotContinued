/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import humandata.CommonData;
import java.util.Scanner;


/**
 * Class for User to create a User with Password.
 * This class have the atributes: Telephone, Country, City, PostalCode, DNI, mail, Name User, Pass User.
 * @author Kitsu.
 */
public class User extends CommonData{

    Scanner sc = new Scanner(System.in);
    int tele = sc.nextInt();
    String country = sc.nextLine();
    String city = sc.nextLine(); 
    String cp = sc.nextLine();
    String dni = sc.nextLine();
    String mail = sc.nextLine();
    String nUser = sc.nextLine();
    String passUser = sc.nextLine();

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public int getTele() {
        return tele;
    }

    public void setTele(int tele) {
        this.tele = tele;
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

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
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
