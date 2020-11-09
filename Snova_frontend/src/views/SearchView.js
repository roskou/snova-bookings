import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import FlatService from 'services/FlatService.js'
import SearchForm from 'components/Forms/SearchForm'
import LogUser from 'components/Forms/LoginForm'
import { isDateBetween } from '../services/DateService.js';

class SearchView extends Component {

    constructor(props) {
        super(props)

        this.state = {
            tipo: props.match.params.tipo,
            rooms: [],
            filter:{
                price_from: '',
                price_to: '',
                localidad: '',
                guest_from: '',
                date_from:'',
                date_to:  '',
            }
        }
    }

    componentDidMount() {
        FlatService.getAllFlatByTypeID(this.state.tipo).then((res) => {
            this.setState({ rooms: res.data });
        });
    }

    setFilter(data){
        this.setState({filter: data})
    }

    render() {
        console.log('SEARCH:', this.props.log)
        const roomsFiltered = this.state.rooms.filter((room) => {
            let validPricePerNightFrom = this.state.filter.price_from
              ? room.roomModel.precio >= +this.state.filter.price_from
              : true;
            let validPricePerNightTo = this.state.filter.price_to
              ? room.roomModel.precio <= +this.state.filter.price_to
              : true;
            let validGuest = this.state.filter.guest_from
              ? room.roomModel.numpersonas >= +this.state.filter.guest_from
              : true;
            //let validLocation = this.state.filter.type ? room.localidad === this.state.filter.type : true;
              let validLocation = room.roomModel.localidad.toUpperCase().includes(this.state.filter.localidad.toUpperCase());
        
            let validDate = !room.dates.some(
              (date) =>
                isDateBetween(date, this.state.filter.date_from, this.state.filter.date_to),
            );
        
            return (
              validPricePerNightFrom &&
              validPricePerNightTo &&
              validGuest &&
              validLocation &&
              validDate
            );
          });

        return (

            <section class="rooms-area section-padding-100-0">
                <div class="container">
                
                    <div class="row justify-content-center">
                    <h1>Search your Apartment</h1><LogUser />
                    <SearchForm onChangeFilter={this.setFilter.bind(this)}/>
                        {roomsFiltered.map((room) => (
                            <div id="tipo" class="col-12 col-md-6 col-lg-4" >
                                <div class="single-rooms-area">
                                    <div className="bg-thumbnail bg-img img-raised"
                                        key={room.id}
                                        style={{ backgroundImage: "url(" + require("assets/img/house_type_" + room.roomModel.tipoModel.id + ".png") + ")" }}>

                                    </div>
                                    {/* <!-- Price  --> */}
                                    <p class="price-from">Desde {room.roomModel.precio} €/noche</p>

                                    {/* <!-- Rooms Text --> */}
                                    <Link to={"../flatDetail/" + room.roomModel.id}><div className="rooms-text">

                                        <div class="line"></div>
                                        <h5>{room.roomModel.codigo}</h5>
                                        <p>{room.roomModel.localidad}</p>
                                        <p>{room.roomModel.descripcion}</p>
                                        <p>{room.roomModel.m2} m2 | PAX: {room.roomModel.numpersonas}</p>
                                        <p>ID: {room.roomModel.id}</p>

                                    </div></Link>

                                </div>
                            </div>

                        ))}

                    </div>
                </div>
            </section>




        )
    }


}

export default SearchView