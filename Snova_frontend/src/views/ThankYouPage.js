import React, { Component } from 'react';
import BookingService from "services/BookingService.js"
import { connect } from 'react-redux'
import Particles from 'react-particles-js';
import { Link } from 'react-router-dom';
import { QRCode } from "react-qr-svg";
import { Row, Col } from "reactstrap";



class ThankYouPage extends Component {
    constructor(props) {
        super(props)

        this.state = {

            cupon: null,
            invoice: {},
            client: {},
        }
    }

    componentDidMount() {
     this.cupon()
    }

    cupon(){

    BookingService.getCupon().then((res) => {this.setState({ cupon: res.data })})
    
    }


    render() {

        return (

            <>

                <div class="page-header clear-filter" filter-color="yellow">

                    <div class="page-header-image" data-parallax="true" style={{ backgroundImage: "url(" + require("assets/img/ironman.png") + ")" }}>

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
                        <div class="content-center ">
                            <QRCode
                                bgColor="#FFFFFF"
                                fgColor="#000000"
                                level="Q"
                                className="QRCode"
                                value={"BEGIN:VEVENT\nSUMMARY:" + this.props.invoice.roomName + "\nDTSTART:" + this.props.invoice.checkIn.toISOString() +
                                    "\nDTEND:" + this.props.invoice.checkOut.toISOString() +
                                    "\nLOCATION:" + this.props.invoice.roomLocation + "\nSTATUS:CONFIRMED\nEND:VEVENT"}
                            />
                            <div>
                            <h1>Thanks for you booking {this.props.client.nombre}!.</h1>
                            <h3>Scan this QR Code to add your booking to tour smartphone.</h3>
                            </div>
                               
                            <div>
                            <h4>Your have booking <strong><u>{this.props.invoice.roomName}</u></strong> located at <strong><u>{this.props.invoice.roomLocation}</u></strong> for <strong><u>{this.props.invoice.price}€</u></strong></h4>
                            
                            </div>
                           <div>
                            <h1>{this.state.cupon}</h1>
                            Congratulations You have awarded with a 20% discount cupon
                            </div>
                            <span><Link className="btn book-room-btn btn-palatin" to={"/"}>Go homepage</Link></span>
                        </div>
                    </div>
                </div>

            </>

        )

    }

}



const mapStateToProps = state => ({

    client: state.clientModel.client,
    invoice: state.invoice
})

export default connect(mapStateToProps)(ThankYouPage)

// {"BEGIN:VEVENT\nSUMMARY:Snova Booking\nDTSTART:", this.props.invoice.checkIn,
//                                              "\nDTEND:", this.props.invoice.chekOut, "\nEND:VEVENT"}