package com.example.cicd;

public final class TextUtils {

    private TextUtils() {
        // Utility class - no instances
    }

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
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
