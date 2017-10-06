package com.netcetera.codecamp.graphqldemo.config;

import graphql.Scalars;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration {

    @Bean
    public GraphQLSchema graphQLSchema() {
        return GraphQLSchema.newSchema()
            .query(GraphQLObjectType.newObject()
                .name("query")
                .field(field -> field
                    .name("test")
                    .type(Scalars.GraphQLString)
                    .dataFetcher(environment -> "response")
                )
                .build())
            .build();
    }
}
