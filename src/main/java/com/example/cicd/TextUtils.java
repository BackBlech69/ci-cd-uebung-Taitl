package com.example.cicd;

public class TextUtils {

    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        String reversed = new StringBuilder(input).reverse().toString();

        return input.equalsIgnoreCase(reversed);
    }

    public static int safeParseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println("Invalid number: " + s);
        }
        return 0;
    }
}
