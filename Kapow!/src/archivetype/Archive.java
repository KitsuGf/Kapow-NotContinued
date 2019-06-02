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
 * 
 * @author Kitsu.
 */




public class Archive extends CommonData {
	
	
	/**
	 * Archive class
	 * 
	 * This class have the atributes: Number of Page, Saga Complete or not, Franquice, Distributor, Description, Saga, Author and Genre.
	 * 
	 * @param CommonData
	 */
 
	
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

    //Set the pag number of the comic
    public void setnPag(int nPag) {
        this.nPag = nPag;
    }

   
    //Get if the saga is completed or not with yes or no
    public String getsComp() {
		return sComp;
	}

    //Set if the saga is completed or not with yes or no
	public void setsComp(String sComp) {
		this.sComp = sComp;
	}

	 //Get the franquice name of the comic
	public String getFran() {
        return fran;
    }
	
	//Set the franquice name of the comic
    public void setFran(String fran) {
        this.fran = fran;
    }
    //Get the distributor name of the comic
    public String getDist() {
        return dist;
    }
    //Set the distributor name of the comic
    public void setDist(String dist) {
        this.dist = dist;
    }

    //Get the saga name of the comic
    public String getSaga() {
        return saga;
    }
    //Set the saga name of the comic
    public void setSaga(String saga) {
        this.saga = saga;
    }
    //Get the author name of the comic
    public String getAuthor() {
        return author;
    }
    //Set the author name of the comic
    public void setAuthor(String author) {
        this.author = author;
    }
    //Get the genre of the comic
    public String getGenre() {
        return genre;
    }
    //Set the genre of the comic
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
    
    
    
   //Functions for walk on directory tree
    
    
   //listarGeneros is a fuction for list the generes of the comics
   public static File[]  listarGeneros() {
    
	   //Make an string with the path of the proyect with the categories
	   String path = "./comic"; 
	   
	   
       String files;
       //File folder is now the path of the proyect
       File folder = new File(path);
       //Array called listOfFiles is and list from the files of the folder in the path
       File[] listOfFiles = folder.listFiles(); 
       //This bucle is for get a list of the files, when the bucle find one, start again the bucle to find anocher
       //The bucle stop when no more files finded.
       for (int i = 0; i < listOfFiles.length; i++)         {
    	   //If the bucle find something different of file, like a folder, get the name of the folder for console
           if (!listOfFiles[i].isFile()){
        	   //Files equals list the files witht he name
               files = listOfFiles[i].getName();
               //Print the files name
               System.out.println(files);
           }
           
       }
    //Return was needed because is an static function and need a return value,
    //in this case, the function is an array so the return need be an a array, 
    //and the array we want to return is the list of the files named.
	return listOfFiles;
    	
    	
    	
    	
  //Try repair this fuck*ng fuctions i can´t resolve.
    	
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
