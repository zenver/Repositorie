package com.company;
import java.lang.String;
import java.lang.Integer;
import java.lang.Exception;

public abstract class Arabian {
    public static void Calculate(String inputString) throws Exception {
        String str = inputString;
        String[] numb = str.split(" ");
        int op1 = Integer.parseInt(numb[0]);
        int op2 = Integer.parseInt(numb[2]);
        //проверка операндов на диапазон 1..10
        if ((op1 < 0 || op1 > 10) || (op2 < 0 || op2 > 10)) {
            throw new Exception("Ошибка");
            }
        String operation = numb[1];
        //проверка арифметической операции и вызов процедуры
        switch (operation) {
            case ("+"):
                Addition(op1, op2);
                break;
            case ("*"):
                Multiplication(op1, op2);
                break;
            case ("-"):
                Subtraction(op1, op2);
                break;
            default:
                Division(op1, op2);
                break;
        }
    }
    private static void Multiplication (int op1, int op2) {
        System.out.println(op1 * op2);
    }
    private static void Addition (int op1, int op2) {
        System.out.println(op1 + op2);
    }
    private static void Subtraction (int op1, int op2) {
        System.out.println(op1 - op2);
    }
    private static void Division (int op1, int op2) {
        if (op1 % op2 != 0 || op1 < op2)
            System.out.println("Дроби недопустимы!");
        else
        System.out.println(op1 / op2);
    }
}
