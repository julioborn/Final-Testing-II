import React, { useState } from 'react'
import { useEffect } from 'react';
import {useParams} from "react-router-dom";
import { useContextGlobal } from '../Components/utils/global.context';

const Detail = () => {
  const {state} = useContextGlobal();
  const [dentista,setDentista] = useState({});
  const param = useParams();

  useEffect(()=>{
    function fetchData(){
      fetch("https://jsonplaceholder.typicode.com/users/"+param.id)
      .then(resp=>resp.json())
      .then(data=>setDentista(data))
      .catch(err=>console.log(err));
    }
    fetchData();
  },[param.id])

  return (
    <>
      <h1 className={state.theme} style={{textAlign:"center", marginBottom:"15px", marginTop:"15px"}}>Información del Dentista {param.id}</h1>
      <table className={state.theme}>
        <thead>
          <th>Nombre</th>
          <th>Email</th>
          <th>Contacto</th>
          <th>Sitio Web</th>
          <th>Email</th>
        </thead>
        <tbody>
          <td>{dentista.name}</td>
          <td>{dentista.email}</td>
          <td>{dentista.phone}</td>
          <td>{dentista.website}</td>
          <td>{dentista.email}</td>
        </tbody>
      </table>
    </>
  )
}

export default Detail