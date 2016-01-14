package org.cjug.slidekaraoke;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        List<String> slideUrlList = new ArrayList<>();
        
        BufferedReader slideFileReader = new BufferedReader(new FileReader("cjugSlideKaraoke.txt"));
        
        String fileLine;
        
        while((fileLine =slideFileReader.readLine()) != null)
        {
            slideUrlList.add(fileLine);
        }
        
        slideFileReader.close();
        
        Collections.shuffle(slideUrlList);
        
        slideUrlList.stream().forEach(randSlideUrl ->{
            String nextCommand = scanner.next();
            
            if(nextCommand.equalsIgnoreCase("exit"))
            {
                scanner.close();
                System.exit(0);
            }
            else{
                try {
                    Desktop.getDesktop().browse(new URI(randSlideUrl));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        

    }

}
