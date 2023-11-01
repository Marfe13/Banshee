package com.mycompany.banshee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Banshee {
    public static String cancion = "src\\main\\java\\folders\\canciones.txt";
    public static ArrayList<Cancion> ListaCancion=new ArrayList<Cancion>();
    
    public static String file = "src\\main\\java\\folders\\clientes.txt";
    public static ArrayList<Cliente> ListaCliente=new ArrayList<Cliente>();
    
    public static void main(String[] args) throws ParseException{
        leerDatosCliente();
        leerDatosCancion();
           
        Scanner entrada = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        
        int opcion=-1;
        Display display = new Display();
        while(opcion!=5){
            display.Menu();
            opcion = entrada.nextInt();
            switch(opcion){
                case 1 -> {
                    System.out.println("1. Agregar clientes");
                    System.out.println("2. Agregar canciones");
                    opcion = entrada.nextInt();
                    if(opcion == 1){
                        Cliente cliente = new Cliente();
                        ListaCliente.add(cliente.crearDato());
                        System.out.println("Presione un número para volver al menu");
                        opcion = entrada.nextInt();
                    }
                    else if(opcion == 2){
                        Cancion cancion = new Cancion();
                        ListaCancion.add(cancion.crearDato());
                        System.out.println("Presione un número para volver al menu");
                        opcion = entrada.nextInt();
                    }
                }
                
                case 2 -> {
                    System.out.println("1. Mostrar lista de clientes");
                    System.out.println("2. Mostrar lista de canciones");
                    opcion = entrada.nextInt();
                    if(opcion == 1){
                        Cliente cliente = new Cliente();
                        cliente.leerDato(ListaCliente);
                        System.out.println("Ingrese un número para volver al menu");
                        opcion = entrada.nextInt();
                    }
                    else if(opcion == 2){
                        Cancion cancion = new Cancion();
                        cancion.leerDato(ListaCancion);
                        System.out.println("Ingrese un número para volver al menu");
                        opcion = entrada.nextInt();
                    }
                }
                
                case 3 -> {
                    System.out.println("1. Modificar lista de clientes");
                    System.out.println("2. Modificar lista de canciones");
                    opcion = entrada.nextInt();
                    if(opcion == 1){
                        System.out.println("Ingrese ID de cliente a modificar");
                        int IdCliente = entrada.nextInt();
                        ListIterator<Cliente>li= ListaCliente.listIterator();
                        boolean found = false;
                        while(li.hasNext()){
                            Cliente e = li.next();
                            if(e.getIdCliente() == IdCliente){
                                System.out.println("Ingrese nombre de cliente");
                                String nombre = string.nextLine();
                                System.out.println("Ingrese tipo de cliente");
                                int tipo = entrada.nextInt();
                                li.set(new Cliente(IdCliente, nombre, tipo));
                                found = true;
                            }
                        }
                            if(!found){
                                System.out.println("ID no encontrada");
                                System.out.println("----------------");
                                System.out.println("Ingrese un número para volver al menu");
                                opcion = entrada.nextInt();
                            }
                            else{
                                System.out.println("¡Registro modificado exitosamente!");
                                System.out.println("----------------");
                                System.out.println("Ingrese un número para volver al menu");
                                opcion = entrada.nextInt();
                            }
                        
                        
                    }
                    else if(opcion == 2){
                        System.out.println("Ingrese ID de cancion a modificar");
                        int IdCancion = entrada.nextInt();
                        ListIterator<Cancion>lista= ListaCancion.listIterator();
                        boolean found = false;
                        while(lista.hasNext()){
                            Cancion i = lista.next();
                            if(i.getIdCancion() == IdCancion){
                                System.out.println("Ingrese nombre de la cancion");
                                String nombre = string.nextLine();
                                System.out.println("Ingrese al autor");
                                String autor = string.nextLine();
                                System.out.println("Ingrese el genero, recordar que son numeros enteros del 1 al 24");
                                int genero = entrada.nextInt();
                                lista.set(new Cancion(nombre, autor, genero, IdCancion));
                                found = true;
                            }
                        }
                            if(!found){
                                System.out.println("ID no encontrada");
                                System.out.println("----------------");
                                System.out.println("Ingrese un número para volver al menu");
                                opcion = entrada.nextInt();
                            }
                            else{
                                System.out.println("¡Registro modificado exitosamente!");
                                System.out.println("----------------");
                                System.out.println("Ingrese un número para volver al menu");
                                opcion = entrada.nextInt();
                            }
                    }
                }
                
                case 4 -> {
                    System.out.println("1. Eliminar clientes");
                    System.out.println("2. Eliminar canciones");
                    opcion = entrada.nextInt();
                    if(opcion == 1){
                        System.out.println("Ingrese la ID del cliente a eliminar");
                        int IdCliente = entrada.nextInt();
                        ListIterator<Cliente>li= ListaCliente.listIterator();
                        boolean found = false;
                        while(li.hasNext()){
                            Cliente d = li.next();
                            if(d.getIdCliente() == IdCliente){
                                li.remove();
                                found = true;
                            }
                        }
                        if(!found){
                            System.out.println("ID no encontrada");
                            System.out.println("----------------");
                            System.out.println("Ingrese un número para volver al menu");
                            opcion = entrada.nextInt();
                        }
                        else{
                            System.out.println("¡Registro eliminado exitosamente!");
                            System.out.println("----------------");
                            System.out.println("Ingrese un número para volver al menu");
                            opcion = entrada.nextInt();
                        }
                    }
                    else if(opcion == 2){
                        System.out.println("Ingrese la ID de la canción a eliminar");
                        int IdCancion = entrada.nextInt();
                        ListIterator<Cancion>li= ListaCancion.listIterator();
                        boolean found = false;
                        while(li.hasNext()){
                            Cancion d = li.next();
                            if(d.getIdCancion() == IdCancion){
                                li.remove();
                                found = true;
                            }
                        }
                        if(!found){
                            System.out.println("ID no encontrada");
                            System.out.println("----------------");
                            System.out.println("Ingrese un número para volver al menu");
                            opcion = entrada.nextInt();
                        }
                        else{
                            System.out.println("¡Registro eliminado exitosamente!");
                            System.out.println("----------------");
                            System.out.println("Ingrese un número para volver al menu");
                            opcion = entrada.nextInt();
                        }
                    }
                }
            }
        }
        System.out.println("Hasta luego!");
        
    }
    
    public static void leerDatosCliente(){
        try {
            BufferedReader archivo = new BufferedReader(new FileReader(file));
            
             int i=0;
             String linea;
             String [] campos=new String[2];
              while ((linea = archivo.readLine()) != null) {
                //System.out.println();
                if(i>0){
                   campos=linea.split(";");
                   ListaCliente.add(new Cliente(Integer.valueOf(campos[0]),campos[1],Integer.valueOf(campos[2])));
                //tratamiento para separar los ';'
                }
                i++;
             }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Banshee.class.getName()).log(Level.SEVERE, null, ex);
        
        }catch (IOException e){
    }
    }
        
    public static void leerDatosCancion(){
        try {
            BufferedReader archivo = new BufferedReader(new FileReader(cancion));
            
             int i=0;
             String linea;
             String [] campos=new String[3];
              while ((linea = archivo.readLine()) != null) {
                //System.out.println();
                if(i>0){
                   campos=linea.split(";");
                   ListaCancion.add(new Cancion((campos[0]),campos[1],Integer.valueOf(campos[2]),Integer.valueOf(campos[3])));
                //tratamiento para separar los ';'
                }
                i++;
             }
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Banshee.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException e){
        
        }
            
        }
}
