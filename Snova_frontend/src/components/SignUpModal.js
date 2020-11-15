
import React from 'react';
import { connect } from 'react-redux';
import { logIn, logOut, client, status_button } from 'redux/actions.js';
import LoginService from 'services/LoginService'
import { Button, Modal, ModalBody } from "reactstrap";




export class SignUpModal extends React.Component {
  constructor(props) {

    super(props);
    this.state = {
      client: [],
      status_button: false
    }
    this.userEmail = React.createRef();
    this.logInEvent = this.logInEvent.bind(this);
    this.logOutEvent = this.logOutEvent.bind(this);
  }


  async logInEvent() {
    let mail = this.userEmail.current.value;  //
    let loginData = { "email": mail }
    const logged = await LoginService.loginCheck(loginData)  // ejecuto query para validar email y recoger objeto cliente

    if ((logged.email !== null)) {
      this.props.status_button({ status_button: true })
      this.props.client({ client: logged });
      this.props.logIn({ title: mail })

    } else {
      this.props.status_button({ status_button: false })
      this.props.log.usuario = {};
      this.props.logIn({ title: 'Email not Found' })
    }



  }

  logOutEvent() {
    this.userEmail.current.value = ""
    this.props.logOut({ title: '' })
    this.props.status_button({ status_button: false });
  }


  render() {
    return (
      <>
        <Modal isOpen={this.props.isOpen} toggle={() => this.props.setIsOpen(false)}>
          <div className="modal-header justify-content-center">
            <h4 className="title title-up">Enter your registred Email</h4>
          </div>
          <ModalBody>
            <div className="justify-content-center">
              <input ref={this.userEmail} placeholder="Email..." type="email" ></input>
              <h3>{this.props.log.title || 'Not logged'}</h3>
             
            </div>
          </ModalBody>
          <div className="modal-footer">
                  {this.props.log.title ? (<Button onClick={this.logOutEvent}> Log Out</Button>) : (<Button onClick={this.logInEvent}>Log In</Button>)}
          </div>
        </Modal>
      </>

    );

  }

}

//logger container

const mapStateToProps = state => ({
  log: state.log,
  clientModel: state.clientModel,
  buttonCheck: state.buttonCheck,
  
});

const mapDispatchToProps = {
  logIn,
  logOut,
  client,
  status_button,
  
};

const LogUserContainer = connect(
  mapStateToProps,
  mapDispatchToProps
)(SignUpModal);

export default LogUserContainer;
