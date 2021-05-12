package com.company;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.lang.Integer;
import java.lang.Exception;
import java.util.TreeMap;

public class RomeNumber {
    private static final Map<String, Integer> romanNumeralsMap = new HashMap<>();

    static {
        romanNumeralsMap.put("I", 1);
        romanNumeralsMap.put("II", 2);
        romanNumeralsMap.put("III", 3);
        romanNumeralsMap.put("IV", 4);
        romanNumeralsMap.put("V", 5);
        romanNumeralsMap.put("VI", 6);
        romanNumeralsMap.put("VII", 7);
        romanNumeralsMap.put("VIII", 8);
        romanNumeralsMap.put("IX", 9);
        romanNumeralsMap.put("X", 10);
    }

    private static final TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static void Calculate(String inputString) throws Exception {
        String ro1 = inputString.split(" ")[0];
        String ro2 = inputString.split(" ")[2];
        if (!romanNumeralsMap.containsKey(ro1) || !romanNumeralsMap.containsKey(ro2))
            throw new Exception("Ошибка");
        //проверка арифметической операции и вызов процедуры
        switch ((inputString.split(" ")[1])) {
            case ("+"):
                Addition(ro1, ro2);
                break;
            case ("*"):
                Multiplication(ro1, ro2);
                break;
            case ("-"):
                Subtraction(ro1, ro2);
                break;
            default:
                Division(ro1, ro2);
                break;
        }
    }

    private static void Multiplication(String ro1, String ro2) {
        int res = romanNumeralsMap.get(ro1) * romanNumeralsMap.get(ro2);
        System.out.println(toRoman(res));
    }

    private static void Addition(String ro1, String ro2) {
        int res = romanNumeralsMap.get(ro1) + romanNumeralsMap.get(ro2);
        System.out.println(toRoman(res));
    }

    private static void Subtraction(String ro1, String ro2) {
        if (romanNumeralsMap.get(ro1) <= romanNumeralsMap.get(ro2)) {
                throw new ArithmeticException("В римских цифрах нет минуса и ноля.");}
        else { int res = romanNumeralsMap.get(ro1) - romanNumeralsMap.get(ro2);
                System.out.println(toRoman(res));}
        }



    private static void Division(String ro1, String ro2) throws Exception {
        if (romanNumeralsMap.get(ro1) < romanNumeralsMap.get(ro2)) {
            throw new Exception("В римских цифрах нет дробей.");
        }
            else {
                int res = romanNumeralsMap.get(ro1) / romanNumeralsMap.get(ro2);
                System.out.println(toRoman(res));
            }
        }

        //функция честно стырена в интернете
        private static String toRoman ( int number){
            int l = map.floorKey(number);
            if (number == l) {
                return map.get(number);
            }
            return map.get(l) + toRoman(number - l);
        }
    }




