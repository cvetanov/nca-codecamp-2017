import React from 'react';
import {graphql} from 'react-apollo';
import gql from 'graphql-tag';

import TaskList from '../components/TaskList';

const urgentTasksQuery = gql`{
    urgentTasks {
        id,
        name,
        description,
        priority
    }
}`;

const ConnectedUrgentTaskList = ({data}) => {
    const {loading, urgentTasks} = data;
    if (loading) {
        return <div>Loading tasks...</div>;
    }

    return <TaskList title="Urgent Tasks" tasks={urgentTasks}/>;
};

export default graphql(urgentTasksQuery)(ConnectedUrgentTaskList);