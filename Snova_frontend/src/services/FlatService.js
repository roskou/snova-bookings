import axios from 'axios';

const FLAT_API_BASE_URL = "http://localhost:8080/api";

class FlatService{

    async getFlatTypes(){
        return await axios.get( FLAT_API_BASE_URL + '/flatType');
    }

    async getAllFlatByTypeID(type){
        return await axios.get( FLAT_API_BASE_URL + '/flatAllByType/' + type);
    }

    async getAllFlat(){
        return await axios.get( FLAT_API_BASE_URL + '/flat');
    }

    
    async getFlatById(id){
        return await axios.get( FLAT_API_BASE_URL + '/flatID/' + id);
    }
    
}

export default new FlatService()