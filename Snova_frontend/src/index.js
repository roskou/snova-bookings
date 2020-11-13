import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";
// styles for this kit
import "assets/css/bootstrap.min.css";
import "assets/css/index.css"
import "assets/scss/now-ui-kit.scss?v=1.4.0";
import "assets/demo/demo.css?v=1.4.0";
import "assets/demo/nucleo-icons-page-styles.css?v=1.4.0";
// Views
import Index from "views/Index.js";
import FlatDetailView from "views/FlatDetailView.js";
import SearchView from "views/SearchView";
import ThankYouPage from "views/ThankYouPage";
// Redux Imports
import { Provider } from 'react-redux';
import { store } from 'redux/store.js';
ReactDOM.render(
  <Provider store={store}>
    <BrowserRouter>
      <Switch>
        <Switch>
          <Route
            path="/index"
            render={(props) => <Index {...props} />} />
          <Route
            path="/flatDetail/:id"
            render={(props) => <FlatDetailView {...props} />}
          />
          <Route
            path="/listByType/:tipo"
            render={(props) => <SearchView {...props} />}
          />
           <Route
            path="/thanks/"
            render={(props) => <ThankYouPage {...props} />}
          />
          <Redirect to="/index" />
          <Redirect from="/" to="/index" />
        </Switch>
      </Switch>
    </BrowserRouter>
  </Provider>,
  document.getElementById("root")
);





