/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tallercs.arem;
import java.io.*;
import java.net.*;

/**
 *
 * @author 2116177
 */
public class Ejer2 {
    //FALTA TODO CREO
    public static void main(String[] args) throws Exception {
    URL google = new URL("http://www.google.com/");
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()))) {
        String inputLine = null;
        while ((inputLine = reader.readLine()) != null) {
            System.out.println(inputLine);
        }
    }catch (IOException x) {
        System.err.println(x);
    }
    }
}
