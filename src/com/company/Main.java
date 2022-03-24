package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        /*int[] array;
        array = new int[]{4, 5, 7, 11, 12, 15, 15, 21, 40, 45};
        System.out.println((third(array, 11)));*/

    }

    public static void first(){
        File file = new File("text.txt");
        int length = (int) file.length();
        try (FileInputStream stream = new FileInputStream(file);
             InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)
        ){
            char[] data = new char[length];
            int readBytes = reader.read(data, 0, length);
            if (readBytes != length){
                throw new IOException("File reading error.");
            }
            String text = new String(data);
            System.out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void second(){
        try(FileOutputStream fos = new FileOutputStream("text2.txt")) {

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            byte[] myText = new byte[0];
            try {
                String name = reader.readLine();
                myText = name.getBytes();
            } finally {
                fos.write(myText);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double third(int[] array, int value){
        int index = 0;
        int limit = array.length - 1;

        while (index <= limit){
            var point = Math.ceil((index + limit)/2);
            var entry = array[(int) point];
            if (value < point){
                index = (int) (point + 1);
                continue;
            }
            if (value < entry){
                limit = (int) (point - 1);
                continue;
            }
            return point;
        }
        return -1;
    }
}
