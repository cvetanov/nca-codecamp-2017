import React, { Component } from 'react';
import { graphql } from 'react-apollo';
import gql from 'graphql-tag';

import FloatingActionButton from 'material-ui/FloatingActionButton';
import ContentAdd from 'material-ui/svg-icons/content/add';

import TaskInput from '../containers/TaskInput';

const addTaskMutation = gql`
  mutation AddTaskMutation(
    $name: String!
    $description: String
    $dateScheduled: String
    $priority: Priority
    $taskStatus: TaskStatus
  ) {
    addTask(
      task: {
        name: $name
        description: $description
        dateScheduled: $dateScheduled
        priority: $priority
        taskStatus: $taskStatus
      }
    ) {
      name
    }
  }
`;

const floatingButtonStyle = {
  float: 'right',
  margin: 10
};

class ConnectedTaskInput extends Component {
  constructor(props) {
    super(props);
    this.state = {
      dialogOpen: false
    };
    this.changeDialogOpen = this.changeDialogOpen.bind(this);
    this.handleOnConfirm = this.handleOnConfirm.bind(this);
  }

  changeDialogOpen = isOpen => () =>
    this.setState(state => ({ ...state, dialogOpen: isOpen }));
  handleOnConfirm = task =>
    this.props.addTask(task).then(this.changeDialogOpen(false));

  render() {
    return [
      <FloatingActionButton
        key="add-task-button"
        style={floatingButtonStyle}
        onClick={this.changeDialogOpen(true)}
      >
        <ContentAdd />
      </FloatingActionButton>,
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
  props: ({ ownProps, mutate }) => ({
    addTask: ({ name, description, dateScheduled, priority, taskStatus }) =>
      mutate({
        variables: { name, description, dateScheduled, priority, taskStatus }
      })
  })
})(ConnectedTaskInput);
