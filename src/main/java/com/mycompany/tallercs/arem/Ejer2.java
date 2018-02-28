/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tallercs.arem;
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Juan Camilo Mantilla
 */
public class Ejer2 {
    URL pagURL;
    public static void main(String[] args) throws Exception {
        Scanner pagina = new Scanner(System.in);
        System.out.print("Ingrese la página deseada: ");
        String pagStr = pagina.nextLine();
        try{
            System.out.println("\n");
            URL pagURL = new URL(pagStr);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(pagURL.openStream()))) {
                String inputLine = null;
                PrintWriter writer = new PrintWriter("resultado.html");                
                while ((inputLine = reader.readLine()) != null) {
                    //System.out.println(inputLine);
                    writer.println(inputLine);
                }
                writer.close();
                System.out.println("Página generada en el archivo resultado.html");
            }catch (IOException x) {
                System.err.println(x);
            }
        }
        catch (MalformedURLException e){
            System.out.println("Error, URL mal formado");
        }
        
        
    }
}
