package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commandLine = sc.nextLine();
        String[] parameters = commandLine.split(" ");
        String nameFile = parameters[2];
        File file = new File(nameFile);
        switch (parameters[1]){
            case "-c" :  System.out.printf("%d %s",file.length(), nameFile ); break;
            case "-l" :
                long lines = 0;
                try(LineNumberReader numberReader = new LineNumberReader(new FileReader(file))){
                    while (numberReader.readLine() != null)
                        lines = numberReader.getLineNumber();
                    System.out.printf("%d %s\n", lines,nameFile );
                } catch (IOException ex){
                    ex.printStackTrace();
                }
                break;
        }
    }
    
    
}