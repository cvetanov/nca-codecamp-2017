import React from 'react';
import ReactDOM from 'react-dom';

import './index.css';
import Container from './Container';
import registerServiceWorker from './registerServiceWorker';

const app = (<Container />);

ReactDOM.render(app, document.getElementById('root'));
registerServiceWorker();
