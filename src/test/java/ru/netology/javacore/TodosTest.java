package ru.netology.javacore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    Todos todos;
    List<String> result;

    @BeforeEach
    void beforeEachMethod() {
        todos = new Todos();
    }

    @Test
    void testAddTask() {
        todos.addTask("Сходить в магазин");
        todos.addTask("Убраться в комнате");
        todos.addTask("Вынести мусор");
        result = todos.getList();
        Collections.sort(result);

        List<String> expected = new ArrayList<>();
        expected.add("Сходить в магазин");
        expected.add("Убраться в комнате");
        expected.add("Вынести мусор");
        Collections.sort(expected);
        assertEquals(expected, result);
    }

    @Test
    void testRemoveTask() {
        List<String> expected = new ArrayList<>();
        expected.add("Сходить в магазин");
        expected.add("Вынести мусор");
        todos.addTask("Сходить в магазин");
        todos.addTask("Убраться в комнате");
        todos.addTask("Вынести мусор");
        todos.removeTask("Убраться в комнате");
        result = todos.getList();
        assertEquals(expected, result);
    }

    @Test
    void testGetAllTasks() {
        List<String> expected = new ArrayList<>();
        expected.add("Сходить в магазин");
        expected.add("Убраться в комнате");
        expected.add("Вынести мусор");
        Collections.sort(expected);
        todos.addTask("Сходить в магазин");
        todos.addTask("Убраться в комнате");
        todos.addTask("Вынести мусор");
        result = todos.getList();
        Collections.sort(result);
        assertEquals(expected, result);
    }
}