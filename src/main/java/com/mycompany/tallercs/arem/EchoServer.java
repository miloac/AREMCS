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
public class EchoServer {
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
            try{
                String lol ="fuffnc:h";
                boolean aa = lol.startsWith("func:");
                System.out.println(aa);
                Integer num = Integer.parseInt(inputLine);
                Integer res= num*num;
                outputLine = "Respuesta: " + res;
                out.println(outputLine);
                if (outputLine.equals("Respuesta: Bye."))
                break;
            }catch(NumberFormatException e){
                outputLine = "Error, ingrese un numero valido";
                out.println(outputLine);
                System.out.println("Valor invalido");
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
