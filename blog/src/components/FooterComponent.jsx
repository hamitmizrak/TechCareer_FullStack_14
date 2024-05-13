// rcc

import { Component } from "react";
import { withTranslation } from "react-i18next";

// CLASS COMPONENT FOOTER
class FooterComponent extends Component {
  // Constructor
  constructor(
    props
  ) {
    super(props);

    // STATE
    this.state = {};

    // BIND
    // this.methodAdi=this.methodAdi.bind(this);
  }

  // CDM

  // Method

  render() {
    return (
      <div>Footer</div>
    );
  }
} //end class Footer

// EXPORT
export default withTranslation()(
  FooterComponent
);
