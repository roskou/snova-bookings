import React, { useState } from "react";
import { Link } from 'react-router-dom';
function FlatThumbNail(props) {
    let room = props.room;
    return (
        <>
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
                <p>{room.roomModel.localidad}: {room.roomModel.descripcion}</p>
                <p>PAX: {room.roomModel.numpersonas} | {room.roomModel.m2} m2</p>
            </div></Link>
        </>
    );
}
export default FlatThumbNail;