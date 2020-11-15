import React from "react";
import BookingService from "services/BookingService.js"
import MyDatePicker from "components/DatePicker/MyDatePicker";
import { connect } from 'react-redux'
import { booking_invoice } from 'redux/actions.js';
import { useHistory } from "react-router-dom";

// reactstrap components
import { Button,Container,Row,Col, Card } from "reactstrap";

function BookingForm(props) {
    const [checkIn, setCheckIn] = React.useState(new Date());
    const [checkOut, setCheckOut] = React.useState(new Date());
    const [invoiceData, setBookingInvoice] = React.useState({});
    const [roomLocation, setRoomLocation] = React.useState(props.roomLocation);
    const [roomName, setRoomName] = React.useState(props.roomName);
    const history = useHistory()

    React.useEffect(() => {
    }, [props]);

    function updateBookDates(checkIn, checkOut) {
        setCheckIn(checkIn)
        setCheckOut(checkOut)
        setRoomLocation(props.roomLocation)
        setRoomName(props.roomName)
        let costData = {
            'preCheckIn': checkIn,
            'preCheckOut': checkOut,
            'client': props.client ? props.client.id : 0,
            'idRoom': props.idRoom
        }
        BookingService.getPrice(costData).then(res => setBookingInvoice(res))
    }

    function SaveBooking(event) {

        event.preventDefault()

        let bookingData = {
            'id_habitacion': props.idRoom,
            'cliente_id': props.client.id,
            'fechaIn': checkIn,
            'fechaOut': checkOut,
            'precioTotal': invoiceData.finalPrice,
            'cupon': null,
        }

        BookingService.saveBooking(bookingData).then(res =>
                {if (res === "OK") {
                    //redux metiendo invoiceData
                    props.booking_invoice({price: invoiceData.finalPrice, checkIn, checkOut, roomLocation, roomName})
                    console.log("HABITACION:" + props.roomLocation)
                    history.push("/thanks");
                }}
            )
    }
    

    return (
        <React.Fragment>
            <div className="text-center pb-1">
            <Card body>

                    <Row>                       
                        <div className="pt-1 pl-3 pb-1">
                            <p className="font-weight-bold">Select your preferences</p>
                        </div>
                      
                        <Col sm={12}>
                            <MyDatePicker onChange2={updateBookDates.bind(this)} excludedDates={props.excludedDates} />
                        </Col>
                    </Row>
                    <br></br>
                    <br></br>

                    
                    <div className="Invoice">
                        {/* Room Price: {invoiceData.finalPrice + (-1 * invoiceData.additionalCharges)}<br></br> */}
                        {/* Adittional Charges or Discounts: {invoiceData.additionalCharges}<br></br><br></br> */}
                        
                    {invoiceData.invoiceRows && <Row>{invoiceData.invoiceRows.map(rows =>
                        <div keys={rows.id}>
                            {rows.description} per {rows.days} days  = {rows.price}€

                        </div>)}
                        
                        <h4>Total Price: {invoiceData.finalPrice}</h4>
                    </Row>}
                    </div>

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
                </Card>
            </div>
            
        </React.Fragment>
    )
}

const mapDispatchToProps = {
    booking_invoice,    
  };
  
const mapStateToProps = state => ({
    client: state.clientModel.client,
    buttonCheck: state.buttonCheck.status_button, 
    invoice: state.invoice.booking_invoice
})

export default connect(mapStateToProps,mapDispatchToProps)(BookingForm)