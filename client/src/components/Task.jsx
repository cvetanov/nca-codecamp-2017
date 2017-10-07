import React, {Component} from 'react';
import {Card, CardActions, CardTitle, CardText} from 'material-ui/Card';
import FlatButton from 'material-ui/FlatButton';
import {withRouter} from "react-router";

const priorityToColorMap = {
    DEADLINE: '#F00',
    PRIORITY1: '#FF9800',
    PRIORITY2: '#FFEB3B',
    PRIORITY_DEFAULT: '#000'
};

class Task extends Component {
    constructor(props) {
        super(props);
        this.goToDetails = this.goToDetails.bind(this);
    }

    goToDetails = () => this.props.history.push(`/tasks/${this.props.id}`);

    render() {
        const {name, description, priority} = this.props;
        return (
            <Card>
                <CardTitle title={name} titleColor={priorityToColorMap[priority]}/>
                <CardText>
                    {description}
                </CardText>
                <CardActions>
                    <FlatButton onClick={this.goToDetails} label="View"/>
                </CardActions>
            </Card>
        );
    }
}

export default withRouter(Task);