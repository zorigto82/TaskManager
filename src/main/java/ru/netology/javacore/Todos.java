package ru.netology.javacore;

import java.util.*;

public class Todos {
    List<String> list = new ArrayList<>();

    public void addTask(String task) {
        list.add(task);
    }

    public void removeTask(String task) {
        list.remove(task);
    }

    public List<String> getAllTasks() {
        return list;
    }

}
