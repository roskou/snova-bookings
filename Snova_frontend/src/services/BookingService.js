import axios from 'axios';

const RESERVA_API_BASE_URL = "http://localhost:8080/api";

class BookingService{

    async getBookins(){
        return await axios.get( RESERVA_API_BASE_URL + '/bookingnow');
    }

    
    async getDatesBookingsByRoom(id){
        return await axios.get( RESERVA_API_BASE_URL + '/date/' + id);
    }

    async saveBooking(bookingData){
        let resp;
        let config = {
          method: 'post',
          url: (RESERVA_API_BASE_URL + '/bookingnow'),
          headers: { 
            'Access-Control-Allow-Origin':'*',
            'Content-Type': 'application/json', 
          },
          data : bookingData
        };
        await axios(config)
          .then((response) => {
              console.log("DATOS GUARDADOS OK")
              resp = response.data
          })
          .catch(function (error) {
            console.log(error);
          });
        return resp;
}

async getPrice(costData){
  let resp;
  let config = {
    method: 'post',
    url: (RESERVA_API_BASE_URL + '/cost'),
    headers: { 
      'Access-Control-Allow-Origin':'*',
      'Content-Type': 'application/json', 
    },
    data : costData
  };
  await axios(config)
    .then((response) => {
        console.log("CALCULO EN BACK 'OK'")
        resp = response.data
    })
    .catch(function (error) {
      console.log(error);
    });
  return resp;
}
    
}

export default new BookingService()