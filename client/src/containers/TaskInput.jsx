import React from 'react';

import {graphql} from 'react-apollo';
import gql from 'graphql-tag';

import Form from '../components/Form';

const addTaskMutation = gql`
    mutation addTask($name: String!, $description: String) {
        addTask(task: { name: $name, description: $description }) {
            name
        }
    }
`;

const TaskInput = ({ addTask }) =>
    <Form
        fields={[
            {
                name: 'name',
                value: 'abc'
            },
            {
                name: 'description',
                value: '123'
            }
        ]}
        onSubmit={addTask}
    />;

export default graphql(addTaskMutation, {
    props: ({ ownProps, mutate }) => ({
        addTask: ({ name, description }) => mutate({ variables: { name, description } })
    })
})(TaskInput);
