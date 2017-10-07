import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

import ProjectList from './containers/ProjectList';
import TaskList from './containers/TaskList';
import TaskInput from './containers/TaskInput';

class App extends Component {
    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h1 className="App-title">Welcome to React</h1>
                </header>
                <ProjectList/>
                <hr/>
                <TaskList/>
                <hr/>
                <TaskInput/>
            </div>
        );
    }
}

export default App;
