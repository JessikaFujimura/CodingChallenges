package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

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
            case "-w" :
                long words = 0;
                try {
                    Stream<String> fileLines = Files.lines(Paths.get(nameFile), Charset.defaultCharset());
                    words= fileLines.flatMap(l -> Arrays.stream(l.split("\\s+"))
                            .filter(i -> !i.isBlank() || !i.isEmpty()))
                            .count();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("%d %s\n", words, nameFile);
                // Primeira Resolução
//                try(LineNumberReader numberReader = new LineNumberReader(new FileReader(file))){
//                    words = 0;
//                    String currentLine = numberReader.readLine();
//                    while ( currentLine != null ){
//                        if(!currentLine.isEmpty() && !currentLine.isBlank()){
//                            String[] lineWords = currentLine.strip().split("\\s+");
//                            words += lineWords.length;
//                        }
//                        currentLine = numberReader.readLine();
//                    }
//                    System.out.printf("%d %s\n", words,nameFile );
//                } catch (IOException ex){
//                    ex.printStackTrace();
//                }
                break;
        }
    }
    
    
}