import React, { Component } from 'react';

const errorTextStyle = {
  color: '#F00'
};

export default class ErrorBoundary extends Component {
  constructor(props) {
    super(props);
    this.state = {
      error: false
    };
  }

  componentDidCatch(error, info) {
    const { onError } = this.props;
    if (typeof onError === 'function') {
      onError(error, info);
    }
    this.setState(state => ({ ...state, error: true }));
  }

  render() {
    if (this.state.error) {
      return <h1 style={errorTextStyle}>Ooops, something went wrong</h1>;
    }

    return this.props.children;
  }
}
