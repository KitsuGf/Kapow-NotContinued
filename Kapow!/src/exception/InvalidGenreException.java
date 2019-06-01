/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 * Class for exceptions of the application.
 * @author Kitsu
 */
public class InvalidGenreException extends java.lang.Exception {
    public InvalidGenreException(String m){
        super(m);
    }
}
