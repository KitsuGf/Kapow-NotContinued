/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivetype;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

import common.CommonData;

/**
 * Class Data to create information from the Archive(Comics).
 * This class have the atributes: Number of Page, Saga Complete or not, Franquice, Distributor, Description, Saga, Author and Genre.
 * @author Kitsu.
 */

//This class extends from CommonData class what have two atributes bwetween comic and user
public class Archive extends CommonData {
 
	
	//Vars for constructor
    int nPag;
    String sComp;
    String fran;
    String dist;
    String saga;
    String author;
    String genre;

    
    //Data for constructor
    public Archive(String name, Date dateUser, int nPag, String sComp, String fran, String dist, String saga, String author, String genre) {
        super(name, dateUser);
        this.nPag = nPag;
        this.sComp = sComp;
        this.fran = fran;
        this.dist = dist;
        this.saga = saga;
        this.author = author;
        this.genre = genre;
    }

    
    //Get the pag number of the comic
    public int getnPag() {
        return nPag;
    }

    public void setnPag(int nPag) {
        this.nPag = nPag;
    }

   
    //Get if the saga is completed or not with yes or no
    public String getsComp() {
		return sComp;
	}


	public void setsComp(String sComp) {
		this.sComp = sComp;
	}

	 //Get the franquice name of the comic
	public String getFran() {
        return fran;
    }

    public void setFran(String fran) {
        this.fran = fran;
    }
    //Get the distributor name of the comic
    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    //Get the saga name of the comic
    public String getSaga() {
        return saga;
    }

    public void setSaga(String saga) {
        this.saga = saga;
    }
    //Get the author name of the comic
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    //Get the genre of the comic
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
    
    
    
   //Functions for walk on directory tree
    
    
   //listarGeneros is a fuction for list the generes of the comics
   public static File[]  listarGeneros() {
    
	   String path = "./comic"; 

       String files;
       File folder = new File(path);
       File[] listOfFiles = folder.listFiles(); 

       for (int i = 0; i < listOfFiles.length; i++)         {

           if (!listOfFiles[i].isFile())             {
               files = listOfFiles[i].getName();
               System.out.println(files);
           }
           
       }
	return listOfFiles;
    	
    	
    	
    	
       
    	
 /* Aquí la carpeta donde queremos buscar
    String path = "./comic"; 

    String files;
    File folder = new File(path);
    File[] listOfGenres = folder.listFiles(); 

    for (int i = 0; i < listOfGenres.length; i++)         {
    	System.out.println(listOfGenres[i]);
        if (listOfGenres[i].isDirectory()) {
            File[] listOfComics = listOfGenres[i].listFiles();
            
           for (int j = 0; j < listOfComics.length; j++) {
				if(listOfComics[j].isDirectory()) {
					System.out.println(listOfComics[j].getName());
				}
			}
           
        }
  }
		        
}
    
    
    
    //}
    

   // public static String  listarComics(String genero) {
    	
   // }
    
    
    /*public static ArrayList<Archive> listarNumeros(String genre,String name){
    	 String path = "./comic/"+genre+"/"+getName(); 
    	 ArrayList<Archive> numeros=new ArrayList<Archive>();
	        File folder = new File(path);
	        File[] comics = folder.listFiles(); 

	        for (int i = 0; i < comics.length; i++){
	        	numeros.add(new Archive(Aqui van todos los archivos));
	        }
	        return numeros;
    }*/
    
}}
