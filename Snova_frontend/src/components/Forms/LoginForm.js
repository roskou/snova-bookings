
import React, { useState } from 'react';
import { connect } from 'react-redux';
import { logIn, logOut, client } from 'redux/actions.js';
import LoginService from 'services/LoginService'

// reactstrap components
import {
  Button,
  Input,
  InputGroupAddon,
  InputGroupText,
  InputGroup,
  Container,
  Row,
  Col,
} from "reactstrap";



export class LogUser extends React.Component {
  constructor(props) {

    super(props);
    this.state = {
      client : []
  }

    this.userEmail = React.createRef();
    this.logInEvent = this.logInEvent.bind(this);
    this.logOutEvent = this.logOutEvent.bind(this);
    

  }
  

  async logInEvent() {
    
    let mail = this.userEmail.current.value;
    console.log("BOTON IN")
    console.log(mail);
    let loginData = {"email": mail}
    
    const logged = await LoginService.loginCheck(loginData)  // ejecuto query para validar email y recoger objeto cliente
    //console.log("Objeto leido del SEssionStorage",logged)

  
    if ((logged.email !== null)){
    this.props.log.validUser = true 
    this.props.client({ client : logged }); //guarda objeto en redux
    console.log('EMAIL CORRECTO', this.props.client)
    this.props.logIn({ title : mail })
    }else{
      // this.props.logIn({ title: 'this mail not exits' })
      console.log('EMAIL INCORRECTO', this.props.log.usuario)  
      this.props.log.validUser = false
      this.props.log.usuario = {};
      this.props.logIn({ title: 'Email not Found' })

    }

    

  }

  logOutEvent() {
    
    console.log("BOTON OUT")
    this.userEmail.current.value = ""
    console.log(this.userEmail.current.value);
    this.props.logOut({ title: '' })
    sessionStorage.setItem('clientModel', JSON.stringify('{}'))
    this.props.log.validUser = false;

  }

  
  render() {
        
    console.log("PROPS REDUX", this.props)
    return (
      <div>

        <input
          ref={this.userEmail}
          placeholder="Email..."
          type="email"         
        ></input>

         <h1>{this.props.log.title || 'Not logged'}</h1> 
        {/* <h1>{this.state.patata ? <div>{this.props.log.usuario.nombre}</div>: <div>no se lo que hago</div>}</h1> */}

        {this.props.log.title  ? (<Button onClick={this.logOutEvent}> Log Out</Button>) : (<Button onClick={this.logInEvent}>Log In</Button>) }
          <h4></h4>
      </div>
    );
    
  }
  
}

//logger container

const mapStateToProps = state => ({
  log: state.log,
  clientModel: state.clientModel
  
});

const mapDispatchToProps = {
  logIn,
  logOut,
  client,
  
};

const LogUserContainer = connect(
  mapStateToProps,
  mapDispatchToProps
)(LogUser);

export default LogUserContainer;