package ru.netology.javacore;

import java.util.*;

public class Todos {
    List<String> list = new ArrayList<>();

    public List<String> getList(){
        return list;
   }

    public void addTask(String task) {
        list.add(task);
    }

    public void removeTask(String task) {
        list.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(list);
        StringBuilder builder = new StringBuilder();
        for (String str : list) {
            builder.append(str).append(" ");
        }
        return builder.toString();
    }
    @Override
    public String toString() {
        return "Todos{" +
                "list=" + list +
                '}';
    }
}
