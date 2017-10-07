import React from 'react';

const Project = ({name, description}) => {
    return [
        <h3 key="name">{name}</h3>,
        <h5 key="description">{description}</h5>
    ];
};

export default Project;
