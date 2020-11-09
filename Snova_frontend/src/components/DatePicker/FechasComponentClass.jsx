import React, { Component } from 'react';
import { FormGroup, Row, Col } from "reactstrap";
import ReservaService from 'services/ReservaService.js';

import DatePicker from "react-datepicker";
import { registerLocale } from  "react-datepicker";
import es from 'date-fns/locale/es';
import "react-datepicker/dist/react-datepicker.css";

registerLocale('es', es)



class FechasComponentClass extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            fechas: [],
          
        }
    }

    componentDidMount(){
        ReservaService.getFechasReservaHabitacion(this.state.id).then((res) => {
            let elem = [];
            for (let index = 0; index < res.data.length; index++) {
                elem[index] = new Date(res.data[index]);}
            this.setState({ fechas : elem});
            
            console.log("Test" + elem)
        });
        
    }

    render() {
        console.log(this.state.fechas)

    



        return (
            <div>
                <h2 className = "text-center">Fechas Reserva por Habitacion SPRING + REACT </h2>

            <br></br>
            <Col md="6">
              <h4>CheckIn</h4>
              <Row>
                <Col md="6">
                  <div className="container">
                    <FormGroup>
                      <DatePicker  
                                 selected={startDate}
                                 startDate = {startDate}
                                 endDate={endDate}
                                 onChange={onChange}
                                 minDate={new Date()}
                                 excludeDates={this.state.fechas}
                                 selectsRange
                                 locale="es"
                         

                      
                      />              
                    </FormGroup>
                  </div>
                </Col>
              </Row>
 
            </Col>
        </div>
                    
        )
    }

}



export default FechasComponentClass