import React from 'react';
import {Link} from "react-router-dom";

const Project = ({id, name, description}) => {
    return [
        <Link to={`/projects/${id}`}>
            <h3 key="name">{name}</h3>
        </Link>,
        <h5 key="description">{description}</h5>
    ];
};

export default Project;
