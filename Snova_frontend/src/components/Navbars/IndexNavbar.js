import React from "react";
import { Link } from "react-router-dom";
import FlatService from 'services/FlatService.js';
import { connect } from 'react-redux'
// reactstrap components
import {
  // Button, 
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  UncontrolledDropdown,
  Collapse,
  NavbarBrand,
  Navbar,
  NavItem,
  NavLink,
  Nav,
  Container,
  UncontrolledTooltip,
} from "reactstrap";
import SignUpModal from "components/SignUpModal";
function IndexNavbar(props) {
  const [navbarColor, setNavbarColor] = React.useState(props.transparent);
  const [collapseOpen, setCollapseOpen] = React.useState(false);
  const [experiences, setExperiences] = React.useState([]);
  const [isOpen, setIsOpen] = React.useState(false);
  
  React.useEffect(() => {
    FlatService.getFlatTypes().then((res) => {
      setExperiences(res.data);
    });
    const updateNavbarColor = () => {
      if (
        document.documentElement.scrollTop > 299 ||
        document.body.scrollTop > 299
      ) {
        setNavbarColor("black");
      } else if (
        document.documentElement.scrollTop < 300 ||
        document.body.scrollTop < 300
      ) {
        setNavbarColor(props.transparent);
      }
    };
    window.addEventListener("scroll", updateNavbarColor);
    return function cleanup() {
      window.removeEventListener("scroll", updateNavbarColor);
    };
  }, []);

  console.log("PEPE" + props)
  return (
    <>
      {collapseOpen ? (
        <div
          id="bodyClick"
          onClick={() => {
            document.documentElement.classList.toggle("nav-open");
            setCollapseOpen(false);
          }}
        />
      ) : null}
      <Navbar className={"fixed-top " + navbarColor} expand="lg" color="default">
        <Container>
          <div className="navbar-translate">
            <NavbarBrand
              href="https://github.com/orgs/Z-devs/teams/z-code-team"
              target="_blank"
              id="navbar-brand"
            >
              <img src={require('assets/img/snova_logo.png')} alt="" />
            </NavbarBrand>
            <UncontrolledTooltip target="#navbar-brand">
              Designed by Taribo. Z coders Team
            </UncontrolledTooltip>
            <button
              className="navbar-toggler navbar-toggler"
              onClick={() => {
                document.documentElement.classList.toggle("nav-open");
                setCollapseOpen(!collapseOpen);
              }}
              aria-expanded={collapseOpen}
              type="button"
            >
              <span className="navbar-toggler-bar top-bar"></span>
              <span className="navbar-toggler-bar middle-bar"></span>
              <span className="navbar-toggler-bar bottom-bar"></span>
            </button>
          </div>
          <Collapse
            className="justify-content-end"
            isOpen={collapseOpen}
            navbar
          >
            <Nav navbar>
              <NavItem>
                <NavLink to="/index" tag={Link}>
                  <i className="now-ui-icons tech_tv"></i>
                  <p>Home</p>
                </NavLink>
              </NavItem>
              <UncontrolledDropdown nav>
                <DropdownToggle
                  caret
                  color="default"
                  href="#pablo"
                  nav
                  onClick={(e) => e.preventDefault()}
                >
                  <i className="now-ui-icons location_compass-05 mr-1"></i>
                  <p>Experiences</p>
                </DropdownToggle>
                {experiences.length > 0 && <DropdownMenu>
                  {experiences.map(e =>
                    <DropdownItem  to={"listByType/" + e.id} tag={Link}>
                      <i className="now-ui-icons objects_support-17 mr-1"></i>
                      {e.nombre}
                    </DropdownItem>
                  )}
                </DropdownMenu>}
              </UncontrolledDropdown>
              <NavItem>
                <NavLink
                  href="#pablo"
                  onClick={(e) => {
                    setIsOpen(true);
                    e.preventDefault();
                  }}
                >
                  {props.buttonCheck ? <i className=  "now-ui-icons emoticons_satisfied" style={{backgroundColor: "green"}} ></i> : <i className=  "now-ui-icons users_circle-08" style={{backgroundColor: "red"}} ></i>}
                    {props.buttonCheck ? <p>Logout</p> : <p>Login</p>}
                  <SignUpModal isOpen={isOpen} setIsOpen={setIsOpen}/>
                </NavLink>
              </NavItem>
            </Nav>
          </Collapse>
        </Container>
      </Navbar>
    </>
  );
}

const mapStateToProps = state => ({

  buttonCheck: state.buttonCheck.status_button,

})

export default connect(mapStateToProps)(IndexNavbar);

// style={{backgroundColor: this.props.log.title ? "green" : "red" }}