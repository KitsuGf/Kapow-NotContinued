/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivetype;

import humandata.CommonData;

/**
 * Class Data to create information from the Archive(Comic, Manga...).
 * This class have the atributes: Number of Page, Saga Complete or not, Franquice, Distributor, Description, Saga, Author and Genre.
 * @author Kitsu.
 */
public class Archive extends CommonData {
    int nPag;
    boolean sComp;
    String fran;
    String dist;
    String desc;
    String saga;
    String author;
    String genre;
}
