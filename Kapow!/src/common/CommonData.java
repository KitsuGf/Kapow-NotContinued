/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.sql.Date;

/**
 * Class of Common data between Archive and User.
 * This class have the atributes: Name and Date shared with Archive and user.
 * @author Kitsu.
 */
public class CommonData {
    String name;
    Date dateUser;

    public CommonData(String name, Date dateUser) {
        this.name = name;
        this.dateUser = dateUser;
    }
    
    public Date getDateUser() {
		return dateUser;
	}

	public void setDateUser(Date dateUser) {
		this.dateUser = dateUser;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
