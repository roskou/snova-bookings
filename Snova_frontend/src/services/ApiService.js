import axios from 'axios'

const API_URL = 'http://localhost:8080/api';

export async function getRooms() {
    //return await fetch(API_URL + '/flat').then(data => data.json());
    return await axios(API_URL + '/flat');

}