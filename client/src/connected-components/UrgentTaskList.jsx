import React from 'react';
import {graphql} from 'react-apollo';
import gql from 'graphql-tag';

import Task from '../components/Task';

// TODO gcvetano 2017-10-07: replace with urgentTasks query when it is done
const urgentTasksQuery = gql`{
    tasks {
        id,
        name,
        description
    }
}`;

const UrgentTaskList = ({data}) => {
    const {loading, tasks} = data;
    if (loading) {
        return <div>Loading tasks...</div>;
    }

    const renderedTasks = tasks.map(task => <Task key={task.id} name={task.name} description={task.description}/>);
    return [
        <h1 key="tasks-title">Urgent tasks</h1>,
        ...renderedTasks
    ]
};

export default graphql(urgentTasksQuery)(UrgentTaskList);