import React, { Component } from 'react';
import { BottomNavigation, BottomNavigationItem, FontIcon } from 'material-ui';
import { withRouter } from 'react-router';

const homeIcon = <FontIcon className="material-icons">home</FontIcon>;
const projectsIcon = <FontIcon className="material-icons">tab</FontIcon>;
const tasksIcon = <FontIcon className="material-icons">list</FontIcon>;

class Navigation extends Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedIndex: 0
    };
    this.changeNavigation = this.changeNavigation.bind(this);
  }

  changeNavigation(newIndex, path) {
    return () => {
      this.props.history.push(path);
      this.setState(s => ({ ...s, selectedIndex: newIndex }));
    };
  }

  render() {
    return (
      <BottomNavigation selectedIndex={this.state.selectedIndex}>
        <BottomNavigationItem
          label="Home"
          icon={homeIcon}
          onClick={this.changeNavigation(0, '/')}
        />
        <BottomNavigationItem
          label="Projects"
          icon={projectsIcon}
          disabled
          onClick={this.changeNavigation(1, '/projects')}
        />
        <BottomNavigationItem
          label="Tasks"
          icon={tasksIcon}
          onClick={this.changeNavigation(2, '/tasks')}
        />
      </BottomNavigation>
    );
  }
}

export default withRouter(Navigation);
