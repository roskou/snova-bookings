  export const logIn = log => ({
    type: 'LOG_IN',
    log,
    
  });

  export const logOut = () => ({
    type: 'LOG_OUT',
  });

  export const client = clientModel => ({
    type: 'USER_NAME',
    clientModel,
  });






  // export const storeUserModel = userData => ({
    
  //     type: 'USER_MODEL',
  //     payload: userData,
    
  // });