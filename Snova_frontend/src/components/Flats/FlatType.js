import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import FlatService from 'services/FlatService.js';
import "assets/css/rooms.css";
class FlatType extends Component {
    constructor(props) {
        super(props)
        this.state = {
            types: [],
        }
    }
    componentDidMount() {
        FlatService.getFlatTypes().then((res) => {
            this.setState({ types: res.data });
        });
    }
    render() {
        return (
            <section class="rooms-area section-padding-100-0">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="section-heading text-center">
                            <h1>What Experience Do You Want To Have?</h1>
                        </div>
                        {
                            this.state.types.map(
                                types =>
                                    <div id="tipo" class="col-12 col-md-6 col-lg-6" >
                                        {/* <!-- Thumbnail --> */}
                                        <div class="single-rooms-area">
                                            <div className="bg-thumbnail bg-img img-raised"
                                                key={types.id}
                                                style={{ backgroundImage: "url(" + require("assets/img/house_type_" + String([types.id]) + ".png") + ")" }}>
                                            </div>
                                            {/* <!-- Price  --> */}
                                            {/* <p class="price-from">Desde 100 €/noche</p> */}
                                            {/* <!-- Rooms Text --> */}
                                            <Link to={"listByType/" + types.id}><div className="rooms-text">
                                                <div class="line"></div>
                                                <h5>{types.nombre}</h5>
                                                <p>{types.descripcion}</p>
                                            </div></Link>
                                        </div>
                                    </div>
                            )}
                    </div>
                </div>
            </section>
        )
    }
}
export default FlatType