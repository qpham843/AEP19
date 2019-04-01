package edu.berkeley.aep;

public class ReverseString {
    public static String reverse(String s) {
        if (s.length() < 2) {
            return s;
        } else {
            return reverse(s.substring(1)) + s.substring(0, 1);
        }
    }
}
