/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict4361.tranlam_networking;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Lam Tran
 */
public class Main {
    public static void main (String[] args) throws MalformedURLException, IOException, URISyntaxException{
        System.out.print ("Enter the URL: ");
        Scanner scanner = new Scanner (System.in);
        URL inputURL = new URL (scanner.nextLine());
        ReadURL testURL1 = new ReadURL(inputURL);
        URL convertedURL = testURL1.getContentAsURI().toURL();
        ReadURL testURL2 = new ReadURL(convertedURL);
        String secondContent = testURL2.getContent();
        System.out.println(inputURL);
        System.out.println(convertedURL);
        System.out.println(secondContent);
    }  
}
