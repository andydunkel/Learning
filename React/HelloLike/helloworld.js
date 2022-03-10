'use strict';

const d = React.createElement;

class HelloWorld extends React.Component {
    constructor() {
        super();
    }

    render() {
        return "<h1>Hello World</h1>";
    }
}

const domContainer1 = document.querySelector('#helloworld_container');
ReactDOM.render(d(HelloWorld), domContainer1);