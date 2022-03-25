package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
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

    public static int forth(String text){
        final int[] CRC_TABLE = new int[256];
        for (var i = 0; i < 256; ++i){
            var code = i;
            for (var j = 0; j < 8; ++j){
                //code = (code & 0x01 ? 0xEDB88320 ^ (code >>> 1) : (code >>> 1)); //nie mam pojęcia o co tu chodzi
            }
            CRC_TABLE[i] = code;
        }
        var crc = -1;
        for (var i = 0; i < text.length(); ++i){
            var code = text.charAt(i);
            crc = CRC_TABLE[(code ^ crc) & 0xFF] ^ (crc >>> 8);
        }
        return (-1 ^ crc);
    }

    public static void fifth(){
        LocalTime time = LocalTime.now(); //lokalny
        System.out.println(time);

        Date globalTime = new Date(); //"globalny"
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println(globalTime);
    }

    public static void sixth(){
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
            var list = text.split("\n");
            int counter = 1;
            for (String elem : list) {
                System.out.println(counter + ": " + elem);
                counter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void seventh() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        User userObject = new User("John", 21);
        String userJson = objectMapper.writeValueAsString(userObject);

        System.out.println(userJson); // {"name":"John","age":21}
    }

    public static void eigth() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{ \"name\" : \"John\", \"age\" : \"21\" }";
        User user = objectMapper.readValue(json, User.class);
    }
}
