package org.java;

public class StringUtils {

    public static boolean isPalindrome(String input) {
        if (input == null) return false;
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }

    public static String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    public static String concatenate(String a, String b) {
        return (a == null ? "" : a) + (b == null ? "" : b);
    }
}
