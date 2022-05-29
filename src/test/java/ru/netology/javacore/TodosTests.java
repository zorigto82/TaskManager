package ru.netology.javacore;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTests {
    Todos todos;

    @BeforeEach
    void beforeEachMethod() {
        todos = new Todos();
    }

    @Test
    void testAddTask() {
        todos.addTask("Сходить в магазин");
        todos.addTask("Убраться в комнате");
    }

    @Test
    void testRemoveTask() {
        todos.removeTask("Убраться в комнате");
    }

    @Test
    void testGetAllTasks() {
        todos.getAllTasks();
    }
}
