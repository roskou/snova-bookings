import React, { Component, } from 'react';
import { Link } from 'react-router-dom';
import { QRCode } from "react-qr-svg";
import FlatService from 'services/FlatService.js';
import BookingForm from 'components/Forms/BookingForm'
import LogUser from 'components/Forms/LoginForm'
import BookingService from "services/BookingService.js"


class FlatDetailView extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            checkIn: new Date(),
            checkOut: new Date(),
            booking_price: 0,
            dates: [],
            room_details: {}
        }
        console.log(' FLAT DETAIL', this.props.log)
        console.log("HHHHHHHHHH", props)
    }

        componentDidMount() {
        console.log("PROPS REDUX", this.props)
        FlatService.getFlatById(this.state.id).then((res) => {
            this.setState({ room_details: res.data.roomModel, dates: res.data.dates });
        });

    }



    updateDetailDates(checkI, checkO) { //recibe checkIn checkOut de bookForm

        this.setState({ checkIn: checkI })
        this.setState({ checkOut: checkO })
        let costData = {
            'preCheckIn': checkI,
            'preCheckOut': checkO,
            'precio': this.state.room_details.precio
          }
        BookingService.getPrice(costData).then(res => this.setState({booking_price : res}))
        console.log("CheckIN en DETAILVIEW:", this.checkIn)
        console.log("CheckOUT en DETAILVIEW:", this.checkOut)

    }



    render() {

        return (



            <div id="principal" className="p">
                <div className="row ">
                    <div className="section-heading text-center">

                        <h2>Do You Want This House...  {this.state.booking_price===0 ? "" : "Book Now for " + this.state.booking_price + "€"} </h2>
                        {/* <p>{this.state.checkIn2}</p>
                        <p>{this.state.checkOut2}</p> */}



                    </div>
                    <div id="apartamento" className="col-md-10" style={{ border: "solid" }}>

                        {/* <!-- Thumbnail --> */}

                        <div className="single-rooms-area">
                            <div className="bg-thumbnail bg-img img-raised"
                                style={{ backgroundImage: "url(" + require("assets/img/house_type_4.png") + ")" }}>

                            </div>
                            {/* <!-- Price  --> */}
                            <p className="price-from">From {this.state.room_details.precio}  €/noche</p>

                            {/* <!-- Rooms Text --> */}
                            {/* <div className="rooms-text">

                                    <div className="line"></div>
                                  
                                </div> */}
                            {/* <!-- Book Room --> */}
                            <p><Link className="btn book-room-btn btn-palatin" to={"/"}>select</Link></p>
                        </div>
                    </div>

                    <div id="formulario" className="col-md-2 customDatePickerWidth" style={{ border: "solid", backgroundColor: "#f87f1c" }}>
                    <QRCode
                        bgColor="#FFFFFF"
                        fgColor="#000000"
                        level="Q"
                        style={{ width: 128 }}
                        value={this.state.room_details.description}
                    />

                        <BookingForm 
                            detailDates={this.updateDetailDates.bind(this)}
                            habitacion={this.state.room_details}
                            id={this.state.room_details.id}
                            excludedDates={this.state.dates} />

                    </div>


                </div>
                <div id="footer" className="row" style={{ border: "solid" }}>
                    <LogUser />
                    <h3>{this.state.room_details.codigo}</h3>
                    <h3>{this.state.room_details.localidad}</h3>
                    <p>{this.state.room_details.descripcion}</p>

                    <div>
                    </div>
                </div>
            </div>




        )
    }

}

export default FlatDetailView