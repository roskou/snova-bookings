import React from 'react'
import SearchForm from 'components/SearchForm';
import { shallow } from 'enzyme';

describe ('Search form unit test', () => {
    test('it should render without crashing', () => {
        const wrapper = shallow(<SearchForm />);
        expect(wrapper).toMatcSnapshot();
    });

    test('should have required inputs',() =>{
        const wrapper = shallow(<SearchForm />);
        expect(wrapper.find('input [name="price_from]')).toHaveLenght(1);
        expect(wrapper.find('input [name="price_to]')).toHaveLenght(1);
        expect(wrapper.find('input [name="guest_from]')).toHaveLenght(1);
        expect(wrapper.find('input [name="type]')).toHaveLenght(1);
        expect(wrapper.find('input [name="date_from]')).toHaveLenght(1);
        expect(wrapper.find('input [name="date_to]')).toHaveLenght(1);
    });

    test('should run onChange with the new state',() =>{
        const updateFilter = jest.fn();
        
        const wrapper = shallow(<SearchForm onChangeFilter={updateFilter}/>);
        
        wrapper.find('input[name="price_from"]').simulate('change', {target:{ name:'price_from' , value:'250' }})
        
        expect(updateFilter).toHaveBeenCalledWith({
            price_from:'',
            price_to:'',
            localidad:'',
            guest_form:'',
            date_from:'',
            date_to:'',
        })


    });
});