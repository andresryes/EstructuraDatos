import org.apache.commons.lang.time.StopWatch;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.LinkedList;


import java.util.concurrent.TimeUnit;

public class Main{
    public static BTree bTree = new BTree();
    public static LinkedList linkedlist = new LinkedList();

    public static void main(String[] args){
      readText();
      Scanner in = new Scanner(System.in);
      Scanner st = new Scanner(System.in);

        StopWatch stopWatch = new StopWatch();
        String key = "zwitterionic";

        //System.out.println("luis".compareTo("luisa"));
        System.out.println("---------------------------------");
        //search in the tree
        Instant starts = Instant.now();

        stopWatch.start();
        if (bTree.search(key)) {
            System.out.println(key + " is founded");
        } else {
            System.out.println(key + " is NOT founded");
        }
        stopWatch.stop();

        Instant ends = Instant.now();
        //System.out.println(Duration.between(starts, ends));
        System.out.println("Time: " + Duration.between(starts, ends));
        System.out.println("---------------------------------");
        stopWatch.reset();
        stopWatch.start();
          //search in the linked list
        Instant starts1 = Instant.now();
        if (linkedlist.contains(key)) {
            System.out.println(key + " is founded");
        } else {
            System.out.println(key + " is NOT founded");
        }
        Instant ends1 = Instant.now();
        stopWatch.stop();
        System.out.println("Time: " + Duration.between(starts1, ends1));
        st.next();

    }

    public static void readText(){
        try (BufferedReader br = new BufferedReader(new FileReader("/home/andres/Documents/EstructuraDatos/Tarea11/src/main/java/words_alpha.txt"))) {
           String sCurrentLine;

           while ((sCurrentLine = br.readLine()) != null) {
                // System.out.println(sCurrentLine);
               bTree.insert(sCurrentLine);
               linkedlist.add(sCurrentLine);
           }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
