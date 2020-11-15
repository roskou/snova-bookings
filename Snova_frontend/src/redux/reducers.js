import { combineReducers } from 'redux';


export const log = (state = {}, action) => {
    switch (action.type) {
      case 'LOG_IN':
        
        return action.log;

      case 'LOG_OUT':
        return {};

       
      default:
        return state;
    }
  };

  export const clientModel = (state = Boolean, action) => {
    switch (action.type) {

          
      case 'USER_NAME':
        return action.clientModel;
    
        
      default:
        return state;
    }
  };

  export const buttonCheck = (state = {}, action) => {
    switch (action.type) {

      case 'LOG_CHECK':
        return action.buttonCheck;
    
        
      default:
        return state;
    }
  };

  export const invoice = (state = {}, action) => {
    switch (action.type) {

      case 'INVOICE_DATA':
        return action.invoice;
            
      default:
        return state;
    }
  };
  
  export const reducers = combineReducers({
    log, clientModel, buttonCheck, invoice,
  });