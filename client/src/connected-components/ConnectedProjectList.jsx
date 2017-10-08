import React from 'react';
import { graphql } from 'react-apollo';

import Project from '../components/Project';
import gql from 'graphql-tag';

const projectsQuery = gql`
  {
    projects {
      id
      name
      description
    }
  }
`;

const ProjectList = ({ data }) => {
  const { loading, projects } = data;
  if (loading) {
    return <div>Loading projects...</div>;
  }

  const renderedProjects = projects.map(p => (
    <Project key={p.id} id={p.id} name={p.name} description={p.description} />
  ));

  return [<h1 key="projects-title">Projects:</h1>, ...renderedProjects];
};

export default graphql(projectsQuery)(ProjectList);
