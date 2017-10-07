import React from 'react';
import Subheader from 'material-ui/Subheader';

import Task from './Task';

const TaskList = ({title = 'Tasks', tasks}) => [
    <Subheader key="task-header">{title}</Subheader>,
    ...tasks.map(task =>
        <Task
            key={task.id}
            id={task.id}
            name={task.name}
            description={task.description}
        />
    )
];

export default TaskList;