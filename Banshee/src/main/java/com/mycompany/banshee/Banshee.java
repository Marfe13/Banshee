package com.mycompany.banshee;

import java.text.ParseException;
import java.util.Scanner;
import java.util.ListIterator;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;    
import java.util.concurrent.atomic.AtomicBoolean;
import com.opencsv.exceptions.CsvValidationException;

public class Banshee {
    public static Lectura lectura;
    public static void main(String[] args) throws ParseException, InterruptedException, CsvValidationException{
        // sector login
        login_app login = new login_app();
        login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        AtomicBoolean closed = new AtomicBoolean(false);
        login.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            synchronized(closed) {
                closed.set(true);
                closed.notify();
            }
            super.windowClosed(e);
            }
        } );

        login.setVisible(true);
        synchronized(closed) {
            while (!closed.get()) {
                closed.wait();
            }
        }
        
        //sector lectura csv
        lectura = new Lectura("src\\main\\java\\folders\\canciones.csv","src\\main\\java\\folders\\clientes.csv");
        lectura.LeerCancion();
        lectura.LeerCliente();
           
        Scanner entrada = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        
        //menu de texto
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
                        lectura.ListaCliente.add(cliente.crearDato());
                        System.out.println("Presione un número para volver al menu");
                        opcion = entrada.nextInt();
                    }
                    else if(opcion == 2){
                        Cancion cancion = new Cancion();
                        lectura.ListaCancion.add(cancion.crearDato());
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
                        cliente.leerDato(lectura.ListaCliente);
                        System.out.println("Ingrese un número para volver al menu");
                        opcion = entrada.nextInt();
                    }
                    else if(opcion == 2){
                        Cancion cancion = new Cancion();
                        cancion.leerDato(lectura.ListaCancion);
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
                        ListIterator<Cliente>li= lectura.ListaCliente.listIterator();
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
                        ListIterator<Cancion>lista= lectura.ListaCancion.listIterator();
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
                        ListIterator<Cliente>li= lectura.ListaCliente.listIterator();
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
                        ListIterator<Cancion>li= lectura.ListaCancion.listIterator();
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
}

