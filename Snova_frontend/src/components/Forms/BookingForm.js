import React from "react";
import BookingService from "services/BookingService.js"
import MyDatePicker from "components/DatePicker/MyDatePicker";
import { connect } from 'react-redux'

// reactstrap components
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




// const bookingData = {
//     'roomId' : this.state.roomId,
//     'checkIn' : this.state.checkin.toJSON().split(“T”)[0],
//     'checkOut' : this.state.checkout.toJSON().split(“T”)[0],
//     'guests' : this.state.guests,
//     'breakfastService': this.state.showBreakfast,
//     'carParkingService': this.state.showCarParking,
//     'spaService': this.state.showSpaService,
//     'laundryService': this.state.showLaundryService,
//     'shuttleService': this.state.showShuttleService,
//     'codeDiscount' : this.state.discountCode,
//     'totalPrice' : '0',
// }
function BookingForm(props) {
    const [firstFocus, setFirstFocus] = React.useState(false);
    const [lastFocus, setLastFocus] = React.useState(false);
    const [checkIn, setCheckIn] = React.useState(null);
    const [checkOut, setCheckOut] = React.useState(null);

    React.useEffect(() => {


        console.log("booking.props: ", props)

    }, [props]);


    function calculatePrice() {
        // aplicar logica

        props.priceFunc(5)
        
    }


    function updateBookDates(checkIn, checkOut) {
        setCheckIn(checkIn)
        setCheckOut(checkOut)
        props.detailDates(checkIn, checkOut)
        console.log("CheckIN en BOOKINGFORM:", checkIn )
        console.log("CheckOUT en BOOKINGFORM:", checkOut )
        console.log("CheckOUT en PROPS-BOOKINGFORM:", props )
    }


    function SaveBooking(event) {
        console.log(event)
        console.log()
        event.preventDefault()
        let bookingData = {
            'id_habitacion': props.habitacion.id,
            'cliente_id': props.client.id,
            'fechaIn': checkIn,
            'fechaOut': checkOut,
            'precioTotal': props.habitacion.precio,
        }

        BookingService.saveBooking(bookingData)
        console.log("Saved Booking Data", bookingData)


    }

    return (
        <React.Fragment>
            <div className="text-center">

                <Container>
                    {/* <h3 className="title">Booking Confirmation</h3> */}

                    <Row>
                        <Col>
                            <InputGroup
                                className={
                                    "input-lg" + (lastFocus ? " input-group-focus" : "")
                                }
                            >
                                <InputGroupAddon addonType="prepend">
                                    <InputGroupText>
                                        <i className="now-ui-icons ui-1_email-85"></i>
                                    </InputGroupText>
                                </InputGroupAddon>
                                <Input
                                    placeholder="Email..."
                                    type="email"
                                    onFocus={() => setLastFocus(true)}
                                    onBlur={() => setLastFocus(false)}
                                ></Input>
                            </InputGroup>
                            <InputGroup
                                className={
                                    "input-lg" + (firstFocus ? " input-group-focus" : "")
                                }
                            >
                                <InputGroupAddon addonType="prepend">
                                    <InputGroupText>
                                        <i className="now-ui-icons users_circle-08"></i>
                                    </InputGroupText>
                                </InputGroupAddon>
                                <Input
                                    placeholder="First Name..."
                                    type="text"
                                    onFocus={() => setFirstFocus(true)}
                                    onBlur={() => setFirstFocus(false)}
                                ></Input>
                            </InputGroup>
                            <InputGroup
                                className={
                                    "input-lg" + (lastFocus ? " input-group-focus" : "")
                                }
                            >
                                <InputGroupAddon addonType="prepend">
                                    <InputGroupText>
                                        <i className="now-ui-icons ui-1_email-85"></i>
                                    </InputGroupText>
                                </InputGroupAddon>
                                <Input
                                    placeholder="Email..."
                                    type="select"
                                    onFocus={() => setLastFocus(true)}
                                    onBlur={() => setLastFocus(false)}
                                ></Input>
                            </InputGroup>
                        </Col>

                        <MyDatePicker onChange2={updateBookDates.bind(this)} excludedDates={props.excludedDates} />

                    </Row>

                    <div className="send-button">
                        <Button
                            block
                            className="btn-round"
                            color="info"
                            href="#pablo"
                            onClick={SaveBooking}
                            size="lg"
                        >
                            Save Booking
                  </Button>
                    </div>

                    <div className="send-button">
                        <Button
                            block
                            className="btn-round"
                            color="info"
                            href="#pablo"
                            onClick={calculatePrice}
                            size="lg"
                        >
                            prop test
                  </Button>
                    </div>


                </Container>
            </div>
        </React.Fragment>
    )






}
const mapStateToProps = state => ({
    client: state.clientModel.client
  })
  
export default connect(mapStateToProps)(BookingForm)