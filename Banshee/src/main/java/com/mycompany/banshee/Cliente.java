package com.mycompany.banshee;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private int IdCliente;
    private String nombre;
    private int tipo; // 1: Cliente - 2: Creador
    private Scanner entrada;
            
    
    Cliente(){
       entrada = new Scanner(System.in);
    }
    
    Cliente(int IdCliente, String nombre, int tipo){
        this.IdCliente = IdCliente;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    // accesor
    
    public int getIdCliente(){
        return this.IdCliente;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getTipo(){
        return this.tipo;
    }
    
    // mutadores
    
    public void setIdCliente(int IdCliente){
        this.IdCliente = IdCliente;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    
    public Cliente crearDato() throws ParseException{
        System.out.println("Ingrese el Nombre del Cliente");
        this.nombre = entrada.nextLine();
        System.out.println("Ingrese el ID del Cliente");
        this.IdCliente = entrada.nextInt();
        System.out.println("Ingrese el tipo de Cliente / Donde 1 = Cliente y 2 = Artista");
        this.tipo = entrada.nextInt();
    return new Cliente(this.IdCliente,this.nombre,this.tipo);
  }
    
    
    public void leerDato(ArrayList<Cliente> Lista){
            Lista.forEach(item->{
        System.out.println("-----------------------------");
        System.out.println("ID de Cliente: "+item.IdCliente);
        System.out.println("Nombre: "+item.nombre);
        switch(item.tipo){
            case 1-> System.out.println("Tipo Cliente");
            case 2-> System.out.println("Tipo Artista");
        }
        System.out.println("-----------------------------");
      });
    }
}