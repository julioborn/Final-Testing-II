import React from 'react'
import Form from '../Components/Form'
import { useContextGlobal } from '../Components/utils/global.context'

const Contact = () => {
  const {state} = useContextGlobal();

  return (
    <div className={state.theme+" contacto"}>
      <h2>¿Necesitas más información?</h2>
      <p>Dejanos tu correo y nos contactaremos en la brevedad</p>
      <br />
      <Form/>
    </div>
  )
}

export default Contact