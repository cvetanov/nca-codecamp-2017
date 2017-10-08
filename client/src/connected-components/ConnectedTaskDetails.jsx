import React from 'react';
import { graphql } from 'react-apollo';
import gql from 'graphql-tag';

import TaskDetails from '../components/TaskDetails';

const taskQuery = gql`
  query TaskQuery($id: ID!) {
    task(id: $id) {
      id
      name
      description
      dateScheduled
      priority
      taskStatus
      project {
        name
        description
      }
    }
  }
`;

const ConnectedTaskDetails = props => {
  const { data: { loading, task } } = props;
  if (loading) {
    return <div>Task data is loading...</div>;
  }
  return (
    <TaskDetails
      id={task.id}
      name={task.name}
      description={task.description}
      dateScheduled={task.dateScheduled}
      priority={task.priority}
      status={task.taskStatus}
      project={task.project}
    />
  );
};

export default graphql(taskQuery, {
  options: ({ match: { params: { id } } }) => ({ variables: { id } })
})(ConnectedTaskDetails);
