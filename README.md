# nca-codecamp-2017
Netcetera CodeCamp 2017 playground project with main focus on GraphQL in Java

## Server

The ``graphql-java`` library is used for creating the main schema, type resolvers and data fetchers.

By adding the ``graphql-spring-boot-starter`` dependency in the application, a simple java servlet is created which
handles HTTP requests on ``'/graphql/*'``.
Servlet definition is ``GraphQLServlet extends HttpServlet implements Servlet`` and can be found [here](https://github.com/graphql-java/graphql-java-servlet).

The servlet searches for a ``GraphQLSchema`` bean.
This bean gets autowired in the library and after the type definitions of the schema are parsed, the servlet is created.

By adding the ``graphiql-spring-boot-starter`` dependency in the application, a GraphiQL UI is exposed on ``'/graphiql'``
for easier and faster development and testing of the queries and mutations.

Type resolving and Java model creation is done using ``DataFetcher`` and ``TypeResolver``.
Every field definition has a ``DateFetcher`` by default and it is set to use getters/setters for accesing fields in a model.

A ``TypeResolver`` helps ``graphql-java`` to decide to which type a concrete value belongs.
In order to have queries in the GraphQL Schema, a class which implements ``GraphQLQueryResolver`` must be present.
The queries from the schema are resolved to the public methods of this class by their names.
For example, a query defined in the schema as ``tasks : [Task]`` will get resolved to the ``public List<Task> tasks()`` method of the class.
For supporting mutations, there must be a class which implements the ``GraphQLMutationResolver`` interface.

Custom type resolvers can also be defined in order to avoid using the same models for inputs/responses in the GraphQL queries and mutations and throughout the application. 

## Client
The client is scaffolded using the ``create-react-app`` tool. It uses ``apollo-client`` with the ``react-apollo`` dependency for connecting the components to the ``ApolloProvider``.

The components which are sending GraphQL queries and mutations can be found under ``src/connected-components``. The other components are plain container and presentational components.
