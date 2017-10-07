import React from 'react';
import {graphql} from 'react-apollo';
import gql from 'graphql-tag';

import TaskList from '../components/TaskList';

// TODO gcvetano 2017-10-07: replace with urgentTasks query when it is done
const urgentTasksQuery = gql`{
    tasks {
        id,
        name,
        description
    }
}`;

const ConnectedUrgentTaskList = ({data}) => {
    const {loading, tasks} = data;
    if (loading) {
        return <div>Loading tasks...</div>;
    }

    return <TaskList title="Urgent Tasks" tasks={tasks}/>;
};

export default graphql(urgentTasksQuery)(ConnectedUrgentTaskList);