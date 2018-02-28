/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tallercs.arem;
import java.net.*;
import java.io.*;

/**
 *
 * @author Juan Camilo Mantilla
 */
public class Ejer1 {
    public static void main(String[] args) throws Exception{
        URL google = new URL("http://www.google.com:80/index.html?search=hola#top");
        System.out.println("Protocolo: "+google.getProtocol());
        System.out.println("Autoridad: "+google.getAuthority());
        System.out.println("Host: "+google.getHost());
        System.out.println("Puerto: "+google.getPort());
        System.out.println("Path: "+google.getPath());
        System.out.println("Busqueda: "+google.getQuery());
        System.out.println("Archivo: "+google.getFile());
        System.out.println("Referencia: "+google.getRef());
    }
}
