package org.java;

import java.time.MonthDay;

public class UserUtils {

    public static boolean ageIsValid(int age) {
        return age >= 0 && age <= 120;
    }

    public static String getZodiacSign(int month) {
        return switch (month) {
            case 1 -> "Capricorn";
            case 2 -> "Aquarius";
            case 3 -> "Pisces";
            case 4 -> "Aries";
            case 5 -> "Taurus";
            case 6 -> "Gemini";
            case 7 -> "Cancer";
            case 8 -> "Leo";
            case 9 -> "Virgo";
            case 10 -> "Libra";
            case 11 -> "Scorpio";
            case 12 -> "Sagittarius";
            default -> "Unknown";
        };
    }

    public static boolean canLaunchGames(String os) {
        return os != null && os.equalsIgnoreCase("Windows");
    }
}
