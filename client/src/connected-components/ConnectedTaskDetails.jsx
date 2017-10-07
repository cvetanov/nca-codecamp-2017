import React from 'react';
import {graphql} from 'react-apollo';
import gql from 'graphql-tag';

import Task from '../components/Task';

const taskQuery = gql`
    query TaskQuery($id: ID!) {
        task(id: $id) {
            id,
            name,
            description,
            priority
        }
    }
`;

const ConnectedTaskDetails = ({data: {loading, task}}) => {
    if (loading) {
        return <div>Task data is loading...</div>
    }
    return (
        <Task
            id={task.id}
            name={task.name}
            description={task.description}
            priority={task.priority}
        />
    );
};

export default graphql(taskQuery, {
    options: ({ match: { params: { id } }}) => ({ variables: { id }})
})(ConnectedTaskDetails)
