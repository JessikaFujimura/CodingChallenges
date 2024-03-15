package org.example;

import java.io.File;
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
        }
    }
    
}