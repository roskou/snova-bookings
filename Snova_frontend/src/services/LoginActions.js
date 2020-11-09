import axios from 'axios';
export const USER_MODEL = 'USER_MODEL';
const FLAT_API_BASE_URL = 'http://localhost:8080/api';

export async function loginCheck(mail) {
    const loginData = {"email": mail}
    var config = {
      method: 'post',
      url: (FLAT_API_BASE_URL + "/login/"), // url del Back
      headers: { 
        'Content-Type': 'application/json'
      },
      data : loginData
    };
    const response = await axios(config);
    const userData = await response.data;
  
    return {
      type: USER_MODEL,
      payload: userData};
  
      }
  