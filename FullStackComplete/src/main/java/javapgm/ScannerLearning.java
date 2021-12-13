package javapgm;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ScannerLearning {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i=0;
        while(sc.hasNext()) {
            System.out.println(++i+" "+sc.nextLine());
        }
    }
}

