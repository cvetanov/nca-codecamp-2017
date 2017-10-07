import React from 'react';
import {graphql} from 'react-apollo';
import gql from 'graphql-tag';

import Task from '../components/Task';

const tasksQuery = gql`{
    tasks {
        id,
        name,
        description
    }
}`;

const TaskList = ({data}) => {
    const {loading, tasks} = data;
    if (loading) {
        return <div>Loading tasks...</div>;
    }

    const renderedTasks = tasks.map(task => <Task key={task.id} name={task.name} description={task.description}/>);
    return [
        <h1 key="tasks-title">All tasks:</h1>,
        ...renderedTasks
    ]
};

export default graphql(tasksQuery)(TaskList);