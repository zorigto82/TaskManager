package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Todos {
    List<String> list = new ArrayList<>();

    public void addTask(String task) {
        list.add(task + " ");
    }

    public void removeTask(String task) {
        list.remove(task);
    }

    public String getAllTasks() {
        Stream<String> stream = list.stream()
                .sorted(Comparator.naturalOrder());
        return stream.collect(Collectors.joining());
    }


}
