package com.netcetera.codecamp.graphqldemo.repository;

import com.netcetera.codecamp.graphqldemo.type.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// TODO gcvetano 2017-10-07: replace this in-memory repository with spring data repository and entities from db
public class TaskRepository {

    private static final List<Task> tasks = new ArrayList<>();

    static {
        Task buyGift = new Task();
        buyGift.setId(UUID.randomUUID().toString());
        buyGift.setName("Buy Gift");
        buyGift.setDescription("Buy Gift for PCA for organizing CodeCamp");
        tasks.add(buyGift);
    }

    public static List<Task> getTasks() {
        return tasks;
    }

    public static void saveTask(Task task) {
        tasks.add(task);
    }
}
