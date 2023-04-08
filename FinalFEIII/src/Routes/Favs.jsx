import React from "react";
import Card from "../Components/Card";
import { useContextGlobal } from "../Components/utils/global.context";

const Favs = () => {
  const { state } = useContextGlobal();
  const destacados = () => {
    return JSON.parse(localStorage.getItem("destacados"));
  }
  return (
    <>
      <h1 className="h1-favs">Dentistas Favoritos</h1>
      <button
        className="boton-eliminar"
        onClick={() => {
          localStorage.clear("destacados");
          alert("Favoritos eliminados")
        }}>
        Borrar todos los dentistas destacados
      </button>
      <br />
      <div className={"card-grid " + state.theme}>
        {destacados() != null ? destacados().map
          (e =>
            <Card
              name={e.name}
              username={e.username}
              id={e.id}
            />
          ) : null
        }
      </div>
    </>
  );
};

export default Favs;
