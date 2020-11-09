import axios from 'axios';

const FLAT_API_BASE_URL = "http://localhost:8080/api";

class FlatService{

    async getAllFlatType(){
        return await axios.get( FLAT_API_BASE_URL + '/flatType');
    }

    async getAllFlat(){
        return await axios.get( FLAT_API_BASE_URL + '/flat');
    }

    
    async getFlatById(id){
        return await axios.get( FLAT_API_BASE_URL + '/flatID/' + id);
    }
    
}

export default new FlatService()