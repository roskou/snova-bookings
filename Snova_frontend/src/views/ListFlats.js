import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import FlatService from 'services/FlatService.js'

class ListFlats extends Component {
    constructor(props) {
        super(props)

        this.state = {
            tipo: this.props.match.params.tipo,
            value: "",
            filterData: [],
            flats: []
        }
    }

    componentDidMount() {
        FlatService.getAllFlatByTypeID(this.state.tipo).then((res) => {
            this.setState({ flats: res.data });
        });
    }


    render() {

      

        return (
            <div>
                <React.Fragment>
                    <h2>- Filtro -</h2>
                    <h3>Selecciona una localidad</h3>
                    <label>Localidad</label> {searchBoxLoc}<label>Precio</label>{searchBoxprice}
                    {selectBox && <ul>{selectBox}</ul>}
                </React.Fragment>
                <h2 className="text-center">Lista de Casas por Tipo</h2>
                <div className="Row" >
                    {
                        this.state.filterData.map(
                            flats =>

                                <div className="row" style={{ margin: '50px' }}>
                                    <div className="col-md-6 col-sm-6">
                                        <img src={require("assets/img/house_type_3.png")}></img>
                                    </div>
                                    <div className="col-md-6 col-sm-6" key={flats.id}>
                                        <h2>{flats.localidad}</h2>
                                        <p className="price"><h3>{flats.precio} &#8364;<small>/ night</small></h3></p>
                                        <p>{flats.descripcion}</p>
                                        <p><Link className="btn btn-primary" to={"../flatDetail/" + flats.id}>Book Now!</Link></p>
                                    </div>
                                </div>
                        )
                    }
                </div>
            </div>
        )
    }

}

export default ListFlats