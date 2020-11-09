import axios from 'axios'




const FLAT_API_BASE_URL = 'http://localhost:8080/api';

class LoginService{

    async loginCheck(userEmail) {
    var config = {
      method: 'post',
      url: (FLAT_API_BASE_URL + '/login/'), // url del Back
      headers: { 
        'Content-Type': 'application/json'
      },
      data : userEmail
    };
    const response = await axios(config);
    const userData = await response.data;
    console.log('getUserModel.book: ',)
    sessionStorage.setItem('clientModel', JSON.stringify(userData));


 
    return userData;
  }



}

export default new LoginService
