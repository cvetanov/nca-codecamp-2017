import React from 'react';
import {MenuItem, SelectField} from "material-ui";

const FancySelect = ({name, value, label, onChange, items}) => {
    return (
        <SelectField
            name={name}
            floatingLabelText={label}
            value={value}
            onChange={onChange}
        >
            {items.map(item => <MenuItem key={item.value} value={item.value} primaryText={item.text} />)}
        </SelectField>
    );
};

export default FancySelect;
