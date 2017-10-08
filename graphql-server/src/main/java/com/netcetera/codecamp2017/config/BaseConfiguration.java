package com.netcetera.codecamp2017.config;

import com.coxautodev.graphql.tools.SchemaParser;
import com.netcetera.codecamp2017.resolver.Mutation;
import com.netcetera.codecamp2017.resolver.Query;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration {

    private final Query query;
    private final Mutation mutation;

    @Autowired
    public BaseConfiguration(Query query, Mutation mutation) {
        this.query = query;
        this.mutation = mutation;
    }

    @Bean
    public GraphQLSchema graphQLSchema() {

        return SchemaParser.newParser()
            .file("schema.graphqls")
            .resolvers(query, mutation)
            .build()
            .makeExecutableSchema();
    }
}
