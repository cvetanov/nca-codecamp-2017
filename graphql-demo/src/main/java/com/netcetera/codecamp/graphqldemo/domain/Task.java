package com.netcetera.codecamp.graphqldemo.domain;

import com.merapar.graphql.GraphQlFields;
import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Task implements GraphQlFields {

    @Override
    public List<GraphQLFieldDefinition> getQueryFields() {

        GraphQLFieldDefinition id = GraphQLFieldDefinition.newFieldDefinition()
                .name("id")
                .description("The ID of the task")
                .type(Scalars.GraphQLID)
                .build();

        GraphQLFieldDefinition name = GraphQLFieldDefinition.newFieldDefinition()
                .name("name")
                .description("Name of the task")
                .type(Scalars.GraphQLString)
                .build();


        List<GraphQLFieldDefinition> fields = new ArrayList<>();
        fields.add(id);
        fields.add(name);
        return fields;
    }

    @Override
    public List<GraphQLFieldDefinition> getMutationFields() {
        return new ArrayList<>();
    }
}
