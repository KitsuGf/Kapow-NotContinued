/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.sql.Date;

/**
 * Class of Common data between Archive and User.
 * This class have the atributes: Name and Date shared with Archive and User.
 * @author Kitsu.
 */

public class CommonData {
	//Vars of the constructor
    String name;
    Date dateUser;
    
    //Data for constructor
    public CommonData(String name, Date dateUser) {
        this.name = name;
        this.dateUser = dateUser;
    }
    
    //Get the date from the user, this one is reutiliced for 
    //get the date from the comic
    public Date getDateUser() {
		return dateUser;
	}
    
    //Set the date from the user, this one is reutiliced for 
    //set the date from the comic
	public void setDateUser(Date dateUser) {
		this.dateUser = dateUser;
	}
	
	//Get the name, comic or name of the user
    public String getName() {
        return name;
    }
    //Set the name, comic or name of the user
    public void setName(String name) {
        this.name = name;
    }
    
}
