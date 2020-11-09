import React, { Component } from 'react';
import { Link } from 'react-router-dom'
import { Button } from 'reactstrap';
import FlatService from 'services/FlatService.js'

class ListAllFlats extends Component {
    constructor(props) {
        super(props)

        this.state = {
            
            value: "",
            filterData: [],
            flats: []
        }
    }

    componentDidMount(){
        FlatService.getAllFlat(this.state.tipo).then((res) => {
            this.setState({ flats : res.data });
        });
    }

      reset = e => {
        this.setState({
          filterData: this.state.flats
          

        });
      };
    
      filterListLoc = e => {
        const updatedList = this.state.flats.filter(item => {
          return (
            item.localidad.toLowerCase().search(e.target.value.toLowerCase()) !== -1
          );
        });
        this.setState({ filterData: updatedList });
      };

      filterListPrice = e => {
        const updatedList = this.state.flats.filter(item => {
          return (
            item.precio.toString().toLowerCase().search(e.target.value.toLowerCase()) !== -1
          );
        });
        this.setState({ filterData: updatedList });
      };

      filterListM2 = e => {
        const updatedList = this.state.flats.filter(item => {
          return (
            item.m2.toString().toLowerCase().search(e.target.value.toLowerCase()) !== -1
          );
        });
        this.setState({ filterData: updatedList });
      };

      filterListPax = e => {
        const updatedList = this.state.flats.filter(item => {
          return (
            item.m2.toString().toLowerCase().search(e.target.value.toLowerCase()) !== -1
          );
        });
        this.setState({ filterData: updatedList });
      };
    

    render() {
        
        const searchBoxLoc = (
            <input
              type="text"
              onChange={this.filterListLoc}
              
            />
          );

          const searchBoxprice = (
            <input
              type="text"
              onChange={this.filterListPrice}
              
            />
          );

          const searchBoxM2 = (
            <input
              type="text"
              onChange={this.filterListM2}
              
            />
          );

          const searchBoxPax = (
            <input
              type="text"
              onChange={this.filterListPax}
              
            />
          );
          const selectBox = this.state.filterData.map(option => (
            <li key={option.id}>{option.localidad} - {option.precio}</li>
          ));;

        return (
            <div>
                   <React.Fragment>
                     <h2>- Filtro -</h2>
                      <label>Localidad</label> {searchBoxLoc}
                      <label>Precio</label> {searchBoxprice}
                      <label>Superficie</label> {searchBoxM2}
                      <label>Pax</label> {searchBoxPax}

                      <Button color="primary" onClick={this.reset} size="sm">Reset</Button>
                       {selectBox && <ul>{selectBox}</ul>} 
                    </React.Fragment>
                <h2 className = "text-center">Lista de Todos los Pisos</h2>
                <div className = "Row" >
                    
                    <table className = "table table-striped table-bordered">

                    <thead>
                        <tr>
                            
                            <th>nombre </th>
                            <th>Descripcion</th>
                            <th>Pax</th>
                            <th>Precio</th>
                            <th>m2</th>
                            <th>Localidad</th>
                        </tr>
                    </thead>
                    <tbody>

                                {
                                    this.state.filterData.map(
                                        flats => 
                                        <tr key = {flats.id}>
                                             <td> {flats.codigo} </td>   
                                             <td> {flats.descripcion}</td>
                                             <td> {flats.numpersonas}</td>
                                             <td> {flats.precio}</td>
                                             <td> {flats.m2}</td> 
                                             <td> {flats.localidad}</td>
                                             <Button to="http://localhost:8080/api/flatID/1"  size="sm">flat_{flats.id}</Button>                            
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

export default ListAllFlats