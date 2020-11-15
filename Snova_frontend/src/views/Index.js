import React from "react";

import IndexNavbar from "components/Navbars/IndexNavbar.js";
import DefaultFooter from "components/Footers/DefaultFooter.js";
import BasicSlider from '../components/Hero/BasicSlider/BasicSlider'
import FlatType from '../components/Flats/FlatType.js'
function Index() {
  React.useEffect(() => {
    document.body.classList.add("index-page");
    document.body.classList.add("sidebar-collapse");
    document.documentElement.classList.remove("nav-open");
    window.scrollTo(0, 0);
    document.body.scrollTop = 0;
    return function cleanup() {
      document.body.classList.remove("index-page");
      document.body.classList.remove("sidebar-collapse");
    };
  });
  return (
    <>
      <IndexNavbar transparent="navbar-transparent" />

      <BasicSlider />
      <div className="content">
        <FlatType />
      </div>
      <DefaultFooter />
    </>
  );
}
export default Index;
