import React, { Component, } from 'react';
import FlatService from 'services/FlatService.js';
import BookingForm from 'components/Forms/BookingForm'
import DefaultFooter from "components/Footers/DefaultFooter.js";
import IndexNavbar from "components/Navbars/IndexNavbar.js";
import { Row, Col, Card, CardTitle, CardSubtitle, CardText } from "reactstrap";



class FlatDetailView extends Component {
    constructor(props) {
        super(props)

        this.state = {

            dates: [],
            room_details: {},
        }

    }

    componentDidMount() {
        FlatService.getFlatById(this.props.match.params.id).then((res) => {
            this.setState({ room_details: res.data.roomModel, dates: res.data.dates });
        });

    }

    

    render() {

        return (
            <>
                <IndexNavbar />
                <section className="DetailView">
                    <div class="container">

                        <Row>
                            <Col md={8}>
                                <div className="single-rooms-area">
                                    <div className="bg-thumbnail bg-img img-raised"
                                        style={{ backgroundImage: "url(" + require("assets/img/house_type_4" + ".png") + ")" }}>

                                    </div>
                                    {/* <!-- Price  --> */}
                                    <p className="price-from">From {this.state.room_details.precio}  €/night</p>

                                </div>

                                <Row>
                                    <Card className="detailFooter" className="text-center">
                                    
                                    <CardTitle tag="h5">  {this.state.room_details.codigo} ({this.state.room_details.localidad})</CardTitle>
                                        
                                    <CardSubtitle tag="h6"> PAX: {this.state.room_details.numpersonas}   |    Surface: {this.state.room_details.m2} m2</CardSubtitle>
                                        
                                    
                                        <CardText>{this.state.room_details.descripcion}</CardText>
                                        

                                    </Card>
                                </Row>

                            </Col>

                            <Col md={4}>
                            <Card body>
                                <BookingForm
                                    idRoom={this.state.room_details.id}
                                    roomLocation={this.state.room_details.localidad}
                                    roomName={this.state.room_details.codigo}
                                    excludedDates={this.state.dates} />
                            </Card>
                            </Col>

                        </Row>

                    </div>
                </section>
                <DefaultFooter />
            </>
        )
    }

}

export default FlatDetailView