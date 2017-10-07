import React, {Component} from 'react';

import Input from './Input';

class Form extends Component {
    constructor(props) {
        super(props);
        const { fields } = props;
        this.state = fields.reduce((state, field) => ({
            ...state,
            [field.name]: field.value
        }), {});
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange = (field, value) => {
        this.setState(state => ({ ...state, [field]: value }));
    };

    handleSubmit = () => {
        this.props.onSubmit(this.state);
    };

    render() {
        return [
            this.props.fields.map(field =>
                <Input
                    key={field.name}
                    name={field.name}
                    value={this.state[field.name]}
                    onChange={this.handleChange}
                />
            ),
            <button key="submit" onClick={this.handleSubmit}>Mutate</button>
        ];
    }
}

export default Form;
