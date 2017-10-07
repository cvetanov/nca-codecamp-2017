import React, {Component} from 'react';
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom'
import logo from './logo.svg';
import './App.css';

import ProjectList from './containers/ProjectList';
import TaskList from './containers/TaskList';
import ProjectDetails from './components/ProjectDetails';

class App extends Component {
    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h1 className="App-title">Welcome to React</h1>
                </header>
                <Router>
                    <div>
                        <nav>
                            <ul>
                                <li><Link to="/projects">Projects</Link></li>
                                <li><Link to="/tasks">Tasks</Link></li>
                            </ul>
                        </nav>

                        <Route exact path="/" component={ProjectList}/>
                        <Route exact path="/projects" component={ProjectList}/>
                        <Route path="/projects/:id" component={ProjectDetails}/>
                        <Route path="/tasks" component={TaskList}/>
                    </div>
                </Router>
            </div>
        );
    }
}

export default App;
