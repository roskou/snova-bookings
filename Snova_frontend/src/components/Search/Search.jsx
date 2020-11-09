import React, { useEffect, useState } from 'react';
import { getRooms } from '../../services/ApiService';
import { Link } from 'react-router-dom';
import FlatService from 'services/FlatService.js'
import { isDateBetween } from '../../services/DateService.js';

const initialFilter = {
  price_from: '',
  price_to: '',
  localidad: '',
  guest_from: '',
  date_from:'',
  date_to:  '',
};

function Search(props) {
  const [rooms, setRooms] = useState([]);

  const [filter, setFilter] = useState(initialFilter);



useEffect(() => {
    // getRooms().then((data) => setRooms(data));
    const tipo = props.match.params.tipo
    FlatService.getAllFlatByTypeID(tipo).then((res) => setRooms(res.data));
    
  },[props.match.params.tipo]);


  function handleChange(event) {
    setFilter({
      ...filter,
      [event.target.name]: event.target.value,
    });
  }
  function resetFilter(event) {
    setFilter(initialFilter);
  }

  const roomsFiltered = rooms.filter((room) => {
    let validPricePerNightFrom = filter.price_from
      ? room.roomModel.precio >= +filter.price_from
      : true;
    let validPricePerNightTo = filter.price_to
      ? room.roomModel.precio <= +filter.price_to
      : true;
    let validGuest = filter.guest_from
      ? room.roomModel.numpersonas >= +filter.guest_from
      : true;
    //let validLocation = filter.type ? room.localidad === filter.type : true;
      let validLocation = room.roomModel.localidad.toUpperCase().includes(filter.localidad.toUpperCase());

    let validDate = !room.dates.some(
      (date) =>
        isDateBetween(date, filter.date_from, filter.date_to),
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
          {roomsFiltered.map((room) => (
          <div id="tipo" class="col-12 col-md-6 col-lg-4" >          
          <div class="single-rooms-area">		
					<div className="bg-thumbnail bg-img img-raised"  
					key={room.id}
					style={{backgroundImage: "url(" + require("assets/img/house_type_" + room.roomModel.tipoModel.id + ".png") + ")"}}>

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
    
    



  );
}

export default Search;