import { combineReducers } from 'redux';
import { USER_MODEL } from 'redux/actions.js'



export const log = (state = {}, action) => {
    switch (action.type) {
      case 'LOG_IN':
        
        return action.log;

      case 'LOG_OUT':
        return {};

          
      case 'USER_NAME':
        return action.clientModel;
    
        
      default:
        return state;
    }
  };

  export const clientModel = (state = {}, action) => {
    switch (action.type) {

          
      case 'USER_NAME':
        return action.clientModel;
    
        
      default:
        return state;
    }
  };
  
  export const reducers = combineReducers({
    log, clientModel,
  });