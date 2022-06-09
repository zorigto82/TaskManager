package ru.netology.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static String pickRandomChar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите задачу из списка или введите своё");
            System.out.println("1. Сходить в магазин" + "\n" + "2. Вынести мусор" + "\n" + "3. Убраться в доме" + "\n" + "4. Своя задача");
            String a = "Сходить в магазин";
            String b = "Вынести мусор";
            String c = "Убраться в доме";
            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    return a;
                case 2:
                    return b;
                case 3:
                    return c;
                case 4:
                    System.out.println("Введите задачу");
                    return scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (
                Socket socket = new Socket("localhost", 8989);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            out.println("task:" + pickRandomChar());
            System.out.println(in.readLine());
        }
    }
}