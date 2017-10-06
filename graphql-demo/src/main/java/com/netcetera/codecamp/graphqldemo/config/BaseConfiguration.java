package com.netcetera.codecamp.graphqldemo.config;

import com.coxautodev.graphql.tools.SchemaParser;
import com.netcetera.codecamp.graphqldemo.resolver.Query;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration {

    @Bean
    public GraphQLSchema graphQLSchema() {
        return SchemaParser.newParser()
            .file("schema.graphqls")
            .resolvers(new Query())
            .build()
            .makeExecutableSchema();
    }
}
