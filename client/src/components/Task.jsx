import React, {Component} from 'react';
import {Card, CardActions, CardTitle, CardText} from 'material-ui/Card';
import FlatButton from 'material-ui/FlatButton';
import {withRouter} from "react-router";

class TaskList extends Component {
    constructor(props) {
        super(props);
        this.goToDetails = this.goToDetails.bind(this);
    }

    goToDetails = () => this.props.history.push(`/tasks/${this.props.id}`);

    render() {
        const {name, description} = this.props;
        return (
            <Card>
                <CardTitle title={name}/>
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

export default withRouter(TaskList);