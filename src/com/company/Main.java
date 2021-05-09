package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.String;
import java.lang.Exception;
import java.lang.ArithmeticException;


public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение типа 2 + 2 или римскими II + II.");
        String inputString = new BufferedReader(new InputStreamReader(System.in)).readLine().trim().replaceAll(" +", " "); // Принятие выражения от пользователя
        if (inputString.matches("^\\d{1,2}[ ][\\+\\-\\*\\/][ ]\\d{1,2}$")) Arabian.Calculate(inputString); // Проверка по примеру для Арабских чисел
        else if (inputString.matches("^[IVX]{1,4}[ ][\\+\\-\\*\\/][ ][IVX]{1,4}$")) RomeNumber.Calculate(inputString); // Проверка по примеру для Римских чисел
        else try {
                throw new ArithmeticException("Выражение не соответсвует задаче"); //Напишет, если пользователь введет что-то совсем не то.
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
    }
}