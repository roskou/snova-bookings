import axios from 'axios'

const FLAT_API_BASE_URL = 'http://localhost:8080/api';

export async function costCalculate(costData) {
    var config = {
      method: 'post',
      url: cost, // url del Back
      headers: { 
        'Content-Type': 'application/json'
      },
      data : costData
    };
    const response = await axios(config);
    // const price = await response.price;
    console.log('costCalculate.book: ',costData)
    // console.log('getBookPrice.data: ',data);
    return data;
  }