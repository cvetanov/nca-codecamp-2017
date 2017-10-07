import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router} from 'react-router-dom'
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

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
    <MuiThemeProvider>
        <Router>
            <ApolloProvider client={client}>
                <App/>
            </ApolloProvider>
        </Router>
    </MuiThemeProvider>
);

ReactDOM.render(app, document.getElementById('root'));
registerServiceWorker();
