import React, { useEffect, useState } from "react";
import DatePicker, { registerLocale } from "react-datepicker";
import es from 'date-fns/locale/es';
import "react-datepicker/dist/react-datepicker.css";

//import "assets/css/datepicker.css";
registerLocale('es', es)



// CSS Modules, react-datepicker-cssmodules.css
// import 'react-datepicker/dist/react-datepicker-cssmodules.css';


function MyDatePicker(props) {
  const disabledDates = [];
  const [startDate, setStartDate] = useState(null);
  const [endDate, setEndDate] = useState(null);

  useEffect(() => {

    const dates = props.excludedDates

    for (let index = 0; index < dates.length; index++) {
      disabledDates[index] = new Date(dates[index]);
    }

  }, [props]);



  const onChange = dates => {
    const [start, end] = dates;
    setStartDate(start);
    setEndDate(end);
    if (start !== startDate) {
      
    }
    else if (end) {
       props.onChange2(start, end)
       console.log("DATEPICKER",start,end)
    }

  }

  return (
    <React.Fragment>
      <DatePicker
        onChange={onChange}
        startDate={startDate}
        endDate={endDate}
        excludeDates={disabledDates}
        selectsRange
        minDate= {new Date()}
        inline
        locale="es"
      />

    </React.Fragment>
  );
};


export default MyDatePicker