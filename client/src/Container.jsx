import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import ApolloClient, { createNetworkInterface } from 'apollo-client';
import { ApolloProvider } from 'react-apollo';

import './index.css';
import App from './App';

const networkInterface = createNetworkInterface({
  uri: 'http://localhost:8080/graphql'
});
const client = new ApolloClient({ networkInterface });

const Container = () => (
  <MuiThemeProvider>
    <Router>
      <ApolloProvider client={client}>
        <App/>
      </ApolloProvider>
    </Router>
  </MuiThemeProvider>
);

export default Container;
