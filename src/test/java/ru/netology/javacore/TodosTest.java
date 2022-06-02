package ru.netology.javacore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    Todos todos;

    @BeforeEach
    void beforeEachMethod() {
        todos = new Todos();
    }

    @Test
    void testAddTask() {
        todos.addTask("Сходить в магазин");
        todos.addTask("Убраться в комнате");
        todos.addTask("Вынести мусор");
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