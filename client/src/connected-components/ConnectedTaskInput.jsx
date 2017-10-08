import React, {Component} from 'react';

import {graphql} from 'react-apollo';
import gql from 'graphql-tag';

import TaskInput from '../containers/TaskInput';

// TODO gcvetano 2017-10-08: consider replacing with floating button
import {RaisedButton} from "material-ui";

const addTaskMutation = gql`
    mutation AddTaskMutation($name: String!, $description: String, $dateScheduled: String, $priority: Priority, $taskStatus: TaskStatus) {
        addTask(task: { name: $name, description: $description, dateScheduled: $dateScheduled, priority: $priority, taskStatus: $taskStatus }) {
            name
        }
    }
`;

class ConnectedTaskInput extends Component {
    constructor(props) {
        super(props);
        this.state = {
            dialogOpen: false
        };
        this.changeDialogOpen = this.changeDialogOpen.bind(this);
        this.handleOnConfirm = this.handleOnConfirm.bind(this);
    }

    changeDialogOpen = isOpen => () => this.setState(state => ({...state, dialogOpen: isOpen}));
    handleOnConfirm = (task) => this.props.addTask(task).then(this.changeDialogOpen(false));

    render() {
        return [
            <RaisedButton
                key="add-task-button"
                label="Add task"
                onClick={this.changeDialogOpen(true)}
            />,
            <TaskInput
                key="add-task-dialog"
                open={this.state.dialogOpen}
                onCancel={this.changeDialogOpen(false)}
                onConfirm={this.handleOnConfirm}
            />
        ];
    }
}

export default graphql(addTaskMutation, {
    props: ({ownProps, mutate}) => ({
        addTask: ({name, description, dateScheduled, priority, taskStatus}) =>
            mutate({variables: {name, description, dateScheduled, priority, taskStatus}})
    })
})(ConnectedTaskInput);
