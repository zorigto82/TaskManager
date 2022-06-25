package ru.netology.javacore;

import com.google.gson.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(8989);) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                ) {
                    System.out.println("New connection accepted");
                    String line = in.readLine();
                    System.out.println(line);

                    JsonElement element = JsonParser.parseString(line);
                    JsonObject object = element.getAsJsonObject();
                    String type = object.get("type").getAsString();
                    String taskWithTag = object.get("task").getAsString();
                    String[] str = taskWithTag.split("#");
                    String task = str[str.length - 1];
                    switch (type) {
                        case "ADD":
                            todos.addTask(task);
                            break;
                        case "REMOVE":
                            todos.removeTask(task);
                            break;
                    }

                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
