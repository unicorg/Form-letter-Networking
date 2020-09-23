/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict4361.tranlam_networking;
import java.net.URL;
import java.net.URI;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.io.InputStreamReader;

/**
 *
 * @author Lam Tran
 */
public class WriteURI {
    private URI uri;
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    
    public WriteURI (URI uriField) throws IOException{
        this.uri = uriField;
        openConnection();
    }
    
    public WriteURI (String uriField) throws URISyntaxException, IOException {
        this.uri = new URI(uriField);
        openConnection();
    }
    
    public void openConnection() throws IOException {
        this.socket = new Socket(uri.getHost(), uri.getPort());
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter = new PrintWriter(socket.getOutputStream(), true);
    }
    
    //A method called sendMessage that takes a String parameter, and uses println to send it on the PrintWriter object.
    public void sendMessage (String sendMsg) {
        printWriter.println(sendMsg);
    }
    
    //A method called receiveMessage that returns a String which it gets by calling readLine() on the BufferedReader
    public String receiveMessage() throws IOException{
        return bufferedReader.readLine();
    }
    //A main method that creates a WriteURI from the URI found in hw7server.uri
    public static void main (String[] args) throws URISyntaxException, IOException{
        WriteURI instanceURI = new WriteURI("telnet://192.168.1.19:52665/");
        instanceURI.sendMessage("Unicorg");
        System.out.println(instanceURI);
        
    }
}
