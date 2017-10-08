import React, {Component} from 'react';
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

class ConnectedUrgentTaskList extends Component {
    componentDidMount() {
        const {data: {refetch}} = this.props;
        if (typeof refetch === 'function') {
            refetch();
        }
    }

    render() {
        const {data: {loading, urgentTasks}} = this.props;
        if (loading) {
            return <div>Loading tasks...</div>;
        }

        return <TaskList title="Urgent Tasks" tasks={urgentTasks}/>;
    }
}


export default graphql(urgentTasksQuery)(ConnectedUrgentTaskList);