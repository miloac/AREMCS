/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tallercs.arem;

/**
 *
 * @author Juan Camilo Mantilla
 */
//Codigo tomado de las diapositivas
import java.net.*;
import java.io.*;
import java.lang.Math;
public class EchoServerFunc {
    
    private static String current = "cos";
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje:" + inputLine);
            if(inputLine.startsWith("func:")){
                String func = changeFunc(inputLine);
                try{
                    if(func.equals("")){
                        throw new Exception();
                    }
                }catch(Exception e){
                    outputLine = "Error, ingrese una funcion valida";
                    out.println(outputLine);
                    System.out.println("Entrada invalida"); 
                }
            }
            else{
                try{
                    Double num = Double.parseDouble(inputLine);
                    Double res =calcular(num);
                    outputLine = "Respuesta: "+ res;
                    out.println(outputLine);
                    if (outputLine.equals("Respuesta: Bye."))
                    break; 
                }
                catch(NumberFormatException e){
                    outputLine = "Error, ingrese un numero valido";
                    out.println(outputLine);
                    System.out.println("Entrada invalida");
                }
            }  
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    
    private static String changeFunc(String newFunc){
        String res = "";
        String func = newFunc.substring(5);
        switch(func){
            case "cos":
                current = "cos";
                break;
            case "sin":
                current = "sin";
                break;
            case "tan":
                current = "tan";
                break;
            default:
                res = "Error";
                break;
        }
        return res;
    }
    
    private static double calcular(double num){
        double res =0;
        switch(current){
            case "cos":
                res = Math.cos(res);
                break;
            case "sin":
                res = Math.sin(res);
                break;
            case "tan":
                res = Math.tan(res);
                break;
        }
        
        return res;
    }
    
}
