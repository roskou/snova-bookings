import React, { useState } from 'react';
import { Row, Col, FormGroup, Input, Button } from "reactstrap";
const initialFilter = {
  price_from: '',
  price_to: '',
  localidad: '',
  guest_from:'',
  pax_from: '',
  date_from: '',
  date_to: '',
};
const SearchForm = (props) => {
  const [filter, setFilter] = useState(initialFilter);
  function handleChange(event) {
    const newFilter = {
      ...filter,
      [event.target.name]: event.target.value,
    };
    setFilter(newFilter);
    props.onChangeFilter(newFilter);
  }
  function resetFilter() {
    setFilter(initialFilter);
    props.onChangeFilter(initialFilter);
  }
  return (
    <div className='filter'>
      <Row>
        <Col sm={12}>
          <FormGroup>
            <Input
              type='number'
              placeholder='Price from'
              name='price_from'
              value={filter.price_from}
              onChange={handleChange}
            ></Input>
          </FormGroup>
        </Col>
        <Col sm={12}>
        <FormGroup>
            <Input
            type='number'
            placeholder='Price to'
            name='price_to'
            value={filter.price_to}
            onChange={handleChange}
          ></Input>
          </FormGroup>
        </Col>
        <Col sm={12}>
        <FormGroup>
            <Input
            type='number'
            placeholder='Minimum guests'
            name='guest_from'
            value={filter.guest_from}
            onChange={handleChange}
            ></Input>
          </FormGroup>
        </Col>
        <Col sm={12}>
        <FormGroup>
            <Input
            type='text'
            placeholder='Localidad'
            name='localidad'
            value={filter.localidad}
            onChange={handleChange}
            ></Input>
          </FormGroup>
        </Col>
        <Col sm={12}>
        <FormGroup>
            <Input
            type='date'
            placeholder='Date From'
            name='date_from'
            value={filter.date_from}
            onChange={handleChange}
            ></Input>
          </FormGroup>
        </Col>
        <Col sm={12}>
        <FormGroup>
            <Input
            type='date'
            placeholder='Date To'
            name='date_to'
            value={filter.date_to}
            onChange={handleChange}
            ></Input>
          </FormGroup>
        </Col>
        <Col sm={12} className="text-center">
          <Button onClick={resetFilter}>Reset Filter</Button>
        </Col>
      </Row>
    </div>
  )
}
export default SearchForm