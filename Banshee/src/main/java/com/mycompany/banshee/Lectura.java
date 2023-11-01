package com.mycompany.banshee;

import com.opencsv.CSVReader;
//import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Lectura {
    private String Ruta, Ruta2;
    
    ArrayList<Cliente> ListaCliente = new ArrayList<Cliente>();
    ArrayList<Cancion> ListaCancion = new ArrayList<Cancion>();
    
    public Lectura(String Ruta, String Ruta2){
        this.Ruta=Ruta;
        this.Ruta2=Ruta2;
    }
    
    public void LeerCancion() throws CsvValidationException{
        File file = new File(this.Ruta);
        try {
            FileReader inputfile = new FileReader(file);
            CSVReader reader = new CSVReader(inputfile);
        
            String[] nextRecord;
            
            int i=0;
            while ((nextRecord = reader.readNext()) != null) {
                if(i>0)ListaCancion.add(new Cancion(nextRecord[0],nextRecord[1],Integer.valueOf(nextRecord[2]),Integer.valueOf(nextRecord[3])));
                  
                
                i++;
            }
            
        
        }catch (IOException e) {
        e.printStackTrace();
        }
    }
    
    public void LeerCliente() throws CsvValidationException{
        File file = new File(this.Ruta2);
        try {
            FileReader inputfile = new FileReader(file);
            CSVReader reader = new CSVReader(inputfile);
        
            String[] nextRecord;
            
            int i=0;
            while ((nextRecord = reader.readNext()) != null) {
                
                //System.out.println(nextRecord[4]);
                if(i>0)ListaCliente.add(new Cliente(Integer.valueOf(nextRecord[0]),nextRecord[1],Integer.valueOf(nextRecord[2])));
                  
            
                i++;

            }
            
        
        }catch (IOException e) {
        e.printStackTrace();
        }
    }
}
