package main.java.by.intro.converter;

import java.util.ArrayList;
import java.util.List;

public class NotationConverter {

    public static void main(String[] args) {

    }

    private int toArabic(String romanNotation) throws InvalidValueException {
        List<Integer> list = new ArrayList<>();

        if (romanNotation == null || "".equals(romanNotation)) {
            throw new InvalidValueException(
                    "String must contain only valid roman numerals [I, V, X, L, C, D, M].");
        }

        for (int i = romanNotation.length() - 1; i >= 0; i--) {
            char c = romanNotation.charAt(i);
            switch (c) {
                case 'I':
                    list.add(1);
                    break;
                case 'V':
                    list.add(5);
                    break;
                case 'X':
                    list.add(10);
                    break;
                case 'L':
                    list.add(50);
                    break;
                case 'C':
                    list.add(100);
                    break;
                case 'D':
                    list.add(500);
                    break;
                case 'M':
                    list.add(1000);
                    break;
                default:
                    throw new InvalidValueException(
                            "String must contain only valid roman numerals [I, V, X, L, C, D, M].");
            }
        }

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size() && list.get(i + 1) < list.get(i)) {
                sum += list.get(i) - list.get(i + 1);
                i++;
            } else {
                sum += list.get(i);
            }
        }
        return sum;
    }
}

class InvalidValueException extends RuntimeException {

    public InvalidValueException(String message) {
        super(message);
    }
}

