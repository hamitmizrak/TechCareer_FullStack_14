// rfce
import React from 'react'
import { withTranslation } from 'react-i18next'

// FUNCTION COMPONENT HEADER
function HeaderComponent(props) {
  return (
    <div>Header
      <i class={props.logo}></i>
    </div>
  )
}

// EXPORT
export default withTranslation()(HeaderComponent) 