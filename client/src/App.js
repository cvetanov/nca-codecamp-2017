import React from 'react';
import {Route} from 'react-router-dom'

import Navigation from './containers/Navigation';

import ProjectList from './connected-components/ProjectList';
import TaskList from './connected-components/TaskList';
import UrgentTaskList from './connected-components/UrgentTaskList';
import ProjectDetails from './connected-components/ProjectDetails';
import TaskDetails from './connected-components/TaskDetails';

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
