package com.example.cicd;

public final class NumberUtils {

    public static final int DEFAULT_LIMIT = 10;

    private NumberUtils() {
        // Utility class - no instances
    }

    // Magic Numbers bleiben vorerst bewusst erhalten (eigene Übung)
    public static boolean isSpecial(int n) {
        if (n % 3 == 0 || n % 5 == 0 || n % 7 == 0) {
            return true;
        }
        switch (n) {
            case 13, 17:
                return true;
            default:
                return false;
        }
    }
}
