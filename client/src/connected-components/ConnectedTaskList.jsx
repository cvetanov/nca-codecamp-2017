import React, {Component} from 'react';
import {graphql} from 'react-apollo';
import gql from 'graphql-tag';

import TaskList from '../components/TaskList';

const tasksQuery = gql`{
    tasks {
        id,
        name,
        description,
        priority
    }
}`;

class ConnectedTaskList extends Component {
    componentDidMount() {
        const {data: {refetch}} = this.props;
        if (typeof refetch === 'function') {
            refetch();
        }
    }

    render() {
        const {data: {loading, tasks}} = this.props;
        if (loading) {
            return <div>Loading tasks...</div>;
        }
        return <TaskList tasks={tasks}/>
    }
}

export default graphql(tasksQuery)(ConnectedTaskList);