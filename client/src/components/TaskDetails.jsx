import React from 'react';

import {prioritiesLookup, statusesLookup} from "../enums/taskEnums";
import {Avatar, Chip, FontIcon} from "material-ui";

const styles = {
    chip: {
        margin: '5px auto'
    },
    wrapper: {
        display: 'flex',
        flexWrap: 'wrap',
    },
};

const TaskDetails = ({name, description, dateScheduled, priority, status, project}) => (
    <div>
        <span>{name}</span>
        <br/>
        <br/>
        <span>{description}</span>
        <br/>
        <br/>
        <span>{dateScheduled}</span>
        <br/>
        <br/>
        <Chip style={styles.chip}>
            <Avatar icon={<FontIcon className="material-icons">schedule</FontIcon>}/>
            {prioritiesLookup[priority]}
        </Chip>
        <Chip style={styles.chip}>
            <Avatar icon={<FontIcon className="material-icons">info</FontIcon>}/>
            {statusesLookup[status]}
        </Chip>
        <div>
            <span>Belongs to:</span>
            <br/>
            <span>{project.name}</span>
            <span>{project.description}</span>
        </div>
    </div>
);


export default TaskDetails;
