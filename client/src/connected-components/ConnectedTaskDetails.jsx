import React from 'react';
import {graphql} from 'react-apollo';
import gql from 'graphql-tag';

import Task from '../components/Task';

const TaskDetails = ({data: {loading, task}}) => {
    if (loading) {
        return <div>Task data is loading...</div>
    }
    return <Task key={task.id} name={task.name} description={task.description} />;
};

const taskQuery = gql`
    query TaskQuery($id: ID!) {
        task(id: $id) {
            name,
            description,
            tasks {
                name,
                description
            }
        }
    }
`;

export default graphql(taskQuery, {
    options: ({ match: { params: { id } }}) => ({ variables: { id }})
})(TaskDetails)
