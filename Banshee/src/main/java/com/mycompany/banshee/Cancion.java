package com.mycompany.banshee;


import java.util.Scanner;
import java.text.ParseException;
import java.util.ArrayList;

public class Cancion {
  private String nombre;
  private String autor;
  private int genero;
  private int IdCancion;
  private Scanner entrada;

  Cancion(){
    entrada = new Scanner(System.in);
  }
  
  Cancion(String nombre, String autor, int genero, int IdCancion){
    this.nombre = nombre;
    this.autor = autor;
    this.genero = genero;
    this.IdCancion = IdCancion;
  }

  
  public String getNombre(){
    return this.nombre;
  }
    
  public String getAutor(){
    return this.autor;
  }
    
  public int getGenero(){
    return this.genero;
  }
  
  public int getIdCancion(){
    return this.IdCancion;
  }
  
    
  public void setNombre(final String nombre){
      this.nombre = nombre;
  }
    
  public void setAutor(final String autor){
      this.autor = autor;
  }
    
  public void setGenero(final int genero){
      this.genero = genero;
  }
  
  public void setIdCancion(final int IdCancion){
      this.IdCancion = IdCancion;
  }

  
  public Cancion crearDato() throws ParseException{
    System.out.println("Ingrese el Nombre de la Cancion");
    this.nombre = entrada.nextLine();

    System.out.println("Ingrese el Nombre del Autor de la Cancion"); 
    this.autor = entrada.nextLine();

    System.out.println("Ingrese la ID del género musical"); 
    this.genero = entrada.nextInt();
    
    System.out.println("Ingrese la ID de la cancion"); 
    this.IdCancion = entrada.nextInt();
    
    return new Cancion(this.nombre, this.autor,this.genero, this.IdCancion);
  }
  
}