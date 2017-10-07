import React from 'react';

import {graphql} from 'react-apollo';
import gql from 'graphql-tag';

import Form from '../components/Form';

const addTask = gql`
    mutation addTask($name: String!, $description: String) {
        addTask(task: { name: $name, description: $description }) {
            name
        }
    }
`;

const TaskInput = (props) =>
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
        onSubmit={formValues => {
            props.addTask(formValues)
        }}
    />;

export default graphql(addTask, {
    props: ({ ownProps, mutate }) => ({
        addTask: ({ name, description }) => {
            console.log(mutate);
            console.log(name);
            console.log(description);
            return mutate({ variables: { name, description } });
        }
    })
})(TaskInput);
