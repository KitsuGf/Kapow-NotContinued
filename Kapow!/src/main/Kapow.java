/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 * Pruebaasdadsa
 *
 * @author Kitsu
 */
public class Kapow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String main;
        int action = 0;
        System.out.println("Welcome to Kapow! Feel free for register yourself and start enjoy the BiblioComic! Select an option now:");
        String menu = "\n\nChoose action by number:"
                + "\n\t1 - Exit game"
                + "\n\t2 - Register new User"
                + "\n\t3 - Login User";
        System.out.println(menu);
        action = Integer.parseInt(sc.nextLine());
        switch (action) {
            case 1:
                System.out.println("The app will be closed, thanks for use me!");
                break;
            case 2:
                System.out.println("Come and register yourself here!");
                break;
            case 3:
                System.out.println("Here you can loging!");
                break;
                

        }
    }
}
