
import React, { Component } from 'react';
import Particles from 'react-particles-js';
import "assets/css/room.css"

class ThankYouPage extends Component {
    constructor(props) {
        super(props)

        this.state = {

            value: "",
            filterData: [],
            flats: []
        }
    }

    componentDidMount() {
        console.log("Thank you Page");
    }

    render() {

        return (

            <>
            
                <div class="page-header clear-filter" filter-color="yellow">
                    
                    <div class="page-header-image" data-parallax="true"  style={{ backgroundImage: "url(" + require("assets/img/ironman.png") + ")" }}>
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
                    <div class="container thanks">
                        <div class="content-center brand">

                            <h1 class="h1-seo">Now UI Kit.</h1>
                            <h3>A beautiful Bootstrap 4 UI kit. Yours free.</h3>
                        </div>
                    </div>
                </div>
                
            </>

        )

    }

}

export default ThankYouPage