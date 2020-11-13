import React from "react";
import { Link } from "react-router-dom";
import FlatService from 'services/FlatService.js';
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
function IndexNavbar() {
  const [navbarColor, setNavbarColor] = React.useState("navbar-transparent");
  const [collapseOpen, setCollapseOpen] = React.useState(false);
  const [experiences, setExperiences] = React.useState([]);
  React.useEffect(() => {
    FlatService.getFlatTypes().then((res) => {
      console.log(res.data);
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
        setNavbarColor("navbar-transparent");
      }
    };
    window.addEventListener("scroll", updateNavbarColor);
    return function cleanup() {
      window.removeEventListener("scroll", updateNavbarColor);
    };
  }, []);
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
              <img src={require('assets/img/logo_small.png')} alt="" />
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
                      {/* <i className="now-ui-icons location_world mr-1"></i> */}
                      {/* <i className="now-ui-icons business_bank mr-1"></i>
                      <i className="now-ui-icons objects_spaceship mr-1"></i>
                      <i className="now-ui-icons objects_support-17 mr-1"></i> */}
                      {e.nombre}
                    </DropdownItem>
                  )}
                </DropdownMenu>}
              </UncontrolledDropdown>
              <NavItem>
                <NavLink
                  href="#pablo"
                  onClick={(e) => {
                    e.preventDefault();
                    document
                      .getElementById("download-section")
                      .scrollIntoView();
                  }}
                >
                  <i className="now-ui-icons users_circle-08"></i>
                  <p>Login</p>
                </NavLink>
              </NavItem>
            </Nav>
          </Collapse>
        </Container>
      </Navbar>
    </>
  );
}
export default IndexNavbar;