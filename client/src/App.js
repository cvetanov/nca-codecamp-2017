import React, {Component} from 'react';
import {Route} from 'react-router-dom'

// TODO gcvetano 2017-10-08: consider replacing with floating button
import RaisedButton from 'material-ui/RaisedButton';

import Navigation from './containers/Navigation';

import ConnectedProjectList from './connected-components/ConnectedProjectList';
import ConnectedTaskList from './connected-components/ConnectedTaskList';
import ConnectedUrgentTaskList from './connected-components/ConnectedUrgentTaskList';
import ConnectedProjectDetails from './connected-components/ConnectedProjectDetails';
import ConnectedTaskDetails from './connected-components/ConnectedTaskDetails';
import TaskInput from './containers/TaskInput';

import './App.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            addTaskDialogOpen: false
        };
        this.changeAddTaskDialogStatus = this.changeAddTaskDialogStatus.bind(this);
    }

    changeAddTaskDialogStatus = isOpen => () => this.setState(state => ({...state, addTaskDialogOpen: isOpen}));

    render () {
        return (
            <div className="App">
                <Navigation/>
                <Route exact path="/" component={ConnectedUrgentTaskList}/>

                <Route exact path="/projects" component={ConnectedProjectList}/>
                <Route path="/projects/:id" component={ConnectedProjectDetails}/>

                <Route exact path="/tasks" component={ConnectedTaskList}/>
                <Route path="/tasks/:id" component={ConnectedTaskDetails}/>
                <RaisedButton
                    label="Add task"
                    onClick={this.changeAddTaskDialogStatus(true)}
                />
                <TaskInput
                    open={this.state.addTaskDialogOpen}
                    onCancel={this.changeAddTaskDialogStatus(false)}
                    onConfirm={addedTask => console.log(addedTask)}
                />
            </div>
        );
    }
}

export default App;
