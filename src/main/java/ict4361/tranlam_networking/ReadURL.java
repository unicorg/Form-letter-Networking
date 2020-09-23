/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict4361.tranlam_networking;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import java.util.Scanner;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
        
/**
 *
 * @author Lam Tran
 */
public class ReadURL {
    
    private URL url;
    
    //A constructor which takes a String as a parameter, from which the URL is created
    public ReadURL (String inputURL) throws MalformedURLException {
        this.url = new URL(inputURL);
    }   
    
    //A constructor which takes a URL as a parameter, from which the URL is assigned
    public ReadURL (URL urlAssigned){
        this.url = urlAssigned;
    }
    
    //A constructor which takes a URI as a parameter, assigning to the URL with the toURL() method
    public ReadURL (URI uriAssigned) throws MalformedURLException {
        this.url = uriAssigned.toURL();
    }
    
    public String getContent() throws IOException{
        URLConnection connection = url.openConnection();
        BufferedReader reader = new BufferedReader (new InputStreamReader(connection.getInputStream()));
        String outputLine = reader.readLine();
        reader.close();
        return outputLine;
    }
    
    public URI getContentAsURI() throws IOException, URISyntaxException {
        URI outputURI = new URI(getContent());
        return outputURI;
    }
    
    public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException{
        URL inputURL = new URL("http://mysite.du.edu/~mschwart/ICT4361/hw7.problem1");
        ReadURL testURL = new ReadURL(inputURL);
        String contentURL = testURL.getContent();
        System.out.println(inputURL.toString());
        System.out.println(contentURL);
    }
}
