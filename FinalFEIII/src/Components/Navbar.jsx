import React from 'react'
import { Link } from "react-router-dom";
import { useContextGlobal } from './utils/global.context';

const Navbar = () => {
  const { state, dispatch } = useContextGlobal();

  return (
    <nav className={state.theme} class="navbar">
      <h2>DH Odonto</h2>
      <div className={state.theme}>
        <div className={state.theme}>
          <Link to="/home"><h3>Inicio</h3></Link>
          <Link to="/contacto"><h3>Contacto</h3></Link>
          <Link to="/favs"><h3>Favoritos</h3></Link>
        </div>
        <button
          onClick={() =>
            state.theme === "" ?
              dispatch({ type: 'dark' }) :
              dispatch({ type: 'light' })
          }
          className={state.theme === "" ?
            "boton1" :
            "boton2"
          }
        >
          {state.theme === "" ? <>Dark 🌙</> : <>Light  ☀</>}
        </button>
      </div>
    </nav>
  )
}

export default Navbar