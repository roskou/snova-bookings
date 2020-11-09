import React, { Component, } from 'react';
import { Link } from 'react-router-dom';
import FlatService from 'services/FlatService.js';
import BookingForm  from 'components/Forms/BookingForm'
import LogUser from 'components/Forms/LoginForm'


import {
    Button,
    Input,
    InputGroupAddon,
    InputGroupText,
    InputGroup,
    Container,
    Row,
    Col,
} from "reactstrap";

class FlatDetailView extends Component {
    constructor(props) {
        super(props)
        
        this.state = {
            id: this.props.match.params.id,
            test: this.updateDetailDates(),
            price: 0,
            dates: [],
            room_details: {}
        }
        console.log(' FLAT DETAIL',this.props.log)
        console.log("HHHHHHHHHH",props)
    }
    
    async componentDidMount() {
        console.log("PROPS REDUX", this.props)
        FlatService.getFlatById(this.state.id).then((res) => {
            this.setState({ room_details: res.data.roomModel, dates: res.data.dates });
            
            //console.log('details: ', this.state.details);
            //console.log('tipos: ', this.state.details.tipoModel.id);
        });

    }

    updateBookPrice(value){

        this.setState({price: value})
    }

    updateDetailDates(checkI, checkO){ //recibe checkIn checkOut de bookForm
        
        this.setState({checkIn : checkI})
        this.setState({checkOut : checkO})
        console.log("CheckIN en DETAILVIEW:", this.checkIn )
        console.log("CheckOUT en DETAILVIEW:", this.checkOut )
        
    }



    render() {
        
        return (


            
                <div id="principal" className="p">
                    <div className="row ">
                        <div className="section-heading text-center">

                        <h1>Do You Want This House... Book Now! {this.checkIn}</h1>
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


                            <BookingForm priceFunc={this.updateBookPrice.bind(this)}
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