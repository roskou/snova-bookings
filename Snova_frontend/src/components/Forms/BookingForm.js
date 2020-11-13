import React from "react";
import BookingService from "services/BookingService.js"
import MyDatePicker from "components/DatePicker/MyDatePicker";
import { connect } from 'react-redux'
import { useHistory } from "react-router-dom";

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


function BookingForm(props) {
    const [firstFocus, setFirstFocus] = React.useState(false);
    const [lastFocus, setLastFocus] = React.useState(false);
    const [checkIn, setCheckIn] = React.useState(null);
    const [checkOut, setCheckOut] = React.useState(null);
    const history = useHistory()

    React.useEffect(() => {


        console.log("booking.props: ", props)

    }, [props]);


    function updateBookDates(checkIn, checkOut) {

        setCheckIn(checkIn)
        setCheckOut(checkOut)


        props.detailDates(checkIn, checkOut)

        console.log("CheckIN en BOOKINGFORM:", checkIn)
        console.log("CheckOUT en BOOKINGFORM:", checkOut)
        console.log("CheckOUT en PROPS-BOOKINGFORM:", props)
        console.log("CheckOUT en BUTTON STATUS:", props.buttonCheck)

    }

    function SaveBooking(event) {

        event.preventDefault()

        let bookingData = {
            'id_habitacion': props.habitacion.id,
            'cliente_id': props.client.id,
            'fechaIn': checkIn,
            'fechaOut': checkOut,
            'precioTotal': props.habitacion.precio,
            'cupon': null,
        }

        BookingService.saveBooking(bookingData)

        console.log("Saved Booking Data", bookingData)
        history.push("/thanks");
    }


    return (
        <React.Fragment>
            <div className="text-center">

                <Container>
                    {/* <h4 className="title"></h4> */}

                    <Row>
                        <div className="pt-4 pl-3 pb-2">
                            <p className="font-weight-bold">Select your preferences</p>
                        </div>
                        <Col sm={12}>
                            <MyDatePicker onChange2={updateBookDates.bind(this)} excludedDates={props.excludedDates} />
                        </Col>
                    </Row>
                    <Row>
                        <Button
                            block
                            className="btn-round "
                            color="info"
                            href="#pablo"
                            onClick={SaveBooking}
                            size="lg"
                            disabled={!props.buttonCheck}

                        >
                            Save Booking
                  </Button>
                  </Row>




                </Container>
            </div>
        </React.Fragment>
    )






}
const mapStateToProps = state => ({
    client: state.clientModel.client,
    buttonCheck: state.buttonCheck.status_button
})

export default connect(mapStateToProps)(BookingForm)