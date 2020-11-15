  export const logIn = log => ({
    type: 'LOG_IN',
    log,
    
  });

  export const logOut = () => ({
    type: 'LOG_OUT',
  });

  export const status_button = buttonCheck => ({
    type: 'LOG_CHECK',
    buttonCheck,
  });

  export const booking_invoice = invoice => ({
    type: 'INVOICE_DATA',
    invoice,
  });

  export const client = clientModel => ({
    type: 'USER_NAME',
    clientModel,
  });

