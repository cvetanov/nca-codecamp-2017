import React, {Component} from 'react';

export default class Input extends Component {

    constructor(props) {
        super(props);
        this.onChange = this.onChange.bind(this);
    }

    onChange = e => {
        const { value } = e.target;
        const { name, onChange } = this.props;
        onChange(name, value);
    };

    render() {
        const { name, value } = this.props;
        return <input value={value} onChange={this.onChange} placeholder={name} />;
    }
}
