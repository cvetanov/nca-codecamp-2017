import React from 'react';
import {Route} from 'react-router-dom'

import Navigation from './containers/Navigation';

import ProjectList from './connected-components/ConnectedProjectList';
import TaskList from './connected-components/ConnectedTaskList';
import UrgentTaskList from './connected-components/ConnectedUrgentTaskList';
import ProjectDetails from './connected-components/ConnectedProjectDetails';
import TaskDetails from './connected-components/ConnectedTaskDetails';

import './App.css';

const App = () => {
    return (
        <div className="App">
            <Navigation/>
            <Route exact path="/" component={UrgentTaskList}/>

            <Route exact path="/projects" component={ProjectList}/>
            <Route path="/projects/:id" component={ProjectDetails}/>

            <Route exact path="/tasks" component={TaskList}/>
            <Route path="/tasks/:id" component={TaskDetails}/>
        </div>
    );
};

export default App;
