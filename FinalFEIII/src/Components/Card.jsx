import React from "react";
import Doctor from "../assets/doctor.jpg"
import { Link } from "react-router-dom"

const Card = ({ name, username, id }) => {
  const agregarAFavorito = () => {
    let dentist = {
      "name": name,
      "username": username,
      "id": id
    }
    let arrayDentist = localStorage.getItem("destacados") != null ? JSON.parse(localStorage.getItem("destacados")) : [];
    const existe = arrayDentist.some((e) => e.id === id)
    if (!existe) {
      arrayDentist.push(dentist);
      localStorage.setItem("destacados", JSON.stringify(arrayDentist));
    }else{
      alert("El dentista ya se encuentra en favoritos")
    }
  }

  return (
    <card className="card">
      <Link to={'/dentist/' + id}><img style={{ objectFit: "fill" }} src={Doctor} alt="imagen de doctor" /></Link>
      <Link to={'/dentist/' + id}><h4>{name}</h4></Link>
      <h5>{username}</h5>
      <button onClick={agregarAFavorito} className="favButton">Agregar a favorito</button>
    </card>
  );
};

export default Card;
