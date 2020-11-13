import React, { Component } from 'react';
import FlatService from 'services/FlatService.js'
import SearchForm from 'components/Forms/SearchForm'
import LogUser from 'components/Forms/LoginForm'
import { isDateBetween } from '../services/DateService.js';
import IndexNavbar from "components/Navbars/IndexNavbar.js";
import FlatThumbNail from 'components/FlatThumbNail.js';
import { Row,Col } from "reactstrap";
import "assets/css/search.css"
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
        <>
            <IndexNavbar />
            <section className="SearchView">
                <div class="container">
                    <div class="row justify-content-center">
                    <h1>Search your Apartment</h1><LogUser />
                    <Row>
                    <Col md={8}>
                        {roomsFiltered.map((room) => (
                            <div id="tipo">
                                <div class="single-rooms-area">
                                    <FlatThumbNail room={room} ></FlatThumbNail>
                                </div>
                            </div>
                        ))}
                    </Col>
                    <Col md={4}>
                        <div className="p-4">
                        <p className="font-weight-bold">Select your preferences</p>
                        <SearchForm onChangeFilter={this.setFilter.bind(this)}/>
                        </div>
                    </Col>
                    </Row>
                    </div>
                </div>
            </section>
        </>
        )
    }
}
export default SearchView