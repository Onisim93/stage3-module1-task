package com.mjc.school.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageHelper {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private MessageHelper() {};

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            printMessage("Incorrect input. Try again.");
            return readString();
        }
    }

    public static int readOperation() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static long readId() {
        long id = 0;
        try {
            id = Long.parseLong(reader.readLine());
        }
        catch (IOException e) {
            MessageHelper.printMessage("Incorrect input. Id should be number. Try again.");
            return readId();
        }
        return id;
    }


}
