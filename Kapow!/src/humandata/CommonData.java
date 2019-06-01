/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humandata;


import java.sql.Date;
import java.util.Scanner;

/**
 * Class of Common datas between Archive and User.
 * This class have the atributes: Name and Date shared with Archive and user.
 * @author Kitsu.
 */
public class CommonData {
    String name;

    public CommonData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
