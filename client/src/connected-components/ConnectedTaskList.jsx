import React from 'react';
import {graphql} from 'react-apollo';
import gql from 'graphql-tag';

import TaskList from '../components/Task';

const tasksQuery = gql`{
    tasks {
        id,
        name,
        description
    }
}`;

const ConnectedTaskList = ({data}) => {
    const {loading, tasks} = data;
    if (loading) {
        return <div>Loading tasks...</div>;
    }
    return <TaskList tasks={tasks}/>
};

export default graphql(tasksQuery)(ConnectedTaskList);