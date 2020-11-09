import React, { Component } from 'react';
import BookingsService from 'services/BookingsService.js'

class ListReservaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            reservas: []
        }
    }

    componentDidMount(){
        BookingsService.getBookings().then((res) => {
            this.setState({ reservas : res.data });

        });
    }

    render() {
        return (
            <div>
                <h2 className = "text-center">Lista de Reservas SPRING + REACT</h2>
                <div className = "Row" >
                    <table className = "table table-striped table-bordered">

                    <thead>
                        <tr>
                            <th>Fecha In</th>
                            <th>Fecha Out </th>
                            <th>Precio</th>
                            <th>Cliente</th>
                        </tr>
                    </thead>
                    <tbody>

                                {
                                    this.state.reservas.map(
                                        reservas => 
                                        <tr key = {reservas.id}>
                                             <td> {reservas.fechaIn} </td>   
                                             <td> {reservas.fechaOut}</td>
                                             <td> {reservas.precioTotal}</td>
                                             <td> {reservas.cliente.email}</td>                            
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }

}

export default ListReservaComponent


