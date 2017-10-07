import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';

import ApolloClient, {createNetworkInterface} from 'apollo-client';
import {ApolloProvider} from 'react-apollo';

const networkInterface = createNetworkInterface({
    uri: 'http://localhost:8080/graphql'
});
const client = new ApolloClient({networkInterface});

const app = (
    <ApolloProvider client={client}>
        <App/>
    </ApolloProvider>
);

ReactDOM.render(app, document.getElementById('root'));
registerServiceWorker();
