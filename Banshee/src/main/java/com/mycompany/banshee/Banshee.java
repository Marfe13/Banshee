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
    public static void main(String[] args) throws ParseException, InterruptedException, CsvValidationException{
        // sector login
        login_app login = new login_app();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        login.setVisible(true);
    }
}

