package ru.netology.javacore;

import com.google.gson.Gson;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    public Todos todos;
    public int port;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(8989);) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
                ) {
                    // обработка одного подключения
                    String line = in.readLine();
                    Gson gson = new Gson();
                    todos.addTask(line);
                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
