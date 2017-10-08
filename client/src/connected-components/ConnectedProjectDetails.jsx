import React from 'react';
import { graphql } from 'react-apollo';
import gql from 'graphql-tag';

import Task from '../components/Task';

const ProjectDetails = ({ data: { loading, project } }) => {
  if (loading) {
    return <div>Project data is loading...</div>;
  }
  return [
    <h4 key="name">{project.name}</h4>,
    <span key="description">{project.description}</span>,
    ...project.tasks.map(t => (
      <Task key={t.id} name={t.name} description={t.description} />
    ))
  ];
};

const projectQuery = gql`
  query ProjectQuery($id: ID!) {
    project(id: $id) {
      name
      description
      tasks {
        name
        description
      }
    }
  }
`;

export default graphql(projectQuery, {
  options: ({ match: { params: { id } } }) => ({ variables: { id } })
})(ProjectDetails);
