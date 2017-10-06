package com.netcetera.codecamp.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.netcetera.codecamp.graphqldemo.repository.TaskRepository;
import com.netcetera.codecamp.graphqldemo.type.Task;

import java.util.List;

public class Query implements GraphQLQueryResolver {

    public List<Task> tasks() {
        return TaskRepository.getTasks();
    }
}
