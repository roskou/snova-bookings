import React, { Component } from 'react';
import Particles from 'react-particles-js';

class ThankYouPage extends Component {
    constructor(props) {
        super(props)

        this.state = {
            
            value: "",
            filterData: [],
            flats: []
        }
    }

    componentDidMount(){
        console.log("Thank you Page");
    }

    render() {

        return(
            <div className="text-center">

                <h1>Thank for Booking!</h1>
<Particles
    params={{
	    "particles": {
	        "number": {
	            "value": 50
	        },
	        "size": {
	            "value": 3
	        }
	    },
	    "interactivity": {
	        "events": {
	            "onhover": {
	                "enable": true,
	                "mode": "repulse"
	            }
	        }
	    }
	}} />


</div>

        )

    }
    
}

export default ThankYouPage