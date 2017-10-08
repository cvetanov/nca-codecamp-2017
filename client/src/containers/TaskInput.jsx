import React, { Component } from 'react';
import Dialog from 'material-ui/Dialog';
import FlatButton from 'material-ui/FlatButton';
import TextField from 'material-ui/TextField';
import { FontIcon, RaisedButton } from 'material-ui';

import FancySelect from '../components/FancySelect';
import { priorities, statuses } from '../enums/taskEnums';

const emptyTask = {
  name: '',
  description: '',
  dateScheduled: '',
  priority: '',
  taskStatus: ''
};

export default class TaskInput extends Component {
  constructor(props) {
    super(props);
    this.handleCancel = this.handleCancel.bind(this);
    this.handleConfirm = this.handleConfirm.bind(this);
    this.handleChangeFromTextField = this.handleChangeFromTextField.bind(this);
    this.handleChangeFromSelect = this.handleChangeFromSelect.bind(this);
    this.setDateScheduledToday = this.setDateScheduledToday.bind(this);
    this.changeValue = this.changeValue.bind(this);
    this.state = emptyTask;
    this.actions = [
      <FlatButton label="Cancel" primary={true} onClick={this.handleCancel} />,
      <FlatButton
        label="Submit"
        primary={true}
        keyboardFocused={true}
        onClick={this.handleConfirm}
      />
    ];
  }

  componentWillReceiveProps(nextProps) {
    if (!this.props.open && nextProps.open) {
      const updatedState = nextProps.task || emptyTask;
      this.setState(updatedState);
    }
  }

  handleCancel = this.props.onCancel;
  handleConfirm = () => {
    this.props.onConfirm(this.state);
  };
  handleChangeFromSelect = name => (event, index, value) =>
    this.changeValue(name, value);
  handleChangeFromTextField = ({ target: { name, value } }) =>
    this.changeValue(name, value);
  setDateScheduledToday = () => {
    const today = new Date();

    const day = today.getDate();
    const adjustedDay = day < 10 ? `0${day}` : day;
    const month = today.getMonth() + 1;
    const year = today.getFullYear();
    const dateString = `${adjustedDay}-${month}-${year}`;
    this.changeValue('dateScheduled', dateString);
  };
  changeValue = (name, value) => {
    this.setState(state => ({ ...state, [name]: value }));
  };

  render() {
    return (
      <Dialog
        title="Add task"
        actions={this.actions}
        modal={false}
        open={this.props.open}
        onRequestClose={this.handleCancel}
      >
        <TextField
          name="name"
          placeholder="Name"
          value={this.state.name}
          onChange={this.handleChangeFromTextField}
        />
        <TextField
          name="description"
          placeholder="Description"
          value={this.state.description}
          onChange={this.handleChangeFromTextField}
        />
        <div>
          <TextField
            name="dateScheduled"
            placeholder="dd-MM-yyyy (e.g. 31-12-2020)"
            value={this.state.dateScheduled}
            onChange={this.handleChangeFromTextField}
          />
          <RaisedButton
            label="Set to today"
            labelPosition="after"
            primary={true}
            onClick={this.setDateScheduledToday}
            icon={<FontIcon className="material-icons">schedule</FontIcon>}
          />
        </div>
        <FancySelect
          name="priority"
          value={this.state.priority}
          label="Priority"
          onChange={this.handleChangeFromSelect('priority')}
          items={priorities}
        />
        <FancySelect
          name="status"
          value={this.state.taskStatus}
          label="Status"
          onChange={this.handleChangeFromSelect('taskStatus')}
          items={statuses}
        />
      </Dialog>
    );
  }
}
