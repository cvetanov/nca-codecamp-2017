import React, {Component} from 'react';
import {Route} from 'react-router-dom'

import Navigation from './containers/Navigation';

import ConnectedProjectList from './connected-components/ConnectedProjectList';
import ConnectedTaskList from './connected-components/ConnectedTaskList';
import ConnectedUrgentTaskList from './connected-components/ConnectedUrgentTaskList';
import ConnectedProjectDetails from './connected-components/ConnectedProjectDetails';
import ConnectedTaskDetails from './connected-components/ConnectedTaskDetails';
import ConnectedTaskInput from "./connected-components/ConnectedTaskInput";

import './App.css';

class App extends Component {
    render () {
        return (
            <div className="App">
                <Navigation/>
                <Route exact path="/" component={ConnectedUrgentTaskList}/>

                <Route exact path="/projects" component={ConnectedProjectList}/>
                <Route path="/projects/:id" component={ConnectedProjectDetails}/>

                <Route exact path="/tasks" component={ConnectedTaskList}/>
                <Route path="/tasks/:id" component={ConnectedTaskDetails}/>
                <ConnectedTaskInput />
            </div>
        );
    }
}

export default App;
